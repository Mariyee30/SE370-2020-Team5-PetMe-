package jdbcdemo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import javax.swing.JOptionPane;
import java.util.List;

public class Edit extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	
	private PetmeDAO petmeDAO;//dao var
	private PetMeApp petMeApp;//login page
	private Frame2 frame2;//sign in page
	private EditPet editPet;
	private JTable table;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	
	public Edit(Frame2 theframe2, PetmeDAO thePetDAO )
	{
		this();
		petmeDAO = thePetDAO;
		frame2 = theframe2;
	
	}
	
	public Edit(EditPet theframe2, PetmeDAO thePetDAO )
	{
		this();
		petmeDAO = thePetDAO;
		editPet = theframe2;
	
	}
	
	public Edit(PetMeApp thePetMeApp, PetmeDAO thePetDAO )
	{
		this();
		petmeDAO = thePetDAO;
		petMeApp = thePetMeApp;
	
	}

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		try {
			Edit dialog = new Edit();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	
	
	public Edit() {
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
			panel.setBounds(0, 0, 138, 501);
			contentPanel.add(panel);
			
			JButton btnNewButton = new JButton("User Profile");
			panel.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Pet Profile");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//go to pet edit
					EditPet owner = new EditPet(Edit.this, petmeDAO);
					owner.setVisible(true);
					
					//setVisible(false);
					//dispose();
					
				}
			});
			panel.add(btnNewButton_1);
			
			JLabel lblNewLabel = new JLabel("First name:");
			lblNewLabel.setBounds(302, 20, 79, 23);
			contentPanel.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Email:");
			lblNewLabel_1.setBounds(331, 94, 40, 23);
			contentPanel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_1_2 = new JLabel("Phone:");
			lblNewLabel_1_2.setBounds(326, 129, 45, 23);
			contentPanel.add(lblNewLabel_1_2);
			
			JLabel lblNewLabel_2 = new JLabel("Last name:");
			lblNewLabel_2.setBounds(303, 56, 68, 23);
			contentPanel.add(lblNewLabel_2);
			
			JButton btnNewButton_1_1 = new JButton("Logout");
			btnNewButton_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					//dispose();
				}
			});
			btnNewButton_1_1.setBounds(547, 17, 117, 29);
			contentPanel.add(btnNewButton_1_1);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(150, 20, 140, 141);
			contentPanel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel show_image = new JLabel("");
			Image img = new ImageIcon(this.getClass().getResource("/images/self.jpg")).getImage();
			show_image.setIcon(new ImageIcon(img));
			show_image.setBounds(0, 0, 140, 140);
			panel_1.add(show_image);
			
			JButton btnNewButton_3 = new JButton("Add Picture");
			btnNewButton_3.setBounds(150, 173, 140, 29);
			contentPanel.add(btnNewButton_3);
		}
		
		final JLabel lblNewLabel_3 = new JLabel("Lauren");
		lblNewLabel_3.setBounds(386, 23, 61, 16);
		contentPanel.add(lblNewLabel_3);
		
		final JLabel lblNewLabel_3_1 = new JLabel("Gonzalez");
		lblNewLabel_3_1.setBounds(383, 59, 108, 16);
		contentPanel.add(lblNewLabel_3_1);
		
		final JLabel lblNewLabel_3_1_1 = new JLabel("(123)456-7890");
		lblNewLabel_3_1_1.setBounds(383, 132, 108, 16);
		contentPanel.add(lblNewLabel_3_1_1);
		
		final JLabel lblNewLabel_3_1_2 = new JLabel("laurengonz@gmail.com");
		lblNewLabel_3_1_2.setBounds(383, 97, 161, 16);
		contentPanel.add(lblNewLabel_3_1_2);
		
		JLabel lblNewLabel = new JLabel("First name:");
		lblNewLabel.setBounds(148, 358, 79, 23);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setBounds(177, 432, 40, 23);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Phone:");
		lblNewLabel_1_2.setBounds(172, 467, 45, 23);
		contentPanel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("Last name:");
		lblNewLabel_2.setBounds(149, 394, 68, 23);
		contentPanel.add(lblNewLabel_2);
		
		textField_4 = new JTextField();
		textField_4.setBounds(213, 359, 168, 20);
		contentPanel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(213, 392, 168, 20);
		contentPanel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(213, 433, 168, 20);
		contentPanel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(213, 466, 168, 20);
		contentPanel.add(textField_7);
		
		JButton btnNewButton1 = new JButton("Save");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name =  textField_4.getText();
				String lname =  textField_5.getText();
				String em =  textField_6.getText();
				String pho =  textField_7.getText();
				
				String email =  lblNewLabel_3_1_2.getText();
				String n = "Lauren@";
				try {
					petmeDAO.updateUserInfo(name,lname,n,pho);
				}catch (Exception exc) {
					JOptionPane.showMessageDialog(null, "Successfully Updated","Updated", JOptionPane.INFORMATION_MESSAGE);
				}
				
				if(!name.isEmpty())
				{
					lblNewLabel_3.setText(name);
				}
				
				if(!lname.isEmpty())
				{
					lblNewLabel_3_1.setText(lname);
				}
				
				if(!em.isEmpty())
				{
					lblNewLabel_3_1_2.setText(em);
				}
				
				if(!pho.isEmpty())
				{
					lblNewLabel_3_1_1.setText(pho);
				}
				
				//JOptionPane.showMessageDialog(null, "Account created! ", "Account created!",
				//			JOptionPane.INFORMATION_MESSAGE);	
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				
				
			}
		});
		btnNewButton1.setBounds(547, 461, 117, 29);
		contentPanel.add(btnNewButton1);
		
	}
		
			
//(22)
	
	public void refreshEmployeesView() {
		
	}
}
