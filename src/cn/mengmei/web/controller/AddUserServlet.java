package cn.mengmei.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.mengmei.domain.User;
import cn.mengmei.utils.WebUtils;
import cn.mengmei.web.service.SecurityService;


public class AddUserServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			if(username!=null && !username.trim().equals("") && password!=null && !password.trim().equals("")){
				User user  = new User();
				user.setId(WebUtils.makeID());
				user.setUsername(username);
				user.setPassword(password);
				
				SecurityService service = new SecurityService();
				service.addUser(user);
				request.setAttribute("message", "添加成功!");
			}else{
				request.setAttribute("message", "用户名和密码不能为空!");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "对不起，添加用户失败，请稍后再试!");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
