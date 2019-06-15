package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.FlowLayout;

public class MainPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtRecipebook;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 593);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 105, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Advanced Search");
		btnNewButton.setBounds(484, 175, 171, 41);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(418, 117, 293, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(4, 51, 399, 451);
		panel.setBackground(new Color(240, 248, 255));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(15, 5, 718, 41);
		panel_1.setBackground(new Color(65, 105, 225));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JTextPane txtpnAddAComponent = new JTextPane();
		txtpnAddAComponent.setText("Add a Component");
		txtpnAddAComponent.setForeground(Color.WHITE);
		txtpnAddAComponent.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 10));
		txtpnAddAComponent.setBackground(new Color(65, 105, 225));
		txtpnAddAComponent.setBounds(440, 17, 150, 27);
		panel_1.add(txtpnAddAComponent);
		
		JTextPane txtpnSearch_1 = new JTextPane();
		txtpnSearch_1.setText("Search");
		txtpnSearch_1.setForeground(Color.WHITE);
		txtpnSearch_1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 10));
		txtpnSearch_1.setBackground(new Color(65, 105, 225));
		txtpnSearch_1.setBounds(378, 17, 102, 27);
		panel_1.add(txtpnSearch_1);
		
		JTextPane txtpnFavouriteRecipes = new JTextPane();
		txtpnFavouriteRecipes.setText("Favourite Recipes");
		txtpnFavouriteRecipes.setForeground(Color.WHITE);
		txtpnFavouriteRecipes.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 10));
		txtpnFavouriteRecipes.setBackground(new Color(65, 105, 225));
		txtpnFavouriteRecipes.setBounds(250, 17, 146, 27);
		panel_1.add(txtpnFavouriteRecipes);
		
		JTextPane txtpnMyRecipes = new JTextPane();
		txtpnMyRecipes.setText("My Recipes");
		txtpnMyRecipes.setForeground(Color.WHITE);
		txtpnMyRecipes.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 10));
		txtpnMyRecipes.setBackground(new Color(65, 105, 225));
		txtpnMyRecipes.setBounds(168, 17, 102, 27);
		panel_1.add(txtpnMyRecipes);
		
		txtRecipebook = new JTextField();
		txtRecipebook.setForeground(new Color(255, 255, 255));
		txtRecipebook.setBounds(11, 0, 386, 44);
		panel_1.add(txtRecipebook);
		txtRecipebook.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 34));
		txtRecipebook.setBackground(new Color(65, 105, 225));
		txtRecipebook.setText("Taimli");
		txtRecipebook.setColumns(10);
		
		JTextPane txtpnUserDetails = new JTextPane();
		txtpnUserDetails.setForeground(new Color(255, 255, 255));
		txtpnUserDetails.setText("user details");
		txtpnUserDetails.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 12));
		txtpnUserDetails.setBackground(new Color(65, 105, 225));
		txtpnUserDetails.setBounds(616, 14, 102, 27);
		panel_1.add(txtpnUserDetails);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(240, 248, 255));
		panel_2.setBounds(408, 51, 313, 189);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JTextPane txtpnSearch = new JTextPane();
		txtpnSearch.setBounds(57, 28, 202, 31);
		panel_2.add(txtpnSearch);
		txtpnSearch.setBackground(new Color(240, 248, 255));
		txtpnSearch.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 20));
		txtpnSearch.setText("Search a Recipe");
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(240, 248, 255));
		panel_3.setBounds(408, 244, 313, 130);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JTextPane txtpnAddNewRecipe = new JTextPane();
		txtpnAddNewRecipe.setBounds(32, 44, 255, 31);
		txtpnAddNewRecipe.setText("Add new Recipe");
		txtpnAddNewRecipe.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 25));
		txtpnAddNewRecipe.setBackground(new Color(240, 248, 255));
		panel_3.add(txtpnAddNewRecipe);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(240, 248, 255));
		panel_4.setBounds(408, 381, 313, 121);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JTextPane txtpnAllRecipes = new JTextPane();
		txtpnAllRecipes.setBounds(82, 44, 205, 31);
		txtpnAllRecipes.setText("All Recipes");
		txtpnAllRecipes.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 25));
		txtpnAllRecipes.setBackground(new Color(240, 248, 255));
		panel_4.add(txtpnAllRecipes);
	}
}
