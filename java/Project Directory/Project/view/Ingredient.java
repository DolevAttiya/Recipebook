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
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Ingredient extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
				Fat= Double.parseDouble(textField_4.getText());
				Protein= Double.parseDouble(textField_6.getText());
				Carbs= Double.parseDouble(textField_3.getText());
				Calories= Double.parseDouble(textField_2.getText());
				if((textField_7.getText().trim().isEmpty())||(textField_2.getText().trim().isEmpty())||(textField_3.getText().trim().isEmpty())||(textField_4.getText().trim().isEmpty())||(textField_6.getText().trim().isEmpty())) {
					JOptionPane.showMessageDialog(null,"One of the parameters is empty, Please fill all");
				}
				else {
					myView.statview.addIngredient(textField_7.getText(), kashruth, isFish, isStrawberries, isCoffie, isGluten, isLactose, isMilk, isEggs, isSeeds, isTreeNuts, isPeanut, isAcidity, isChocolate, Calories, Carbs, Fat, Protein);
					if(myView.check==false)
						JOptionPane.showMessageDialog(null,"Something went wrong, Please try again!");
					else {				
						Ingredient.this.dispose();
						Ingredient.this.setVisible(false);
					}
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
		textPane.setBounds(660, 210, 85, 21);
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
		textPane_5.setBounds(536, 170, 340, 38);
		panel_1.add(textPane_5);

		textField_2 = new JTextField();
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calories= Double.parseDouble(textField_2.getText());
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
		checkBox_1.setBounds(210, 225, 121, 41);
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
		checkBox_2.setBounds(210, 385, 209, 41);
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
		checkBox_3.setBounds(210, 265, 167, 41);
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
		checkBox_5.setBounds(210, 345, 153, 41);
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
		checkBox_6.setBounds(210, 425, 167, 41);
		panel_1.add(checkBox_6);

		JTextPane textPane_3 = new JTextPane();
		textPane_3.setEditable(false);
		textPane_3.setText("Allergies:");
		textPane_3.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 30));
		textPane_3.setBackground(new Color(240, 248, 255));
		textPane_3.setBounds(67, 180, 192, 41);
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
		checkBox_7.setBounds(210, 305, 153, 41);
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
		checkBox_8.setBounds(32, 265, 173, 41);
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
				textField.setBounds(495, 36, 163, 21);
				panel.add(textField);
				textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
				textField.setColumns(10);

				JTextPane textPane_51 = new JTextPane();
				textPane_51.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						myView.statview.getTop10();
						MainPage b=new MainPage();
						b.setVisible(true);
						Ingredient.this.dispose();
						Ingredient.this.setVisible(false);
					}
				});
				textPane_51.setBounds(10, 0, 204, 57);
				panel.add(textPane_51);
				textPane_51.setText("Taimli");
				textPane_51.setForeground(Color.WHITE);
				textPane_51.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 50));
				textPane_51.setEditable(false);
				textPane_51.setBackground(new Color(65, 105, 225));

				JTextPane textPane1 = new JTextPane();
				textPane1.addMouseListener(new MouseAdapter() {
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
						Ingredient.this.dispose();
						Ingredient.this.setVisible(false);
					}
				});
				textPane1.setBounds(882, 8, 102, 49);
				panel.add(textPane1);
				textPane1.setText("user details");
				textPane1.setForeground(Color.WHITE);
				textPane1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
				textPane1.setEditable(false);
				textPane1.setBackground(new Color(65, 105, 225));

				JTextPane textPane_11 = new JTextPane();
				textPane_11.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						AdvancedSearch d=new AdvancedSearch();
						d.setVisible(true);
						Ingredient.this.dispose();
						Ingredient.this.setVisible(false);
					}
				});
				textPane_11.setBounds(729, 7, 126, 50);
				panel.add(textPane_11);
				textPane_11.setText("Advanced Search");
				textPane_11.setForeground(Color.WHITE);
				textPane_11.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
				textPane_11.setEditable(false);
				textPane_11.setBackground(new Color(65, 105, 225));

				JTextPane textPane_31 = new JTextPane();
				textPane_31.setBounds(559, 11, 92, 29);
				panel.add(textPane_31);
				textPane_31.setText("Search");
				textPane_31.setForeground(Color.WHITE);
				textPane_31.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
				textPane_31.setEditable(false);
				textPane_31.setBackground(new Color(65, 105, 225));

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
								Ingredient.this.dispose();
								Ingredient.this.setVisible(false);
							}
						}
					}
				});
				button.setBounds(659, 36, 47, 21);
				panel.add(button);
				button.setFont(new Font("Tahoma", Font.BOLD, 5));

				JTextPane textPane_21 = new JTextPane();
				textPane_21.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						myView.statview.myFavorite();
						MyFavourites d=new MyFavourites();
						d.setVisible(true);
						Ingredient.this.dispose();
						Ingredient.this.setVisible(false);
					}
				});
				textPane_21.setBounds(341, 8, 132, 49);
				panel.add(textPane_21);
				textPane_21.setText("Favourite Recipes");
				textPane_21.setForeground(Color.WHITE);
				textPane_21.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
				textPane_21.setEditable(false);
				textPane_21.setBackground(new Color(65, 105, 225));

				JTextPane textPane_41 = new JTextPane();
				textPane_41.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						myView.statview.myRecipes();
						MyRecipes c=new MyRecipes();
						c.setVisible(true);
						Ingredient.this.dispose();
						Ingredient.this.setVisible(false);
					}
				});
				textPane_41.setBounds(224, 8, 107, 49);
				panel.add(textPane_41);
				textPane_41.setText("My Recipes");
				textPane_41.setForeground(Color.WHITE);
				textPane_41.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
				textPane_41.setEditable(false);
				textPane_41.setBackground(new Color(65, 105, 225));
	}
}