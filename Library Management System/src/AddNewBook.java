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
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddNewBook extends JFrame {

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
					AddNewBook frame = new AddNewBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public void reset()
	{
		textField.setText(getBookId());
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
	
	public String getBookId()
	{

		String id = "";
		for(int i=1;i<=6;i++)
		{
			id+=(int)(Math.random()*9) +1;
			//System.out.println(id);
		}
		return id;
	}
	
	/**
	 * Create the frame.
	 */
	public AddNewBook() {
		setTitle("Add New Book ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 553, 600);
		setLocationRelativeTo(this);
		setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File ");
		menuBar.add(mnFile);
		
		JMenu mnAddNew = new JMenu("Add New ");
		menuBar.add(mnAddNew);
		
		JMenuItem mntmAuthor = new JMenuItem("Author");
		mntmAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String s1 = arg0.getActionCommand();
				String  str=JOptionPane.showInputDialog(AddNewBook.this, "Enter "+s1+" Name", s1+" Input ", JOptionPane.QUESTION_MESSAGE);
				//System.out.println(s1+"::"+str);
				 
				if(str==null)
				{
					JOptionPane.showMessageDialog(getParent(), s1+" Not Added", s1+" Not Added !! ",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
				int i = DBInfo.insertValue(s1, str);
				if(i==1)
					JOptionPane.showMessageDialog(AddNewBook.this, "Author Added", s1+" Added !! ",JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(AddNewBook.this, "Author Not Added", s1+" Not Added !! ",JOptionPane.ERROR_MESSAGE);
				
				dispose();
				new AddNewBook().setVisible(true);
				} 
			}
		});
		mnAddNew.add(mntmAuthor);
		
		JMenuItem mntmPublisher = new JMenuItem("Publisher ");
		mntmPublisher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String s1 = arg0.getActionCommand();
				String  str=JOptionPane.showInputDialog(AddNewBook.this, "Enter "+s1+" Name", s1+" Input ", JOptionPane.QUESTION_MESSAGE);
				//System.out.println(s1+"::"+str);
				
				if(str==null)
				{
					JOptionPane.showMessageDialog(getParent(), s1+" Not Added", s1+" Not Added !! ",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
				int i = DBInfo.insertValue(s1, str);
				if(i==1)
					JOptionPane.showMessageDialog(AddNewBook.this, "Publisher Added", s1+" Added !! ",JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(AddNewBook.this, "Publisher Not Added", s1+" Not Added !! ",JOptionPane.ERROR_MESSAGE);
				
				dispose();
				new AddNewBook().setVisible(true);
				}
			}
		});
		mnAddNew.add(mntmPublisher);
		
		JMenuItem mntmCategory = new JMenuItem("Category ");
		mntmCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String s1 = e.getActionCommand();
				String  str=JOptionPane.showInputDialog(AddNewBook.this, "Enter "+s1+" Name", s1+" Input ", JOptionPane.QUESTION_MESSAGE);
				//System.out.println(s1+"::"+str);
				
				if(str==null)
				{
					JOptionPane.showMessageDialog(getParent(), s1+" Not Added", s1+" Not Added !! ",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
				int i = DBInfo.insertValue(s1, str);
				if(i==1)
					JOptionPane.showMessageDialog(AddNewBook.this, "Category Added", s1+" Added !! ",JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(AddNewBook.this, "Category Not Added", s1+" Not Added !! ",JOptionPane.ERROR_MESSAGE);
				
				dispose();
				new AddNewBook().setVisible(true);
				}
			}
		});
		mnAddNew.add(mntmCategory);
		
		JMenuItem mntmSubject = new JMenuItem("Subject ");
		mntmSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String s1 = e.getActionCommand();
				String  str=JOptionPane.showInputDialog(AddNewBook.this, "Enter "+s1+" Name", s1+" Input ", JOptionPane.QUESTION_MESSAGE);
				//System.out.println(s1+"::"+str);
				
				if(str==null)
				{
					JOptionPane.showMessageDialog(getParent(), s1+" Not Added", s1+" Not Added !! ",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
				int i = DBInfo.insertValue(s1, str);
				if(i==1)
					JOptionPane.showMessageDialog(AddNewBook.this, "Subject Added", s1+" Added !! ",JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(AddNewBook.this, "Subject Not Added", s1+" Not Added !! ",JOptionPane.ERROR_MESSAGE);

				dispose();
				new AddNewBook().setVisible(true);
				}
			}
		});
		mnAddNew.add(mntmSubject);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("ADD_NEW_BOOK");
		
		JLabel lblBookId = new JLabel("Book Id ");
		lblBookId.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		textField = new JTextField(getBookId());
		textField.setEditable(false);
		textField.setColumns(10);
		
		JLabel lblTitlename = new JLabel("Title/Name ");
		lblTitlename.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblAuthor = new JLabel("Author ");
		lblAuthor.setFont(new Font("Tahoma", Font.BOLD, 12));
		
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
		
		JLabel lblIsbnNo = new JLabel("ISBN No. ");
		lblIsbnNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
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
		textField_2.setColumns(10);
		
		JLabel lblEdition = new JLabel("Edition ");
		lblEdition.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
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
		textField_3.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price ");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_4 = new JTextField();
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
		textField_4.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity ");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() {
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
		textField_5.setColumns(10);
		
		JButton btnSave = new JButton("RESET ");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				reset();
			}
		});
		
		JButton btnSave_1 = new JButton("SAVE ");
		btnSave_1.addActionListener(new ActionListener() {
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
					JOptionPane.showMessageDialog(AddNewBook.this, "Please Fill/Select all the fields", "Error",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
				String query="insert into book values(?,?,?,?,?,?,?,?,?,?)";
				int flag=0;
				Connection con = DBInfo.con;
				try {
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1,id);
					ps.setString(2,title);
					ps.setString(3,author);
					ps.setString(4,pub);
					ps.setString(5,cat);
					ps.setString(6,sub);
					ps.setString(7,isbn);
					ps.setString(8,edition);
					ps.setString(9,price);
					ps.setString(10,quantity);
					flag=ps.executeUpdate();

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				if(flag==1)
				{
					JOptionPane.showMessageDialog(AddNewBook.this, "Book Added Successfully", "Message",JOptionPane.INFORMATION_MESSAGE);
					reset();
					
				}
				else
					JOptionPane.showMessageDialog(AddNewBook.this, "Book Not Added", "Error",JOptionPane.ERROR_MESSAGE);

				
				dispose();
				new AddNewBook().setVisible(true);
			}
		}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(227)
							.addComponent(lblNewLabel))
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
										.addComponent(lblQuantity, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))))
							.addGap(73)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
								.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
								.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
								.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
								.addComponent(comboBox_3, 0, 177, Short.MAX_VALUE)
								.addComponent(comboBox_2, 0, 177, Short.MAX_VALUE)
								.addComponent(comboBox_1, 0, 177, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(textField_1)
									.addComponent(textField, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)))))
					.addGap(131))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(130)
					.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addGap(57)
					.addComponent(btnSave_1, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(183, Short.MAX_VALUE))
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
					.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnSave_1))
					.addGap(25))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
