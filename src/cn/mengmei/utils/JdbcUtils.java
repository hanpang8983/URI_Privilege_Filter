package cn.mengmei.utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	
	private static ComboPooledDataSource dataSource = null;
	
	static{
		dataSource = new ComboPooledDataSource("mysql");
	}
	
	public static ComboPooledDataSource getDataSource() {
		return dataSource;
	}
	
	//不处理事务不需要写这个方法
	/*public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}*/
}
