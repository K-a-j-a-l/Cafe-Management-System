package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import controller.C_Menu;

public class Manager_Menu extends JFrame{
	
	C_Menu obj_C_Menu=new C_Menu();
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_1;
	private JButton btnBack;
	private JLabel lblTitle;
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager_Menu frame =new Manager_Menu();
					frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Manager_Menu() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setBounds(-8, -3, 1389, 742);
		contentPane=new JPanel();
		contentPane.setBackground(new Color(210, 180, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_1=new JLabel("Menu");
		lblNewLabel_1.setBounds(408, 37, 149, 52);
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 35));
		contentPane.add(lblNewLabel_1);
		
		scrollPane=new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(50,50));
		scrollPane.setViewportBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		scrollPane.setToolTipText("");
		scrollPane.setBounds(408, 100, 758, 374);
		contentPane.add(scrollPane);
		
		
		ResultSet rs=obj_C_Menu.viewMenu();
		DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn("Item Name");
        tableModel.addColumn("Item Price");
        tableModel.addColumn("Quantity");
        tableModel.addColumn("Category");

        // Loop through the ResultSet and add data to the table model
        while (rs.next()) {
            String itemName = rs.getString("Item_Name");
            int itemPrice = rs.getInt("Item_Price");
            int quantity = rs.getInt("Quantity");
            String category = rs.getString("Category");

            // Add the data as a row to the table model
            tableModel.addRow(new Object[]{itemName, itemPrice, quantity, category});
        }
        
        // Create a JTable using the DefaultTableModel
        table=new JTable(tableModel);
		table.setBorder(new CompoundBorder(new LineBorder(new Color(171, 173, 179)), null));
		table.setToolTipText("");
		table.setFont(new Font("Calibri", Font.PLAIN, 16));
		scrollPane.setViewportView(table);
		
		btnBack=new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.BLACK);
		btnBack.setFont(new Font("Calibri", Font.BOLD, 22));
		btnBack.setBounds(420, 550, 100, 40);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnBack);
		
		lblTitle=new JLabel("My Cafe");
		lblTitle.setFont(new Font("Mathura MT Script Capitals",Font.BOLD, 30));
		lblTitle.setBounds(10,11, 182, 32);
		contentPane.add(lblTitle);
		
		
		
	}

}
