<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>1.jsp</title>
  </head>
  
  <body>
  <br>
  <c:choose>
	  <c:when test="${!empty(user)}">
	  	欢迎您，${user.username}!  <a href="${pageContext.request.contextPath}/LogOutServlet">退出</a><br><br>
	  </c:when>
	  <c:otherwise>
	  	<a href="${pageContext.request.contextPath}/jsp/login.jsp">登录</a> <br><br>
	  </c:otherwise>
  </c:choose>
  
    <a href="${pageContext.request.contextPath}/manager/AddProductServlet">添加商品</a>
    <a href="${pageContext.request.contextPath}/manager/UpdateProductServlet">修改商品</a>
    <a href="${pageContext.request.contextPath}/manager/DeleteProductServlet">删除商品</a><br>
    <a href="${pageContext.request.contextPath}/manager/AddCategoryServlet">添加分类</a>
    <a href="${pageContext.request.contextPath}/manager/UpdateCategoryServlet">修改分类</a>
    <a href="${pageContext.request.contextPath}/manager/DeleteCategoryServlet">删除分类</a><br>
    <a href="${pageContext.request.contextPath}/manager/ShowOrderServlet">查看订单</a>
  </body>
</html>
