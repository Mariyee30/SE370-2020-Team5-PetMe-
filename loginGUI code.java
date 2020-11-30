import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginGUI implements ActionListener {
	
	private static JLabel userLabel;
	private static JTextField userText;
	private static JLabel passwordLabel;
	private static JPasswordField passwordText;
	private static JButton loginButton;
	private static JLabel success;

	public static void main(String[] args) {
		
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		frame.setSize(350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.setLayout(null);
		
		userLabel = new JLabel("UserName:");
		userLabel.setBounds(10, 20, 80, 25); //(x, y, width, height)
		panel.add(userLabel);
		
		userText = new JTextField(20); //box to fill in user name
		userText.setBounds(100, 20, 165, 25); //(x, y, width, height)
		panel.add(userText);
		
		passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(10, 50, 80, 25); //(x, y, width, height)
		panel.add(passwordLabel);
		
		passwordText = new JPasswordField(); //box to fill in password
		passwordText.setBounds(100, 50, 165, 25);
		panel.add(passwordText);
		
		loginButton = new JButton("Login"); //for the login button 
		loginButton.setBounds(10, 150, 80, 25);
		loginButton.addActionListener(new LoginGUI());
		panel.add(loginButton);
		
		success = new JLabel(""); //for a successful login 
		success.setBounds(10, 200, 300, 25);
		panel.add(success);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String user = userText.getText();
		String password = passwordText.getText();
		System.out.println(user + ", " + password);
		
		if(user.equals(userText.getText()) && password.equals(passwordText.getText())) {
			
			success.setText("Login successful");
		}
		
	}

}
