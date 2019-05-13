import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.control.ProgressBar;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class HomePage_Loading extends JFrame {

	private JPanel contentPane;
	JProgressBar progressBar;
	
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public HomePage_Loading() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 409, 385);
		setUndecorated(true);
		setLocationRelativeTo(this);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblsmartLibrary = new JLabel("#Smart Library 1.0");
		lblsmartLibrary.setForeground(Color.BLACK);
		lblsmartLibrary.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		progressBar = new JProgressBar();
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		
		JLabel lblPleaseWait = new JLabel("Loading...");
		lblPleaseWait.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("F:\\Eclispe_mars2\\Library Management System\\load.gif"));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(84)
							.addComponent(lblsmartLibrary, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(157)
							.addComponent(lblPleaseWait, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(51)
							.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(128)
							.addComponent(lblNewLabel)))
					.addContainerGap(110, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(46)
					.addComponent(lblsmartLibrary, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(71)
					.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(lblPleaseWait)
					.addGap(39)
					.addComponent(lblNewLabel)
					.addGap(31))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void update()
	{
		int i=0;
		for(i=0;i<=100;i=i+2)
		{
			progressBar.setValue(i);
			
			try {
				Thread.sleep(100);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			if(i==100)
			{
				LoginPage hp_l=new LoginPage();
				hp_l.setVisible(true);
				dispose();
			}
		}
		
	}
	
	public static void main(String[] args) {
		HomePage_Loading progressBar = new HomePage_Loading();
		progressBar.setVisible(true);
		progressBar.update();
		
	}
}
