package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class M_Employee {
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
	public boolean AddEmployee(String name, String contact, int age, String duty, int salary) {
		String Emp_ID="";
		int Emp_ID_1=1;
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="select Emp_ID from Employee Order by Emp_ID desc limit 1";
			ResultSet rs=smt.executeQuery(sql);
			while(rs.next()) {
				Emp_ID=rs.getString("Emp_ID");
			}
			if(Emp_ID.equals("")) {
				Emp_ID="1";
			}
			else {
				Emp_ID_1=Integer.parseInt(Emp_ID);
				Emp_ID_1++;
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="insert into Employee(Emp_ID, Name, Contact, Age, Duty, Salary) values ('"+Emp_ID_1+"', '"+name+"', '"+contact+"','"+age+"','"+duty+"','"+salary+"');";
			int x=smt.executeUpdate(sql);
			if(x==1) {
				return true;
			}			
		}catch(Exception e){
			System.out.println(e);
		}
		return false;
	}
	public boolean DeleteEmployee(String name) {
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="Delete from Employee where Name='"+name+"'";
			int x=smt.executeUpdate(sql);
			if(x==1) {
				return true;
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
		return false;
	}
	public boolean UpdateSalary(String name, int salary) {
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="Update Employee set Salary= '"+salary+"' where Name='"+name+"'";
			int x=smt.executeUpdate(sql);
			if(x==1) {
				return true;
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
		return false;
	}
	public boolean AssignDuty(String name, String duty) {
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="Update Employee set Duty='"+duty+"' where Name='"+name+"'";
			int x=smt.executeUpdate(sql);
			if(x==1) {
				return true;
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
		return false;
	}
	public ResultSet viewEmployee() {
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="select * from Employee";
			ResultSet rs=smt.executeQuery(sql);
			return rs;
			
		}catch(Exception e){
			System.out.println(e);
		}
		return null;
	}
}
