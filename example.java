import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;


/* I'm designing player matcher application.This is first page that we will see on the screen when we install application
 our phones or computers.Firstly users have to sign in , if they have account they have to log in . */

public class example extends JFrame implements ActionListener,Runnable{
   
	// I defined GUI items
	private JLabel lblİK,lblMatcher,lblSpace1,lblSpace2,lblGame1,lblGame2,lblGame3;
    private JButton btnSignIn,btnSearch,btnGAME1,btnGAME2,btnGAME3,btnLanguages,btnPlay,btnFind_Your_Partner;
    private JTextField txtİK;
	private JPanel pnlContent,pnlContent2;
	private JDialog jlexample;
	
	//for animation
	private Font font;
	private int x,y;
	private Timer timer;
	private Thread myThread;
	private int a,b;
	private int speedX,speedY;
	
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
	
		g.setColor(Color.RED);
		g.setFont(font);
		g.drawString("THE LATEST NEW :VALORANT İS THE MOST PLAYED GAMES .", x, y);
	
	}
	public  example() {
	
		
		setLayout(new BorderLayout());
		
		//I initialized buttons and labels. These are  the items at the top of  the screen.
		
		btnSignIn=new JButton("SIGN IN");
		btnSignIn.setBackground(Color.DARK_GRAY);
		btnSignIn.setForeground(Color.LIGHT_GRAY);
		/*btnSearch=new JButton("SEARCH"); 
		btnSearch.setBackground(Color.DARK_GRAY);
		btnSearch.setForeground(Color.LIGHT_GRAY);*/
		
		
		btnLanguages=new JButton("Languages");
		btnLanguages.setBackground(Color.DARK_GRAY);
		btnLanguages.setForeground(Color.LIGHT_GRAY);
		btnPlay=new JButton("PLAY");
		lblMatcher=new JLabel("MATCHER");
		lblMatcher.setForeground(Color.RED);
		lblMatcher.setFont(new Font ("MATCHER",Font.BOLD,45)); // ı changed the font.
	
		
		lblİK=new JLabel("");
		lblSpace1=new JLabel("                                                                                                                 ");
		lblSpace2=new JLabel("                                                                                                                 ");
		
		add(lblİK);
		
		
		// I used java panel to put many thing to the same place.
		
		JPanel panel=new JPanel();
		
		pnlContent =new JPanel ();
		pnlContent.add(lblMatcher);
		pnlContent.add(lblSpace1);
		pnlContent.add(lblSpace2);
		
		pnlContent.add(btnLanguages);
		//pnlContent.add(btnSearch);
		pnlContent.add(btnSignIn);	
		
		add(pnlContent,BorderLayout.NORTH);
	    
	
		
		
		//ı changed the button sizes 
		
		btnSignIn.setPreferredSize(new Dimension (200,50));
		//btnSearch.setPreferredSize(new Dimension(200,50));
		btnLanguages.setPreferredSize(new Dimension(200,50));
		// put to screen the my game buttons as i want using border layout.
		btnGAME1=new JButton("GAME1");
		btnGAME1.setPreferredSize(new Dimension(900,100));
		add(btnGAME1,BorderLayout.CENTER);
		

		
		btnGAME2=new JButton("GAME 2");
		btnGAME2.setPreferredSize(new Dimension(300, 500));
		btnGAME2.setBackground(Color.DARK_GRAY);
		btnGAME2.setForeground(Color.LIGHT_GRAY);
		
		add(btnGAME2,BorderLayout.LINE_END);
		btnGAME3=new JButton("GAME 3");
		btnGAME3.setPreferredSize(new Dimension(300,500));
		add(btnGAME3,BorderLayout.LINE_START);
		btnGAME3.setBackground(Color.DARK_GRAY);
		btnGAME3.setForeground(Color.LIGHT_GRAY);
		
		
		//for animation
		font= new Font("Time New Roman",
				Font.BOLD|Font.ITALIC, 35);
		x=100;
		y=700;
		
		a=100;
		b=50;
		timer= new Timer(100, this);
		
		myThread=new Thread(this);
		
		//frame settings
		setSize(1500,725);
		setTitle("Example");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	

		//register buttons to handle the implements
	
		btnSignIn.addActionListener(this);
		btnLanguages.addActionListener(this);
		//btnSearch.addActionListener(this);
		btnGAME1.addActionListener(this);
		btnGAME2.addActionListener(this);
		btnGAME3.addActionListener(this);
	   
		
	
	}
	
	public static void main (String[]args) {
		
		new example();
	   
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	 if (e.getSource()==btnLanguages) {
			languages();
		}
		
		else if (e.getSource()==btnGAME1) {
			 game1();
		}
		else if (e.getSource()==btnGAME2) {
			 game2();
		}
		else if (e.getSource()==btnGAME3) {
			 game3();
		}
		//for animation,thread starting	
		if (e.getSource()==btnGAME1 && !myThread.isAlive()) {
			//start animation
			myThread.start();
		}
	    if (e.getActionCommand().equals("İK")){
	    	btnİK();
	    }
	    else if (e.getActionCommand().equals("SEARCH")) {
	    	Search();
	    }
	
	
	
	}

	private void Search() {
		// TODO Auto-generated method stub
		
	}



     //This method shows options on the second window.
	private void btnİK() {
		// TODO Auto-generated method stub
		String[] options= {"ACCOUNT","MESSAGES","LOGOUT"};
	     String alloptions=(String) JOptionPane.showInputDialog(null,"","SELECT",JOptionPane.QUESTION_MESSAGE,
				                                                 null, options,options[0]);		
	}






    
	private void game1() {
		// TODO Auto-generated method stub
		
		
		
		
				

	}
	//this for animation
	public void move() {
		while (true) {
			try {
				Thread.currentThread().sleep(400);
				x=x+5;
				repaint();
			}
			catch (InterruptedException e) {
				// TODO: handle exception
				return; // exit from the loop THİS İS HOW DO WE STOP
			}
		}
	}
	
	
	private void game2() {
		// TODO Auto-generated method stub
		
		
			
	}
	
	private void game3() {
		// TODO Auto-generated method stub
		
		
		
	}
	

	//User can choose any language that their want
	private void languages() {
		// TODO Auto-generated method stub
		String [] languages= {"Turkçe","English","German"};
		String mylanguages=(String) JOptionPane.showInputDialog(null,"","SELECT",JOptionPane.QUESTION_MESSAGE,null,languages,
				                                                                                    languages[0]);
	}
      //This method provides some options to users.
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
        move();

		
	}

	
	
	
	
	
	
	
	
	
	
}