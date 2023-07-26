package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import controller.C_Menu;

public class UpdatePrice extends JFrame{
	
	C_Menu obj_Menu=new C_Menu();
	
	private JPanel contentPane;
	private JTextField txtItemName;
	private JTextField txtUpdateItemPrice;
	private JLabel lblItemName;
	private JLabel lblUpdateItemPrice;
	private JButton btnUpdate;
	private JButton btnBack;
	private JLabel lblTitle;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdatePrice frame =new UpdatePrice();
					frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public UpdatePrice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setBounds(-8, -3, 1389, 742);
		contentPane=new JPanel();
		contentPane.setBackground(new Color(210, 180, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsertNewItem=new JLabel("Add New Item in Menu");
		lblInsertNewItem.setForeground(Color.BLACK);
		lblInsertNewItem.setFont(new Font("Calibri", Font.BOLD, 30));
		lblInsertNewItem.setBounds(370, 45, 302, 53);
		contentPane.add(lblInsertNewItem);
		
		lblItemName=new JLabel("Item Name");
		lblItemName.setForeground(Color.BLACK);
		lblItemName.setFont(new Font("Calibri", Font.BOLD, 20));
		lblItemName.setBounds(308, 216, 103, 27);
		contentPane.add(lblItemName);
		
		txtItemName=new JTextField();
		txtItemName.setBounds(458, 208, 200, 30);
		txtItemName.setColumns(10);
		contentPane.add(txtItemName);
		
		lblUpdateItemPrice=new JLabel("New Item Price");
		lblUpdateItemPrice.setForeground(Color.BLACK);
		lblUpdateItemPrice.setFont(new Font("Calibri", Font.BOLD, 20));
		lblUpdateItemPrice.setBounds(308, 266, 103, 27);
		contentPane.add(lblUpdateItemPrice);
		
		txtUpdateItemPrice=new JTextField();
		txtUpdateItemPrice.setBounds(458, 258, 200, 30);
		txtUpdateItemPrice.setColumns(10);
		contentPane.add(txtUpdateItemPrice);
		
		JLabel lblNewLabel=new JLabel("");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel.setBounds(428, 420, 240, 120);
		contentPane.add(lblNewLabel);
		
		btnUpdate=new JButton("Update");
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setBackground(Color.BLACK);
		btnUpdate.setFont(new Font("Calibri", Font.BOLD, 20));
		btnUpdate.setBounds(420, 500, 100, 40);
		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int itemPrice=Integer.parseInt(txtUpdateItemPrice.getText());
				boolean result=obj_Menu.UpdatePrice(txtItemName.getText(), itemPrice);
				if(result==true) {
					lblNewLabel.setText("Price Updated Successfully");
				}
				else {
					lblNewLabel.setText("Price Updation UnSuccessful");
				}
				txtUpdateItemPrice.setText("");
				txtItemName.setText("");
			}
			
		});
		contentPane.add(btnUpdate);
		
		btnBack=new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.BLACK);
		btnBack.setFont(new Font("Calibri", Font.BOLD, 22));
		btnBack.setBounds(420, 550, 100, 40);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manager_Account frame=new Manager_Account();
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
		
		lblTitle=new JLabel("My Cafe");
		lblTitle.setFont(new Font("Mathura MT Script Capitals",Font.BOLD, 30));
		lblTitle.setBounds(10,11, 182, 32);
		contentPane.add(lblTitle);
		
		
	}

}
