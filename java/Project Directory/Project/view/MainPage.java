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
import javax.swing.JOptionPane;
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
		setSize(1000, 700);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 105, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
				JPanel panel_7 = new JPanel();
				panel_7.setBounds(475, 461, 495, 173);
				contentPane.add(panel_7);
				panel_7.setLayout(null);
				panel_7.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
				panel_7.setBackground(new Color(240, 248, 255));
				
						JTextPane txtpnAddNewRecipe_1 = new JTextPane();
						txtpnAddNewRecipe_1.setEditable(false);
						txtpnAddNewRecipe_1.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								myView.statview.initializeRecipe();
								NewRecipe a=new NewRecipe();
								a.setVisible(true);
								MainPage.this.dispose();
								MainPage.this.setVisible(false);
							}
						});
						txtpnAddNewRecipe_1.setText("Add New Recipe");
						txtpnAddNewRecipe_1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 30));
						txtpnAddNewRecipe_1.setBackground(new Color(240, 248, 255));
						txtpnAddNewRecipe_1.setBounds(93, 66, 316, 45);
						panel_7.add(txtpnAddNewRecipe_1);


		JPanel panel = new JPanel();
		panel.setBounds(10, 60, 971, 586);
		panel.setBackground(new Color(240, 248, 255));
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		panel_3.setBackground(new Color(240, 248, 255));
		panel_3.setBounds(10, 61, 452, 514);
		panel.add(panel_3);

		String[] columnNames = {"Recipe Name",
				"Description",
		"Rate"}; 
		Object[][] data = new Object[myView.recipeTop10Array.size()][3];
		for(int row=0;row<myView.recipeTop10Array.size();row++) {
			data[row][0]=myView.recipeTop10Array.get(row).getRecipeName();
			data[row][1]=myView.recipeTop10Array.get(row).getRecipeDescription();
			data[row][2]=myView.recipeTop10Array.get(row).getRecipeRate();
		}
		JTable table = new JTable(data, columnNames);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setRowHeight(80);
		JTableHeader th = table.getTableHeader();
		th.setPreferredSize(new Dimension(100, 30));
		Font bigFont = new Font("Tahoma", Font.PLAIN, 12);
		table.getTableHeader().setFont(bigFont);

		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		scrollPane.setSize(432, 450);
		scrollPane.setLocation(10, 53);
		//TableColumn column = null;
		panel_3.add(scrollPane);

		JTextPane txtpnTopTen = new JTextPane();
		txtpnTopTen.setEditable(false);
		txtpnTopTen.setText("Top Ten!!");
		txtpnTopTen.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 30));
		txtpnTopTen.setBackground(new Color(240, 248, 255));
		txtpnTopTen.setBounds(140, 11, 180, 44);
		panel_3.add(txtpnTopTen);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		panel_2.setBounds(466, 61, 495, 158);
		panel.add(panel_2);
		panel_2.setBackground(new Color(240, 248, 255));
		panel_2.setLayout(null);

		JTextPane txtpnSearch = new JTextPane();
		txtpnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Reports d=new Reports();
				d.setVisible(true);
				MainPage.this.dispose();
				MainPage.this.setVisible(false);
			}
		});
		txtpnSearch.setEditable(false);
		txtpnSearch.setBounds(158, 54, 160, 44);
		panel_2.add(txtpnSearch);
		txtpnSearch.setBackground(new Color(240, 248, 255));
		txtpnSearch.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 30));
		txtpnSearch.setText("Reports");

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		panel_6.setBackground(new Color(240, 248, 255));
		panel_6.setBounds(466, 224, 495, 173);
		panel.add(panel_6);

		JTextPane txtpnAllRecipies = new JTextPane();
		txtpnAllRecipies.setEditable(false);
		txtpnAllRecipies.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myView.statview.getAllRecipes();
				SearchRes d=new SearchRes();
				d.setVisible(true);
				MainPage.this.dispose();
				MainPage.this.setVisible(false);
			}
		});
		txtpnAllRecipies.setText("All Recipies");
		txtpnAllRecipies.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 30));
		txtpnAllRecipies.setBackground(new Color(240, 248, 255));
		txtpnAllRecipies.setBounds(127, 57, 234, 52);
		panel_6.add(txtpnAllRecipies);

		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setText("Welcome To Taimli !");
		textPane.setForeground(new Color(0, 0, 0));
		textPane.setFont(new Font("Tempus Sans ITC", Font.BOLD, 50));
		textPane.setBackground(new Color(240, 248, 255));
		textPane.setBounds(226, 0, 745, 66);
		panel.add(textPane);

		//panel upper
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 994, 59);
		panel_1.setBackground(new Color(65, 105, 225));
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		textField = new JTextField();
		textField.setBounds(518, 36, 163, 21);
		panel_1.add(textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setColumns(10);

		JTextPane textPane_5 = new JTextPane();
		textPane_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainPage b=new MainPage();
				b.setVisible(true);
				MainPage.this.dispose();
				MainPage.this.setVisible(false);
			}
		});
		textPane_5.setBounds(0, 0, 204, 57);
		panel_1.add(textPane_5);
		textPane_5.setText("Taimli");
		textPane_5.setForeground(Color.WHITE);
		textPane_5.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 50));
		textPane_5.setEditable(false);
		textPane_5.setBackground(new Color(65, 105, 225));

		JTextPane textPane1 = new JTextPane();
		textPane1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (myView.myUser!=null) {
					User f=new User();
					f.setVisible(true);
				}
				else {
					Dietican f=new Dietican();
					f.setVisible(true);
				}
				MainPage.this.dispose();
				MainPage.this.setVisible(false);
			}
		});
		textPane1.setBounds(882, 8, 102, 49);
		panel_1.add(textPane1);
		textPane1.setText("user details");
		textPane1.setForeground(Color.WHITE);
		textPane1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
		textPane1.setEditable(false);
		textPane1.setBackground(new Color(65, 105, 225));

		JTextPane textPane_1 = new JTextPane();
		textPane_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdvancedSearch d=new AdvancedSearch();
				d.setVisible(true);
				MainPage.this.dispose();
				MainPage.this.setVisible(false);
			}
		});
		textPane_1.setBounds(746, 8, 126, 50);
		panel_1.add(textPane_1);
		textPane_1.setText("Advanced Search");
		textPane_1.setForeground(Color.WHITE);
		textPane_1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
		textPane_1.setEditable(false);
		textPane_1.setBackground(new Color(65, 105, 225));

		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(582, 11, 92, 29);
		panel_1.add(textPane_3);
		textPane_3.setText("Search");
		textPane_3.setForeground(Color.WHITE);
		textPane_3.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
		textPane_3.setEditable(false);
		textPane_3.setBackground(new Color(65, 105, 225));

		JButton button = new JButton("Go!");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myView.statview.mainSearch(textField.getText());  
				if (myView.check==false) {
					JOptionPane.showMessageDialog(null,"There is no match to your search, Please try again");
				}
				else {
					SearchRes d=new SearchRes();
					d.setVisible(true);
					MainPage.this.dispose();
					MainPage.this.setVisible(false);
				}
			}
		});
		button.setBounds(682, 36, 47, 21);
		panel_1.add(button);
		button.setFont(new Font("Tahoma", Font.BOLD, 5));

		JTextPane textPane_2 = new JTextPane();
		textPane_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myView.statview.myFavorite();
				MyFavourites d=new MyFavourites();
				d.setVisible(true);
				MainPage.this.dispose();
				MainPage.this.setVisible(false);
			}
		});
		textPane_2.setBounds(385, 8, 132, 49);
		panel_1.add(textPane_2);
		textPane_2.setText("Favourite Recipes");
		textPane_2.setForeground(Color.WHITE);
		textPane_2.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
		textPane_2.setEditable(false);
		textPane_2.setBackground(new Color(65, 105, 225));

		JTextPane textPane_4 = new JTextPane();
		textPane_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myView.statview.myRecipes();
				MyRecipes c=new MyRecipes();
				c.setVisible(true);
				MainPage.this.dispose();
				MainPage.this.setVisible(false);
			}
		});
		textPane_4.setBounds(242, 8, 107, 49);
		panel_1.add(textPane_4);
		textPane_4.setText("My Recipes");
		textPane_4.setForeground(Color.WHITE);
		textPane_4.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
		textPane_4.setEditable(false);
		textPane_4.setBackground(new Color(65, 105, 225));

	}	
}		


