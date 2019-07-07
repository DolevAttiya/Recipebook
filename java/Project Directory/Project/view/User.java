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
import javax.swing.JPasswordField;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class User extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User frame = new User();
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
	public User() {
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
		
		JTextPane txtpnExpiryDate = new JTextPane();
		txtpnExpiryDate.setText("Expiry Date:");
		txtpnExpiryDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnExpiryDate.setBackground(new Color(240, 248, 255));
		txtpnExpiryDate.setBounds(216, 284, 153, 31);
		panel_1.add(txtpnExpiryDate);
		
		JCheckBox checkBox_2 = new JCheckBox("?");
		checkBox_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_2.setBackground(new Color(240, 248, 255));
		checkBox_2.setBounds(517, 247, 131, 41);
		panel_1.add(checkBox_2);
		
		JCheckBox chckbxFish = new JCheckBox("Fish");
		chckbxFish.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxFish.setBackground(new Color(240, 248, 255));
		chckbxFish.setBounds(398, 247, 221, 41);
		panel_1.add(chckbxFish);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(466, 28, 153, 126);
		panel_1.add(panel_2);
		
		JButton btnDeletePhoto = new JButton("Edit Photo");
		btnDeletePhoto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDeletePhoto.setBounds(486, 152, 111, 23);
		panel_1.add(btnDeletePhoto);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(32, 309, 153, 26);
		panel_1.add(textField_4);
		setVisible(true);
		
		JTextPane txtpnEnterDieticanNumber = new JTextPane();
		txtpnEnterDieticanNumber.setText("Enter Dietican Number:");
		txtpnEnterDieticanNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnEnterDieticanNumber.setBackground(new Color(240, 248, 255));
		txtpnEnterDieticanNumber.setBounds(32, 287, 255, 31);
		panel_1.add(txtpnEnterDieticanNumber);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField_1.setBounds(216, 215, 141, 21);
		panel_1.add(passwordField_1);
		
		JCheckBox checkBox_4 = new JCheckBox("?");
		checkBox_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_4.setBackground(new Color(240, 248, 255));
		checkBox_4.setBounds(517, 321, 131, 41);
		panel_1.add(checkBox_4);
		
		JCheckBox checkBox_3 = new JCheckBox("?");
		checkBox_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_3.setBackground(new Color(240, 248, 255));
		checkBox_3.setBounds(517, 284, 131, 41);
		panel_1.add(checkBox_3);
		
		JCheckBox checkBox_1 = new JCheckBox("?");
		checkBox_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_1.setBackground(new Color(240, 248, 255));
		checkBox_1.setBounds(517, 210, 131, 41);
		panel_1.add(checkBox_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(136, 101, 221, 26);
		panel_1.add(textField_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(136, 69, 221, 26);
		panel_1.add(textField_1);
		
		JTextPane txtpnSearchFor = new JTextPane();
		txtpnSearchFor.setText("First Name:");
		txtpnSearchFor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnSearchFor.setBackground(new Color(240, 248, 255));
		txtpnSearchFor.setBounds(22, 64, 255, 31);
		panel_1.add(txtpnSearchFor);
		
		JTextPane txtpnRecipeId = new JTextPane();
		txtpnRecipeId.setText("Last Name:");
		txtpnRecipeId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnRecipeId.setBackground(new Color(240, 248, 255));
		txtpnRecipeId.setBounds(22, 96, 255, 31);
		panel_1.add(txtpnRecipeId);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Kosher");
		chckbxNewCheckBox.setBackground(new Color(240, 248, 255));
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxNewCheckBox.setBounds(183, 250, 221, 41);
		panel_1.add(chckbxNewCheckBox);
		
		JTextPane txtpnAdvancedSearch = new JTextPane();
		txtpnAdvancedSearch.setText("Sign UP");
		txtpnAdvancedSearch.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 30));
		txtpnAdvancedSearch.setBackground(new Color(240, 248, 255));
		txtpnAdvancedSearch.setBounds(259, 11, 170, 41);
		panel_1.add(txtpnAdvancedSearch);
		
		JCheckBox chckbxDairy = new JCheckBox("Dairy");
		chckbxDairy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxDairy.setBackground(new Color(240, 248, 255));
		chckbxDairy.setBounds(398, 210, 221, 41);
		panel_1.add(chckbxDairy);
		
		JTextPane txtpnAllergies = new JTextPane();
		txtpnAllergies.setText("Allergies:");
		txtpnAllergies.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 22));
		txtpnAllergies.setBackground(new Color(240, 248, 255));
		txtpnAllergies.setBounds(436, 182, 153, 41);
		panel_1.add(txtpnAllergies);
		
		JCheckBox chckbxG = new JCheckBox("Gluten");
		chckbxG.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxG.setBackground(new Color(240, 248, 255));
		chckbxG.setBounds(398, 284, 221, 41);
		panel_1.add(chckbxG);
		
		JCheckBox checkBox = new JCheckBox("?");
		checkBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox.setBackground(new Color(240, 248, 255));
		checkBox.setBounds(398, 322, 221, 41);
		panel_1.add(checkBox);
		
		JButton btnSearch = new JButton("Register");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// if pass!=pass again > print an error
				// else send him to my func which I don't know it's name yet :)
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 27));
		btnSearch.setBounds(247, 382, 228, 41);
		panel_1.add(btnSearch);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(90, 142, 267, 26);
		panel_1.add(textField_3);
		
		JTextPane txtpnEmail = new JTextPane();
		txtpnEmail.setText("Email:");
		txtpnEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnEmail.setBackground(new Color(240, 248, 255));
		txtpnEmail.setBounds(22, 137, 255, 31);
		panel_1.add(txtpnEmail);
		
		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// if the count(pass)<6 -> print an error
			}
		});
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField.setBounds(216, 187, 141, 21);
		panel_1.add(passwordField);
		
		JTextPane txtpnEnterPassword = new JTextPane();
		txtpnEnterPassword.setText("Enter Password: (6 digits)");
		txtpnEnterPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnEnterPassword.setBackground(new Color(240, 248, 255));
		txtpnEnterPassword.setBounds(22, 187, 255, 31);
		panel_1.add(txtpnEnterPassword);
		
		JTextPane txtpnEnterPasswordAgain = new JTextPane();
		txtpnEnterPasswordAgain.setText("Enter Password Again:");
		txtpnEnterPasswordAgain.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnEnterPasswordAgain.setBackground(new Color(240, 248, 255));
		txtpnEnterPasswordAgain.setBounds(22, 214, 255, 31);
		panel_1.add(txtpnEnterPasswordAgain);
		
		JCheckBox chckbxDietican = new JCheckBox("Dietican");
		chckbxDietican.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxDietican.setBackground(new Color(240, 248, 255));
		chckbxDietican.setBounds(32, 247, 221, 41);
		panel_1.add(chckbxDietican);
		
		JCheckBox chckbxShowOnlyRecipes = new JCheckBox("Show only recipes adapted to allergies");
		chckbxShowOnlyRecipes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxShowOnlyRecipes.setBackground(new Color(240, 248, 255));
		chckbxShowOnlyRecipes.setBounds(32, 340, 515, 41);
		panel_1.add(chckbxShowOnlyRecipes);
	}
}
