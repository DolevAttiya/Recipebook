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
import javax.swing.ImageIcon;

public class RecipeView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_5;
	private JTextField txtRecipebook;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecipeView frame = new RecipeView();
					frame.setVisible(true);
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
		
		JTextPane txtpnPerGrams = new JTextPane();
		txtpnPerGrams.setText("per 100 grams");
		txtpnPerGrams.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnPerGrams.setBackground(new Color(240, 248, 255));
		txtpnPerGrams.setBounds(1238, 654, 160, 31);
		panel_1.add(txtpnPerGrams);
		
		JTextPane txtpnProtein = new JTextPane();
		txtpnProtein.setText("Protein:");
		txtpnProtein.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnProtein.setBackground(new Color(240, 248, 255));
		txtpnProtein.setBounds(1102, 864, 173, 61);
		panel_1.add(txtpnProtein);
		
		JTextPane txtpnFat = new JTextPane();
		txtpnFat.setText("Fat:");
		txtpnFat.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnFat.setBackground(new Color(240, 248, 255));
		txtpnFat.setBounds(1102, 809, 173, 61);
		panel_1.add(txtpnFat);
		
		JTextPane txtpnSugar = new JTextPane();
		txtpnSugar.setText("Sugar:");
		txtpnSugar.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnSugar.setBackground(new Color(240, 248, 255));
		txtpnSugar.setBounds(1102, 746, 173, 61);
		panel_1.add(txtpnSugar);
		
		JTextPane txtpnCalories = new JTextPane();
		txtpnCalories.setText("Calories:");
		txtpnCalories.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnCalories.setBackground(new Color(240, 248, 255));
		txtpnCalories.setBounds(1102, 687, 173, 61);
		panel_1.add(txtpnCalories);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 45));
		textField_1.setColumns(10);
		textField_1.setBounds(278, 186, 775, 57);
		panel_1.add(textField_1);
		
		JTextPane txtpnSearchFor = new JTextPane();
		txtpnSearchFor.setText("Description:");
		txtpnSearchFor.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnSearchFor.setBackground(new Color(240, 248, 255));
		txtpnSearchFor.setBounds(22, 182, 350, 61);
		panel_1.add(txtpnSearchFor);
		
		JTextPane txtpnAdvancedSearch = new JTextPane();
		txtpnAdvancedSearch.setText("Recipe");
		txtpnAdvancedSearch.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 80));
		txtpnAdvancedSearch.setBackground(new Color(240, 248, 255));
		txtpnAdvancedSearch.setBounds(507, 55, 886, 99);
		panel_1.add(txtpnAdvancedSearch);
		
		JButton btnSearch = new JButton("Add!");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 50));
		btnSearch.setBounds(608, 1138, 326, 69);
		panel_1.add(btnSearch);
		
		JTextPane txtpnNutritionValues = new JTextPane();
		txtpnNutritionValues.setText("Nutrition Values:");
		txtpnNutritionValues.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 52));
		txtpnNutritionValues.setBackground(new Color(240, 248, 255));
		txtpnNutritionValues.setBounds(1161, 598, 326, 58);
		panel_1.add(txtpnNutritionValues);
		
		JTextPane txtpnIngredients = new JTextPane();
		txtpnIngredients.setText("Ingredients:");
		txtpnIngredients.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnIngredients.setBackground(new Color(240, 248, 255));
		txtpnIngredients.setBounds(22, 252, 453, 61);
		panel_1.add(txtpnIngredients);
		
		JTextPane txtpnInstructions = new JTextPane();
		txtpnInstructions.setText("Instructions");
		txtpnInstructions.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnInstructions.setBackground(new Color(240, 248, 255));
		txtpnInstructions.setBounds(22, 630, 326, 49);
		panel_1.add(txtpnInstructions);
		
		JTextArea textArea = new JTextArea();
		//textArea.setDropMode(DropMode.ON);
		textArea.setBounds(32, 687, 1021, 423);
		panel_1.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setColumns(30);
		textArea_1.setRows(15);
		textArea_1.setBounds(32, 318, 1021, 298);
		panel_1.add(textArea_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_2.setColumns(10);
		textField_2.setBounds(1287, 699, 237, 49);
		panel_1.add(textField_2);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_4.setColumns(10);
		textField_4.setBounds(1287, 758, 237, 49);
		panel_1.add(textField_4);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_6.setColumns(10);
		textField_6.setBounds(1287, 817, 237, 49);
		panel_1.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_7.setColumns(10);
		textField_7.setBounds(1287, 876, 237, 49);
		panel_1.add(textField_7);
		
		JButton btnILikeIt = new JButton("I Like It!");
		btnILikeIt.setIcon(new ImageIcon("C:\\Users\\Adi G\\Desktop\\like.png"));
		btnILikeIt.setBackground(new Color(65, 105, 225));
		btnILikeIt.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 20));
		btnILikeIt.setBounds(1220, 954, 173, 156);
		panel_1.add(btnILikeIt);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_3.setColumns(10);
		textField_3.setBounds(1220, 1113, 173, 49);
		panel_1.add(textField_3);
	}
}