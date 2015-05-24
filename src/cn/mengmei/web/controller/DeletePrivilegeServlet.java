package cn.mengmei.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.mengmei.web.service.SecurityService;


public class DeletePrivilegeServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			String privilege_id = request.getParameter("privilege_id");
			SecurityService service = new SecurityService();
			service.deletePrivilege(privilege_id);
			request.getRequestDispatcher("/ListPrivilegeServlet").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "对不起，删除失败，请稍后再试!");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
