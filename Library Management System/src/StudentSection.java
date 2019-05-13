import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class StudentSection extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentSection frame = new StudentSection();
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
	public StudentSection() {
		super("Student Section ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 717, 320);
		setLocationRelativeTo(this);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 4, 0, 0));
		
		JButton btnViewsearchBook = new JButton("View/Search Book");
		btnViewsearchBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				new SearchBy().setVisible(true);
			}
		});
		contentPane.add(btnViewsearchBook);
		
		JButton btnAddNotice = new JButton("View Notice");
		btnAddNotice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				SearchNotice sn=new SearchNotice();
				sn.setVisible(true);
			}
		});
		contentPane.add(btnAddNotice);
		
		JButton btnSearchupdatedeleteNotice = new JButton("View/Update Profile");
		btnSearchupdatedeleteNotice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				ViewProfile vp=new ViewProfile();
				vp.setVisible(true);
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
		contentPane.add(btnChangeSelfPassword);
		
		JButton btnNewLogin = new JButton("New Login");
		btnNewLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				LoginPage hp_l=new LoginPage();
				hp_l.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnNewLogin);
	}

}
