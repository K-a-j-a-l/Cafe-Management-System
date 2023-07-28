package controller;

import java.sql.ResultSet;

import model.M_Menu;

public class C_Menu {
	M_Menu obj_M_Menu=new M_Menu();
	public ResultSet SearchFoodList(String item_name) {
		ResultSet rs=obj_M_Menu.SearchFood_List(item_name);
		return rs;
	}
	public boolean AddMenuItem(String item_name, int item_price, int quantity, String category) {
		boolean result=obj_M_Menu.AddMenuItem(item_name, item_price, quantity, category);
		if(result==true) {
			return true;
		}
		return false;
	}
	public boolean DeleteMenuItem(String item_name) {
		boolean result=obj_M_Menu.DeleteItem(item_name);
		if(result==true) {
			return true;
		}
		return false;
	}
	public boolean UpdatePrice(String item_name, int item_price) {
		boolean result=obj_M_Menu.UpdatePrice(item_name, item_price);
		if(result==true) {
			return true;
		}
		return false;
	}
	public ResultSet DisplaySnacks() {
		ResultSet rs=obj_M_Menu.displaySnacks();
		return rs;
	}
	public ResultSet DisplayJunkFood() {
		ResultSet rs=obj_M_Menu.displayJunkFood();
		return rs;
	}
	public ResultSet DisplayMeal() {
		ResultSet rs=obj_M_Menu.displayMeal();
		return rs;
	}
	public ResultSet DisplayDessert() {
		ResultSet rs=obj_M_Menu.displayDessert();
		return rs;
	}
	public ResultSet DisplayOthers() {
		ResultSet rs=obj_M_Menu.displayOthers();
		return rs;
	}
	public ResultSet DisplayShakes() {
		ResultSet rs=obj_M_Menu.displayShake();
		return rs;
	}
	public ResultSet DisplayJuice() {
		ResultSet rs=obj_M_Menu.displayJuice();
		return rs;
	}
	public String DisplayPrice(String item) {
		String price=obj_M_Menu.displayPrice(item);
		return price;
	}
	public ResultSet SearchFood(String item) {
		ResultSet rs=obj_M_Menu.SearchFood(item);
		return rs;
	}
	public ResultSet viewMenu() {
		ResultSet rs=obj_M_Menu.ViewMenu();
		return rs;
	}
}
