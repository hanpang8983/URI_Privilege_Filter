package cn.mengmei.web.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.mengmei.domain.Privilege;
import cn.mengmei.domain.User;
import cn.mengmei.web.service.SecurityService;

public class CheckPrivilegeFilter implements Filter {
	
	private Map<String,Privilege> map = new HashMap<String,Privilege>();
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		map.put("/myday19/manager/AddProductServlet", new Privilege("添加商品"));
		map.put("/myday19/manager/UpdateProductServlet", new Privilege("修改商品"));
		map.put("/myday19/manager/DeleteProductServlet", new Privilege("删除商品"));
		map.put("/myday19/manager/AddCategoryServlet", new Privilege("添加分类"));
		map.put("/myday19/manager/UpdateCategoryServlet", new Privilege("修改分类"));
		map.put("/myday19/manager/DeleteCategoryServlet", new Privilege("删除分类"));
		map.put("/myday19/manager/ShowOrderServlet", new Privilege("查看订单"));		
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		//得到用户请求的URI
		String uri = request.getRequestURI();
		
		//得到访问这个资源需要的权限
		Privilege p = map.get(uri);
		
		//判断得到的权限是否为空，为空则直接放行
		if(p==null){
			chain.doFilter(request, response);
		}
		
		//需要权限，则检查用户是否已经登录，如果没有登录，先让用户登录
		User user = (User) request.getSession().getAttribute("user");
		if(user==null){
			request.setAttribute("message", "对不起，您还没有登录，请登录后再来!");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		//如果用户已经登录，得到用户拥有的所有权限
		SecurityService service = new SecurityService();
		Set<Privilege> set = service.getUserAllPrivilege(user.getId());
		
		//判断用户所拥有的权限中，是否含有访问该资源需要的权限
		if(!set.contains(p)){
			request.setAttribute("message", "对不起，您没有权限访问该资源，请联系管理员!");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		//有权限，放行!
		chain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {

		
	}

}
