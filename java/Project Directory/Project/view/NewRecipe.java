
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
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import model.Ingredient;

import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import java.awt.TextArea;
import javax.swing.JScrollPane;
import java.awt.Component;

public class NewRecipe extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_5;
	private JTextField textField_3;
	private JTextField txtRecipebook;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField textField_9;

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
	public Double amount=0.0;
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
					NewRecipe frame = new NewRecipe();
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
	public NewRecipe() {
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
				myView.statview.mainSearch(textField_2.getText());  
				if (myView.check==false) {
					JOptionPane.showMessageDialog(null,"There is no match to your search, try again");
				}
				else {
					SearchRes d=new SearchRes();
				d.setVisible(true);
				NewRecipe.this.dispose();
				NewRecipe.this.setVisible(false);
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
		txtpnUserDetails.setEditable(false);
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
				NewRecipe.this.dispose();
				NewRecipe.this.setVisible(false);
			}
		});
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
				AdvancedSearch f=new AdvancedSearch();
				f.setVisible(true);
				NewRecipe.this.dispose();
				NewRecipe.this.setVisible(false);
			}
		});
		txtpnAdvancedSearch_1.setText("Advanced Search");
		txtpnAdvancedSearch_1.setForeground(Color.WHITE);
		txtpnAdvancedSearch_1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 28));
		txtpnAdvancedSearch_1.setBackground(new Color(65, 105, 225));
		txtpnAdvancedSearch_1.setBounds(1146, 7, 215, 80);
		panel.add(txtpnAdvancedSearch_1);



		JTextPane txtpnFavouriteRecipes = new JTextPane();
		txtpnFavouriteRecipes.setEditable(false);
		txtpnFavouriteRecipes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myView.statview.myFavorite();
				MyFavourites f=new MyFavourites();
				f.setVisible(true);
				NewRecipe.this.dispose();
				NewRecipe.this.setVisible(false);
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
				myView.statview.myRecipes();
				MyRecipes f=new MyRecipes();
				f.setVisible(true);
				NewRecipe.this.dispose();
				NewRecipe.this.setVisible(false);
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
				MainPage f=new MainPage();
				f.setVisible(true);
				NewRecipe.this.dispose();
				NewRecipe.this.setVisible(false);
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

		String[] times = {"30", "60", "120", "180", "all"}; //if string=all -->>99999
		JComboBox comboBox_5 = new JComboBox(times);
		comboBox_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox comboBox_5 = (JComboBox)e.getSource();
		        timeToMake = (int)comboBox_5.getSelectedIndex();
			}
		});
		comboBox_5.setFont(new Font("Tahoma", Font.PLAIN, 40));
		comboBox_5.setBounds(1076, 1018, 509, 49);
		panel_1.add(comboBox_5);

		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		scrollPane.setSize(1018, 358);
		scrollPane.setLocation(36, 413);
		//TableColumn column = null;
		panel_1.add(scrollPane);

		TextArea textArea = new TextArea();
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 40));
		textArea.setBounds(32, 824, 1011, 282);
		panel_1.add(textArea);

		JComboBox comboBox_1 = new JComboBox(); //get
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox comboBox_1 = (JComboBox)e.getSource();
				String mesuring = (String)comboBox_1.getSelectedItem();
			}
		});
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		comboBox_1.setBounds(738, 355, 229, 49);
		panel_1.add(comboBox_1);


		textField_3 = new JTextField();
		textField_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				amount= Double.parseDouble(textField_3.getText());
			}
		});
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 40));
		textField_3.setColumns(10);
		textField_3.setBounds(627, 355, 105, 49);
		panel_1.add(textField_3);

		//ALLERGIES
		JCheckBox checkBox_7 = new JCheckBox("Gluten");
		checkBox_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox_7.isSelected()){  
					isGluten=1;   } 
				else {
					isGluten=0;
				}
			}
		});
		checkBox_7.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_7.setBackground(new Color(240, 248, 255));
		checkBox_7.setBounds(1076, 515, 255, 41);
		panel_1.add(checkBox_7);

		JCheckBox checkBox_4 = new JCheckBox("Eggs");
		checkBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox_4.isSelected()){  
					isEggs=1;   } 
				else {
					isEggs=0;
				}
			}
		});
		checkBox_4.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_4.setBackground(new Color(240, 248, 255));
		checkBox_4.setBounds(1342, 300, 243, 55);
		panel_1.add(checkBox_4);

		JCheckBox checkBox_11 = new JCheckBox("Food Acidity");
		checkBox_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox_11.isSelected()){  
					isAcidity=1;   } 
				else {
					isAcidity=0;
				}
			}
		});
		checkBox_11.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_11.setBackground(new Color(240, 248, 255));
		checkBox_11.setBounds(1342, 588, 265, 41);
		panel_1.add(checkBox_11);

		JCheckBox checkBox_1 = new JCheckBox("Seeds");
		checkBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox_1.isSelected()){  
					isSeeds=1;   } 
				else {
					isSeeds=0;
				}
			}
		});
		checkBox_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_1.setBackground(new Color(240, 248, 255));
		checkBox_1.setBounds(1342, 375, 243, 41);
		panel_1.add(checkBox_1);

		JCheckBox checkBox_9 = new JCheckBox("Lactose");
		checkBox_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox_9.isSelected()){  
					isLactose=1;   } 
				else {
					isLactose=0;
				}
			}
		});
		checkBox_9.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_9.setBackground(new Color(240, 248, 255));
		checkBox_9.setBounds(1076, 588, 226, 41);
		panel_1.add(checkBox_9);

		JCheckBox checkBox = new JCheckBox("Peanut");
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox.isSelected()){  
					isPeanut=1;   } 
				else {
					isPeanut=0;
				}
			}
		});
		checkBox.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox.setBackground(new Color(240, 248, 255));
		checkBox.setBounds(1342, 515, 192, 41);
		panel_1.add(checkBox);

		JCheckBox checkBox_10 = new JCheckBox("Chocolate");
		checkBox_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox_10.isSelected()){  
					isChocolate=1;   } 
				else {
					isChocolate=0;
				}
			}
		});
		checkBox_10.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_10.setBackground(new Color(240, 248, 255));
		checkBox_10.setBounds(1342, 661, 243, 41);
		panel_1.add(checkBox_10);

		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setText("Allergies:");
		textPane.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 52));
		textPane.setBackground(new Color(240, 248, 255));
		textPane.setBounds(1154, 227, 340, 72);
		panel_1.add(textPane);

		JCheckBox checkBox_3 = new JCheckBox("Tree Nuts");
		checkBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox_3.isSelected()){  
					isTreeNuts=1;   } 
				else {
					isTreeNuts=0;
				}
			}
		});
		checkBox_3.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_3.setBackground(new Color(240, 248, 255));
		checkBox_3.setBounds(1342, 442, 231, 41);
		panel_1.add(checkBox_3);

		JCheckBox checkBox_2 = new JCheckBox("Strawberries");
		checkBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox_2.isSelected()){  
					isStrawberries=1;   } 
				else {
					isFish=0;
				}
			}
		});
		checkBox_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_2.setBackground(new Color(240, 248, 255));
		checkBox_2.setBounds(1076, 375, 269, 41);
		panel_1.add(checkBox_2);

		JCheckBox checkBox_6 = new JCheckBox("Coffie");
		checkBox_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox_6.isSelected()){  
					isCoffie=1;   } 
				else {
					isCoffie=0;
				}
			}
		});
		checkBox_6.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_6.setBackground(new Color(240, 248, 255));
		checkBox_6.setBounds(1076, 442, 269, 41);
		panel_1.add(checkBox_6);

		JCheckBox checkBox_8 = new JCheckBox("Dairy");
		checkBox_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox_8.isSelected()){  
					isMilk=1;   } 
				else {
					isMilk=0;
				}
			}
		});
		checkBox_8.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_8.setBackground(new Color(240, 248, 255));
		checkBox_8.setBounds(1076, 661, 226, 41);
		panel_1.add(checkBox_8);

		JCheckBox checkBox_5 = new JCheckBox("Fish");
		checkBox_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox_5.isSelected()){  
					isFish=1;   } 
				else {
					isFish=0;
				}
			}
		});
		checkBox_5.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_5.setBackground(new Color(240, 248, 255));
		checkBox_5.setBounds(1076, 307, 269, 41);
		panel_1.add(checkBox_5);


		JComboBox comboBox = new JComboBox(); //get
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 40));
		comboBox.setBounds(366, 355, 255, 49);
		panel_1.add(comboBox);

		JTextPane txtpnCategory = new JTextPane();
		txtpnCategory.setEditable(false);
		txtpnCategory.setText("Name:");
		txtpnCategory.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txtpnCategory.setBackground(new Color(240, 248, 255));
		txtpnCategory.setBounds(452, 321, 97, 31);
		panel_1.add(txtpnCategory);

		JTextPane txtpnAdvancedSearch = new JTextPane();
		txtpnAdvancedSearch.setEditable(false);
		txtpnAdvancedSearch.setText("Add New Recipe");
		txtpnAdvancedSearch.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 80));
		txtpnAdvancedSearch.setBackground(new Color(240, 248, 255));
		txtpnAdvancedSearch.setBounds(507, 55, 886, 99);
		panel_1.add(txtpnAdvancedSearch);

		JButton btnSearch = new JButton("Add!");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((textField_1.getText().trim().isEmpty())||(textField_9.getText().trim().isEmpty())||(textField_3.getText().trim().isEmpty())||(textArea.getText().trim().isEmpty())) {
					JOptionPane.showMessageDialog(null,"One of the parameters is empty, Please fill all");
				}

				else {
					
					myView.statview.addRecipe(textField_1.getText(), isFish, isStrawberries, isCoffie, isGluten, isLactose, isMilk, isEggs, isSeeds, isTreeNuts, isPeanut, isAcidity, isChocolate, textField_9.getText(), Complexity, timeToMake, textArea.getText());
					RecipeView f=new RecipeView();
					f.setVisible(true);
					NewRecipe.this.dispose();
					NewRecipe.this.setVisible(false);
				}
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 50));
		btnSearch.setBounds(553, 1202, 326, 69);
		panel_1.add(btnSearch);

		JTextPane txtpnIngredients = new JTextPane();
		txtpnIngredients.setEditable(false);
		txtpnIngredients.setText("Add Ingredients:");
		txtpnIngredients.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnIngredients.setBackground(new Color(240, 248, 255));
		txtpnIngredients.setBounds(26, 343, 340, 61);
		panel_1.add(txtpnIngredients);

		JTextPane txtpnInstructions = new JTextPane();
		txtpnInstructions.setEditable(false);
		txtpnInstructions.setText("Instructions:");
		txtpnInstructions.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnInstructions.setBackground(new Color(240, 248, 255));
		txtpnInstructions.setBounds(32, 769, 326, 49);
		panel_1.add(txtpnInstructions);

		JTextPane txtpnAmount = new JTextPane();
		txtpnAmount.setEditable(false);
		txtpnAmount.setText("Amount:");
		txtpnAmount.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txtpnAmount.setBackground(new Color(240, 248, 255));
		txtpnAmount.setBounds(627, 321, 105, 31);
		panel_1.add(txtpnAmount);

		JTextPane txtpnMeauring = new JTextPane();
		txtpnMeauring.setEditable(false);
		txtpnMeauring.setText("Measuring:");
		txtpnMeauring.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txtpnMeauring.setBackground(new Color(240, 248, 255));
		txtpnMeauring.setBounds(763, 321, 138, 38);
		panel_1.add(txtpnMeauring);

		JTextPane textPane_2 = new JTextPane();
		textPane_2.setEditable(false);
		textPane_2.setText("Name:");
		textPane_2.setFont(new Font("Tahoma", Font.PLAIN, 45));
		textPane_2.setBackground(new Color(240, 248, 255));
		textPane_2.setBounds(32, 182, 141, 61);
		panel_1.add(textPane_2);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 45));
		textField_1.setColumns(10);
		textField_1.setBounds(177, 186, 632, 57);
		panel_1.add(textField_1);

		JTextPane textPane_3 = new JTextPane();
		textPane_3.setEditable(false);
		textPane_3.setText("Description:");
		textPane_3.setFont(new Font("Tahoma", Font.PLAIN, 45));
		textPane_3.setBackground(new Color(240, 248, 255));
		textPane_3.setBounds(32, 257, 243, 61);
		panel_1.add(textPane_3);

		textField_9 = new JTextField();
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 45));
		textField_9.setColumns(10);
		textField_9.setBounds(288, 261, 775, 57);
		panel_1.add(textField_9);


		JButton btnAddNewIngredient = new JButton("Add New Ingredient");
		btnAddNewIngredient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.Ingredient f=new view.Ingredient();
				f.setVisible(true);
			}
		});
		btnAddNewIngredient.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnAddNewIngredient.setBounds(1137, 738, 397, 69);
		panel_1.add(btnAddNewIngredient);

		String[] kashruthing = {"Parve", "Dairy", "Meat","Not Kosher"};

		JButton btnAdd_1 = new JButton("Add");
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Integer> ing=new ArrayList<Integer>();
				myView.statview.addIngredientToRecipe (myView.statview.ingredientArray.get(comboBox.getSelectedIndex()),myView.statview.myMeasuring.get(comboBox_1.getSelectedIndex()),amount);
				dataIngredients= new Object [myView.myRecipe.getRecipeIngredientId().size()][3];
				for(int row=0;row<myView.myRecipe.getRecipeIngredientId().size();row++)
				{
					dataIngredients[row][0]=myView.ingredientArrayForRecipe.get(row).getIngredientName();
					dataIngredients[row][1]=myView.myRecipe.getRecipeIngredientsAmount().get(row).toString();
					dataIngredients[row][2]=myView.myMeasuringForRecipe.get(row).getIngredientTypeName();
				}
				;
			}
		});
		btnAdd_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd_1.setBounds(973, 355, 81, 49);
		panel_1.add(btnAdd_1);

		JTextPane textPane_5 = new JTextPane();
		textPane_5.setEditable(false);
		textPane_5.setText("Complexity:");
		textPane_5.setFont(new Font("Tahoma", Font.PLAIN, 45));
		textPane_5.setBackground(new Color(240, 248, 255));
		textPane_5.setBounds(1071, 828, 243, 64);
		panel_1.add(textPane_5);

		String[] complexiting = {"Easy", "Medium", "Hard"};
		JComboBox comboBox_4 = new JComboBox(complexiting);
		comboBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox comboBox_4 = (JComboBox)e.getSource();
		        Complexity = (int)comboBox_4.getSelectedIndex();
			}
		});
		comboBox_4.setFont(new Font("Tahoma", Font.PLAIN, 40));
		comboBox_4.setBounds(1076, 893, 508, 49);
		panel_1.add(comboBox_4);

		JTextPane textPane_6 = new JTextPane();
		textPane_6.setEditable(false);
		textPane_6.setText("Cooking Time Up To:");
		textPane_6.setFont(new Font("Tahoma", Font.PLAIN, 45));
		textPane_6.setBackground(new Color(240, 248, 255));
		textPane_6.setBounds(1072, 950, 444, 64);
		panel_1.add(textPane_6);
	}	
}
