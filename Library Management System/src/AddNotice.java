import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Date;
import java.awt.event.ActionEvent;

public class AddNotice extends JFrame {

	private JPanel contentPane;
	JDateChooser dateChooser;
	JTextArea txtrA;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNotice frame = new AddNotice();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void reset()
	{
		dateChooser.setDate(null);
		txtrA.setText(null);
	}

	/**
	 * Create the frame.
	 */
	public AddNotice() {
		setTitle("Add Notice ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 410, 449);
		setLocationRelativeTo(this);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("ADD_NOTICE");
		
		JLabel lblDate = new JLabel("Date ");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblMessage = new JLabel("Message ");
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtrA = new JTextArea(10,20);
		scrollPane.setViewportView(txtrA);
		txtrA.setText("");
	
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd-MM-yyyy");
		
		JButton btnReset = new JButton("Reset ");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				reset();
			}
		});
		
		JButton btnButton = new JButton("Submit ");
		btnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String str =txtrA.getText();
				if(str.length() == 0 || dateChooser.getDate()==null )
					JOptionPane.showMessageDialog(getParent(), "Enter the Details!! ", "Error", JOptionPane.ERROR_MESSAGE);
			
				else
				{
					Date d = dateChooser.getDate();
					java.sql.Date date = new  java.sql.Date(d.getTime());
					int i=0;
					String query = "Insert Into notice Values(?,?,?)";
					try{
						PreparedStatement ps = DBInfo.con.prepareStatement(query);
						ps.setInt(1, 0);
						ps.setDate(2, date);
						ps.setString(3, str);
					    i = ps.executeUpdate();
						
					    JOptionPane.showMessageDialog(getParent(), "Notice Added ", "Message", JOptionPane.INFORMATION_MESSAGE);
					    reset();
					}catch(Exception e)
						{
							e.printStackTrace();
						}
					if(i==0)
					{
						JOptionPane.showMessageDialog(getParent(), "Notice Not Added !!", "Error", JOptionPane.ERROR_MESSAGE);
						reset();
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
							.addGap(41)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMessage)
								.addComponent(lblDate))
							.addGap(47)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(82)
							.addComponent(btnReset)
							.addGap(52)
							.addComponent(btnButton)))
					.addContainerGap(78, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(69)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDate, Alignment.TRAILING)
						.addComponent(dateChooser, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(48)
							.addComponent(lblMessage)))
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnButton)
						.addComponent(btnReset))
					.addGap(43))
		);
		
		contentPane.setLayout(gl_contentPane);
	}
}
