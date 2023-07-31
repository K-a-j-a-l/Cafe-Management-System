package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import controller.CustomerAccount;
import controller.C_Menu;
import controller.Order;

public class Form extends JFrame{
	
	CustomerAccount obj_CustomerAccount=new CustomerAccount();
	C_Menu obj_C_Menu=new C_Menu();
	Order obj_Order=new Order();
	View obj_View=new View();
	
	private boolean menuCount=false;
	public String customerId;
	private String orderId;
	private String time;
	private int recv_time;
	private int bill;
	
	private JPanel contentPane;
	private JTable table;
	private final JTabbedPane tabbedPane=new JTabbedPane(JTabbedPane.TOP);
	private JPasswordField CurrentpasswordField;
	private JPasswordField NewpasswordField;
	private JPasswordField ConfirmpasswordField;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form frame =new Form();
					frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Form() {
		setTitle("My Cafe Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setBounds(-8, -3, 1389, 742);
		contentPane=new JPanel();
		contentPane.setBackground(new Color(210, 180, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane.setBackground(new Color(128, 128, 128));
		tabbedPane.setForeground(new Color(255, 255, 255));
		tabbedPane.setFont(new Font("Calibri", Font.PLAIN, 35));
		tabbedPane.setBounds(0, 28, 1370, 645);
		contentPane.add(tabbedPane);
		
		JPanel HomePanel=new JPanel();
		HomePanel.setBackground(new Color(192, 192, 192));
		tabbedPane.addTab("Home", null, HomePanel, null);
		HomePanel.setLayout(null);
		
		JTextPane txtpnCommitment=new JTextPane();
		txtpnCommitment.setFont(new Font("Calibri", Font.PLAIN, 24));
		txtpnCommitment.setBackground(new Color(253, 245, 230));
		txtpnCommitment.setText("Our Commitment\r\n To Quality");
		txtpnCommitment.setBounds(200, 100, 200, 100);
		txtpnCommitment.setEditable(false);
		HomePanel.add(txtpnCommitment);
		
		JTextPane txtpnAsaCafe=new JTextPane();
		txtpnAsaCafe.setFont(new Font("Calibri", Font.PLAIN, 22));
		txtpnAsaCafe.setBackground(new Color(253, 245, 230));
		txtpnAsaCafe.setText("\r\nAs a cafe, we\u2019re proud to say we\u2019ve made some changes for you, our customers. Without you, there would be no us. So, we\u2019re making it our mission to be the best you want. One that\u2019s dedicated to improving the way we prepare our quality food and the ingredients that go into it. One that understands that what\u2019s good for you is good for us. That\u2019s why our food philosophy is this\u2014The Simpler The Better.");
		txtpnAsaCafe.setBounds(200, 250, 700, 200);
		txtpnAsaCafe.setEditable(false);
		HomePanel.add(txtpnAsaCafe);
		
		JPanel FeedbackPanel=new JPanel();
		FeedbackPanel.setBackground(new Color(192, 192, 192));
		tabbedPane.addTab("Feedback", null, FeedbackPanel, null);
		FeedbackPanel.setLayout(null);
		
		JLabel lblFeedback=new JLabel("Feedback");
		lblFeedback.setForeground(Color.BLACK);
		lblFeedback.setFont(new Font("Calibri", Font.BOLD, 29));
		lblFeedback.setBounds(600, 50, 200, 50);
		FeedbackPanel.add(lblFeedback);
		
		JLabel lblFeedbackBody=new JLabel("If you have any problem in ordering the food or with the quality of the food then please comment it. We will try to resolve the issue.");
		lblFeedbackBody.setForeground(Color.BLACK);
		lblFeedbackBody.setFont(new Font("Calibri", Font.BOLD, 20));
		lblFeedbackBody.setBounds(20, 100, 1100, 50);
		FeedbackPanel.add(lblFeedbackBody);
		
		JLabel lblComment=new JLabel("Comment:");
		lblComment.setForeground(Color.BLACK);
		lblComment.setFont(new Font("Calibri", Font.BOLD, 29));
		lblComment.setBounds(20, 200, 200, 50);
		FeedbackPanel.add(lblComment);
		
		JTextPane txtComment=new JTextPane();
		txtComment.setFont(new Font("Calibri", Font.PLAIN, 22));
		txtComment.setBackground(new Color(253, 245, 230));
		txtComment.setBounds(200, 200, 400, 100);
		FeedbackPanel.add(txtComment);
		
		JLabel lblResult=new JLabel("");
		lblResult.setForeground(Color.BLACK);
		lblResult.setFont(new Font("Calibri", Font.BOLD, 20));
		lblResult.setBounds(400, 300, 200, 50);
		FeedbackPanel.add(lblResult);
		
		JButton btnSubmit=new JButton("Submit");
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setBackground(Color.BLACK);
		btnSubmit.setFont(new Font("Calibri", Font.BOLD, 20));
		btnSubmit.setBounds(400, 400, 100, 40);
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean result=obj_CustomerAccount.giveFeedback(txtComment.getText(), View.CustomerId);
				if(result==true) {
					lblResult.setText("Feedback Submitted");
				}
			}
			
		});
		FeedbackPanel.add(btnSubmit);
		
		System.out.println(View.CustomerId);
		
		JPanel SettingsPanel=new JPanel();
		SettingsPanel.setBackground(new Color(192, 192, 192));
		tabbedPane.addTab("Settings", null, SettingsPanel, null);
		SettingsPanel.setLayout(null);
		
		JLabel lblSettings=new JLabel("Settings");
		lblSettings.setHorizontalAlignment(SwingConstants.CENTER);
		lblSettings.setForeground(Color.BLACK);
		lblSettings.setFont(new Font("Calibri", Font.BOLD, 29));
		lblSettings.setBounds(624, 48, 147, 41);
		SettingsPanel.add(lblSettings);
		
		JLabel lblChangePassword=new JLabel("Change Password");
		lblChangePassword.setForeground(Color.BLACK);
		lblChangePassword.setFont(new Font("Calibri", Font.BOLD, 24));
		lblChangePassword.setBounds(176, 119, 191, 28);
		SettingsPanel.add(lblChangePassword);
		
		JLabel lblCurrentPassword=new JLabel("Current Password");
		lblCurrentPassword.setForeground(Color.BLACK);
		lblCurrentPassword.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblCurrentPassword.setBounds(176, 169, 191, 28);
		SettingsPanel.add(lblCurrentPassword);
		
		CurrentpasswordField=new JPasswordField();
		CurrentpasswordField.setBounds(376, 169, 191, 28);
		SettingsPanel.add(CurrentpasswordField);
		
		JLabel lblNewPassword=new JLabel("New Password");
		lblNewPassword.setForeground(Color.BLACK);
		lblNewPassword.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewPassword.setBounds(176, 219, 191, 28);
		SettingsPanel.add(lblNewPassword);
		
		NewpasswordField=new JPasswordField();
		NewpasswordField.setBounds(376, 219, 191, 28);
		SettingsPanel.add(NewpasswordField);
		
		JLabel lblConfirmPassword=new JLabel("Confirm Password");
		lblConfirmPassword.setForeground(Color.BLACK);
		lblConfirmPassword.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblConfirmPassword.setBounds(176, 269, 191, 28);
		SettingsPanel.add(lblConfirmPassword);
		
		ConfirmpasswordField=new JPasswordField();
		ConfirmpasswordField.setBounds(376, 269, 191, 28);
		SettingsPanel.add(ConfirmpasswordField);
		
		JLabel lblPasswordNote=new JLabel("");
		lblPasswordNote.setForeground(Color.BLACK);
		lblPasswordNote.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblPasswordNote.setBounds(276, 319, 300, 50);
		SettingsPanel.add(lblPasswordNote);
		
		JButton btnSave=new JButton("Save");
		btnSave.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnSave.setForeground(Color.WHITE);
		btnSave.setBackground(Color.BLACK);
		btnSave.setFont(new Font("Calibri", Font.BOLD, 20));
		btnSave.setBounds(200, 400, 100, 40);
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(NewpasswordField.getText().equals(ConfirmpasswordField.getText())) {
					boolean result=obj_CustomerAccount.editSettings(NewpasswordField.getText(),View.CustomerId);
					if(result==true) {
						lblPasswordNote.setText("Password Changed Successfully");
					}
					else {
						lblPasswordNote.setText("Password does not match");
					}
				}
			}
			
		});
		SettingsPanel.add(btnSave);
		
		JPanel MenuPanel=new JPanel();
		MenuPanel.setBackground(new Color(192, 192, 192));
		tabbedPane.addTab("Menu", null, MenuPanel, null);
		MenuPanel.setLayout(null);
		
		JLabel lblMenu=new JLabel("Menu");
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setForeground(Color.BLACK);
		lblMenu.setFont(new Font("Calibri", Font.BOLD, 25));
		lblMenu.setBounds(600, 50, 100, 50);
		MenuPanel.add(lblMenu);
		
		JTextPane txtPnMenu=new JTextPane();
		txtPnMenu.setFont(new Font("Calibri", Font.PLAIN, 22));
		txtPnMenu.setBackground(new Color(253, 245, 230));
		txtPnMenu.setText("* Meals\r\n* Junk Food\r\n* Juices\r\n* Shakes\r\n* Desserts\r\n* Snacks");
		txtPnMenu.setBounds(300, 100, 600, 200);
		txtPnMenu.setEditable(false);
		MenuPanel.add(txtPnMenu);
		
		JButton btnViewFull=new JButton("View Full Menu");
		btnViewFull.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnViewFull.setForeground(Color.WHITE);
		btnViewFull.setBackground(Color.BLACK);
		btnViewFull.setFont(new Font("Calibri", Font.BOLD, 20));
		btnViewFull.setBounds(350, 400, 200, 40);
		btnViewFull.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Menu obj_Menu=new Menu();
				obj_Menu.setVisible(true);
			}
			
		});
		
		MenuPanel.add(btnViewFull);
		
	
		
	}

}
