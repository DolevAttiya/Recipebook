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


	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					  frame.setVisible(true);
					  frame.setTitle("Taimli!");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public void close() {
		WindowEvent winClosingEvent= new WindowEvent (this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}

	/**
	 * Create the frame.
	 */

	public Login() {
		
		
		setSize(1000, 700);
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
		txtpnWelcomeToRecipebook.setBounds(36, 100, 916, 160);
		contentPane.add(txtpnWelcomeToRecipebook);
		txtpnWelcomeToRecipebook.setEditable(false);
		txtpnWelcomeToRecipebook.setForeground(new Color(255, 255, 255));
		txtpnWelcomeToRecipebook.setBackground(new Color(65, 105, 225));
		txtpnWelcomeToRecipebook.setFont(new Font("Tempus Sans ITC", Font.BOLD, 90));
		txtpnWelcomeToRecipebook.setText("Welcome To Taimli !");

		JLabel lblUserName = new JLabel("Email:");
		lblUserName.setBounds(53, 271, 207, 72);
		contentPane.add(lblUserName);
		lblUserName.setFont(new Font("Dialog", Font.PLAIN, 50));
		lblUserName.setForeground(new Color(255, 255, 255));

		textField = new JTextField();
		textField.setBounds(278, 280, 641, 65);
		contentPane.add(textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 40));
		textField.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(39, 354, 238, 72);
		contentPane.add(lblPassword);
		lblPassword.setFont(new Font("Dialog", Font.PLAIN, 50));
		lblPassword.setForeground(new Color(255, 255, 255));

		passwordField = new JPasswordField(50);
		passwordField.setBounds(278, 364, 641, 65);
		contentPane.add(passwordField);
		passwordField.setFont(new Font("Dialog", Font.PLAIN, 40));

		JButton btnRegister = new JButton("Sign up!");
		btnRegister.setBounds(365, 546, 238, 63);
		contentPane.add(btnRegister);
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 45));
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(365, 472, 238, 63);
		contentPane.add(btnLogin);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 45));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent f) {
				myView.statview.login(textField.getText(), String.copyValueOf(passwordField.getPassword()));
				if (myView.check==true) // Connected as User or as Dietitian
				{
					myView.statview.myRecipes();

					MainPage a=new MainPage();
					a.setVisible(true);
					Login.this.dispose();
					Login.this.setVisible(false);
				}
				else // not exist
					JOptionPane.showMessageDialog(null,"One of the parameters is wrong, Please try again");
			}
		});
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register a=new Register();
				a.setVisible(true);
				close();
			}
		});
	}
}
