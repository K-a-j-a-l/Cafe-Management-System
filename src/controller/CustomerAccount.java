package controller;
import model.M_CustomerAccount;

public class CustomerAccount implements Account {
	public static String id;
	public String ID=id;
	M_CustomerAccount obj_M_CustomerAccount=new M_CustomerAccount();
	
	@Override
	public boolean createAccount(String customerName, String customerId, String password) {
		boolean result=obj_M_CustomerAccount.createAccount(customerName, customerId, password);
		if(result==true) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean login(String customerId, String password) {
		boolean result=obj_M_CustomerAccount.login(customerId, password);
		if(result==true) {
			id=customerId;
			return true;
		}
		return false;
	}
	
	@Override
	public boolean editSettings(String newpassword, String customerId) {
		boolean result=obj_M_CustomerAccount.editSettings(newpassword, customerId);
		if(result==true) {
			return true;
		}
		return false;
	}
	
	public boolean giveFeedback(String feedback, String customerId) {
		boolean result=obj_M_CustomerAccount.giveFeedback(feedback, id);
		if(result==true) {
			return true;
		}
		return false;
	}
	
	public boolean CheckAccount(String customerId) {
		boolean result=obj_M_CustomerAccount.checkAccount(customerId);
		if(result==true) {
			return true;
		}
		return false;
	}
}
