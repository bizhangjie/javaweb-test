package com.zj.javaweb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * @Author 章杰
 * @Date 2023/2/22 1:18
 * @Version 1.0.0
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String username = req.getParameter("username");
        Connection conn = null;
        PreparedStatement pstm = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/ZP?useSSL=false&serverTimezone=UTC";
            conn = DriverManager.getConnection(url,"root","123456");
            String sql = "SELECT * FROM `user` where name = '" + username + "'";
            System.out.println(sql);
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            String code = null;
            if(rs.next()){
                code = "200";
            }
            out.write("{\"code\":" + code + "}");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
