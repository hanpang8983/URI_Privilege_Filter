<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>listprivilege.jsp</title>
  </head>
  
  <body>
  	<br>
	<table align="center" width="60%">
		<tr>
			<td align="right"><a href="${pageContext.request.contextPath}/jsp/addprivilege.jsp">添加权限</a></td>
		<tr>
	</table>
	<table align="center" border="1px" cellspacing="0" frame="border" width="60%">
		<tr>
			<th>权限名称</th>
			<th>描述</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${privileges}" var="p">
			<tr>
				<td align="center">${p.name}</td>
				<td style="padding-left: 6px;">${p.description}</td>
				<td align="center">
					<a href="#">修改权限</a><br>
					<a href="${pageContext.request.contextPath}/DeletePrivilegeServlet?privilege_id=${p.id}">删除权限</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
  </body>
</html>
