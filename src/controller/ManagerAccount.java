package controller;
import java.sql.ResultSet;

import model.M_ManageAccount;
public class ManagerAccount implements Account{
	M_ManageAccount obj_M_ManageAccount=new M_ManageAccount();
	
	@Override
	public boolean createAccount(String managerName, String managerId, String password) {
		return false;
	}
	
	@Override
	public boolean login(String managerId, String password) {
		boolean result=obj_M_ManageAccount.login(managerId, password);
		if(result==true) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean editSettings(String newpassword, String managerId) {
		boolean result=obj_M_ManageAccount.editSettings(newpassword, managerId);
		if(result==true) {
			return true;
		}
		return false;
	}
	
	public ResultSet checkFeedback() {
		ResultSet rs=obj_M_ManageAccount.checkFeedback();
		return rs;
	}
	
	public void removeFeedback() {
		obj_M_ManageAccount.removeFeedback();
	}
	
	public ResultSet checkRateService() {
		ResultSet rs=obj_M_ManageAccount.checkRateService();
		return rs;
	}
	

	
}
