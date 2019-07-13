package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MainPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
					frame.setVisible(true);
					frame.setTitle("Taimli!");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	public void close() {
		WindowEvent winClosingEvent= new WindowEvent (this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);}

	/**
	 * Create the frame.
	 */
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1664, 1493);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 105, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JPanel panel = new JPanel();
		panel.setBounds(11, 106, 1610, 1299);
		panel.setBackground(new Color(240, 248, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		panel_3.setBackground(new Color(240, 248, 255));
		panel_3.setBounds(26, 162, 848, 1077);
		panel.add(panel_3);
		
		String[] columnNames = {"Recipe Name",
                "Description",
                "Rate"}; 
		Object[][] data = {
			    {"Kathy", "Smith",
			     "Snowboarding"},
			    {"John", "Doe",
			     "Rowing"},
			    {"Sue", "Black",
			     "Knitting"},
			    {"Jane", "White",
			     "Speed reading"},
			    {"Joe", "Brown",
			     "Pool"},
			    {"Joe", "Brown",
				     "Pool"},
			    {"Joe", "Brown",
				     "Pool"},
			    {"Joe", "Brown",
				     "Pool"},
			    {"Joe", "Brown",
				     "Pool"},
			    {"Joe", "Brown",
				     "Pool"}
			};
		
		JTable table = new JTable(data, columnNames);
		table.setFont(new Font("Tahoma", Font.PLAIN, 30));
		table.setRowHeight(80);
		JTableHeader th = table.getTableHeader();
		th.setPreferredSize(new Dimension(100, 100));
		Font bigFont = new Font("Tahoma", Font.PLAIN, 32);
		table.getTableHeader().setFont(bigFont);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		scrollPane.setSize(796, 900);
		scrollPane.setLocation(26, 108);
		//TableColumn column = null;
		panel_3.add(scrollPane);
		
		JTextPane txtpnTopTen = new JTextPane();
		txtpnTopTen.setText("Top Ten!!");
		txtpnTopTen.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 70));
		txtpnTopTen.setBackground(new Color(240, 248, 255));
		txtpnTopTen.setBounds(232, 16, 529, 139);
		panel_3.add(txtpnTopTen);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		panel_2.setBounds(886, 162, 698, 351);
		panel.add(panel_2);
		panel_2.setBackground(new Color(240, 248, 255));
		panel_2.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField.setBounds(40, 142, 632, 70);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JTextPane txtpnSearch = new JTextPane();
		txtpnSearch.setBounds(68, 41, 593, 139);
		panel_2.add(txtpnSearch);
		txtpnSearch.setBackground(new Color(240, 248, 255));
		txtpnSearch.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 60));
		txtpnSearch.setText("Search a Recipe");
		
		JButton btnNewButton = new JButton("Advanced Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent v) {
				AdvancedSearch a=new AdvancedSearch();
				a.setVisible(true);
				MainPage.this.dispose();
				MainPage.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(202, 235, 310, 45);
		panel_2.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		panel_6.setBackground(new Color(240, 248, 255));
		panel_6.setBounds(886, 524, 698, 351);
		panel.add(panel_6);
		
		JTextPane txtpnAllRecipies = new JTextPane();
		txtpnAllRecipies.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SearchRes d=new SearchRes();
				d.setVisible(true);
				MainPage.this.dispose();
				MainPage.this.setVisible(false);
			}
		});
		txtpnAllRecipies.setText("All Recipies");
		txtpnAllRecipies.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 60));
		txtpnAllRecipies.setBackground(new Color(240, 248, 255));
		txtpnAllRecipies.setBounds(129, 119, 529, 139);
		panel_6.add(txtpnAllRecipies);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		panel_7.setBackground(new Color(240, 248, 255));
		panel_7.setBounds(886, 888, 698, 351);
		panel.add(panel_7);
		
		JTextPane txtpnAddNewRecipe_1 = new JTextPane();
		txtpnAddNewRecipe_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NewRecipe a=new NewRecipe();
				a.setVisible(true);
				MainPage.this.dispose();
				MainPage.this.setVisible(false);
			}
		});
		txtpnAddNewRecipe_1.setText("Add New Recipe");
		txtpnAddNewRecipe_1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 60));
		txtpnAddNewRecipe_1.setBackground(new Color(240, 248, 255));
		txtpnAddNewRecipe_1.setBounds(53, 124, 630, 139);
		panel_7.add(txtpnAddNewRecipe_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("Welcome To Taimli !");
		textPane.setForeground(new Color(0, 0, 0));
		textPane.setFont(new Font("Tempus Sans ITC", Font.BOLD, 99));
		textPane.setBackground(new Color(240, 248, 255));
		textPane.setBounds(286, 28, 1028, 160);
		panel.add(textPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(26, 15, 1603, 87);
		panel_1.setBackground(new Color(65, 105, 225));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JTextPane txtpnUserDetails = new JTextPane();
		txtpnUserDetails.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				User f=new User();
				f.setVisible(true);
				MainPage.this.dispose();
				MainPage.this.setVisible(false);
			}
		});
		txtpnUserDetails.setBounds(1371, 7, 175, 82);
		panel_1.add(txtpnUserDetails);
		txtpnUserDetails.setForeground(new Color(255, 255, 255));
		txtpnUserDetails.setText("user details");
		txtpnUserDetails.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 28));
		txtpnUserDetails.setBackground(new Color(65, 105, 225));
		
		JTextPane txtpnAdvancedSearch_1 = new JTextPane();
		txtpnAdvancedSearch_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdvancedSearch d=new AdvancedSearch();
				d.setVisible(true);
				MainPage.this.dispose();
				MainPage.this.setVisible(false);
			}
		});
		txtpnAdvancedSearch_1.setText("Advanced Search");
		txtpnAdvancedSearch_1.setForeground(Color.WHITE);
		txtpnAdvancedSearch_1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 28));
		txtpnAdvancedSearch_1.setBackground(new Color(65, 105, 225));
		txtpnAdvancedSearch_1.setBounds(1146, 7, 215, 80);
		panel_1.add(txtpnAdvancedSearch_1);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 40));
		textField_5.setColumns(10);
		textField_5.setBounds(747, 37, 340, 43);
		panel_1.add(textField_5);
		
		JTextPane txtpnFavouriteRecipes = new JTextPane();
		txtpnFavouriteRecipes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MyFavourites d=new MyFavourites();
				d.setVisible(true);
				MainPage.this.dispose();
				MainPage.this.setVisible(false);
			}
		});

		txtpnFavouriteRecipes.setBounds(524, 7, 210, 87);
		panel_1.add(txtpnFavouriteRecipes);
		txtpnFavouriteRecipes.setText("Favourite Recipes");
		txtpnFavouriteRecipes.setForeground(Color.WHITE);
		txtpnFavouriteRecipes.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 28));
		txtpnFavouriteRecipes.setBackground(new Color(65, 105, 225));
		
		JTextPane txtpnSearch_1 = new JTextPane();
		txtpnSearch_1.setText("Search");
		txtpnSearch_1.setForeground(Color.WHITE);
		txtpnSearch_1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 28));
		txtpnSearch_1.setBackground(new Color(65, 105, 225));
		txtpnSearch_1.setBounds(844, 0, 146, 42);
		panel_1.add(txtpnSearch_1);
		
		JTextPane txtpnMyRecipes = new JTextPane();
		txtpnMyRecipes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MyRecipes c=new MyRecipes();
				c.setVisible(true);
				MainPage.this.dispose();
				MainPage.this.setVisible(false);
			}
		});
		txtpnMyRecipes.setText("My Recipes");
		txtpnMyRecipes.setForeground(Color.WHITE);
		txtpnMyRecipes.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 28));
		txtpnMyRecipes.setBackground(new Color(65, 105, 225));
		txtpnMyRecipes.setBounds(347, 7, 175, 80);
		panel_1.add(txtpnMyRecipes);
		
		JTextPane txtpnTaimli = new JTextPane();
		txtpnTaimli.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MainPage b=new MainPage();
				b.setVisible(true);
				MainPage.this.dispose();
				MainPage.this.setVisible(false);
			}
		});
		
		
		txtpnTaimli.setText("Taimli");
		txtpnTaimli.setForeground(Color.WHITE);
		txtpnTaimli.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 80));
		txtpnTaimli.setBackground(new Color(65, 105, 225));
		txtpnTaimli.setBounds(0, -7, 343, 96);
		panel_1.add(txtpnTaimli);
	}	
}		
		

