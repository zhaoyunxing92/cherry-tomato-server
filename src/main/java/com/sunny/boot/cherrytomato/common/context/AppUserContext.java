package com.sunny.boot.cherrytomato.common.context;

import com.sunny.boot.cherrytomato.user.model.vo.AppUserVo;
import com.sunny.boot.cherrytomato.util.StringUtil;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author sunny
 * @class: com.sunny.boot.cherrytomato.common.context.AppUserContext
 * @date: 2018-06-08 16:12
 * @des:
 */
public class AppUserContext implements Serializable {
    private static final long serialVersionUID = -3040901576313484640L;
    private static AppUserVo appUser = new AppUserVo();

    /**
     * 设置appUservo
     *
     * @param user appuser
     */
    public static void setAppUser(AppUserVo user) {
        appUser = user;
    }

    /**
     * 用户id
     *
     * @return 用户id
     */
    public static Long userId() {
        Long id = appUser.getId();
        return Objects.isNull(id) ? 0 : id;
    }

    /**
     * 用户账号
     *
     * @return 用户账号
     */
    public static String userName() {
        String userName = appUser.getUsername();
        return StringUtils.isEmpty(userName) ? "" : userName;
    }
}
