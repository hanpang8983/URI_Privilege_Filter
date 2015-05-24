<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>addRolePrivileges.jsp</title>
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
    		<td>角色名称</td><td>${role.name}</td>
    	</tr>
    	<tr>
    		<td>当前角色拥有的权限</td>
    		<td>
    			<c:if test="${empty(role_privileges)}">
    				&nbsp;
    			</c:if>
    			<c:forEach items="${role_privileges}" var="r_p">
    				${r_p.name}<br>
    			</c:forEach>
    		</td>
    	</tr>
    	<tr>
    		<td>系统权限</td>
    		<td>
	    		<form action="${pageContext.request.contextPath}/AddRolePrivilegesServlet" method="post">
	    			<input type="hidden" name="role_id" value="${role.id}">
	    			<c:forEach items="${system_privileges}" var="s_p">
	    				<input type="checkbox" name="system_privilege_id" value="${s_p.id}">${s_p.name}<br>
	    			</c:forEach>
	    			<input type="submit" value="授权">
	    		</form>
    		</td>
    	</tr>
    </table>
  </body>
</html>
