package jxnu.x3107.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 数据库连接
 * */

public class DBclass {
	private String url = "jdbc:sqlserver://localhost:1433;DatabaseName=shaiquanDB";
	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String userName = "sa";
	private String passWord = "sa";
	public Connection connection = null;
	public Statement statement = null;
	public ResultSet resultSet = null;

	public DBclass() {

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public int executeUpdate(String sql){
		int result = 0;

		try {
			connection = DriverManager.getConnection(url,userName,passWord);

			statement = connection.createStatement();

			result = statement.executeUpdate(sql);

			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public ResultSet executeQuery(String sql){

		try {
			connection = DriverManager.getConnection(url,userName,passWord);

			statement = connection.createStatement();

			resultSet = statement.executeQuery(sql);
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultSet;
	}

	
	public boolean coloseConnection(Connection connection){
		boolean bl = false;

		if (connection != null) {
			try {
				connection.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			bl = true;
		}else {
			bl = true;
		}

		return bl;
	}
}
