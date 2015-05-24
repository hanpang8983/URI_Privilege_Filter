package cn.mengmei.web.UI;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.mengmei.domain.Privilege;
import cn.mengmei.domain.Role;
import cn.mengmei.web.service.SecurityService;


public class AddRolePrivilegesUIServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			String role_id = request.getParameter("role_id");
			SecurityService service = new SecurityService();
			Role role = service.findRole(role_id);
			
			List<Privilege> role_privileges = service.getRolePrivileges(role_id);
			List<Privilege> system_privileges = service.getAllPrivilege();
			
			request.setAttribute("role", role);
			request.setAttribute("role_privileges", role_privileges);
			request.setAttribute("system_privileges", system_privileges);
			
			request.getRequestDispatcher("/jsp/addRolePrivileges.jsp").forward(request,response);
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
