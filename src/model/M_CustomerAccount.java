package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class M_CustomerAccount {
	
	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "admin");
			return con;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
		
	}
	public boolean createAccount(String customerName, String customerId, String password) {
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="insert into Customer(Customer_ID, Name, Password) values('"+customerId+"','"+customerName+"','"+password+"');";
			int a=smt.executeUpdate(sql);
			if(a==1) {
				return true;			
			}
			return false;
		}
		catch(Exception e) {
			System.out.println(e);
			return false;
		}
		
	}
	
	public boolean checkAccount(String customerId) {
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="select Customer_ID from Customer where Customer_ID='"+customerId+"'";
			ResultSet rs=smt.executeQuery(sql);
			while(rs.next()) {
				String id=rs.getString("Customer_ID");
				return true;
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	public boolean login(String customerId, String password) {
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="select Customer_ID, Password from Customer where Customer_ID='"+customerId+"'";
			ResultSet rs=smt.executeQuery(sql);
			while(rs.next()) {
				String id=rs.getString("Customer_ID");
				String pwd=rs.getString("Password");
				if(id!="" && pwd!="") {
					if(customerId.equals(id) && password.equals(pwd)) {
						return true;
					}
					return false;
				}
			}
					
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	public boolean giveFeedback(String feedback,  String customerId) {
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="Update Customer set Feedback='"+feedback+"'where Customer_ID='"+customerId+"'";
			int a=smt.executeUpdate(sql);
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	public boolean editSettings(String newPassword, String customerId) {
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="update Customer set Password='"+newPassword+"' where Customer_ID='"+customerId+"'";
			int a=smt.executeUpdate(sql);
			return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	

}
