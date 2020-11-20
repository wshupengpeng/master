<%--
  Created by IntelliJ IDEA.
  User: HPP
  Date: 2020/10/29
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello spring sercuity !!!!</title>
</head>
<body>
    <form action="login" method="post">
        用户名:<input type="text" name="username"/><br/>
        密码：<input type="password" name="password"/><br/>
        <input type="submit" value="登录"/>
    </form>


    <form action="upload" method="post" enctype="multipart/form-data">
        <input type="file" name="upload"/>
        <input type="submit" value="登录"/>
    </form>

    <form action="download" method="post" >
        <input type="submit" value="点击下载"/>
    </form>

    <a href="download" methods="post" name="download">download</a>
    <a href="download" methods="get" name="download">getdownload</a>
</body>
</html>
