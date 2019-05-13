import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ReturnBook extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	JDateChooser dateChooser;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBook frame = new ReturnBook();
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
		dateChooser.setDate(null);
		
	}
	
	public long daysBetween(Date one , Date two)
	{
		long difference = (one.getTime() - two.getTime())/86400000;
		return Math.abs(difference);
	}
	
	/**
	 * Create the frame.
	 */
	public ReturnBook() throws ParseException	{
		setTitle("Return book");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 433);
		setLocationRelativeTo(this);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("RETURN_BOOK");
		
		JLabel lblBookid = new JLabel("Book Id");
		lblBookid.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblStudentid = new JLabel("Student Id ");
		lblStudentid.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		
		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblDateOfIssue = new JLabel("Date of Issue");
		lblDateOfIssue.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		
		JLabel lblLateFine = new JLabel("Late Fine");
		lblLateFine.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		
		dateChooser = new JDateChooser();
		dateChooser.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) 
			{
				long fine =0;
				long eday =0;
				String studid =textField.getText();
				String bookid =textField_2.getText(); 
				
				if( studid.length()==0 || bookid.length()==0  )      
				{
					JOptionPane.showMessageDialog(ReturnBook.this, "Please Fill/Select all the fields", "Error",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					String query= "select * from issue where id=? and bookid=?";
					int flag=0;
					try {
						PreparedStatement ps = DBInfo.con.prepareStatement(query);
						ps.setString(1, studid);
						ps.setString(2, bookid);
						ResultSet res=ps.executeQuery();
						while(res.next())
						{
							flag=1;
							String name = res.getString(3);
							String date = res.getString(4);
							textField_1.setText(name);
							textField_3.setText(date);
							
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							Date doi = sdf.parse(date);
							//System.out.println("date of issue : "+doi);
							
							Date dor = dateChooser.getDate();
							//System.out.println("date of return : "+dor);
							
							
							long days = daysBetween(doi , dor); 
							//System.out.println(days);
							if(dor.compareTo(doi)<0)
							{
								JOptionPane.showMessageDialog(getParent(), "Date of Return is before Date of Issue  !!", "Error", JOptionPane.ERROR_MESSAGE);	
								dateChooser.setDate(null);
								textField_1.setText(null);
								textField_3.setText(null);
								textField_4.setText(null);
							}

							if(days >15)
							{
								eday = days -15;
								fine = days *5 ;
							}
							textField_4.setText(String.valueOf(fine));
							
							break;
							
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					if(flag==0)
					{
						JOptionPane.showMessageDialog(getParent(), "Enter correct details !!", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		dateChooser.setDateFormatString("yyyy-MM-dd");
		
		JLabel lblReturnDate = new JLabel("Return date ");
		lblReturnDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				long fine =0;
				long eday =0;
				String studid =textField.getText();
				String bookid =textField_2.getText(); 
				
				if( studid.length()==0 || bookid.length()==0 || dateChooser.getDate() == null )      
				{
					JOptionPane.showMessageDialog(ReturnBook.this, "Please Fill/Select all the fields", "Error",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					String query= "select * from issue where id=? and bookid=?";
					int flag=0;
					try {
						PreparedStatement ps = DBInfo.con.prepareStatement(query);
						ps.setString(1, studid);
						ps.setString(2, bookid);
						ResultSet res=ps.executeQuery();
						while(res.next())
						{
							flag=1;
							String name = res.getString(3);
							String date = res.getString(4);
							textField_1.setText(name);
							textField_3.setText(date);
							
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							Date doi = sdf.parse(date);
							//System.out.println("date of issue : "+doi);
							
							Date dor = dateChooser.getDate();
							//System.out.println("date of return : "+dor);
							
							long days = daysBetween(doi , dor); 
							//System.out.println(days);
							
							if(dor.compareTo(doi)<0)
							{
								JOptionPane.showMessageDialog(getParent(), "Date of Return is before Date of Issue !!", "Error", JOptionPane.ERROR_MESSAGE);	
								dateChooser.setDate(null);
								textField_1.setText(null);
								textField_3.setText(null);
								textField_4.setText(null);
							}
							
							if(days >15)
							{
								eday = days -15;
								fine = days *5 ;
							}
							textField_4.setText(String.valueOf(fine));
							
							break;
							
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					if(flag==0)
					{
						JOptionPane.showMessageDialog(getParent(), "Enter correct details !!", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		JButton btnReturn = new JButton("Return ");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String studid =textField.getText();
				String bookid =textField_2.getText(); 
				String studname =textField_1.getText();
				String doi =textField_3.getText();
								
				if(studid.length() == 0 || bookid.length() == 0 || studname.length() == 0 || doi.length() == 0 || dateChooser.getDate() == null)
				{
					JOptionPane.showMessageDialog(getParent(), "Enter all the Fields!!", "Error", JOptionPane.ERROR_MESSAGE);

				}
				else
				{
					String query= "delete from issue where id=? and bookid=?";
					int flag=0;
					try 
					{
						PreparedStatement ps = DBInfo.con.prepareStatement(query);
						ps.setString(1, studid);
						ps.setString(2, bookid);
						flag=ps.executeUpdate();
						
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					if(flag!=0)
					{
						JOptionPane.showMessageDialog(getParent(), "Book Returned!!", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
						reset();
					}
					if(flag==0)
					{
						JOptionPane.showMessageDialog(getParent(), "Book Not Returned!!", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
					
					// for getting the quantity and update it
					int l=0;
					String left="";
					String query1= "select * from book where bookid=?";
					String query2="update book set quantity=? where bookid=?";
					try 
					{
						PreparedStatement ps1 = DBInfo.con.prepareStatement(query1);
						ps1.setString(1,bookid );
						ResultSet res=ps1.executeQuery();
						while(res.next())
							{
								String quantity = res.getString(10);
								l = Integer.parseInt(quantity) + 1;
								left = String.valueOf(l);
								break;
							}
						
						PreparedStatement ps2=DBInfo.con.prepareStatement(query2);
						ps2.setString(1,left);
						ps2.setString(2,bookid);
						ps2.executeUpdate();
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		JButton btnReset = new JButton("Reset ");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				dateChooser.setDate(null);
			}
		});
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(159)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(64)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblReturnDate)
								.addComponent(lblDateOfIssue)
								.addComponent(lblStudentid)
								.addComponent(lblStudentName)
								.addComponent(lblBookid)
								.addComponent(lblLateFine))
							.addGap(71)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
								.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
								.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
								.addComponent(textField_1, 181, 181, Short.MAX_VALUE)
								.addComponent(textField_3, 181, 181, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))))
					.addGap(74))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(76)
					.addComponent(btnSearch)
					.addGap(26)
					.addComponent(btnReturn)
					.addGap(27)
					.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(87, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(lblNewLabel)
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStudentid))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBookid)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStudentName)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDateOfIssue)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblReturnDate)
						.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(13)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLateFine)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSearch)
						.addComponent(btnReset)
						.addComponent(btnReturn))
					.addGap(36))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
