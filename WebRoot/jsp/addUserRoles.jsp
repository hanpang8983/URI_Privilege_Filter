<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>addUserRoles.jsp</title>
    <style type="text/css">
    	td{
    		padding-left: 6px;
    	}
    </style>
  </head>
  
  <body>
    <br>
    <table align="center" border="1px" cellspacing="0" width="60%">
    	<tr>
    		<td>用户名</td><td>${user.username}</td>
    	</tr>
    	<tr>
    		<td>当前用户拥有的角色</td>
    		<td>
    			<c:if test="${empty(user_roles)}">
    				&nbsp;
    			</c:if>
    			<c:forEach items="${user_roles}" var="u_r">
    				${u_r.name}<br>
    			</c:forEach>
    		</td>
    	</tr>
    	<tr>
    		<td>系统角色</td>
    		<td>
	    		<form action="${pageContext.request.contextPath}/AddUserRolesServlet" method="post">
	    			<input type="hidden" name="user_id" value="${user.id}">
	    			<c:forEach items="${system_roles}" var="s_r">
	    				<input type="checkbox" name="system_role_id" value="${s_r.id}">${s_r.name}<br>
	    			</c:forEach>
	    			<input type="submit" value="授权">
	    		</form>
    		</td>
    	</tr>
    </table>
  </body>
</html>
