package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class M__OrderList {
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
	public ResultSet ViewOrderList() {
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="select * From Orders where Order_Status='Pending'";
			ResultSet rs=smt.executeQuery(sql);
			System.out.println(rs);
			return rs;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public void ChangeOrderStatus(String value_orderId, int value_bill) {
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="update Orders set Order_Status='"+"Paid"+"' where Order_ID='"+value_orderId+"'";
			int a=smt.executeUpdate(sql);
		}catch(Exception e) {
			System.out.println(e);
		}
		int saleId=0;
		String id="";
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="select Sale_ID From Sale order by Order_ID desc limit 1";
			ResultSet rs=smt.executeQuery(sql);
			while(rs.next()) {
				id=rs.getString("Sale_ID");
			}
			if(id.equals("")) {
				saleId=10001;
			}
			else {
				saleId=Integer.parseInt(id);
				saleId++;
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="insert into Sale(Sale_ID,Order_ID, Sale) values('"+saleId+"', '"+value_orderId+"', '"+value_bill+"')";
			int a=smt.executeUpdate(sql);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public ResultSet viewOrderDetails() {
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="select Order_ID From Order_Details where Status='"+"Not Prepared"+"' Group by Order_ID";
			ResultSet rs=smt.executeQuery(sql);
			return rs;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public void changeOrderDetail_Status(String value_orderId) {
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="update Order_Details set Status='"+"Prepared"+"' where Order_ID='"+value_orderId+"'";
			int a=smt.executeUpdate(sql);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public void CancelOrder(String value_orderId, int value_bill) {
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="update Orders set Order_Status='"+"Cancel"+"' where Order_ID='"+value_orderId+"'";
			int a=smt.executeUpdate(sql);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public void UpdateQuantity(String value_orderId) {
		String[] name=new String[80];
		String[] quantity=new String[80];
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="select Item_Name, Quantity From Order_Details where Order_ID='"+value_orderId+"'";
			ResultSet rs=smt.executeQuery(sql);
			int i=0;
			while(rs.next()) {
				name[i]=rs.getString("Item_Name");
				quantity[i]=rs.getString("Quantity");
				i++;
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		for(int i=0;i<name.length; i++) {
			try {
				Connection con=getConnection();
				Statement smt=con.createStatement();
				String sql="update Menu set Quantity=Quantity-'"+quantity[i]+"' where Item_Name='"+name[i]+"'";
				int a=smt.executeUpdate(sql);
					
			}catch(Exception e) {
				System.out.println(e);
			}
		}
	}
	public ResultSet OrderItemDetails(String orderId) {
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="select Item_Name, Quantity From Order_Details where Order_ID='"+orderId+"'";
			ResultSet rs=smt.executeQuery(sql);
			return rs;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}


}
