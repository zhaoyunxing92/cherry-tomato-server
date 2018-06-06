package com.sunny.boot.cherrytomato.controller;


import com.sunny.boot.cherrytomato.common.result.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

  @GetMapping("/login")
  public Response<List<Object>> login() {
    List<Object> list = new ArrayList<>();
    list.add(1);
    list.add(new Date());
    list.add("sunny");


    return new Response<>(1, "登录成功", list);
  }
}
