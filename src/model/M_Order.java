package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
			System.out.print(rs);
			return rs;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public int OrderFood(String customerId, String bill) {
		
		int order_id=0;
		int totalBill=Integer.parseInt(bill);
		int rec_time=5;
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
		String orderTime=sdf.format(cal.getTime());
		System.out.println(orderTime);
		String orderStatus="Pending";
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="SELECT MAX(Order_ID) AS Order_ID FROM Orders";
			ResultSet rs=smt.executeQuery(sql);
			System.out.println(rs);
			while(rs.next()) {
				order_id=rs.getInt("Order_ID");
				System.out.println(order_id);
			}
			if(order_id==0) {
				order_id=101;
			}
			else {
				order_id++;
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		try {
			Connection con=getConnection();
			String sql = "INSERT INTO Orders(Order_ID, Bill, ORDERING_TIME, RECEIVING_TIME, CUSTOMER_ID, ORDER_STATUS) VALUES (?, ?, ?, ?, ?, ?)";
			System.out.println(order_id);
			try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
		        // Set the parameter values
		        preparedStatement.setInt(1, order_id);
		        preparedStatement.setInt(2, totalBill);
		        preparedStatement.setString(3, orderTime);
		        preparedStatement.setInt(4, rec_time);
		        preparedStatement.setString(5, customerId);
		        preparedStatement.setString(6, orderStatus);
		        // Execute the query
		        int i=preparedStatement.executeUpdate();
		        if(i==1) {
		        	return order_id;
		        }
			}		
		}catch(Exception e){
			System.out.println(e);
		}
		return order_id;
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
