package view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.Customer;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SubmitOrder extends JFrame{

	private JPanel contentPane;
	private String orderId;
	private int bill;
	private String recv_time;
	private String time;
	private String customerId;
	
	View Obj_View=new View();
	Customer obj_Customer=new Customer();


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SubmitOrder frame =new SubmitOrder(null);
					frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public SubmitOrder(ResultSet rs) {
		setTitle("Order Submitted");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setBounds(-8, -3, 1389, 742);
		contentPane=new JPanel();
		contentPane.setBackground(new Color(210, 180, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*try {
			while(rs.next()) {
				orderId=rs.getString("Order_ID");
				bill=rs.getInt("Bill");
				time=rs.getString("Ordering_Time");
				recv_time=rs.getString("Receiving_Time");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		
		JLabel lblOrderSub=new JLabel("Order Submitted:");
		lblOrderSub.setForeground(Color.BLACK);
		lblOrderSub.setFont(new Font("Calibri", Font.BOLD, 30));
		lblOrderSub.setBounds(50, 50, 300, 50);
		contentPane.add(lblOrderSub);
		
		JLabel lblOrderId=new JLabel("Your order Id is "+orderId);
		lblOrderId.setForeground(Color.BLACK);
		lblOrderId.setFont(new Font("Calibri", Font.BOLD, 20));
		lblOrderId.setBounds(400, 50, 400, 50);
		contentPane.add(lblOrderId);
		
		JLabel lblTotalPrice=new JLabel("Your Total bill is "+bill);
		lblTotalPrice.setForeground(Color.BLACK);
		lblTotalPrice.setFont(new Font("Calibri", Font.BOLD, 20));
		lblTotalPrice.setBounds(400, 100, 400, 50);
		contentPane.add(lblTotalPrice);

		JLabel lblOrderingTime=new JLabel("Your Ordering Time is Rs. "+time);
		lblOrderingTime.setForeground(Color.BLACK);
		lblOrderingTime.setFont(new Font("Calibri", Font.BOLD, 20));
		lblOrderingTime.setBounds(400, 150, 400, 50);
		contentPane.add(lblOrderingTime);
		
		JLabel lblReceivingTime=new JLabel("Your can take your order at "+time);
		lblReceivingTime.setForeground(Color.BLACK);
		lblReceivingTime.setFont(new Font("Calibri", Font.BOLD, 20));
		lblReceivingTime.setBounds(400, 200, 400, 50);
		contentPane.add(lblReceivingTime);
		
		

	}

}
