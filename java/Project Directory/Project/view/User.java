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

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JEditorPane;

import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import java.awt.Choice;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class User extends JFrame {

	private JPanel contentPane;
	private JPanel contentPane_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_7;
	private JTextField textField_4;
	public boolean userKosher=false;
	public boolean userAllergy=false; 

	//allergies:
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
		public int isKosher=0;
		public int isAller=0;		

		


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User frame = new User();
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
	public User() {
		setSize(1664, 1493);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
		contentPane = new JPanel();
		contentPane_1 = new JPanel();
		contentPane_1.setBackground(new Color(65, 105, 225));
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_1);
		contentPane_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(26, 15, 1603, 87);
		panel.setBackground(new Color(65, 105, 225));
		contentPane_1.add(panel);
		panel.setLayout(null);
		
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
				User.this.dispose();
				User.this.setVisible(false);
			}
		});
		
		JButton btnAdd = new JButton("Go!");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchRes d=new SearchRes();
				d.setVisible(true);
				User.this.dispose();
				User.this.setVisible(false);
			}
		});
		btnAdd.setBounds(1016, 37, 71, 42);
		panel.add(btnAdd);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		
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
				User.this.dispose();
				User.this.setVisible(false);
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
				User.this.dispose();
				User.this.setVisible(false);
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
				User.this.dispose();
				User.this.setVisible(false);
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
				User.this.dispose();
				User.this.setVisible(false);
			}
		});
		txtpnTaimli.setText("Taimli");
		txtpnTaimli.setForeground(Color.WHITE);
		txtpnTaimli.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 80));
		txtpnTaimli.setBackground(new Color(65, 105, 225));
		txtpnTaimli.setBounds(0, -7, 343, 96);
		panel.add(txtpnTaimli);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 248, 255));
		panel_1.setBounds(11, 106, 1610, 1299);
		contentPane_1.add(panel_1);
		panel_1.setLayout(null);
		
		String[] days = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		JComboBox comboBox = new JComboBox(days);
		comboBox.setEnabled(false);
		comboBox.setSelectedItem("16"); /*myView.myUser.getPersonDateOfBirth().getDayOfMonth()*/
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox comboBox = (JComboBox)arg0.getSource();
		        String days = (String)comboBox.getSelectedItem();
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 40));
		comboBox.setBounds(357, 620, 105, 49);
		panel_1.add(comboBox);		
	
		String[] months = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
		JComboBox comboBox_3 = new JComboBox(months);
		comboBox_3.setEnabled(false);
		comboBox_3.setSelectedItem("11");/*myView.myUser.getPersonDateOfBirth().getMonth()*/
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox comboBox_3 = (JComboBox)arg0.getSource();
		        String months = (String)comboBox.getSelectedItem();
			}
		});
		comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 40));
		comboBox_3.setBounds(469, 620, 105, 49);
		panel_1.add(comboBox_3);
		
		textField_7 = new JTextField(/*myView.myUser.getPersonHashPass()*/);
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 40));
		textField_7.setColumns(10);
		textField_7.setBounds(588, 520, 421, 49);
		panel_1.add(textField_7);
		
		
		textField_2 = new JTextField(/*myView.myUser.getPersonHashPass()*/);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		textField_2.setColumns(10);
		textField_2.setBounds(588, 461, 421, 49);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField(/*myView.myUser.getPersonEmail()*/);
		textField_3.setEditable(false);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 40));
		textField_3.setColumns(10);
		textField_3.setBounds(205, 337, 804, 49);
		panel_1.add(textField_3);
		
		textField_6 = new JTextField(/*myView.myUser.getPersonLastName()*/);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 40));
		textField_6.setColumns(10);
		textField_6.setBounds(316, 254, 693, 49);
		panel_1.add(textField_6);
		
		JCheckBox chckbxSeeds = new JCheckBox("Seeds");
		chckbxSeeds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 isSeeds=myView.myUser.getUserAllergen()[7];
					if (isSeeds>0) {
						chckbxSeeds.isSelected();
					}
			}
		});
		chckbxSeeds.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxSeeds.setBackground(new Color(240, 248, 255));
		chckbxSeeds.setBounds(1311, 334, 281, 41);
		panel_1.add(chckbxSeeds);
		
		JCheckBox chckbxFish = new JCheckBox("Strawberries");
		chckbxFish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 isStrawberries=myView.myUser.getUserAllergen()[1];
					if (isStrawberries>0) {
						chckbxFish.isSelected();
					}
			}
		});
		chckbxFish.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxFish.setBackground(new Color(240, 248, 255));
		chckbxFish.setBounds(1031, 334, 281, 41);
		panel_1.add(chckbxFish);
		setVisible(true);
		
		JCheckBox chckbxPeanut = new JCheckBox("Peanut");
		chckbxPeanut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isPeanut=myView.myUser.getUserAllergen()[9];
					if (isPeanut>0) {
						chckbxPeanut.isSelected();
					}
			}
		});
		chckbxPeanut.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxPeanut.setBackground(new Color(240, 248, 255));
		chckbxPeanut.setBounds(1311, 474, 281, 41);
		panel_1.add(chckbxPeanut);
		
		JCheckBox chckbxTreeNuts = new JCheckBox("Tree Nuts");
		chckbxTreeNuts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 isTreeNuts=myView.myUser.getUserAllergen()[8];
					if (isTreeNuts>0) {
						chckbxTreeNuts.isSelected();
					}
			}
		});
		chckbxTreeNuts.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxTreeNuts.setBackground(new Color(240, 248, 255));
		chckbxTreeNuts.setBounds(1311, 401, 281, 41);
		panel_1.add(chckbxTreeNuts);
		
		JCheckBox chckbxEggs = new JCheckBox("Eggs");
		chckbxEggs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 isEggs=myView.myUser.getUserAllergen()[6];
					if (isEggs>0) {
						chckbxEggs.isSelected();
					}
			}
		});
		chckbxEggs.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxEggs.setBackground(new Color(240, 248, 255));
		chckbxEggs.setBounds(1311, 259, 281, 55);
		panel_1.add(chckbxEggs);
		
		textField_1 = new JTextField(/*myView.myUser.getPersonFirstName()*/);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		textField_1.setColumns(10);
		textField_1.setBounds(316, 183, 693, 49);
		panel_1.add(textField_1);
		
		JTextPane txtpnSearchFor = new JTextPane();
		txtpnSearchFor.setText("First Name:");
		txtpnSearchFor.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnSearchFor.setBackground(new Color(240, 248, 255));
		txtpnSearchFor.setBounds(69, 178, 237, 63);
		panel_1.add(txtpnSearchFor);
		
		JTextPane txtpnRecipeId = new JTextPane();
		txtpnRecipeId.setText("Last Name:");
		txtpnRecipeId.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnRecipeId.setBackground(new Color(240, 248, 255));
		txtpnRecipeId.setBounds(69, 247, 237, 83);
		panel_1.add(txtpnRecipeId);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Show only Kosher Recipies");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userKosher=myView.myUser.getUserKashruth();
				if (userKosher==true) {
					chckbxNewCheckBox.setSelected(true);
					isKosher=1;
				}
				else {
					chckbxNewCheckBox.setSelected(false);
					isKosher=0;
				}
			}
		});
		chckbxNewCheckBox.setBackground(new Color(240, 248, 255));
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 45));
		chckbxNewCheckBox.setBounds(67, 713, 697, 64);
		panel_1.add(chckbxNewCheckBox);
		
		JTextPane txtpnAdvancedSearch = new JTextPane();
		txtpnAdvancedSearch.setText("User Details");
		txtpnAdvancedSearch.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 80));
		txtpnAdvancedSearch.setBackground(new Color(240, 248, 255));
		txtpnAdvancedSearch.setBounds(507, 55, 644, 99);
		panel_1.add(txtpnAdvancedSearch);
		
		JCheckBox chckbxDairy = new JCheckBox("Fish");
		chckbxDairy.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent h) {
				 isFish=myView.myUser.getUserAllergen()[0];
					if (isFish>0) {
						chckbxDairy.isSelected();
					}
			}
		});
		chckbxDairy.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxDairy.setBackground(new Color(240, 248, 255));
		chckbxDairy.setBounds(1031, 266, 262, 41);
		panel_1.add(chckbxDairy);
		
		JTextPane txtpnAllergies = new JTextPane();
		txtpnAllergies.setText("Allergies:");
		txtpnAllergies.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 52));
		txtpnAllergies.setBackground(new Color(240, 248, 255));
		txtpnAllergies.setBounds(1133, 183, 340, 72);
		panel_1.add(txtpnAllergies);
		
		JCheckBox chckbxG = new JCheckBox("Coffie");
		chckbxG.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent g) {
				 isCoffie=myView.myUser.getUserAllergen()[2];
					if (isCoffie>0) {
						chckbxG.isSelected();
					}
			}
		});
		chckbxG.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxG.setBackground(new Color(240, 248, 255));
		chckbxG.setBounds(1031, 401, 262, 41);
		panel_1.add(chckbxG);
		
		JCheckBox chckbxNon = new JCheckBox("Gluten");
		chckbxNon.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent f) {
				 isGluten=myView.myUser.getUserAllergen()[3];
					if (isGluten>0) {
						chckbxNon.isSelected();
					}
			}
		});
		chckbxNon.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxNon.setBackground(new Color(240, 248, 255));
		chckbxNon.setBounds(1031, 474, 255, 41);
		panel_1.add(chckbxNon);
		
		JButton btnSearch = new JButton("Update!");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((textField_1.getText().trim().isEmpty())||(textField_6.getText().trim().isEmpty())||(textField_3.getText().trim().isEmpty())||(textField_2.getText().trim().isEmpty())||(textField_7.getText().trim().isEmpty())||(textField_4.getText().trim().isEmpty())) {
					JOptionPane.showMessageDialog(null,"One of the parameters is empty, Please fill all");
				}
						
				else {
					myView.statview.userUpdate(textField_1.getText(), textField_6.getText(), textField_3.getText(), textField_2.getText(), textField_7.getText(), myView.myUser.getPersonDateOfBirth().toString(), isKosher, isFish, isStrawberries, isCoffie, isGluten, isLactose, isMilk, isEggs, isSeeds, isTreeNuts, isPeanut, isAcidity, isChocolate ,isAller);
					MainPage f=new MainPage();
					f.setVisible(true);
					User.this.dispose();
					User.this.setVisible(false);
					}
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 50));
		btnSearch.setBounds(607, 1068, 326, 69);
		panel_1.add(btnSearch);
		
		JTextPane txtpnEmail = new JTextPane();
		txtpnEmail.setText("Email:");
		txtpnEmail.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnEmail.setBackground(new Color(240, 248, 255));
		txtpnEmail.setBounds(69, 337, 129, 69);
		panel_1.add(txtpnEmail);
		JTextPane txtpnEnterPasswordAgain = new JTextPane();
		txtpnEnterPasswordAgain.setText("Enter Password Again:");
		txtpnEnterPasswordAgain.setFont(new Font("Tahoma", Font.PLAIN, 40));
		txtpnEnterPasswordAgain.setBackground(new Color(240, 248, 255));
		txtpnEnterPasswordAgain.setBounds(69, 520, 462, 63);
		panel_1.add(txtpnEnterPasswordAgain);
		
		JCheckBox chckbxShowOnlyRecipes = new JCheckBox("Show only Recipes adapted to Alergies");
		//chckbxShowOnlyRecipes.setSelected(true);
		chckbxShowOnlyRecipes.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent d) {
				 userAllergy=myView.myUser.getUserAllergens();
				if (userAllergy==true) {
					chckbxShowOnlyRecipes.setSelected(true);
					isAller=1;
				}
				else {
					chckbxShowOnlyRecipes.setSelected(false);
					isAller=0;
				}
			}
		});
		chckbxShowOnlyRecipes.setFont(new Font("Tahoma", Font.PLAIN, 45));
		chckbxShowOnlyRecipes.setBackground(new Color(240, 248, 255));
		chckbxShowOnlyRecipes.setBounds(67, 797, 866, 69);
		panel_1.add(chckbxShowOnlyRecipes);
		
		JCheckBox chckbxDairy_1 = new JCheckBox("Dairy");
		chckbxDairy_1.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent c) {
				 isMilk=myView.myUser.getUserAllergen()[5];
					if (isMilk>0) {
						chckbxDairy_1.isSelected();
					}
			}
		});
		chckbxDairy_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxDairy_1.setBackground(new Color(240, 248, 255));
		chckbxDairy_1.setBounds(1031, 620, 226, 41);
		panel_1.add(chckbxDairy_1);
		
		JCheckBox chckbxLactose = new JCheckBox("Lactose");
		chckbxLactose.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent b) {
				 isLactose=myView.myUser.getUserAllergen()[4];
					if (isGluten>0) {
						chckbxLactose.isSelected();
					}
			}
		});
		chckbxLactose.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxLactose.setBackground(new Color(240, 248, 255));
		chckbxLactose.setBounds(1031, 547, 226, 41);
		panel_1.add(chckbxLactose);
		
		JCheckBox chckbxChocolate = new JCheckBox("Chocolate");
		chckbxChocolate.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent a) {
					isChocolate=myView.myUser.getUserAllergen()[10];
					if (isChocolate>0) {
						chckbxChocolate.isSelected();
					}
			}
		});
		chckbxChocolate.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxChocolate.setBackground(new Color(240, 248, 255));
		chckbxChocolate.setBounds(1311, 620, 281, 41);
		panel_1.add(chckbxChocolate);
		
		JCheckBox chckbxFoodAcidity = new JCheckBox("Food Acidity");
		chckbxFoodAcidity.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent j) {
					isAcidity=myView.myUser.getUserAllergen()[10];
					if (isAcidity>0) {
						chckbxFoodAcidity.isSelected();
					}
			}
		});
		chckbxFoodAcidity.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxFoodAcidity.setBackground(new Color(240, 248, 255));
		chckbxFoodAcidity.setBounds(1311, 547, 281, 41);
		panel_1.add(chckbxFoodAcidity);
		
		JTextPane txtpnEnterPassword = new JTextPane();
		txtpnEnterPassword.setText("Enter Password (6 digits):");
		txtpnEnterPassword.setFont(new Font("Tahoma", Font.PLAIN, 40));
		txtpnEnterPassword.setBackground(new Color(240, 248, 255));
		txtpnEnterPassword.setBounds(69, 450, 489, 63);
		panel_1.add(txtpnEnterPassword);
		
		JTextPane txtpnDateOfBirth = new JTextPane();
		txtpnDateOfBirth.setText("Date of Birth:");
		txtpnDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnDateOfBirth.setBackground(new Color(240, 248, 255));
		txtpnDateOfBirth.setBounds(69, 611, 275, 69);
		panel_1.add(txtpnDateOfBirth);
		
		textField_4 = new JTextField(/*myView.myUser.getPersonDateOfBirth().getYear()*/);
		textField_4.setEditable(false);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 40));
		textField_4.setColumns(10);
		textField_4.setBounds(581, 620, 171, 49);
		panel_1.add(textField_4);
		
		JButton button = new JButton("Delete User");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myView.statview.deleteUser();
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 50));
		button.setBounds(1056, 752, 406, 69);
		panel_1.add(button);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("Don't delete unless you're sure!");
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textPane.setBackground(new Color(240, 248, 255));
		textPane.setBounds(1056, 825, 406, 55);
		panel_1.add(textPane);
		
		//LocalDate.parse(rs.getString("personDateOfBirth")) äîøú ñèøéðâ ùì úàøéê ìlocaldate
	}
}
