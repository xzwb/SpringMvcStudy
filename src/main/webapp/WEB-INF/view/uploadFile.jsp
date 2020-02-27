<%--
  Created by IntelliJ IDEA.
  User: xzwb
  Date: 2020/2/27
  Time: 下午1:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UploadFile</title>
</head>
<body>
<form method="post" action="saveFile" enctype="multipart/form-data">
    文件上传:<input type="file" name="upfile">
    <input type="submit" value="upload">
</form>
</body>
</html>
