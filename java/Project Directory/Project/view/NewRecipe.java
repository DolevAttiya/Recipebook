
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
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import model.Ingredient;

import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import java.awt.TextArea;
import javax.swing.JScrollPane;
import java.awt.Component;

public class NewRecipe extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_5;
	private JTextField textField_3;
	private JTextField txtRecipebook;
	private JTextField textField_1;
	private JTextField textField_9;

	//allergies:
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
	public Double amount=0.0;
	Object[][] dataIngredients;
	public int Complexity=0;
	public int timeToMake=0;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewRecipe frame = new NewRecipe();
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
	public NewRecipe() {
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

		String[] columnNames = {"Ingredient Name",
				"Amount",
		"Mesuring"}; 
		 dataIngredients = new Object[myView.recipeArray.size()][3];
		for(int row=0;row<myView.ingredientArrayForRecipe.size();row++) {
			dataIngredients[row][0]=myView.ingredientArrayForRecipe.get(row).getIngredientName();
			dataIngredients[row][1]=myView.myRecipe.getRecipeIngredientsAmount().get(row).toString();
			dataIngredients[row][2]=myView.myMeasuringForRecipe.get(row).getIngredientTypeName();
		}
		JTable table = new JTable(dataIngredients, columnNames);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setRowHeight(80);
		JTableHeader th = table.getTableHeader();
		th.setPreferredSize(new Dimension(100, 30));
		Font bigFont = new Font("Tahoma", Font.PLAIN, 12);
		table.getTableHeader().setFont(bigFont);

		String[] times = {"30", "60", "120", "180", "all"}; //if string=all -->>99999

		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		scrollPane.setSize(611, 145);
		scrollPane.setLocation(10, 198);
		//TableColumn column = null;
		panel_1.add(scrollPane);

		TextArea textArea = new TextArea();
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 40));
		textArea.setBounds(10, 365, 611, 149);
		panel_1.add(textArea);

		JComboBox comboBox_1 = new JComboBox(); //get
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox comboBox_1 = (JComboBox)e.getSource();
				String mesuring = (String)comboBox_1.getSelectedItem();
			}
		});
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_1.setBounds(400, 164, 130, 32);
		panel_1.add(comboBox_1);


		textField_3 = new JTextField();
		textField_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				amount= Double.parseDouble(textField_3.getText());
			}
		});
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(318, 165, 81, 32);
		panel_1.add(textField_3);

		//ALLERGIES
		JCheckBox checkBox_7 = new JCheckBox("Gluten");
		checkBox_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox_7.isSelected()){  
					isGluten=1;   } 
				else {
					isGluten=0;
				}
			}
		});
		checkBox_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_7.setBackground(new Color(240, 248, 255));
		checkBox_7.setBounds(638, 222, 88, 41);
		panel_1.add(checkBox_7);

		JCheckBox checkBox_4 = new JCheckBox("Eggs");
		checkBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox_4.isSelected()){  
					isEggs=1;   } 
				else {
					isEggs=0;
				}
			}
		});
		checkBox_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_4.setBackground(new Color(240, 248, 255));
		checkBox_4.setBounds(804, 102, 81, 41);
		panel_1.add(checkBox_4);

		JCheckBox checkBox_11 = new JCheckBox("Food Acidity");
		checkBox_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox_11.isSelected()){  
					isAcidity=1;   } 
				else {
					isAcidity=0;
				}
			}
		});
		checkBox_11.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_11.setBackground(new Color(240, 248, 255));
		checkBox_11.setBounds(804, 262, 141, 41);
		panel_1.add(checkBox_11);

		JCheckBox checkBox_1 = new JCheckBox("Seeds");
		checkBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox_1.isSelected()){  
					isSeeds=1;   } 
				else {
					isSeeds=0;
				}
			}
		});
		checkBox_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_1.setBackground(new Color(240, 248, 255));
		checkBox_1.setBounds(804, 142, 104, 41);
		panel_1.add(checkBox_1);

		JCheckBox checkBox_9 = new JCheckBox("Lactose");
		checkBox_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox_9.isSelected()){  
					isLactose=1;   } 
				else {
					isLactose=0;
				}
			}
		});
		checkBox_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_9.setBackground(new Color(240, 248, 255));
		checkBox_9.setBounds(638, 262, 104, 41);
		panel_1.add(checkBox_9);

		JCheckBox checkBox = new JCheckBox("Peanut");
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox.isSelected()){  
					isPeanut=1;   } 
				else {
					isPeanut=0;
				}
			}
		});
		checkBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox.setBackground(new Color(240, 248, 255));
		checkBox.setBounds(804, 222, 97, 41);
		panel_1.add(checkBox);

		JCheckBox checkBox_10 = new JCheckBox("Chocolate");
		checkBox_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox_10.isSelected()){  
					isChocolate=1;   } 
				else {
					isChocolate=0;
				}
			}
		});
		checkBox_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_10.setBackground(new Color(240, 248, 255));
		checkBox_10.setBounds(804, 302, 118, 41);
		panel_1.add(checkBox_10);

		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setText("Allergies:");
		textPane.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 30));
		textPane.setBackground(new Color(240, 248, 255));
		textPane.setBounds(681, 60, 198, 41);
		panel_1.add(textPane);

		JCheckBox checkBox_3 = new JCheckBox("Tree Nuts");
		checkBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox_3.isSelected()){  
					isTreeNuts=1;   } 
				else {
					isTreeNuts=0;
				}
			}
		});
		checkBox_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_3.setBackground(new Color(240, 248, 255));
		checkBox_3.setBounds(804, 182, 118, 41);
		panel_1.add(checkBox_3);

		JCheckBox checkBox_2 = new JCheckBox("Strawberries");
		checkBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox_2.isSelected()){  
					isStrawberries=1;   } 
				else {
					isFish=0;
				}
			}
		});
		checkBox_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_2.setBackground(new Color(240, 248, 255));
		checkBox_2.setBounds(638, 142, 141, 41);
		panel_1.add(checkBox_2);

		JCheckBox checkBox_6 = new JCheckBox("Coffie");
		checkBox_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox_6.isSelected()){  
					isCoffie=1;   } 
				else {
					isCoffie=0;
				}
			}
		});
		checkBox_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_6.setBackground(new Color(240, 248, 255));
		checkBox_6.setBounds(638, 182, 81, 41);
		panel_1.add(checkBox_6);

		JCheckBox checkBox_8 = new JCheckBox("Dairy");
		checkBox_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox_8.isSelected()){  
					isMilk=1;   } 
				else {
					isMilk=0;
				}
			}
		});
		checkBox_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_8.setBackground(new Color(240, 248, 255));
		checkBox_8.setBounds(638, 302, 88, 41);
		panel_1.add(checkBox_8);

		JCheckBox checkBox_5 = new JCheckBox("Fish");
		checkBox_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox_5.isSelected()){  
					isFish=1;   } 
				else {
					isFish=0;
				}
			}
		});
		checkBox_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkBox_5.setBackground(new Color(240, 248, 255));
		checkBox_5.setBounds(638, 102, 65, 41);
		panel_1.add(checkBox_5);


		JComboBox comboBox = new JComboBox(); //get
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setBounds(174, 164, 141, 32);
		panel_1.add(comboBox);

		JTextPane txtpnCategory = new JTextPane();
		txtpnCategory.setEditable(false);
		txtpnCategory.setText("Name:");
		txtpnCategory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnCategory.setBackground(new Color(240, 248, 255));
		txtpnCategory.setBounds(218, 142, 46, 23);
		panel_1.add(txtpnCategory);

		JTextPane txtpnAdvancedSearch = new JTextPane();
		txtpnAdvancedSearch.setEditable(false);
		txtpnAdvancedSearch.setText("Add New Recipe");
		txtpnAdvancedSearch.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 40));
		txtpnAdvancedSearch.setBackground(new Color(240, 248, 255));
		txtpnAdvancedSearch.setBounds(302, 8, 412, 55);
		panel_1.add(txtpnAdvancedSearch);

		JTextPane txtpnIngredients = new JTextPane();
		txtpnIngredients.setEditable(false);
		txtpnIngredients.setText("Add Ingredients:");
		txtpnIngredients.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnIngredients.setBackground(new Color(240, 248, 255));
		txtpnIngredients.setBounds(10, 149, 154, 31);
		panel_1.add(txtpnIngredients);

		JTextPane txtpnInstructions = new JTextPane();
		txtpnInstructions.setEditable(false);
		txtpnInstructions.setText("Instructions:");
		txtpnInstructions.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnInstructions.setBackground(new Color(240, 248, 255));
		txtpnInstructions.setBounds(10, 338, 118, 32);
		panel_1.add(txtpnInstructions);

		JTextPane txtpnAmount = new JTextPane();
		txtpnAmount.setEditable(false);
		txtpnAmount.setText("Amount:");
		txtpnAmount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnAmount.setBackground(new Color(240, 248, 255));
		txtpnAmount.setBounds(325, 142, 65, 23);
		panel_1.add(txtpnAmount);

		JTextPane txtpnMeauring = new JTextPane();
		txtpnMeauring.setEditable(false);
		txtpnMeauring.setText("Measuring:");
		txtpnMeauring.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnMeauring.setBackground(new Color(240, 248, 255));
		txtpnMeauring.setBounds(427, 142, 72, 23);
		panel_1.add(txtpnMeauring);

		JTextPane textPane_2 = new JTextPane();
		textPane_2.setEditable(false);
		textPane_2.setText("Name:");
		textPane_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPane_2.setBackground(new Color(240, 248, 255));
		textPane_2.setBounds(10, 69, 65, 31);
		panel_1.add(textPane_2);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(85, 69, 533, 31);
		panel_1.add(textField_1);

		JTextPane textPane_3 = new JTextPane();
		textPane_3.setEditable(false);
		textPane_3.setText("Description:");
		textPane_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPane_3.setBackground(new Color(240, 248, 255));
		textPane_3.setBounds(10, 109, 113, 31);
		panel_1.add(textPane_3);

		textField_9 = new JTextField();
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_9.setColumns(10);
		textField_9.setBounds(126, 109, 492, 31);
		panel_1.add(textField_9);


		JButton btnAddNewIngredient = new JButton("Add New Ingredient");
		btnAddNewIngredient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.Ingredient f=new view.Ingredient();
				f.setVisible(true);
			}
		});
		btnAddNewIngredient.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddNewIngredient.setBounds(671, 491, 251, 23);
		panel_1.add(btnAddNewIngredient);

		String[] kashruthing = {"Parve", "Dairy", "Meat","Not Kosher"};

		JButton btnAdd_1 = new JButton("Add");
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Integer> ing=new ArrayList<Integer>();
				myView.statview.addIngredientToRecipe (myView.statview.ingredientArray.get(comboBox.getSelectedIndex()),myView.statview.myMeasuring.get(comboBox_1.getSelectedIndex()),amount);
				dataIngredients= new Object [myView.myRecipe.getRecipeIngredientId().size()][3];
				for(int row=0;row<myView.myRecipe.getRecipeIngredientId().size();row++)
				{
					dataIngredients[row][0]=myView.ingredientArrayForRecipe.get(row).getIngredientName();
					dataIngredients[row][1]=myView.myRecipe.getRecipeIngredientsAmount().get(row).toString();
					dataIngredients[row][2]=myView.myMeasuringForRecipe.get(row).getIngredientTypeName();
				}
				;
			}
		});
		btnAdd_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd_1.setBounds(533, 164, 88, 32);
		panel_1.add(btnAdd_1);
		
		String[] complexiting = {"Easy", "Medium", "Hard"};
		JTextPane textPane_5 = new JTextPane();
		textPane_5.setBounds(638, 350, 112, 31);
		panel_1.add(textPane_5);
		textPane_5.setEditable(false);
		textPane_5.setText("Complexity:");
		textPane_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPane_5.setBackground(new Color(240, 248, 255));
		JComboBox comboBox_4_1 = new JComboBox(complexiting);
		comboBox_4_1.setBounds(638, 381, 307, 31);
		panel_1.add(comboBox_4_1);
		comboBox_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox comboBox_4 = (JComboBox)e.getSource();
		        Complexity = (int)comboBox_4.getSelectedIndex();
			}
		});
		comboBox_4_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
				JTextPane textPane_6 = new JTextPane();
				textPane_6.setBounds(638, 412, 194, 31);
				panel_1.add(textPane_6);
				textPane_6.setEditable(false);
				textPane_6.setText("Cooking Time Up To:");
				textPane_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
				textPane_6.setBackground(new Color(240, 248, 255));
				JComboBox comboBox_5_1 = new JComboBox(times);
				comboBox_5_1.setBounds(638, 445, 307, 31);
				panel_1.add(comboBox_5_1);
				comboBox_5_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
				JComboBox comboBox_5 = (JComboBox)e.getSource();
		        timeToMake = (int)comboBox_5.getSelectedIndex();
					}
				});
				comboBox_5_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
				
						JButton btnSearch = new JButton("Add!");
						btnSearch.setBounds(401, 534, 179, 41);
						panel_1.add(btnSearch);
						btnSearch.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
				if((textField_1.getText().trim().isEmpty())||(textField_9.getText().trim().isEmpty())||(textField_3.getText().trim().isEmpty())||(textArea.getText().trim().isEmpty())) {
					JOptionPane.showMessageDialog(null,"One of the parameters is empty, Please fill all");
				}

				else {
					
					myView.statview.addRecipe(textField_1.getText(), isFish, isStrawberries, isCoffie, isGluten, isLactose, isMilk, isEggs, isSeeds, isTreeNuts, isPeanut, isAcidity, isChocolate, textField_9.getText(), Complexity, timeToMake, textArea.getText());
					RecipeView f=new RecipeView();
					f.setVisible(true);
					NewRecipe.this.dispose();
					NewRecipe.this.setVisible(false);
				}
							}
						});
						btnSearch.setFont(new Font("Tahoma", Font.BOLD, 25));


		
		
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
						MainPage b=new MainPage();
						b.setVisible(true);
						NewRecipe.this.dispose();
						NewRecipe.this.setVisible(false);
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
						NewRecipe.this.dispose();
						NewRecipe.this.setVisible(false);
					}
				});
				textPane1.setBounds(882, 8, 102, 49);
				panel.add(textPane1);
				textPane1.setText("user details");
				textPane1.setForeground(Color.WHITE);
				textPane1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
				textPane1.setEditable(false);
				textPane1.setBackground(new Color(65, 105, 225));
				
				JTextPane textPane_1 = new JTextPane();
				textPane_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						AdvancedSearch d=new AdvancedSearch();
						d.setVisible(true);
						NewRecipe.this.dispose();
						NewRecipe.this.setVisible(false);
					}
				});
				textPane_1.setBounds(729, 7, 126, 50);
				panel.add(textPane_1);
				textPane_1.setText("Advanced Search");
				textPane_1.setForeground(Color.WHITE);
				textPane_1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
				textPane_1.setEditable(false);
				textPane_1.setBackground(new Color(65, 105, 225));
				
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
						myView.statview.mainSearch(textField.getText());  
						if (myView.check==false) {
							JOptionPane.showMessageDialog(null,"There is no match to your search, try again");
						}
						else {
							SearchRes d=new SearchRes();
						d.setVisible(true);
						NewRecipe.this.dispose();
						NewRecipe.this.setVisible(false);
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
						NewRecipe.this.dispose();
						NewRecipe.this.setVisible(false);
					}
				});
				textPane_21.setBounds(341, 8, 132, 49);
				panel.add(textPane_21);
				textPane_21.setText("Favourite Recipes");
				textPane_21.setForeground(Color.WHITE);
				textPane_21.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 18));
				textPane_21.setEditable(false);
				textPane_21.setBackground(new Color(65, 105, 225));
				
				JTextPane textPane_4 = new JTextPane();
				textPane_4.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						myView.statview.myRecipes();
						MyRecipes c=new MyRecipes();
						c.setVisible(true);
						NewRecipe.this.dispose();
						NewRecipe.this.setVisible(false);
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
