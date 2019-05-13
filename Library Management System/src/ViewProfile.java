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
import com.toedter.calendar.JDayChooser;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ViewProfile extends JFrame {

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
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewProfile frame = new ViewProfile();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void reset()
	{
		textField.setText(null);
		textField_1.setText(null);
		textField_2.setText(null);
		textField_3.setText(null);
		textField_4.setText(null);
		textField_5.setText(null);
		passwordField.setText(null);
		
	}
	/**
	 * Create the frame.
	 */
	public ViewProfile() {
		setTitle("View/Update Profile !!");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 437, 443);
		setLocationRelativeTo(this);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("VIEW_UPDATE_PROFILE");
		
		JLabel lblId = new JLabel("ID ");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_4 = new JTextField();
		textField_4.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) 
			{

				String id = textField_4.getText();
				String username="";
		
				
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
		textField.setEditable(false);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e)
			{
				char x=e.getKeyChar();
				if((x < 'A' || x > 'Z') && (x < 'a' || x > 'z') && x != ' ')
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
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		
		lblPassword = new JLabel("Password ");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		lblUsertype = new JLabel("Usertype ");
		lblUsertype.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		passwordField = new JPasswordField();
		passwordField.setEditable(false);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		
		btnSave = new JButton("Update ");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String id = textField_4.getText();
				
				String mobile=textField_1.getText();
				String email=textField_2.getText();
				
				
				if(id.length()==0 || mobile.length()==0 || email.length()==0 )
				{
				JOptionPane.showMessageDialog(getParent(), "Enter required Fields !!", "Error",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					String query="update registration set mobile=?,email=?  where id=?";
					
					int flag=0;
					try {
						PreparedStatement ps=DBInfo.con.prepareStatement(query);
						
						ps.setString(1,mobile);
						ps.setString(2,email);
						ps.setString(3,id);
						flag=ps.executeUpdate();

					} catch (Exception e1) {
						// TODO: handle exception
						e1.printStackTrace();
					}
					
					if(flag==1 )
					{
						JOptionPane.showMessageDialog(getParent(), "User Updated Successfully", "Message",JOptionPane.INFORMATION_MESSAGE);
						reset();
						
					}
					else
						JOptionPane.showMessageDialog(getParent(), "User Not Updated", "Error",JOptionPane.ERROR_MESSAGE);
					
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
		
		JButton btnSearch = new JButton("Search ");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String id = textField_4.getText();
				String username="";
		
				
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
		
		
	
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(31)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblPassword)
										.addComponent(lblUsertype)
										.addComponent(lblUsername)
										.addComponent(lblEmail)
										.addComponent(lblMobile)
										.addComponent(lblName)
										.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(54)
									.addComponent(btnSearch)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(27)
									.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(48)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(textField, Alignment.LEADING)
										.addComponent(textField_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
										.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
										.addComponent(textField_2, Alignment.LEADING, 166, 166, Short.MAX_VALUE)
										.addComponent(textField_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
										.addComponent(passwordField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
										.addComponent(textField_5, Alignment.LEADING)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(134)
							.addComponent(lblNewLabel)))
					.addContainerGap(84, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsertype)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(61)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSearch)
						.addComponent(btnSave)
						.addComponent(btnReset))
					.addContainerGap(66, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
