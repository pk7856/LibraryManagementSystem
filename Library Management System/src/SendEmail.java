import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;

//imports for mail
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SendEmail extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTo;
	private JTextField textFieldSub;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SendEmail frame = new SendEmail();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void reset()
	{
		textFieldTo.setText(null);
		textFieldSub.setText(null);
		textArea.setText(null);
	}
	
	/**
	 * Create the frame.
	 */
	public SendEmail() {
		setTitle("Send Email");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 473, 461);
		setLocationRelativeTo(this);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblTo = new JLabel("To");
		
		textFieldTo = new JTextField();
		textFieldTo.setColumns(15);
		
		JLabel lblMessage = new JLabel("Message");
		
		JLabel lblSendEmail = new JLabel("SEND_EMAIL");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblSubject = new JLabel("Subject");
		
		textFieldSub = new JTextField();
		textFieldSub.setColumns(15);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnSend = new JButton("SEND");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textFieldTo.getText().length()==0 || textFieldSub.getText().length()==0 || textArea.getText().length()==0)
		            JOptionPane.showMessageDialog(getParent(),"Please Fill All Details !!"," ERROR",JOptionPane.ERROR_MESSAGE);
				else{
					try{
		            String host ="smtp.gmail.com" ;
		            String user = "Email_id1";
		            String pass = "Password";
		            String to = textFieldTo.getText() ;
		            String from = "Email_id1";
		            String subject = textFieldSub.getText();
		            String messageText = textArea.getText();
		            boolean sessionDebug = false;

		            Properties props = System.getProperties();

		            props.put("mail.smtp.starttls.enable", "true");
		            props.put("mail.smtp.host", host);
		            props.put("mail.smtp.port", "587");
		            props.put("mail.smtp.auth", "true");
		            props.put("mail.smtp.starttls.required", "true");

		            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		            Session mailSession = Session.getDefaultInstance(props, null);
		            mailSession.setDebug(sessionDebug);
		            Message msg = new MimeMessage(mailSession);
		            msg.setFrom(new InternetAddress(from));
		            InternetAddress[] address = {new InternetAddress(to)};
		            msg.setRecipients(Message.RecipientType.TO, address);
		            msg.setSubject(subject); msg.setSentDate(new Date());
		            msg.setText(messageText);

		           Transport transport=mailSession.getTransport("smtp");
		           transport.connect(host, user, pass);
		           transport.sendMessage(msg, msg.getAllRecipients());
		           transport.close();
		           //System.out.println("message send successfully");
		           JOptionPane.showMessageDialog(getParent(), "Message Send Successfully");
		           reset();
		        }catch(Exception ex)
		        {
		            //System.out.println(ex);
		            JOptionPane.showMessageDialog(getParent(),"Message Not Sent !!"," ERROR",JOptionPane.ERROR_MESSAGE);
		            reset();
		        }}
			}
		});
		
		JButton btnCancel = new JButton("CLEAR");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reset();
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(170)
							.addComponent(lblSendEmail))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(36)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTo, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSubject)
								.addComponent(lblMessage))
							.addGap(137)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textFieldSub, Alignment.TRAILING)
								.addComponent(textFieldTo, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
								.addComponent(scrollPane)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(95)
							.addComponent(btnSend)
							.addGap(97)
							.addComponent(btnCancel)))
					.addContainerGap(55, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addComponent(lblSendEmail)
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldTo, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTo, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldSub, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSubject))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(100)
							.addComponent(lblMessage))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(104, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(361, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSend)
						.addComponent(btnCancel))
					.addGap(38))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
