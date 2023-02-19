package com.zj.javaweb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * @Author 章杰
 * @Date 2023/2/19 15:38
 * @Version 1.0.0
 */
@WebServlet("/vip")
public class VipServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String passwrod = req.getParameter("password");
        Connection conn = null;
        PreparedStatement pstm = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/ZP?useSSL=false&serverTimezone=UTC";
            conn = DriverManager.getConnection(url,"root","123456");
            String sql = "SELECT * FROM `permission` as p,`user` as u\n" +
                    "WHERE p.userID = u.id and p.major = 1 and u.name ='" + username + "' and u.passwrod = '"+passwrod+"'";
            System.out.println(sql);
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()){
                req.getRequestDispatcher("/VIP.jsp").forward(req,resp);
            }
            req.getRequestDispatcher("/custom.jsp").forward(req,resp);
        }catch (Exception e){
            e.printStackTrace();
        }

        // 第五大题第2小题
        // 首先，需要从数据库中把数据拿过来，即用stm.executeQuery(sql)来完成这一目标。
        // 其次，就是用setAttribute把数据放到request里面去。最后，调用getRequestDispatch函数，利用*.jsp来显示数据的输出工作。

        // 第五大题第3小题
        // 恶意SQL注入、存在拼串操作，繁琐。  使用PreparedStatement可有效防止，维护性提高

        // 第五大题第4小题
//        参考地址： https://blog.csdn.net/qq_34283987/article/details/78122149
//        开发过程中的两种模型
//                model1= jsp + javabean (已被淘汰)
//        model2 = jsp + javabean + servlet
//        model2模型更符合MVC设计模式，符合OCP原则，符合高内聚，低耦合的设计。
//        MVC设计模式
//                盖一个楼
//        架构模式(考虑整体 一栋楼的整体轮廓 架子 如何搭起来 考虑宏观)
//        设计模式(考虑局部)
//        1.户型如何设计(两室一厅、三室一厅) 2.暖气管道怎么布置 3.墙体保温层如何设计
//        一.M Model 模型
//                javabean
//        (1)业务模型 Service+Dao
//                (2)数据模型 VO
//        二.V View 视图
//        JSP 向客户端显示信息
//        三.C Controller 控制器 Servlet
//        1.填充数据
//        2.调用业务逻辑
//        3.转发视图jsp model2=jsp(V)+javabean(M)+servlet(C)
//        三层架构
//                三层架构
//        持久层:DAO+VO(实体类) 功能把数据持久化(保存)到数据库
//        业务层:Service
//        表现层:Controller + JSP
    }
}
