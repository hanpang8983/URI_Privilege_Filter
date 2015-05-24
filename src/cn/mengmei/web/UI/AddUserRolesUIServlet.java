package cn.mengmei.web.UI;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.mengmei.domain.Privilege;
import cn.mengmei.domain.Role;
import cn.mengmei.domain.User;
import cn.mengmei.web.service.SecurityService;


public class AddUserRolesUIServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			String user_id = request.getParameter("user_id");
			SecurityService service = new SecurityService();
			User user = service.findUser(user_id);
			
			List<Role> user_roles = service.getUserRoles(user_id);
			List<Role> system_roles = service.getAllRole();
			
			request.setAttribute("user", user);
			request.setAttribute("user_roles", user_roles);
			request.setAttribute("system_roles", system_roles);
			
			request.getRequestDispatcher("/jsp/addUserRoles.jsp").forward(request,response);
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
