package controller;

import java.sql.ResultSet;

import model.M__OrderList;
public class OrderList {
	M__OrderList obj_M__OrderList=new M__OrderList();
	
	public ResultSet viewOrderList() {
		ResultSet rs=obj_M__OrderList.ViewOrderList();
		return rs;
	}
	
	public void ChangeOrderStatus(String value_orderId, int value_bill) {
		obj_M__OrderList.ChangeOrderStatus(value_orderId, value_bill);
	}
	
	public void CancelOrder(String value_orderId, int value_bill) {
		obj_M__OrderList.CancelOrder(value_orderId, value_bill);
	}
	
	public void UpdateQuantity(String value_orderId) {
		obj_M__OrderList.UpdateQuantity(value_orderId);
	}
	
	public ResultSet viewOrderDetails() {
		ResultSet rs=obj_M__OrderList.viewOrderDetails();
		return rs;
	}
	
	public void ChangeOrderDetailStatus(String value_orderId) {
		obj_M__OrderList.changeOrderDetail_Status(value_orderId);
	}
	
	public ResultSet orderItemDetails(String orderId) {
		ResultSet rs=obj_M__OrderList.OrderItemDetails(orderId);
		return rs;
	}
}

