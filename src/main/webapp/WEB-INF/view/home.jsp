<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: xzwb
  Date: 2020/2/25
  Time: 下午4:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h1>欢迎来到不用web.xml配置</h1>
    <a href="<c:url value="/list"/>">List</a>
    <a href="<c:url value="/home/register"/>">Register</a>
</body>
</html>
