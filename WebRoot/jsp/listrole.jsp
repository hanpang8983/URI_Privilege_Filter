<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>listrole.jsp</title>
  </head>
  
  <body>
    <br>
	<table align="center" width="60%">
		<tr>
			<td align="right"><a href="${pageContext.request.contextPath}/jsp/addrole.jsp">添加角色</a></td>
		<tr>
	</table>
	<table align="center" border="1px" cellspacing="0" width="60%">
		<tr>
			<th>角色名称</th>
			<th>描述</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${roles}" var="r">
			<tr>
				<td align="center">${r.name}</td>
				<td style="padding-left: 6px;">${r.description}</td>
				<td align="center">
					<a href="${pageContext.request.contextPath}/AddRolePrivilegesUIServlet?role_id=${r.id}">角色授权</a><br>
					<a href="#">修改角色</a><br>
					<a href="${pageContext.request.contextPath}/DeleteRoleServlet?role_id=${r.id}">删除角色</a>
				</td>
			</tr>
		</c:forEach>
	</table>
  </body>
</html>
