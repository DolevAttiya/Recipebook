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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import java.awt.Choice;
import java.beans.VetoableChangeListener;
import java.beans.PropertyChangeEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtRecipebook;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	public String dateOfBirth="0000-00-00";
	public String yearOfBirth="0000";
	public String monthOfBirth="00";
	public String dayOfBirth="00";
	public int isDietitian=0;
	public String dietitianNum;
	public int isKosher=0;
	private JTextField textField_4;
	public String dietitianStatDate="0000-00-00";
	public String yearOfStat="0000";
	public String monthOfStat="00";
	public String dayOfStat="00";
	public int wantAllerg=0;

	//allergies
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



	// dietitianStatDate, allergies, wantAllerg);


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setSize(1664, 1493);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
		contentPane = new JPanel();
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

		//
		JTextPane txtpnUserDetails = new JTextPane();
		txtpnUserDetails.setEditable(false);
		txtpnUserDetails.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null,"Declined, please sign in first");
			}
		});
		JButton btnAdd = new JButton("Go!");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Declined, please sign in first");
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
		txtpnAdvancedSearch_1.setEditable(false);
		txtpnAdvancedSearch_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null,"Declined, please sign in first");

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
		textField_5.setBounds(747, 37, 269, 43);
		panel.add(textField_5);

		JTextPane txtpnFavouriteRecipes = new JTextPane();
		txtpnFavouriteRecipes.setEditable(false);
		txtpnFavouriteRecipes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null,"Declined, please sign in first");
			}
		});
		txtpnFavouriteRecipes.setBounds(524, 7, 210, 87);
		panel.add(txtpnFavouriteRecipes);
		txtpnFavouriteRecipes.setText("Favourite Recipes");
		txtpnFavouriteRecipes.setForeground(Color.WHITE);
		txtpnFavouriteRecipes.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 28));
		txtpnFavouriteRecipes.setBackground(new Color(65, 105, 225));

		JTextPane txtpnSearch_1 = new JTextPane();
		txtpnSearch_1.setEditable(false);
		txtpnSearch_1.setText("Search");
		txtpnSearch_1.setForeground(Color.WHITE);
		txtpnSearch_1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 28));
		txtpnSearch_1.setBackground(new Color(65, 105, 225));
		txtpnSearch_1.setBounds(844, 0, 146, 42);
		panel.add(txtpnSearch_1);

		JTextPane txtpnMyRecipes = new JTextPane();
		txtpnMyRecipes.setEditable(false);
		txtpnMyRecipes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null,"Declined, please sign in first");
			}
		});
		txtpnMyRecipes.setText("My Recipes");
		txtpnMyRecipes.setForeground(Color.WHITE);
		txtpnMyRecipes.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 28));
		txtpnMyRecipes.setBackground(new Color(65, 105, 225));
		txtpnMyRecipes.setBounds(347, 7, 175, 80);
		panel.add(txtpnMyRecipes);

		JTextPane txtpnTaimli = new JTextPane();
		txtpnTaimli.setEditable(false);
		txtpnTaimli.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login f=new Login();
				f.setVisible(true);
				Register.this.dispose();
				Register.this.setVisible(false);
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

		String[] monthsDietitian = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
		JComboBox comboBox_3 = new JComboBox(monthsDietitian);
		comboBox_3.setEnabled(false);
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox comboBox_3 = (JComboBox)e.getSource();
				String monthOfStat = (String)comboBox_3.getSelectedItem();
			}
		});
		comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 40));
		comboBox_3.setBounds(796, 738, 105, 49);
		panel_1.add(comboBox_3);

		String[] daysDietitian = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		JComboBox comboBox_2 = new JComboBox(daysDietitian);
		comboBox_2.setEnabled(false);
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox comboBox_2 = (JComboBox)e.getSource();
				String dayOfStat = (String)comboBox_2.getSelectedItem();
			}
		});
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		comboBox_2.setBounds(681, 738, 105, 49);
		panel_1.add(comboBox_2);

		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String yearOfStat=textField_4.getText();
			}
		});
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 40));
		textField_4.setColumns(10);
		textField_4.setBounds(913, 738, 171, 49);
		panel_1.add(textField_4);

		//if (chckbxDietican.setSelected(true)) --> textField_8.setEnabled(false);

		textField_8 = new JTextField();
		textField_8.setEnabled(false);
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 40));
		textField_8.setColumns(10);
		textField_8.setBounds(738, 669, 346, 49);
		panel_1.add(textField_8);

		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_7.setColumns(10);
		textField_7.setBounds(553, 557, 456, 49);
		panel_1.add(textField_7);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_2.setColumns(10);
		textField_2.setBounds(553, 498, 456, 49);
		panel_1.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_3.setColumns(10);
		textField_3.setBounds(205, 337, 804, 49);
		panel_1.add(textField_3);

		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_6.setColumns(10);
		textField_6.setBounds(316, 254, 693, 49);
		panel_1.add(textField_6);

		JCheckBox chckbxSeeds = new JCheckBox("Seeds");
		chckbxSeeds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(chckbxSeeds.isSelected()){  
					  isSeeds=1;   } 
				 else {
					 isSeeds=0;
				 }
			}
		});
		chckbxSeeds.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxSeeds.setBackground(new Color(240, 248, 255));
		chckbxSeeds.setBounds(1318, 318, 281, 41);
		panel_1.add(chckbxSeeds);

		JCheckBox chckbxFish = new JCheckBox("Strawberries");
		chckbxFish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(chckbxFish.isSelected()){  
					  isStrawberries=1;   } 
				 else {
					 isStrawberries=0;
				 }
			}
		});
		chckbxFish.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxFish.setBackground(new Color(240, 248, 255));
		chckbxFish.setBounds(1038, 318, 271, 41);
		panel_1.add(chckbxFish);
		setVisible(true);

		JTextPane txtpnEnterDieticanNumber = new JTextPane();
		txtpnEnterDieticanNumber.setEditable(false);
		txtpnEnterDieticanNumber.setText("Enter Dietican Number:");
		txtpnEnterDieticanNumber.setFont(new Font("Tahoma", Font.PLAIN, 38));
		txtpnEnterDieticanNumber.setBackground(new Color(240, 248, 255));
		txtpnEnterDieticanNumber.setBounds(316, 669, 412, 55);
		panel_1.add(txtpnEnterDieticanNumber);

		JCheckBox chckbxPeanut = new JCheckBox("Peanut");
		chckbxPeanut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(chckbxPeanut.isSelected()){  
					  isPeanut=1;   } 
				 else {
					 isPeanut=0;
				 }
			}
		});
		chckbxPeanut.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxPeanut.setBackground(new Color(240, 248, 255));
		chckbxPeanut.setBounds(1318, 458, 281, 41);
		panel_1.add(chckbxPeanut);

		JCheckBox chckbxTreeNuts = new JCheckBox("Tree Nuts");
		chckbxTreeNuts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(chckbxTreeNuts.isSelected()){  
					  isTreeNuts=1;   } 
				 else {
					 isTreeNuts=0;
				 }
			}
		});
		chckbxTreeNuts.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxTreeNuts.setBackground(new Color(240, 248, 255));
		chckbxTreeNuts.setBounds(1318, 385, 281, 41);
		panel_1.add(chckbxTreeNuts);

		JCheckBox chckbxEggs = new JCheckBox("Eggs");
		chckbxEggs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(chckbxEggs.isSelected()){  
					  isEggs=1;   } 
				 else {
					 isEggs=0;
				 }
			}
		});
		chckbxEggs.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxEggs.setBackground(new Color(240, 248, 255));
		chckbxEggs.setBounds(1318, 243, 281, 55);
		panel_1.add(chckbxEggs);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_1.setColumns(10);
		textField_1.setBounds(316, 183, 693, 49);
		panel_1.add(textField_1);

		JTextPane txtpnSearchFor = new JTextPane();
		txtpnSearchFor.setEditable(false);
		txtpnSearchFor.setText("First Name:");
		txtpnSearchFor.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnSearchFor.setBackground(new Color(240, 248, 255));
		txtpnSearchFor.setBounds(69, 178, 237, 63);
		panel_1.add(txtpnSearchFor);

		JTextPane txtpnRecipeId = new JTextPane();
		txtpnRecipeId.setEditable(false);
		txtpnRecipeId.setText("Last Name:");
		txtpnRecipeId.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnRecipeId.setBackground(new Color(240, 248, 255));
		txtpnRecipeId.setBounds(69, 247, 244, 83);
		panel_1.add(txtpnRecipeId);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Show only Kosher Recipies");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent b) {
				if(chckbxNewCheckBox.isSelected()){ 
					isKosher=1;
				} 
				else {  
					isKosher=0;
				}  
			}
		});
		chckbxNewCheckBox.setBackground(new Color(240, 248, 255));
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 45));
		chckbxNewCheckBox.setBounds(69, 811, 697, 64);
		panel_1.add(chckbxNewCheckBox);

		JTextPane txtpnAdvancedSearch = new JTextPane();
		txtpnAdvancedSearch.setEditable(false);
		txtpnAdvancedSearch.setText("Register");
		txtpnAdvancedSearch.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 80));
		txtpnAdvancedSearch.setBackground(new Color(240, 248, 255));
		txtpnAdvancedSearch.setBounds(507, 55, 644, 99);
		panel_1.add(txtpnAdvancedSearch);

		JCheckBox chckbxDairy = new JCheckBox("Fish");
		chckbxDairy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent d) {
				 if(chckbxDairy.isSelected()){  
					  isFish=1;   } 
				 else {
					  isFish=0;
				 }
			}
		});
		chckbxDairy.setSelected(false);
		chckbxDairy.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxDairy.setBackground(new Color(240, 248, 255));
		chckbxDairy.setBounds(1038, 250, 271, 41);
		panel_1.add(chckbxDairy);

		JTextPane txtpnAllergies = new JTextPane();
		txtpnAllergies.setEditable(false);
		txtpnAllergies.setText("Allergies:");

		txtpnAllergies.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 52));
		txtpnAllergies.setBackground(new Color(240, 248, 255));
		txtpnAllergies.setBounds(1140, 167, 340, 72);
		panel_1.add(txtpnAllergies);

		JCheckBox chckbxG = new JCheckBox("Coffie");
		chckbxG.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 if(chckbxG.isSelected()){  
					  isCoffie=1;   } 
				 else {
					  isCoffie=0;
				 }
			}
		});
		chckbxG.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxG.setBackground(new Color(240, 248, 255));
		chckbxG.setBounds(1038, 385, 263, 41);
		panel_1.add(chckbxG);

		JCheckBox chckbxNon = new JCheckBox("Gluten");
		chckbxNon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent f) {
				 if(chckbxNon.isSelected()){  
					  isGluten=1;   } 
				 else {
					  isGluten=0;
				 }
			}
		});
		chckbxNon.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxNon.setBackground(new Color(240, 248, 255));
		chckbxNon.setBounds(1038, 458, 255, 41);
		panel_1.add(chckbxNon);

		JButton btnSearch = new JButton("Register");
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent g) {
				if((textField_1.getText().trim().isEmpty())||(textField_6.getText().trim().isEmpty())||(textField_3.getText().trim().isEmpty())||(textField_2.getText().trim().isEmpty())||(textField_7.getText().trim().isEmpty())||(textField_9.getText().trim().isEmpty())) {
					JOptionPane.showMessageDialog(null,"One of the parameters is empty, Please fill all");
				}
						
				else {
						dateOfBirth=yearOfBirth+"-"+monthOfBirth+"-"+dayOfBirth;
						dietitianStatDate=yearOfStat+"-"+monthOfStat+"-"+dayOfStat;
						myView.statview.register(textField_1.getText(), textField_6.getText(), textField_3.getText(), textField_2.getText(), textField_7.getText(),dateOfBirth, isDietitian, textField_8.getText(), isKosher, dietitianStatDate, isFish, isStrawberries, isCoffie, isGluten, isLactose, isMilk, isEggs, isSeeds, isTreeNuts, isPeanut, isAcidity, isChocolate, wantAllerg);
						MainPage f=new MainPage();
						f.setVisible(true);
						Register.this.dispose();
						Register.this.setVisible(false);
					}
				}
			});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 50));
		btnSearch.setBounds(607, 1068, 326, 69);
		panel_1.add(btnSearch);

		JTextPane txtpnEmail = new JTextPane();
		txtpnEmail.setEditable(false);
		txtpnEmail.setText("Email:");
		chckbxNon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent h) {
				System.out.println(h.getID() == ActionEvent.ACTION_PERFORMED
						? "ACTION_PERFORMED" : h.getID()); //add what happens
			}
		});
		txtpnEmail.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnEmail.setBackground(new Color(240, 248, 255));
		txtpnEmail.setBounds(69, 337, 129, 69);
		panel_1.add(txtpnEmail);

		JTextPane txtpnEnterPassword = new JTextPane();
		txtpnEnterPassword.setEditable(false);
		txtpnEnterPassword.setText("Enter Password: (6 digits)");
		txtpnEnterPassword.setFont(new Font("Tahoma", Font.PLAIN, 40));
		txtpnEnterPassword.setBackground(new Color(240, 248, 255));
		txtpnEnterPassword.setBounds(69, 498, 480, 68);
		panel_1.add(txtpnEnterPassword);

		JTextPane txtpnEnterPasswordAgain = new JTextPane();
		txtpnEnterPasswordAgain.setEditable(false);
		txtpnEnterPasswordAgain.setText("Enter Password Again:");
		txtpnEnterPasswordAgain.setFont(new Font("Tahoma", Font.PLAIN, 40));
		txtpnEnterPasswordAgain.setBackground(new Color(240, 248, 255));
		txtpnEnterPasswordAgain.setBounds(69, 557, 462, 63);
		panel_1.add(txtpnEnterPasswordAgain);

		JCheckBox chckbxShowOnlyRecipes = new JCheckBox("Show only Recipes adapted to Alergies");
		chckbxShowOnlyRecipes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent c) {
				if(chckbxShowOnlyRecipes.isSelected()){ 
					wantAllerg=1;
				} 
				else {  
					wantAllerg=0;
				}  
			}
		});
		chckbxShowOnlyRecipes.setFont(new Font("Tahoma", Font.PLAIN, 45));
		chckbxShowOnlyRecipes.setBackground(new Color(240, 248, 255));
		chckbxShowOnlyRecipes.setBounds(69, 895, 866, 69);
		panel_1.add(chckbxShowOnlyRecipes);
		

		JCheckBox chckbxDairy_1 = new JCheckBox("Dairy");
		chckbxDairy_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent h) {
				 if(chckbxDairy_1.isSelected()){  
					  isMilk=1;   } 
				 else {
					 isMilk=0;
				 }
			}
		});
		chckbxDairy_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxDairy_1.setBackground(new Color(240, 248, 255));
		chckbxDairy_1.setBounds(1038, 604, 226, 41);
		panel_1.add(chckbxDairy_1);

		JCheckBox chckbxLactose = new JCheckBox("Lactose");
		chckbxLactose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent i) {
				 if(chckbxLactose.isSelected()){  
					  isLactose=1;   } 
				 else {
					 isLactose=0;
				 }
			}
		});
		chckbxLactose.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxLactose.setBackground(new Color(240, 248, 255));
		chckbxLactose.setBounds(1038, 531, 226, 41);
		panel_1.add(chckbxLactose);

		JCheckBox chckbxChocolate = new JCheckBox("Chocolate");
		chckbxChocolate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent i) {
				 if(chckbxChocolate.isSelected()){  
					  isChocolate=1;   } 
				 else {
					 isChocolate=0;
				 }
			}
		});
		chckbxChocolate.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxChocolate.setBackground(new Color(240, 248, 255));
		chckbxChocolate.setBounds(1318, 604, 281, 41);
		panel_1.add(chckbxChocolate);

		JCheckBox chckbxFoodAcidity = new JCheckBox("Food Acidity");
		chckbxFoodAcidity.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent j) {
				 if(chckbxFoodAcidity.isSelected()){  
					  isAcidity=1;   } 
				 else {
					 isAcidity=0;
				 }
			}
		});
		chckbxFoodAcidity.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxFoodAcidity.setBackground(new Color(240, 248, 255));
		chckbxFoodAcidity.setBounds(1318, 531, 281, 41);
		panel_1.add(chckbxFoodAcidity);
		
		JCheckBox chckbxDietican = new JCheckBox("Dietican");
		chckbxDietican.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				if(chckbxDietican.isSelected()){ 
					isDietitian=1;
					textField_8.setEnabled(true);
					textField_4.setEnabled(true);
					comboBox_2.setEnabled(true);
					comboBox_3.setEnabled(true);
					chckbxShowOnlyRecipes.setEnabled(false);
					chckbxNewCheckBox.setEnabled(false);
					chckbxDairy.setEnabled(false);
					chckbxFish.setEnabled(false);
					chckbxG.setEnabled(false);
					chckbxNon.setEnabled(false);
					chckbxLactose.setEnabled(false);
					chckbxDairy_1.setEnabled(false);
					chckbxEggs.setEnabled(false);
					chckbxSeeds.setEnabled(false);
					chckbxTreeNuts.setEnabled(false);
					chckbxPeanut.setEnabled(false);
					chckbxFoodAcidity.setEnabled(false);
					chckbxChocolate.setEnabled(false);
					chckbxFish.setEnabled(false);
					chckbxFish.setEnabled(false);
					chckbxFish.setEnabled(false);
					chckbxFish.setEnabled(false);
					chckbxFish.setEnabled(false);
					chckbxFish.setEnabled(false);
					chckbxFish.setEnabled(false);
				} 
				else {  
					isDietitian=0;
					textField_8.setEnabled(false);
					textField_4.setEnabled(false);
					comboBox_2.setEnabled(false);
					comboBox_3.setEnabled(false);
					chckbxShowOnlyRecipes.setEnabled(true);
					chckbxNewCheckBox.setEnabled(true);
					chckbxDairy.setEnabled(true);
					chckbxFish.setEnabled(true);
					chckbxG.setEnabled(true);
					chckbxNon.setEnabled(true);
					chckbxLactose.setEnabled(true);
					chckbxDairy_1.setEnabled(true);
					chckbxEggs.setEnabled(true);
					chckbxSeeds.setEnabled(true);
					chckbxTreeNuts.setEnabled(true);
					chckbxPeanut.setEnabled(true);
					chckbxFoodAcidity.setEnabled(true);
					chckbxChocolate.setEnabled(true);
					chckbxFish.setEnabled(true);
					chckbxFish.setEnabled(true);
					chckbxFish.setEnabled(true);
					chckbxFish.setEnabled(true);
					chckbxFish.setEnabled(true);
					chckbxFish.setEnabled(true);
					chckbxFish.setEnabled(true);
				}  

			}
		});
		chckbxDietican.setFont(new Font("Tahoma", Font.PLAIN, 45));
		chckbxDietican.setBackground(new Color(240, 248, 255));
		chckbxDietican.setBounds(69, 673, 237, 41);
		panel_1.add(chckbxDietican);

		

		JTextPane txtpnExpiryDate_1 = new JTextPane();
		txtpnExpiryDate_1.setEditable(false);
		txtpnExpiryDate_1.setText("Date of Certification:");
		txtpnExpiryDate_1.setFont(new Font("Tahoma", Font.PLAIN, 38));
		txtpnExpiryDate_1.setBackground(new Color(240, 248, 255));
		txtpnExpiryDate_1.setBounds(316, 732, 357, 55);
		panel_1.add(txtpnExpiryDate_1);

		String[] months = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
		JComboBox comboBox = new JComboBox(months);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox comboBox = (JComboBox)e.getSource();
				monthOfBirth = (String)comboBox.getSelectedItem();
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 40));
		comboBox.setBounds(358, 408, 105, 49);
		panel_1.add(comboBox);

		
		String[] days = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		JComboBox comboBox_1 = new JComboBox(days);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox comboBox_1 = (JComboBox)e.getSource();
				dayOfBirth = (String)comboBox_1.getSelectedItem();
			}
		});
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		comboBox_1.setBounds(468, 408, 105, 49);
		panel_1.add(comboBox_1);

		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setText("Date of Birth:");
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 45));
		textPane.setBackground(new Color(240, 248, 255));
		textPane.setBounds(69, 401, 275, 69);
		panel_1.add(textPane);

		textField_9 = new JTextField();
		textField_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yearOfBirth=textField_9.getText();
			}
		});
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 40));
		textField_9.setColumns(10);
		textField_9.setBounds(580, 408, 171, 49);
		panel_1.add(textField_9);


	}
}
