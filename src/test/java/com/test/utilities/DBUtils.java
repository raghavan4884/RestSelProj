package com.test.utilities;

import java.sql.*;

public class DBUtils {
	public Connection con;
	public Statement st;
	public ResultSet rs;
	
	public void getResults(String sql)
	{
		try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con=DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=sa;user=sa;password=sa");
			st=con.createStatement();
			rs=st.executeQuery(sql);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public void updateResults(String sql)
	{
		try {
			
			Class.forName("com.microsoft.jdbc.SQLServerDriver");
			con=DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=saluser=sa;password=sa");
			st=con.createStatement();
			st.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
