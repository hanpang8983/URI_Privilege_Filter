package cn.mengmei.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.mengmei.domain.Role;
import cn.mengmei.utils.WebUtils;
import cn.mengmei.web.service.SecurityService;


public class AddRoleServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try{
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			if(name!=null && !name.trim().equals("")){
				Role role = new Role();
				role.setId(WebUtils.makeID());
				role.setName(name);
				role.setDescription(description);
				
				SecurityService service = new SecurityService();
				service.addRole(role);
				request.setAttribute("message", "添加成功!");
			}else{
				request.setAttribute("message", "角色名称不能为空!");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "对不起，添加角色失败，请稍后再试!");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
