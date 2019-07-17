package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ingredient extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtRecipebook;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;
	public int kashruth =0;
	public double Calories=0;
	public double Carbs=0;
	public double Fat=0;
	public double Protein=0;
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


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ingredient frame = new Ingredient();
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
	public Ingredient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 700);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
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
		
		String[] kashruthing = {"Parve", "Dairy", "Meat","Not Kosher"};
		JComboBox comboBox_1 = new JComboBox(kashruthing);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox comboBox_1 = (JComboBox)arg0.getSource();
		        kashruth = comboBox_1.getSelectedIndex();
			}
		});
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_1.setBounds(150, 133, 269, 31);
		panel_1.add(comboBox_1);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField_7.setColumns(10);
		textField_7.setBounds(240, 91, 669, 31);
		panel_1.add(textField_7);
		
		JTextPane txtpnAdvancedSearch = new JTextPane();
		txtpnAdvancedSearch.setEditable(false);
		txtpnAdvancedSearch.setText("Add an Ingredient");
		txtpnAdvancedSearch.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 40));
		txtpnAdvancedSearch.setBackground(new Color(240, 248, 255));
		txtpnAdvancedSearch.setBounds(243, 22, 473, 57);
		panel_1.add(txtpnAdvancedSearch);
		
		JButton btnSearch = new JButton("Add!");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((textField_7.getText().trim().isEmpty())||(textField_2.getText().trim().isEmpty())||(textField_3.getText().trim().isEmpty())||(textField_4.getText().trim().isEmpty())||(textField_6.getText().trim().isEmpty())) {
					JOptionPane.showMessageDialog(null,"One of the parameters is empty, Please fill all");
				}
				else if(myView.check==false)
					JOptionPane.showMessageDialog(null,"Something went wrong, Please try again!");
				else {
						myView.statview.addIngredient (textField_7.getText(), kashruth, isFish, isStrawberries, isCoffie, isGluten, isLactose, isMilk, isEggs, isSeeds, isTreeNuts, isPeanut, isAcidity, isChocolate, Calories, Carbs, Fat, Protein);
				Ingredient.this.dispose();
				Ingredient.this.setVisible(false);
				}
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnSearch.setBounds(433, 471, 144, 41);
		panel_1.add(btnSearch);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setText("per 100 grams");
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPane.setBackground(new Color(240, 248, 255));
		textPane.setBounds(660, 207, 85, 21);
		panel_1.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setText("Protein:");
		textPane_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPane_1.setBackground(new Color(240, 248, 255));
		textPane_1.setBounds(536, 356, 85, 31);
		panel_1.add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setEditable(false);
		textPane_2.setText("Fat:");
		textPane_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPane_2.setBackground(new Color(240, 248, 255));
		textPane_2.setBounds(536, 316, 41, 31);
		panel_1.add(textPane_2);
		
		JTextPane txtpnCarbs = new JTextPane();
		txtpnCarbs.setEditable(false);
		txtpnCarbs.setText("Carbs:");
		txtpnCarbs.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnCarbs.setBackground(new Color(240, 248, 255));
		txtpnCarbs.setBounds(536, 276, 63, 31);
		panel_1.add(txtpnCarbs);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setEditable(false);
		textPane_4.setText("Calories:");
		textPane_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPane_4.setBackground(new Color(240, 248, 255));
		textPane_4.setBounds(536, 236, 85, 31);
		panel_1.add(textPane_4);
		
		JTextPane textPane_5 = new JTextPane();
		textPane_5.setEditable(false);
		textPane_5.setText("Nutrition Values:");
		textPane_5.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 30));
		textPane_5.setBackground(new Color(240, 248, 255));
		textPane_5.setBounds(536, 170, 340, 58);
		panel_1.add(textPane_5);
		
		textField_2 = new JTextField();
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Calories= Double.parseDouble(textField_7.getText());
			}
		});
		textField_2.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(631, 236, 226, 31);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Carbs= Double.parseDouble(textField_3.getText());

			}
		});
		textField_3.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(631, 276, 226, 31);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Fat= Double.parseDouble(textField_4.getText());

			}
		});
		textField_4.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(631, 316, 226, 31);
		panel_1.add(textField_4);
		
		textField_6 = new JTextField();
		textField_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Protein= Double.parseDouble(textField_6.getText());
			}
		});
		textField_6.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField_6.setColumns(10);
		textField_6.setBounds(631, 356, 226, 31);
		panel_1.add(textField_6);
		
		JTextPane txtpnComponentName = new JTextPane();
		txtpnComponentName.setEditable(false);
		txtpnComponentName.setText("Component Name:");
		txtpnComponentName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnComponentName.setBackground(new Color(240, 248, 255));
		txtpnComponentName.setBounds(48, 90, 173, 31);
		panel_1.add(txtpnComponentName);
		
		JTextPane txtpnCategory_1 = new JTextPane();
		txtpnCategory_1.setEditable(false);
		txtpnCategory_1.setText("Kashruth:");
		txtpnCategory_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnCategory_1.setBackground(new Color(240, 248, 255));
		txtpnCategory_1.setBounds(48, 133, 92, 31);
		panel_1.add(txtpnCategory_1);
		
		JCheckBox checkBox = new JCheckBox("Gluten");
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(checkBox.isSelected()){  
					  isGluten=1;   } 
				 else {
					 isGluten=0;
				 }
			}
		});
		checkBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox.setBackground(new Color(240, 248, 255));
		checkBox.setBounds(32, 345, 144, 41);
		panel_1.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("Eggs");
		checkBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(checkBox_1.isSelected()){  
					  isEggs=1;   } 
				 else {
					 isEggs=0;
				 }
			}
		});
		checkBox_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_1.setBackground(new Color(240, 248, 255));
		checkBox_1.setBounds(187, 225, 121, 41);
		panel_1.add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("Food Acidity");
		checkBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(checkBox_2.isSelected()){  
					  isAcidity=1;   } 
				 else {
					 isAcidity=0;
				 }
			}
		});
		checkBox_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_2.setBackground(new Color(240, 248, 255));
		checkBox_2.setBounds(187, 385, 133, 41);
		panel_1.add(checkBox_2);
		
		JCheckBox checkBox_3 = new JCheckBox("Seeds");
		checkBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(checkBox_3.isSelected()){  
					  isSeeds=1;   } 
				 else {
					 isSeeds=0;
				 }
			}
		});
		checkBox_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_3.setBackground(new Color(240, 248, 255));
		checkBox_3.setBounds(187, 265, 92, 41);
		panel_1.add(checkBox_3);
		
		JCheckBox checkBox_4 = new JCheckBox("Lactose");
		checkBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(checkBox_4.isSelected()){  
					  isLactose=1;   } 
				 else {
					 isLactose=0;
				 }
			}
		});
		checkBox_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_4.setBackground(new Color(240, 248, 255));
		checkBox_4.setBounds(32, 385, 121, 41);
		panel_1.add(checkBox_4);
		
		JCheckBox checkBox_5 = new JCheckBox("Peanut");
		checkBox_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(checkBox_5.isSelected()){  
					  isPeanut=1;   } 
				 else {
					 isPeanut=0;
				 }
			}
		});
		checkBox_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_5.setBackground(new Color(240, 248, 255));
		checkBox_5.setBounds(187, 345, 105, 41);
		panel_1.add(checkBox_5);
		
		JCheckBox checkBox_6 = new JCheckBox("Chocolate");
		checkBox_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(checkBox_6.isSelected()){  
					  isChocolate=1;   } 
				 else {
					 isChocolate=0;
				 }
			}
		});
		checkBox_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_6.setBackground(new Color(240, 248, 255));
		checkBox_6.setBounds(187, 425, 121, 41);
		panel_1.add(checkBox_6);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setEditable(false);
		textPane_3.setText("Allergies:");
		textPane_3.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 30));
		textPane_3.setBackground(new Color(240, 248, 255));
		textPane_3.setBounds(67, 190, 192, 41);
		panel_1.add(textPane_3);
		
		JCheckBox checkBox_7 = new JCheckBox("Tree Nuts");
		checkBox_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(checkBox_7.isSelected()){  
					  isTreeNuts=1;   } 
				 else {
					 isTreeNuts=0;
				 }
			}
		});
		checkBox_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_7.setBackground(new Color(240, 248, 255));
		checkBox_7.setBounds(187, 305, 121, 41);
		panel_1.add(checkBox_7);
		
		JCheckBox checkBox_8 = new JCheckBox("Strawberries");
		checkBox_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(checkBox_8.isSelected()){  
					  isStrawberries=1;   } 
				 else {
					 isStrawberries=0;
				 }
			}
		});
		checkBox_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_8.setBackground(new Color(240, 248, 255));
		checkBox_8.setBounds(32, 265, 153, 41);
		panel_1.add(checkBox_8);
		
		JCheckBox checkBox_9 = new JCheckBox("Coffie");
		checkBox_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(checkBox_9.isSelected()){  
					  isCoffie=1;   } 
				 else {
					 isCoffie=0;
				 }
			}
		});
		checkBox_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_9.setBackground(new Color(240, 248, 255));
		checkBox_9.setBounds(32, 305, 144, 41);
		panel_1.add(checkBox_9);
		
		JCheckBox checkBox_10 = new JCheckBox("Dairy");
		checkBox_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(checkBox_10.isSelected()){  
					  isMilk=1;   } 
				 else {
					 isMilk=0;
				 }
			}
		});
		checkBox_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_10.setBackground(new Color(240, 248, 255));
		checkBox_10.setBounds(32, 425, 121, 41);
		panel_1.add(checkBox_10);
		
		JCheckBox checkBox_11 = new JCheckBox("Fish");
		checkBox_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 if(checkBox_11.isSelected()){  
					  isFish=1;   } 
				 else {
					  isFish=0;
				 }
			}
		});
		checkBox_11.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_11.setBackground(new Color(240, 248, 255));
		checkBox_11.setBounds(32, 225, 153, 41);
		panel_1.add(checkBox_11);
		
		//panel upper
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
		
		JTextPane textPane_12 = new JTextPane();
		textPane_12.setBounds(0, 0, 204, 57);
		panel.add(textPane_12);
		textPane_12.setText("Taimli");
		textPane_12.setForeground(Color.WHITE);
		textPane_12.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 50));
		textPane_12.setEditable(false);
		textPane_12.setBackground(new Color(65, 105, 225));
		
		JTextPane textPane_9 = new JTextPane();
		textPane_9.setBounds(898, 8, 96, 49);
		panel.add(textPane_9);
		textPane_9.setText("user details");
		textPane_9.setForeground(Color.WHITE);
		textPane_9.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
		textPane_9.setEditable(false);
		textPane_9.setBackground(new Color(65, 105, 225));
		
		JTextPane textPane_10 = new JTextPane();
		textPane_10.setBounds(746, 8, 126, 50);
		panel.add(textPane_10);
		textPane_10.setText("Advanced Search");
		textPane_10.setForeground(Color.WHITE);
		textPane_10.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
		textPane_10.setEditable(false);
		textPane_10.setBackground(new Color(65, 105, 225));
		
		JTextPane textPane_11 = new JTextPane();
		textPane_11.setBounds(582, 11, 92, 29);
		panel.add(textPane_11);
		textPane_11.setText("Search");
		textPane_11.setForeground(Color.WHITE);
		textPane_11.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
		textPane_11.setEditable(false);
		textPane_11.setBackground(new Color(65, 105, 225));
		
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
				Ingredient.this.dispose();
				Ingredient.this.setVisible(false);
				}
			}
		});
		button.setBounds(682, 36, 47, 21);
		panel.add(button);
		button.setFont(new Font("Tahoma", Font.BOLD, 5));
		
		JTextPane textPane_7 = new JTextPane();
		textPane_7.setBounds(385, 8, 132, 49);
		panel.add(textPane_7);
		textPane_7.setText("Favourite Recipes");
		textPane_7.setForeground(Color.WHITE);
		textPane_7.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
		textPane_7.setEditable(false);
		textPane_7.setBackground(new Color(65, 105, 225));
		
		JTextPane textPane_8 = new JTextPane();
		textPane_8.setBounds(242, 8, 107, 49);
		panel.add(textPane_8);
		textPane_8.setText("My Recipes");
		textPane_8.setForeground(Color.WHITE);
		textPane_8.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
		textPane_8.setEditable(false);
		textPane_8.setBackground(new Color(65, 105, 225));
	}
}