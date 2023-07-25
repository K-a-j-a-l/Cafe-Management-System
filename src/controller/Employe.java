package controller;
import java.sql.ResultSet;

import model.M_Employee;
public class Employe {
	M_Employee obj_M_Employee=new M_Employee();
	
	public boolean AddEmployee(String name,  String contact, int age, String Duty, int Salary) {
		boolean result=obj_M_Employee.AddEmployee(name, contact, age, Duty, Salary);
		if(result==true) {
			return true;
		}
		return false;
	}
	
	public boolean DeleteEmployee(String name) {
		boolean result=obj_M_Employee.DeleteEmployee(name);
		if(result==true) {
			return true;
		}
		return false;
	}
	
	public boolean UpdateSalary(String name, int Salary) {
		boolean result=obj_M_Employee.UpdateSalary(name, Salary);
		if(result==true) {
			return true;
		}
		return false;
	}
	public boolean AssignDuty(String name, String Duty) {
		boolean result=obj_M_Employee.AssignDuty(name, Duty);
		if(result==true) {
			return true;
		}
		return false;
	}
	public ResultSet viewEmployees() {
		ResultSet rs=obj_M_Employee.viewEmployee();
		return rs;
	}
}
