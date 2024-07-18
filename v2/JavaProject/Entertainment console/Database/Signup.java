package Database;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Signup extends JFrame implements ActionListener{

	static String url = "jdbc:mysql://localhost:3306/Entertainment?useSSL=false";
	static String uname = "root";
	static String passw = "mutillidae";
	static String query;
	
	JLabel loginuser,loginpass,enter,email,pass;
	JTextField loginuser1,loginpass1,email1;
	JPasswordField pass1;
	JButton b,d,bc;
	Container c;
	JPanel j;
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

	void first()
	{
		Font f1=new Font("Arial",Font.BOLD,20);
		loginuser=new JLabel("FirstName");
		loginuser.setFont(f1);
		loginuser.setForeground(Color.white);
		loginuser.setBounds(250,170,300,100);
		c.add(loginuser);
		
		Font f2=new Font("Arial",Font.BOLD,15);
		loginuser1=new JTextField();
		loginuser1.setBounds(430,200,90,30);
		loginuser1.setFont(f2);
		loginuser1.setBackground(Color.white);
		loginuser1.setForeground(Color.black);
		loginuser1.addActionListener(this);
		c.add(loginuser1);
	}
	
	void last()
	{
		Font f1=new Font("Arial",Font.BOLD,20);
		loginpass=new JLabel("LastName");
		loginpass.setFont(f1);
		loginpass.setForeground(Color.white);
		loginpass.setBounds(250,230,300,100);
		c.add(loginpass);
		
		Font f2=new Font("Arial",Font.BOLD,15);
		loginpass1=new JTextField();
		loginpass1.setBackground(Color.white);
		loginpass1.setFont(f2);
		loginpass1.setForeground(Color.black);
		loginpass1.setBounds(430,260,90,30);
		loginpass1.addActionListener(this);
		c.add(loginpass1);
	}

	void email()
	{
		Font f1=new Font("Arial",Font.BOLD,20);
		email=new JLabel("Email-Address");
		email.setFont(f1);
		email.setForeground(Color.white);
		email.setBounds(250,290,300,100);
		c.add(email);
		
		Font f2=new Font("Arial",Font.BOLD,15);
		email1=new JTextField();
		email.setBackground(Color.white);
		email1.setFont(f2);
		email1.setForeground(Color.black);
		email1.setBounds(430,320,220,30);
		email1.addActionListener(this);
		c.add(email1);
	}

	void password()
	{
		
		Font f1=new Font("Arial",Font.BOLD,20);
		pass=new JLabel("Password");
		pass.setFont(f1);
		pass.setForeground(Color.white);
		pass.setBounds(250,350,300,100);
		c.add(pass);
		
		Font f2=new Font("Arial",Font.BOLD,15);
		pass1=new JPasswordField();
		pass1.setBackground(Color.white);
		pass1.setFont(f2);
		pass1.setForeground(Color.black);
		pass1.setBounds(430,380,220,30);
		pass1.addActionListener(this);
		c.add(pass1);
		
	}
	
	
	void register()
	{
		Font f2=new Font("Arial",Font.BOLD,15);
		b=new JButton("Register");
		b.setFont(f2);
		b.setBackground(Color.red);
		b.setForeground(Color.white);
		b.setBounds(690,20,120,30);
		b.addActionListener(this);
		c.add(b);
		
	}
//created table
	void acountcreate()
	{
		try 
		{   
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, passw);
		Statement s = con.createStatement();
		String name=loginuser1.getText();
		String query = ("CREATE TABLE IF NOT EXISTS "+name+"(ID INTEGER NOT NULL AUTO_INCREMENT,fname varchar(255),lname varchar(255),email varchar(255),password varchar(255),PRIMARY KEY(id))");
		PreparedStatement p = con.prepareStatement(query);
		int count = p.executeUpdate();

	    }  
	    catch (ClassNotFoundException | SQLException e1) {
		e1.printStackTrace();
	 } 
		}

	public void actionPerformed(ActionEvent e) {
		//inserted table
		if(e.getSource()==b)
		{
			acountcreate();
			try 
			{
            
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, uname, passw);
			Statement s = con.createStatement();		
			String name=loginuser1.getText();
			String query = "Insert into "+name+"(fname,lname,email,password)values(?,?,?,?) ";	
			PreparedStatement p = con.prepareStatement(query);
		
			p.setString(1,loginuser1.getText());
    		p.setString(2,loginpass1.getText());
    		p.setString(3, email1.getText());
    		p.setString(4, pass1.getText());     

			
			if(loginuser1.getText().equals("")&&loginpass1.getText().equals("")&&email1.getText().equals("")&& pass1.getText().equals(""))
			{
				
				JOptionPane.showMessageDialog(null,"Invalid username or password");
			}
			if(loginuser1.getText().equals("")||loginpass1.getText().equals("")||email1.getText().equals("")|| pass1.getText().equals(""))
			{
				
				JOptionPane.showMessageDialog(null,"Invalid username or password");
			}
		else 
			{
				int count = p.executeUpdate();
				if(count>0) {
					JOptionPane.showMessageDialog(null,"Sucessfully register");
					setVisible(false);
					Signlogin s1=new Signlogin();
					s1.head();
					s1.signin();
					s1.password();
					s1.login();
					s1.back();
				}
			else {
					JOptionPane.showMessageDialog(null,"Invalid username or password");
				}
					
			}

		    }  
    	    catch (ClassNotFoundException | SQLException e1) {
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
		else
		{
			JOptionPane.showMessageDialog(null,"Enter Correctly");
	
		}
	}
public static void main(String args[])
        {
	Signup s=new Signup();
	s.head();
	s.first();
	s.last();
	s.register();
	s.email();
	s.password();
    s.back();
      }
}
