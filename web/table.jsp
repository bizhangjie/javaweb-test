<%--
  Created by IntelliJ IDEA.
  User: 章杰
  Date: 2023/2/19
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
<%--    第三大题第1小题--%>
    <div>
        <h1>欢迎光临：<font color="green" font-family="黑体">
            <%
                String username = request.getParameter("username");
                out.print(username);
            %>
        </font></h1>
    </div>

<%--第三大题第2小题--%>
<%--具有跨平台、业务代码分离、组件重用、继承Java Servlet功能和预编译等技术特点。--%>
<%--（1）一次编写，到处运行。由于JSP/Servlet都是基于Java的，所以它们也有Java语言的最大优点——平台无关性，也就是所谓的“一次编写，随处运行（WORA – Write Once, Run Anywhere）”。除了这个优点，JSP/Servlet的效率以及安全性也是相当惊人的。--%>
<%--（2）系统的多平台支持。基本上可以在所有平台上的任意环境中开发，在任意环境中进行系统部署，在任意环境中扩展。相比ASP/PHP的局限性是显而易见的。--%>
<%--（3）强大的可伸缩性。从只有一个小的Jar文件就可以运行Servlet/JSP，到由多台服务器进行集群和负载均衡，到多台Application进行事务处理，消息处理，一台服务器到无数台服务器，Java显示了一个巨大的生命力。--%>
<%--（4）多样化和功能强大的开发工具支持。这一点与ASP很像，Java已经有了许多非常优秀的开发工具，而且许多可以免费得到，并且其中许多已经可以顺利的运行于多种平台之下。--%>
</body>
</html>
