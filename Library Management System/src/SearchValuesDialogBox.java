import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchValuesDialogBox extends JDialog {

	private final JPanel contentPanel = new JPanel();

	
	/**
	 * Create the dialog.
	 */
	Vector<String> vector;
	public SearchValuesDialogBox(String values) 
	{
		setTitle("Select "+values);
		setBounds(100, 100, 450, 241);
		setLocationRelativeTo(this);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblSelect = new JLabel("Select ");
		lblSelect.setFont(new Font("Tahoma", Font.BOLD, 12));
		 if(values.equalsIgnoreCase("author"))
		 {
			 vector=DBInfo.getAuthor();
		 }
		 else if(values.equalsIgnoreCase("publisher"))
		 {
			 vector=DBInfo.getPublisher();
		 }
		 else if(values.equalsIgnoreCase("category"))
		 {
			 vector=DBInfo.getCategory();
		 }
		 else if(values.equalsIgnoreCase("subject"))
		 {
			 vector=DBInfo.getSubject();
		 }
		 else
		 {
			 
		 }
		 
		
		JComboBox comboBox = new JComboBox(vector);
		comboBox.insertItemAt("Select",0);
		comboBox.setSelectedIndex(0);
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(46)
					.addComponent(lblSelect)
					.addGap(89)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(87, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(67)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSelect)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(137, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						String s1=(String)comboBox.getSelectedItem();
						//System.out.println(s1+":::"+values);
						
						JFrame frm = new JFrame();
						
						frm.setSize(900, 400);
						frm.setLocationRelativeTo(frm);
						frm.setDefaultCloseOperation(frm.DISPOSE_ON_CLOSE);
						
						DBInfo.getValues(values, s1);
						
						JTable t = new JTable(DBInfo.outer,DBInfo.header);
						JScrollPane pane = new JScrollPane(t);
						frm.getContentPane().add(pane);
						frm.setVisible(true);
						
						dispose();
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
