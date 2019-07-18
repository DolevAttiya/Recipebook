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
		setSize(1000, 700);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
		contentPane = new JPanel();
		contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 105, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//panelkavuaa

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 248, 255));
		panel_1.setBounds(10, 60, 971, 586);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		String[] monthsDietitian = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
		JComboBox comboBox_3 = new JComboBox(monthsDietitian);
		comboBox_3.setEnabled(false);
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox comboBox_3 = (JComboBox)e.getSource();
				monthOfStat = (String)comboBox_3.getSelectedItem();
			}
		});
		comboBox_3.setFont(new Font("Dialog", Font.PLAIN, 20));
		comboBox_3.setBounds(453, 409, 75, 34);
		panel_1.add(comboBox_3);

		String[] daysDietitian = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		JComboBox comboBox_2 = new JComboBox(daysDietitian);
		comboBox_2.setEnabled(false);
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox comboBox_2 = (JComboBox)e.getSource();
				dayOfStat = (String)comboBox_2.getSelectedItem();
			}
		});
		comboBox_2.setFont(new Font("Dialog", Font.PLAIN, 20));
		comboBox_2.setBounds(368, 409, 75, 34);
		panel_1.add(comboBox_2);

		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yearOfStat=textField_4.getText();
			}
		});
		textField_4.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField_4.setColumns(10);
		textField_4.setBounds(538, 409, 176, 34);
		panel_1.add(textField_4);

		textField_8 = new JTextField();
		textField_8.setEnabled(false);
		textField_8.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField_8.setColumns(10);
		textField_8.setBounds(368, 362, 346, 39);
		panel_1.add(textField_8);

		textField_7 = new JTextField();
		textField_7.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField_7.setColumns(10);
		textField_7.setBounds(256, 312, 282, 39);
		panel_1.add(textField_7);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(256, 262, 282, 39);
		panel_1.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(101, 162, 441, 39);
		panel_1.add(textField_3);

		textField_6 = new JTextField();
		textField_6.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField_6.setColumns(10);
		textField_6.setBounds(157, 112, 387, 39);
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
		chckbxSeeds.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxSeeds.setBackground(new Color(240, 248, 255));
		chckbxSeeds.setBounds(773, 152, 142, 41);
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
		chckbxFish.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxFish.setBackground(new Color(240, 248, 255));
		chckbxFish.setBounds(613, 152, 142, 41);
		panel_1.add(chckbxFish);
		setVisible(true);

		JTextPane txtpnEnterDieticanNumber = new JTextPane();
		txtpnEnterDieticanNumber.setEditable(false);
		txtpnEnterDieticanNumber.setText("Enter Dietican Number:");
		txtpnEnterDieticanNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnEnterDieticanNumber.setBackground(new Color(240, 248, 255));
		txtpnEnterDieticanNumber.setBounds(146, 371, 215, 33);
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
		chckbxPeanut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxPeanut.setBackground(new Color(240, 248, 255));
		chckbxPeanut.setBounds(773, 232, 98, 41);
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
		chckbxTreeNuts.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxTreeNuts.setBackground(new Color(240, 248, 255));
		chckbxTreeNuts.setBounds(773, 192, 129, 41);
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
		chckbxEggs.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxEggs.setBackground(new Color(240, 248, 255));
		chckbxEggs.setBounds(773, 112, 117, 40);
		panel_1.add(chckbxEggs);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(157, 62, 387, 39);
		panel_1.add(textField_1);

		JTextPane txtpnSearchFor = new JTextPane();
		txtpnSearchFor.setEditable(false);
		txtpnSearchFor.setText("First Name:");
		txtpnSearchFor.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtpnSearchFor.setBackground(new Color(240, 248, 255));
		txtpnSearchFor.setBounds(26, 62, 117, 33);
		panel_1.add(txtpnSearchFor);

		JTextPane txtpnRecipeId = new JTextPane();
		txtpnRecipeId.setEditable(false);
		txtpnRecipeId.setText("Last Name:");
		txtpnRecipeId.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtpnRecipeId.setBackground(new Color(240, 248, 255));
		txtpnRecipeId.setBounds(26, 112, 117, 27);
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
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxNewCheckBox.setBounds(26, 450, 697, 39);
		panel_1.add(chckbxNewCheckBox);

		JTextPane txtpnAdvancedSearch = new JTextPane();
		txtpnAdvancedSearch.setEditable(false);
		txtpnAdvancedSearch.setText("Register");
		txtpnAdvancedSearch.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 40));
		txtpnAdvancedSearch.setBackground(new Color(240, 248, 255));
		txtpnAdvancedSearch.setBounds(337, 0, 243, 55);
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
		chckbxDairy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxDairy.setBackground(new Color(240, 248, 255));
		chckbxDairy.setBounds(613, 112, 65, 41);
		panel_1.add(chckbxDairy);

		JTextPane txtpnAllergies = new JTextPane();
		txtpnAllergies.setEditable(false);
		txtpnAllergies.setText("Allergies:");

		txtpnAllergies.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 30));
		txtpnAllergies.setBackground(new Color(240, 248, 255));
		txtpnAllergies.setBounds(629, 62, 211, 55);
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
		chckbxG.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxG.setBackground(new Color(240, 248, 255));
		chckbxG.setBounds(613, 192, 92, 41);
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
		chckbxNon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxNon.setBackground(new Color(240, 248, 255));
		chckbxNon.setBounds(613, 232, 105, 41);
		panel_1.add(chckbxNon);

		JButton btnSearch = new JButton("Register");
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent g) {
				if((textField_1.getText().trim().isEmpty())||(textField_6.getText().trim().isEmpty())||(textField_3.getText().trim().isEmpty())||(textField_2.getText().trim().isEmpty())||(textField_7.getText().trim().isEmpty())||(textField_9.getText().trim().isEmpty())) {
					JOptionPane.showMessageDialog(null,"One of the parameters is empty, Please fill all");
				}
				else if (myView.check==false)
					JOptionPane.showMessageDialog(null,"Couldn't save, Something went wrong, Please try again!");
				else
				{
					yearOfBirth=textField_9.getText();
					yearOfStat=textField_4.getText();
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
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnSearch.setBounds(391, 534, 179, 41);
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
		txtpnEmail.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtpnEmail.setBackground(new Color(240, 248, 255));
		txtpnEmail.setBounds(26, 162, 65, 33);
		panel_1.add(txtpnEmail);

		JTextPane txtpnEnterPassword = new JTextPane();
		txtpnEnterPassword.setEditable(false);
		txtpnEnterPassword.setText("Enter Password: (6 digits)");
		txtpnEnterPassword.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtpnEnterPassword.setBackground(new Color(240, 248, 255));
		txtpnEnterPassword.setBounds(26, 262, 226, 39);
		panel_1.add(txtpnEnterPassword);

		JTextPane txtpnEnterPasswordAgain = new JTextPane();
		txtpnEnterPasswordAgain.setEditable(false);
		txtpnEnterPasswordAgain.setText("Enter Password Again:");
		txtpnEnterPasswordAgain.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtpnEnterPasswordAgain.setBackground(new Color(240, 248, 255));
		txtpnEnterPasswordAgain.setBounds(26, 312, 211, 39);
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
		chckbxShowOnlyRecipes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxShowOnlyRecipes.setBackground(new Color(240, 248, 255));
		chckbxShowOnlyRecipes.setBounds(26, 492, 489, 41);
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
		chckbxDairy_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxDairy_1.setBackground(new Color(240, 248, 255));
		chckbxDairy_1.setBounds(613, 312, 92, 41);
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
		chckbxLactose.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxLactose.setBackground(new Color(240, 248, 255));
		chckbxLactose.setBounds(613, 272, 117, 41);
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
		chckbxChocolate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxChocolate.setBackground(new Color(240, 248, 255));
		chckbxChocolate.setBounds(773, 312, 117, 41);
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
		chckbxFoodAcidity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxFoodAcidity.setBackground(new Color(240, 248, 255));
		chckbxFoodAcidity.setBounds(773, 272, 142, 41);
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
		chckbxDietican.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxDietican.setBackground(new Color(240, 248, 255));
		chckbxDietican.setBounds(26, 363, 237, 41);
		panel_1.add(chckbxDietican);



		JTextPane txtpnExpiryDate_1 = new JTextPane();
		txtpnExpiryDate_1.setEditable(false);
		txtpnExpiryDate_1.setText("Date of Certification:");
		txtpnExpiryDate_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnExpiryDate_1.setBackground(new Color(240, 248, 255));
		txtpnExpiryDate_1.setBounds(146, 410, 201, 33);
		panel_1.add(txtpnExpiryDate_1);

		String[] months = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
		JComboBox comboBox = new JComboBox(months);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox comboBox = (JComboBox)e.getSource();
				monthOfBirth = (String)comboBox.getSelectedItem();
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setBounds(178, 212, 87, 36);
		panel_1.add(comboBox);


		String[] days = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		JComboBox comboBox_1 = new JComboBox(days);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox comboBox_1 = (JComboBox)e.getSource();
				dayOfBirth = (String)comboBox_1.getSelectedItem();
			}
		});
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_1.setBounds(274, 212, 87, 36);
		panel_1.add(comboBox_1);

		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setText("Date of Birth:");
		textPane.setFont(new Font("Dialog", Font.PLAIN, 20));
		textPane.setBackground(new Color(240, 248, 255));
		textPane.setBounds(26, 212, 142, 39);
		panel_1.add(textPane);

		textField_9 = new JTextField();
		textField_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yearOfBirth=textField_9.getText();
			}
		});
		textField_9.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField_9.setColumns(10);
		textField_9.setBounds(368, 212, 171, 36);
		panel_1.add(textField_9);

		//panel upper
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 994, 59);
		panel.setBackground(new Color(65, 105, 225));
		contentPane.add(panel);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setBounds(495, 36, 163, 21);
		panel.add(textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setColumns(10);

		JTextPane textPane_5 = new JTextPane();
		textPane_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login b=new Login();
				b.setVisible(true);
				Register.this.dispose();
				Register.this.setVisible(false);
			}
		});
		textPane_5.setBounds(10, 0, 204, 57);
		panel.add(textPane_5);
		textPane_5.setText("Taimli");
		textPane_5.setForeground(Color.WHITE);
		textPane_5.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 50));
		textPane_5.setEditable(false);
		textPane_5.setBackground(new Color(65, 105, 225));

		JTextPane textPane1 = new JTextPane();
		textPane1.setBounds(882, 8, 102, 49);
		panel.add(textPane1);
		textPane1.setText("user details");
		textPane1.setForeground(Color.WHITE);
		textPane1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
		textPane1.setEditable(false);
		textPane1.setBackground(new Color(65, 105, 225));

		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(729, 7, 126, 50);
		panel.add(textPane_1);
		textPane_1.setText("Advanced Search");
		textPane_1.setForeground(Color.WHITE);
		textPane_1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
		textPane_1.setEditable(false);
		textPane_1.setBackground(new Color(65, 105, 225));

		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(559, 11, 92, 29);
		panel.add(textPane_3);
		textPane_3.setText("Search");
		textPane_3.setForeground(Color.WHITE);
		textPane_3.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
		textPane_3.setEditable(false);
		textPane_3.setBackground(new Color(65, 105, 225));

		JButton button = new JButton("Go!");
		button.setBounds(659, 36, 47, 21);
		panel.add(button);
		button.setFont(new Font("Tahoma", Font.BOLD, 5));

		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(341, 8, 132, 49);
		panel.add(textPane_2);
		textPane_2.setText("Favourite Recipes");
		textPane_2.setForeground(Color.WHITE);
		textPane_2.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
		textPane_2.setEditable(false);
		textPane_2.setBackground(new Color(65, 105, 225));

		JTextPane textPane_4 = new JTextPane();
		textPane_4.setBounds(224, 8, 107, 49);
		panel.add(textPane_4);
		textPane_4.setText("My Recipes");
		textPane_4.setForeground(Color.WHITE);
		textPane_4.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
		textPane_4.setEditable(false);
		textPane_4.setBackground(new Color(65, 105, 225));



	}
}
