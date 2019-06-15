package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
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

public class MyFavourites extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFavourites frame = new MyFavourites();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyFavourites() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 593);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 105, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(65, 105, 225));
		panel.setBounds(15, 5, 718, 41);
		contentPane.add(panel);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("Add a Component");
		textPane.setForeground(Color.WHITE);
		textPane.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 10));
		textPane.setBackground(new Color(65, 105, 225));
		textPane.setBounds(440, 17, 150, 27);
		panel.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("Search");
		textPane_1.setForeground(Color.WHITE);
		textPane_1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 10));
		textPane_1.setBackground(new Color(65, 105, 225));
		textPane_1.setBounds(378, 17, 102, 27);
		panel.add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setText("Favourite Recipes");
		textPane_2.setForeground(Color.WHITE);
		textPane_2.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 10));
		textPane_2.setBackground(new Color(65, 105, 225));
		textPane_2.setBounds(250, 17, 146, 27);
		panel.add(textPane_2);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setText("My Recipes");
		textPane_3.setForeground(Color.WHITE);
		textPane_3.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 10));
		textPane_3.setBackground(new Color(65, 105, 225));
		textPane_3.setBounds(168, 17, 102, 27);
		panel.add(textPane_3);
		
		textField = new JTextField();
		textField.setText("Taimli");
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 34));
		textField.setColumns(10);
		textField.setBackground(new Color(65, 105, 225));
		textField.setBounds(11, 0, 386, 44);
		panel.add(textField);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setText("user details");
		textPane_4.setForeground(Color.WHITE);
		textPane_4.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 12));
		textPane_4.setBackground(new Color(65, 105, 225));
		textPane_4.setBounds(616, 14, 102, 27);
		panel.add(textPane_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 248, 255));
		panel_1.setBounds(4, 51, 718, 451);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JTextPane txtpnAdvancedSearch = new JTextPane();
		txtpnAdvancedSearch.setText("My Favourites");
		txtpnAdvancedSearch.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 30));
		txtpnAdvancedSearch.setBackground(new Color(240, 248, 255));
		txtpnAdvancedSearch.setBounds(198, 14, 418, 41);
		panel_1.add(txtpnAdvancedSearch);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 20));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(79);
		table.setBounds(55, 59, 614, 320);
		panel_1.add(table);
		
		JButton button = new JButton("Previous Page");
		button.setFont(new Font("Tahoma", Font.BOLD, 16));
		button.setBounds(198, 393, 150, 41);
		panel_1.add(button);
		
		JButton button_1 = new JButton("Next Page");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_1.setBounds(354, 393, 150, 41);
		panel_1.add(button_1);
	}
}