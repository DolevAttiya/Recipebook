package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtKljaeld;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 593);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 105, 225));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnWelcomeToRecipebook = new JTextPane();
		txtpnWelcomeToRecipebook.setForeground(new Color(255, 255, 255));
		txtpnWelcomeToRecipebook.setBackground(new Color(65, 105, 225));
		txtpnWelcomeToRecipebook.setFont(new Font("Tempus Sans ITC", Font.BOLD, 60));
		txtpnWelcomeToRecipebook.setText("Welcome To Taimli !");
		txtpnWelcomeToRecipebook.setBounds(76, 85, 609, 83);
		contentPane.add(txtpnWelcomeToRecipebook);
		
		JLabel lblUserName = new JLabel("Email:");
		lblUserName.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 27));
		lblUserName.setForeground(new Color(255, 255, 255));
		lblUserName.setBounds(189, 207, 153, 41);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 27));
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setBounds(189, 264, 153, 42);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(342, 214, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLogin.setBounds(277, 313, 146, 41);
		contentPane.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(342, 272, 146, 26);
		contentPane.add(passwordField);
		
		JButton btnRegister = new JButton("Sign up!");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegister.setBounds(277, 361, 147, 41);
		contentPane.add(btnRegister);
	}
}
