<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>listuser.jsp</title>
  </head>
  
  <body>
    <br>
	<table align="center" width="60%">
		<tr>
			<td align="right"><a href="${pageContext.request.contextPath}/jsp/adduser.jsp">添加用户</a></td>
		<tr>
	</table>
	<table align="center" border="1px" cellspacing="0" width="60%">
		<tr>
			<th>用户名</th>
			<th>密码</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${users}" var="u">
			<tr>
				<td align="center">${u.username}</td>
				<td style="padding-left: 6px;">${u.password}</td>
				<td align="center">
					<a href="${pageContext.request.contextPath}/AddUserRolesUIServlet?user_id=${u.id}">用户授权</a><br>
					<a href="#">修改用户</a><br>
					<a href="${pageContext.request.contextPath}/DeleteUserServlet?user_id=${u.id}">删除用户</a>
				</td>
			</tr>
		</c:forEach>
	</table>
  </body>
</html>
