package com.sunny.boot.cherrytomato.user.controller;


import com.sunny.boot.cherrytomato.common.result.Response;
import com.sunny.boot.cherrytomato.user.controller.form.UserForm;
import com.sunny.boot.cherrytomato.user.controller.form.valid.LoginGroup;
import com.sunny.boot.cherrytomato.user.controller.form.valid.RegisterGroup;
import com.sunny.boot.cherrytomato.user.service.AppUserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sunny
 * @class: com.sunny.workflow.users.controller.AppUserController
 * @date: 2018-05-18 0:41
 * @des: 用户控制器
 */
@RestController
@RequestMapping("/auth")
public class AppUserController {

  @Autowired
  private AppUserAuthService appUserAuthService;

  /**
   * 登录
   *
   * @param form 用户名和密码
   * @return 登录成功返回用户信息
   */
  @PostMapping("/login")
  public Response login(HttpServletResponse res, @RequestBody @Validated({LoginGroup.class}) UserForm form) {
    return appUserAuthService.login(res, form.getUserName(), form.getPassword());
  }

  /**
   * 注册
   *
   * @param form 邮箱和密码
   * @return 登录成功返回用户信息
   */
  @PutMapping("/reg")
  public Response register(HttpServletResponse res, @RequestBody @Validated({RegisterGroup.class}) UserForm form) {
    return appUserAuthService.register(res, form);
  }
}
