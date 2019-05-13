import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class IssueBook extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	JDateChooser dateChooser ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IssueBook frame = new IssueBook();
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
		dateChooser.setDate(null);
		
	}
	/**
	 * Create the frame.
	 */
	public IssueBook() {
		setTitle("Issue Book");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 478, 421);
		setLocationRelativeTo(this);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("ISSUE_BOOK");
		
		JLabel lblNewLabel_1 = new JLabel("Book Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd-MM-yyyy");
		
		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) 
			{

				String bookid =textField.getText();
				
				if(bookid.length() == 0)
				{
					
				}
				else
				{
					String query= "select * from book where bookid=?";
					int flag=0;
					try {
						PreparedStatement ps = DBInfo.con.prepareStatement(query);
						
						ps.setString(1,bookid );
						ResultSet res=ps.executeQuery();
						while(res.next())
							{
								flag=1;
								String quantity = res.getString(10);
								textField_3.setText(quantity);
								break;
							}
					}catch (Exception e) {
					e.printStackTrace();
					}
					if(flag==0)
					{
						JOptionPane.showMessageDialog(getParent(), "No Book Found !!", "Error", JOptionPane.ERROR_MESSAGE);
						textField.setText(null);
					}
				}
			}
		});
		textField.setColumns(10);
		
		JLabel lblStudentId = new JLabel("Student Id");
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblDateOfIssue = new JLabel("Date Of Issue");
		lblDateOfIssue.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_1 = new JTextField();
		textField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) 
			{

				String id =textField_1.getText();
				
				if(id.length() == 0)
				{
					JOptionPane.showMessageDialog(getParent(), "Please enter the Student Id !!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					String query= "select * from registration where id=?";
					int flag=0;
					try {
						PreparedStatement ps = DBInfo.con.prepareStatement(query);
						
						ps.setString(1,id );
						ResultSet res=ps.executeQuery();
						while(res.next())
							{
								flag=1;
								String name = res.getString(2);
								textField_2.setText(name);
								break;
							}
					}catch (Exception e) {
					e.printStackTrace();
					}
					if(flag==0)
					{
						JOptionPane.showMessageDialog(getParent(), "No such user registered !!", "Error", JOptionPane.ERROR_MESSAGE);
						textField.setText(null);
					}
				}	
			}
		});
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
		

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		
		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String id =textField_1.getText();
				
				if(id.length() == 0)
					JOptionPane.showMessageDialog(getParent(), "Please enter the id !!", "Error", JOptionPane.ERROR_MESSAGE);
				else
				{
					String query= "select * from registration where id=?";
					int flag=0;
					try {
						PreparedStatement ps = DBInfo.con.prepareStatement(query);
						
						ps.setString(1,id );
						ResultSet res=ps.executeQuery();
						while(res.next())
							{
								flag=1;
								String name = res.getString(2);
								textField_2.setText(name);
								break;
							}
					}catch (Exception e) {
					e.printStackTrace();
					}
					if(flag==0)
					{
						JOptionPane.showMessageDialog(getParent(), "No such user registered !!", "Error", JOptionPane.ERROR_MESSAGE);
						textField.setText(null);
					}
				}
			}
		});
		
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String bookid =textField.getText();
				
				String query= "select * from book where bookid=?";
				int flag=0;
				try {
					PreparedStatement ps = DBInfo.con.prepareStatement(query);
					
					ps.setString(1,bookid );
					ResultSet res=ps.executeQuery();
					while(res.next())
						{
							flag=1;
							String quantity = res.getString(10);
							textField_3.setText(quantity);
							break;
						}
				}catch (Exception e) {
				e.printStackTrace();
				}
				if(flag==0)
				{
					JOptionPane.showMessageDialog(getParent(), "No Book Found !!", "Error", JOptionPane.ERROR_MESSAGE);
					textField.setText(null);
				}
			}
		});
	
		JButton btnIssue = new JButton("Issue ");
		btnIssue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				ResultSet res1;
				int l=0;
				String left="";
				String bookid =textField.getText();
				String studid =textField_1.getText();
				String studname =textField_2.getText();
				
				
				if( bookid.length()== 0 || studid.length() == 0 || studname.length() == 0 || textField_3.getText().length()==0 || dateChooser.getDate() == null)      
				{
					JOptionPane.showMessageDialog(getParent(), "Please Fill all the fields", "Error",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					SimpleDateFormat sdf = new SimpleDateFormat();
					String doi = sdf.format(dateChooser.getDate());
					Date d = dateChooser.getDate();
					java.sql.Date c = new  java.sql.Date(d.getTime());
					//System.out.println(c);
					
				String query= "select * from book where bookid=?";
				int flag=0;
				int flag1=0;
				try {
					PreparedStatement ps = DBInfo.con.prepareStatement(query);
					ps.setString(1,bookid );
					ResultSet res=ps.executeQuery();
					while(res.next())
						{
							flag1=1;
							String quantity = res.getString(10);
							l = Integer.parseInt(quantity) - 1;
							left = String.valueOf(l);
							break;
						}
					
					//if book present in issue table then ...
					String query3="select * from issue where bookid=?";
					PreparedStatement ps3 = DBInfo.con.prepareStatement(query3);
					ps3.setString(1,bookid );
					res1=ps3.executeQuery();
					if(res1.next())
					{ 
						
						do
						{
							String bid = res1.getString(1);
							String id = res1.getString(2);
							//System.out.println(bid);
							//System.out.println(id);
								
							//checks if the book is present matches with any of present userid or not
							 if(bid.equalsIgnoreCase(bookid) && (Integer.parseInt(id) == Integer.parseInt(studid) )  )
							 {
								 //System.out.println("user matched hurrey");
								 flag=1; 
								JOptionPane.showMessageDialog(getParent(), "Book already issued to user!!", "Error", JOptionPane.ERROR_MESSAGE);
								reset();
								
							 }
							}
							 while(res1.next());
				
							if(flag ==0 )
							{	
								if(l >= 0)
									{
										String query1="update book set quantity=? where bookid=?";
										PreparedStatement ps1=DBInfo.con.prepareStatement(query1);
										ps1.setString(1,left);
										ps1.setString(2,bookid);
										flag=ps1.executeUpdate();
											
										String query2="insert into issue values(?,?,?,?)";
										PreparedStatement ps2=DBInfo.con.prepareStatement(query2);
										ps2.setString(1,bookid);
										ps2.setString(2,studid);
										ps2.setString(3,studname);
										ps2.setDate(4, c);
										ps2.executeUpdate();
											
										JOptionPane.showMessageDialog(getParent(), "Book Issued!!", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
										reset();
										dispose();
										new IssueBook().setVisible(true);
									
									}
								else
								{
									JOptionPane.showMessageDialog(getParent(), "Book not left in library!!", "Error", JOptionPane.ERROR_MESSAGE);
								}
							}	
						}
					
					
					
					//line 2 if book not present in issue table ...
					else 
					{
						//System.out.println("book not present in issue "+res1.next());
						flag=1;
						if(l >= 0)
						{	
							String query1="update book set quantity=? where bookid=?";
							PreparedStatement ps1=DBInfo.con.prepareStatement(query1);
							ps1.setString(1,left);
							ps1.setString(2,bookid);
							flag=ps1.executeUpdate();
							
							String query2="insert into issue values(?,?,?,?)";
							PreparedStatement ps2=DBInfo.con.prepareStatement(query2);
							ps2.setString(1,bookid);
							ps2.setString(2,studid);
							ps2.setString(3,studname);
							ps2.setDate(4, c);
							ps2.executeUpdate();
							
							JOptionPane.showMessageDialog(getParent(), "Book Issued!!", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
							reset();
							dispose();
							new IssueBook().setVisible(true);
						}
						else
						{
							JOptionPane.showMessageDialog(getParent(), "Book not left in library!!", "Error", JOptionPane.ERROR_MESSAGE);
						}

					}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				
					if(flag1==0)
					{
						JOptionPane.showMessageDialog(getParent(), "No Book Found !!", "Error", JOptionPane.ERROR_MESSAGE);
						reset();
					}
				}
				}
			});
		btnIssue.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnReset = new JButton("Reset ");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				reset();
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblQLeft = new JLabel("Quantity Left");
		lblQLeft.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(95)
					.addComponent(btnIssue)
					.addGap(41)
					.addComponent(btnReset)
					.addContainerGap(165, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(53)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(lblDateOfIssue)
						.addComponent(lblStudentId)
						.addComponent(lblStudentName)
						.addComponent(lblQLeft))
					.addGap(48)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel)
								.addComponent(textField)
								.addComponent(textField_1, 177, 177, Short.MAX_VALUE)
								.addComponent(textField_2))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
							.addGap(4)
							.addComponent(btnSearch))
						.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(49)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_1))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStudentId))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStudentName)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDateOfIssue)
						.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblQLeft)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnSearch)))
					.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIssue)
						.addComponent(btnReset))
					.addGap(35))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
