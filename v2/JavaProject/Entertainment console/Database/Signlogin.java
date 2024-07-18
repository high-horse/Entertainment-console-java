package Database;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import Games.gamelist;
//import Games.games;
import thugLife.thuglife1;

import javax.swing.JOptionPane;

public class Signlogin extends JFrame implements ActionListener{
	
	String name,pass;
	static String url = "jdbc:mysql://localhost:3306/Entertainment?useSSL=false";
	static String uname = "root";
	static String passw = "mutillidae";
	static String query;
	
	JLabel loginuser,loginpass,enter;
	JTextField loginuser1;
	JPasswordField loginpass1;
	JButton b,bc;
	Container c;

	void back() {
		bc=new JButton("Back");
		bc.setBounds(690,70,100,30);
		bc.setBackground(Color.red);
		bc.setForeground(Color.white);
		c.add(bc);
		bc.addActionListener(this);
		
	}
	void head() 
	{
		 setVisible(true);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		 setBounds(410,50,800,600);
		 setTitle("Entertainment Console");
		 c=this.getContentPane();
         c.setBackground(Color.DARK_GRAY);
         c.setLayout(null);
		}
	
//	void Entertainment()
//	{
//		Font f1=new Font("Arial",Font.BOLD,30);
//		enter =new JLabel("Entertainment Console");
//		enter.setFont(f1);
//		enter.setBounds(200,20,400,200);
//		enter.setForeground(Color.white);
//		c.add(enter);	
//	}
	void signin()
	{
		Font f1=new Font("Arial",Font.BOLD,20);
		loginuser=new JLabel("Username");
		loginuser.setFont(f1);
		loginuser.setForeground(Color.white);
		loginuser.setBounds(250,170,300,100);
		c.add(loginuser);
		
		Font f2=new Font("Arial",Font.BOLD,15);
		loginuser1=new JTextField();
		loginuser1.setBounds(380,200,90,30);
		loginuser1.setFont(f2);
		loginuser1.setBackground(Color.white);
		loginuser1.setForeground(Color.black);
		loginuser1.addActionListener(this);
		c.add(loginuser1);
	}
	void password()
	{
		Font f1=new Font("Arial",Font.BOLD,20);
		loginpass=new JLabel("Password");
		loginpass.setFont(f1);
		loginpass.setForeground(Color.white);
		loginpass.setBounds(250,230,300,100);
		c.add(loginpass);
		
		Font f2=new Font("Arial",Font.BOLD,15);
		loginpass1=new JPasswordField ();
		loginpass1.setBackground(Color.white);
		loginpass1.setFont(f2);
		loginpass1.setForeground(Color.black);
		loginpass1.setBounds(380,260,90,30);
		loginpass1.addActionListener(this);
		c.add(loginpass1);
	}

	void login()
	{
		Font f2=new Font("Arial",Font.BOLD,15);
		b=new JButton("Login");
		b.setFont(f2);
		b.setBackground(Color.red);
		b.setForeground(Color.white);
		b.setBounds(690,20,100,30);
		b.addActionListener(this);
		c.add(b);		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b)
		{
			//reading from table
			try
			{
			String name=loginuser1.getText();	
			query = "select * from "+name+" where fname=? AND password=?"; 
			
			this.name=loginuser1.getText();
			this.pass=loginpass1.getText();
			String password=loginpass1.getText();
			ResultSet rs;
			Connection con = DriverManager.getConnection(url, uname, passw);
		    Statement s = con.createStatement();
			
			PreparedStatement p = con.prepareStatement(query);
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, uname, passw);
			s = con.createStatement();
			p = con.prepareStatement(query);
			
				p.setString(1,name);
				p.setString(2,password);
				thuglife1 t=new thuglife1();
			
				rs=p.executeQuery();

				  if (rs.next()) 
				  {
					 JOptionPane.showMessageDialog(null,"Sucessfully Login"); 
					 					 
					 setVisible(false);
					 gamelist g=new gamelist();
						g.head();
						g.Entertainment();
						g.Alu();
						g.Thug();
						g.Brickbreaker();
						g.Mathmatical();
						g.music();
						g.Combobox();
					    g.back();
				  }
			       else 
			       {
			    	  JOptionPane.showMessageDialog(null,"Incorrect Password or Username");
			    	 
			       }
			     }   
			catch (ClassNotFoundException | SQLException e1){
			
				  e1.printStackTrace();
			}
			}
		else if(e.getSource()==bc) {
			setVisible(false);
			database d=new database();
			d.head();
			d.button1();
			d.button2();
			d.Entertainment();
			d.del();
		}
		else {
			 JOptionPane.showMessageDialog(null,"Invalid Account");
		}
	}
	
public static void main(String args[])
    {
	Signlogin s=new Signlogin();
//	s.Entertainment();
	s.head();
	s.signin();
	s.password();
	s.login();
	s.back();
    }
}

