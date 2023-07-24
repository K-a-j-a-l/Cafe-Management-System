package controller;

public interface Account {
	public boolean createAccount(String customerName, String customerId, String password);
	public boolean login(String id, String password);
	public boolean editSettings(String newPassword, String id);
}
