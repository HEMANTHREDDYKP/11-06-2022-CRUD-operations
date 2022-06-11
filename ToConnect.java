package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ToConnect {

	public  void addDynamically(Employee employee) {
		String url = "jdbc:mysql://localhost:3306/employees";

		String un = "root";
		String pa = "root";
		String sql="insert into employee values(?,?)";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection = DriverManager.getConnection(url, un, pa);
			
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, employee.getId());
			preparedStatement.setString(2, employee.getName());
			
			preparedStatement.execute();
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public  void toGet(int id) {
		String url = "jdbc:mysql://localhost:3306/employees";

		String un = "root";
		String pa = "root";
		String sql="select * from employee where id=?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection = DriverManager.getConnection(url, un, pa);
			
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
			}
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public  void toDelete(int id) {
		String url = "jdbc:mysql://localhost:3306/employees";

		String un = "root";
		String pa = "root";
		String sql="delete from employee where id=?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection = DriverManager.getConnection(url, un, pa);
			
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, id);
			
			preparedStatement.execute();
			
		 
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public  void toUpdate(int id,String name) {
		String url = "jdbc:mysql://localhost:3306/employees";

		String un = "root";
		String pa = "root";
		String sql="update employee set name=? where id=?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection = DriverManager.getConnection(url, un, pa);
			
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setInt(2, id);
			preparedStatement.setString(1, name);
			
			preparedStatement.execute();
			
		 
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
