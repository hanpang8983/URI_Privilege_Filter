package cn.mengmei.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.mengmei.domain.Privilege;
import cn.mengmei.utils.WebUtils;
import cn.mengmei.web.service.SecurityService;


public class AddPrivilegeServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			if(name!=null && !name.trim().equals("")){
				Privilege p = new Privilege();
				p.setId(WebUtils.makeID());
				p.setName(name);
				p.setDescription(description);
				
				SecurityService service = new SecurityService();
				service.addPrivilege(p);
				
				request.setAttribute("message", "添加成功!");
			}else{
				request.setAttribute("message", "权限名称不能为空!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "对不起，添加失败，请稍后再试!");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
