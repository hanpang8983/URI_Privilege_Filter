package cn.mengmei.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.mengmei.domain.Privilege;
import cn.mengmei.web.service.SecurityService;


public class AddRolePrivilegesServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try{
			String role_id = request.getParameter("role_id");
			String[] system_privilege_ids = request.getParameterValues("system_privilege_id");
			
			SecurityService service = new SecurityService();
			service.updateRolePrivilege(role_id, system_privilege_ids);
			
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
