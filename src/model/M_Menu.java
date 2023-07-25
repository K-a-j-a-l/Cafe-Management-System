package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class M_Menu {
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
	public ResultSet displaySnacks() {
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="select Item_Name From Menu where Category='"+"Snacks"+"' and Qunatity>0";
			ResultSet rs=smt.executeQuery(sql);
			return rs;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public ResultSet displayJunkFood() {
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="select Item_Name From Menu where Category='"+"Junk Food"+"' and Qunatity>0";
			ResultSet rs=smt.executeQuery(sql);
			return rs;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public ResultSet displayMeal() {
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="select Item_Name From Menu where Category='"+"Meal"+"' and Qunatity>0";
			ResultSet rs=smt.executeQuery(sql);
			return rs;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public ResultSet displayDessert() {
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="select Item_Name From Menu where Category='"+"Dessert"+"' and Qunatity>0";
			ResultSet rs=smt.executeQuery(sql);
			return rs;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public ResultSet displayJuice() {
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="select Item_Name From Menu where Category='"+"Juice"+"' and Qunatity>0";
			ResultSet rs=smt.executeQuery(sql);
			return rs;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public ResultSet displayShake() {
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="select Item_Name From Menu where Category='"+"Shake"+"' and Qunatity>0";
			ResultSet rs=smt.executeQuery(sql);
			return rs;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public ResultSet displayOthers() {
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="select Item_Name From Menu where Category='"+"Others"+"' and Qunatity>0";
			ResultSet rs=smt.executeQuery(sql);
			return rs;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public String displayPrice(String item) {
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="select Item_Price From Menu where Item_Name =upper('"+item+"') or Item_Name =lower('"+item+"')";
			ResultSet rs=smt.executeQuery(sql);
			String price="";
			while(rs.next()) {
				price=rs.getString("Item_Price");
			}
			return price;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public ResultSet SearchFood(String item) {
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="select Item_Name, Item_Price From Menu where Item_Name='"+item+"'";
			ResultSet rs=smt.executeQuery(sql);
			return rs;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public ResultSet SearchFood_List(String item) {
		if(item.equals("")) {
			return null;
		}
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="select Item_Name From Menu where Item_Name like '"+item+"%' and Quantity>0;";
			ResultSet rs=smt.executeQuery(sql);
			return rs;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public boolean AddMenuItem(String item_name, String item_price, int quantity , String category) {
		String item_id="";
		int item_Id_1=1;
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="select Item_ID from Menu Order by Item_ID desc limit 1";
			ResultSet rs=smt.executeQuery(sql);
			while(rs.next()) {
				item_id=rs.getString("Item_ID");
			}
			if(item_id.equals("")) {
				item_id="1";
			}
			else {
				item_Id_1=Integer.parseInt(item_id);
				item_Id_1++;
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="insert into Menu(Item_ID,Item_Name, Category, Quantity, Item_Price) values ('"+item_Id_1+"', '"+item_name+"', '"+category+"','"+quantity+"','"+item_price+"');";
			int x=smt.executeUpdate(sql);
			if(x==1) {
				return true;
			}			
		}catch(Exception e){
			System.out.println(e);
		}
		return false;
	}
	public boolean DeleteItem(String name) {
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="Delete from Menu where Item_Name='"+name+"'";
			int x=smt.executeUpdate(sql);
			if(x==1) {
				return true;
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
		return false;
	}
	public boolean UpdatePrice(String name, int price) {
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="Update menu set Item_Price= '"+price+"' where Name='"+name+"'";
			int x=smt.executeUpdate(sql);
			if(x==1) {
				return true;
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
		return false;
	}
	public ResultSet ViewMenu() {
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="select Item_Name, Category, Quantity, Item_Price From Menu'";
			ResultSet rs=smt.executeQuery(sql);
			return rs;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
}
