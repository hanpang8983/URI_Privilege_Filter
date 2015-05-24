package cn.mengmei.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.mengmei.web.service.SecurityService;

public class AddUserRolesServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			String user_id = request.getParameter("user_id");
			String[] system_role_ids = request.getParameterValues("system_role_id");
			
			SecurityService service = new SecurityService();
			service.updateUserRole(user_id, system_role_ids);
			
			request.setAttribute("message", "授权成功!");
			
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "对不起，授权失败，请稍后再试!");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
