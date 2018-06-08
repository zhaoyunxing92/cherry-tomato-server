package com.sunny.boot.cherrytomato.controller;


import com.sunny.boot.cherrytomato.common.result.Response;
import com.sunny.boot.cherrytomato.common.valid.LoginGroup;
import com.sunny.boot.cherrytomato.controller.form.UserForm;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author sunny
 * @class: com.sunny.workflow.users.controller.AppUserController
 * @date: 2018-05-18 0:41
 * @des: 用户控制器
 */
@RestController
@RequestMapping("/user")
public class AppUserController {
  /**
   * 登录
   *
   * @param form
   * @return
   */
  @PostMapping("/login")

  public Response login(@RequestBody @Validated({LoginGroup.class}) UserForm form) {
//    List<Object> list = new ArrayList<>();
//    list.add(1);
//    list.add(new Date());
//    list.add("sunny2323");


    return new Response<UserForm>(Response.Result.SUCCESS, null);
    // return null;
  }
}
