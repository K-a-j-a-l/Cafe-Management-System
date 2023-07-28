package view;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
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

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import controller.C_Menu;
import controller.Order;
import controller.CustomerAccount;
import controller.Customer;

public class Menu extends JFrame{

	C_Menu obj_C_Menu=new C_Menu();
	Order obj_Order=new Order();
	CustomerAccount obj_CustomerAccount=new CustomerAccount();
	Customer obj_Customer=new Customer();
	//View obj_View=new View();

	private static String[] array_itemName=new String[20];
	private static String[] array_itemQty=new String[20];
	private int arrayIndex=0;
	
	private JPanel contentPane;
	private final JTabbedPane tabbedPane=new JTabbedPane(JTabbedPane.TOP);
	JComboBox<String> SnacksBox=new JComboBox<String>();
	JComboBox<String> JunkFoodBox=new JComboBox<String>();
	JComboBox<String> ShakesBox=new JComboBox<String>();
	JComboBox<String> DessertBox=new JComboBox<String>();
	JComboBox<String> MealBox=new JComboBox<String>();
	JComboBox<String> OthersBox=new JComboBox<String>();
	JComboBox<String> JuiceBox=new JComboBox<String>();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame =new Menu();
					frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Menu() {
		setTitle("My Cafe Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-8, -3, 1389, 742);

		contentPane=new JPanel();
		contentPane.setBackground(new Color(204, 102, 102));
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane.setBackground(new Color(128, 128, 128));
		tabbedPane.setForeground(new Color(255, 255, 255));
		tabbedPane.setFont(new Font("Calibri", Font.PLAIN, 40));
		tabbedPane.setBounds(0, 0, 1370, 645);
		contentPane.add(tabbedPane);
		
		SnacksBox.addItem("Select");
		JunkFoodBox.addItem("Select");
		ShakesBox.addItem("Select");
		DessertBox.addItem("Select");
		MealBox.addItem("Select");
		OthersBox.addItem("Select");
		JuiceBox.addItem("Select");
		
		ResultSet rs=obj_C_Menu.DisplaySnacks();
		try {
			while(rs.next()) {
				String itemName=rs.getString("Item_Name");
				SnacksBox.addItem(itemName);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		ResultSet rs1=obj_C_Menu.DisplayJunkFood();
		try {
			while(rs1.next()) {
				String itemName=rs1.getString("Item_Name");
				JunkFoodBox.addItem(itemName);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		ResultSet rs2=obj_C_Menu.DisplayShakes();
		try {
			while(rs2.next()) {
				String itemName=rs2.getString("Item_Name");
				ShakesBox.addItem(itemName);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		ResultSet rs3=obj_C_Menu.DisplayDessert();
		try {
			while(rs3.next()) {
				String itemName=rs3.getString("Item_Name");
				DessertBox.addItem(itemName);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		ResultSet rs4=obj_C_Menu.DisplayMeal();
		try {
			while(rs4.next()) {
				String itemName=rs4.getString("Item_Name");
				MealBox.addItem(itemName);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		

		ResultSet rs5=obj_C_Menu.DisplayOthers();
		try {
			while(rs5.next()) {
				String itemName=rs5.getString("Item_Name");
				OthersBox.addItem(itemName);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		ResultSet rs6=obj_C_Menu.DisplayJuice();
		try {
			while(rs6.next()) {
				String itemName=rs6.getString("Item_Name");
				JuiceBox.addItem(itemName);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		JPanel menuPanel=new JPanel();
		menuPanel.setBackground(new Color(153, 153, 102));
		tabbedPane.addTab("Menu",null, menuPanel, null);
		menuPanel.setLayout(null);
		
		JTabbedPane menutabbedPane=new JTabbedPane(JTabbedPane.TOP);
		menutabbedPane.setBackground(new Color(128, 128, 128));
		menutabbedPane.setForeground(Color.BLACK);
		menutabbedPane.setFont(new Font("Calibri", Font.PLAIN, 30));
		menutabbedPane.setBounds(0, 60, 1370, 645);
		menuPanel.add(menutabbedPane);
		
		JPanel SnacksMenuPanel=new JPanel();
		SnacksMenuPanel.setBackground(new Color(153, 153, 102));
		SnacksMenuPanel.setForeground(new Color(0,0, 102));
		menutabbedPane.addTab("Snacks",null, SnacksMenuPanel, null);
		SnacksMenuPanel.setLayout(null);
		
		SnacksBox.setForeground(Color.BLACK);
		SnacksBox.setBackground(new Color(153, 153, 102));
		SnacksBox.setToolTipText("");
		SnacksBox.setSelectedIndex(0);
		SnacksBox.setBounds(172, 274, 220, 36);
		SnacksMenuPanel.add(SnacksBox);
		
		
		SnacksBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println(SnacksBox.getSelectedItem());
				int x=100, y=100, h=200, w=100;
				
				JLabel lblItemName=new JLabel("Item Name");
				lblItemName.setForeground(Color.BLACK);
				lblItemName.setFont(new Font("Calibri", Font.PLAIN, 20));
				lblItemName.setBounds(x, y, h, w);
				SnacksMenuPanel.add(lblItemName);
				
				JLabel lblItemNameValue=new JLabel("");
				lblItemNameValue.setForeground(Color.BLACK);
				lblItemNameValue.setFont(new Font("Calibri", Font.PLAIN, 20));
				lblItemNameValue.setBounds(x, y+100, h, w);
				SnacksMenuPanel.add(lblItemNameValue);
				lblItemNameValue.setText((String) SnacksBox.getSelectedItem());
			}
			
		});
		
		JPanel JunkFoodMenuPanel=new JPanel();
		JunkFoodMenuPanel.setBackground(new Color(153, 153, 102));
		JunkFoodMenuPanel.setForeground(new Color(0,0, 102));
		menutabbedPane.addTab("Junk Food",null, JunkFoodMenuPanel, null);
		JunkFoodMenuPanel.setLayout(null);
	
		
		JunkFoodBox.setForeground(Color.BLACK);
		JunkFoodBox.setBackground(new Color(153, 153, 102));
		JunkFoodBox.setToolTipText("");
		JunkFoodBox.setSelectedIndex(0);
		JunkFoodBox.setBounds(172, 274, 220, 36);
		JunkFoodMenuPanel.add(JunkFoodBox);
		
		JPanel MealMenuPanel=new JPanel();
		MealMenuPanel.setBackground(new Color(153, 153, 102));
		MealMenuPanel.setForeground(new Color(0,0, 102));
		menutabbedPane.addTab("Meals",null, MealMenuPanel, null);
		MealMenuPanel.setLayout(null);
		
		MealBox.setForeground(Color.BLACK);
		MealBox.setBackground(new Color(153, 153, 102));
		MealBox.setToolTipText("");
		MealBox.setSelectedIndex(0);
		MealBox.setBounds(172, 274, 220, 36);
		MealMenuPanel.add(MealBox);
		
		JPanel DessertMenuPanel=new JPanel();
		DessertMenuPanel.setBackground(new Color(153, 153, 102));
		DessertMenuPanel.setForeground(new Color(0,0, 102));
		menutabbedPane.addTab("Desserts",null, DessertMenuPanel, null);
		DessertMenuPanel.setLayout(null);
		
		DessertBox.setForeground(Color.BLACK);
		DessertBox.setBackground(new Color(153, 153, 102));
		DessertBox.setToolTipText("");
		DessertBox.setSelectedIndex(0);
		DessertBox.setBounds(172, 274, 220, 36);
		DessertMenuPanel.add(DessertBox);
		
		JPanel ShakesMenuPanel=new JPanel();
		ShakesMenuPanel.setBackground(new Color(153, 153, 102));
		ShakesMenuPanel.setForeground(new Color(0,0, 102));
		menutabbedPane.addTab("Shakes",null, ShakesMenuPanel, null);
		ShakesMenuPanel.setLayout(null);
		
		ShakesBox.setForeground(Color.BLACK);
		ShakesBox.setBackground(new Color(153, 153, 102));
		ShakesBox.setToolTipText("");
		ShakesBox.setSelectedIndex(0);
		ShakesBox.setBounds(172, 274, 220, 36);
		ShakesMenuPanel.add(ShakesBox);
		
		JPanel JuicesMenuPanel=new JPanel();
		JuicesMenuPanel.setBackground(new Color(153, 153, 102));
		JuicesMenuPanel.setForeground(new Color(0,0, 102));
		menutabbedPane.addTab("Juices",null, JuicesMenuPanel, null);
		JuicesMenuPanel.setLayout(null);
		
		JuiceBox.setForeground(Color.BLACK);
		JuiceBox.setBackground(new Color(153, 153, 102));
		JuiceBox.setToolTipText("");
		JuiceBox.setSelectedIndex(0);
		JuiceBox.setBounds(172, 274, 220, 36);
		JuicesMenuPanel.add(JuiceBox);
		
		JPanel OthersMenuPanel=new JPanel();
		OthersMenuPanel.setBackground(new Color(153, 153, 102));
		OthersMenuPanel.setForeground(new Color(0,0, 102));
		menutabbedPane.addTab("Others",null, OthersMenuPanel, null);
		OthersMenuPanel.setLayout(null);
		
		OthersBox.setForeground(Color.BLACK);
		OthersBox.setBackground(new Color(153, 153, 102));
		OthersBox.setToolTipText("");
		OthersBox.setSelectedIndex(0);
		OthersBox.setBounds(172, 274, 220, 36);
		OthersMenuPanel.add(OthersBox);
		
		pack();
	}

}
