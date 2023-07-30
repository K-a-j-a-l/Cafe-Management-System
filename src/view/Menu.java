package view;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;
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
	private static String[] array_itemPrice=new String[20];
	private static String[] array_totalPrice=new String[20];
	private int arrayIndex=0;
	private int TotalBill=0;
	
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
		
		
		
		//main panel
		
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
		
		
		//menu panel
		JPanel menuPanel=new JPanel();
		menuPanel.setBackground(new Color(153, 153, 102));
		tabbedPane.addTab("Menu",null, menuPanel, null);
		menuPanel.setLayout(null);
		
		//order Panel
		JPanel OrderPanel=new JPanel();
		OrderPanel.setBackground(new Color(153, 153, 102));
		tabbedPane.addTab("Order",null, OrderPanel, null);
		OrderPanel.setLayout(null);
		
		JLabel lblOrders=new JLabel("Items Ordered");
		lblOrders.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrders.setForeground(Color.BLACK);
		lblOrders.setFont(new Font("Calibri", Font.BOLD, 28));
		lblOrders.setBounds(600, 45, 200, 50);
		OrderPanel.add(lblOrders);
		
		JScrollPane scrollPane=new JScrollPane();
		scrollPane.setBounds(300,100, 1000, 300);
		OrderPanel.add(scrollPane);
		
		JLabel lblTotalBill=new JLabel("Total Bill");
		lblTotalBill.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalBill.setForeground(Color.BLACK);
		lblTotalBill.setFont(new Font("Calibri", Font.BOLD, 20));
		lblTotalBill.setBounds(100,200 ,200, 50);
		OrderPanel.add(lblTotalBill);
		
		JLabel lblTotalBillValue=new JLabel("");
		lblTotalBillValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalBillValue.setForeground(Color.BLACK);
		lblTotalBillValue.setFont(new Font("Calibri", Font.BOLD, 28));
		lblTotalBillValue.setBounds(100,250 , 100, 50);
		OrderPanel.add(lblTotalBillValue);
		
		
		JTabbedPane menutabbedPane=new JTabbedPane(JTabbedPane.TOP);
		menutabbedPane.setBackground(new Color(128, 128, 128));
		menutabbedPane.setForeground(Color.BLACK);
		menutabbedPane.setFont(new Font("Calibri", Font.PLAIN, 30));
		menutabbedPane.setBounds(0, 60, 1370, 645);
		menuPanel.add(menutabbedPane);
		
		
		//Snacks Panel
		
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
		
		JLabel lblItemNameSnack=new JLabel("Item Name");
		lblItemNameSnack.setForeground(Color.BLACK);
		lblItemNameSnack.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblItemNameSnack.setBounds(172, 144, 117, 29);
		SnacksMenuPanel.add(lblItemNameSnack);
		
		JLabel lblItemNameValueSnack=new JLabel("");
		lblItemNameValueSnack.setForeground(Color.BLACK);
		lblItemNameValueSnack.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblItemNameValueSnack.setBounds(172, 184, 219, 36);
		SnacksMenuPanel.add(lblItemNameValueSnack);
		
		JLabel lblQtySnack=new JLabel("Quantity:");
		lblQtySnack.setForeground(Color.BLACK);
		lblQtySnack.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblQtySnack.setBounds(468, 144, 117, 29);
		SnacksMenuPanel.add(lblQtySnack);
		
		JSpinner QtySpinnerSnack=new JSpinner();
		QtySpinnerSnack.setModel(new SpinnerNumberModel(1,1,10,1));
		QtySpinnerSnack.setFont(new Font("Calibri", Font.PLAIN, 20));
		QtySpinnerSnack.setBounds(468, 184, 219, 36);
		SnacksMenuPanel.add(QtySpinnerSnack);
		
		JLabel lblItemPriceSpinnerSnack=new JLabel("Price:");
		lblItemPriceSpinnerSnack.setForeground(Color.BLACK);
		lblItemPriceSpinnerSnack.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblItemPriceSpinnerSnack.setBounds(468, 242, 117, 29);
		SnacksMenuPanel.add(lblItemPriceSpinnerSnack);
		
		JLabel lblItemPriceValueSnack=new JLabel("");
		lblItemPriceValueSnack.setForeground(Color.BLACK);
		lblItemPriceValueSnack.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblItemPriceValueSnack.setBounds(468, 274, 219, 36);
		SnacksMenuPanel.add(lblItemPriceValueSnack);
		
		JLabel lblTotalPriceSnacks=new JLabel("Total Price:");
		lblTotalPriceSnacks.setForeground(Color.BLACK);
		lblTotalPriceSnacks.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblTotalPriceSnacks.setBounds(602, 242, 117, 29);
		SnacksMenuPanel.add(lblTotalPriceSnacks);
		
		JLabel lblTotalPriceValueSnacks=new JLabel("");
		lblTotalPriceValueSnacks.setForeground(Color.BLACK);
		lblTotalPriceValueSnacks.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblTotalPriceValueSnacks.setBounds(602, 274, 219, 36);
		SnacksMenuPanel.add(lblTotalPriceValueSnacks);
	
		JButton btnAddSnacks=new JButton("Add");
		btnAddSnacks.setBackground(Color.BLACK);
		btnAddSnacks.setForeground(Color.WHITE);
		btnAddSnacks.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnAddSnacks.setBounds(356, 360, 117, 44);
		btnAddSnacks.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblItemNameValueSnack.setText(SnacksBox.getSelectedItem().toString());
				String Item=lblItemNameValueSnack.getText().toString();
				int price=obj_C_Menu.DisplayPrice(Item);
				//System.out.println(price);
				String price_str=Integer.toString(price);
				lblItemPriceValueSnack.setText(price_str);
				int qty=(Integer)QtySpinnerSnack.getValue();
				int totalPrice=qty*price;
				TotalBill+=totalPrice;
				String total_price=Integer.toString(totalPrice);
				lblTotalPriceValueSnacks.setText(total_price);
				array_itemPrice[arrayIndex]=lblItemPriceValueSnack.getText();
				array_totalPrice[arrayIndex]=lblTotalPriceValueSnacks.getText();
				array_itemName[arrayIndex]=lblItemNameValueSnack.getText();
				array_itemQty[arrayIndex]=QtySpinnerSnack.getValue().toString();
				arrayIndex++;
				
			}
			
		});
		SnacksMenuPanel.add(btnAddSnacks);
		
		
		//JunkFood Panel 
		
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
		
		JLabel lblItemNameJF=new JLabel("Item Name");
		lblItemNameJF.setForeground(Color.BLACK);
		lblItemNameJF.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblItemNameJF.setBounds(172, 144, 117, 29);
		JunkFoodMenuPanel.add(lblItemNameJF);
		
		JLabel lblItemNameValueJF=new JLabel("");
		lblItemNameValueJF.setForeground(Color.BLACK);
		lblItemNameValueJF.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblItemNameValueJF.setBounds(172, 184, 219, 36);
		JunkFoodMenuPanel.add(lblItemNameValueJF);
		
		JLabel lblQtyJF=new JLabel("Quantity:");
		lblQtyJF.setForeground(Color.BLACK);
		lblQtyJF.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblQtyJF.setBounds(468, 144, 117, 29);
		JunkFoodMenuPanel.add(lblQtyJF);
		
		JSpinner QtySpinnerJF=new JSpinner();
		QtySpinnerJF.setModel(new SpinnerNumberModel(1,1,10,1));
		QtySpinnerJF.setFont(new Font("Calibri", Font.PLAIN, 20));
		QtySpinnerJF.setBounds(468, 184, 219, 36);
		JunkFoodMenuPanel.add(QtySpinnerJF);
		
		JLabel lblItemPriceJF=new JLabel("Price:");
		lblItemPriceJF.setForeground(Color.BLACK);
		lblItemPriceJF.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblItemPriceJF.setBounds(468, 242, 117, 29);
		JunkFoodMenuPanel.add(lblItemPriceJF);
		
		JLabel lblItemPriceValueJF=new JLabel("");
		lblItemPriceValueJF.setForeground(Color.BLACK);
		lblItemPriceValueJF.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblItemPriceValueJF.setBounds(468, 274, 219, 36);
		JunkFoodMenuPanel.add(lblItemPriceValueJF);
		
		JLabel lblTotalPriceJF=new JLabel("Total Price:");
		lblTotalPriceJF.setForeground(Color.BLACK);
		lblTotalPriceJF.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblTotalPriceJF.setBounds(602, 242, 117, 29);
		JunkFoodMenuPanel.add(lblTotalPriceJF);
		
		JLabel lblTotalPriceValueJF=new JLabel("");
		lblTotalPriceValueJF.setForeground(Color.BLACK);
		lblTotalPriceValueJF.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblTotalPriceValueJF.setBounds(602, 274, 219, 36);
		JunkFoodMenuPanel.add(lblTotalPriceValueJF);
	

		JButton btnAddJF=new JButton("Add");
		btnAddJF.setBackground(Color.BLACK);
		btnAddJF.setForeground(Color.WHITE);
		btnAddJF.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnAddJF.setBounds(356, 360, 117, 44);
		btnAddJF.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lblItemNameValueJF.setText(JunkFoodBox.getSelectedItem().toString());
				
				String Item=lblItemNameValueJF.getText().toString();
				int price=obj_C_Menu.DisplayPrice(Item);
				System.out.println(price);
				String price_str=Integer.toString(price);
				lblItemPriceValueJF.setText(price_str);
				int qty=(Integer)QtySpinnerJF.getValue();
				int totalPrice=qty*price;
				TotalBill+=totalPrice;
				String total_price=Integer.toString(totalPrice);
				lblTotalPriceValueJF.setText(total_price);				
				array_itemPrice[arrayIndex]=lblItemPriceValueJF.getText();
				array_totalPrice[arrayIndex]=lblTotalPriceValueJF.getText();
				array_itemName[arrayIndex]=lblItemNameValueJF.getText();
				array_itemQty[arrayIndex]=QtySpinnerJF.getValue().toString();
				arrayIndex++;
				
			}
			
		});
		JunkFoodMenuPanel.add(btnAddJF);

		
		//Meal Panel
		
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
		
		JLabel lblItemNameMeal=new JLabel("Item Name");
		lblItemNameMeal.setForeground(Color.BLACK);
		lblItemNameMeal.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblItemNameMeal.setBounds(172, 144, 117, 29);
		MealMenuPanel.add(lblItemNameMeal);
		
		JLabel lblItemNameValueMeal=new JLabel("");
		lblItemNameValueMeal.setForeground(Color.BLACK);
		lblItemNameValueMeal.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblItemNameValueMeal.setBounds(172, 184, 219, 36);
		MealMenuPanel.add(lblItemNameValueMeal);
		
		JLabel lblQtyMeal=new JLabel("Quantity:");
		lblQtyMeal.setForeground(Color.BLACK);
		lblQtyMeal.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblQtyMeal.setBounds(468, 144, 117, 29);
		MealMenuPanel.add(lblQtyMeal);
		
		JSpinner QtySpinnerMeal=new JSpinner();
		QtySpinnerMeal.setModel(new SpinnerNumberModel(1,1,10,1));
		QtySpinnerMeal.setFont(new Font("Calibri", Font.PLAIN, 20));
		QtySpinnerMeal.setBounds(468, 184, 219, 36);
		MealMenuPanel.add(QtySpinnerMeal);
		
		JLabel lblItemPriceMeal=new JLabel("Price:");
		lblItemPriceMeal.setForeground(Color.BLACK);
		lblItemPriceMeal.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblItemPriceMeal.setBounds(468, 242, 117, 29);
		MealMenuPanel.add(lblItemPriceMeal);
		
		JLabel lblItemPriceValueMeal=new JLabel("");
		lblItemPriceValueMeal.setForeground(Color.BLACK);
		lblItemPriceValueMeal.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblItemPriceValueMeal.setBounds(468, 274, 219, 36);
		MealMenuPanel.add(lblItemPriceValueMeal);
		
		JLabel lblTotalPriceMeal=new JLabel("Total Price:");
		lblTotalPriceMeal.setForeground(Color.BLACK);
		lblTotalPriceMeal.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblTotalPriceMeal.setBounds(602, 242, 117, 29);
		MealMenuPanel.add(lblTotalPriceMeal);
		
		JLabel lblTotalPriceValueMeal=new JLabel("");
		lblTotalPriceValueMeal.setForeground(Color.BLACK);
		lblTotalPriceValueMeal.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblTotalPriceValueMeal.setBounds(602, 274, 219, 36);
		MealMenuPanel.add(lblTotalPriceValueMeal);

		JButton btnAddMeal=new JButton("Add");
		btnAddMeal.setBackground(Color.BLACK);
		btnAddMeal.setForeground(Color.WHITE);
		btnAddMeal.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnAddMeal.setBounds(356, 360, 117, 44);
		btnAddMeal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lblItemNameValueMeal.setText(MealBox.getSelectedItem().toString());
				
				String Item=lblItemNameValueMeal.getText().toString();
				int price=obj_C_Menu.DisplayPrice(Item);
				System.out.println(price);
				String price_str=Integer.toString(price);
				lblItemPriceValueMeal.setText(price_str);
				int qty=(Integer)QtySpinnerMeal.getValue();
				int totalPrice=qty*price;
				TotalBill+=totalPrice;
				String total_price=Integer.toString(totalPrice);
				lblTotalPriceValueMeal.setText(total_price);				
				array_itemPrice[arrayIndex]=lblItemPriceValueMeal.getText();
				array_totalPrice[arrayIndex]=lblTotalPriceValueMeal.getText();
				array_itemName[arrayIndex]=lblItemNameValueMeal.getText();
				array_itemQty[arrayIndex]=QtySpinnerMeal.getValue().toString();
				arrayIndex++;
				
			}
			
		});
		MealMenuPanel.add(btnAddMeal);

		
		
		//Dessert Panel
		
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
		
		JLabel lblItemNameDess=new JLabel("Item Name");
		lblItemNameDess.setForeground(Color.BLACK);
		lblItemNameDess.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblItemNameDess.setBounds(172, 144, 117, 29);
		DessertMenuPanel.add(lblItemNameDess);
		
		JLabel lblItemNameValueDess=new JLabel("");
		lblItemNameValueDess.setForeground(Color.BLACK);
		lblItemNameValueDess.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblItemNameValueDess.setBounds(172, 184, 219, 36);
		DessertMenuPanel.add(lblItemNameValueDess);
		
		JLabel lblQtyDess=new JLabel("Quantity:");
		lblQtyDess.setForeground(Color.BLACK);
		lblQtyDess.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblQtyDess.setBounds(468, 144, 117, 29);
		DessertMenuPanel.add(lblQtyDess);
		
		JSpinner QtySpinnerDess=new JSpinner();
		QtySpinnerDess.setModel(new SpinnerNumberModel(1,1,10,1));
		QtySpinnerDess.setFont(new Font("Calibri", Font.PLAIN, 20));
		QtySpinnerDess.setBounds(468, 184, 219, 36);
		DessertMenuPanel.add(QtySpinnerDess);
		
		JLabel lblItemPriceDess=new JLabel("Price:");
		lblItemPriceDess.setForeground(Color.BLACK);
		lblItemPriceDess.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblItemPriceDess.setBounds(468, 242, 117, 29);
		DessertMenuPanel.add(lblItemPriceDess);
		
		JLabel lblItemPriceValueDess=new JLabel("");
		lblItemPriceValueDess.setForeground(Color.BLACK);
		lblItemPriceValueDess.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblItemPriceValueDess.setBounds(468, 274, 219, 36);
		DessertMenuPanel.add(lblItemPriceValueDess);
		
		JLabel lblTotalPriceDess=new JLabel("Total Price:");
		lblTotalPriceDess.setForeground(Color.BLACK);
		lblTotalPriceDess.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblTotalPriceDess.setBounds(602, 242, 117, 29);
		DessertMenuPanel.add(lblTotalPriceDess);
		
		JLabel lblTotalPriceValueDess=new JLabel("");
		lblTotalPriceValueDess.setForeground(Color.BLACK);
		lblTotalPriceValueDess.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblTotalPriceValueDess.setBounds(602, 274, 219, 36);
		DessertMenuPanel.add(lblTotalPriceValueDess);
	

		JButton btnAddDess=new JButton("Add");
		btnAddDess.setBackground(Color.BLACK);
		btnAddDess.setForeground(Color.WHITE);
		btnAddDess.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnAddDess.setBounds(356, 360, 117, 44);
		btnAddDess.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lblItemNameValueDess.setText(DessertBox.getSelectedItem().toString());

				String Item=lblItemNameValueDess.getText().toString();
				int price=obj_C_Menu.DisplayPrice(Item);
				System.out.println(price);
				String price_str=Integer.toString(price);
				lblItemPriceValueDess.setText(price_str);
				int qty=(Integer)QtySpinnerDess.getValue();
				int totalPrice=qty*price;
				TotalBill+=totalPrice;
				String total_price=Integer.toString(totalPrice);
				lblTotalPriceValueDess.setText(total_price);				
				
				array_itemPrice[arrayIndex]=lblItemPriceValueDess.getText();
				array_totalPrice[arrayIndex]=lblTotalPriceValueDess.getText();
				array_itemName[arrayIndex]=lblItemNameValueDess.getText();
				array_itemQty[arrayIndex]=QtySpinnerDess.getValue().toString();
				arrayIndex++;
			}
			
		});
		DessertMenuPanel.add(btnAddDess);

		
		//Shakes Menu Panel
		
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
		
		JLabel lblItemNameShk=new JLabel("Item Name");
		lblItemNameShk.setForeground(Color.BLACK);
		lblItemNameShk.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblItemNameShk.setBounds(172, 144, 117, 29);
		ShakesMenuPanel.add(lblItemNameShk);
		
		JLabel lblItemNameValueShk=new JLabel("");
		lblItemNameValueShk.setForeground(Color.BLACK);
		lblItemNameValueShk.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblItemNameValueShk.setBounds(172, 184, 219, 36);
		ShakesMenuPanel.add(lblItemNameValueShk);
		
		JLabel lblQtyShk=new JLabel("Quantity:");
		lblQtyShk.setForeground(Color.BLACK);
		lblQtyShk.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblQtyShk.setBounds(468, 144, 117, 29);
		ShakesMenuPanel.add(lblQtyShk);
		
		JSpinner QtySpinnerShk=new JSpinner();
		QtySpinnerShk.setModel(new SpinnerNumberModel(1,1,10,1));
		QtySpinnerShk.setFont(new Font("Calibri", Font.PLAIN, 20));
		QtySpinnerShk.setBounds(468, 184, 219, 36);
		ShakesMenuPanel.add(QtySpinnerShk);
		
		JLabel lblItemPriceShk=new JLabel("Price:");
		lblItemPriceShk.setForeground(Color.BLACK);
		lblItemPriceShk.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblItemPriceShk.setBounds(468, 242, 117, 29);
		ShakesMenuPanel.add(lblItemPriceShk);
		
		JLabel lblItemPriceValueShk=new JLabel("");
		lblItemPriceValueShk.setForeground(Color.BLACK);
		lblItemPriceValueShk.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblItemPriceValueShk.setBounds(468, 274, 219, 36);
		ShakesMenuPanel.add(lblItemPriceValueShk);
		
		JLabel lblTotalPriceShk=new JLabel("Total Price:");
		lblTotalPriceShk.setForeground(Color.BLACK);
		lblTotalPriceShk.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblTotalPriceShk.setBounds(602, 242, 117, 29);
		ShakesMenuPanel.add(lblTotalPriceShk);
		
		JLabel lblTotalPriceValueShk=new JLabel("");
		lblTotalPriceValueShk.setForeground(Color.BLACK);
		lblTotalPriceValueShk.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblTotalPriceValueShk.setBounds(602, 274, 219, 36);
		ShakesMenuPanel.add(lblTotalPriceValueShk);
	
		JButton btnAddShk=new JButton("Add");
		btnAddShk.setBackground(Color.BLACK);
		btnAddShk.setForeground(Color.WHITE);
		btnAddShk.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnAddShk.setBounds(356, 360, 117, 44);
		btnAddShk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lblItemNameValueShk.setText(ShakesBox.getSelectedItem().toString());
				
				String Item=lblItemNameValueShk.getText().toString();
				int price=obj_C_Menu.DisplayPrice(Item);
				System.out.println(price);
				String price_str=Integer.toString(price);
				lblItemPriceValueShk.setText(price_str);
				int qty=(Integer)QtySpinnerShk.getValue();
				int totalPrice=qty*price;
				TotalBill+=totalPrice;
				String total_price=Integer.toString(totalPrice);
				lblTotalPriceValueShk.setText(total_price);				
				
				array_itemPrice[arrayIndex]=lblItemPriceValueShk.getText();
				array_totalPrice[arrayIndex]=lblTotalPriceValueShk.getText();
				array_itemName[arrayIndex]=lblItemNameValueShk.getText();
				array_itemQty[arrayIndex]=QtySpinnerShk.getValue().toString();
				arrayIndex++;
				
			}
			
		});
		ShakesMenuPanel.add(btnAddShk);
		
		//Juices Menu Panel
		
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
		
		JLabel lblItemNameJui=new JLabel("Item Name");
		lblItemNameJui.setForeground(Color.BLACK);
		lblItemNameJui.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblItemNameJui.setBounds(172, 144, 117, 29);
		JuicesMenuPanel.add(lblItemNameJui);
		
		JLabel lblItemNameValueJui=new JLabel("");
		lblItemNameValueJui.setForeground(Color.BLACK);
		lblItemNameValueJui.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblItemNameValueJui.setBounds(172, 184, 219, 36);
		JuicesMenuPanel.add(lblItemNameValueJui);
		
		JLabel lblQtyJui=new JLabel("Quantity:");
		lblQtyJui.setForeground(Color.BLACK);
		lblQtyJui.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblQtyJui.setBounds(468, 144, 117, 29);
		JuicesMenuPanel.add(lblQtyJui);
		
		JSpinner QtySpinnerJui=new JSpinner();
		QtySpinnerJui.setModel(new SpinnerNumberModel(1,1,10,1));
		QtySpinnerJui.setFont(new Font("Calibri", Font.PLAIN, 20));
		QtySpinnerJui.setBounds(468, 184, 219, 36);
		JuicesMenuPanel.add(QtySpinnerJui);
		
		JLabel lblItemPriceJui=new JLabel("Price:");
		lblItemPriceJui.setForeground(Color.BLACK);
		lblItemPriceJui.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblItemPriceJui.setBounds(468, 242, 117, 29);
		JuicesMenuPanel.add(lblItemPriceJui);
		
		JLabel lblItemPriceValueJui=new JLabel("");
		lblItemPriceValueJui.setForeground(Color.BLACK);
		lblItemPriceValueJui.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblItemPriceValueJui.setBounds(468, 274, 219, 36);
		JuicesMenuPanel.add(lblItemPriceValueJui);
		
		JLabel lblTotalPriceJui=new JLabel("Total Price:");
		lblTotalPriceJui.setForeground(Color.BLACK);
		lblTotalPriceJui.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblTotalPriceJui.setBounds(602, 242, 117, 29);
		JuicesMenuPanel.add(lblTotalPriceJui);
		
		JLabel lblTotalPriceValueJui=new JLabel("");
		lblTotalPriceValueJui.setForeground(Color.BLACK);
		lblTotalPriceValueJui.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblTotalPriceValueJui.setBounds(602, 274, 219, 36);
		JuicesMenuPanel.add(lblTotalPriceValueJui);
	

		JButton btnAddJui=new JButton("Add");
		btnAddJui.setBackground(Color.BLACK);
		btnAddJui.setForeground(Color.WHITE);
		btnAddJui.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnAddJui.setBounds(356, 360, 117, 44);
		btnAddJui.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lblItemNameValueJui.setText(JuiceBox.getSelectedItem().toString());
				
				String Item=lblItemNameValueJui.getText().toString();
				int price=obj_C_Menu.DisplayPrice(Item);
				System.out.println(price);
				String price_str=Integer.toString(price);
				lblItemPriceValueJui.setText(price_str);
				int qty=(Integer)QtySpinnerJui.getValue();
				int totalPrice=qty*price;
				TotalBill+=totalPrice;
				String total_price=Integer.toString(totalPrice);
				lblTotalPriceValueJui.setText(total_price);				
		
				array_itemPrice[arrayIndex]=lblItemPriceValueJui.getText();
				array_totalPrice[arrayIndex]=lblTotalPriceValueJui.getText();
				array_itemName[arrayIndex]=lblItemNameValueJui.getText();
				array_itemQty[arrayIndex]=QtySpinnerJui.getValue().toString();
				arrayIndex++;
				
			}
			
		});
		JuicesMenuPanel.add(btnAddJui);
		
		
		//Others Menu Panel
		
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
		
		JLabel lblItemNameOth=new JLabel("Item Name");
		lblItemNameOth.setForeground(Color.BLACK);
		lblItemNameOth.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblItemNameOth.setBounds(172, 144, 117, 29);
		OthersMenuPanel.add(lblItemNameOth);
		
		JLabel lblItemNameValueOth=new JLabel("");
		lblItemNameValueOth.setForeground(Color.BLACK);
		lblItemNameValueOth.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblItemNameValueOth.setBounds(172, 184, 219, 36);
		OthersMenuPanel.add(lblItemNameValueOth);
		
		JLabel lblQtyOth=new JLabel("Quantity:");
		lblQtyOth.setForeground(Color.BLACK);
		lblQtyOth.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblQtyOth.setBounds(468, 144, 117, 29);
		OthersMenuPanel.add(lblQtyOth);
		
		JSpinner QtySpinnerOth=new JSpinner();
		QtySpinnerOth.setModel(new SpinnerNumberModel(1,1,10,1));
		QtySpinnerOth.setFont(new Font("Calibri", Font.PLAIN, 20));
		QtySpinnerOth.setBounds(468, 184, 219, 36);
		OthersMenuPanel.add(QtySpinnerOth);
		
		JLabel lblItemPriceOth=new JLabel("Price:");
		lblItemPriceOth.setForeground(Color.BLACK);
		lblItemPriceOth.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblItemPriceOth.setBounds(468, 242, 117, 29);
		OthersMenuPanel.add(lblItemPriceOth);
		
		JLabel lblItemPriceValueOth=new JLabel("");
		lblItemPriceValueOth.setForeground(Color.BLACK);
		lblItemPriceValueOth.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblItemPriceValueOth.setBounds(468, 274, 219, 36);
		OthersMenuPanel.add(lblItemPriceValueOth);
		
		JLabel lblTotalPriceOth=new JLabel("Total Price:");
		lblTotalPriceOth.setForeground(Color.BLACK);
		lblTotalPriceOth.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblTotalPriceOth.setBounds(602, 242, 117, 29);
		OthersMenuPanel.add(lblTotalPriceOth);
		
		JLabel lblTotalPriceValueOth=new JLabel("");
		lblTotalPriceValueOth.setForeground(Color.BLACK);
		lblTotalPriceValueOth.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblTotalPriceValueOth.setBounds(602, 274, 219, 36);
		OthersMenuPanel.add(lblTotalPriceValueOth);

		JButton btnAddOth=new JButton("Add");
		btnAddOth.setBackground(Color.BLACK);
		btnAddOth.setForeground(Color.WHITE);
		btnAddOth.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnAddOth.setBounds(356, 360, 117, 44);
		btnAddOth.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lblItemNameValueOth.setText(OthersBox.getSelectedItem().toString());

				String Item=lblItemNameValueOth.getText().toString();
				int price=obj_C_Menu.DisplayPrice(Item);
				System.out.println(price);
				String price_str=Integer.toString(price);
				lblItemPriceValueOth.setText(price_str);
				int qty=(Integer)QtySpinnerOth.getValue();
				int totalPrice=qty*price;
				TotalBill+=totalPrice;
				String total_price=Integer.toString(totalPrice);
				lblTotalPriceValueOth.setText(total_price);		
				
				array_itemPrice[arrayIndex]=lblItemPriceValueOth.getText();
				array_totalPrice[arrayIndex]=lblTotalPriceValueOth.getText();
				array_itemName[arrayIndex]=lblItemNameValueOth.getText();
				array_itemQty[arrayIndex]=QtySpinnerOth.getValue().toString();
				arrayIndex++;
				
			}
		});
		
		OthersMenuPanel.add(btnAddOth);
		
		JButton btnConfirm=new JButton("Confirm Order");
		btnConfirm.setBackground(Color.BLACK);
		btnConfirm.setForeground(Color.WHITE);
		btnConfirm.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnConfirm.setBounds(656, 360, 117, 44);
		btnConfirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DefaultTableModel tableModel = new DefaultTableModel();
		        tableModel.addColumn("Item Name");
		        tableModel.addColumn("Item Price");
		        tableModel.addColumn("Quantity");
		        tableModel.addColumn("Total Price");
		        for(int i=0; i<arrayIndex; i++) {
		        	System.out.println(array_itemName[i]);
					System.out.println(array_itemPrice[i]);
					System.out.println(array_itemQty[i]);
					System.out.println(array_totalPrice[i]);
		        	String itemName =array_itemName[i];
		            String itemPrice = array_itemPrice[i];
		            String quantity = array_itemQty[i];
		            String totalPrice = array_totalPrice[i];
		            tableModel.addRow(new Object[]{itemName, itemPrice, quantity, totalPrice});
		        }
		        
		        JTable OrderTable=new JTable(tableModel);
		        OrderTable.setBorder(new CompoundBorder(new LineBorder(new Color(171, 173, 179)), null));
				OrderTable.setToolTipText("");
				OrderTable.setFont(new Font("Calibri", Font.PLAIN, 16));
				scrollPane.setViewportView(OrderTable);
				
				String Total_Bill_Value=Integer.toString(TotalBill);
				lblTotalBillValue.setText(Total_Bill_Value);
			}
			
		});
			
		OthersMenuPanel.add(btnConfirm);
		contentPane.revalidate();
	}
	
}
