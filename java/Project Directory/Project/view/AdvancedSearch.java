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
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdvancedSearch extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtRecipebook;
	private JTextField textField_5;
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
	public void close() {
		WindowEvent winClosingEvent= new WindowEvent (this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);}

	/**
	 * Create the frame.
	 */
	public AdvancedSearch() {
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
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(1512, 0, 79, 73);
		panel.add(panel_3);
		
		JTextPane txtpnUserDetails = new JTextPane();
		txtpnUserDetails.setBounds(1371, 7, 175, 82);
		panel.add(txtpnUserDetails);
		txtpnUserDetails.setForeground(new Color(255, 255, 255));
		txtpnUserDetails.setText("user details");
		txtpnUserDetails.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 28));
		txtpnUserDetails.setBackground(new Color(65, 105, 225));
		
		JTextPane txtpnAdvancedSearch_1 = new JTextPane();
		txtpnAdvancedSearch_1.setText("Advanced Search");
		txtpnAdvancedSearch_1.setForeground(Color.WHITE);
		txtpnAdvancedSearch_1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 28));
		txtpnAdvancedSearch_1.setBackground(new Color(65, 105, 225));
		txtpnAdvancedSearch_1.setBounds(1146, 7, 215, 80);
		panel.add(txtpnAdvancedSearch_1);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 40));
		textField_5.setColumns(10);
		textField_5.setBounds(747, 37, 340, 43);
		panel.add(textField_5);
		
		JTextPane txtpnFavouriteRecipes = new JTextPane();
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
				MyRecipes r=new MyRecipes();
				r.setVisible(true);
				close();
			}
		});
		txtpnMyRecipes.setText("My Recipes");
		txtpnMyRecipes.setForeground(Color.WHITE);
		txtpnMyRecipes.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 28));
		txtpnMyRecipes.setBackground(new Color(65, 105, 225));
		txtpnMyRecipes.setBounds(347, 7, 175, 80);
		panel.add(txtpnMyRecipes);
		
		txtRecipebook = new JTextField();
		txtRecipebook.setForeground(new Color(255, 255, 255));
		txtRecipebook.setBounds(11, 0, 386, 87);
		panel.add(txtRecipebook);
		txtRecipebook.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 70));
		txtRecipebook.setBackground(new Color(65, 105, 225));
		txtRecipebook.setText("Taimli");
		txtRecipebook.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 248, 255));
		panel_1.setBounds(11, 106, 1610, 1299);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JCheckBox checkBox_2 = new JCheckBox("Peanut");
		checkBox_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_2.setBackground(new Color(240, 248, 255));
		checkBox_2.setBounds(1279, 671, 281, 41);
		panel_1.add(checkBox_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 45));
		comboBox_1.setBounds(373, 504, 317, 49);
		panel_1.add(comboBox_1);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setFont(new Font("Tahoma", Font.PLAIN, 45));
		comboBox_4.setBounds(373, 427, 317, 49);
		panel_1.add(comboBox_4);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_1.setColumns(10);
		textField_1.setBounds(297, 220, 1246, 58);
		panel_1.add(textField_1);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 45));
		comboBox_3.setBounds(307, 617, 90, 53);
		panel_1.add(comboBox_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 45));
		comboBox.setBounds(373, 352, 317, 49);
		panel_1.add(comboBox);
		
		JTextPane txtpnCategory = new JTextPane();
		txtpnCategory.setText("Category:");
		txtpnCategory.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnCategory.setBackground(new Color(240, 248, 255));
		txtpnCategory.setBounds(50, 341, 317, 64);
		panel_1.add(txtpnCategory);
		
		JTextPane txtpnRateAbove = new JTextPane();
		txtpnRateAbove.setText("Rate Above:");
		txtpnRateAbove.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnRateAbove.setBackground(new Color(240, 248, 255));
		txtpnRateAbove.setBounds(50, 606, 255, 64);
		panel_1.add(txtpnRateAbove);
		
		JTextPane txtpnAdvancedSearch = new JTextPane();
		txtpnAdvancedSearch.setText("Advanced Search");
		txtpnAdvancedSearch.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 80));
		txtpnAdvancedSearch.setBackground(new Color(240, 248, 255));
		txtpnAdvancedSearch.setBounds(307, 56, 1061, 99);
		panel_1.add(txtpnAdvancedSearch);
		
		JButton btnSearch = new JButton("Search!");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 50));
		btnSearch.setBounds(607, 1068, 326, 69);
		panel_1.add(btnSearch);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("Allergies:");
		textPane.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 52));
		textPane.setBackground(new Color(240, 248, 255));
		textPane.setBounds(1091, 383, 340, 72);
		panel_1.add(textPane);
		
		JCheckBox checkBox_8 = new JCheckBox("Show only Kosher Recipies");
		checkBox_8.setFont(new Font("Tahoma", Font.PLAIN, 45));
		checkBox_8.setBackground(new Color(240, 248, 255));
		checkBox_8.setBounds(50, 758, 697, 64);
		panel_1.add(checkBox_8);
		
		JTextPane txtpnSearchFor = new JTextPane();
		txtpnSearchFor.setText("Search For:");
		txtpnSearchFor.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnSearchFor.setBackground(new Color(240, 248, 255));
		txtpnSearchFor.setBounds(50, 215, 332, 63);
		panel_1.add(txtpnSearchFor);
		
		JTextPane txtpnComplexity_1 = new JTextPane();
		txtpnComplexity_1.setText("Complexity:");
		txtpnComplexity_1.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnComplexity_1.setBackground(new Color(240, 248, 255));
		txtpnComplexity_1.setBounds(50, 416, 317, 64);
		panel_1.add(txtpnComplexity_1);
		
		JTextPane txtpnCookingTime = new JTextPane();
		txtpnCookingTime.setText("Cooking Time:");
		txtpnCookingTime.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnCookingTime.setBackground(new Color(240, 248, 255));
		txtpnCookingTime.setBounds(50, 493, 317, 64);
		panel_1.add(txtpnCookingTime);
		
		JCheckBox checkBox = new JCheckBox("Seeds");
		checkBox.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox.setBackground(new Color(240, 248, 255));
		checkBox.setBounds(1279, 531, 281, 41);
		panel_1.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("Strawberries");
		checkBox_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_1.setBackground(new Color(240, 248, 255));
		checkBox_1.setBounds(999, 531, 345, 41);
		panel_1.add(checkBox_1);
		
		JCheckBox checkBox_3 = new JCheckBox("Tree Nuts");
		checkBox_3.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_3.setBackground(new Color(240, 248, 255));
		checkBox_3.setBounds(1279, 598, 281, 41);
		panel_1.add(checkBox_3);
		
		JCheckBox checkBox_4 = new JCheckBox("Eggs");
		checkBox_4.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_4.setBackground(new Color(240, 248, 255));
		checkBox_4.setBounds(1279, 456, 281, 55);
		panel_1.add(checkBox_4);
		
		JCheckBox checkBox_5 = new JCheckBox("Fish");
		checkBox_5.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_5.setBackground(new Color(240, 248, 255));
		checkBox_5.setBounds(999, 463, 345, 41);
		panel_1.add(checkBox_5);
		
		JCheckBox checkBox_6 = new JCheckBox("Coffie");
		checkBox_6.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_6.setBackground(new Color(240, 248, 255));
		checkBox_6.setBounds(999, 598, 345, 41);
		panel_1.add(checkBox_6);
		
		JCheckBox checkBox_7 = new JCheckBox("Gluten");
		checkBox_7.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_7.setBackground(new Color(240, 248, 255));
		checkBox_7.setBounds(999, 671, 345, 41);
		panel_1.add(checkBox_7);
		
		JCheckBox checkBox_9 = new JCheckBox("Dairy");
		checkBox_9.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_9.setBackground(new Color(240, 248, 255));
		checkBox_9.setBounds(999, 817, 226, 41);
		panel_1.add(checkBox_9);
		
		JCheckBox checkBox_10 = new JCheckBox("Lactose");
		checkBox_10.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_10.setBackground(new Color(240, 248, 255));
		checkBox_10.setBounds(999, 744, 226, 41);
		panel_1.add(checkBox_10);
		
		JCheckBox checkBox_11 = new JCheckBox("Chocolate");
		checkBox_11.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_11.setBackground(new Color(240, 248, 255));
		checkBox_11.setBounds(1279, 817, 281, 41);
		panel_1.add(checkBox_11);
		
		JCheckBox checkBox_12 = new JCheckBox("Food Acidity");
		checkBox_12.setFont(new Font("Tahoma", Font.PLAIN, 40));
		checkBox_12.setBackground(new Color(240, 248, 255));
		checkBox_12.setBounds(1279, 744, 281, 41);
		panel_1.add(checkBox_12);
	}
}
