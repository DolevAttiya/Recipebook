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

public class Component extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Component frame = new Component();
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
	public Component() {
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
		
		JCheckBox checkBox_5 = new JCheckBox("Kosher");
		checkBox_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_5.setBackground(new Color(240, 248, 255));
		checkBox_5.setBounds(437, 302, 221, 41);
		panel_1.add(checkBox_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_6.setColumns(10);
		textField_6.setBounds(513, 267, 122, 18);
		panel_1.add(textField_6);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_5.setColumns(10);
		textField_5.setBounds(513, 243, 122, 18);
		panel_1.add(textField_5);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(513, 221, 122, 18);
		panel_1.add(textField_4);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setBounds(513, 197, 122, 18);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JTextPane txtpnProtein = new JTextPane();
		txtpnProtein.setText("Protein:");
		txtpnProtein.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnProtein.setBackground(new Color(240, 248, 255));
		txtpnProtein.setBounds(437, 264, 255, 31);
		panel_1.add(txtpnProtein);
		
		JTextPane txtpnFat = new JTextPane();
		txtpnFat.setText("Fat:");
		txtpnFat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnFat.setBackground(new Color(240, 248, 255));
		txtpnFat.setBounds(437, 240, 255, 31);
		panel_1.add(txtpnFat);
		
		JTextPane txtpnSugar = new JTextPane();
		txtpnSugar.setText("Sugar:");
		txtpnSugar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnSugar.setBackground(new Color(240, 248, 255));
		txtpnSugar.setBounds(437, 217, 255, 31);
		panel_1.add(txtpnSugar);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(506, 217, 186, 26);
		panel_1.add(textField_3);
		
		JTextPane txtpnCalories = new JTextPane();
		txtpnCalories.setText("Calories:");
		txtpnCalories.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnCalories.setBackground(new Color(240, 248, 255));
		txtpnCalories.setBounds(437, 193, 255, 31);
		panel_1.add(txtpnCalories);
		
		JCheckBox checkBox_3 = new JCheckBox("?");
		checkBox_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_3.setBackground(new Color(240, 248, 255));
		checkBox_3.setBounds(292, 269, 131, 41);
		panel_1.add(checkBox_3);
		
		JCheckBox checkBox = new JCheckBox("?");
		checkBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox.setBackground(new Color(240, 248, 255));
		checkBox.setBounds(173, 307, 221, 41);
		panel_1.add(checkBox);
		
		JCheckBox checkBox_2 = new JCheckBox("?");
		checkBox_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_2.setBackground(new Color(240, 248, 255));
		checkBox_2.setBounds(292, 232, 131, 41);
		panel_1.add(checkBox_2);
		
		JCheckBox chckbxG = new JCheckBox("Gluten");
		chckbxG.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxG.setBackground(new Color(240, 248, 255));
		chckbxG.setBounds(173, 269, 221, 41);
		panel_1.add(chckbxG);
		
		JCheckBox checkBox_1 = new JCheckBox("?");
		checkBox_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_1.setBackground(new Color(240, 248, 255));
		checkBox_1.setBounds(292, 195, 131, 41);
		panel_1.add(checkBox_1);
		
		JCheckBox chckbxFish = new JCheckBox("Fish");
		chckbxFish.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxFish.setBackground(new Color(240, 248, 255));
		chckbxFish.setBounds(173, 232, 221, 41);
		panel_1.add(chckbxFish);
		
		JCheckBox checkBox_4 = new JCheckBox("?");
		checkBox_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_4.setBackground(new Color(240, 248, 255));
		checkBox_4.setBounds(292, 306, 131, 41);
		panel_1.add(checkBox_4);
		
		JTextPane txtpnAllergies = new JTextPane();
		txtpnAllergies.setText("Allergies:");
		txtpnAllergies.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 22));
		txtpnAllergies.setBackground(new Color(240, 248, 255));
		txtpnAllergies.setBounds(201, 148, 153, 41);
		panel_1.add(txtpnAllergies);
		
		JCheckBox chckbxDairy = new JCheckBox("Dairy");
		chckbxDairy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxDairy.setBackground(new Color(240, 248, 255));
		chckbxDairy.setBounds(173, 195, 221, 41);
		panel_1.add(chckbxDairy);
		
		JCheckBox chckbxMiliter = new JCheckBox("Militer");
		chckbxMiliter.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxMiliter.setBackground(new Color(240, 248, 255));
		chckbxMiliter.setBounds(12, 323, 221, 41);
		panel_1.add(chckbxMiliter);
		
		JCheckBox chckbxSpoon = new JCheckBox("Spoon");
		chckbxSpoon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxSpoon.setBackground(new Color(240, 248, 255));
		chckbxSpoon.setBounds(12, 246, 221, 41);
		panel_1.add(chckbxSpoon);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Cup");
		chckbxNewCheckBox.setBackground(new Color(240, 248, 255));
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxNewCheckBox.setBounds(12, 209, 221, 41);
		panel_1.add(chckbxNewCheckBox);
		
		JCheckBox chckbxGrams = new JCheckBox("Grams");
		chckbxGrams.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxGrams.setBackground(new Color(240, 248, 255));
		chckbxGrams.setBounds(12, 284, 221, 41);
		panel_1.add(chckbxGrams);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(213, 69, 293, 26);
		panel_1.add(textField_1);
		
		JTextPane txtpnSearchFor = new JTextPane();
		txtpnSearchFor.setText("Component Name:");
		txtpnSearchFor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnSearchFor.setBackground(new Color(240, 248, 255));
		txtpnSearchFor.setBounds(22, 64, 255, 31);
		panel_1.add(txtpnSearchFor);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setBounds(163, 100, 166, 31);
		panel_1.add(comboBox);
		
		JTextPane txtpnCategory = new JTextPane();
		txtpnCategory.setText("Category:");
		txtpnCategory.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnCategory.setBackground(new Color(240, 248, 255));
		txtpnCategory.setBounds(22, 100, 255, 31);
		panel_1.add(txtpnCategory);
		
		JTextPane txtpnComplexity = new JTextPane();
		txtpnComplexity.setText("Measuring Types:");
		txtpnComplexity.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtpnComplexity.setBackground(new Color(240, 248, 255));
		txtpnComplexity.setBounds(22, 148, 153, 69);
		panel_1.add(txtpnComplexity);
		
		JTextPane txtpnAdvancedSearch = new JTextPane();
		txtpnAdvancedSearch.setText("Add an Ingredient");
		txtpnAdvancedSearch.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 30));
		txtpnAdvancedSearch.setBackground(new Color(240, 248, 255));
		txtpnAdvancedSearch.setBounds(203, 11, 418, 41);
		panel_1.add(txtpnAdvancedSearch);
		
		JButton btnSearch = new JButton("Add");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 27));
		btnSearch.setBounds(243, 382, 228, 41);
		panel_1.add(btnSearch);
		
		JTextPane txtpnNutritionValues = new JTextPane();
		txtpnNutritionValues.setText("Nutrition Values:");
		txtpnNutritionValues.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 22));
		txtpnNutritionValues.setBackground(new Color(240, 248, 255));
		txtpnNutritionValues.setBounds(445, 148, 247, 31);
		panel_1.add(txtpnNutritionValues);
		
		JTextPane txtpnPerGrams = new JTextPane();
		txtpnPerGrams.setText("per 100 grams");
		txtpnPerGrams.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnPerGrams.setBackground(new Color(240, 248, 255));
		txtpnPerGrams.setBounds(513, 173, 95, 31);
		panel_1.add(txtpnPerGrams);
	}
}