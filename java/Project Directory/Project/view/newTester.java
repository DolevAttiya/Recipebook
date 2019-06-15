package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class newTester extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	public newTester () {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		//setContentPane(contentPane);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(62, 229, 1135, 569);
		getContentPane().add(panel);
		setVisible (true);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newTester frame = new newTester();
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
	
}






//setSize ((int)(Toolkit.getDefaultToolkit().getScreenSize().width*0.5),(int)(Toolkit.getDefaultToolkit().getScreenSize().height*0.5));
		//getContentPane().setLayout(null);
		