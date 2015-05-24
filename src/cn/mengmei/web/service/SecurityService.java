package cn.mengmei.web.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.mengmei.dao.PrivilegeDao;
import cn.mengmei.dao.RoleDao;
import cn.mengmei.dao.UserDao;
import cn.mengmei.domain.Privilege;
import cn.mengmei.domain.Role;
import cn.mengmei.domain.User;

//对web层提供所有权限相关的服务
public class SecurityService {
	
	private PrivilegeDao pDao = new PrivilegeDao();
	private RoleDao rDao = new RoleDao();
	private UserDao uDao = new UserDao();
	
	public void addPrivilege(Privilege p){
		pDao.add(p);
	}
	
	public void deletePrivilege(String id){
		pDao.delete(id);
	}
	
	public Privilege findPrivilege(String id){
		return pDao.find(id);
	}
	
	public List<Privilege> getAllPrivilege(){
		return pDao.getAll();
	}
	
	public void addRole(Role role){
		rDao.add(role);
	}
	
	public void deleteRole(String id){
		rDao.delete(id);
	}
	
	public Role findRole(String id){
		return rDao.find(id);
	}
	
	public List<Role> getAllRole(){
		return rDao.getAll();
	}
	
	public List<Privilege> getRolePrivileges(String role_id){
		return rDao.getRolePrivileges(role_id);
	}
	
	public void updateRolePrivilege(String role_id, String[] system_privilege_ids){
		
			Role role = rDao.find(role_id);
			
			List<Privilege> privileges = new ArrayList<Privilege>();
			
			for(int i=0; system_privilege_ids!=null && i<system_privilege_ids.length; i++){
				privileges.add(pDao.find(system_privilege_ids[i]));
			}
			
			rDao.updateRolePrivilege(role, privileges);
	}
	
	public void addUser(User user){
		uDao.add(user);
	}
	
	public void deleteUser(String id){
		uDao.delete(id);
	}
	
	public User findUser(String id){
		return uDao.find(id);
	}
	
	public User login(String username, String password) {
		User user = uDao.find(username, password);
		return user;
	}
	
	public List<User> getAllUser(){
		return uDao .getAll();
	}
	
	public List<Role> getUserRoles(String user_id){
		return uDao.getUserRoles(user_id);
	}
	
	public void updateUserRole(String user_id, String[] system_role_ids){
		
			User user = uDao.find(user_id);
			
			List<Role> roles = new ArrayList<Role>();
			
			for(int i=0; system_role_ids!=null && i<system_role_ids.length; i++){
				roles.add(rDao.find(system_role_ids[i]));
			}
			
			uDao.updateUserRole(user, roles);
	}

	public Set<Privilege> getUserAllPrivilege(String user_id) {
		List<Role> roles = uDao.getUserRoles(user_id);
		Set<Privilege> set = new HashSet(); 
		for(int i=0; roles!=null && i<roles.size(); i++){
			Role role = roles.get(i);
			List<Privilege> privileges = rDao.getRolePrivileges(role.getId());
			set.addAll(privileges);
		}
		return set;
	}
	
}
