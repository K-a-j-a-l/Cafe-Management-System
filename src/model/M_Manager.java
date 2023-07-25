package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class M_Manager {
	public ResultSet viewSales() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "admin");
			Statement smt=con.createStatement();
			String sql="select Sale from Sale";
			ResultSet rs =smt.executeQuery(sql);
			return rs;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
}
