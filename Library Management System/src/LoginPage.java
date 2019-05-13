import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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

	public static void sound()
	{
		try {
			FileInputStream save = new FileInputStream("loginacc.mp3");
			Player player = new Player(save);
			player.play();
		//	System.out.println("login sound");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 catch (JavaLayerException e) {
		e.printStackTrace();
	}	
	}
	
	public LoginPage() {
		setTitle("Login !!");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 496, 421);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		
		JLabel lblNewLabel = new JLabel("LOGIN ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username ");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblPassword = new JLabel("Password ");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnLogin = new JButton("Login ");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String usertype="";
				String s1=textField.getText();
				char ch[] = passwordField.getPassword();
				String s2=String.copyValueOf(ch); // password
				String query = "select * from login where username=? and password=?";
				Connection con = DBInfo.con;
				int i=0;
				try 
				{
					PreparedStatement ps= con.prepareStatement(query);
					ps.setString(1,s1);
					ps.setString(2, s2);
					ResultSet res = ps.executeQuery();
					while(res.next())
					{
						i=1;
						usertype=res.getString(3);
						break;
					}

					sound();
					
				} catch (Exception e)
				{
					e.printStackTrace();
				}
		
				if(i==1 && usertype.equalsIgnoreCase("admin"))
				{
					AdminSection ad= new AdminSection();
					ad.setVisible(true);
					dispose();	
				}
				if(i==1 && usertype.equalsIgnoreCase("student"))
				{
					StudentSection ss=new StudentSection();
					ss.setVisible(true);
					dispose();
				}
				if(i==1 && usertype.equalsIgnoreCase("faculty"))
				{
					FacultySection fs=new FacultySection();
					fs.setVisible(true);
					dispose();
					
				}
				if(i==0)
				{
					JOptionPane.showMessageDialog(getParent(), "Wrong Username or password!!", "Error",JOptionPane.ERROR_MESSAGE);
				}
			
			}
		});
		
		JButton btnReset = new JButton("Reset ");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				textField.setText("");
				passwordField.setText("");
			}
		});
		
		passwordField = new JPasswordField();
		
		JLabel lblNeedAnAccount = new JLabel("Need an account !!");
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				StudentRegistration sr=new StudentRegistration();
				sr.setVisible(true);
				
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(48, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUsername)
								.addComponent(lblPassword)
								.addComponent(lblNeedAnAccount))
							.addGap(125))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(79)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
						.addComponent(passwordField, 156, 156, 156)
						.addComponent(btnSignUp)
						.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(49, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(192)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(228, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(54)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblUsername)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(55)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogin)
						.addComponent(btnReset))
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNeedAnAccount)
						.addComponent(btnSignUp))
					.addContainerGap(97, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
