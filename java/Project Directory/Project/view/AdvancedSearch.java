package view; 

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdvancedSearch extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtRecipebook;
	private JTextField textField_5;
	private JTextField textField_1;
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
	public String timeToMake="30";
	public String rateAbove="0";
	public int kashruth=0;
	public int complexity=0;



	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdvancedSearch frame = new AdvancedSearch();
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
	public AdvancedSearch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 700);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 105, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 994, 59);
		panel.setBackground(new Color(65, 105, 225));
		contentPane.add(panel);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setBounds(518, 36, 163, 21);
		panel.add(textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setColumns(10);

		JTextPane textPane_5 = new JTextPane();
		textPane_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				myView.statview.getTop10();
				MainPage b=new MainPage();
				b.setVisible(true);
				AdvancedSearch.this.dispose();
				AdvancedSearch.this.setVisible(false);
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
				AdvancedSearch.this.dispose();
				AdvancedSearch.this.setVisible(false);
			}
		}
				);
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
				AdvancedSearch.this.dispose();
				AdvancedSearch.this.setVisible(false);
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
				if (textField.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Cannot search an empty string!");
				}
				else 
				{
					myView.statview.mainSearch(textField.getText());  
					if (myView.check==false) {
						JOptionPane.showMessageDialog(null,"There is no match to your search, try again");
					}
					else {
						SearchRes d=new SearchRes();
						d.setVisible(true);
						AdvancedSearch.this.dispose();
						AdvancedSearch.this.setVisible(false);
					}
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
				AdvancedSearch.this.dispose();
				AdvancedSearch.this.setVisible(false);
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
				AdvancedSearch.this.dispose();
				AdvancedSearch.this.setVisible(false);
			}
		});
		textPane_4.setBounds(242, 8, 107, 49);
		panel.add(textPane_4);
		textPane_4.setText("My Recipes");
		textPane_4.setForeground(Color.WHITE);
		textPane_4.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
		textPane_4.setEditable(false);
		textPane_4.setBackground(new Color(65, 105, 225));


		//panelkavuaa

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 248, 255));
		panel_1.setBounds(10, 60, 971, 586);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JCheckBox checkBox_2 = new JCheckBox("Peanut");
		checkBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox_2.isSelected()){  
					isPeanut=1;   } 
				else {
					isPeanut=0;
				}
			}
		});
		checkBox_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_2.setBackground(new Color(240, 248, 255));
		checkBox_2.setBounds(737, 316, 140, 41);
		panel_1.add(checkBox_2);

		String[] times = {"30", "60", "120", "180", "all"};
		JComboBox comboBox_1 = new JComboBox(times);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox comboBox_1 = (JComboBox)e.getSource();
				timeToMake = (String)comboBox_1.getSelectedItem();
				if (timeToMake=="all") {
					timeToMake="99999";
				}
			}
		});
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_1.setBounds(246, 232, 198, 41);
		panel_1.add(comboBox_1);

		String[] complexiting = {"Easy", "Medium", "Hard"};
		JComboBox comboBox_4 = new JComboBox(complexiting);
		comboBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox comboBox_4 = (JComboBox)e.getSource();
				complexity = (int)comboBox_4.getSelectedIndex();
			}
		});
		comboBox_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_4.setBounds(159, 180, 285, 41);
		panel_1.add(comboBox_4);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(159, 88, 597, 29);
		panel_1.add(textField_1);

		String[] kashruthing = {"Parve", "Dairy", "Meat","Not Kosher","Kosher"};
		JComboBox comboBox = new JComboBox(kashruthing);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox comboBox = (JComboBox)arg0.getSource();
				kashruth = (int)comboBox.getSelectedIndex();

				//send kashruth level to DB
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setBounds(158, 128, 286, 41);
		panel_1.add(comboBox);

		JTextPane txtpnCategory = new JTextPane();
		txtpnCategory.setEditable(false);
		txtpnCategory.setText("Kashruth");
		txtpnCategory.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnCategory.setBackground(new Color(240, 248, 255));
		txtpnCategory.setBounds(42, 135, 111, 29);
		panel_1.add(txtpnCategory);

		JTextPane txtpnRateAbove = new JTextPane();
		txtpnRateAbove.setEditable(false);
		txtpnRateAbove.setText("Rate Above:");
		txtpnRateAbove.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnRateAbove.setBackground(new Color(240, 248, 255));
		txtpnRateAbove.setBounds(42, 285, 130, 31);
		panel_1.add(txtpnRateAbove);
		// add open and close
		JTextPane textPane_7 = new JTextPane();
		textPane_7.setEditable(false);
		textPane_7.setText("Allergies:");
		textPane_7.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 30));
		textPane_7.setBackground(new Color(240, 248, 255));
		textPane_7.setBounds(626, 124, 198, 47);
		panel_1.add(textPane_7);

		JTextPane txtpnSearchFor = new JTextPane();
		txtpnSearchFor.setEditable(false);
		txtpnSearchFor.setText("Search For:");
		txtpnSearchFor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnSearchFor.setBackground(new Color(240, 248, 255));
		txtpnSearchFor.setBounds(42, 88, 111, 29);
		panel_1.add(txtpnSearchFor);

		JTextPane txtpnComplexity_1 = new JTextPane();
		txtpnComplexity_1.setEditable(false);
		txtpnComplexity_1.setText("Complexity:");
		txtpnComplexity_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnComplexity_1.setBackground(new Color(240, 248, 255));
		txtpnComplexity_1.setBounds(42, 185, 120, 29);
		panel_1.add(txtpnComplexity_1);

		JTextPane txtpnCookingTime = new JTextPane();
		txtpnCookingTime.setEditable(false);
		txtpnCookingTime.setText("Cooking Time Up To:");
		txtpnCookingTime.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnCookingTime.setBackground(new Color(240, 248, 255));
		txtpnCookingTime.setBounds(42, 232, 194, 29);
		panel_1.add(txtpnCookingTime);

		JCheckBox checkBox = new JCheckBox("Seeds");
		checkBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent v) {
				if(checkBox.isSelected()){  
					isSeeds=1;   } 
				else {
					isSeeds=0;
				}
			}
		});
		checkBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox.setBackground(new Color(240, 248, 255));
		checkBox.setBounds(737, 216, 120, 41);
		panel_1.add(checkBox);

		JCheckBox checkBox_1 = new JCheckBox("Strawberries");
		checkBox_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent u) {
				if(checkBox_1.isSelected()){  
					isStrawberries=1;   } 
				else {
					isStrawberries=0;
				}
			}
		});
		checkBox_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_1.setBackground(new Color(240, 248, 255));
		checkBox_1.setBounds(567, 216, 163, 41);
		panel_1.add(checkBox_1);

		JCheckBox checkBox_3 = new JCheckBox("Tree Nuts");
		checkBox_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent t) {
				if(checkBox_3.isSelected()){  
					isTreeNuts=1;   } 
				else {
					isTreeNuts=0;
				}
			}
		});
		checkBox_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_3.setBackground(new Color(240, 248, 255));
		checkBox_3.setBounds(737, 266, 163, 41);
		panel_1.add(checkBox_3);

		JCheckBox checkBox_4 = new JCheckBox("Eggs");
		checkBox_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent s) {
				if(checkBox_4.isSelected()){  
					isEggs=1;   } 
				else {
					isEggs=0;
				}
			}
		});
		checkBox_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_4.setBackground(new Color(240, 248, 255));
		checkBox_4.setBounds(737, 166, 120, 55);
		panel_1.add(checkBox_4);

		JCheckBox checkBox_5 = new JCheckBox("Fish");
		checkBox_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent l) {
				if(checkBox_5.isSelected()){  
					isFish=1;   } 
				else {
					isFish=0;
				}
			}
		});
		checkBox_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_5.setBackground(new Color(240, 248, 255));
		checkBox_5.setBounds(567, 166, 152, 41);
		panel_1.add(checkBox_5);

		JCheckBox checkBox_6 = new JCheckBox("Coffie");
		checkBox_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent m) {
				if(checkBox_6.isSelected()){  
					isCoffie=1;   } 
				else {
					isCoffie=0;
				}
			}
		});
		checkBox_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_6.setBackground(new Color(240, 248, 255));
		checkBox_6.setBounds(567, 266, 152, 41);
		panel_1.add(checkBox_6);

		JCheckBox checkBox_7 = new JCheckBox("Gluten");
		checkBox_7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent n) {
				if(checkBox_7.isSelected()){  
					isGluten=1;   } 
				else {
					isGluten=0;
				}
			}
		});
		checkBox_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_7.setBackground(new Color(240, 248, 255));
		checkBox_7.setBounds(567, 316, 140, 41);
		panel_1.add(checkBox_7);

		JCheckBox checkBox_9 = new JCheckBox("Dairy");
		checkBox_9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent o) {
				if(checkBox_9.isSelected()){  
					isMilk=1;   } 
				else {
					isMilk=0;
				}
			}
		});
		checkBox_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_9.setBackground(new Color(240, 248, 255));
		checkBox_9.setBounds(567, 416, 130, 41);
		panel_1.add(checkBox_9);

		JCheckBox checkBox_10 = new JCheckBox("Lactose");
		checkBox_10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent p) {
				if(checkBox_10.isSelected()){  
					isLactose=1;   } 
				else {
					isLactose=0;
				}
			}
		});
		checkBox_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_10.setBackground(new Color(240, 248, 255));
		checkBox_10.setBounds(567, 366, 140, 41);
		panel_1.add(checkBox_10);

		JCheckBox checkBox_11 = new JCheckBox("Chocolate");
		checkBox_11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent q) {
				if(checkBox_11.isSelected()){  
					isChocolate=1;   } 
				else {
					isChocolate=0;
				}
			}
		});
		checkBox_11.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_11.setBackground(new Color(240, 248, 255));
		checkBox_11.setBounds(737, 416, 163, 41);
		panel_1.add(checkBox_11);

		JCheckBox checkBox_12 = new JCheckBox("Food Acidity");
		checkBox_12.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent r) {
				if(checkBox_12.isSelected()){  
					isAcidity=1;   } 
				else {
					isAcidity=0;
				}
			}
		});
		checkBox_12.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_12.setBackground(new Color(240, 248, 255));
		checkBox_12.setBounds(737, 366, 163, 41);
		panel_1.add(checkBox_12);

		String[] rate = {"0","50", "100", "150","200", "more than 200"};
		JComboBox comboBox_2 = new JComboBox(rate);
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox comboBox_2 = (JComboBox)e.getSource();
				rateAbove = (String)comboBox.getSelectedItem();
				if (rateAbove=="more than 200") {
					rateAbove="99999";
				}
			}
		});
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_2.setBounds(182, 284, 262, 41);
		panel_1.add(comboBox_2);

		JTextPane txtpnAdvancedSearch = new JTextPane();
		txtpnAdvancedSearch.setBounds(275, 11, 449, 57);
		panel_1.add(txtpnAdvancedSearch);
		txtpnAdvancedSearch.setEditable(false);
		txtpnAdvancedSearch.setText("Advanced Search");
		txtpnAdvancedSearch.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 40));
		txtpnAdvancedSearch.setBackground(new Color(240, 248, 255));



		JButton btnSearch = new JButton("Search!");
		btnSearch.setBounds(412, 488, 175, 47);
		panel_1.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_1.getText()==null)
				{
					JOptionPane.showMessageDialog(null,"One of the parameters is empty, Please fill all");
				}
				else
				{
					myView.statview.advancedSearch(textField_1.getText(), kashruth, complexity, timeToMake, rateAbove, isFish, isStrawberries, isCoffie, isGluten, isLactose, isMilk, isEggs, isSeeds, isTreeNuts, isPeanut, isAcidity, isChocolate);
					if (myView.check==false) {
						JOptionPane.showMessageDialog(null,"There is no match to your search, try again");
					}
					else {
						SearchRes f=new SearchRes();
						f.setVisible(true);
						AdvancedSearch.this.dispose();
						AdvancedSearch.this.setVisible(false);
					}
				}
			}});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 25));

	}
}
