import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.Font;

public class StudentRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblUsername;
	private JTextField textField_3;
	private JLabel lblPassword;
	private JLabel lblRepassword;
	private JLabel lblUsertype;
	private JButton btnSave;
	private JButton btnReset;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_4;
	JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentRegistration frame = new StudentRegistration();
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
	public StudentRegistration() {
		setTitle("Registration Window !!");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 473, 449);
		setLocationRelativeTo(this);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("ADD_NEW_USER");
		
		JLabel lblId = new JLabel("ID ");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e)
			{
				char c=e.getKeyChar();
				if((c < '0' || c > '9') && c != '\b')
				{
					e.consume();
				}
			}
		});
		
		
		JLabel lblName = new JLabel("Name ");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) 
			{
				char c=e.getKeyChar();
				if((c < 'A' || c > 'Z') && (c < 'a' || c > 'z') && c != ' ')
				{
					e.consume();
				}	
			}
		});
		textField.setColumns(10);
		
		JLabel lblMobile = new JLabel("Mobile ");
		lblMobile.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e)
			{
				char c=e.getKeyChar();
				if((c < '0' || c > '9') && c != '\b')
				{
					e.consume();
				}
			}
		});
		
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		lblUsername = new JLabel("Username ");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		lblPassword = new JLabel("Password ");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		lblRepassword = new JLabel("RePassword ");
		lblRepassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		lblUsertype = new JLabel("Usertype ");
		lblUsertype.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		passwordField = new JPasswordField();
		
		passwordField_1 = new JPasswordField();
		
		comboBox = new JComboBox();
		comboBox.insertItemAt("Select",0);
		comboBox.insertItemAt("Admin",1);
		comboBox.insertItemAt("Faculty",2);
		comboBox.insertItemAt("Student",3);
		comboBox.setSelectedIndex(0);
		
		btnSave = new JButton("Save ");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String id = textField_4.getText();
				String name=textField.getText();
				String mobile=textField_1.getText();
				String email=textField_2.getText();
				String username=textField_3.getText();				
				String pass=String.copyValueOf(passwordField.getPassword());
				String repass=String.copyValueOf(passwordField_1.getPassword());
				String usertype=(String)comboBox.getSelectedItem();
				
				
				if(id.length()==0 || name.length()==0 ||mobile.length()==0 || email.length()==0 ||username.length()==0 ||pass.length()==0 || usertype.equalsIgnoreCase("select"))
				{
				JOptionPane.showMessageDialog(getParent(), "Enter all details !!", "Error",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					if(!pass.equalsIgnoreCase(repass))
					{
						JOptionPane.showMessageDialog(getParent(), "Password and RePassword do not match !!", "Error",JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						String q1= "select * from registration where id=?";
						String q= "select * from registration where username=?";
						try {
							PreparedStatement ps2 = DBInfo.con.prepareStatement(q);
							ps2.setString(1, username);
							ResultSet res=ps2.executeQuery();
							
							PreparedStatement ps3 = DBInfo.con.prepareStatement(q1);
							ps3.setString(1, id);
							ResultSet res1=ps3.executeQuery();
							
							
							if(res.next())
							{
						JOptionPane.showMessageDialog(getParent(),"Username already taken .Select another Username.", "ERROR",JOptionPane.ERROR_MESSAGE);
						textField_3.setText(null);
							}
							else if(res1.next())
							{
						JOptionPane.showMessageDialog(getParent(),"User Id already taken .Select another User Id.", "ERROR",JOptionPane.ERROR_MESSAGE);
						textField_4.setText(null);
							}

							else
						{
							String query="insert into registration values(?,?,?,?,?)";
							String query1="insert into login values (?,?,?)";
							int flag=0;
							int flag1=0;
							Connection con = DBInfo.con;
							try {
								PreparedStatement ps=con.prepareStatement(query);
								ps.setString(1,id);
								ps.setString(2,name);
								ps.setString(3,mobile);
								ps.setString(4,email);
								ps.setString(5,username);
								
								flag=ps.executeUpdate();
								
								PreparedStatement ps1=con.prepareStatement(query1);
								ps1.setString(1,username);
								ps1.setString(2,pass);
								ps1.setString(3,usertype);
								
								flag1=ps1.executeUpdate();
								
								} catch (Exception event) {
								event.printStackTrace();
							}
				
							if(flag==1 && flag1==1)
							{
								JOptionPane.showMessageDialog(getParent(), usertype+" Added Successfully", "Message",JOptionPane.INFORMATION_MESSAGE);
								textField.setText(null);
								textField_1.setText(null);
								textField_2.setText(null);
								textField_3.setText(null);
								passwordField.setText(null);
								passwordField_1.setText(null);
	
							}
							else
								JOptionPane.showMessageDialog(getParent(),usertype+ " Not Added", "Error",JOptionPane.ERROR_MESSAGE);
	
							dispose();
							new StudentRegistration().setVisible(true);
							}
						
						} catch (Exception ex) {
							ex.printStackTrace();
						}	
						}
				}
			}
		});
		
		btnReset = new JButton("Reset ");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				passwordField.setText(null);
				passwordField_1.setText(null);
				comboBox.setSelectedIndex(0);
			}
		});
	
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(249)
					.addComponent(btnReset)
					.addContainerGap(135, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(176)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(57)
									.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
									.addGap(64))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblName)
										.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblMobile)
										.addComponent(lblEmail)
										.addComponent(lblUsername)
										.addComponent(lblPassword)
										.addComponent(lblRepassword)
										.addComponent(lblUsertype))
									.addGap(63)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox, 0, 166, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
								.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
								.addComponent(passwordField_1, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
								.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
								.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
								.addComponent(textField_2, 166, 166, Short.MAX_VALUE)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))))
					.addGap(104))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblId))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName))
					.addGap(8)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMobile))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRepassword))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsertype))
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnReset)
						.addComponent(btnSave))
					.addContainerGap(57, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
