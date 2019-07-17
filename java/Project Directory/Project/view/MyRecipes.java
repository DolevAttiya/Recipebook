
package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class MyRecipes extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField txtRecipebook;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyRecipes frame = new MyRecipes();
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
	public MyRecipes() {
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
		
		JTextPane txtpnAdvancedSearch = new JTextPane();
		txtpnAdvancedSearch.setEditable(false);
		txtpnAdvancedSearch.setText("My Recipies");
		txtpnAdvancedSearch.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 40));
		txtpnAdvancedSearch.setBackground(new Color(240, 248, 255));
		txtpnAdvancedSearch.setBounds(282, 11, 309, 57);
		panel_1.add(txtpnAdvancedSearch);
		
		String[] columnNames = {"Recipe Name",
				"Description",
				"Rate",
				"Calories",
		"Kosher"}; 

		Object[][] data = new Object[myView.recipeArray.size()][5];
		for(int row=0;row<myView.recipeArray.size();row++) {
			data[row][0]=myView.recipeArray.get(row).getRecipeName();
			data[row][1]=myView.recipeArray.get(row).getRecipeDescription();
			data[row][2]=myView.recipeArray.get(row).getRecipeRate();
			data[row][3]=myView.recipeArray.get(row).getRecipeTotalCalories();
			data[row][4]=myView.recipeArray.get(row).getRecipeKashruth();
		}
		JTable table = new JTable(data, columnNames);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myView.statview.myRecipe=myView.statview.recipeArray.get(table.getSelectedRow());
				RecipeView f=new RecipeView();
				f.setVisible(true);
				MyRecipes.this.dispose();
				MyRecipes.this.setVisible(false);
			}
		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setRowHeight(50);
		JTableHeader th = table.getTableHeader();
		th.setPreferredSize(new Dimension(100, 30));
		Font bigFont = new Font("Tahoma", Font.PLAIN, 12);
		table.getTableHeader().setFont(bigFont);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		table.setRowHeight(1, 60);
		scrollPane.setSize(951, 506);
		scrollPane.setLocation(10, 69);
		//TableColumn column = null;
		panel_1.add(scrollPane);
		
		
		
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
						MyRecipes.this.dispose();
						MyRecipes.this.setVisible(false);
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
						MyRecipes.this.dispose();
						MyRecipes.this.setVisible(false);
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
						MyRecipes.this.dispose();
						MyRecipes.this.setVisible(false);
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
						MyRecipes.this.dispose();
						MyRecipes.this.setVisible(false);
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
						MyRecipes.this.dispose();
						MyRecipes.this.setVisible(false);
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
						MyRecipes.this.dispose();
						MyRecipes.this.setVisible(false);
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