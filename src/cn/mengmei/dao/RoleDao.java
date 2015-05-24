package cn.mengmei.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.mengmei.domain.Privilege;
import cn.mengmei.domain.Role;
import cn.mengmei.utils.JdbcUtils;

public class RoleDao {
	
	public void add(Role role){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into role(id,name,description) values(?,?,?)";
			Object[] params = {role.getId(), role.getName(), role.getDescription()};
			qr.update(sql, params);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public void delete(String id){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "delete from role_privilege where role_id=?";
			qr.update(sql, id);
			sql = "delete from role where id=?";
			qr.update(sql, id);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	
	@SuppressWarnings("deprecation")
	public Role find(String id){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from role where id=?";
			return (Role) qr.query(sql, id, new BeanHandler(Role.class));
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Role> getAll(){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from role";
			return (List<Role>) qr.query(sql, new BeanListHandler(Role.class));
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Privilege> getRolePrivileges(String role_id){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select p.* from role_privilege rp,privilege p where role_id=? and p.id=rp.privilege_id";
			return (List<Privilege>) qr.query(sql, role_id, new BeanListHandler(Privilege.class));
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
		
	public void updateRolePrivilege(Role role, List<Privilege> privileges){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "delete from role_privilege where role_id=?";
			qr.update(sql, role.getId());
			
			sql = "insert into role_privilege(role_id,privilege_id) values(?,?)";
			for(int i=0; privileges!=null && i<privileges.size(); i++){
				Object[] params = {role.getId(), privileges.get(i).getId()};
				qr.update(sql, params);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
