package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
			String sql="select Item_Name From Menu where Category='Snack' and Quantity>0";
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
			String sql="select Item_Name From Menu where Category='JunkFood' and Quantity>0";
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
			String sql="select Item_Name From Menu where Category='Meal' and Quantity>0";
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
			String sql="select Item_Name From Menu where Category='Dessert' and Quantity>0";
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
			String sql="select Item_Name From Menu where Category='Juice' and Quantity>0";
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
			String sql="select Item_Name From Menu where Category='Shake' and Quantity>0";
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
			String sql="select Item_Name From Menu where Category='Other' and Quantity>0";
			ResultSet rs=smt.executeQuery(sql);
			return rs;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public int displayPrice(String item) {
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="select Item_Price From Menu where Item_Name ='"+item+"'";
			ResultSet rs=smt.executeQuery(sql);
			int price=0;
			while(rs.next()) {
				price=rs.getInt("Item_Price");
			}
			return price;
		}catch(Exception e) {
			System.out.println(e);
		}
		return 0;
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
	public boolean AddMenuItem(String item_name, int item_price, int quantity , String category) {
		int item_Id_1=1;
		try {
			Connection con=getConnection();
			Statement smt=con.createStatement();
			String sql="SELECT MAX(Item_ID) AS Item_ID FROM Menu";
			ResultSet rs=smt.executeQuery(sql);
			System.out.println(rs);
			while(rs.next()) {
				item_Id_1=rs.getInt("Item_ID");
				System.out.println(item_Id_1);
			}
			if(item_Id_1==0) {
				item_Id_1=1;
			}
			else {
				item_Id_1++;
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		try {
			Connection con=getConnection();
			String sql = "INSERT INTO Menu(Item_ID, Item_Name, Category, Quantity, Item_Price) VALUES (?, ?, ?, ?, ?)";
			System.out.println(item_Id_1);
			try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
		        // Set the parameter values
		        preparedStatement.setInt(1, item_Id_1);
		        preparedStatement.setString(2, item_name);
		        preparedStatement.setString(3, category);
		        preparedStatement.setInt(4, quantity);
		        preparedStatement.setInt(5, item_price);

		        // Execute the query
		        int i=preparedStatement.executeUpdate();
		        if(i==1) {
		        	return true;
		        }
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
			String sql="Update Menu set Item_Price= '"+price+"' where Item_Name='"+name+"'";
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
			String sql="select Item_Name, Category, Quantity, Item_Price From Menu";
			ResultSet rs=smt.executeQuery(sql);
			return rs;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
}

