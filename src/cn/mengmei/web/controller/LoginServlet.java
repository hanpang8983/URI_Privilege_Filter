package cn.mengmei.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.mengmei.domain.User;
import cn.mengmei.web.service.SecurityService;


public class LoginServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		SecurityService service = new SecurityService();
		User user = service.login(username, password);
		
		if(user!=null){
			request.getSession().setAttribute("user", user);
			request.setAttribute("message", user.getUsername()+"登录成功!");
		}else{
			request.setAttribute("message", "用户名或密码错误!");
		}
		
		String contextPath = request.getContextPath();
		response.setHeader("Refresh", "1;url="+contextPath+"/1.jsp");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
