package com.fmc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fmc.model.User;
import com.fmc.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ycw on 2017/9/14 0014.
 */

@Controller
@RequestMapping("/user")

public class UserController {
    @Resource
    private IUserService userService;

    @RequestMapping("/showUser.do")
    public void selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        long userId = Long.parseLong(request.getParameter("id"));
        User user = userService.getUser(userId);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(user.getUsername());
        response.getWriter().write(mapper.writeValueAsString(user));
        response.getWriter().close();
    }

    @RequestMapping(value="/login.do",method= RequestMethod.POST)
    public String login(User user,Model model) throws Exception {
        //user=userService.checkLogin(user.getUsername(), user.getUserpwd());
        if(user!=null){
            //model.addAttribute(user);
            return "index";
        }
        return "/login/fail";
    }
}
