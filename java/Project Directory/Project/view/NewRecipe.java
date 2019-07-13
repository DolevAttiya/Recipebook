
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
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.JList;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import java.awt.TextArea;

public class NewRecipe extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_5;
	private JTextField textField_3;
	private JTextField txtRecipebook;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_1;
	private JTextField textField_9;

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

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		textField_2.setColumns(10);
		textField_2.setBounds(747, 37, 340, 43);
		panel.add(textField_2);

		JTextPane txtpnUserDetails = new JTextPane();
		txtpnUserDetails.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				User f=new User();
				f.setVisible(true);
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
		txtpnFavouriteRecipes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
		
		TextArea textArea = new TextArea();
		textArea.setBounds(32, 824, 1011, 282);
		panel_1.add(textArea);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		comboBox_1.setBounds(738, 355, 229, 49);
		panel_1.add(comboBox_1);


		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(627, 355, 105, 49);
		panel_1.add(textField_3);

		//ALLERGIES
				JCheckBox checkBox_7 = new JCheckBox("Gluten");
				checkBox_7.setFont(new Font("Tahoma", Font.PLAIN, 40));
				checkBox_7.setBackground(new Color(240, 248, 255));
				checkBox_7.setBounds(1076, 515, 255, 41);
				panel_1.add(checkBox_7);
				
				JCheckBox checkBox_4 = new JCheckBox("Eggs");
				checkBox_4.setFont(new Font("Tahoma", Font.PLAIN, 40));
				checkBox_4.setBackground(new Color(240, 248, 255));
				checkBox_4.setBounds(1342, 300, 243, 55);
				panel_1.add(checkBox_4);
				
				JCheckBox checkBox_11 = new JCheckBox("Food Acidity");
				checkBox_11.setFont(new Font("Tahoma", Font.PLAIN, 40));
				checkBox_11.setBackground(new Color(240, 248, 255));
				checkBox_11.setBounds(1342, 588, 265, 41);
				panel_1.add(checkBox_11);
				
				JCheckBox checkBox_1 = new JCheckBox("Seeds");
				checkBox_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
				checkBox_1.setBackground(new Color(240, 248, 255));
				checkBox_1.setBounds(1342, 375, 243, 41);
				panel_1.add(checkBox_1);
				
				JCheckBox checkBox_9 = new JCheckBox("Lactose");
				checkBox_9.setFont(new Font("Tahoma", Font.PLAIN, 40));
				checkBox_9.setBackground(new Color(240, 248, 255));
				checkBox_9.setBounds(1076, 588, 226, 41);
				panel_1.add(checkBox_9);
				
				JCheckBox checkBox = new JCheckBox("Peanut");
				checkBox.setFont(new Font("Tahoma", Font.PLAIN, 40));
				checkBox.setBackground(new Color(240, 248, 255));
				checkBox.setBounds(1342, 515, 192, 41);
				panel_1.add(checkBox);
				
				JCheckBox checkBox_10 = new JCheckBox("Chocolate");
				checkBox_10.setFont(new Font("Tahoma", Font.PLAIN, 40));
				checkBox_10.setBackground(new Color(240, 248, 255));
				checkBox_10.setBounds(1342, 661, 243, 41);
				panel_1.add(checkBox_10);
				
				JTextPane textPane = new JTextPane();
				textPane.setText("Allergies:");
				textPane.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 52));
				textPane.setBackground(new Color(240, 248, 255));
				textPane.setBounds(1154, 227, 340, 72);
				panel_1.add(textPane);
				
				JCheckBox checkBox_3 = new JCheckBox("Tree Nuts");
				checkBox_3.setFont(new Font("Tahoma", Font.PLAIN, 40));
				checkBox_3.setBackground(new Color(240, 248, 255));
				checkBox_3.setBounds(1342, 442, 231, 41);
				panel_1.add(checkBox_3);
				
				JCheckBox checkBox_2 = new JCheckBox("Strawberries");
				checkBox_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
				checkBox_2.setBackground(new Color(240, 248, 255));
				checkBox_2.setBounds(1076, 375, 269, 41);
				panel_1.add(checkBox_2);
				
				JCheckBox checkBox_6 = new JCheckBox("Coffie");
				checkBox_6.setFont(new Font("Tahoma", Font.PLAIN, 40));
				checkBox_6.setBackground(new Color(240, 248, 255));
				checkBox_6.setBounds(1076, 442, 269, 41);
				panel_1.add(checkBox_6);
				
				JCheckBox checkBox_8 = new JCheckBox("Dairy");
				checkBox_8.setFont(new Font("Tahoma", Font.PLAIN, 40));
				checkBox_8.setBackground(new Color(240, 248, 255));
				checkBox_8.setBounds(1076, 661, 226, 41);
				panel_1.add(checkBox_8);
				
				JCheckBox checkBox_5 = new JCheckBox("Fish");
				checkBox_5.setFont(new Font("Tahoma", Font.PLAIN, 40));
				checkBox_5.setBackground(new Color(240, 248, 255));
				checkBox_5.setBounds(1076, 307, 269, 41);
				panel_1.add(checkBox_5);
		
		JTextPane txtpnPerGrams = new JTextPane();
		txtpnPerGrams.setText("per 100 grams");
		txtpnPerGrams.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnPerGrams.setBackground(new Color(240, 248, 255));
		txtpnPerGrams.setBounds(1264, 825, 160, 31);
		panel_1.add(txtpnPerGrams);

		JTextPane txtpnProtein = new JTextPane();
		txtpnProtein.setText("Protein:");
		txtpnProtein.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnProtein.setBackground(new Color(240, 248, 255));
		txtpnProtein.setBounds(1128, 1035, 173, 61);
		panel_1.add(txtpnProtein);

		JTextPane txtpnFat = new JTextPane();
		txtpnFat.setText("Fat:");
		txtpnFat.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnFat.setBackground(new Color(240, 248, 255));
		txtpnFat.setBounds(1128, 980, 173, 61);
		panel_1.add(txtpnFat);

		JTextPane txtpnSugar = new JTextPane();
		txtpnSugar.setText("Carbs:");
		txtpnSugar.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnSugar.setBackground(new Color(240, 248, 255));
		txtpnSugar.setBounds(1128, 917, 173, 61);
		panel_1.add(txtpnSugar);

		JTextPane txtpnCalories = new JTextPane();
		txtpnCalories.setText("Calories:");
		txtpnCalories.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnCalories.setBackground(new Color(240, 248, 255));
		txtpnCalories.setBounds(1128, 858, 173, 61);
		panel_1.add(txtpnCalories);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 40));
		comboBox.setBounds(366, 355, 255, 49);
		panel_1.add(comboBox);

		JTextPane txtpnCategory = new JTextPane();
		txtpnCategory.setText("Name:");
		txtpnCategory.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txtpnCategory.setBackground(new Color(240, 248, 255));
		txtpnCategory.setBounds(452, 321, 97, 31);
		panel_1.add(txtpnCategory);

		JTextPane txtpnAdvancedSearch = new JTextPane();
		txtpnAdvancedSearch.setText("Add New Recipe");
		txtpnAdvancedSearch.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 80));
		txtpnAdvancedSearch.setBackground(new Color(240, 248, 255));
		txtpnAdvancedSearch.setBounds(507, 55, 886, 99);
		panel_1.add(txtpnAdvancedSearch);

		JButton btnSearch = new JButton("Add!");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 50));
		btnSearch.setBounds(553, 1202, 326, 69);
		panel_1.add(btnSearch);

		JTextPane txtpnNutritionValues = new JTextPane();
		txtpnNutritionValues.setText("Nutrition Values:");
		txtpnNutritionValues.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 52));
		txtpnNutritionValues.setBackground(new Color(240, 248, 255));
		txtpnNutritionValues.setBounds(1187, 769, 326, 58);
		panel_1.add(txtpnNutritionValues);

		JTextPane txtpnIngredients = new JTextPane();
		txtpnIngredients.setText("Add Ingredients:");
		txtpnIngredients.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnIngredients.setBackground(new Color(240, 248, 255));
		txtpnIngredients.setBounds(26, 343, 340, 61);
		panel_1.add(txtpnIngredients);

		JTextPane txtpnInstructions = new JTextPane();
		txtpnInstructions.setText("Instructions:");
		txtpnInstructions.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnInstructions.setBackground(new Color(240, 248, 255));
		txtpnInstructions.setBounds(32, 769, 326, 49);
		panel_1.add(txtpnInstructions);

		JTextPane txtpnAmount = new JTextPane();
		txtpnAmount.setText("Amount:");
		txtpnAmount.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txtpnAmount.setBackground(new Color(240, 248, 255));
		txtpnAmount.setBounds(627, 321, 105, 31);
		panel_1.add(txtpnAmount);

		JTextPane txtpnMeauring = new JTextPane();
		txtpnMeauring.setText("Measuring:");
		txtpnMeauring.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txtpnMeauring.setBackground(new Color(240, 248, 255));
		txtpnMeauring.setBounds(763, 321, 138, 38);
		panel_1.add(txtpnMeauring);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_2.setColumns(10);
		textField_2.setBounds(1313, 870, 237, 49);
		panel_1.add(textField_2);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_4.setColumns(10);
		textField_4.setBounds(1313, 929, 237, 49);
		panel_1.add(textField_4);

		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_6.setColumns(10);
		textField_6.setBounds(1313, 988, 237, 49);
		panel_1.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_7.setColumns(10);
		textField_7.setBounds(1313, 1047, 237, 49);
		panel_1.add(textField_7);
		
		TextArea textArea_1 = new TextArea();
		textArea_1.setBounds(32, 419, 1021, 357);
		panel_1.add(textArea_1);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("Kashruth:");
		textPane_1.setFont(new Font("Tahoma", Font.PLAIN, 45));
		textPane_1.setBackground(new Color(240, 248, 255));
		textPane_1.setBounds(26, 1112, 198, 49);
		panel_1.add(textPane_1);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 45));
		textField_8.setColumns(10);
		textField_8.setBounds(233, 1112, 300, 57);
		panel_1.add(textField_8);
		
		JTextPane textPane_2 = new JTextPane();
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
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAdd.setBounds(975, 355, 79, 49);
		panel_1.add(btnAdd);
	}	
}
