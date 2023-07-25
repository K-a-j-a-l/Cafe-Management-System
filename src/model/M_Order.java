package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class M_Order {
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
	public ResultSet ViewBill(String customerid) {
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="select Order_ID, Bill, Ordering_Time, Receiving_Time From Orders where Customer_ID='"+customerid+"' and Order_Status='"+"Pending"+"'";
			ResultSet rs=smt.executeQuery(sql);
			return rs;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public String OrderFood(String customerId, String Bill) {
		String id="", orderId="";
		int id_1=0;
		String rec_time="5";
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
		String orderTime=sdf.format(cal.getTime());
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="select Order_ID From Orders order by Order_ID desc limit 1";
			ResultSet rs=smt.executeQuery(sql);
			while(rs.next()) {
				id=rs.getString("Order_ID");
			}
			if(id.equals("")) {
				orderId="1001";
			}
			else {
				id_1=Integer.parseInt(id);
				id_1++;
				orderId=Integer.toString(id_1);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		int TotalBill=Integer.parseInt(Bill);
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="insert into Orders(Order_ID, Bill, Ordering_Time, Receiving_Time, Customer_ID, Order_Status) values('"+orderId+"', '"+TotalBill+"', '"+orderTime+"', '"+rec_time+"', '"+customerId+"', '"+"Pending"+"')";
			int a=smt.executeUpdate(sql);
		}catch(Exception e) {
			System.out.println(e);
		}
		return orderId;
	}
	
	public void AddOrderDetails(String orderId, String[] array_itemName, String[] array_Quantity ) {
		String id="";
		int id_1=0;
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="select ID From Order_Details order by ID desc limit 1";
			ResultSet rs=smt.executeQuery(sql);
			while(rs.next()) {
				id=rs.getString("ID");
			}
			if(id.equals("")) {
				id="1";
			}
			else {
				id_1=Integer.parseInt(id);
				id_1++;
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		int i;
		for(i=0;i<array_itemName.length; i++) {
			try {
				if(array_itemName[i]==null) {
					
				}
				else {
					Connection con=getConnection();
					Statement smt=con.createStatement();
					String sql="insert into Order_Details(ID, Order_ID, Item_Name, Quantiy, Status) values('"+id+"','"+orderId+"', '"+array_itemName[i]+"', '"+array_Quantity[i]+"', '"+"Not Prepared"+"');";
					int a=smt.executeUpdate(sql);
				}
				
			}catch(Exception e) {
				System.out.println(e);
			}
			id_1++;
		}
		for(i=0;i<array_itemName.length; i++) {
			try {
				if(array_Quantity[i]==null) {
					
				}
				else {
					Connection con=getConnection();
					Statement smt=con.createStatement();
					String sql="Update Menu set Quantity='"+array_Quantity[i]+"'where Item_Name='"+array_itemName[i]+"';";
					int a=smt.executeUpdate(sql);
				}
				
			}catch(Exception e) {
				System.out.println(e);
			}
		}
	}
}
