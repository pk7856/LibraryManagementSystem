import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class SearchUpDelNotice extends JFrame {

	private JPanel contentPane;
	JComboBox comboBox;
	JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchUpDelNotice frame = new SearchUpDelNotice();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void reset()
	{
		comboBox.setSelectedIndex(0);
		textArea.setText(null);
	}
	/**
	 * Create the frame.
	 */
	public SearchUpDelNotice() {
		setTitle("Search/Update/Delete Notice ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 475, 480);
		setLocationRelativeTo(this);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("SEARCH_UPDATE_DELETE_NOTICE");
		
		JLabel lblSelectDate = new JLabel("Select Date");
		
		
		comboBox = new JComboBox(DBInfo.getdate());
		comboBox.insertItemAt("Select",0);
		comboBox.setSelectedIndex(0);
		comboBox.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) 
			{
				String date = (String)comboBox.getSelectedItem();
				String query= "select * from notice where date=?";
				int flag=0;
				try 
				{
					PreparedStatement ps = DBInfo.con.prepareStatement(query);
					ps.setString(1, date);
					ResultSet res=ps.executeQuery();
					while(res.next())
					{
						flag=1;
						String mess = res.getString(3);
						textArea.setText(mess);
						break;
					}	
					} catch (Exception e1) {
					e1.printStackTrace();
				}	
			}
		});
		

		JLabel lblMessage = new JLabel("Message ");
		
		JScrollPane scrollPane = new JScrollPane();
		
		textArea= new JTextArea(10, 20);
		scrollPane.setViewportView(textArea);
		textArea.setText("");
		
		JButton btnReset = new JButton("Reset ");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				reset();
			}
		});
		
		JButton btnSearch = new JButton("Search ");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				if(((String)comboBox.getSelectedItem()).equalsIgnoreCase("select"))
				{
					JOptionPane.showMessageDialog(getParent(), "Select a Date!!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					String date = (String)comboBox.getSelectedItem();
					String query= "select * from notice where date=?";
					int flag=0;
					try 
					{
						PreparedStatement ps = DBInfo.con.prepareStatement(query);
						ps.setString(1, date);
						ResultSet res=ps.executeQuery();
						while(res.next())
						{
							flag=1;
							String mess = res.getString(3);
							textArea.setText(mess);
							break;
						}	
						} catch (Exception e1) {
						e1.printStackTrace();
					}
					if(flag==0 )
						{
							JOptionPane.showMessageDialog(getParent(), "Wrong Input!!", "Error", JOptionPane.ERROR_MESSAGE);
						}
				}
			}
		});
		
		JButton btnUpdate = new JButton("Update ");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String mess =textArea.getText();
				
				if( mess.length()==0  || ((String)comboBox.getSelectedItem()).equalsIgnoreCase("select"))      
				{
					JOptionPane.showMessageDialog(getParent(), "Please fill the credentials !!", "Error",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					String date = (String)comboBox.getSelectedItem();
					String query="update notice set message=? where date=?";
					int flag=0;
					try {
						PreparedStatement ps=DBInfo.con.prepareStatement(query);
						
						ps.setString(1,mess);
						ps.setString(2,date);
						flag=ps.executeUpdate();
						} catch (Exception e)
						{
							e.printStackTrace();
						}
					
					if(flag==1)
					{
						JOptionPane.showMessageDialog(getParent(), "Message Updated Successfully", "Message",JOptionPane.INFORMATION_MESSAGE);
						reset();
						
					}
					else
						JOptionPane.showMessageDialog(getParent(), "Message Not Updated", "Error",JOptionPane.ERROR_MESSAGE);
					
				}	
			}
		});
		
		JButton btnDelete = new JButton("Delete ");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				int flag=0;
				String mess =textArea.getText();
				if( mess.length()==0 || ((String)comboBox.getSelectedItem()).equalsIgnoreCase("select"))      
				{
					JOptionPane.showMessageDialog(getParent(), "Please fill the Message or Date", "Error",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					String date = (String)comboBox.getSelectedItem();
					String query="delete from notice where date=?";
					try 
					{
						PreparedStatement ps = DBInfo.con.prepareStatement(query);
						ps.setString(1,date);
						flag=ps.executeUpdate();
					
					} catch (Exception e) {
						e.printStackTrace();
					}
						
					if(flag!=0  )
						{
							JOptionPane.showMessageDialog(getParent(),"Message Deleated Successfully!!", "Message",JOptionPane.INFORMATION_MESSAGE);
							dispose();
							new SearchUpDelNotice().setVisible(true);
						}
					if(flag==0 )
						{
							JOptionPane.showMessageDialog(getParent(), "Message Not Deleated !!", "Error",JOptionPane.ERROR_MESSAGE);
						}
				}	
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(51)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSelectDate)
								.addComponent(lblMessage))
							.addGap(83)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSearch)
							.addContainerGap(33, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addGap(29)
									.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
									.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
									.addGap(82))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addContainerGap(258, Short.MAX_VALUE))))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(63)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSelectDate)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblMessage)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnReset)
						.addComponent(btnDelete)
						.addComponent(btnUpdate))
					.addGap(27))
		);
		
		
		contentPane.setLayout(gl_contentPane);
	}
}
