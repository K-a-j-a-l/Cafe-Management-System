package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import controller.CustomerAccount;
import controller.ManagerAccount;
public class View extends JFrame{
	
	ManagerAccount obj_ManagerAccount=new ManagerAccount();
	CustomerAccount obj_CustomerAccount=new CustomerAccount();
	
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
	public static String CustomerId="";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame=new View();
					frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public View() {
		setTitle("My Cafe Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-8, -3, 1389, 742);
		contentPane=new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*JLabel lblNewLabel=new JLabel("");
		Image img1=new ImageIcon(this.getClass().getResource("/img12.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img1));
		lblNewLabel.setBounds(34, 11, 411, 476);
		contentPane.add(lblNewLabel);
		
		JLabel label=new JLabel("");
		Image img2=new ImageIcon(this.getClass().getResource("/img12.png")).getImage();
		label.setIcon(new ImageIcon(img2));
		label.setBounds(0, 559, 350, 144);
		contentPane.add(label);
		
		JLabel label_1=new JLabel("");
		Image img3=new ImageIcon(this.getClass().getResource("/img12.png")).getImage();
		label_1.setIcon(new ImageIcon(img3));
		label_1.setBounds(341, 559, 361, 144);
		contentPane.add(label_1);

		
		JLabel lblNewLabel_1=new JLabel("");
		Image img4=new ImageIcon(this.getClass().getResource("/img11.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img4));
		lblNewLabel_1.setBounds(683, 559, 350, 144);
		contentPane.add(lblNewLabel_1);*/
		
		JLabel lblID=new JLabel("ID:");
		lblID.setForeground(new Color(153, 0, 51));
		lblID.setFont(new Font("Calibri", Font.BOLD, 22));
		lblID.setBounds(718, 130, 125, 28);
		contentPane.add(lblID);
		
		textField=new JTextField();
		textField.setBounds(892, 127, 188, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword=new JLabel("Password:");
		lblPassword.setForeground(new Color(153, 0, 51));
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 22));
		lblPassword.setBounds(718, 195, 125, 28);
		contentPane.add(lblPassword);
		
		passwordField=new JPasswordField();
		passwordField.setBounds(746, 249, 191, 42);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_2=new JLabel("");
		lblNewLabel_2.setForeground(new Color(153, 102, 0));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_2.setBounds(837, 464, 178, 23);
		contentPane.add(lblNewLabel_2);
		
		JButton btnLogin=new JButton("Login");
		
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("m_001")) {
					boolean result=obj_ManagerAccount.login(textField.getText(), passwordField.getText());
					if(result==true) {
						dispose();
						Manager_Account manager_account_view=new Manager_Account();
						manager_account_view.setVisible(true);
					}
					else {
						lblNewLabel_2.setText("Login Failed");
					}
				}
				else {
					boolean result1=obj_CustomerAccount.login(textField.getText(), passwordField.getText());
					if(result1==true) {
						lblNewLabel_2.setText("Login Successfull");
						CustomerId =textField.getText();
						dispose();
						Form obj_form=new Form();
						obj_form.setVisible(true);
						obj_form.customerId=CustomerId;
					}
					else {
						lblNewLabel_2.setText("Login Failed");
					}
				}
			}
		});
		
		btnLogin.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Calibri", Font.BOLD, 20));
		btnLogin.setBackground(new Color(153, 51, 51));
		btnLogin.setBounds(844, 273, 159, 53);
		contentPane.add(btnLogin);
		
		JButton btnCreateAccount=new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				CreateAccount obj_CreateAccount=new CreateAccount();
				obj_CreateAccount.setVisible(true);
			}
		});
		
		btnCreateAccount.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnCreateAccount.setForeground(new Color(255, 255, 255));
		btnCreateAccount.setFont(new Font("Calibri", Font.BOLD, 20));
		btnCreateAccount.setBackground(new Color(153, 51, 51));
		btnCreateAccount.setBounds(844, 371, 159, 60);
		contentPane.add(btnCreateAccount);
		
		JLabel label_2=new JLabel("");
		Image img5=new ImageIcon(this.getClass().getResource("/img12.png")).getImage();
		label_2.setIcon(new ImageIcon(img5));
		label_2.setBounds(1025, 559, 367, 144);
		contentPane.add(label_2);

		
		JLabel lblNewLabel_3=new JLabel("");
		Image img5=new ImageIcon(this.getClass().getResource("/img11.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img5));
		lblNewLabel_3.setBounds(590, 11, 377, 53);
		contentPane.add(lblNewLabel_3);
	}

}
