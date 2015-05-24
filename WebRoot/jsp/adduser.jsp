<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>adduser.jsp</title>
  </head>
  
  <body>
    <form action="${pageContext.request.contextPath}/AddUserServlet" method="post">
		用户名：<input type="text" name="username"><br>
		密码：<input type="text" name="password"><br>
		<input type="submit" value="添加用户">
	</form>
  </body>
</html>
