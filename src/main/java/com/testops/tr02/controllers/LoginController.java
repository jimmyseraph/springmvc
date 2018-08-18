package com.testops.tr02.controllers;

import com.testops.tr02.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(
            @RequestParam(value = "username",required = false) String username,
            @RequestParam(value = "password",required = false) String password,
            HttpSession session,
            Model model
    ){
        if(username == null || username.trim().equals("")){
            model.addAttribute("result","用户名为空");
        }else if(password == null || password.trim().equals("")){
            model.addAttribute("result","密码为空");
        }else {
            if(loginService.doLogin(username,password)){
                model.addAttribute("result","欢迎您回来");
                session.setAttribute("isLogin",true);
                session.setAttribute("user",username);
            }else {
                model.addAttribute("result","用户名或密码错误");
            }
        }
        return "login";
    }
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
