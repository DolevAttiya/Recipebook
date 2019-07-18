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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

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
import java.beans.VetoableChangeListener;
import java.beans.PropertyChangeEvent;

public class Reports extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtRecipebook;
	public String dateOfBirth="0000-00-00";
	public String yearOfBirth="0000";
	public String monthOfBirth="00";
	public String dayOfBirth="00";
	public int isDietitian=0;
	public String dietitianNum;
	public int isKosher=0;
	public String dietitianStatDate="0000-00-00";
	public String yearOfStat="0000";
	public String monthOfStat="00";
	public String dayOfStat="00";
	public int wantAllerg=0;
	public int allergyIndex=0;

	//allergies
	public int isFish=0;
	public int isStrawberries=0;
	public int isCoffie=0;
	public int isGluten=0;
	public int isLactose=0;
	public int isMilk=0;
	public int isEggs=0;
	public int isSeeds=0;
	public int isTreeNuts=0;
	public int isPeanut=0;
	public int isAcidity=0;
	public int isChocolate=0;



	// dietitianStatDate, allergies, wantAllerg);


	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reports frame = new Reports();
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
*/
	/**
	 * Create the frame.
	 */
	public Reports() {
		setSize(1000, 700);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
		contentPane = new JPanel();
		contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 105, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//panelkavuaa

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 248, 255));
		panel_1.setBounds(10, 60, 971, 586);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		String[] monthsDietitian = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};

		String[] daysDietitian = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		setVisible(true);

		JTextPane txtpnAdvancedSearch = new JTextPane();
		txtpnAdvancedSearch.setEditable(false);
		txtpnAdvancedSearch.setText("Reports");
		txtpnAdvancedSearch.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 40));
		txtpnAdvancedSearch.setBackground(new Color(240, 248, 255));
		txtpnAdvancedSearch.setBounds(355, 10, 215, 57);
		panel_1.add(txtpnAdvancedSearch);

		JTextPane txtpnAllergies = new JTextPane();
		txtpnAllergies.setEditable(false);
		txtpnAllergies.setText("Find recipe that doesn't include:");

		txtpnAllergies.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 30));
		txtpnAllergies.setBackground(new Color(240, 248, 255));
		txtpnAllergies.setBounds(65, 76, 626, 44);
		panel_1.add(txtpnAllergies);

		JButton btnSearch = new JButton("Get Recipes Report");
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent g) {
				myView.statview.recipeReport(allergyIndex);
				TopRecipesByAllergy f=new TopRecipesByAllergy();
				f.setVisible(true);
				Reports.this.dispose();
				Reports.this.setVisible(false);
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 50));
		btnSearch.setBounds(118, 163, 702, 178);
		panel_1.add(btnSearch);

		String[] Allergy = {"---","Fish", "Strawberries", "Coffie", "Gluten", "Lactose", "Milk", "Eggs", "Seeds", "TreeNuts", "Peanut", "Acidity", "Chocolate"};
		JComboBox comboBox = new JComboBox(Allergy);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				allergyIndex=comboBox.getSelectedIndex();
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 25));
		comboBox.setBounds(701, 71, 189, 49);
		panel_1.add(comboBox);

		JButton btnGetIngredientReport = new JButton("Get Ingredient\r\n Report");
		btnGetIngredientReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myView.statview.ingredientReport(allergyIndex);
				TopIngredient f=new TopIngredient();
				f.setVisible(true);
				Reports.this.dispose();
				Reports.this.setVisible(false);
			}
		});
		btnGetIngredientReport.setFont(new Font("Tahoma", Font.BOLD, 50));
		btnGetIngredientReport.setBounds(118, 352, 702, 178);
		panel_1.add(btnGetIngredientReport);

		//panel upper
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 994, 59);
		panel.setBackground(new Color(65, 105, 225));
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(495, 36, 163, 21);
		panel.add(textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setColumns(10);
		
		JTextPane textPane_5 = new JTextPane();
		textPane_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainPage b=new MainPage();
				b.setVisible(true);
				Reports.this.dispose();
				Reports.this.setVisible(false);
			}
		});
		textPane_5.setBounds(10, 0, 204, 57);
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
				Reports.this.dispose();
				Reports.this.setVisible(false);
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
				Reports.this.dispose();
				Reports.this.setVisible(false);
			}
		});
		textPane_1.setBounds(729, 7, 126, 50);
		panel.add(textPane_1);
		textPane_1.setText("Advanced Search");
		textPane_1.setForeground(Color.WHITE);
		textPane_1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
		textPane_1.setEditable(false);
		textPane_1.setBackground(new Color(65, 105, 225));
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(559, 11, 92, 29);
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
				Reports.this.dispose();
				Reports.this.setVisible(false);
				}
			}
		});
		button.setBounds(659, 36, 47, 21);
		panel.add(button);
		button.setFont(new Font("Tahoma", Font.BOLD, 5));
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myView.statview.myFavorite();
				MyFavourites d=new MyFavourites();
				d.setVisible(true);
				Reports.this.dispose();
				Reports.this.setVisible(false);
			}
		});
		textPane_2.setBounds(341, 8, 132, 49);
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
				Reports.this.dispose();
				Reports.this.setVisible(false);
			}
		});
		textPane_4.setBounds(224, 8, 107, 49);
		panel.add(textPane_4);
		textPane_4.setText("My Recipes");
		textPane_4.setForeground(Color.WHITE);
		textPane_4.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
		textPane_4.setEditable(false);
		textPane_4.setBackground(new Color(65, 105, 225));

}
}
