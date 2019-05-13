import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SearchUpdateDelete extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JComboBox<String> comboBox,comboBox_1,comboBox_2,comboBox_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchUpdateDelete frame = new SearchUpdateDelete();
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
		comboBox.setSelectedIndex(0);
		comboBox_1.setSelectedIndex(0);
		comboBox_2.setSelectedIndex(0);
		comboBox_3.setSelectedIndex(0);
		
	}
	
	/**
	 * Create the frame.
	 */
	public SearchUpdateDelete() 
	{
		setTitle("Search/Update/Delete Book");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 553, 609);
		setLocationRelativeTo(this);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("SEARCH_UPDATE_DELETE BOOK");
		
		JLabel lblBookId = new JLabel("Book Id ");
		lblBookId.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		comboBox = new JComboBox(DBInfo.getAuthor());
		comboBox.insertItemAt("Select",0);
		comboBox.setSelectedIndex(0);
		
		JLabel lblPublisher = new JLabel("Publisher ");
		lblPublisher.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		comboBox_1 = new JComboBox(DBInfo.getPublisher());
		comboBox_1.insertItemAt("Select",0);
		comboBox_1.setSelectedIndex(0);
		
		JLabel lblCategory = new JLabel("Category ");
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		comboBox_2 = new JComboBox(DBInfo.getCategory());
		comboBox_2.insertItemAt("Select",0);
		comboBox_2.setSelectedIndex(0);
		
		JLabel lblSubject = new JLabel("Subject ");
		lblSubject.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		comboBox_3 = new JComboBox(DBInfo.getSubject());
		comboBox_3.insertItemAt("Select",0);
		comboBox_3.setSelectedIndex(0);
		
		JLabel lblTitlename = new JLabel("Title/Name ");
		lblTitlename.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblAuthor = new JLabel("Author ");
		lblAuthor.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblIsbnNo = new JLabel("ISBN No. ");
		lblIsbnNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblEdition = new JLabel("Edition ");
		lblEdition.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price ");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity ");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
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
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) 
			{
				String id = textField.getText();
				if(id.length()!= 0)
				{
					String query= "select * from book where bookid=?";
					int flag=0;
					try {
						PreparedStatement ps = DBInfo.con.prepareStatement(query);
						ps.setString(1, id);
						ResultSet res=ps.executeQuery();
						while(res.next())
						{
							flag=1;
							String title = res.getString(2);
							String author = res.getString(3);
							String pub = res.getString(4);
							String cat = res.getString(5);
							String sub = res.getString(6);
							String isbn = res.getString(7);
							String edition = res.getString(8);
							String price = res.getString(9);
							String quantity = res.getString(10);
							
							//System.out.println(author);
							//System.out.println(pub);
							//System.out.println(cat);
							//System.out.println(sub);
							
							textField_1.setText(title);
							comboBox.setSelectedItem(author);
							comboBox_1.setSelectedItem(pub);
							comboBox_2.setSelectedItem(cat);
							comboBox_3.setSelectedItem(sub);
							textField_2.setText(isbn);
							textField_3.setText(edition);
							textField_4.setText(price);
							textField_5.setText(quantity);
							break;
							
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					if(flag==0)
					{
						JOptionPane.showMessageDialog(getParent(), "No Book Found !!", "Error", JOptionPane.ERROR_MESSAGE);
						textField.setText(null);
					}
				}
				if(id.length()==0)
				{
					JOptionPane.showMessageDialog(getParent(), "BookID not Entered !!", "Error", JOptionPane.ERROR_MESSAGE);
				}
		}
		});
		
		textField.setColumns(10);
	
		JButton btnSave = new JButton("RESET ");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
				reset();
			}
		});
		
		JButton btnSave_1 = new JButton("SEARCH ");
		btnSave_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String id = textField.getText();
				if(id.length()!= 0)
				{
					String query= "select * from book where bookid=?";
					int flag=0;
					try {
						PreparedStatement ps = DBInfo.con.prepareStatement(query);
						ps.setString(1, id);
						ResultSet res=ps.executeQuery();
						while(res.next())
						{
							flag=1;
							String title = res.getString(2);
							String author = res.getString(3);
							String pub = res.getString(4);
							String cat = res.getString(5);
							String sub = res.getString(6);
							String isbn = res.getString(7);
							String edition = res.getString(8);
							String price = res.getString(9);
							String quantity = res.getString(10);
							
							//System.out.println(author);
							//System.out.println(pub);
							//System.out.println(cat);
							//System.out.println(sub);
							
							textField_1.setText(title);
							comboBox.setSelectedItem(author);
							comboBox_1.setSelectedItem(pub);
							comboBox_2.setSelectedItem(cat);
							comboBox_3.setSelectedItem(sub);
							textField_2.setText(isbn);
							textField_3.setText(edition);
							textField_4.setText(price);
							textField_5.setText(quantity);
							break;
							
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					if(flag==0)
					{
						JOptionPane.showMessageDialog(getParent(), "No Book Found !!", "Error", JOptionPane.ERROR_MESSAGE);
						textField.setText(null);
					}
				}
				if(id.length()==0)
				{
					JOptionPane.showMessageDialog(getParent(), "BookID not Entered !!", "Error", JOptionPane.ERROR_MESSAGE);
				}
		}
		});
		
		JButton button = new JButton("UPDATE ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String id=textField.getText();
				String title=textField_1.getText();
				String author=(String)comboBox.getSelectedItem();
				String pub=(String)comboBox_1.getSelectedItem();
				String cat=(String)comboBox_2.getSelectedItem();
				String sub=(String)comboBox_3.getSelectedItem();
				String isbn=textField_2.getText();
				String edition=textField_3.getText();
				String price=textField_4.getText();
				String quantity=textField_5.getText();
				
				if( id.length()==0 || title.length()==0 || author.equalsIgnoreCase("select") || pub.equalsIgnoreCase("select") || cat.equalsIgnoreCase("select") || sub.equalsIgnoreCase("select") || isbn.length()==0 || edition.length()==0 || price.length()==0 || quantity.length()==0 )      
				{
					JOptionPane.showMessageDialog(getParent(), "Please Fill/Select all the fields", "Error",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
				String query="update book set title=?,author=?,publisher=?,category=?,subject=?,isbn=?,edition=?,price=?,quantity=? where bookid=?";
				int flag=0;
				Connection con = DBInfo.con;
				try {
					PreparedStatement ps=con.prepareStatement(query);
					
					ps.setString(1,title);
					ps.setString(2,author);
					ps.setString(3,pub);
					ps.setString(4,cat);
					ps.setString(5,sub);
					ps.setString(6,isbn);
					ps.setString(7,edition);
					ps.setString(8,price);
					ps.setString(9,quantity);
					ps.setString(10,id);
					flag=ps.executeUpdate();

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				if(flag==1)
				{
					JOptionPane.showMessageDialog(getParent(), "Book Updated Successfully", "Message",JOptionPane.INFORMATION_MESSAGE);
					reset();
					
				}
				else
					JOptionPane.showMessageDialog(getParent(), "Book Not Updated", "Error",JOptionPane.ERROR_MESSAGE);
			}
				
		}	
		});
		
		JButton button_1 = new JButton("DELETE ");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String id=textField.getText();
				
				if(id.length() == 0)
				{
					JOptionPane.showMessageDialog(getParent(), "Cannot Delete Book ,Insert all the records !!", "Error", JOptionPane.ERROR_MESSAGE);

				}
				else
				{
				String q= "select * from issue where bookid=?";
				try {
					PreparedStatement ps1 = DBInfo.con.prepareStatement(q);
					ps1.setString(1, id);
					ResultSet res=ps1.executeQuery();
					if(res.next())
					{
						JOptionPane.showMessageDialog(getParent(), "Cannot Delete Book as book is issued to User !!", "Error", JOptionPane.ERROR_MESSAGE);
						reset();
					}
					else
					{
						String query="delete from book where bookid=?";
						int flag=0;
						try 
						{
							PreparedStatement ps = DBInfo.con.prepareStatement(query);
							ps.setString(1,id);
							flag=ps.executeUpdate();
								
						} catch (Exception e) {
							e.printStackTrace();
						}
							
							if(flag!=0)
							{
								JOptionPane.showMessageDialog(getParent(), "Record Deleated !!");
								reset();
							}
							if(flag==0)
							{
								JOptionPane.showMessageDialog(getParent(), "Record Not Deleated !!");
							}
							
					}
					}catch (Exception e1) {
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
							.addGap(83)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblBookId, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTitlename, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblPublisher, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblAuthor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(82)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCategory, GroupLayout.PREFERRED_SIZE, 89, Short.MAX_VALUE)
								.addComponent(lblSubject, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblIsbnNo, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
								.addComponent(lblEdition, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
								.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblQuantity, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(73)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
								.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
								.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
								.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
								.addComponent(comboBox_3, 0, 231, Short.MAX_VALUE)
								.addComponent(comboBox_2, 0, 231, Short.MAX_VALUE)
								.addComponent(comboBox_1, 0, 231, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
								.addComponent(comboBox, 0, 231, Short.MAX_VALUE)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addComponent(btnSave_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
					.addGap(62))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(169)
					.addComponent(lblNewLabel)
					.addContainerGap(216, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(48)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBookId)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTitlename)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAuthor))
					.addGap(17)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPublisher)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCategory))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSubject))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIsbnNo))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEdition))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPrice))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblQuantity))
					.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnSave_1)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(54))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
