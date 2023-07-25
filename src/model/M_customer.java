package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class M_customer {
	
	public void rateService(String customerId, String rate) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "admin");
			Statement smt=con.createStatement();
			String sql="update customer set Rate='"+rate+"'where Customer_ID='"+customerId+"'";
			int a =smt.executeUpdate(sql);
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
