import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class AdminSection extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSection frame = new AdminSection();
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
	public AdminSection(){
		super("AdminSection");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 894, 440);
		setLocationRelativeTo(this);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 4, 0, 0));
		
		JButton btnAddNewBook = new JButton("Add New Book");
		btnAddNewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				AddNewBook obj = new AddNewBook();
				obj.setVisible(true);
			}
		});
		contentPane.add(btnAddNewBook);
		
		JButton btnSearchdeleteupdateBook = new JButton("Search/Update/Delete Book by id");
		btnSearchdeleteupdateBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				SearchUpdateDelete obj = new SearchUpdateDelete();
				obj.setVisible(true);
			}
		});
		contentPane.add(btnSearchdeleteupdateBook);
		
		JButton btnViewsearchBook = new JButton("View/Search Book");
		btnViewsearchBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				new SearchBy().setVisible(true);
			}
		});
		contentPane.add(btnViewsearchBook);
		
		JButton btnIssuesubmitBook = new JButton("Issue Book");
		btnIssuesubmitBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				IssueBook Ib=new IssueBook();
				Ib.setVisible(true);
			}
		});
		contentPane.add(btnIssuesubmitBook);
		
		JButton btnAddNewUser = new JButton("Add New User");
		btnAddNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				StudentRegistration sr=new StudentRegistration();
				sr.setVisible(true);

			}
		});
		
		JButton btnNewButton = new JButton("Return Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				ReturnBook rb;
				try {
					rb = new ReturnBook();
					rb.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnViewIssuedBooks = new JButton("View Issued Books");
		btnViewIssuedBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				ViewIssuedBooks vib=new ViewIssuedBooks();
				vib.setVisible(true);
			}
		});
		contentPane.add(btnViewIssuedBooks);
		contentPane.add(btnAddNewUser);
		
		JButton btnSearchupdatedeleteUser = new JButton("Search/Update/Delete User");
		btnSearchupdatedeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				SearchUpdateDeleteUser sud=new SearchUpdateDeleteUser();
				sud.setVisible(true);
			}
		});
		contentPane.add(btnSearchupdatedeleteUser);
		
		JButton btnAddNotice = new JButton("Add Notice");
		btnAddNotice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				AddNotice anoc=new AddNotice();
				anoc.setVisible(true);
			}
		});
		
		JButton btnViewAllUsers = new JButton("View All Users");
		btnViewAllUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JFrame frm = new JFrame("Rsgistered Users");
				frm.setSize(900, 400);
				frm.setLocationRelativeTo(frm);
				frm.setDefaultCloseOperation(frm.DISPOSE_ON_CLOSE);
				DBInfo.getAllUser();
				JTable t = new JTable(DBInfo.outer,DBInfo.header);
				JScrollPane pane = new JScrollPane(t);
				frm.getContentPane().add(pane);
				frm.setVisible(true);
				
			}
		});
		
		contentPane.add(btnViewAllUsers);
		contentPane.add(btnAddNotice);
		
		JButton btnSearchupdatedeleteNotice = new JButton("Search/Update/Delete Notice");
		btnSearchupdatedeleteNotice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				SearchUpDelNotice sudn=new SearchUpDelNotice();
				sudn.setVisible(true);
			}
		});
		contentPane.add(btnSearchupdatedeleteNotice);
		
		JButton btnChangeSelfPassword = new JButton("Change Self Password");
		btnChangeSelfPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Updatepass up=new Updatepass();
				up.setVisible(true);
			}
		});
		
		JButton btnSendEmail = new JButton("Send Email");
		btnSendEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SendEmail se = new SendEmail();
				se.setVisible(true);
			}
		});
		contentPane.add(btnSendEmail);
		contentPane.add(btnChangeSelfPassword);
		JButton btnNewButton_2 = new JButton("New Login");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				LoginPage hp_l=new LoginPage();
				hp_l.setVisible(true);
				dispose();
			}
		});
		
		JButton btnNewButton_1 = new JButton("About ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				About ab=new About();
				ab.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_1);
		contentPane.add(btnNewButton_2);
	}

}
