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

public class AdvancedSearch extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdvancedSearch frame = new AdvancedSearch();
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
	public AdvancedSearch() {
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
		
		JCheckBox checkBox_4 = new JCheckBox("?");
		checkBox_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_4.setBackground(new Color(240, 248, 255));
		checkBox_4.setBounds(546, 278, 131, 41);
		panel_1.add(checkBox_4);
		
		JCheckBox checkBox_3 = new JCheckBox("?");
		checkBox_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_3.setBackground(new Color(240, 248, 255));
		checkBox_3.setBounds(546, 241, 131, 41);
		panel_1.add(checkBox_3);
		
		JCheckBox checkBox_2 = new JCheckBox("?");
		checkBox_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_2.setBackground(new Color(240, 248, 255));
		checkBox_2.setBounds(546, 204, 131, 41);
		panel_1.add(checkBox_2);
		
		JCheckBox checkBox_1 = new JCheckBox("?");
		checkBox_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_1.setBackground(new Color(240, 248, 255));
		checkBox_1.setBounds(546, 167, 131, 41);
		panel_1.add(checkBox_1);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_3.setBounds(147, 251, 90, 31);
		panel_1.add(comboBox_3);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_1.setBounds(163, 153, 166, 31);
		panel_1.add(comboBox_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(136, 69, 293, 26);
		panel_1.add(textField_1);
		
		JTextPane txtpnSearchFor = new JTextPane();
		txtpnSearchFor.setText("Search For:");
		txtpnSearchFor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnSearchFor.setBackground(new Color(240, 248, 255));
		txtpnSearchFor.setBounds(22, 64, 255, 31);
		panel_1.add(txtpnSearchFor);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setBounds(163, 119, 166, 31);
		panel_1.add(comboBox);
		
		JTextPane txtpnCategory = new JTextPane();
		txtpnCategory.setText("Category:");
		txtpnCategory.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnCategory.setBackground(new Color(240, 248, 255));
		txtpnCategory.setBounds(22, 119, 255, 31);
		panel_1.add(txtpnCategory);
		
		JTextPane txtpnComplexity = new JTextPane();
		txtpnComplexity.setText("Complexity:");
		txtpnComplexity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnComplexity.setBackground(new Color(240, 248, 255));
		txtpnComplexity.setBounds(22, 153, 255, 31);
		panel_1.add(txtpnComplexity);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_2.setBounds(163, 188, 166, 31);
		panel_1.add(comboBox_2);
		
		JTextPane txtpnCookingTime = new JTextPane();
		txtpnCookingTime.setText("Cooking Time:");
		txtpnCookingTime.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnCookingTime.setBackground(new Color(240, 248, 255));
		txtpnCookingTime.setBounds(22, 188, 255, 31);
		panel_1.add(txtpnCookingTime);
		
		JTextPane txtpnRateAbove = new JTextPane();
		txtpnRateAbove.setText("Rate Above:");
		txtpnRateAbove.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnRateAbove.setBackground(new Color(240, 248, 255));
		txtpnRateAbove.setBounds(22, 251, 255, 31);
		panel_1.add(txtpnRateAbove);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Kosher");
		chckbxNewCheckBox.setBackground(new Color(240, 248, 255));
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxNewCheckBox.setBounds(22, 294, 221, 41);
		panel_1.add(chckbxNewCheckBox);
		
		JTextPane txtpnAdvancedSearch = new JTextPane();
		txtpnAdvancedSearch.setText("Advanced Search");
		txtpnAdvancedSearch.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 30));
		txtpnAdvancedSearch.setBackground(new Color(240, 248, 255));
		txtpnAdvancedSearch.setBounds(203, 11, 418, 41);
		panel_1.add(txtpnAdvancedSearch);
		
		JCheckBox chckbxDairy = new JCheckBox("Dairy");
		chckbxDairy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxDairy.setBackground(new Color(240, 248, 255));
		chckbxDairy.setBounds(427, 167, 221, 41);
		panel_1.add(chckbxDairy);
		
		JTextPane txtpnAllergies = new JTextPane();
		txtpnAllergies.setText("Allergies:");
		txtpnAllergies.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 22));
		txtpnAllergies.setBackground(new Color(240, 248, 255));
		txtpnAllergies.setBounds(499, 127, 153, 41);
		panel_1.add(txtpnAllergies);
		
		JCheckBox chckbxFish = new JCheckBox("Fish");
		chckbxFish.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxFish.setBackground(new Color(240, 248, 255));
		chckbxFish.setBounds(427, 204, 221, 41);
		panel_1.add(chckbxFish);
		
		JCheckBox chckbxG = new JCheckBox("Gluten");
		chckbxG.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxG.setBackground(new Color(240, 248, 255));
		chckbxG.setBounds(427, 241, 221, 41);
		panel_1.add(chckbxG);
		
		JCheckBox checkBox = new JCheckBox("?");
		checkBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox.setBackground(new Color(240, 248, 255));
		checkBox.setBounds(427, 279, 221, 41);
		panel_1.add(checkBox);
		
		JButton btnSearch = new JButton("Search!");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 27));
		btnSearch.setBounds(255, 361, 228, 41);
		panel_1.add(btnSearch);
	}
}
