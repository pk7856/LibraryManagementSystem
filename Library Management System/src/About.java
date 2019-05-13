import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.Font;

public class About extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
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
	public About() {
		setTitle("About Developer !!");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 455, 329);
		setLocationRelativeTo(this);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblLibraryManagementSystem = new JLabel("Library Management System ");
		lblLibraryManagementSystem.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblVersion = new JLabel("Version - 1.0");
		lblVersion.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblCopyright = new JLabel("Copyright @2018");
		lblCopyright.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblDevelopedByPranav = new JLabel("Developed by Pranav Kumar");
		lblDevelopedByPranav.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblRollNo = new JLabel("Roll No. - BE/25088/16");
		lblRollNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblContact = new JLabel("Contact - 7979988421");
		lblContact.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel = new JLabel(" ");
		lblNewLabel.setIcon(new ImageIcon("F:\\Eclipse\\Library Management System\\me.jpg"));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(37)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblContact)
						.addComponent(lblCopyright)
						.addComponent(lblVersion)
						.addComponent(lblLibraryManagementSystem)
						.addComponent(lblDevelopedByPranav)
						.addComponent(lblRollNo))
					.addGap(58))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblLibraryManagementSystem, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblVersion)
							.addGap(18)
							.addComponent(lblDevelopedByPranav)
							.addGap(18)
							.addComponent(lblRollNo)
							.addGap(18)
							.addComponent(lblCopyright)
							.addGap(18)
							.addComponent(lblContact)))
					.addContainerGap(158, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
