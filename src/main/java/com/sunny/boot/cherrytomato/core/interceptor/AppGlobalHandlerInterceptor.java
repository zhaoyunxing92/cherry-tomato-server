package com.sunny.boot.cherrytomato.core.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.sunny.boot.cherrytomato.common.context.AppUserContext;
import com.sunny.boot.cherrytomato.common.result.Response;
import com.sunny.boot.cherrytomato.core.config.AppSpringBeanAware;
import com.sunny.boot.cherrytomato.core.config.HttpRequestTwiceReadingWrapper;
import com.sunny.boot.cherrytomato.user.model.vo.AppUserVo;
import com.sunny.boot.cherrytomato.user.service.AppUserAuthService;
import com.sunny.boot.cherrytomato.util.CookieUtil;
import com.sunny.boot.cherrytomato.util.EnvUtil;
import com.sunny.boot.cherrytomato.util.Md5Util;
import com.sunny.boot.cherrytomato.util.StringUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.parser.Entity;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

/**
 * @author sunny
 * @class: com.sunny.boot.cherrytomato.core.interceptor.AppGlobalHandlerInterceptor
 * @date: 2018-06-08 13:54
 * @des: 全局拦截器
 */
public class AppGlobalHandlerInterceptor implements HandlerInterceptor {
    //private static final String[] EXCLUDES = {"/swagger-resources", "/configuration/security", "/v2/api-docs", "/configuration/ui", "/auth/login", "/error"};
    private static final String[] EXCLUDES = {"/auth/login", "/auth/reg", "/error"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //OPTIONS
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return true;
        }

        //是否拦截path 401状态
        if (isInterceptorPath(request)) {
            responseMsg(response, HttpServletResponse.SC_UNAUTHORIZED, Response.Result.NOT_LOGIN_ERROR);
            return false;
        }
        //参数签名校验 403状态
        if (!signatureValidation(request)) {
            responseMsg(response, HttpServletResponse.SC_FORBIDDEN, Response.Result.SIGNATURE_VALIDATION_ERROR);
            return false;
        } else {
            return true;
        }
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

    /**
     * 是否拦截path ,默认都拦截
     *
     * @param request 请求路径
     * @return 返回是true/false
     */
    private boolean isInterceptorPath(HttpServletRequest request) {
        String path = request.getServletPath();
        //排除公共地址
        if (Arrays.asList(EXCLUDES).contains(path)) {
            return false;
        }
        //获取token,null和"" 拦截
        String token = getToken(request);
        if (StringUtils.isEmpty(token))
            return true;

        //redis 获取用户信息
        RedisTemplate<String, Object> redisTemplate = (RedisTemplate<String, Object>) AppSpringBeanAware.getBean("redisTemplate");
        AppUserVo                     appUser       = (AppUserVo) redisTemplate.opsForValue().get(token);
        if (null == appUser)
            return true;
        // 初始化用户环境信息
        AppUserContext.setAppUser(appUser);
        return false;
    }

    /**
     * 获取token 先头获取没有在cookie获取
     *
     * @param request
     * @return
     */
    private String getToken(HttpServletRequest request) {
        String key   = AppUserAuthService.tokenKey;
        String token = request.getHeader(key);
        if (StringUtils.isEmpty(token)) {
            token = Objects.requireNonNull(CookieUtil.getCookie(request, key)).getValue();
        }
        return token;
    }

    /**
     * 参数签名校验, 参数排序md5，跟客户端签名对比
     *
     * @return
     */
    private boolean signatureValidation(HttpServletRequest req) throws IOException {
        //开发环境跳过签名校验
        if (EnvUtil.isDev()) {
            return true;
        }
        //        //忽略校验路径
        //        if ("/error".equals(req.getServletPath())) {
        //            return true;
        //        }

        String sign = req.getHeader("sign");
        return !StringUtil.equals(sign, signature(req));
    }

    /**
     * 参数签名参数排序md5；
     *
     * @param request
     * @return
     */
    private String signature(HttpServletRequest request) throws IOException {
        String contentType = request.getContentType();
        String method      = request.getMethod();
        String str;
        /**
         * 不是get请求并且头是【application/json】流读取参数
         */
        if (!"get".equalsIgnoreCase(method) && contentType.startsWith("application/json")) {
            str = getParameterTOInputStream(request);
        } else {
            str = getParameter(request);
        }
        return Md5Util.encrypt(str);
    }

    /**
     * 从流读取参数
     *
     * @param request
     * @return
     */
    private String getParameterTOInputStream(HttpServletRequest request) throws IOException {
        String string = new HttpRequestTwiceReadingWrapper(request).getBodyString(request);

        if (StringUtils.isEmpty(string)) {
            return "{}";
        }
        StringBuffer sb = new StringBuffer();
        //转json
        JSONObject json = JSONObject.parseObject(string);
        sb.setLength(0);
        Set<String> keySet = json.keySet();
        String[]    keys   = keySet.toArray(new String[keySet.size()]);
        Arrays.sort(keys);
        for (String key : keys) {
            if (key.equals("sign")) {
                continue;
            }
            String value = json.getString(key);
            if (!StringUtils.isEmpty(value)) {// 参数值为空，则不参与签名
                sb.append(key).append("=").append(value).append("&");
            }
        }
        String str = sb.toString();
        if (StringUtils.isEmpty(str)) {
            return "{}";
        }
        return str.substring(0, str.lastIndexOf("&"));
    }

    private static String getBodyData(HttpServletRequest request) throws IOException {
        StringBuffer   data = new StringBuffer();
        String         line;
        BufferedReader reader;
        reader = request.getReader();
        while (null != (line = reader.readLine()))
            data.append(line);
        return data.toString();
    }

    /**
     * 获取签名,参数不支持二级数据，就是key不能相同
     *
     * @param req
     * @return
     */
    private String getParameter(HttpServletRequest req) {
        //Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> keySet = req.getParameterMap().keySet();
        String[]    keys   = keySet.toArray(new String[keySet.size()]);
        Arrays.sort(keys);

        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            if (key.equals("sign")) {
                continue;
            }
            String value = req.getParameter(key);
            if (!StringUtils.isEmpty(value)) {// 参数值为空，则不参与签名
                sb.append(key).append("=").append(value).append("&");
            }
        }
        // 解决空字符串问题
        String str = sb.toString();
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        return str.substring(0, str.lastIndexOf("&"));
    }

    /**
     * 统一返设置
     *
     * @param response
     * @param code     状态码
     * @param result
     */
    private void responseMsg(HttpServletResponse response, int code, Response.Result result) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(code);
        response.getWriter().write(result.toString());
    }
}
