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
		setSize(1000, 700);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
		contentPane = new JPanel();
		contentPane_1 = new JPanel();
		contentPane_1.setBackground(new Color(65, 105, 225));
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_1);
		contentPane_1.setLayout(null);

		//panel upper
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 994, 59);
		panel.setBackground(new Color(65, 105, 225));
		contentPane_1.add(panel);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setBounds(518, 36, 163, 21);
		panel.add(textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setColumns(10);

		JTextPane textPane_5 = new JTextPane();
		textPane_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainPage b=new MainPage();
				b.setVisible(true);
				Dietican.this.dispose();
				Dietican.this.setVisible(false);
			}
		});
		textPane_5.setBounds(0, 0, 204, 57);
		panel.add(textPane_5);
		textPane_5.setText("Taimli");
		textPane_5.setForeground(Color.WHITE);
		textPane_5.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 50));
		textPane_5.setEditable(false);
		textPane_5.setBackground(new Color(65, 105, 225));

		JTextPane textPane = new JTextPane();
		textPane.addMouseListener(new MouseAdapter() {
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
		textPane.setBounds(882, 8, 102, 49);
		panel.add(textPane);
		textPane.setText("user details");
		textPane.setForeground(Color.WHITE);
		textPane.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
		textPane.setEditable(false);
		textPane.setBackground(new Color(65, 105, 225));

		JTextPane textPane_1 = new JTextPane();
		textPane_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdvancedSearch d=new AdvancedSearch();
				d.setVisible(true);
				Dietican.this.dispose();
				Dietican.this.setVisible(false);
			}
		});
		textPane_1.setBounds(746, 8, 126, 50);
		panel.add(textPane_1);
		textPane_1.setText("Advanced Search");
		textPane_1.setForeground(Color.WHITE);
		textPane_1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
		textPane_1.setEditable(false);
		textPane_1.setBackground(new Color(65, 105, 225));

		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(582, 11, 92, 29);
		panel.add(textPane_3);
		textPane_3.setText("Search");
		textPane_3.setForeground(Color.WHITE);
		textPane_3.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
		textPane_3.setEditable(false);
		textPane_3.setBackground(new Color(65, 105, 225));

		JButton button = new JButton("Go!");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myView.statview.mainSearch(textField.getText());  
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
		button.setBounds(682, 36, 47, 21);
		panel.add(button);
		button.setFont(new Font("Tahoma", Font.BOLD, 5));

		JTextPane textPane_2 = new JTextPane();
		textPane_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myView.statview.myFavorite();
				MyFavourites d=new MyFavourites();
				d.setVisible(true);
				Dietican.this.dispose();
				Dietican.this.setVisible(false);
			}
		});
		textPane_2.setBounds(385, 8, 132, 49);
		panel.add(textPane_2);
		textPane_2.setText("Favourite Recipes");
		textPane_2.setForeground(Color.WHITE);
		textPane_2.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
		textPane_2.setEditable(false);
		textPane_2.setBackground(new Color(65, 105, 225));

		JTextPane textPane_4 = new JTextPane();
		textPane_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myView.statview.myRecipes();
				MyRecipes c=new MyRecipes();
				c.setVisible(true);
				Dietican.this.dispose();
				Dietican.this.setVisible(false);
			}
		});
		textPane_4.setBounds(242, 8, 107, 49);
		panel.add(textPane_4);
		textPane_4.setText("My Recipes");
		textPane_4.setForeground(Color.WHITE);
		textPane_4.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
		textPane_4.setEditable(false);
		textPane_4.setBackground(new Color(65, 105, 225));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 248, 255));
		panel_1.setBounds(10, 60, 971, 586);
		contentPane_1.add(panel_1);
		panel_1.setLayout(null);

		Integer cer =myView.myDietitian.getDietitianId();
		textField_8 = new JTextField(cer.toString());
		textField_8.setEnabled(false);
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_8.setColumns(10);
		textField_8.setBounds(527, 212, 406, 39);
		panel_1.add(textField_8);

		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_7.setColumns(10);
		textField_7.setBounds(266, 312, 232, 39);
		panel_1.add(textField_7);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(266, 262, 232, 39);
		panel_1.add(textField_2);

		textField_3 = new JTextField(myView.myDietitian.getPersonEmail());
		textField_3.setEnabled(false);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(101, 212, 397, 39);
		panel_1.add(textField_3);

		textField_6 = new JTextField(myView.myDietitian.getPersonLastName());
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_6.setColumns(10);
		textField_6.setBounds(153, 162, 348, 39);
		panel_1.add(textField_6);
		setVisible(true);

		JTextPane txtpnEnterDieticanNumber = new JTextPane();
		txtpnEnterDieticanNumber.setEditable(false);
		txtpnEnterDieticanNumber.setText("Enter Dietican Number:");
		txtpnEnterDieticanNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnEnterDieticanNumber.setBackground(new Color(240, 248, 255));
		txtpnEnterDieticanNumber.setBounds(527, 183, 406, 28);
		panel_1.add(txtpnEnterDieticanNumber);


		textField_1 = new JTextField(myView.myDietitian.getPersonFirstName());
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(155, 112, 348, 39);
		panel_1.add(textField_1);

		JTextPane txtpnSearchFor = new JTextPane();
		txtpnSearchFor.setEditable(false);
		txtpnSearchFor.setText("First Name:");
		txtpnSearchFor.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtpnSearchFor.setBackground(new Color(240, 248, 255));
		txtpnSearchFor.setBounds(31, 118, 117, 33);
		panel_1.add(txtpnSearchFor);

		JTextPane txtpnRecipeId = new JTextPane();
		txtpnRecipeId.setEditable(false);
		txtpnRecipeId.setText("Last Name:");
		txtpnRecipeId.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtpnRecipeId.setBackground(new Color(240, 248, 255));
		txtpnRecipeId.setBounds(31, 162, 117, 39);
		panel_1.add(txtpnRecipeId);

		JTextPane txtpnAdvancedSearch = new JTextPane();
		txtpnAdvancedSearch.setEditable(false);
		txtpnAdvancedSearch.setText("Dietican Details");
		txtpnAdvancedSearch.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 40));
		txtpnAdvancedSearch.setBackground(new Color(240, 248, 255));
		txtpnAdvancedSearch.setBounds(266, 33, 406, 55);
		panel_1.add(txtpnAdvancedSearch);

		JTextPane txtpnEmail = new JTextPane();
		txtpnEmail.setEditable(false);
		txtpnEmail.setText("Email:");
		txtpnEmail.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtpnEmail.setBackground(new Color(240, 248, 255));
		txtpnEmail.setBounds(31, 212, 75, 39);
		panel_1.add(txtpnEmail);
		JTextPane txtpnEnterPasswordAgain = new JTextPane();
		txtpnEnterPasswordAgain.setEditable(false);
		txtpnEnterPasswordAgain.setText("Enter Password Again:");
		txtpnEnterPasswordAgain.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtpnEnterPasswordAgain.setBackground(new Color(240, 248, 255));
		txtpnEnterPasswordAgain.setBounds(31, 304, 206, 39);
		panel_1.add(txtpnEnterPasswordAgain);

		JTextPane txtpnExpiryDate_1 = new JTextPane();
		txtpnExpiryDate_1.setEditable(false);
		txtpnExpiryDate_1.setText("Date of Certification:");
		txtpnExpiryDate_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnExpiryDate_1.setBackground(new Color(240, 248, 255));
		txtpnExpiryDate_1.setBounds(527, 123, 360, 28);
		panel_1.add(txtpnExpiryDate_1);

		JTextPane txtpnEnterPassword = new JTextPane();
		txtpnEnterPassword.setEditable(false);
		txtpnEnterPassword.setText("Enter Password (6 digits):");
		txtpnEnterPassword.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtpnEnterPassword.setBackground(new Color(240, 248, 255));
		txtpnEnterPassword.setBounds(31, 263, 232, 39);
		panel_1.add(txtpnEnterPassword);

		JTextPane txtpnDateOfBirth = new JTextPane();
		txtpnDateOfBirth.setEditable(false);
		txtpnDateOfBirth.setText("Date of Birth:");
		txtpnDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnDateOfBirth.setBackground(new Color(240, 248, 255));
		txtpnDateOfBirth.setBounds(31, 363, 158, 28);
		panel_1.add(txtpnDateOfBirth);

		Integer X=myView.myDietitian.getPersonDateOfBirth().getMonthValue();
		String[] month= {X.toString()};
		JComboBox comboBox = new JComboBox(month);
		comboBox.setEnabled(false);
		comboBox.setSelectedItem(myView.myDietitian.getPersonDateOfBirth().getMonth().toString());
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setBounds(210, 392, 105, 32);
		panel_1.add(comboBox);

		Integer XX=myView.myDietitian.getPersonDateOfBirth().getDayOfMonth();
		String[] day= {XX.toString()};
		JComboBox comboBox_1 = new JComboBox(day);
		comboBox_1.setEnabled(false);
		comboBox_1.setSelectedItem(myView.myDietitian.getPersonDateOfBirth().getDayOfMonth());
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_1.setBounds(95, 392, 105, 32);
		panel_1.add(comboBox_1);

		Integer ZZZ =myView.myDietitian.getPersonDateOfBirth().getYear();
		textField_9 = new JTextField(ZZZ.toString());
		textField_9.setEnabled(false);
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_9.setColumns(10);
		textField_9.setBounds(327, 392, 171, 32);
		panel_1.add(textField_9);

		Integer months=myView.myDietitian.getDietitianStatDate().getDayOfMonth();
		String[] mo= {months.toString()};
		JComboBox comboBox_2 = new JComboBox(mo);
		comboBox_2.setEnabled(false);
		comboBox_2.setSelectedItem(myView.myDietitian.getDietitianStatDate().getDayOfMonth());
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_2.setBounds(527, 151, 105, 31);
		panel_1.add(comboBox_2);

		Integer days=myView.myDietitian.getDietitianStatDate().getDayOfMonth();
		String[] da= {days.toString()};
		JComboBox comboBox_3 = new JComboBox(da);
		comboBox_3.setEnabled(false);
		comboBox_3.setSelectedItem(myView.myDietitian.getDietitianStatDate().getDayOfMonth());
		comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_3.setBounds(642, 151, 105, 31);
		panel_1.add(comboBox_3);

		Integer eee =myView.myDietitian.getDietitianStatDate().getYear();
		textField_4 = new JTextField(eee.toString());
		textField_4.setEnabled(false);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_4.setColumns(10);
		textField_4.setBounds(759, 151, 171, 31);
		panel_1.add(textField_4);

		JButton btnDeleteUser = new JButton("Delete User");
		btnDeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myView.statview.deleteDietitian();
				if (myView.check==true) // was able to delete
				{
					Login b=new Login();
					b.setVisible(true);
					Dietican.this.dispose();
					Dietican.this.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null,"You are not alowed to delete this user");
				}
			}
		});
		btnDeleteUser.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnDeleteUser.setBounds(693, 480, 226, 39);
		panel_1.add(btnDeleteUser);

		JTextPane txtpnDontDeleteUnless = new JTextPane();
		txtpnDontDeleteUnless.setEditable(false);
		txtpnDontDeleteUnless.setText("Don't delete unless you're sure!");
		txtpnDontDeleteUnless.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnDontDeleteUnless.setBackground(new Color(240, 248, 255));
		txtpnDontDeleteUnless.setBounds(693, 523, 226, 28);
		panel_1.add(txtpnDontDeleteUnless);

		JButton btnSearch = new JButton("Update!");
		btnSearch.setBounds(379, 489, 188, 47);
		panel_1.add(btnSearch);
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
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 25));
	}
}
