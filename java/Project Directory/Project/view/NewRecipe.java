package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.DropMode;

public class NewRecipe extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewRecipe frame = new NewRecipe();
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
	public NewRecipe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 593);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 105, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(65, 105, 225));
		panel.setBounds(15, 5, 718, 41);
		contentPane.add(panel);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("Add a Component");
		textPane.setForeground(Color.WHITE);
		textPane.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 10));
		textPane.setBackground(new Color(65, 105, 225));
		textPane.setBounds(440, 17, 150, 27);
		panel.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("Search");
		textPane_1.setForeground(Color.WHITE);
		textPane_1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 10));
		textPane_1.setBackground(new Color(65, 105, 225));
		textPane_1.setBounds(378, 17, 102, 27);
		panel.add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setText("Favourite Recipes");
		textPane_2.setForeground(Color.WHITE);
		textPane_2.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 10));
		textPane_2.setBackground(new Color(65, 105, 225));
		textPane_2.setBounds(250, 17, 146, 27);
		panel.add(textPane_2);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setText("My Recipes");
		textPane_3.setForeground(Color.WHITE);
		textPane_3.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 10));
		textPane_3.setBackground(new Color(65, 105, 225));
		textPane_3.setBounds(168, 17, 102, 27);
		panel.add(textPane_3);
		
		textField = new JTextField();
		textField.setText("Taimli");
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 34));
		textField.setColumns(10);
		textField.setBackground(new Color(65, 105, 225));
		textField.setBounds(11, 0, 386, 44);
		panel.add(textField);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setText("user details");
		textPane_4.setForeground(Color.WHITE);
		textPane_4.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 12));
		textPane_4.setBackground(new Color(65, 105, 225));
		textPane_4.setBounds(616, 14, 102, 27);
		panel.add(textPane_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 248, 255));
		panel_1.setBounds(4, 51, 718, 451);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(275, 116, 105, 31);
		panel_1.add(textField_3);
		
		JCheckBox chckbxDairy = new JCheckBox("Dairy");
		chckbxDairy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxDairy.setBackground(new Color(240, 248, 255));
		chckbxDairy.setBounds(574, 326, 88, 41);
		panel_1.add(chckbxDairy);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setBounds(608, 214, 97, 18);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JTextPane txtpnPerGrams = new JTextPane();
		txtpnPerGrams.setText("per 100 grams");
		txtpnPerGrams.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnPerGrams.setBackground(new Color(240, 248, 255));
		txtpnPerGrams.setBounds(585, 186, 120, 31);
		panel_1.add(txtpnPerGrams);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(552, 11, 153, 126);
		panel_1.add(panel_2);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_6.setColumns(10);
		textField_6.setBounds(608, 284, 97, 18);
		panel_1.add(textField_6);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_5.setColumns(10);
		textField_5.setBounds(608, 260, 97, 18);
		panel_1.add(textField_5);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(608, 238, 97, 18);
		panel_1.add(textField_4);
		
		JTextPane txtpnProtein = new JTextPane();
		txtpnProtein.setText("Protein:");
		txtpnProtein.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnProtein.setBackground(new Color(240, 248, 255));
		txtpnProtein.setBounds(532, 281, 173, 31);
		panel_1.add(txtpnProtein);
		
		JTextPane txtpnFat = new JTextPane();
		txtpnFat.setText("Fat:");
		txtpnFat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnFat.setBackground(new Color(240, 248, 255));
		txtpnFat.setBounds(532, 257, 173, 31);
		panel_1.add(txtpnFat);
		
		JTextPane txtpnSugar = new JTextPane();
		txtpnSugar.setText("Sugar:");
		txtpnSugar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnSugar.setBackground(new Color(240, 248, 255));
		txtpnSugar.setBounds(532, 234, 173, 31);
		panel_1.add(txtpnSugar);
		
		JTextPane txtpnCalories = new JTextPane();
		txtpnCalories.setText("Calories:");
		txtpnCalories.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnCalories.setBackground(new Color(240, 248, 255));
		txtpnCalories.setBounds(532, 210, 173, 31);
		panel_1.add(txtpnCalories);
		
		JCheckBox chckbxG = new JCheckBox("Gluten");
		chckbxG.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxG.setBackground(new Color(240, 248, 255));
		chckbxG.setBounds(574, 398, 96, 41);
		panel_1.add(chckbxG);
		
		JCheckBox chckbxFish = new JCheckBox("Fish");
		chckbxFish.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxFish.setBackground(new Color(240, 248, 255));
		chckbxFish.setBounds(574, 362, 96, 41);
		panel_1.add(chckbxFish);
		
		JTextPane txtpnAllergies = new JTextPane();
		txtpnAllergies.setText("Allergies:");
		txtpnAllergies.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 16));
		txtpnAllergies.setBackground(new Color(240, 248, 255));
		txtpnAllergies.setBounds(585, 306, 120, 41);
		panel_1.add(txtpnAllergies);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(137, 69, 405, 26);
		panel_1.add(textField_1);
		
		JTextPane txtpnSearchFor = new JTextPane();
		txtpnSearchFor.setText("Description:");
		txtpnSearchFor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnSearchFor.setBackground(new Color(240, 248, 255));
		txtpnSearchFor.setBounds(22, 64, 255, 31);
		panel_1.add(txtpnSearchFor);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setBounds(176, 116, 97, 31);
		panel_1.add(comboBox);
		
		JTextPane txtpnCategory = new JTextPane();
		txtpnCategory.setText("Name:");
		txtpnCategory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnCategory.setBackground(new Color(240, 248, 255));
		txtpnCategory.setBounds(176, 94, 73, 31);
		panel_1.add(txtpnCategory);
		
		JTextPane txtpnAdvancedSearch = new JTextPane();
		txtpnAdvancedSearch.setText("Add New Recipe");
		txtpnAdvancedSearch.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 30));
		txtpnAdvancedSearch.setBackground(new Color(240, 248, 255));
		txtpnAdvancedSearch.setBounds(203, 11, 418, 41);
		panel_1.add(txtpnAdvancedSearch);
		
		JButton btnSearch = new JButton("Add");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 27));
		btnSearch.setBounds(222, 398, 228, 41);
		panel_1.add(btnSearch);
		
		JTextPane txtpnNutritionValues = new JTextPane();
		txtpnNutritionValues.setText("Nutrition Values:");
		txtpnNutritionValues.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 16));
		txtpnNutritionValues.setBackground(new Color(240, 248, 255));
		txtpnNutritionValues.setBounds(540, 165, 178, 31);
		panel_1.add(txtpnNutritionValues);
		
		JButton button = new JButton("Edit Photo");
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.setBounds(578, 135, 105, 23);
		panel_1.add(button);
		
		JTextPane txtpnIngredients = new JTextPane();
		txtpnIngredients.setText("Add Ingredients:");
		txtpnIngredients.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnIngredients.setBackground(new Color(240, 248, 255));
		txtpnIngredients.setBounds(22, 94, 255, 31);
		panel_1.add(txtpnIngredients);
		
		JTextPane txtpnInstructions = new JTextPane();
		txtpnInstructions.setText("Instructions");
		txtpnInstructions.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnInstructions.setBackground(new Color(240, 248, 255));
		txtpnInstructions.setBounds(22, 271, 255, 31);
		panel_1.add(txtpnInstructions);
		
		JTextPane txtpnAmount = new JTextPane();
		txtpnAmount.setText("Amount:");
		txtpnAmount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnAmount.setBackground(new Color(240, 248, 255));
		txtpnAmount.setBounds(275, 94, 73, 31);
		panel_1.add(txtpnAmount);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_1.setBounds(382, 116, 97, 31);
		panel_1.add(comboBox_1);
		
		JTextPane txtpnMeauring = new JTextPane();
		txtpnMeauring.setText("Meauring:");
		txtpnMeauring.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnMeauring.setBackground(new Color(240, 248, 255));
		txtpnMeauring.setBounds(382, 94, 73, 31);
		panel_1.add(txtpnMeauring);
		
		JTextArea textArea = new JTextArea();
		textArea.setDropMode(DropMode.ON);
		textArea.setBounds(22, 297, 500, 126);
		panel_1.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setColumns(30);
		textArea_1.setRows(15);
		textArea_1.setBounds(22, 153, 500, 110);
		panel_1.add(textArea_1);
	}
}