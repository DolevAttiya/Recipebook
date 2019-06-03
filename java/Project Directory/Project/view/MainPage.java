package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class MainPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtRecipebook;
	private JTextField txtPicture;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 602);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtRecipebook = new JTextField();
		txtRecipebook.setBounds(5, 5, 186, 46);
		txtRecipebook.setFont(new Font("Tempus Sans ITC", Font.BOLD, 30));
		txtRecipebook.setBackground(new Color(230, 230, 250));
		txtRecipebook.setText("RecipeBook");
		contentPane.add(txtRecipebook);
		txtRecipebook.setColumns(10);
		
		txtPicture = new JTextField();
		txtPicture.setText("picture");
		txtPicture.setFont(new Font("Tempus Sans ITC", Font.BOLD, 30));
		txtPicture.setColumns(10);
		txtPicture.setBackground(new Color(230, 230, 250));
		txtPicture.setBounds(625, 5, 118, 46);
		contentPane.add(txtPicture);
	}

}
