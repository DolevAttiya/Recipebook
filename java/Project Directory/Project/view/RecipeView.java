package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JTextArea;
import javax.swing.Box.Filler;
import javax.swing.DropMode;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.TextArea;

public class RecipeView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_5;
	private JTextField txtRecipebook;
	private JTextField textField_2_1;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_3;
	private JTextField textField_8;

	//allergies:
	public int isFish=0;
	public int isStrawberries=0;
	public int isCoffie=0;
	public int isGluten=0;
	public int isLactose=0;
	public int isMilk=0;
	public int isDairy=0;
	public int isEggs=0;
	public int isSeeds=0;
	public int isTreeNuts=0;
	public int isPeanut=0;
	public int isAcidity=0;
	public int isChocolate=0;
	Object[]dataIngredients;
	public int Complexity=0;
	public int timeToMake=0;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecipeView frame = new RecipeView();
					frame.setVisible(true);
					frame.setTitle("Taimli!");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public RecipeView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 700);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
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

		//ALLERGIES
		JCheckBox checkBox_7 = new JCheckBox("Gluten");
		checkBox_7.setEnabled(false);
		if(myView.myRecipe.getRecipeAllergen()[3]!=null)
		{
			isGluten=myView.myRecipe.getRecipeAllergen()[3];
			if (isGluten>0) {
				checkBox_7.setSelected(true);
			}
		}
		else
			myView.myRecipe.getRecipeAllergen()[3]=0;

		checkBox_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_7.setBackground(new Color(240, 248, 255));
		checkBox_7.setBounds(637, 194, 148, 41);
		panel_1.add(checkBox_7);

		JCheckBox checkBox_4 = new JCheckBox("Eggs");
		checkBox_4.setEnabled(false);
		if(myView.myRecipe.getRecipeAllergen()[6]!=null)
		{
			isEggs=myView.myRecipe.getRecipeAllergen()[6];
			if (isEggs>0) {
				checkBox_4.setSelected(true);
			}
		}
		else
			myView.myRecipe.getRecipeAllergen()[6]=0;

		checkBox_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_4.setBackground(new Color(240, 248, 255));
		checkBox_4.setBounds(803, 74, 118, 41);
		panel_1.add(checkBox_4);

		JCheckBox checkBox_11 = new JCheckBox("Food Acidity");
		checkBox_11.setEnabled(false);
		if(myView.myRecipe.getRecipeAllergen()[10]!=null)
		{
			isAcidity=myView.myRecipe.getRecipeAllergen()[10];
			if (isAcidity>0) {
				checkBox_11.setSelected(true);
			}
		}
		else
			myView.myRecipe.getRecipeAllergen()[10]=0;

		checkBox_11.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_11.setBackground(new Color(240, 248, 255));
		checkBox_11.setBounds(803, 234, 153, 41);
		panel_1.add(checkBox_11);

		JCheckBox checkBox_1 = new JCheckBox("Seeds");
		checkBox_1.setEnabled(false);
		if(myView.myRecipe.getRecipeAllergen()[7]!=null)
		{
			isSeeds=myView.myRecipe.getRecipeAllergen()[7];
			if (isSeeds>0) {
				checkBox_1.setSelected(true);
			}
		}
		else
			myView.myRecipe.getRecipeAllergen()[7]=0;

		checkBox_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_1.setBackground(new Color(240, 248, 255));
		checkBox_1.setBounds(803, 114, 104, 41);
		panel_1.add(checkBox_1);

		JCheckBox checkBox_9 = new JCheckBox("Lactose");
		checkBox_9.setEnabled(false);
		if(myView.myRecipe.getRecipeAllergen()[4]!=null)
		{
			isLactose=myView.myRecipe.getRecipeAllergen()[4];
			if (isLactose>0) {
				checkBox_9.setSelected(true);
			}
		}
		else
			myView.myRecipe.getRecipeAllergen()[4]=0;

		checkBox_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_9.setBackground(new Color(240, 248, 255));
		checkBox_9.setBounds(637, 234, 148, 41);
		panel_1.add(checkBox_9);

		JCheckBox checkBox = new JCheckBox("Peanut");
		checkBox.setEnabled(false);
		if(myView.myRecipe.getRecipeAllergen()[9]!=null)
		{
			isPeanut=myView.myRecipe.getRecipeAllergen()[9];
			if (isPeanut>0) {
				checkBox.setSelected(true);
			}
		}
		else
			myView.myRecipe.getRecipeAllergen()[9]=0;

		checkBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox.setBackground(new Color(240, 248, 255));
		checkBox.setBounds(803, 194, 129, 41);
		panel_1.add(checkBox);

		JCheckBox checkBox_10 = new JCheckBox("Chocolate");
		checkBox_10.setEnabled(false);
		if(myView.myRecipe.getRecipeAllergen()[11]!=null)
		{
			isChocolate=myView.myRecipe.getRecipeAllergen()[11];
			if (isChocolate>0) {
				checkBox_10.setSelected(true);
			}
		}
		else
			myView.myRecipe.getRecipeAllergen()[11]=0;

		checkBox_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_10.setBackground(new Color(240, 248, 255));
		checkBox_10.setBounds(803, 274, 153, 41);
		panel_1.add(checkBox_10);

		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setText("Allergies:");
		textPane.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 30));
		textPane.setBackground(new Color(240, 248, 255));
		textPane.setBounds(680, 32, 198, 41);
		panel_1.add(textPane);

		JCheckBox checkBox_3 = new JCheckBox("Tree Nuts");
		checkBox_3.setEnabled(false);
		if(myView.myRecipe.getRecipeAllergen()[8]!=null)
		{
			isTreeNuts=myView.myRecipe.getRecipeAllergen()[8];
			if (isTreeNuts>0) {
				checkBox_3.setSelected(true);
			}
		}
		else
			myView.myRecipe.getRecipeAllergen()[8]=0;

		checkBox_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_3.setBackground(new Color(240, 248, 255));
		checkBox_3.setBounds(803, 154, 141, 41);
		panel_1.add(checkBox_3);

		JCheckBox checkBox_2 = new JCheckBox("Strawberries");
		checkBox_2.setEnabled(false);
		if(myView.myRecipe.getRecipeAllergen()[1]!=null)
		{
			isStrawberries=myView.myRecipe.getRecipeAllergen()[1];
			if (isStrawberries>0) {
				checkBox_2.setSelected(true);
			}
		}
		else
			myView.myRecipe.getRecipeAllergen()[1]=0;

		checkBox_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_2.setBackground(new Color(240, 248, 255));
		checkBox_2.setBounds(637, 114, 168, 41);
		panel_1.add(checkBox_2);

		JCheckBox checkBox_6 = new JCheckBox("Coffie");
		checkBox_6.setEnabled(false);
		if(myView.myRecipe.getRecipeAllergen()[2]!=null)
		{
			isCoffie=myView.myRecipe.getRecipeAllergen()[2];
			if (isCoffie>0) {
				checkBox_6.setSelected(true);
			}
		}
		else
			myView.myRecipe.getRecipeAllergen()[2]=0;

		checkBox_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_6.setBackground(new Color(240, 248, 255));
		checkBox_6.setBounds(637, 154, 148, 41);
		panel_1.add(checkBox_6);

		JCheckBox checkBox_8 = new JCheckBox("Dairy");
		checkBox_8.setEnabled(false);
		if(myView.myRecipe.getRecipeAllergen()[5]!=null)
		{
			isDairy=myView.myRecipe.getRecipeAllergen()[5];
			if (isDairy>0) {
				checkBox_8.setSelected(true);
			}
		}
		else
			myView.myRecipe.getRecipeAllergen()[5]=0;

		checkBox_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_8.setBackground(new Color(240, 248, 255));
		checkBox_8.setBounds(637, 274, 148, 41);
		panel_1.add(checkBox_8);

		JCheckBox checkBox_5 = new JCheckBox("Fish");
		checkBox_5.setEnabled(false);
		if(myView.myRecipe.getRecipeAllergen()[0]!=null)
		{
			isFish=myView.myRecipe.getRecipeAllergen()[0];
			if (isFish>0) {
				checkBox_5.setSelected(true);
			}
		}
		else
			myView.myRecipe.getRecipeAllergen()[0]=0;

		checkBox_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_5.setBackground(new Color(240, 248, 255));
		checkBox_5.setBounds(637, 74, 118, 41);
		panel_1.add(checkBox_5);

		JTextPane txtpnPerGrams = new JTextPane();
		txtpnPerGrams.setEditable(false);
		txtpnPerGrams.setText("per 100 grams");
		txtpnPerGrams.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnPerGrams.setBackground(new Color(240, 248, 255));
		txtpnPerGrams.setBounds(745, 345, 88, 21);
		panel_1.add(txtpnPerGrams);

		JTextPane txtpnProtein = new JTextPane();
		txtpnProtein.setEditable(false);
		txtpnProtein.setText("Protein:");
		txtpnProtein.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnProtein.setBackground(new Color(240, 248, 255));
		txtpnProtein.setBounds(642, 488, 81, 31);
		panel_1.add(txtpnProtein);

		JTextPane txtpnFat = new JTextPane();
		txtpnFat.setEditable(false);
		txtpnFat.setText("Fat:");
		txtpnFat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnFat.setBackground(new Color(240, 248, 255));
		txtpnFat.setBounds(642, 448, 41, 31);
		panel_1.add(txtpnFat);

		JTextPane txtpnSugar = new JTextPane();
		txtpnSugar.setEditable(false);
		txtpnSugar.setText("Carbs:");
		txtpnSugar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnSugar.setBackground(new Color(240, 248, 255));
		txtpnSugar.setBounds(642, 408, 65, 31);
		panel_1.add(txtpnSugar);

		JTextPane txtpnCalories = new JTextPane();
		txtpnCalories.setEditable(false);
		txtpnCalories.setText("Calories:");
		txtpnCalories.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnCalories.setBackground(new Color(240, 248, 255));
		txtpnCalories.setBounds(642, 368, 88, 31);
		panel_1.add(txtpnCalories);

		textField_1 = new JTextField(myView.myRecipe.getRecipeDescription());
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(126, 109, 492, 31);
		panel_1.add(textField_1);

		JTextPane txtpnSearchFor = new JTextPane();
		txtpnSearchFor.setEditable(false);
		txtpnSearchFor.setText("Description:");
		txtpnSearchFor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnSearchFor.setBackground(new Color(240, 248, 255));
		txtpnSearchFor.setBounds(10, 109, 113, 31);
		panel_1.add(txtpnSearchFor);

		JTextPane txtpnAdvancedSearch = new JTextPane();
		txtpnAdvancedSearch.setEditable(false);
		txtpnAdvancedSearch.setText("Recipe");
		txtpnAdvancedSearch.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 40));
		txtpnAdvancedSearch.setBackground(new Color(240, 248, 255));
		txtpnAdvancedSearch.setBounds(394, 11, 186, 55);
		panel_1.add(txtpnAdvancedSearch);

		JButton btnSearch = new JButton("Edit");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(myView.myUser!=null)
				{
					if (myView.myUser.getPersonEmail().compareTo(myView.myRecipe.getRecipePersonEmail())==0) 
					{
						RecipeUpdate f=new RecipeUpdate();
						f.setVisible(true);
						RecipeView.this.dispose();
						RecipeView.this.setVisible(false);	
					}

				}
				else
					if(myView.myDietitian!=null)
					{
						if(myView.myDietitian.getPersonEmail().compareTo(myView.myRecipe.getRecipePersonEmail())==0)
						{
							RecipeUpdate f=new RecipeUpdate();
							f.setVisible(true);
							RecipeView.this.dispose();
							RecipeView.this.setVisible(false);
						}
					}

					else
					{
						JOptionPane.showMessageDialog(null,"You are not allowed to edit this recipe!");
					}



			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSearch.setBounds(401, 534, 179, 41);
		panel_1.add(btnSearch);

		JTextPane txtpnNutritionValues = new JTextPane();
		txtpnNutritionValues.setEditable(false);
		txtpnNutritionValues.setText("Nutrition Values:");
		txtpnNutritionValues.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 30));
		txtpnNutritionValues.setBackground(new Color(240, 248, 255));
		txtpnNutritionValues.setBounds(637, 307, 347, 41);
		panel_1.add(txtpnNutritionValues);

		JTextPane txtpnIngredients = new JTextPane();
		txtpnIngredients.setEditable(false);
		txtpnIngredients.setText("Ingredients:");
		txtpnIngredients.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnIngredients.setBackground(new Color(240, 248, 255));
		txtpnIngredients.setBounds(10, 149, 154, 31);
		panel_1.add(txtpnIngredients);

		JTextPane txtpnInstructions = new JTextPane();
		txtpnInstructions.setEditable(false);
		txtpnInstructions.setText("Instructions");
		txtpnInstructions.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnInstructions.setBackground(new Color(240, 248, 255));
		txtpnInstructions.setBounds(10, 333, 118, 32);
		panel_1.add(txtpnInstructions);

		textField_2_1 = new JTextField(myView.myRecipe.getRecipeTotalCalories().toString());
		textField_2_1.setEditable(false);
		textField_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2_1.setColumns(10);
		textField_2_1.setBounds(733, 368, 223, 31);
		panel_1.add(textField_2_1);

		textField_4 = new JTextField(myView.myRecipe.getRecipeTotalCarbohydrate().toString());
		textField_4.setEditable(false);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_4.setColumns(10);
		textField_4.setBounds(733, 408, 221, 31);
		panel_1.add(textField_4);

		textField_6 = new JTextField(myView.myRecipe.getRecipeTotalFat().toString());
		textField_6.setEditable(false);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_6.setColumns(10);
		textField_6.setBounds(733, 448, 221, 31);
		panel_1.add(textField_6);

		textField_7 = new JTextField(myView.myRecipe.getRecipeTotalProtein().toString());
		textField_7.setEditable(false);
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_7.setColumns(10);
		textField_7.setBounds(733, 488, 221, 31);
		panel_1.add(textField_7);

		textField_3 = new JTextField(myView.myRecipe.getRecipeRate().toString());
		textField_3.setEditable(false);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(169, 518, 55, 57);
		panel_1.add(textField_3);

		JTextPane txtpnName = new JTextPane();
		txtpnName.setEditable(false);
		txtpnName.setText("Name:");
		txtpnName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnName.setBackground(new Color(240, 248, 255));
		txtpnName.setBounds(10, 69, 65, 31);
		panel_1.add(txtpnName);

		textField_8 = new JTextField(myView.myRecipe.getRecipeName().toString());
		textField_8.setEditable(false);
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_8.setColumns(10);
		textField_8.setBounds(85, 69, 533, 31);
		panel_1.add(textField_8);

		JTextPane txtpnKosherLevel = new JTextPane();
		txtpnKosherLevel.setEditable(false);
		txtpnKosherLevel.setText("Kashruth:");
		txtpnKosherLevel.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnKosherLevel.setBackground(new Color(240, 248, 255));
		txtpnKosherLevel.setBounds(26, 1055, 198, 49);
		panel_1.add(txtpnKosherLevel);

		TextArea textArea = new TextArea(myView.myRecipe.getRecipeProcess());
		textArea.setFont(new Font("Dialog", Font.PLAIN, 16));
		textArea.setBounds(10, 365, 611, 149);
		panel_1.add(textArea);

		String[] columnNames = {"Ingredient Name",
				"Amount",
		"Mesuring"}; 

		JTable table = new JTable(null, columnNames);
		DefaultTableModel tableModel = new DefaultTableModel(null, columnNames) {

			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		};
		myView.statview.fillIngredientIdToName();
		dataIngredients = new Object[3];
		for(int row=0;row<myView.ingredientArrayForRecipe.size();row++) {
			dataIngredients[0]=myView.ingredientArrayForRecipe.get(row).getIngredientName();
			dataIngredients[1]=myView.myRecipe.getRecipeIngredientsAmount().get(row).toString();
			dataIngredients[2]=myView.myMeasuringForRecipe.get(row).getIngredientTypeName();
			tableModel.addRow(dataIngredients);

		}
		table.setModel(tableModel);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setRowHeight(32);
		JTableHeader th = table.getTableHeader();
		th.setPreferredSize(new Dimension(100, 30));
		Font bigFont = new Font("Tahoma", Font.PLAIN, 12);
		table.getTableHeader().setFont(bigFont);

		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		scrollPane.setSize(611, 145);
		scrollPane.setLocation(10,188);
		//TableColumn column = null;
		panel_1.add(scrollPane);

		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setText("Complexity:");
		textPane_1.setFont(new Font("Tahoma", Font.PLAIN, 45));
		textPane_1.setBackground(new Color(240, 248, 255));
		textPane_1.setBounds(1070, 968, 243, 64);
		panel_1.add(textPane_1);

		String[] complexiting = {"Easy", "Medium", "Hard"};  
		JComboBox comboBox = new JComboBox(complexiting);
		comboBox.setEnabled(false);
		comboBox.setSelectedIndex(0);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 40));

		comboBox.setBounds(1075, 1033, 508, 49);
		panel_1.add(comboBox);

		JTextPane textPane_2 = new JTextPane();
		textPane_2.setEditable(false);
		textPane_2.setText("Cooking Time Up To:");
		textPane_2.setFont(new Font("Tahoma", Font.PLAIN, 45));
		textPane_2.setBackground(new Color(240, 248, 255));
		textPane_2.setBounds(1071, 1090, 444, 64);
		panel_1.add(textPane_2);
		/*
		String[] times = {"30", "60", "120", "180", "all"};
		JComboBox comboBox_1 = new JComboBox(times);
		comboBox_1.setEnabled(false);
		comboBox_1.setSelectedIndex(myView.myRecipe.getRecipeTimeToMake()); 
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		comboBox_1.setBounds(1075, 1158, 509, 49);
		panel_1.add(comboBox_1);

		String[] kashruthing = {"Parve", "Dairy", "Meat","Not Kosher"};
		JComboBox comboBox_2 = new JComboBox(kashruthing);
		comboBox_2.setEnabled(false);
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		comboBox_2.setSelectedIndex(myView.myRecipe.getRecipeKashruth()); 
		comboBox_2.setBounds(229, 1065, 442, 49);
		panel_1.add(comboBox_2);
		 */
		JButton btnDeleteRecipe = new JButton("Delete Recipe");
		btnDeleteRecipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				if(myView.myUser!=null)
				{
					if (myView.myUser.getPersonEmail().compareTo(myView.myRecipe.getRecipePersonEmail())==0)
					{
						myView.statview.deleteRecipe();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"You are not allowed to delete this recipe!");
					}
				}
				else
					if(myView.myDietitian!=null)
					{
						if(myView.myDietitian.getPersonEmail().compareTo(myView.myRecipe.getRecipePersonEmail())==0) 
						{
							myView.statview.deleteRecipe();
						}
						else 
						{
							JOptionPane.showMessageDialog(null,"You are not allowed to delete this recipe!");
						}
					}
				MainPage a=new MainPage();
				a.setVisible(true);
				RecipeView.this.dispose();
				RecipeView.this.setVisible(false);
				
			}
		});
		btnDeleteRecipe.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnDeleteRecipe.setBounds(693, 523, 226, 39);
		panel_1.add(btnDeleteRecipe);

		JTextPane textPane_3 = new JTextPane();
		textPane_3.setEditable(false);
		textPane_3.setText("Don't delete unless you're sure!");
		textPane_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textPane_3.setBackground(new Color(240, 248, 255));
		textPane_3.setBounds(687, 563, 234, 21);
		panel_1.add(textPane_3);

		JButton btnILikeIt = new JButton("");
		btnILikeIt.setBounds(109, 518, 55, 57);
		panel_1.add(btnILikeIt);
		btnILikeIt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myView.statview.ifLiked(myView.myRecipe.getRecipeId());
				if (myView.check==true)
				{
					JOptionPane.showMessageDialog(null,"Can't Press Like more than one time!");
					btnILikeIt.setEnabled(false);
				}
				else
				{
					myView.statview.likePressed();
					btnILikeIt.setEnabled(false);
					Integer x=Integer.parseInt(textField_3.getText())+1;
					textField_3.setText(x.toString());
				}
			}
		}
				);
		btnILikeIt.setIcon(new ImageIcon(RecipeView.class.getResource("/view/rsz_like.jpg")));
		btnILikeIt.setBackground(new Color(65, 105, 225));
		btnILikeIt.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 20));

		JButton btnNewButton = new JButton("");
		btnNewButton.setVisible(false);
		if (myView.myRecipe.getRecipeRate()>50) {
			btnNewButton.setVisible(true);
		}
		else {
			btnNewButton.setVisible(false);
		};
		btnNewButton.setIcon(new ImageIcon(RecipeView.class.getResource("/view/rsz_picture1.png")));
		btnNewButton.setBounds(10, 11, 55, 55);
		panel_1.add(btnNewButton);


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
				myView.statview.getTop10();
				MainPage b=new MainPage();
				b.setVisible(true);
				RecipeView.this.dispose();
				RecipeView.this.setVisible(false);
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
				RecipeView.this.dispose();
				RecipeView.this.setVisible(false);
			}
		});
		textPane1.setBounds(882, 8, 102, 49);
		panel.add(textPane1);
		textPane1.setText("user details");
		textPane1.setForeground(Color.WHITE);
		textPane1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
		textPane1.setEditable(false);
		textPane1.setBackground(new Color(65, 105, 225));

		JTextPane textPane_11 = new JTextPane();
		textPane_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdvancedSearch d=new AdvancedSearch();
				d.setVisible(true);
				RecipeView.this.dispose();
				RecipeView.this.setVisible(false);
			}
		});
		textPane_11.setBounds(729, 7, 126, 50);
		panel.add(textPane_11);
		textPane_11.setText("Advanced Search");
		textPane_11.setForeground(Color.WHITE);
		textPane_11.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
		textPane_11.setEditable(false);
		textPane_11.setBackground(new Color(65, 105, 225));

		JTextPane textPane_31 = new JTextPane();
		textPane_31.setBounds(559, 11, 92, 29);
		panel.add(textPane_31);
		textPane_31.setText("Search");
		textPane_31.setForeground(Color.WHITE);
		textPane_31.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
		textPane_31.setEditable(false);
		textPane_31.setBackground(new Color(65, 105, 225));

		JButton button = new JButton("Go!");
		button.addActionListener(new ActionListener() {
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
						RecipeView.this.dispose();
						RecipeView.this.setVisible(false);
					}
				}
			}
		});
		button.setBounds(659, 36, 47, 21);
		panel.add(button);
		button.setFont(new Font("Tahoma", Font.BOLD, 5));

		JTextPane textPane_21 = new JTextPane();
		textPane_21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myView.statview.myFavorite();
				MyFavourites d=new MyFavourites();
				d.setVisible(true);
				RecipeView.this.dispose();
				RecipeView.this.setVisible(false);
			}
		});
		textPane_21.setBounds(341, 8, 132, 49);
		panel.add(textPane_21);
		textPane_21.setText("Favourite Recipes");
		textPane_21.setForeground(Color.WHITE);
		textPane_21.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
		textPane_21.setEditable(false);
		textPane_21.setBackground(new Color(65, 105, 225));

		JTextPane textPane_4 = new JTextPane();
		textPane_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myView.statview.myRecipes();
				MyRecipes c=new MyRecipes();
				c.setVisible(true);
				RecipeView.this.dispose();
				RecipeView.this.setVisible(false);
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