<%--
  Created by IntelliJ IDEA.
  User: 章杰
  Date: 2023/2/19
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录</title>
  </head>

  <style>
    div{
      font-family: 宋体;
      text-align: center;
      background-color: red;
      color: red;
    }
  </style>
  <body>
  <div>
    <form onsubmit="return validateForm()" action="/test/logincheck" method="post" name="loginForm" >
      <table>
        <tr>
          <td>账号：</td>
          <td><input name="username" id="username" type="text"><span id="username-exists"></span></td>
        </tr>
        <tr>
          <td>密码：</td>
          <td><input name="password" type="password"></td>
        </tr>
        <tr>
          <td><input type="checkbox" name="auto" checked="checked">记住密码</td>
          <td><input type="submit" value="登录"></td>
        </tr>
        <tr>
          <td><a href="index.jsp">注册</a></td>
          <td><a href="index.jsp">忘记密码</a></td>
        </tr>
      </table>
    </form>
  </div>
11
  <script>
    function validateForm(){
      var username = document.loginForm.username.value;
      const password = document.loginForm.password.value;
      const auto = document.loginForm.auto.checked;
      console.log(username + " "+ password + "   " + auto)
      if (username == ""){
        alert("用户名为空")
        return false;
      }
      if (password == ""){
        alert("密码为空")
        return false;
      }
      if (auto == false){
        alert("必须勾选上自动登录")
        return false;
      }
      return true;
    }
  </script>

  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script>
    $(function (){
      console.log("进去");
      $("#username").blur(function (){
        var username = $(this).val();
        $.ajax({
          url:"user",
          type:"post",
          data:{"username":username},
          success:function (data){
            console.log(data)
            if (data.code){
              $("#username-exists").text("该用户名已存在！")
            }else {
              $("#username-exists").text("该用户名不存在！")
            }
          },
          error:function (data){
            console.log("获取失败")

          }
        })
      })
    })
  </script>
  </body>
</html>


<%--第一大题的第3小题--%>
<%--1、脚本语言。--%>
<%--JavaScript是一种解释型的脚本语言，C、C++等语言先编译后执行，而JavaScript是在程序的运行过程中逐行进行解释。--%>
<%--2、基于对象。--%>
<%--JavaScript是一种基于对象的脚本语言，它不仅可以创建对象，也能使用现有的对象。--%>
<%--3、简单。--%>
<%--JavaScript语言中采用的是弱类型的变量类型，对使用的数据类型未做出严格的要求，是基于Java基本语句和控制的脚本语言，其设计简单紧凑。--%>
<%--4、动态性。--%>
<%--JavaScript是一种采用事件驱动的脚本语言，它不需要经过Web服务器就可以对用户的输入做出响应。在访问一个网页时，鼠标在网页中进行鼠标点击或上下移、窗口移动等操作JavaScript都可直接对这些事件给出相应的响应。--%>
<%--5、跨平台性。--%>
<%--JavaScript脚本语言不依赖于操作系统，仅需要浏览器的支持。因此一个JavaScript脚本在编写后可以带到任意机器上使用，前提上机器上的浏览器支持JavaScript脚本语言，目前JavaScript已被大多数的浏览器所支持。--%>
