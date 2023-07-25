package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
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

public class Cafe extends JFrame {
	
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cafe frame=new Cafe();
					frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Cafe() {
		setTitle("My Cafe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-8, -3, 1389, 742);
		
		contentPane=new JPanel();
		contentPane.setBackground(new Color(204, 102, 102));
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel=new JLabel((String)null);
		lblNewLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		Image img1=new ImageIcon(this.getClass().getResource("/map2/png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img1));
		lblNewLabel.setBounds(1056, 419, 314, 284);
		contentPane.add(lblNewLabel);
		
		
		JLabel lblNewLabel_1=new JLabel("My Cafe");
		lblNewLabel_1.setBorder(new CompoundBorder());
		lblNewLabel_1.setBackground(new Color(165, 42, 42));
		lblNewLabel_1.setForeground(new Color(250, 250, 210));
		//lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Matura MT Script Capitals", Font.BOLD, 60));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2=new JLabel("");
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		Image img2=new ImageIcon(this.getClass().getResource("")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img2));
		lblNewLabel_2.setBounds(1130, 0, 240, 210);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3=new JLabel("");
		Image img3=new ImageIcon(this.getClass().getResource("")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img3));
		lblNewLabel_3.setBounds(0, 192, 426, 526);
		contentPane.add(lblNewLabel_3);
		
		JButton btnLogin=new JButton("Login");
		
		btnLogin.addActionListener(new ActionListener() {
			public void ActionPerformed(ActionEvent e) {
				dispose();
				View obj_login=new View();
				obj_Login.setVisible(true);
			}
		});
		
		btnLogin.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Calibri", Font.BOLD, 23));
		btnLogin.setBackground(new Color(153, 51, 51));
		btnLogin.setBounds(685, 322, 176, 70);
		contentPane.add(btnLogin);
		
		JButton btnCreateAccount=new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void ActionPerformed(ActionEvent e) {
				dispose();
				CreateAccount obj_CreateAccount=new CreateAccount();
				obj_CreateAccount.setVisible(true);
			}
		});
		
		btnCreateAccount.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnCreateAccount.setForeground(new Color(255, 255, 255));
		btnCreateAccount.setFont(new Font("Calibri", Font.BOLD, 23));
		btnCreateAccount.setBackground(new Color(153, 51, 51));
		btnCreateAccount.setBounds(685, 442, 176, 75);
		contentPane.add(btnCreateAccount);
		
		
		
	}

}
