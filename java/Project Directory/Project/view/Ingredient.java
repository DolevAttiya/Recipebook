package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ingredient extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_5;
	private JTextField txtRecipebook;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;
	public int kashruth =0;
	public double Calories=0;
	public double Carbs=0;
	public double Fat=0;
	public double Protein=0;
	public int isFish=0;
	public int isStrawberries=0;
	public int isCoffie=0;
	public int isGluten=0;
	public int isLactose=0;
	public int isMilk=0;
	public int isEggs=0;
	public int isSeeds=0;
	public int isTreeNuts=0;
	public int isPeanut=0;
	public int isAcidity=0;
	public int isChocolate=0;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ingredient frame = new Ingredient();
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
	public Ingredient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1664, 1493);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 105, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//panelkavuaa
		JPanel panel = new JPanel();
		panel.setBounds(26, 15, 1603, 87);
		panel.setBackground(new Color(65, 105, 225));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAdd = new JButton("Go!");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchRes d=new SearchRes();
				d.setVisible(true);
				Ingredient.this.dispose();
				Ingredient.this.setVisible(false);
			}
		});
		btnAdd.setBounds(1016, 37, 71, 42);
		panel.add(btnAdd);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JTextPane txtpnUserDetails = new JTextPane();
		txtpnUserDetails.addMouseListener(new MouseAdapter() {
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
				Ingredient.this.dispose();
				Ingredient.this.setVisible(false);
			}
		});
		txtpnUserDetails.setBounds(1371, 7, 175, 82);
		panel.add(txtpnUserDetails);
		txtpnUserDetails.setForeground(new Color(255, 255, 255));
		txtpnUserDetails.setText("user details");
		txtpnUserDetails.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 28));
		txtpnUserDetails.setBackground(new Color(65, 105, 225));
		
		JTextPane txtpnAdvancedSearch_1 = new JTextPane();
		txtpnAdvancedSearch_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdvancedSearch f=new AdvancedSearch();
				f.setVisible(true);
				Ingredient.this.dispose();
				Ingredient.this.setVisible(false);
			}
		});
		txtpnAdvancedSearch_1.setText("Advanced Search");
		txtpnAdvancedSearch_1.setForeground(Color.WHITE);
		txtpnAdvancedSearch_1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 28));
		txtpnAdvancedSearch_1.setBackground(new Color(65, 105, 225));
		txtpnAdvancedSearch_1.setBounds(1146, 7, 215, 80);
		panel.add(txtpnAdvancedSearch_1);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 40));
		textField_5.setColumns(10);
		textField_5.setBounds(747, 37, 340, 43);
		panel.add(textField_5);
		
		JTextPane txtpnFavouriteRecipes = new JTextPane();
		txtpnFavouriteRecipes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MyFavourites f=new MyFavourites();
				f.setVisible(true);
				Ingredient.this.dispose();
				Ingredient.this.setVisible(false);
			}
		});
		txtpnFavouriteRecipes.setBounds(524, 7, 210, 87);
		panel.add(txtpnFavouriteRecipes);
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
		panel.add(txtpnSearch_1);
		
		JTextPane txtpnMyRecipes = new JTextPane();
		txtpnMyRecipes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MyRecipes f=new MyRecipes();
				f.setVisible(true);
				Ingredient.this.dispose();
				Ingredient.this.setVisible(false);
			}
		});
		txtpnMyRecipes.setText("My Recipes");
		txtpnMyRecipes.setForeground(Color.WHITE);
		txtpnMyRecipes.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 28));
		txtpnMyRecipes.setBackground(new Color(65, 105, 225));
		txtpnMyRecipes.setBounds(347, 7, 175, 80);
		panel.add(txtpnMyRecipes);
		
		JTextPane txtpnTaimli = new JTextPane();
		txtpnTaimli.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainPage f=new MainPage();
				f.setVisible(true);
				Ingredient.this.dispose();
				Ingredient.this.setVisible(false);
			}
		});
		txtpnTaimli.setText("Taimli");
		txtpnTaimli.setForeground(Color.WHITE);
		txtpnTaimli.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 80));
		txtpnTaimli.setBackground(new Color(65, 105, 225));
		txtpnTaimli.setBounds(0, -7, 343, 96);
		panel.add(txtpnTaimli);
		
		//panelkavuaa
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 248, 255));
		panel_1.setBounds(11, 106, 1610, 1299);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		String[] kashruthing = {"Parve", "Dairy", "Meat","Not Kosher"};
		JComboBox comboBox_1 = new JComboBox(kashruthing);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox comboBox_1 = (JComboBox)arg0.getSource();
		        kashruth = comboBox_1.getSelectedIndex();
			}
		});
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		comboBox_1.setBounds(277, 277, 442, 49);
		panel_1.add(comboBox_1);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 45));
		textField_7.setColumns(10);
		textField_7.setBounds(459, 200, 1043, 57);
		panel_1.add(textField_7);
		
		JTextPane txtpnAdvancedSearch = new JTextPane();
		txtpnAdvancedSearch.setText("Add an Ingredient");
		txtpnAdvancedSearch.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 80));
		txtpnAdvancedSearch.setBackground(new Color(240, 248, 255));
		txtpnAdvancedSearch.setBounds(340, 54, 944, 99);
		panel_1.add(txtpnAdvancedSearch);
		
		JButton btnSearch = new JButton("Add!");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myView.statview.addIngredient (textField_7.getText(), kashruth, isFish, isStrawberries, isCoffie, isGluten, isLactose, isMilk, isEggs, isSeeds, isTreeNuts, isPeanut, isAcidity, isChocolate, Calories, Carbs, Fat, Protein);
				Ingredient.this.dispose();
				Ingredient.this.setVisible(false);
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 50));
		btnSearch.setBounds(607, 1068, 326, 69);
		panel_1.add(btnSearch);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("per 100 grams");
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textPane.setBackground(new Color(240, 248, 255));
		textPane.setBounds(1092, 460, 160, 31);
		panel_1.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("Protein:");
		textPane_1.setFont(new Font("Tahoma", Font.PLAIN, 45));
		textPane_1.setBackground(new Color(240, 248, 255));
		textPane_1.setBounds(956, 670, 173, 61);
		panel_1.add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setText("Fat:");
		textPane_2.setFont(new Font("Tahoma", Font.PLAIN, 45));
		textPane_2.setBackground(new Color(240, 248, 255));
		textPane_2.setBounds(956, 615, 173, 61);
		panel_1.add(textPane_2);
		
		JTextPane txtpnCarbs = new JTextPane();
		txtpnCarbs.setText("Carbs:");
		txtpnCarbs.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnCarbs.setBackground(new Color(240, 248, 255));
		txtpnCarbs.setBounds(956, 552, 173, 61);
		panel_1.add(txtpnCarbs);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setText("Calories:");
		textPane_4.setFont(new Font("Tahoma", Font.PLAIN, 45));
		textPane_4.setBackground(new Color(240, 248, 255));
		textPane_4.setBounds(956, 493, 173, 61);
		panel_1.add(textPane_4);
		
		JTextPane textPane_5 = new JTextPane();
		textPane_5.setText("Nutrition Values:");
		textPane_5.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 52));
		textPane_5.setBackground(new Color(240, 248, 255));
		textPane_5.setBounds(1015, 404, 326, 58);
		panel_1.add(textPane_5);
		
		textField_2 = new JTextField();
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Calories= Double.parseDouble(textField_7.getText());
			}
		});
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_2.setColumns(10);
		textField_2.setBounds(1141, 505, 237, 49);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Carbs= Double.parseDouble(textField_3.getText());

			}
		});
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_3.setColumns(10);
		textField_3.setBounds(1141, 564, 237, 49);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Fat= Double.parseDouble(textField_4.getText());

			}
		});
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_4.setColumns(10);
		textField_4.setBounds(1141, 623, 237, 49);
		panel_1.add(textField_4);
		
		textField_6 = new JTextField();
		textField_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Protein= Double.parseDouble(textField_6.getText());
			}
		});
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_6.setColumns(10);
		textField_6.setBounds(1141, 682, 237, 49);
		panel_1.add(textField_6);
		
		JTextPane txtpnComponentName = new JTextPane();
		txtpnComponentName.setText("Component Name:");
		txtpnComponentName.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnComponentName.setBackground(new Color(240, 248, 255));
		txtpnComponentName.setBounds(58, 196, 433, 61);
		panel_1.add(txtpnComponentName);
		
		JTextPane txtpnCategory_1 = new JTextPane();
		txtpnCategory_1.setText("Kashruth:");
		txtpnCategory_1.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnCategory_1.setBackground(new Color(240, 248, 255));
		txtpnCategory_1.setBounds(58, 266, 214, 61);
		panel_1.add(txtpnCategory_1);
		
		JCheckBox checkBox = new JCheckBox("Gluten");
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(checkBox.isSelected()){  
					  isGluten=1;   } 
				 else {
					 isGluten=0;
				 }
			}
		});
		checkBox.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox.setBackground(new Color(240, 248, 255));
		checkBox.setBounds(109, 692, 255, 41);
		panel_1.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("Eggs");
		checkBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(checkBox_1.isSelected()){  
					  isEggs=1;   } 
				 else {
					 isEggs=0;
				 }
			}
		});
		checkBox_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_1.setBackground(new Color(240, 248, 255));
		checkBox_1.setBounds(375, 477, 243, 55);
		panel_1.add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("Food Acidity");
		checkBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(checkBox_2.isSelected()){  
					  isAcidity=1;   } 
				 else {
					 isAcidity=0;
				 }
			}
		});
		checkBox_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_2.setBackground(new Color(240, 248, 255));
		checkBox_2.setBounds(375, 765, 265, 41);
		panel_1.add(checkBox_2);
		
		JCheckBox checkBox_3 = new JCheckBox("Seeds");
		checkBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(checkBox_3.isSelected()){  
					  isSeeds=1;   } 
				 else {
					 isSeeds=0;
				 }
			}
		});
		checkBox_3.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_3.setBackground(new Color(240, 248, 255));
		checkBox_3.setBounds(375, 552, 243, 41);
		panel_1.add(checkBox_3);
		
		JCheckBox checkBox_4 = new JCheckBox("Lactose");
		checkBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(checkBox_4.isSelected()){  
					  isLactose=1;   } 
				 else {
					 isLactose=0;
				 }
			}
		});
		checkBox_4.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_4.setBackground(new Color(240, 248, 255));
		checkBox_4.setBounds(109, 765, 226, 41);
		panel_1.add(checkBox_4);
		
		JCheckBox checkBox_5 = new JCheckBox("Peanut");
		checkBox_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(checkBox_5.isSelected()){  
					  isPeanut=1;   } 
				 else {
					 isPeanut=0;
				 }
			}
		});
		checkBox_5.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_5.setBackground(new Color(240, 248, 255));
		checkBox_5.setBounds(375, 692, 192, 41);
		panel_1.add(checkBox_5);
		
		JCheckBox checkBox_6 = new JCheckBox("Chocolate");
		checkBox_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(checkBox_6.isSelected()){  
					  isChocolate=1;   } 
				 else {
					 isChocolate=0;
				 }
			}
		});
		checkBox_6.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_6.setBackground(new Color(240, 248, 255));
		checkBox_6.setBounds(375, 838, 243, 41);
		panel_1.add(checkBox_6);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setText("Allergies:");
		textPane_3.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 52));
		textPane_3.setBackground(new Color(240, 248, 255));
		textPane_3.setBounds(187, 404, 340, 72);
		panel_1.add(textPane_3);
		
		JCheckBox checkBox_7 = new JCheckBox("Tree Nuts");
		checkBox_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(checkBox_7.isSelected()){  
					  isTreeNuts=1;   } 
				 else {
					 isTreeNuts=0;
				 }
			}
		});
		checkBox_7.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_7.setBackground(new Color(240, 248, 255));
		checkBox_7.setBounds(375, 619, 231, 41);
		panel_1.add(checkBox_7);
		
		JCheckBox checkBox_8 = new JCheckBox("Strawberries");
		checkBox_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(checkBox_8.isSelected()){  
					  isStrawberries=1;   } 
				 else {
					 isStrawberries=0;
				 }
			}
		});
		checkBox_8.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_8.setBackground(new Color(240, 248, 255));
		checkBox_8.setBounds(109, 552, 269, 41);
		panel_1.add(checkBox_8);
		
		JCheckBox checkBox_9 = new JCheckBox("Coffie");
		checkBox_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(checkBox_9.isSelected()){  
					  isCoffie=1;   } 
				 else {
					 isCoffie=0;
				 }
			}
		});
		checkBox_9.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_9.setBackground(new Color(240, 248, 255));
		checkBox_9.setBounds(109, 619, 269, 41);
		panel_1.add(checkBox_9);
		
		JCheckBox checkBox_10 = new JCheckBox("Dairy");
		checkBox_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(checkBox_10.isSelected()){  
					  isMilk=1;   } 
				 else {
					 isMilk=0;
				 }
			}
		});
		checkBox_10.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_10.setBackground(new Color(240, 248, 255));
		checkBox_10.setBounds(109, 838, 226, 41);
		panel_1.add(checkBox_10);
		
		JCheckBox checkBox_11 = new JCheckBox("Fish");
		checkBox_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 if(checkBox_11.isSelected()){  
					  isFish=1;   } 
				 else {
					  isFish=0;
				 }
			}
		});
		checkBox_11.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_11.setBackground(new Color(240, 248, 255));
		checkBox_11.setBounds(109, 484, 269, 41);
		panel_1.add(checkBox_11);
	}
}