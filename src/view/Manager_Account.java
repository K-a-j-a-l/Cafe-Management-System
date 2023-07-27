package view;

import java.awt.EventQueue;
import net.proteanit.sql.DbUtils;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

import controller.ManagerAccount;
import controller.Manager;
import controller.OrderList;

public class Manager_Account extends JFrame{
	ManagerAccount obj_ManagerAccount=new ManagerAccount();
	Manager obj_Manager=new Manager();
	OrderList obj_OrderList=new OrderList();
	private static boolean remove_count=true;
	
	private JPanel contentPane;
	private final JTabbedPane tabbedPane=new JTabbedPane(JTabbedPane.TOP);
	private JTable table;
	private JPasswordField CurrentpasswordField;
	private JPasswordField NewpasswordField;
	private JPasswordField ConfirmpasswordField;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager_Account frame =new Manager_Account();
					frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Manager_Account() {
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
		tabbedPane.setBounds(0, 58, 1370, 645);
		contentPane.add(tabbedPane);
		
		JPanel panel=new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		tabbedPane.addTab("Home", null, panel, null);
		panel.setLayout(null);
		
		JTextPane txtpnCommitment=new JTextPane();
		txtpnCommitment.setFont(new Font("Calibri", Font.PLAIN, 24));
		txtpnCommitment.setBackground(new Color(253, 245, 230));
		txtpnCommitment.setText("Our Commitment\r\n To Quality");
		txtpnCommitment.setBounds(375, 105, 205, 65);
		panel.add(txtpnCommitment);
		
		JTextPane txtpnAsaCafe=new JTextPane();
		txtpnAsaCafe.setFont(new Font("Calibri", Font.PLAIN, 22));
		txtpnAsaCafe.setBackground(new Color(253, 245, 230));
		txtpnAsaCafe.setText("\r\nAs a cafe, we\u2019re proud to say we\u2019ve made some changes for you, our customers. Without you, there would be no us. So, we\u2019re making it our mission to be the best you want. One that\u2019s dedicated to improving the way we prepare our quality food and the ingredients that go into it. One that understands that what\u2019s good for you is good for us. That\u2019s why our food philosophy is this\u2014The Simpler The Better.");
		txtpnAsaCafe.setBounds(130, 200, 755, 221);
		panel.add(txtpnAsaCafe);
		
		JPanel panel_1=new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		tabbedPane.addTab("Settings", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblSettings=new JLabel("Settings");
		lblSettings.setHorizontalAlignment(SwingConstants.CENTER);
		lblSettings.setForeground(Color.BLACK);
		lblSettings.setFont(new Font("Calibri", Font.BOLD, 29));
		lblSettings.setBounds(624, 48, 147, 41);
		panel_1.add(lblSettings);
		
		JLabel lblChangePassword=new JLabel("Change Password");
		lblChangePassword.setForeground(Color.BLACK);
		lblChangePassword.setFont(new Font("Calibri", Font.BOLD, 24));
		lblChangePassword.setBounds(176, 119, 191, 28);
		panel_1.add(lblChangePassword);
		
		JLabel lblCurrentPassword=new JLabel("Current Password");
		lblCurrentPassword.setForeground(Color.BLACK);
		lblCurrentPassword.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblCurrentPassword.setBounds(176, 169, 191, 28);
		panel_1.add(lblCurrentPassword);
		
		CurrentpasswordField=new JPasswordField();
		CurrentpasswordField.setBounds(376, 169, 191, 28);
		panel_1.add(CurrentpasswordField);
		
		JLabel lblNewPassword=new JLabel("New Password");
		lblNewPassword.setForeground(Color.BLACK);
		lblNewPassword.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewPassword.setBounds(176, 219, 191, 28);
		panel_1.add(lblNewPassword);
		
		NewpasswordField=new JPasswordField();
		NewpasswordField.setBounds(376, 219, 191, 28);
		panel_1.add(NewpasswordField);
		
		JLabel lblConfirmPassword=new JLabel("Confirm Password");
		lblConfirmPassword.setForeground(Color.BLACK);
		lblConfirmPassword.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblConfirmPassword.setBounds(176, 269, 191, 28);
		panel_1.add(lblConfirmPassword);
		
		ConfirmpasswordField=new JPasswordField();
		ConfirmpasswordField.setBounds(376, 269, 191, 28);
		panel_1.add(ConfirmpasswordField);
		
		JLabel lblPasswordNote=new JLabel("");
		lblPasswordNote.setForeground(Color.BLACK);
		lblPasswordNote.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblPasswordNote.setBounds(276, 319, 200, 40);
		panel_1.add(lblPasswordNote);
		
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
					boolean result=obj_ManagerAccount.editSettings(CurrentpasswordField.getText(), NewpasswordField.getText());
					if(result==true) {
						lblPasswordNote.setText("Password Changed Successfully");
					}
					else {
						lblPasswordNote.setText("Password does not match");
					}
				}
			}
			
		});
		panel_1.add(btnSave);
		
		JPanel panel_2=new JPanel();
		panel_2.setBackground(new Color(192, 192, 192));
		tabbedPane.addTab("View Orders", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblOrdersList=new JLabel("Orders List");
		lblOrdersList.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrdersList.setForeground(Color.BLACK);
		lblOrdersList.setFont(new Font("Calibri", Font.BOLD, 28));
		lblOrdersList.setBounds(624, 48, 147, 41);
		panel_2.add(lblOrdersList);
		
		JScrollPane scrollPane=new JScrollPane();
		scrollPane.setBounds(100,200, 1164, 356);
		panel_2.add(scrollPane);
		
		
		JButton btnView=new JButton("View");
		btnView.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnView.setForeground(Color.WHITE);
		btnView.setBackground(Color.BLACK);
		btnView.setFont(new Font("Calibri", Font.BOLD, 20));
		btnView.setBounds(80, 100, 100, 40);
		btnView.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ResultSet rs=obj_OrderList.viewOrderList();
				TableModel tableModel=DbUtils.resultSetToTableModel(rs);
				table.setModel(tableModel);
				
			}
		});
		panel_2.add(btnView);
		table=new JTable();
		scrollPane.setViewportView(table);
		table.setRowHeight(25);
		JTableHeader obj=table.getTableHeader();
		obj.setFont(new Font("Calibri", Font.BOLD, 22));
		
		JButton btnDelete=new JButton("Change Status");
		btnDelete.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(Color.BLACK);
		btnDelete.setFont(new Font("Calibri", Font.BOLD, 20));
		btnDelete.setBounds(80, 150, 100, 40);
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row=table.getSelectedRow();
				System.out.println(row);
				String value_order_id=table.getValueAt(row, 0).toString();
				String Bill_Value=table.getValueAt(row,2).toString();
				int value_bill=Integer.parseInt(Bill_Value);
				System.out.println(value_order_id);
				
				obj_OrderList.ChangeOrderStatus(value_order_id, value_bill);
				
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				try {
					model.removeRow(row);
				}catch(Exception ex) {
					System.out.println(ex);
				}
			}
		});
		panel_2.add(btnDelete);
		
	}
}
