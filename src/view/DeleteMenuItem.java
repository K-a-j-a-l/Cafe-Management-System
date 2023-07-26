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

public class DeleteMenuItem extends JFrame{
	
	C_Menu obj_Menu=new C_Menu();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel label_1;
	private JButton btnDelete;
	private JLabel lblNewLabel;
	private JButton btnExit;
	private JButton btnNewButton;
	private JLabel label;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteMenuItem frame =new DeleteMenuItem();
					frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public DeleteMenuItem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setBounds(-8, -3, 1389, 742);
		contentPane=new JPanel();
		contentPane.setBackground(new Color(210, 180, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeleteMenuItemFrom=new JLabel("Delete Item From Menu");
		lblDeleteMenuItemFrom.setForeground(Color.BLACK);
		lblDeleteMenuItemFrom.setFont(new Font("Calibri", Font.BOLD, 30));
		lblDeleteMenuItemFrom.setBounds(556, 72, 318, 53);
		contentPane.add(lblDeleteMenuItemFrom);
		
		JLabel lblItemPrice=new JLabel("Item Name");
		lblItemPrice.setForeground(Color.BLACK);
		lblItemPrice.setFont(new Font("Calibri", Font.BOLD, 20));
		lblItemPrice.setBounds(280, 216, 103, 32);
		contentPane.add(lblItemPrice);
		
		textField=new JTextField();
		textField.setColumns(10);
		textField.setBounds(439, 216, 234, 40);
		contentPane.add(textField);
		
		
		lblNewLabel=new JLabel("");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel.setBounds(585, 455, 289, 32);
		contentPane.add(lblNewLabel);
		
		btnDelete=new JButton("Delete");
		btnDelete.setBackground(Color.BLACK);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Calibri", Font.BOLD, 22));
		btnDelete.setBounds(439, 360, 128, 60);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean result=obj_Menu.DeleteMenuItem(textField.getText());
				if(result==true) {
					lblNewLabel.setText("Item Removed Successfully");
	
				}
				else {
					lblNewLabel.setText("Deletion Unsuccessful");
					
				}
			}
		});
		contentPane.add(btnDelete);
		
		
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
		
		label=new JLabel("My Cafe");
		label.setFont(new Font("Mathura MT Script Capitals",Font.BOLD, 30));
		label.setBounds(10,11, 182, 32);
		contentPane.add(label);
	}

}
