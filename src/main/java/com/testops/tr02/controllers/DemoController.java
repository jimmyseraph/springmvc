package com.testops.tr02.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Writer;

@Controller
public class DemoController {
    @RequestMapping("/demo")
    public void  showHello(HttpServletRequest request,HttpServletResponse response)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        Writer writer = response.getWriter();
        String content = "<!DOCTYPE html>\n" +
                "<html lang=\"zh-cn\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>欢迎学习Spring boot</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>你好</h1>\n" +
                "</body>\n" +
                "</html>";
        writer.write(content);
        writer.flush();
    }

    @RequestMapping(value = "/thymeleaf_demo", method = RequestMethod.GET)
    public String thymeleafDemo(
            @RequestParam(value = "name",required = false) String name,
            Model model
    ){
        if(name != null && !name.trim().equals("")){
            model.addAttribute("content",name);
        }else{
            model.addAttribute("content","World");
        }
        return "thdemo";
    }
}
