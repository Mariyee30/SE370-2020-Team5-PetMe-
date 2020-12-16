package jdbcdemo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame2 extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private PetmeDAO petmeDAO;//dao var
	private PetMeApp petMeApp;//login page
	
	

	public Frame2(PetMeApp thePetMeApp, PetmeDAO thePetDAO )
	{
		this();
		petmeDAO = thePetDAO;
		petMeApp = thePetMeApp;
	
	}

	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
			Frame2 dialog = new Frame2();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
	/**
	 * Create the dialog.
	 */
	public Frame2() {
		setTitle("PetMe+");
		setBounds(100, 100, 758, 441);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(176, 224, 230));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 205));
		panel.setBounds(0, 0, 278, 441);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("PetMe+");
		lblNewLabel_1.setFont(new Font("Cubano", Font.PLAIN, 50));
		lblNewLabel_1.setBounds(51, 43, 189, 56);
		panel.add(lblNewLabel_1);
		
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
		
		JLabel lblNewLabel = new JLabel("Email:");
		lblNewLabel.setBounds(373, 104, 61, 16);
		contentPanel.add(lblNewLabel);
		
		JTextField textField = new JTextField();
		textField.setBounds(369, 132, 318, 40);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(373, 183, 83, 16);
		contentPanel.add(lblPassword);
		
		final JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(369, 211, 318, 40);
		contentPanel.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String ps =  passwordField.getText();
				String ps1 =  "12345";
				
				//String oname = passwordField.getText();
				boolean check = ps.equals(ps1);
				if(check == false)
				{
					JOptionPane.showMessageDialog(null, "Incorrect Password", "ERROR",
							JOptionPane.ERROR_MESSAGE);	
				}
				else
				{
					Edit owner = new Edit(Frame2.this, petmeDAO);
					owner.setVisible(true);
					setVisible(false);
					dispose();
				}
			}
		});
		btnNewButton.setBounds(375, 263, 306, 29);
		contentPanel.add(btnNewButton);
		
		
	}
}
