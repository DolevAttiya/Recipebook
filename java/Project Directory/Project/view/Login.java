package view;
import view.myView;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.im.InputContext;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.WindowEvent;
	
public class Login extends JFrame {

	private JTextField textField;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

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
	
	public void close() {
		WindowEvent winClosingEvent= new WindowEvent (this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setSize(1664, 1493);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 105, 225));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//components:
		JTextPane txtpnWelcomeToRecipebook = new JTextPane();
		txtpnWelcomeToRecipebook.setForeground(new Color(255, 255, 255));
		txtpnWelcomeToRecipebook.setBackground(new Color(65, 105, 225));
		txtpnWelcomeToRecipebook.setFont(new Font("Tempus Sans ITC", Font.BOLD, 99));
		txtpnWelcomeToRecipebook.setText("Welcome To Taimli !");
		txtpnWelcomeToRecipebook.setBounds(302, 234, 1028, 160);
		contentPane.add(txtpnWelcomeToRecipebook);
		
		JLabel lblUserName = new JLabel("Email:");
		lblUserName.setFont(new Font("Dialog", Font.PLAIN, 70));
		lblUserName.setForeground(new Color(255, 255, 255));
		lblUserName.setBounds(302, 504, 536, 72);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Dialog", Font.PLAIN, 70));
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setBounds(302, 604, 536, 72);
		contentPane.add(lblPassword);
		textField = new JTextField(50);
		textField.setBounds(342, 214, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 70));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myView.statview.login(passwordField_1.getText(), String.copyValueOf(passwordField.getPassword()));
				MainPage a=new MainPage();
				a.setVisible(true);
				close();
			}
		});
		btnLogin.setBounds(589, 867, 421, 93);
		contentPane.add(btnLogin);
		
		passwordField = new JPasswordField(50);
		passwordField.setFont(new Font("Dialog", Font.PLAIN, 50));
		passwordField.setBounds(662, 615, 641, 65);
		contentPane.add(passwordField);
		
		JButton btnRegister = new JButton("Sign up!");
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 70));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register a=new Register();
				a.setVisible(true);
				close();
			}
		});
		btnRegister.setBounds(589, 976, 421, 93);
		contentPane.add(btnRegister);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Dialog", Font.PLAIN, 50));
		passwordField_1.setBounds(662, 515, 641, 65);
		contentPane.add(passwordField_1);
	}
}
