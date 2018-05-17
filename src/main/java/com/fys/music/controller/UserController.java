package com.fys.music.controller;

import com.fys.music.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户填写注册信息页面
     * @return
     */
    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    /**
     * 用户注册处理
     */
    @RequestMapping("/registerDeal")
    public void registerDeal(HttpServletRequest req, HttpServletResponse resp) {
        PrintWriter print = null;
        try {
            print = resp.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");
        String email = req.getParameter("email");
        String sex = req.getParameter("sex");
        Integer age = Integer.parseInt(req.getParameter("age"));
        String birthday = req.getParameter("birthday");
        String hobby = req.getParameter("hobby");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String ret = userService.registerDeal(username, password, password2, email, sex, age, birthday, hobby, phone, address);
        print.write(ret);
    }


    /**
     * 激活邮箱1
     */

    @RequestMapping("/mailConf")
    public String mailConf(HttpServletRequest req, HttpServletResponse resp) {
        String url = req.getParameter("url");
        userService.mailConf(url);
        return "/login";
    }


    /**
     * 用户登陆页面
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 登陆处理
     */
    @RequestMapping("/loginDeal")
    public void loginDeal(HttpServletRequest req, HttpServletResponse resp) {
        PrintWriter out = null;
        try {
            out = resp.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String ret = userService.loginDeal(username, password);
        if (ret.equals("loginSuccess")) {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("username", username);
            out.write("loginSuccess");
        } else {
            out.write(ret);
        }
    }

    /**
     * 退出
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest httpServletRequest, String username, String password) {
        HttpSession httpSession = httpServletRequest.getSession();
        httpSession.invalidate();
        return "redirect:/";
    }


    /**
     * 找回密码页面
     */
    @RequestMapping("/forgetPassword")
    public String forgetPassword() {
        return "forgetpassword";
    }

    /**
     * 找回密码处理
     */
    @RequestMapping("/forgetPasswordDeal")
    public void forgetPasswordDeal(HttpServletRequest req, HttpServletResponse resp) {
        PrintWriter out = null;
        try {
            out = resp.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String email = req.getParameter("email");
        if(null != userService.selectMailIsExist(email)) {
            userService.forgetPasswordDeal(email);
            out.print("success");
        } else {
            out.print("emailIsNotRegister");
        }

    }

    /**
     * 检查找回密码的validateCode是否正确
     */
    @RequestMapping("/resetPassword")
    public String checkValidateCode(HttpServletRequest req, HttpServletResponse resp) {
        String validateCode = req.getParameter("validateCode");
        String email = req.getParameter("email");
        String ret = userService.checkValidateCode(validateCode, email);
        if(ret.equals("resetpage")) {
            req.setAttribute("email", email);
            return ret;
        } else {
            return ret;
        }
    }

    /**
     * 修改密码
     */
    @RequestMapping("/updatePassword")
    public void updatePassword(HttpServletRequest req, HttpServletResponse resp) {
        PrintWriter out = null;
        try {
            out = resp.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");
        out.print(userService.updatePassword(username, password, password2, email));
    }
}
