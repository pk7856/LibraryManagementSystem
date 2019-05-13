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
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Updatepass extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Updatepass frame = new Updatepass();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void reset()
	{
		passwordField.setText(null);
		passwordField_1.setText(null);
		passwordField_2.setText(null);
		textField.setText(null);
	}

	/**
	 * Create the frame.
	 */
	public Updatepass() {
		setTitle("Reset Password ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 415, 344);
		setLocationRelativeTo(this);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("UPDATE_PASSWORD");
		
		JLabel lblUsername = new JLabel("Username ");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblCurrentPassword = new JLabel("Current Password ");
		lblCurrentPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewPassword = new JLabel("New Password ");
		lblNewPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password ");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		passwordField = new JPasswordField();
		
		passwordField_1 = new JPasswordField();
		
		passwordField_2 = new JPasswordField();
		
		JButton btnSave = new JButton("Save ");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String username= textField.getText();
				String oldpass =String.copyValueOf(passwordField.getPassword());
				String pass =String.copyValueOf(passwordField_1.getPassword());
				String repass =String.copyValueOf(passwordField_2.getPassword());
				
				if(oldpass.length()==0 || pass.length()==0 || repass.length()==0)
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
						String query="update login set password=? where username=?";
						int flag=0;
						try {
							PreparedStatement ps=DBInfo.con.prepareStatement(query);
							
							ps.setString(1,pass);
							ps.setString(2,username);
							
							flag=ps.executeUpdate();
				
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
						if(flag==1 )
						{
							JOptionPane.showMessageDialog(getParent(), "Password Updated Successfully", "Message",JOptionPane.INFORMATION_MESSAGE);
							reset();
						}
						else
							JOptionPane.showMessageDialog(getParent(), "Password Not Updated", "Error",JOptionPane.ERROR_MESSAGE);
					}
					
					}
				}
			
		});
		
		JButton btnReset = new JButton("Reset ");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				reset();
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(37)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUsername)
								.addComponent(lblCurrentPassword)
								.addComponent(lblNewPassword)
								.addComponent(lblConfirmPassword))
							.addGap(63)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(passwordField_2, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
								.addComponent(passwordField_1, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
								.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(66)
							.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
							.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addGap(53)))
					.addGap(49))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(131)
					.addComponent(lblNewLabel)
					.addContainerGap(166, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCurrentPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewPassword)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConfirmPassword)
						.addComponent(passwordField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnReset))
					.addGap(43))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
