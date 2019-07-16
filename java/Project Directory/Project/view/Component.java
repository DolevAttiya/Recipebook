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

public class Component extends JFrame {

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
	public int isCup=0;
	public int isSpoon=0;
	public int isMililiter=0;
	public int isGram=0;
	public int Calories=0;
	public int Carbs=0;
	public int Fat=0;
	public int Protein=0;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Component frame = new Component();
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
	public Component() {
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
				Component.this.dispose();
				Component.this.setVisible(false);
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
				Component.this.dispose();
				Component.this.setVisible(false);
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
				Component.this.dispose();
				Component.this.setVisible(false);
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
				Component.this.dispose();
				Component.this.setVisible(false);
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
				Component.this.dispose();
				Component.this.setVisible(false);
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
				Component.this.dispose();
				Component.this.setVisible(false);
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
		
		String[] kashruthing = {"Parve", "Dairy", "Meat","Not Kosher","Kosher"};
		JComboBox comboBox_1 = new JComboBox(kashruthing);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox comboBox_1 = (JComboBox)arg0.getSource();
		        String kashruth = (String)comboBox_1.getSelectedItem();
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
				//public void addIngredient (String ingredientName, Integer catagory,  Integer isCup, Integer isSpoon, Integer isMililiter, Integer isGram, Double calories, Double carbohydrate, Double fat, Double protein, Integer kashruth);
				//addIngredient (textField_7.getText(), kashruth,  isCup, isSpoon, isMililiter, isGram, Calories, Carbs, Fat, Protein );
				Component.this.dispose();
				Component.this.setVisible(false);
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 50));
		btnSearch.setBounds(607, 1068, 326, 69);
		panel_1.add(btnSearch);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("per 100 grams");
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textPane.setBackground(new Color(240, 248, 255));
		textPane.setBounds(1180, 460, 160, 31);
		panel_1.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("Protein:");
		textPane_1.setFont(new Font("Tahoma", Font.PLAIN, 45));
		textPane_1.setBackground(new Color(240, 248, 255));
		textPane_1.setBounds(1044, 670, 173, 61);
		panel_1.add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setText("Fat:");
		textPane_2.setFont(new Font("Tahoma", Font.PLAIN, 45));
		textPane_2.setBackground(new Color(240, 248, 255));
		textPane_2.setBounds(1044, 615, 173, 61);
		panel_1.add(textPane_2);
		
		JTextPane txtpnCarbs = new JTextPane();
		txtpnCarbs.setText("Carbs:");
		txtpnCarbs.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnCarbs.setBackground(new Color(240, 248, 255));
		txtpnCarbs.setBounds(1044, 552, 173, 61);
		panel_1.add(txtpnCarbs);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setText("Calories:");
		textPane_4.setFont(new Font("Tahoma", Font.PLAIN, 45));
		textPane_4.setBackground(new Color(240, 248, 255));
		textPane_4.setBounds(1044, 493, 173, 61);
		panel_1.add(textPane_4);
		
		JTextPane textPane_5 = new JTextPane();
		textPane_5.setText("Nutrition Values:");
		textPane_5.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 52));
		textPane_5.setBackground(new Color(240, 248, 255));
		textPane_5.setBounds(1103, 404, 326, 58);
		panel_1.add(textPane_5);
		
		textField_2 = new JTextField();
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Calories= Double.parseDouble(textField_7.getText());
			}
		});
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_2.setColumns(10);
		textField_2.setBounds(1229, 505, 237, 49);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Carbs= Double.parseDouble(textField_3.getText());

			}
		});
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_3.setColumns(10);
		textField_3.setBounds(1229, 564, 237, 49);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Fat= Double.parseDouble(textField_4.getText());

			}
		});
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_4.setColumns(10);
		textField_4.setBounds(1229, 623, 237, 49);
		panel_1.add(textField_4);
		
		textField_6 = new JTextField();
		textField_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Protein= Double.parseDouble(textField_6.getText());
			}
		});
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_6.setColumns(10);
		textField_6.setBounds(1229, 682, 237, 49);
		panel_1.add(textField_6);
		
		JTextPane txtpnMes = new JTextPane();
		txtpnMes.setText("Measuring Types:");
		txtpnMes.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 52));
		txtpnMes.setBackground(new Color(240, 248, 255));
		txtpnMes.setBounds(60, 404, 678, 88);
		panel_1.add(txtpnMes);
		
		JCheckBox chckbxCup = new JCheckBox("Cup");
		chckbxCup.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent e) {
				 if(chckbxCup.isSelected()){  
					  isCup=1;   } 
				 else {
					  isCup=0;
				 }
			}
		});
		chckbxCup.setFont(new Font("Tahoma", Font.PLAIN, 45));
		chckbxCup.setBackground(new Color(240, 248, 255));
		chckbxCup.setBounds(58, 487, 697, 64);
		panel_1.add(chckbxCup);
		
		JCheckBox chckbxSpoon_1 = new JCheckBox("Spoon");
		chckbxSpoon_1.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent g) {
				 if(chckbxSpoon_1.isSelected()){  
					  isSpoon=1;   } 
				 else {
					  isSpoon=0;
				 }
			}
		});
		chckbxSpoon_1.setFont(new Font("Tahoma", Font.PLAIN, 45));
		chckbxSpoon_1.setBackground(new Color(240, 248, 255));
		chckbxSpoon_1.setBounds(58, 547, 697, 64);
		panel_1.add(chckbxSpoon_1);
		
		JCheckBox chckbxGrams_1 = new JCheckBox("Grams");
		chckbxGrams_1.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent h) {
				 if(chckbxGrams_1.isSelected()){  
					  isGram=1;   } 
				 else {
					  isGram=0;
				 }
			}
		});
		chckbxGrams_1.setFont(new Font("Tahoma", Font.PLAIN, 45));
		chckbxGrams_1.setBackground(new Color(240, 248, 255));
		chckbxGrams_1.setBounds(58, 607, 697, 64);
		panel_1.add(chckbxGrams_1);
		
		JCheckBox chckbxMililiter = new JCheckBox("Mililiter");
		chckbxMililiter.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent i) {
				 if(chckbxMililiter.isSelected()){  
					  isMililiter=1;   } 
				 else {
					 isMililiter=0;
				 }
			}
		});
		chckbxMililiter.setFont(new Font("Tahoma", Font.PLAIN, 45));
		chckbxMililiter.setBackground(new Color(240, 248, 255));
		chckbxMililiter.setBounds(58, 667, 697, 64);
		panel_1.add(chckbxMililiter);
		
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
	}
}