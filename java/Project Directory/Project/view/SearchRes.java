package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;
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

import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class SearchRes extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private Component txtRecipebook;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchRes frame = new SearchRes();
					frame.setVisible(true);
					frame.setTitle("Taimli!");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SearchRes() {
		setSize(1664, 1493);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
		contentPane = new JPanel();
		contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 105, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//panelkavuaa
		JPanel panel = new JPanel();
		panel.setBounds(26, 15, 1603, 87);
		panel.setBackground(new Color(65, 105, 225));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAdd = new JButton("Go!");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchRes d=new SearchRes();
				d.setVisible(true);
				SearchRes.this.dispose();
				SearchRes.this.setVisible(false);
			}
		});
		btnAdd.setBounds(1016, 37, 71, 42);
		panel.add(btnAdd);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		textField_2.setColumns(10);
		textField_2.setBounds(747, 37, 340, 43);
		panel.add(textField_2);

		JTextPane txtpnUserDetails = new JTextPane();
		txtpnUserDetails.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				User f=new User();
				f.setVisible(true);
				SearchRes.this.dispose();
				SearchRes.this.setVisible(false);
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
				SearchRes.this.dispose();
				SearchRes.this.setVisible(false);
			}
		});
		txtpnAdvancedSearch_1.setText("Advanced Search");
		txtpnAdvancedSearch_1.setForeground(Color.WHITE);
		txtpnAdvancedSearch_1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 28));
		txtpnAdvancedSearch_1.setBackground(new Color(65, 105, 225));
		txtpnAdvancedSearch_1.setBounds(1146, 7, 215, 80);
		panel.add(txtpnAdvancedSearch_1);
		JTextPane txtpnFavouriteRecipes = new JTextPane();
		txtpnFavouriteRecipes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MyFavourites f=new MyFavourites();
				f.setVisible(true);
				SearchRes.this.dispose();
				SearchRes.this.setVisible(false);
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
				SearchRes.this.dispose();
				SearchRes.this.setVisible(false);
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
				SearchRes.this.dispose();
				SearchRes.this.setVisible(false);
			}
		});
		txtpnTaimli.setText("Taimli");
		txtpnTaimli.setForeground(Color.WHITE);
		txtpnTaimli.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 80));
		txtpnTaimli.setBackground(new Color(65, 105, 225));
		txtpnTaimli.setBounds(0, -7, 343, 96);
		panel.add(txtpnTaimli);

		//panelkavuaa

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 248, 255));
		panel_1.setBounds(0, 106, 1610, 1299);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JTextPane txtpnAdvancedSearch = new JTextPane();
		txtpnAdvancedSearch.setText("Search Results");
		txtpnAdvancedSearch.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 80));
		txtpnAdvancedSearch.setBackground(new Color(240, 248, 255));
		txtpnAdvancedSearch.setBounds(452, 56, 969, 99);
		panel_1.add(txtpnAdvancedSearch);

		String[] columnNames = {"Recipe Name",
                "Description",
                "Rate",
                "Calories",
                "Kosher"}; // name, description, rate, calories, kosher, 
		Object[][] data = {
			    {"Kathy", "Smith",
			     "Snowboarding", new Integer(5), new Boolean(false)},
			    {"John", "Doe",
			     "Rowing", new Integer(3), new Boolean(true)},
			    {"Sue", "Black",
			     "Knitting", new Integer(2), new Boolean(false)},
			    {"Jane", "White",
			     "Speed reading", new Integer(20), new Boolean(true)},
			    {"Joe", "Brown",
			     "Pool", new Integer(10), new Boolean(false)}
			};
		
		JTable table = new JTable(data, columnNames);
		table.setFont(new Font("Tahoma", Font.PLAIN, 40));
		table.setRowHeight(50);
		JTableHeader th = table.getTableHeader();
		th.setPreferredSize(new Dimension(100, 100));
		Font bigFont = new Font("Tahoma", Font.PLAIN, 45);
		table.getTableHeader().setFont(bigFont);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		table.setRowHeight(1, 60);
		scrollPane.setSize(1514, 1001);
		scrollPane.setLocation(46, 154);
		//TableColumn column = null;
		panel_1.add(scrollPane);
	}
}