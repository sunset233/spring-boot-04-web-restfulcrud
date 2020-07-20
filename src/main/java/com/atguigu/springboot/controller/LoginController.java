package com.atguigu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @ Author: Sunset
 * @ Date: 2020/7/19 23:58
 * @ Version: 1.0
 */
@Controller
public class LoginController {
//    @DeleteMapping
//    @PutMapping
//    @GetMapping
    //@RequestMapping(value = "value = /user/login", method = RequestMethod.POST)
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            session.setAttribute("loginuser",username);
            return "redirect:/main.html";
        }
        else
        {
            map.put("msg","用户名密码错误");
            return "index";
        }
    }
}
