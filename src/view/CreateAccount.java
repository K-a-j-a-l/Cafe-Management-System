package view;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import controller.CustomerAccount;

public class CreateAccount extends JFrame{
	
	CustomerAccount obj_CustomerAccount=new CustomerAccount();
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount frame=new CreateAccount();
					frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public CreateAccount() {
		setTitle("My Cafe Create Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setBounds(-8, -3, 1389, 742);
		contentPane=new JPanel();
		contentPane.setBackground(new Color(210, 180, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*JLabel lblNewLabel=new JLabel("");
		Image img1=new ImageIcon(this.getClass().getResource("/img12.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img1));
		lblNewLabel.setBounds(0, 530, 275, 183);
		contentPane.add(lblNewLabel);*/
		
		/*JLabel lblNewLabel_1=new JLabel("");
		Image img2=new ImageIcon(this.getClass().getResource("/img11.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img2));
		lblNewLabel_1.setBounds(0, 384, 275, 147);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2=new JLabel("");
		Image img3=new ImageIcon(this.getClass().getResource("")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img3));
		lblNewLabel_2.setBounds(0, 219, 275, 164);
		contentPane.add(lblNewLabel_2);*/
		
		JLabel lblCreateAccount=new JLabel("CreateAccount");
		lblCreateAccount.setBackground(new Color(165, 42, 42));
		lblCreateAccount.setForeground(new Color(255, 102, 153));
		lblCreateAccount.setOpaque(true);
		lblCreateAccount.setFont(new Font("Matura MT Script Capitals", Font.PLAIN, 24));
		lblCreateAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateAccount.setBounds(0,0,1370, 88);
		contentPane.add(lblCreateAccount);
		
		JLabel lblName=new JLabel("Name:");
		lblName.setForeground(new Color(153, 0, 51));
		lblName.setFont(new Font("Calibri", Font.BOLD, 20));
		lblName.setBounds(567, 178, 96, 35);
		contentPane.add(lblName);
		
		textField=new JTextField();
		textField.setBounds(746, 175, 191, 42);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblID=new JLabel("ID:");
		lblID.setForeground(new Color(153, 0, 51));
		lblID.setFont(new Font("Calibri", Font.BOLD, 20));
		lblID.setBounds(567, 254, 96, 30);
		contentPane.add(lblID);
		
		textField_1=new JTextField();
		textField_1.setBounds(746, 249, 191, 42);
		contentPane.add(textField_1);
		textField.setColumns(10);
		
		JLabel lblPassword=new JLabel("Password:");
		lblPassword.setForeground(new Color(153, 0, 51));
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 20));
		lblPassword.setBounds(565, 324, 132, 32);
		contentPane.add(lblPassword);
		
		passwordField=new JPasswordField();
		passwordField.setBounds(746, 324, 191, 42);
		contentPane.add(passwordField);
		
		JLabel lblAccountisCreated=new JLabel("");
		lblAccountisCreated.setForeground(new Color(153, 0, 51));
		lblAccountisCreated.setFont(new Font("Calibri", Font.BOLD, 18));
		lblAccountisCreated.setBounds(672, 626, 313, 28);
		contentPane.add(lblAccountisCreated);
		
		JButton btnCreate=new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String checkId=textField_1.getText();
				char[] checkId_1=checkId.toCharArray();
				int i=0;
				boolean create=false;
				while(i<checkId.length()) {
					if(checkId_1[i]=='m') {
						lblAccountisCreated.setText("Account Cannot be Created For Manager");
						create=false;
						break;
					}
					else {
						create=true;
					}
					i++;
				}
				if(create==true) {
					boolean result=obj_CustomerAccount.CheckAccount(textField_1.getText());
					System.out.println(result);
					if(result==false) {
						boolean result1=obj_CustomerAccount.createAccount(textField.getText(), textField_1.getText(), passwordField.getText());
						if(result1==true) {
							lblAccountisCreated.setText("Account Created");
						}
					}
					else {
						lblAccountisCreated.setText("Account exist. Do you want to login account?");	
					}
				}
				
			}
		});
		
		btnCreate.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnCreate.setForeground(new Color(255, 204, 255));
		btnCreate.setBackground(new Color(102, 51, 51));
		btnCreate.setFont(new Font("Calibri", Font.BOLD, 20));
		btnCreate.setBounds(685, 454, 130, 50);
		contentPane.add(btnCreate);
		
		JButton btnLogin=new JButton("Login");
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				View obj_login=new View();
				obj_login.setVisible(true);
			}
		});
		
		btnLogin.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Calibri", Font.BOLD, 23));
		btnLogin.setBackground(new Color(153, 51, 51));
		btnLogin.setBounds(683, 530, 132, 50);
		contentPane.add(btnLogin);
		
		JButton btnBack=new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.BLACK);
		btnBack.setFont(new Font("Calibri", Font.BOLD, 22));
		btnBack.setBounds(420, 550, 100, 40);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cafe frame=new Cafe();
				frame.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnBack);
		
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Calibri", Font.BOLD, 20));
		btnExit.setBackground(Color.BLACK);
		btnExit.setBounds(1196, 530, 107, 47);
		contentPane.add(btnExit);
		
	}
}
