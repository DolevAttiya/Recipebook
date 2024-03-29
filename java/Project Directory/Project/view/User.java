package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class User extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane_1;
	private JTextField textField;
	private JTextField textField_1;
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
	 * Create the frame.
	 */
	public User() {
		setSize(1000, 700);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
		contentPane_1 = new JPanel();
		contentPane_1.setBackground(new Color(65, 105, 225));
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_1);
		contentPane_1.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 248, 255));
		panel_1.setBounds(10, 60, 971, 586);
		contentPane_1.add(panel_1);
		panel_1.setLayout(null);

		Integer X=myView.myUser.getPersonDateOfBirth().getDayOfMonth();
		String[] day= {X.toString()};
		JComboBox comboBox = new JComboBox(day);
		comboBox.setEnabled(false);
		comboBox.setSelectedItem(myView.myUser.getPersonDateOfBirth().getDayOfMonth()); 
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox comboBox = (JComboBox)arg0.getSource();
				String days = (String)comboBox.getSelectedItem();
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setBounds(178, 212, 87, 36);
		panel_1.add(comboBox);		

		Integer Y=myView.myUser.getPersonDateOfBirth().getMonthValue();
		String[] month= {Y.toString()};		
		JComboBox comboBox_3 = new JComboBox(month);
		comboBox_3.setEnabled(false);
		comboBox_3.setSelectedItem(myView.myUser.getPersonDateOfBirth().getMonth());
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox comboBox_3 = (JComboBox)arg0.getSource();
				String months = (String)comboBox.getSelectedItem();
			}
		});
		comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_3.setBounds(274, 212, 87, 36);
		panel_1.add(comboBox_3);

		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_7.setColumns(10);
		textField_7.setBounds(284, 312, 254, 39);
		panel_1.add(textField_7);


		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(284, 262, 254, 39);
		panel_1.add(textField_2);

		textField_3 = new JTextField(myView.myUser.getPersonEmail());
		textField_3.setEditable(false);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(101, 162, 441, 39);
		panel_1.add(textField_3);

		textField_6 = new JTextField(myView.myUser.getPersonLastName());
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_6.setColumns(10);
		textField_6.setBounds(157, 112, 387, 39);
		panel_1.add(textField_6);

		JCheckBox chckbxSeeds = new JCheckBox("Seeds");
		chckbxSeeds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxSeeds.isSelected()) {
					isSeeds=1;
				}
				else {
					isSeeds=0;
				}
			}
		});


		if (myView.myUser.getUserAllergen()[7]!=null) {
			if(myView.myUser.getUserAllergen()[7]>0)
			{
				isSeeds=1;
				chckbxSeeds.setSelected(true);
			}
			else
				isSeeds=0;
		}
		else
			isSeeds=0;

		chckbxSeeds.setFont(new Font("Dialog", Font.PLAIN, 20));
		chckbxSeeds.setBackground(new Color(240, 248, 255));
		chckbxSeeds.setBounds(773, 152, 142, 41);
		panel_1.add(chckbxSeeds);

		JCheckBox chckbxFish = new JCheckBox("Strawberries");
		chckbxFish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxFish.isSelected()) {
					isStrawberries=1;
				}
				else {
					isStrawberries=0;
				}
			}
		});

		if (myView.myUser.getUserAllergen()[1]!=null) {
			if(myView.myUser.getUserAllergen()[1]>0)
			{
				isStrawberries=1;
				chckbxFish.setSelected(true);
			}
			else
				isStrawberries=0;
		}
		else
			isStrawberries=0;

		chckbxFish.setFont(new Font("Dialog", Font.PLAIN, 20));
		chckbxFish.setBackground(new Color(240, 248, 255));
		chckbxFish.setBounds(600, 152, 171, 41);
		panel_1.add(chckbxFish);
		setVisible(true);

		JCheckBox chckbxPeanut = new JCheckBox("Peanut");
		chckbxPeanut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxPeanut.isSelected()) {
					isPeanut=1;
				}
				else {
					isPeanut=0;
				}
			}
		});


		if (myView.myUser.getUserAllergen()[9]!=null) {
			if(myView.myUser.getUserAllergen()[9]>0)
			{
				isPeanut=1;
				chckbxPeanut.setSelected(true);
			}
			else
				isPeanut=0;
		}
		else
			isPeanut=0;

		chckbxPeanut.setFont(new Font("Dialog", Font.PLAIN, 20));
		chckbxPeanut.setBackground(new Color(240, 248, 255));
		chckbxPeanut.setBounds(773, 232, 142, 41);
		panel_1.add(chckbxPeanut);

		JCheckBox chckbxTreeNuts = new JCheckBox("Tree Nuts");
		chckbxTreeNuts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxTreeNuts.isSelected()) {
					isTreeNuts=1;
				}
				else {
					isTreeNuts=0;
				}
			}
		});

		if (myView.myUser.getUserAllergen()[8]!=null) {
			if(myView.myUser.getUserAllergen()[8]>0)
			{
				isTreeNuts=1;
				chckbxTreeNuts.setSelected(true);
			}
			else
				isTreeNuts=0;
		}
		else
			isTreeNuts=0;

		chckbxTreeNuts.setFont(new Font("Dialog", Font.PLAIN, 20));
		chckbxTreeNuts.setBackground(new Color(240, 248, 255));
		chckbxTreeNuts.setBounds(773, 192, 129, 41);
		panel_1.add(chckbxTreeNuts);

		JCheckBox chckbxEggs = new JCheckBox("Eggs");
		chckbxEggs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxEggs.isSelected()) {
					isEggs=1;
				}
				else {
					isEggs=0;
				}
			}
		});


		if (myView.myUser.getUserAllergen()[6]!=null) {
			if(myView.myUser.getUserAllergen()[6]>0)
			{
				isEggs=1;
				chckbxEggs.setSelected(true);
			}
			else
				isEggs=0;
		}
		else
			isEggs=0;

		chckbxEggs.setFont(new Font("Dialog", Font.PLAIN, 20));
		chckbxEggs.setBackground(new Color(240, 248, 255));
		chckbxEggs.setBounds(773, 112, 117, 40);
		panel_1.add(chckbxEggs);

		textField_1 = new JTextField(myView.myUser.getPersonFirstName());
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(157, 62, 387, 39);
		panel_1.add(textField_1);

		JTextPane txtpnSearchFor = new JTextPane();
		txtpnSearchFor.setEditable(false);
		txtpnSearchFor.setText("First Name:");
		txtpnSearchFor.setFont(new Font("Tahoma", Font.PLAIN, 20));
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
		userKosher=myView.myUser.getUserKashruth();
		if (userKosher==true) {
			chckbxNewCheckBox.setSelected(true);
			isKosher=1;
		}
		else {
			chckbxNewCheckBox.setSelected(false);
			isKosher=0;
		}
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxNewCheckBox.isSelected()) {
					isKosher=1;
				}
				else {
					isKosher=0;
				}		


			}
		});


		chckbxNewCheckBox.setBackground(new Color(240, 248, 255));
		chckbxNewCheckBox.setFont(new Font("Dialog", Font.PLAIN, 20));
		chckbxNewCheckBox.setBounds(26, 358, 697, 41);
		panel_1.add(chckbxNewCheckBox);

		JTextPane txtpnAdvancedSearch = new JTextPane();
		txtpnAdvancedSearch.setEditable(false);
		txtpnAdvancedSearch.setText("User Details");
		txtpnAdvancedSearch.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 40));
		txtpnAdvancedSearch.setBackground(new Color(240, 248, 255));
		txtpnAdvancedSearch.setBounds(337, 0, 326, 55);
		panel_1.add(txtpnAdvancedSearch);

		JCheckBox chckbxDairy = new JCheckBox("Fish");
		chckbxDairy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent h) {
				if (chckbxDairy.isSelected()) {
					isFish=1;
				}
				else {
					isFish=0;
				}
			}
		});
		if (myView.myUser.getUserAllergen()[0]!=null) {
			if(myView.myUser.getUserAllergen()[0]>0)
			{
				isFish=1;
				chckbxDairy.setSelected(true);
			}
			else
				isFish=0;
		}
		else
			isFish=0;

		chckbxDairy.setFont(new Font("Dialog", Font.PLAIN, 20));
		chckbxDairy.setBackground(new Color(240, 248, 255));
		chckbxDairy.setBounds(600, 112, 155, 41);
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
			public void actionPerformed(ActionEvent g) {
				if (chckbxG.isSelected()) {
					isCoffie=1;
				}
				else {
					isCoffie=0;
				}
			}
		});
		if (myView.myUser.getUserAllergen()[2]!=null) {
			if(myView.myUser.getUserAllergen()[2]>0)
			{
				isCoffie=1;
				chckbxG.setSelected(true);
			}
			else
				isCoffie=0;
		}
		else
			isCoffie=0;

		chckbxG.setFont(new Font("Dialog", Font.PLAIN, 20));
		chckbxG.setBackground(new Color(240, 248, 255));
		chckbxG.setBounds(600, 192, 155, 41);
		panel_1.add(chckbxG);

		JCheckBox chckbxNon = new JCheckBox("Gluten");
		chckbxNon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent f) {
				if (chckbxNon.isSelected()) {
					isGluten=1;
				}
				else {
					isGluten=0;
				}
			}
		});
		if (myView.myUser.getUserAllergen()[3]!=null) {
			if(myView.myUser.getUserAllergen()[3]>0)
			{
				isGluten=1;
				chckbxNon.setSelected(true);
			}
			else
				isGluten=0;
		}
		else
			isGluten=0;

		chckbxNon.setFont(new Font("Dialog", Font.PLAIN, 20));
		chckbxNon.setBackground(new Color(240, 248, 255));
		chckbxNon.setBounds(600, 232, 105, 41);
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
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnSearch.setBounds(379, 489, 188, 47);
		panel_1.add(btnSearch);

		JTextPane txtpnEmail = new JTextPane();
		txtpnEmail.setEditable(false);
		txtpnEmail.setText("Email:");
		txtpnEmail.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtpnEmail.setBackground(new Color(240, 248, 255));
		txtpnEmail.setBounds(26, 162, 65, 33);
		panel_1.add(txtpnEmail);
		JTextPane txtpnEnterPasswordAgain = new JTextPane();
		txtpnEnterPasswordAgain.setEditable(false);
		txtpnEnterPasswordAgain.setText("Enter Password Again:");
		txtpnEnterPasswordAgain.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtpnEnterPasswordAgain.setBackground(new Color(240, 248, 255));
		txtpnEnterPasswordAgain.setBounds(26, 312, 211, 39);
		panel_1.add(txtpnEnterPasswordAgain);

		JCheckBox chckbxShowOnlyRecipes = new JCheckBox("Show only Recipes adapted to Alergies");
		userAllergy=myView.myUser.getUserAllergens();
		if (userAllergy==true) {
			chckbxShowOnlyRecipes.setSelected(true);
			isAller=1;
		}
		else {
			chckbxShowOnlyRecipes.setSelected(false);
			isAller=0;
		}
		chckbxShowOnlyRecipes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxShowOnlyRecipes.isSelected()) {
					isAller=1;
				}
				else {
					isAller=0;
				}		
			}
		});



		chckbxShowOnlyRecipes.setFont(new Font("Dialog", Font.PLAIN, 20));
		chckbxShowOnlyRecipes.setBackground(new Color(240, 248, 255));
		chckbxShowOnlyRecipes.setBounds(26, 402, 866, 49);
		panel_1.add(chckbxShowOnlyRecipes);

		JCheckBox chckbxDairy_1 = new JCheckBox("Dairy");
		chckbxDairy_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent c) {
				if (chckbxDairy_1.isSelected()) {
					isMilk=1;
				}
				else {
					isMilk=0;
				}
			}
		});

		if (myView.myUser.getUserAllergen()[5]!=null) {
			if(myView.myUser.getUserAllergen()[5]>0)
			{
				isMilk=1;
				chckbxDairy_1.setSelected(true);
			}
			else
				isMilk=0;
		}
		else
			isMilk=0;


		chckbxDairy_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		chckbxDairy_1.setBackground(new Color(240, 248, 255));
		chckbxDairy_1.setBounds(600, 312, 92, 41);
		panel_1.add(chckbxDairy_1);

		JCheckBox chckbxLactose = new JCheckBox("Lactose");
		chckbxLactose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxLactose.isSelected()) {
					isLactose=1;
				}
				else {
					isLactose=0;
				}
			}
		});

		if (myView.myUser.getUserAllergen()[4]!=null) {
			if(myView.myUser.getUserAllergen()[4]>0)
			{
				isLactose=1;
				chckbxLactose.setSelected(true);
			}
			else
				isLactose=0;
		}
		else
			isLactose=0;


		chckbxLactose.setFont(new Font("Dialog", Font.PLAIN, 20));
		chckbxLactose.setBackground(new Color(240, 248, 255));
		chckbxLactose.setBounds(600, 272, 117, 41);
		panel_1.add(chckbxLactose);

		JCheckBox chckbxChocolate = new JCheckBox("Chocolate");
		chckbxChocolate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				if (chckbxChocolate.isSelected()) {
					isChocolate=1;
				}
				else {
					isChocolate=0;
				}
			}
		});

		if (myView.myUser.getUserAllergen()[11]!=null) {
			if(myView.myUser.getUserAllergen()[11]>0)
			{
				isChocolate=1;
				chckbxChocolate.setSelected(true);
			}
			else
				isChocolate=0;
		}
		else
			isChocolate=0;

		chckbxChocolate.setFont(new Font("Dialog", Font.PLAIN, 20));
		chckbxChocolate.setBackground(new Color(240, 248, 255));
		chckbxChocolate.setBounds(773, 312, 155, 41);
		panel_1.add(chckbxChocolate);

		JCheckBox chckbxFoodAcidity = new JCheckBox("Food Acidity");
		chckbxFoodAcidity.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent j) {
				if (chckbxFoodAcidity.isSelected()) {
					isAcidity=1;
				}
				else {
					isAcidity=0;
				}
			}
		});

		if (myView.myUser.getUserAllergen()[10]!=null) {
			if(myView.myUser.getUserAllergen()[10]>0)
			{
				isAcidity=1;
				chckbxFoodAcidity.setSelected(true);
			}
			else
				isAcidity=0;
		}
		else
			isAcidity=0;

		chckbxFoodAcidity.setFont(new Font("Dialog", Font.PLAIN, 20));
		chckbxFoodAcidity.setBackground(new Color(240, 248, 255));
		chckbxFoodAcidity.setBounds(773, 272, 176, 41);
		panel_1.add(chckbxFoodAcidity);

		JTextPane txtpnEnterPassword = new JTextPane();
		txtpnEnterPassword.setEditable(false);
		txtpnEnterPassword.setText("Enter Password (6 digits):");
		txtpnEnterPassword.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtpnEnterPassword.setBackground(new Color(240, 248, 255));
		txtpnEnterPassword.setBounds(26, 262, 254, 39);
		panel_1.add(txtpnEnterPassword);

		JTextPane txtpnDateOfBirth = new JTextPane();
		txtpnDateOfBirth.setEditable(false);
		txtpnDateOfBirth.setText("Date of Birth:");
		txtpnDateOfBirth.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtpnDateOfBirth.setBackground(new Color(240, 248, 255));
		txtpnDateOfBirth.setBounds(26, 212, 142, 39);
		panel_1.add(txtpnDateOfBirth);

		Integer ZZZ =myView.myUser.getPersonDateOfBirth().getYear();
		textField_4 = new JTextField(ZZZ.toString());
		textField_4.setEditable(false);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_4.setColumns(10);
		textField_4.setBounds(368, 212, 171, 36);
		panel_1.add(textField_4);

		JButton button = new JButton("Delete User");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myView.statview.deleteUser();
				if (myView.check==true) // was able to delete
				{
					Login b=new Login();
					b.setVisible(true);
					User.this.dispose();
					User.this.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null,"You are not alowed to delete this user");
				}
			}
		});

		button.setFont(new Font("Tahoma", Font.BOLD, 25));
		button.setBounds(693, 480, 226, 39);
		panel_1.add(button);

		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setText("Don't delete unless you're sure!");
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textPane.setBackground(new Color(240, 248, 255));
		textPane.setBounds(693, 523, 226, 28);
		panel_1.add(textPane);

		//panel upper
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 994, 59);
		panel.setBackground(new Color(65, 105, 225));
		contentPane_1.add(panel);
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
				myView.statview.getTop10();
				MainPage b=new MainPage();
				b.setVisible(true);
				User.this.dispose();
				User.this.setVisible(false);
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
				User.this.dispose();
				User.this.setVisible(false);
			}
		});
		textPane1.setBounds(882, 8, 102, 49);
		panel.add(textPane1);
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
				User.this.dispose();
				User.this.setVisible(false);
			}
		});
		textPane_1.setBounds(729, 7, 126, 50);
		panel.add(textPane_1);
		textPane_1.setText("Advanced Search");
		textPane_1.setForeground(Color.WHITE);
		textPane_1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
		textPane_1.setEditable(false);
		textPane_1.setBackground(new Color(65, 105, 225));

		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(560, 5, 92, 29);
		panel.add(textPane_3);
		textPane_3.setText("Search");
		textPane_3.setForeground(Color.WHITE);
		textPane_3.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
		textPane_3.setEditable(false);
		textPane_3.setBackground(new Color(65, 105, 225));

		JButton button1 = new JButton("Go!");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Cannot search an empty string!");
				}
				else {
					myView.statview.mainSearch(textField.getText()); 
					if (myView.check==false) {
						JOptionPane.showMessageDialog(null,"There is no match to your search, try again");
					}
					else {
						SearchRes d=new SearchRes();
						d.setVisible(true);
						User.this.dispose();
						User.this.setVisible(false);
					}
				}
			}
		});
		button1.setBounds(659, 36, 47, 21);
		panel.add(button1);
		button1.setFont(new Font("Tahoma", Font.BOLD, 5));

		JTextPane textPane_2 = new JTextPane();
		textPane_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myView.statview.myFavorite();
				MyFavourites d=new MyFavourites();
				d.setVisible(true);
				User.this.dispose();
				User.this.setVisible(false);
			}
		});
		textPane_2.setBounds(341, 8, 132, 49);
		panel.add(textPane_2);
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
				User.this.dispose();
				User.this.setVisible(false);
			}
		});
		textPane_4.setBounds(224, 8, 107, 49);
		panel.add(textPane_4);
		textPane_4.setText("My Recipes");
		textPane_4.setForeground(Color.WHITE);
		textPane_4.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
		textPane_4.setEditable(false);
		textPane_4.setBackground(new Color(65, 105, 225));

	}
}
