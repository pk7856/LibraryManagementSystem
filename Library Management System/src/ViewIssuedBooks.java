import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTextField;

public class ViewIssuedBooks extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewIssuedBooks frame = new ViewIssuedBooks();
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
	public ViewIssuedBooks() 
	{
		setTitle("SearchBy ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 471, 299);
		setLocationRelativeTo(this);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("VIEW_ISSUED_BOOKS");
		
		JLabel lblSearchBy = new JLabel("Search By ");
		lblSearchBy.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		String values[]={"Select","BookId","UserId","All"};
		JComboBox comboBox = new JComboBox(values);
		
		JButton btnNewButton = new JButton("Search ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String value = (String)comboBox.getSelectedItem();
				if(value.equalsIgnoreCase("select"))
				{
					JOptionPane.showMessageDialog(getParent(), "Please select a value", "Error",JOptionPane.ERROR_MESSAGE);
				}
				if(value.equalsIgnoreCase("all"))
				{
					JFrame frm = new JFrame("All Issued Books");
					frm.setSize(900, 400);
					frm.setLocationRelativeTo(frm);
					frm.setDefaultCloseOperation(frm.DISPOSE_ON_CLOSE);
					DBInfo.getAllIssued();
					JTable t = new JTable(DBInfo.outer,DBInfo.header);
					JScrollPane pane = new JScrollPane(t);
					frm.getContentPane().add(pane);
					frm.setVisible(true);
					
				}
				else
				{
					//System.out.println("this is selected "+ value);
					if(value.equalsIgnoreCase("BookId"))
					{
						String id=JOptionPane.showInputDialog("Enter "+value);
						
						JFrame frm = new JFrame("Issued Books of BookId :"+id);
						frm.setSize(900, 400);
						frm.setLocationRelativeTo(frm);
						frm.setDefaultCloseOperation(frm.DISPOSE_ON_CLOSE);
						DBInfo.getbyid("bookid", id);
						JTable t = new JTable(DBInfo.outer,DBInfo.header);
						JScrollPane pane = new JScrollPane(t);
						frm.getContentPane().add(pane);
						frm.setVisible(true);
							
					}
					else if(value.equalsIgnoreCase("UserId"))
					{
						String id=JOptionPane.showInputDialog("Enter "+value);
						
						JFrame frm = new JFrame("Issued Books to UserId "+id);
						frm.setSize(900, 400);
						frm.setLocationRelativeTo(frm);
						frm.setDefaultCloseOperation(frm.DISPOSE_ON_CLOSE);
						DBInfo.getbyid("id", id);;
						JTable t = new JTable(DBInfo.outer,DBInfo.header);
						JScrollPane pane = new JScrollPane(t);
						frm.getContentPane().add(pane);
						frm.setVisible(true);
	
					}
					
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("Reset ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				comboBox.setSelectedIndex(0);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(71)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addGap(54)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblSearchBy)
							.addPreferredGap(ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
							.addGap(74))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(144)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(178, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(54)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSearchBy)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(61))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
