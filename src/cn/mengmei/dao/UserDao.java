package cn.mengmei.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.mengmei.domain.Role;
import cn.mengmei.domain.User;
import cn.mengmei.utils.JdbcUtils;

public class UserDao {

	public void add(User user){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into user(id,username,password) values(?,?,?)";
			Object[] params = {user.getId(), user.getUsername(), user.getPassword()};
			qr.update(sql, params);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public void delete(String id){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "delete from user_role where user_id=?";
			qr.update(sql, id);
			sql = "delete from user where id=?";
			qr.update(sql, id);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	
	@SuppressWarnings("deprecation")
	public User find(String id){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from user where id=?";
			return (User) qr.query(sql, id, new BeanHandler(User.class));
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public User find(String username, String password) {
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from user where username=? and password=?";
			Object[] params = {username, password};
			return (User) qr.query(sql, params, new BeanHandler(User.class));
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAll(){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from user";
			return (List<User>) qr.query(sql, new BeanListHandler(User.class));
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Role> getUserRoles(String user_id){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select r.* from user_role u_r,role r where u_r.user_id=? and r.id=u_r.role_id";
			return (List<Role>) qr.query(sql, user_id, new BeanListHandler(Role.class));
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
		
	public void updateUserRole(User user, List<Role> roles){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "delete from user_role where user_id=?";
			qr.update(sql, user.getId());
			
			sql = "insert into user_role(user_id,role_id) values(?,?)";
			for(int i=0; roles!=null && i<roles.size(); i++){
				Object[] params = {user.getId(), roles.get(i).getId()};
				qr.update(sql, params);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

}
