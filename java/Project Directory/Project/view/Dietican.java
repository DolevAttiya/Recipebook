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
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import java.awt.Choice;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

public class Dietican extends JFrame {

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
	private JTextField textField_9;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dietican frame = new Dietican();
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
	public Dietican() {
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
				if (myView.myUser!=null) {
					User f=new User();
				f.setVisible(true);
				}
				else {
					Dietican f=new Dietican();
					f.setVisible(true);
				}
				Dietican.this.dispose();
				Dietican.this.setVisible(false);
			}
		});
		
		JButton btnAdd = new JButton("Go!");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myView.statview.mainSearch(textField_5.getText());  
				if (myView.check==false) {
					JOptionPane.showMessageDialog(null,"There is no match to your search, try again");
				}
				else {
					SearchRes d=new SearchRes();
				d.setVisible(true);
				Dietican.this.dispose();
				Dietican.this.setVisible(false);
				}
			}
		});
		btnAdd.setBounds(1016, 37, 71, 42);
		panel.add(btnAdd);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		
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
				Dietican.this.dispose();
				Dietican.this.setVisible(false);
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
		textField_5.setBounds(747, 37, 269, 43);
		panel.add(textField_5);
		
		JTextPane txtpnFavouriteRecipes = new JTextPane();
		txtpnFavouriteRecipes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myView.statview.myFavorite();
				MyFavourites f=new MyFavourites();
				f.setVisible(true);
				Dietican.this.dispose();
				Dietican.this.setVisible(false);
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
				myView.statview.myRecipes();
				MyRecipes f=new MyRecipes();
				f.setVisible(true);
				Dietican.this.dispose();
				Dietican.this.setVisible(false);
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
				Dietican.this.dispose();
				Dietican.this.setVisible(false);
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
		
		textField_8 = new JTextField(/*myView.myDietitian.getDietitianId()*/);
		textField_8.setEnabled(false);
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 40));
		textField_8.setColumns(10);
		textField_8.setBounds(1079, 236, 406, 49);
		panel_1.add(textField_8);
		
		textField_7 = new JTextField(/*myView.myDietitian.getPersonHashPass()*/);
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 40));
		textField_7.setColumns(10);
		textField_7.setBounds(553, 520, 456, 49);
		panel_1.add(textField_7);
		
		textField_2 = new JTextField(/*myView.myDietitian.getPersonHashPass()*/);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		textField_2.setColumns(10);
		textField_2.setBounds(588, 461, 421, 49);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField(/*myView.myDietitian.getPersonEmail()*/);
		textField_3.setEnabled(false);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 40));
		textField_3.setColumns(10);
		textField_3.setBounds(205, 337, 804, 49);
		panel_1.add(textField_3);
		
		textField_6 = new JTextField(/*myView.myDietitian.getPersonLastName()*/);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 40));
		textField_6.setColumns(10);
		textField_6.setBounds(316, 254, 693, 49);
		panel_1.add(textField_6);
		setVisible(true);
		
		JTextPane txtpnEnterDieticanNumber = new JTextPane();
		txtpnEnterDieticanNumber.setText("Enter Dietican Number:");
		txtpnEnterDieticanNumber.setFont(new Font("Tahoma", Font.PLAIN, 38));
		txtpnEnterDieticanNumber.setBackground(new Color(240, 248, 255));
		txtpnEnterDieticanNumber.setBounds(1079, 183, 406, 55);
		panel_1.add(txtpnEnterDieticanNumber);
		
		
		textField_1 = new JTextField(/*myView.myDietitian.getPersonFirstName()*/);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		textField_1.setColumns(10);
		textField_1.setBounds(316, 183, 693, 49);
		panel_1.add(textField_1);
		
		JTextPane txtpnSearchFor = new JTextPane();
		txtpnSearchFor.setText("First Name:");
		txtpnSearchFor.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnSearchFor.setBackground(new Color(240, 248, 255));
		txtpnSearchFor.setBounds(69, 178, 237, 63);
		panel_1.add(txtpnSearchFor);
		
		JTextPane txtpnRecipeId = new JTextPane();
		txtpnRecipeId.setText("Last Name:");
		txtpnRecipeId.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnRecipeId.setBackground(new Color(240, 248, 255));
		txtpnRecipeId.setBounds(69, 247, 237, 83);
		panel_1.add(txtpnRecipeId);
		
		JTextPane txtpnAdvancedSearch = new JTextPane();
		txtpnAdvancedSearch.setText("Dietican Details");
		txtpnAdvancedSearch.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 80));
		txtpnAdvancedSearch.setBackground(new Color(240, 248, 255));
		txtpnAdvancedSearch.setBounds(402, 53, 644, 99);
		panel_1.add(txtpnAdvancedSearch);
		
		JButton btnSearch = new JButton("Update!");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((textField_1.getText().trim().isEmpty())||(textField_6.getText().trim().isEmpty())||(textField_3.getText().trim().isEmpty())||(textField_2.getText().trim().isEmpty())||(textField_7.getText().trim().isEmpty())||(textField_9.getText().trim().isEmpty())||(textField_8.getText().trim().isEmpty())||(textField_4.getText().trim().isEmpty())) {
					JOptionPane.showMessageDialog(null,"One of the parameters is empty, Please fill all");
				}
						
				else {
					myView.statview.dietitianUpdate(textField_1.getText(), textField_6.getText(), textField_3.getText(), textField_2.getText(), textField_7.getText(), myView.myDietitian.getPersonDateOfBirth().toString(),textField_8.getText(),myView.myDietitian.getDietitianStatDate().toString());
					MainPage f=new MainPage();
					f.setVisible(true);
					Dietican.this.dispose();
					Dietican.this.setVisible(false);
					}
				
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 50));
		btnSearch.setBounds(607, 1068, 326, 69);
		panel_1.add(btnSearch);
		
		JTextPane txtpnEmail = new JTextPane();
		txtpnEmail.setText("Email:");
		txtpnEmail.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnEmail.setBackground(new Color(240, 248, 255));
		txtpnEmail.setBounds(69, 337, 129, 69);
		panel_1.add(txtpnEmail);
		JTextPane txtpnEnterPasswordAgain = new JTextPane();
		txtpnEnterPasswordAgain.setText("Enter Password Again:");
		txtpnEnterPasswordAgain.setFont(new Font("Tahoma", Font.PLAIN, 40));
		txtpnEnterPasswordAgain.setBackground(new Color(240, 248, 255));
		txtpnEnterPasswordAgain.setBounds(69, 520, 462, 63);
		panel_1.add(txtpnEnterPasswordAgain);
		
		JTextPane txtpnExpiryDate_1 = new JTextPane();
		txtpnExpiryDate_1.setText("Date of Certification:");
		txtpnExpiryDate_1.setFont(new Font("Tahoma", Font.PLAIN, 38));
		txtpnExpiryDate_1.setBackground(new Color(240, 248, 255));
		txtpnExpiryDate_1.setBounds(1089, 286, 360, 55);
		panel_1.add(txtpnExpiryDate_1);
		
		JTextPane txtpnEnterPassword = new JTextPane();
		txtpnEnterPassword.setText("Enter Password (6 digits):");
		txtpnEnterPassword.setFont(new Font("Tahoma", Font.PLAIN, 40));
		txtpnEnterPassword.setBackground(new Color(240, 248, 255));
		txtpnEnterPassword.setBounds(69, 450, 489, 63);
		panel_1.add(txtpnEnterPassword);
		
		JTextPane txtpnDateOfBirth = new JTextPane();
		txtpnDateOfBirth.setText("Date of Birth:");
		txtpnDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtpnDateOfBirth.setBackground(new Color(240, 248, 255));
		txtpnDateOfBirth.setBounds(69, 634, 275, 69);
		panel_1.add(txtpnDateOfBirth);
		
		String[] months = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
		JComboBox comboBox = new JComboBox(months);
		comboBox.setEnabled(false);
		comboBox.setSelectedItem("11"); /*myView.myDietitian.getPersonDateOfBirth().getMonth()*/
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 40));
		comboBox.setBounds(463, 641, 105, 49);
		panel_1.add(comboBox);
		
		String[] days = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		JComboBox comboBox_1 = new JComboBox(days);
		comboBox_1.setEnabled(false);
		comboBox_1.setSelectedItem("16"); /*myView.myDietitian.getPersonDateOfBirth().getDayOfMonth()*/
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		comboBox_1.setBounds(348, 641, 105, 49);
		panel_1.add(comboBox_1);
		
		textField_9 = new JTextField(/*myView.myDietitian.getPersonDateOfBirth().getYear()*/);
		textField_9.setEnabled(false);
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 40));
		textField_9.setColumns(10);
		textField_9.setBounds(580, 641, 171, 49);
		panel_1.add(textField_9);
		
		String[] daysDietitian = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		JComboBox comboBox_2 = new JComboBox(daysDietitian);
		comboBox_2.setEnabled(false);
		comboBox_2.setSelectedItem("04"); /*myView.myDietitian.getDietitianStatDate().getDayOfMonth()*/
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		comboBox_2.setBounds(1082, 350, 105, 49);
		panel_1.add(comboBox_2);
		
		String[] monthsDietitian = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
		JComboBox comboBox_3 = new JComboBox(monthsDietitian);
		comboBox_3.setEnabled(false);
		comboBox_3.setSelectedItem("03"); /*myView.myDietitian.getDietitianStatDate().getDayMonth()*/
		comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 40));
		comboBox_3.setBounds(1197, 350, 105, 49);
		panel_1.add(comboBox_3);
		
		textField_4 = new JTextField(/*myView.myDietitian.getDietitianStatDate().getYear()*/);
		textField_4.setEnabled(false);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 40));
		textField_4.setColumns(10);
		textField_4.setBounds(1314, 350, 171, 49);
		panel_1.add(textField_4);
		
		JButton btnDeleteUser = new JButton("Delete User");
		btnDeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myView.statview.deleteDietitian();
			}
		});
		btnDeleteUser.setFont(new Font("Tahoma", Font.BOLD, 50));
		btnDeleteUser.setBounds(1079, 487, 406, 69);
		panel_1.add(btnDeleteUser);
		
		JTextPane txtpnDontDeleteUnless = new JTextPane();
		txtpnDontDeleteUnless.setText("Don't delete unless you're sure!");
		txtpnDontDeleteUnless.setFont(new Font("Tahoma", Font.PLAIN, 28));
		txtpnDontDeleteUnless.setBackground(new Color(240, 248, 255));
		txtpnDontDeleteUnless.setBounds(1079, 560, 406, 55);
		panel_1.add(txtpnDontDeleteUnless);
	}
}
