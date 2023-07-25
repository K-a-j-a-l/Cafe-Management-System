package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class M_ManageAccount {
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
	public boolean login(String managerId, String managerpwd) {
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="select Password from Manager where Manager_ID='"+managerId+"'";
			ResultSet rs=smt.executeQuery(sql);
			while(rs.next()) {
				String pwd=rs.getString("Password");
				if(pwd!="") {
					if(managerpwd.equals(pwd)) {
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
	public ResultSet checkFeedback() {
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="select Name, Feedback from Customer where Feedback!='"+null+"'";
			ResultSet rs=smt.executeQuery(sql);
			return rs;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public void removeFeedback() {
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="update Customer set Feedback='"+null+"' where Feedback!='"+null+"'";
			int a=smt.executeUpdate(sql);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public boolean editSettings(String newPassword, String managerId) {
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="update Manager set Password='"+newPassword+"' where Manager_ID='"+managerId+"'";
			int a=smt.executeUpdate(sql);
			return true;
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	public ResultSet checkRateService() {
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="select Rate, count(rate) as Count_Rate from Customer group by Rate";
			ResultSet rs=smt.executeQuery(sql);
			return rs;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
