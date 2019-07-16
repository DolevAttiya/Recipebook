package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class newTest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newTest frame = new newTest();
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
	public newTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnHereIsA = new JTextPane();
		txtpnHereIsA.setText("here is a test");
		txtpnHereIsA.setBounds(38, 56, 232, 39);
		contentPane.add(txtpnHereIsA);
		
		JButton btnKaftor = new JButton("kaftor");
		btnKaftor.setBounds(88, 143, 171, 41);
		contentPane.add(btnKaftor);
	}

}
