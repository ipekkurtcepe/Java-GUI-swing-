import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Matcher extends JFrame implements ActionListener{
         private JLabel userLabel,passwordLabel;
         private JTextField userText;
         private JPasswordField passwordText;
         private JButton button;
         private JLabel success;
	
		public Matcher() {
          
	
    	JFrame frame=new JFrame();
	    JPanel panel=new JPanel();	
		frame.setSize(200,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(panel);
		
		panel.setLayout(null);
		
		
		 userLabel =new JLabel("User");
		
		userLabel.setBounds(10,20,80,25);
		panel.add(userLabel);
		
		 userText =new JTextField(20);	
		userText.setBounds(100,20,165,25);
		panel.add(userText);
		
		 passwordLabel=new JLabel("Password");
		passwordLabel.setBounds(10,50,80,25);
		panel.add(passwordLabel);
		
	   passwordText =new JPasswordField();
		passwordText.setBounds(100,50,165,25);
		panel.add(passwordText);
		
		
		 button =new JButton("LOG IN");
		button.setBounds(10,80,80,25);
	    button.addActionListener(this);
		panel.add(button);
		
		 success =new JLabel ("");
		success.setBounds(10,110,300,25);
		panel.add(success);
		
		
		
			
		frame.setVisible(true);
			
			
			
			
			
			
			
			
			
		
	
		}
	    public static void main(String[] args) {
			new Matcher();
			
			

				
				
			}
			
			
			
			
			
			
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String user=userText.getText();
			String password =passwordText.getText();
			//System.out.println(user+","+password);
			
			if (user.equals("ipek@gmail.com")&& password.equals("ipek56")){
				
				
				JOptionPane.showMessageDialog(this,  "log in successfull");
				//success.setText("Log in succesul!");
			   try {
				   //Server
				   ServerSocket server=new ServerSocket(6000);
				   Socket socket=server.accept();
				   
			     InputStream is =socket.getInputStream();
			     DataInputStream dis=new DataInputStream(new BufferedInputStream(is));
			     
			     //Client
			     Socket s =new Socket ("local host",6000);
			     OutputStream os=s.getOutputStream();
			     DataOutputStream dos =new DataOutputStream(os);
			     
			   
			   
			   userText.setText(JOptionPane.showInputDialog(this,"UserName","Input username"));
			   
			   }catch(Exception ex ) {
				   System.out.println(ex.getMessage());
			   }
			    //example myexample=new example();
			}
			else {	JOptionPane.showMessageDialog(null,"Invalid e-mail or password"); }	
			
		}
	
}
