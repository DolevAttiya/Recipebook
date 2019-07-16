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
	private JTextField textField_2;
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
	public int isEggs=0;
	public int isSeeds=0;
	public int isTreeNuts=0;
	public int isPeanut=0;
	public int isAcidity=0;
	public int isChocolate=0;
	Object[][] dataIngredients;
	public int Complexity=0;
	public int timeToMake=0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the frame.
	 */
	public RecipeView() {
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
		panel.setBounds(26, 15, 1603, 87);
		panel.setBackground(new Color(65, 105, 225));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAdd = new JButton("Go!");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myView.statview.mainSearch(textField_2.getText());  
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
		});
		btnAdd.setBounds(1016, 37, 71, 42);
		panel.add(btnAdd);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		textField_2.setColumns(10);
		textField_2.setBounds(747, 37, 269, 43);
		panel.add(textField_2);

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
				RecipeView.this.dispose();
				RecipeView.this.setVisible(false);
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
				RecipeView.this.dispose();
				RecipeView.this.setVisible(false);
			}
		});
		txtpnAdvancedSearch_1.setText("Advanced Search");
		txtpnAdvancedSearch_1.setForeground(Color.WHITE);
		txtpnAdvancedSearch_1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 28));
		txtpnAdvancedSearch_1.setBackground(new Color(65, 105, 225));
		txtpnAdvancedSearch_1.setBounds(1146, 7, 215, 80);
		panel.add(txtpnAdvancedSearch_1);



		JTextPane txtpnFavouriteRecipes = new JTextPane();
		txtpnFavouriteRecipes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myView.statview.myFavorite();
				MyFavourites f=new MyFavourites();
				f.setVisible(true);
				RecipeView.this.dispose();
				RecipeView.this.setVisible(false);
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
				myView.statview.myRecipes();
				MyRecipes f=new MyRecipes();
				f.setVisible(true);
				RecipeView.this.dispose();
				RecipeView.this.setVisible(false);
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
				RecipeView.this.dispose();
				RecipeView.this.setVisible(false);
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
		
		//ALLERGIES
		JCheckBox checkBox_7 = new JCheckBox("Gluten");
		checkBox_7.setEnabled(false);
		checkBox_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isGluten=myView.myRecipe.getRecipeAllergen()[3];
				if (isGluten>0) {
					checkBox_7.isSelected();
				}
			}
		});
		checkBox_7.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_7.setBackground(new Color(240, 248, 255));
		checkBox_7.setBounds(1079, 403, 255, 41);
		panel_1.add(checkBox_7);
		
		JCheckBox checkBox_4 = new JCheckBox("Eggs");
		checkBox_4.setEnabled(false);
		checkBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isEggs=myView.myRecipe.getRecipeAllergen()[6];
				if (isEggs>0) {
					checkBox_4.isSelected();
				}
			}
		});
		checkBox_4.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_4.setBackground(new Color(240, 248, 255));
		checkBox_4.setBounds(1345, 188, 243, 55);
		panel_1.add(checkBox_4);
		
		JCheckBox checkBox_11 = new JCheckBox("Food Acidity");
		checkBox_11.setEnabled(false);
		checkBox_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isAcidity=myView.myRecipe.getRecipeAllergen()[10];
				if (isAcidity>0) {
					checkBox_11.isSelected();
				}
			}
		});
		checkBox_11.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_11.setBackground(new Color(240, 248, 255));
		checkBox_11.setBounds(1345, 476, 265, 41);
		panel_1.add(checkBox_11);
		
		JCheckBox checkBox_1 = new JCheckBox("Seeds");
		checkBox_1.setEnabled(false);
		checkBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isSeeds=myView.myRecipe.getRecipeAllergen()[7];
				if (isSeeds>0) {
					checkBox_1.isSelected();
				}
			}
		});
		checkBox_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_1.setBackground(new Color(240, 248, 255));
		checkBox_1.setBounds(1345, 263, 243, 41);
		panel_1.add(checkBox_1);
		
		JCheckBox checkBox_9 = new JCheckBox("Lactose");
		checkBox_9.setEnabled(false);
		checkBox_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isLactose=myView.myRecipe.getRecipeAllergen()[4];
				if (isLactose>0) {
					checkBox_9.isSelected();
				}
			}
		});
		checkBox_9.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_9.setBackground(new Color(240, 248, 255));
		checkBox_9.setBounds(1079, 476, 226, 41);
		panel_1.add(checkBox_9);
		
		JCheckBox checkBox = new JCheckBox("Peanut");
		checkBox.setEnabled(false);
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isPeanut=myView.myRecipe.getRecipeAllergen()[9];
				if (isPeanut>0) {
					checkBox.isSelected();
				}
			}
		});
		checkBox.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox.setBackground(new Color(240, 248, 255));
		checkBox.setBounds(1345, 403, 192, 41);
		panel_1.add(checkBox);
		
		JCheckBox checkBox_10 = new JCheckBox("Chocolate");
		checkBox_10.setEnabled(false);
		checkBox_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isChocolate=myView.myRecipe.getRecipeAllergen()[11];
				if (isChocolate>0) {
					checkBox_10.isSelected();
				}
			}
		});
		checkBox_10.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_10.setBackground(new Color(240, 248, 255));
		checkBox_10.setBounds(1345, 549, 243, 41);
		panel_1.add(checkBox_10);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("Allergies:");
		textPane.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 52));
		textPane.setBackground(new Color(240, 248, 255));
		textPane.setBounds(1157, 115, 340, 72);
		panel_1.add(textPane);
		
		JCheckBox checkBox_3 = new JCheckBox("Tree Nuts");
		checkBox_3.setEnabled(false);
		checkBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isTreeNuts=myView.myRecipe.getRecipeAllergen()[8];
				if (isTreeNuts>0) {
					checkBox_3.isSelected();
				}
			}
		});
		checkBox_3.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_3.setBackground(new Color(240, 248, 255));
		checkBox_3.setBounds(1345, 330, 231, 41);
		panel_1.add(checkBox_3);
		
		JCheckBox checkBox_2 = new JCheckBox("Strawberries");
		checkBox_2.setEnabled(false);
		checkBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isStrawberries=myView.myRecipe.getRecipeAllergen()[1];
				if (isStrawberries>0) {
					checkBox_2.isSelected();
				}
			}
		});
		checkBox_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_2.setBackground(new Color(240, 248, 255));
		checkBox_2.setBounds(1079, 263, 269, 41);
		panel_1.add(checkBox_2);
		
		JCheckBox checkBox_6 = new JCheckBox("Coffie");
		checkBox_6.setEnabled(false);
		checkBox_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isCoffie=myView.myRecipe.getRecipeAllergen()[2];
				if (isCoffie>0) {
					checkBox_6.isSelected();
				}
			}
		});
		checkBox_6.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_6.setBackground(new Color(240, 248, 255));
		checkBox_6.setBounds(1079, 330, 269, 41);
		panel_1.add(checkBox_6);
		
		JCheckBox checkBox_8 = new JCheckBox("Dairy");
		checkBox_8.setEnabled(false);
		checkBox_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isMilk=myView.myRecipe.getRecipeAllergen()[5];
				if (isMilk>0) {
					checkBox_8.isSelected();
				}
			}
		});
		checkBox_8.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_8.setBackground(new Color(240, 248, 255));
		checkBox_8.setBounds(1079, 549, 226, 41);
		panel_1.add(checkBox_8);
		
		JCheckBox checkBox_5 = new JCheckBox("Fish");
		checkBox_5.setEnabled(false);
		checkBox_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isFish=myView.myRecipe.getRecipeAllergen()[0];
				if (isFish>0) {
					checkBox_5.isSelected();
				}
			}
		});
		checkBox_5.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_5.setBackground(new Color(240, 248, 255));
		checkBox_5.setBounds(1079, 195, 269, 41);
		panel_1.add(checkBox_5);
		
		JTextPane txtpnPerGrams = new JTextPane();
		txtpnPerGrams.setText("per 100 grams");
		txtpnPerGrams.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnPerGrams.setBackground(new Color(240, 248, 255));
		txtpnPerGrams.setBounds(1251, 686, 160, 31);
		panel_1.add(txtpnPerGrams);
		
		JTextPane txtpnProtein = new JTextPane();
		txtpnProtein.setText("Protein:");
		txtpnProtein.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnProtein.setBackground(new Color(240, 248, 255));
		txtpnProtein.setBounds(1115, 896, 173, 61);
		panel_1.add(txtpnProtein);
		
		JTextPane txtpnFat = new JTextPane();
		txtpnFat.setText("Fat:");
		txtpnFat.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnFat.setBackground(new Color(240, 248, 255));
		txtpnFat.setBounds(1115, 841, 173, 61);
		panel_1.add(txtpnFat);
		
		JTextPane txtpnSugar = new JTextPane();
		txtpnSugar.setText("Carbs:");
		txtpnSugar.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnSugar.setBackground(new Color(240, 248, 255));
		txtpnSugar.setBounds(1115, 778, 173, 61);
		panel_1.add(txtpnSugar);
		
		JTextPane txtpnCalories = new JTextPane();
		txtpnCalories.setText("Calories:");
		txtpnCalories.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnCalories.setBackground(new Color(240, 248, 255));
		txtpnCalories.setBounds(1115, 719, 173, 61);
		panel_1.add(txtpnCalories);
		
		textField_1 = new JTextField(/*myView.myRecipe.getRecipeDescription()*/);
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 45));
		textField_1.setColumns(10);
		textField_1.setBounds(282, 267, 775, 57);
		panel_1.add(textField_1);
		
		JTextPane txtpnSearchFor = new JTextPane();
		txtpnSearchFor.setText("Description:");
		txtpnSearchFor.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnSearchFor.setBackground(new Color(240, 248, 255));
		txtpnSearchFor.setBounds(26, 263, 243, 61);
		panel_1.add(txtpnSearchFor);
		
		JTextPane txtpnAdvancedSearch = new JTextPane();
		txtpnAdvancedSearch.setText("Recipe");
		txtpnAdvancedSearch.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 80));
		txtpnAdvancedSearch.setBackground(new Color(240, 248, 255));
		txtpnAdvancedSearch.setBounds(507, 55, 424, 99);
		panel_1.add(txtpnAdvancedSearch);
		
		JButton btnSearch = new JButton("Edit");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecipeUpdate f=new RecipeUpdate();
				f.setVisible(true);
				RecipeView.this.dispose();
				RecipeView.this.setVisible(false);
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 50));
		btnSearch.setBounds(605, 1178, 326, 69);
		panel_1.add(btnSearch);
		
		JTextPane txtpnNutritionValues = new JTextPane();
		txtpnNutritionValues.setText("Nutrition Values:");
		txtpnNutritionValues.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 52));
		txtpnNutritionValues.setBackground(new Color(240, 248, 255));
		txtpnNutritionValues.setBounds(1174, 630, 326, 58);
		panel_1.add(txtpnNutritionValues);
		
		JTextPane txtpnIngredients = new JTextPane();
		txtpnIngredients.setText("Ingredients:");
		txtpnIngredients.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnIngredients.setBackground(new Color(240, 248, 255));
		txtpnIngredients.setBounds(26, 328, 453, 61);
		panel_1.add(txtpnIngredients);
		
		JTextPane txtpnInstructions = new JTextPane();
		txtpnInstructions.setText("Instructions");
		txtpnInstructions.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnInstructions.setBackground(new Color(240, 248, 255));
		txtpnInstructions.setBounds(26, 723, 326, 49);
		panel_1.add(txtpnInstructions);
		
		textField_2_1 = new JTextField(/*myView.myRecipe.getRecipeCalories()*/);
		textField_2_1.setEditable(false);
		textField_2_1.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_2_1.setColumns(10);
		textField_2_1.setBounds(1300, 731, 237, 49);
		panel_1.add(textField_2_1);
		
		textField_4 = new JTextField(/*myView.myRecipe.getRecipeCarbohydrate()*/);
		textField_4.setEditable(false);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_4.setColumns(10);
		textField_4.setBounds(1300, 790, 237, 49);
		panel_1.add(textField_4);
		
		textField_6 = new JTextField(/*myView.myRecipe.getRecipeFat()*/);
		textField_6.setEditable(false);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_6.setColumns(10);
		textField_6.setBounds(1300, 849, 237, 49);
		panel_1.add(textField_6);
		
		textField_7 = new JTextField(/*myView.myRecipe.getRecipeTotalProtein().toString()*/);
		textField_7.setEditable(false);
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_7.setColumns(10);
		textField_7.setBounds(1300, 908, 237, 49);
		panel_1.add(textField_7);
		
		JButton btnILikeIt = new JButton("I Like It!");
		btnILikeIt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myView.statview.likePressed();
				btnILikeIt.setEnabled(false);				
			}
		});
		btnILikeIt.setIcon(new ImageIcon("C:\\Users\\Adi G\\Desktop\\like.png"));
		btnILikeIt.setBackground(new Color(65, 105, 225));
		btnILikeIt.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 20));
		btnILikeIt.setBounds(947, 103, 110, 108);
		panel_1.add(btnILikeIt);
		
		textField_3 = new JTextField(/*myView.myRecipe.getRecipeRate()*/);
		textField_3.setEditable(false);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_3.setColumns(10);
		textField_3.setBounds(947, 211, 110, 49);
		panel_1.add(textField_3);
		
		JTextPane txtpnName = new JTextPane();
		txtpnName.setText("Name:");
		txtpnName.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnName.setBackground(new Color(240, 248, 255));
		txtpnName.setBounds(26, 188, 141, 61);
		panel_1.add(txtpnName);
		
		textField_8 = new JTextField(/*myView.myRecipe.getRecipeName()*/);
		textField_8.setEditable(false);
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 45));
		textField_8.setColumns(10);
		textField_8.setBounds(171, 192, 632, 57);
		panel_1.add(textField_8);
		
		JTextPane txtpnKosherLevel = new JTextPane();
		txtpnKosherLevel.setText("Kashruth:");
		txtpnKosherLevel.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnKosherLevel.setBackground(new Color(240, 248, 255));
		txtpnKosherLevel.setBounds(26, 1055, 198, 49);
		panel_1.add(txtpnKosherLevel);
		
		TextArea textArea = new TextArea(/*myView.myRecipe.getRecipeInstructions()*/);
		textArea.setBounds(26, 778, 1021, 271);
		panel_1.add(textArea);
		
		String[] columnNames = {"Ingredient Name",
                "Amount",
                "Mesuring"}; 
		dataIngredients = new Object[myView.recipeArray.size()][3];
		for(int row=0;row<myView.ingredientArrayForRecipe.size();row++) {
			dataIngredients[row][0]=myView.ingredientArrayForRecipe.get(row).getIngredientName();
			dataIngredients[row][1]=myView.myRecipe.getRecipeIngredientsAmount().get(row).toString();
			dataIngredients[row][2]=myView.myMeasuringForRecipe.get(row).getIngredientTypeName();
		}
		JTable table = new JTable(dataIngredients, columnNames);
		table.setFont(new Font("Tahoma", Font.PLAIN, 30));
		table.setRowHeight(80);
		JTableHeader th = table.getTableHeader();
		th.setPreferredSize(new Dimension(100, 100));
		Font bigFont = new Font("Tahoma", Font.PLAIN, 32);
		table.getTableHeader().setFont(bigFont);
		
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		scrollPane.setSize(1018, 327);
		scrollPane.setLocation(26, 394);
		//TableColumn column = null;
		panel_1.add(scrollPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("Complexity:");
		textPane_1.setFont(new Font("Tahoma", Font.PLAIN, 45));
		textPane_1.setBackground(new Color(240, 248, 255));
		textPane_1.setBounds(1070, 968, 243, 64);
		panel_1.add(textPane_1);
		
		String[] complexiting = {"Easy", "Medium", "Hard"};  
		JComboBox comboBox = new JComboBox(complexiting);
		comboBox.setEnabled(false);
		comboBox.setSelectedIndex(0); //myView.myRecipe.getRecipeKashruth()
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
		comboBox.setBounds(1075, 1033, 508, 49);
		panel_1.add(comboBox);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setText("Cooking Time Up To:");
		textPane_2.setFont(new Font("Tahoma", Font.PLAIN, 45));
		textPane_2.setBackground(new Color(240, 248, 255));
		textPane_2.setBounds(1071, 1090, 444, 64);
		panel_1.add(textPane_2);
		
		String[] times = {"30", "60", "120", "180", "all"};
		JComboBox comboBox_1 = new JComboBox(times);
		comboBox_1.setEnabled(false);
		comboBox_1.setSelectedIndex(0); //myView.myRecipe.getRecipeKashruth()
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		comboBox_1.setBounds(1075, 1158, 509, 49);
		panel_1.add(comboBox_1);
		
		String[] kashruthing = {"Parve", "Dairy", "Meat","Not Kosher"};
		JComboBox comboBox_2 = new JComboBox(kashruthing);
		comboBox_2.setEnabled(false);
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		comboBox_2.setSelectedIndex(0); //myView.myRecipe.getRecipeKashruth()
		comboBox_2.setBounds(229, 1065, 442, 49);
		panel_1.add(comboBox_2);
		
		JButton btnDeleteRecipe = new JButton("Delete Recipe");
		btnDeleteRecipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (myView.myUser.getPersonEmail()==myView.myRecipe.getRecipePersonEmail()||myView.myDietitian.getPersonEmail()==myView.myRecipe.getRecipePersonEmail()) {
					myView.statview.deleteRecipe();
				}
				else {
					JOptionPane.showMessageDialog(null,"You are not allowed to delete this recipe!");
				}
			}
		});
		btnDeleteRecipe.setFont(new Font("Tahoma", Font.BOLD, 50));
		btnDeleteRecipe.setBounds(26, 1171, 406, 69);
		panel_1.add(btnDeleteRecipe);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setText("Don't delete unless you're sure!");
		textPane_3.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textPane_3.setBackground(new Color(240, 248, 255));
		textPane_3.setBounds(26, 1244, 406, 55);
		panel_1.add(textPane_3);
		
	}
}