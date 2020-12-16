package jdbcdemo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class EditPet extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private PetmeDAO petmeDAO;//dao var
	private PetMeApp petMeApp;//login page
	private Edit edit;//pet page
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblNewLabel_3_1_1_2;
	
	public EditPet(Edit theframe2, PetmeDAO thePetDAO )
	{
		this();
		petmeDAO = thePetDAO;
		edit = theframe2;
	
	}

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
			EditPet dialog = new EditPet();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public EditPet() {
	
		try {
			petmeDAO = new PetmeDAO();//INSTANCE OF DAO
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
		}
		
		
		setTitle("PetMe+");
		setBounds(100, 100, 690, 540);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(176, 224, 230));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 250, 205));
			panel.setBounds(0, 0, 138, 491);
			contentPanel.add(panel);
			
			JButton btnNewButton = new JButton("User Profile");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//go to edit
					Edit owner = new Edit(EditPet.this, petmeDAO);
					owner.setVisible(true);
				}
			});
			panel.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Pet Profile");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//go to pet edit
					//Edit owner = new Edit(Edit.this, petmeDAO);
					//owner.setVisible(true);
					
				}
			});
			panel.add(btnNewButton_1);
			
			JButton btnNewButton_11 = new JButton("Back");
			btnNewButton_11.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				//exit diolage
					setVisible(false);
					dispose();
				
				}
			});
			btnNewButton_11.setBounds(548, 17, 117, 29);
			contentPanel.add(btnNewButton_11);
			
			JLabel lblNewLabel = new JLabel("Name:");
			lblNewLabel.setBounds(313, 21, 79, 23);
			contentPanel.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Breed");
			lblNewLabel_1.setBounds(313, 95, 40, 23);
			contentPanel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_1_2 = new JLabel("Age:");
			lblNewLabel_1_2.setBounds(313, 129, 45, 23);
			contentPanel.add(lblNewLabel_1_2);
			
			JLabel lblNewLabel_2 = new JLabel("Type:");
			lblNewLabel_2.setBounds(314, 57, 68, 23);
			contentPanel.add(lblNewLabel_2);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(150, 20, 140, 141);
			contentPanel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel show_image = new JLabel("");
			Image img = new ImageIcon(this.getClass().getResource("/images/chandler.png")).getImage();
			show_image.setIcon(new ImageIcon(img));
			show_image.setBounds(0, 0, 140, 140);
			panel_1.add(show_image);
			
			JButton btnNewButton_3 = new JButton("Add Picture");
			btnNewButton_3.setBounds(150, 165, 140, 29);
			contentPanel.add(btnNewButton_3);
		}
		
		final JLabel lblNewLabel_3 = new JLabel("Chandler");
		lblNewLabel_3.setBounds(397, 24, 61, 16);
		contentPanel.add(lblNewLabel_3);
		
		final JLabel lblNewLabel_3_1 = new JLabel("Dog");
		lblNewLabel_3_1.setBounds(394, 60, 108, 16);
		contentPanel.add(lblNewLabel_3_1);
		
		final JLabel lblNewLabel_3_1_1 = new JLabel("10 months");
		lblNewLabel_3_1_1.setBounds(394, 133, 108, 16);
		contentPanel.add(lblNewLabel_3_1_1);
		
		final JLabel lblNewLabel_3_1_2 = new JLabel("Silky Terrier");
		lblNewLabel_3_1_2.setBounds(394, 98, 161, 16);
		contentPanel.add(lblNewLabel_3_1_2);
		
		JLabel lblNewLabel_4 = new JLabel("Food:");
		lblNewLabel_4.setBounds(313, 173, 46, 14);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Medication:");
		lblNewLabel_4_1.setBounds(307, 208, 68, 14);
		contentPanel.add(lblNewLabel_4_1);
		
		final JLabel lblNewLabel_3_1_1_1 = new JLabel("Blue Buffalo");
		lblNewLabel_3_1_1_1.setBounds(394, 173, 108, 16);
		contentPanel.add(lblNewLabel_3_1_1_1);
		
		lblNewLabel_3_1_1_2 = new JLabel("None");
		lblNewLabel_3_1_1_2.setBounds(394, 207, 108, 16);
		contentPanel.add(lblNewLabel_3_1_1_2);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Medication:");
		lblNewLabel_4_1_1.setBounds(166, 465, 55, 14);
		contentPanel.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Food:");
		lblNewLabel_4_2.setBounds(179, 429, 46, 14);
		contentPanel.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Age:");
		lblNewLabel_1_2.setBounds(179, 385, 45, 23);
		contentPanel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1 = new JLabel("Breed");
		lblNewLabel_1.setBounds(179, 351, 40, 23);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Type:");
		lblNewLabel_2.setBounds(180, 313, 68, 23);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(179, 277, 79, 23);
		contentPanel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(227, 278, 177, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(227, 314, 177, 20);
		contentPanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(229, 352, 177, 20);
		contentPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(227, 386, 177, 20);
		contentPanel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(227, 426, 177, 20);
		contentPanel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(227, 462, 177, 20);
		contentPanel.add(textField_5);
		
		JButton btnNewButton_2 = new JButton("Save");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name =  textField.getText();
				String type =  textField_1.getText();
				String breed =  textField_2.getText();
				String age =  textField_3.getText();
				String food =  textField_4.getText();
				String medication =  textField_5.getText();
				
				
				
				if(!name.isEmpty())
				{
					lblNewLabel_3.setText(name);
				}
				
				if(!type.isEmpty())
				{
					lblNewLabel_3_1.setText(type);
				}
				
				if(!breed.isEmpty())
				{
					lblNewLabel_3_1_2.setText(breed);
				}
				
				if(!age.isEmpty())
				{
					lblNewLabel_3_1_1.setText(age);
				}
				if(!food.isEmpty())
				{
					lblNewLabel_3_1_1_1.setText(food);
				}
				if(!medication.isEmpty())
				{
					lblNewLabel_3_1_1_2.setText(medication);
				}
				
				//JOptionPane.showMessageDialog(null, "Account created! ", "Account created!",
				//			JOptionPane.INFORMATION_MESSAGE);	
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
			}
		});
		btnNewButton_2.setBounds(548, 453, 117, 29);
		contentPanel.add(btnNewButton_2);
		
	}
		
	
}

