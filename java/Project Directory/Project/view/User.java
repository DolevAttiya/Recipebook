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

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JEditorPane;

import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import java.awt.Choice;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

public class User extends JFrame {

	private JPanel contentPane;
	private JPanel contentPane_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_7;
	private JTextField textField_8;
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
	public User() {
		setSize(1664, 1493);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
		contentPane = new JPanel();
		contentPane_1 = new JPanel();
		contentPane_1.setBackground(new Color(65, 105, 225));
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_1);
		contentPane_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(26, 15, 1603, 87);
		panel.setBackground(new Color(65, 105, 225));
		contentPane_1.add(panel);
		panel.setLayout(null);
		
		JTextPane txtpnUserDetails = new JTextPane();
		txtpnUserDetails.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				User f=new User();
				f.setVisible(true);
				User.this.dispose();
				User.this.setVisible(false);
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
				User.this.dispose();
				User.this.setVisible(false);
			}
		});
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
		txtpnFavouriteRecipes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MyFavourites f=new MyFavourites();
				f.setVisible(true);
				User.this.dispose();
				User.this.setVisible(false);
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
				User.this.dispose();
				User.this.setVisible(false);
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
				User.this.dispose();
				User.this.setVisible(false);
			}
		});
		txtpnTaimli.setText("Taimli");
		txtpnTaimli.setForeground(Color.WHITE);
		txtpnTaimli.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 80));
		txtpnTaimli.setBackground(new Color(65, 105, 225));
		txtpnTaimli.setBounds(0, -7, 343, 96);
		panel.add(txtpnTaimli);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 248, 255));
		panel_1.setBounds(11, 106, 1610, 1299);
		contentPane_1.add(panel_1);
		panel_1.setLayout(null);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_4.setColumns(10);
		textField_4.setBounds(738, 695, 237, 49);
		panel_1.add(textField_4);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_8.setColumns(10);
		textField_8.setBounds(738, 632, 237, 49);
		panel_1.add(textField_8);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_7.setColumns(10);
		textField_7.setBounds(553, 520, 456, 49);
		panel_1.add(textField_7);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_2.setColumns(10);
		textField_2.setBounds(553, 461, 456, 49);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_3.setColumns(10);
		textField_3.setBounds(205, 337, 804, 49);
		panel_1.add(textField_3);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_6.setColumns(10);
		textField_6.setBounds(316, 254, 693, 49);
		panel_1.add(textField_6);
		
		JCheckBox chckbxSeeds = new JCheckBox("Seeds");
		chckbxSeeds.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxSeeds.setBackground(new Color(240, 248, 255));
		chckbxSeeds.setBounds(1307, 783, 281, 41);
		panel_1.add(chckbxSeeds);
		
		JCheckBox chckbxFish = new JCheckBox("Strawberries");
		chckbxFish.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxFish.setBackground(new Color(240, 248, 255));
		chckbxFish.setBounds(1027, 783, 345, 41);
		panel_1.add(chckbxFish);
		
		JButton btnDeletePhoto = new JButton("Edit Photo");
		btnDeletePhoto.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnDeletePhoto.setBounds(1274, 552, 161, 31);
		panel_1.add(btnDeletePhoto);
		setVisible(true);
		
		JTextPane txtpnEnterDieticanNumber = new JTextPane();
		txtpnEnterDieticanNumber.setText("Enter Dietican Number:");
		txtpnEnterDieticanNumber.setFont(new Font("Tahoma", Font.PLAIN, 38));
		txtpnEnterDieticanNumber.setBackground(new Color(240, 248, 255));
		txtpnEnterDieticanNumber.setBounds(316, 632, 443, 55);
		panel_1.add(txtpnEnterDieticanNumber);
		
		JCheckBox chckbxPeanut = new JCheckBox("Peanut");
		chckbxPeanut.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxPeanut.setBackground(new Color(240, 248, 255));
		chckbxPeanut.setBounds(1307, 923, 281, 41);
		panel_1.add(chckbxPeanut);
		
		JCheckBox chckbxTreeNuts = new JCheckBox("Tree Nuts");
		chckbxTreeNuts.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxTreeNuts.setBackground(new Color(240, 248, 255));
		chckbxTreeNuts.setBounds(1307, 850, 281, 41);
		panel_1.add(chckbxTreeNuts);
		
		JCheckBox chckbxEggs = new JCheckBox("Eggs");
		chckbxEggs.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxEggs.setBackground(new Color(240, 248, 255));
		chckbxEggs.setBounds(1307, 708, 281, 55);
		panel_1.add(chckbxEggs);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_1.setColumns(10);
		textField_1.setBounds(316, 183, 693, 49);
		panel_1.add(textField_1);
		
		JTextPane txtpnSearchFor = new JTextPane();
		txtpnSearchFor.setText("First Name:");
		txtpnSearchFor.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnSearchFor.setBackground(new Color(240, 248, 255));
		txtpnSearchFor.setBounds(69, 178, 332, 63);
		panel_1.add(txtpnSearchFor);
		
		JTextPane txtpnRecipeId = new JTextPane();
		txtpnRecipeId.setText("Last Name:");
		txtpnRecipeId.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnRecipeId.setBackground(new Color(240, 248, 255));
		txtpnRecipeId.setBounds(69, 247, 326, 83);
		panel_1.add(txtpnRecipeId);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Show only Kosher Recipies");
		chckbxNewCheckBox.setBackground(new Color(240, 248, 255));
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 45));
		chckbxNewCheckBox.setBounds(69, 811, 697, 64);
		panel_1.add(chckbxNewCheckBox);
		
		JTextPane txtpnAdvancedSearch = new JTextPane();
		txtpnAdvancedSearch.setText("User Details");
		txtpnAdvancedSearch.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 80));
		txtpnAdvancedSearch.setBackground(new Color(240, 248, 255));
		txtpnAdvancedSearch.setBounds(507, 55, 644, 99);
		panel_1.add(txtpnAdvancedSearch);
		
		JCheckBox chckbxDairy = new JCheckBox("Fish");
		chckbxDairy.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent h) {
				 System.out.println(h.getID() == ActionEvent.ACTION_PERFORMED
		                    ? "ACTION_PERFORMED" : h.getID()); //add what happens
			}
		});
		chckbxDairy.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxDairy.setBackground(new Color(240, 248, 255));
		chckbxDairy.setBounds(1027, 715, 345, 41);
		panel_1.add(chckbxDairy);
		
		JTextPane txtpnAllergies = new JTextPane();
		txtpnAllergies.setText("Allergies:");
		txtpnAllergies.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 52));
		txtpnAllergies.setBackground(new Color(240, 248, 255));
		txtpnAllergies.setBounds(1129, 632, 340, 72);
		panel_1.add(txtpnAllergies);
		
		JCheckBox chckbxG = new JCheckBox("Coffie");
		chckbxG.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent g) {
				 System.out.println(g.getID() == ActionEvent.ACTION_PERFORMED
		                    ? "ACTION_PERFORMED" : g.getID()); //add what happens
			}
		});
		chckbxG.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxG.setBackground(new Color(240, 248, 255));
		chckbxG.setBounds(1027, 850, 345, 41);
		panel_1.add(chckbxG);
		
		JCheckBox chckbxNon = new JCheckBox("Gluten");
		chckbxNon.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent f) {
				 System.out.println(f.getID() == ActionEvent.ACTION_PERFORMED
		                    ? "ACTION_PERFORMED" : f.getID()); //add what happens
			}
		});
		chckbxNon.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxNon.setBackground(new Color(240, 248, 255));
		chckbxNon.setBounds(1027, 923, 345, 41);
		panel_1.add(chckbxNon);
		
		JButton btnSearch = new JButton("Update!");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 50));
		btnSearch.setBounds(607, 1068, 326, 69);
		panel_1.add(btnSearch);
		
		JTextPane txtpnEmail = new JTextPane();
		txtpnEmail.setText("Email:");
		txtpnEmail.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnEmail.setBackground(new Color(240, 248, 255));
		txtpnEmail.setBounds(69, 337, 255, 69);
		panel_1.add(txtpnEmail);
		JTextPane txtpnEnterPasswordAgain = new JTextPane();
		txtpnEnterPasswordAgain.setText("Enter Password Again:");
		txtpnEnterPasswordAgain.setFont(new Font("Tahoma", Font.PLAIN, 40));
		txtpnEnterPasswordAgain.setBackground(new Color(240, 248, 255));
		txtpnEnterPasswordAgain.setBounds(69, 520, 462, 63);
		panel_1.add(txtpnEnterPasswordAgain);
		
		JCheckBox chckbxDietican = new JCheckBox("Dietican");
		chckbxDietican.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent e) {
				 System.out.println(e.getID() == ActionEvent.ACTION_PERFORMED
		                    ? "ACTION_PERFORMED" : e.getID()); //add what happens
			}
		});
		chckbxDietican.setFont(new Font("Tahoma", Font.PLAIN, 45));
		chckbxDietican.setBackground(new Color(240, 248, 255));
		chckbxDietican.setBounds(69, 636, 412, 41);
		panel_1.add(chckbxDietican);
		
		JCheckBox chckbxShowOnlyRecipes = new JCheckBox("Show only Recipes adapted to Alergies");
		chckbxShowOnlyRecipes.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent d) {
				 System.out.println(d.getID() == ActionEvent.ACTION_PERFORMED
		                    ? "ACTION_PERFORMED" : d.getID()); //add what happens
			}
		});
		chckbxShowOnlyRecipes.setFont(new Font("Tahoma", Font.PLAIN, 45));
		chckbxShowOnlyRecipes.setBackground(new Color(240, 248, 255));
		chckbxShowOnlyRecipes.setBounds(69, 895, 866, 69);
		panel_1.add(chckbxShowOnlyRecipes);
		
		JTextPane txtpnExpiryDate_1 = new JTextPane();
		txtpnExpiryDate_1.setText("Expiry Date:");
		txtpnExpiryDate_1.setFont(new Font("Tahoma", Font.PLAIN, 38));
		txtpnExpiryDate_1.setBackground(new Color(240, 248, 255));
		txtpnExpiryDate_1.setBounds(316, 695, 443, 55);
		panel_1.add(txtpnExpiryDate_1);
		
		JCheckBox chckbxDairy_1 = new JCheckBox("Dairy");
		chckbxDairy_1.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent c) {
				 System.out.println(c.getID() == ActionEvent.ACTION_PERFORMED
		                    ? "ACTION_PERFORMED" : c.getID()); //add what happens
			}
		});
		chckbxDairy_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxDairy_1.setBackground(new Color(240, 248, 255));
		chckbxDairy_1.setBounds(1027, 1069, 226, 41);
		panel_1.add(chckbxDairy_1);
		
		JCheckBox chckbxLactose = new JCheckBox("Lactose");
		chckbxLactose.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent b) {
				 System.out.println(b.getID() == ActionEvent.ACTION_PERFORMED
		                    ? "ACTION_PERFORMED" : b.getID()); //add what happens
			}
		});
		chckbxLactose.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxLactose.setBackground(new Color(240, 248, 255));
		chckbxLactose.setBounds(1027, 996, 226, 41);
		panel_1.add(chckbxLactose);
		
		JCheckBox chckbxChocolate = new JCheckBox("Chocolate");
		chckbxChocolate.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent a) {
				 System.out.println(a.getID() == ActionEvent.ACTION_PERFORMED
		                    ? "ACTION_PERFORMED" : a.getID()); //add what happens
			}
		});
		chckbxChocolate.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxChocolate.setBackground(new Color(240, 248, 255));
		chckbxChocolate.setBounds(1307, 1069, 281, 41);
		panel_1.add(chckbxChocolate);
		
		JCheckBox chckbxFoodAcidity = new JCheckBox("Food Acidity");
		chckbxFoodAcidity.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent j) {
				 System.out.println(j.getID() == ActionEvent.ACTION_PERFORMED
		                    ? "ACTION_PERFORMED" : j.getID()); //add what happens
			}
		});
		chckbxFoodAcidity.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxFoodAcidity.setBackground(new Color(240, 248, 255));
		chckbxFoodAcidity.setBounds(1307, 996, 281, 41);
		panel_1.add(chckbxFoodAcidity);
	}
}
