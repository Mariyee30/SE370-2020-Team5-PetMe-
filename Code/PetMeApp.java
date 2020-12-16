package jdbcdemo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.Image;
import java.awt.List;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;

//import jdbcdemo.PetMeDAO;
public class PetMeApp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PetmeDAO petmeDAO;
	//private Edit edit;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PetMeApp frame = new PetMeApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	public PetMeApp(Pet thePrevP, boolean theUpdateMode) {
		this();

		prevP = thePrevP;
		
		updateMode = theUpdateMode;

		if (updateMode) {
			setTitle("Update Employee");
			
			populateGui(prevP);
		}
	}
	
*/
	
	/**
	 * Create the frame.
	 */
	public PetMeApp() 
	{
		//CREATE DAO
		try {
			petmeDAO = new PetmeDAO();//INSTANCE OF DAO
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
		}
		
		//
		setTitle("PetMe+");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 441);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 205));
		panel.setBounds(0, 0, 278, 441);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 250, 205));
		panel_1.setBounds(14, 151, 256, 262);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel show_image = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/images/pet-care-2.png")).getImage();
		show_image.setIcon(new ImageIcon(img));
		show_image.setBounds(3, 20, 251, 257);
		panel_1.add(show_image);
		
		JLabel lblNewLabel_1 = new JLabel("PetMe+");
		lblNewLabel_1.setFont(new Font("Cubano", Font.PLAIN, 50));
		lblNewLabel_1.setBounds(51, 43, 189, 56);
		panel.add(lblNewLabel_1);
		
		JButton btnBackToLogin = new JButton("Login");
		btnBackToLogin.setBounds(80, 111, 133, 29);
		panel.add(btnBackToLogin);
		btnBackToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				//Edit owner = new Edit(PetMeApp.this, petmeDAO);
				//owner.setVisible(true);
				
				Frame2 owner = new Frame2(PetMeApp.this, petmeDAO);
				owner.setVisible(true);
			}
		});
		
		textField = new JTextField();
		textField.setBounds(290, 34, 318, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Email:");
		lblNewLabel.setBounds(294, 10, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(294, 86, 83, 16);
		contentPane.add(lblPassword);
		
		JLabel lblReenterPassword = new JLabel("Re-enter Password:");
		lblReenterPassword.setBounds(294, 167, 156, 16);
		contentPane.add(lblReenterPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(290, 115, 318, 40);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(290, 195, 318, 40);
		contentPane.add(passwordField_1);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveUser();
				
				
			}
		});
		btnSignUp.setBounds(618, 361, 123, 29);
		contentPane.add(btnSignUp);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(294, 249, 156, 16);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(453, 249, 156, 16);
		contentPane.add(lblLastName);
		
		JLabel lblPhoneNumber = new JLabel("Phone number:");
		lblPhoneNumber.setBounds(294, 327, 156, 16);
		contentPane.add(lblPhoneNumber);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(290, 355, 318, 40);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(290, 277, 156, 40);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(453, 277, 156, 40);
		contentPane.add(textField_3);
	}
	
	

	//save login
	
	protected void saveUser()
	{//start

		//getting info from text field EMAIL & PSW
		String email =  textField.getText();
	
		String password1 = passwordField.getText();
		String password2 = passwordField_1.getText();
		String fn=  textField_2.getText();
		String ls =  textField_3.getText();
		String phone =  textField_1.getText();
		
		//String oname = passwordField.getText();
		boolean check = password1.equals(password2);
		if(check == false)
		{
			JOptionPane.showMessageDialog(PetMeApp.this, "Password does not match", "ERROR",
					JOptionPane.ERROR_MESSAGE);	
		}
		else {
		
		
			Pet tempPet = new Pet(email, fn, ls, phone);//CREATE PET INSTANCE
			try {
			// save to the database
			petmeDAO.addUser(tempPet);
			
			if(check != false)
			{
				JOptionPane.showMessageDialog(PetMeApp.this, "Account created! ", "Account created!",
					JOptionPane.INFORMATION_MESSAGE);	
			}
			textField.setText("");
			passwordField.setText("");
			passwordField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_1.setText("");
		}catch (Exception exc) {
			JOptionPane.showMessageDialog(null, "Error saving pet: " + exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		}
	}
}


