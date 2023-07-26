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


public class InsertMenuItem extends JFrame{
	C_Menu obj_Menu=new C_Menu();
	
	private JPanel contentPane;
	private JTextField txtItemName;
	private JTextField txtItemPrice;
	private JTextField txtCategory;
	private JTextField txtQuantity;
	private JLabel lblItemName;
	private JLabel lblItemPrice;
	private JLabel lblCategory;
	private JLabel lblQuantity;
	private JButton btnAdd;
	private JLabel lblTitle;
	
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertMenuItem frame =new InsertMenuItem();
					frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public InsertMenuItem() {
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
		
		lblItemPrice=new JLabel("Item Price");
		lblItemPrice.setForeground(Color.BLACK);
		lblItemPrice.setFont(new Font("Calibri", Font.BOLD, 20));
		lblItemPrice.setBounds(308, 266, 103, 27);
		contentPane.add(lblItemPrice);
		
		txtItemPrice=new JTextField();
		txtItemPrice.setBounds(458, 258, 200, 30);
		txtItemPrice.setColumns(10);
		contentPane.add(txtItemPrice);
		
		lblCategory=new JLabel("Category");
		lblCategory.setForeground(Color.BLACK);
		lblCategory.setFont(new Font("Calibri", Font.BOLD, 20));
		lblCategory.setBounds(308, 316, 103, 27);
		contentPane.add(lblCategory);
		
		txtCategory=new JTextField();
		txtCategory.setBounds(458, 308, 200, 30);
		txtCategory.setColumns(10);
		contentPane.add(txtCategory);
		
		lblQuantity=new JLabel("Quantity");
		lblQuantity.setForeground(Color.BLACK);
		lblQuantity.setFont(new Font("Calibri", Font.BOLD, 20));
		lblQuantity.setBounds(308, 366, 103, 27);
		contentPane.add(lblQuantity);
		
		txtQuantity=new JTextField();
		txtQuantity.setBounds(458, 368, 200, 30);
		txtQuantity.setColumns(10);
		contentPane.add(txtQuantity);
		
		JLabel lblNewLabel=new JLabel("");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel.setBounds(428, 420, 240, 120);
		contentPane.add(lblNewLabel);
		
		
		btnAdd=new JButton("Add");
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBackground(Color.BLACK);
		btnAdd.setFont(new Font("Calibri", Font.BOLD, 20));
		btnAdd.setBounds(420, 500, 100, 40);
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int itemPrice=Integer.parseInt(txtItemPrice.getText());
				int qty=Integer.parseInt(txtQuantity.getText());
				boolean result=obj_Menu.AddMenuItem(txtItemName.getText(), itemPrice, qty, txtCategory.getText());
				if(result==true) {
					lblNewLabel.setText("Item inserted Successfully");
					
				}
				else {
					lblNewLabel.setText("Insertion unsuccessful");
				}
				txtItemPrice.setText("");
				txtQuantity.setText("");
				txtItemName.setText("");
				txtCategory.setText("");
			}
			
		});
		contentPane.add(btnAdd);
		
		JButton btnBack=new JButton("Back");
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
