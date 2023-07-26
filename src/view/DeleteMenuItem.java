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
		
	}

}
