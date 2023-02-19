package com.zj.javaweb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录servlet
 *
 * @Author 章杰
 * @Date 2023/2/19 14:27
 * @Version 1.0.0
 */

// 第二大题第2小题第a个小问
// 注解配置
//@WebServlet("/logincheck")

//请求地址   http://localhost:8080/test/logincheck

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        // 第二大题第1小题
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("user: " + username + "  password: " + password);
        if ("zc".equals(username) && "1234".equals(password)){
            System.out.println("登录成功！");
            out.write("<h1>欢迎光临<font color=\"red\">" +username+ "</font></h1>");
//            req.getRequestDispatcher("main.jsp");
        }

//        resp.sendRedirect("login.jsp");
        // 第四大题第二小题
//        request.getRequestDispatcher()是请求转发，前后页面共享一个request ; 这个是在服务端运行的，对浏览器来说是透明的。
//        response.sendRedirect()是重新定向，前后页面不是一个request。而这个是在浏览器端运行的。

//        第四大题第3小题
//        1.page指当前页面。只在一个jsp页面里有效 。
//        2.request 指从http请求到服务器处理结束，返回响应的整个过程。在这个过程中使用forward方式跳转多个jsp。在这些页面里你都可以使用这个变量。
//        3.Session 有效范围当前会话，从浏览器打开到浏览器关闭这个过程。
//        4.application它的有效范围是整个应用。
//        参考 https://blog.csdn.net/frankaqi/article/details/49535207

        // 跳转到第五大题
        req.getRequestDispatcher("/vip").forward(req,resp);
    }
}
