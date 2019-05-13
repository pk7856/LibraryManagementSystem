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
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComboBox;

public class SearchUpdateDeleteUser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblUsername;
	private JTextField textField_3;
	private JLabel lblPassword;
	private JLabel lblUsertype;
	private JButton btnSave;
	private JButton btnReset;
	private JPasswordField passwordField;
	private JTextField textField_4;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchUpdateDeleteUser frame = new SearchUpdateDeleteUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void reset()
	{
		textField_4.setText(null);
		textField.setText(null);
		textField_1.setText(null);
		textField_2.setText(null);
		textField_3.setText(null);
		passwordField.setText(null);
		textField_5.setText(null);
		
	}
	/**
	 * Create the frame.
	 */
	public SearchUpdateDeleteUser() {
		setTitle("Search/Update/Delete User");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 508, 459);
		setLocationRelativeTo(this);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("SEARCH_UPDATE_DELETE_USER");
		
		JLabel lblId = new JLabel("ID ");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_4 = new JTextField();
		textField_4.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) 
			{
				String username="";
				String id = textField_4.getText();
				if(id.length() == 0)
				{
					JOptionPane.showMessageDialog(getParent(), "UserId not Entered !!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					String query= "select * from registration where id=?";
					String query1= "select * from login where username=?";
					int flag=0;
					int flag1=0;
					try {
						PreparedStatement ps = DBInfo.con.prepareStatement(query);
						ps.setString(1, id);
						ResultSet res=ps.executeQuery();
						while(res.next())
						{
							flag=1;
							String name = res.getString(2);
							String mobile = res.getString(3);
							String email = res.getString(4);
							username = res.getString(5);
							textField.setText(name);
							textField_1.setText(mobile);
							textField_2.setText(email);
							textField_3.setText(username);
							break;
						}
						
						PreparedStatement ps1 = DBInfo.con.prepareStatement(query1);
						ps1.setString(1, username);
						ResultSet res1=ps1.executeQuery();
						while(res1.next())
						{
							flag1=1;
							String pass = res1.getString(2);
							String usertype = res1.getString(3);
							passwordField.setText(pass);
							textField_5.setText(usertype);
							break;
							
						}
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					if(flag==0 && flag1==0 && id.length()!=0)
					{
						JOptionPane.showMessageDialog(getParent(), "No Such User!!", "Error", JOptionPane.ERROR_MESSAGE);
					}	
				}
			}
		});
		textField_4.setColumns(10);
		
		JLabel lblName = new JLabel("Name ");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField = new JTextField();
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
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		
		lblPassword = new JLabel("Password ");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		lblUsertype = new JLabel("Usertype ");
		lblUsertype.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		passwordField = new JPasswordField();
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		btnSave = new JButton("Search ");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String username="";
				String id = textField_4.getText();
				
				if(id.length() == 0)
				{
					JOptionPane.showMessageDialog(getParent(), "UserId not Entered !!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					String query= "select * from registration where id=?";
					String query1= "select * from login where username=?";
					int flag=0;
					int flag1=0;
					try {
						PreparedStatement ps = DBInfo.con.prepareStatement(query);
						ps.setString(1, id);
						ResultSet res=ps.executeQuery();
						while(res.next())
						{
							flag=1;
							String name = res.getString(2);
							String mobile = res.getString(3);
							String email = res.getString(4);
							username = res.getString(5);
							textField.setText(name);
							textField_1.setText(mobile);
							textField_2.setText(email);
							textField_3.setText(username);
							break;
						}
						
						PreparedStatement ps1 = DBInfo.con.prepareStatement(query1);
						ps1.setString(1, username);
						ResultSet res1=ps1.executeQuery();
						while(res1.next())
						{
							flag1=1;
							String pass = res1.getString(2);
							String usertype = res1.getString(3);
							passwordField.setText(pass);
							textField_5.setText(usertype);
							break;
							
						}
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					if(flag==0 && flag1==0)
					{
						JOptionPane.showMessageDialog(getParent(), "No Such User!!", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}		
			}
		});
		
		btnReset = new JButton("Reset ");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				reset();
				
			}
		});
		
		btnUpdate = new JButton("Update ");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String id =textField_4.getText();
				String name =textField.getText();
				String mobile =textField_1.getText();
				String email =textField_2.getText();
				String username =textField_3.getText();
				String password =String.copyValueOf(passwordField.getPassword());
				String usertype =textField_5.getText();
				
				
				if( id.length()==0 || name.length()==0 || mobile.length()==0 || email.length()==0 || username.length()==0 || password.length()==0 || usertype.length()==0 )      
				{
					JOptionPane.showMessageDialog(getParent(), "Please Fill/Select all the fields", "Error",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
						
				// updating the credentials
				String query1="update registration set name=?,mobile=?,email=?  where id=?";
				String query2="update login set password=?,usertype=? where username=?";
				String query3="update issue set name=? where id=?";
				int flag=0;
				int flag1=0;
				int flag2=0;
				try {
					PreparedStatement ps=DBInfo.con.prepareStatement(query1);
					
					ps.setString(1,name);
					ps.setString(2,mobile);
					ps.setString(3,email);
					//ps.setString(4,username);
					ps.setString(4,id);
					flag=ps.executeUpdate();
					
					PreparedStatement ps1=DBInfo.con.prepareStatement(query2);
					ps1.setString(1,password);
					ps1.setString(2,usertype);
					ps1.setString(3,username);
					flag1=ps1.executeUpdate();
					
					//System.out.println("before"+flag2);
					PreparedStatement ps2=DBInfo.con.prepareStatement(query3);
					ps2.setString(1,name);
					ps2.setString(2,id);
					flag2=ps2.executeUpdate();
					//System.out.println("after"+flag2);

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
				if(flag==1 && flag1==1 )
				{
					JOptionPane.showMessageDialog(getParent(), "User Updated Successfully", "Message",JOptionPane.INFORMATION_MESSAGE);
					reset();
					
				}
				else
					JOptionPane.showMessageDialog(getParent(), "User Not Updated", "Error",JOptionPane.ERROR_MESSAGE);
			}
			
			}
		});
		
		btnDelete = new JButton("Delete ");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{

				String id=textField_4.getText();
				String username=textField_3.getText();
				
				if(id.length() == 0)
				{
					JOptionPane.showMessageDialog(getParent(), "Enter the User Id!!", "Error",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					String q= "select * from issue where id=?";
					try {
						PreparedStatement ps3 = DBInfo.con.prepareStatement(q);
						ps3.setString(1, id);
						ResultSet res=ps3.executeQuery();
						if(res.next())
						{
							JOptionPane.showMessageDialog(getParent(), "Cannot Delete User as book is issued to User !!", "Error", JOptionPane.ERROR_MESSAGE);
							reset();
						}
						else
							{
								
							String query="delete from registration where id=?";
							String query1="delete from login where username=?";
							int flag=0;
							int flag1=0;
							try 
							{
								PreparedStatement ps = DBInfo.con.prepareStatement(query);
								ps.setString(1,id);
								flag=ps.executeUpdate();
									
								PreparedStatement ps1 = DBInfo.con.prepareStatement(query1);
								ps1.setString(1,username);
								flag1=ps1.executeUpdate();
										
							} catch (Exception e) {
								e.printStackTrace();
							}
								
							if(flag!=0 && flag1!=0  )
								{
									JOptionPane.showMessageDialog(getParent(),"Record Deleated Successfully!!", "Message",JOptionPane.INFORMATION_MESSAGE);
									reset();
								}
							if(flag==0 && flag1==0)
								{
									JOptionPane.showMessageDialog(getParent(), "Record Not Deleated !!", "Error",JOptionPane.ERROR_MESSAGE);
								}
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(45, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblUsertype)
										.addComponent(lblName)
										.addComponent(lblMobile)
										.addComponent(lblEmail)
										.addComponent(lblUsername)
										.addComponent(lblPassword))
									.addGap(62))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addGap(37)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(textField_5, Alignment.LEADING)
										.addComponent(passwordField, Alignment.LEADING)
										.addComponent(textField_3, Alignment.LEADING)
										.addComponent(textField_2, Alignment.LEADING)
										.addComponent(textField_1, Alignment.LEADING)
										.addComponent(textField, Alignment.LEADING)
										.addComponent(textField_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
									.addGap(18)
									.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addGap(33)
									.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(176)
							.addComponent(lblNewLabel)))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSave))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMobile)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsertype)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(68)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnUpdate)
						.addComponent(btnReset)
						.addComponent(btnDelete))
					.addGap(62))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
