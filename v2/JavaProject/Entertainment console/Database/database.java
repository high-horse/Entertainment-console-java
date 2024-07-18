package Database;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class database extends JFrame implements ActionListener{

	
	JLabel loginuser,loginpass,enter;
	JTextField loginuser1,loginpass1;
	JButton b1,b2,d;
	Container c;
	JPanel j;
	public void head() 
	{		
		 setVisible(true);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		 setBounds(410,50,800,600);
		 setTitle("Entertainment Console");
		 c=this.getContentPane();
         c.setBackground(Color.DARK_GRAY);
         c.setLayout(null);
		}
	public void Entertainment()
	{
		Font f1=new Font("Arial",Font.BOLD,30);
		enter =new JLabel("Entertainment Console");
		enter.setFont(f1);
		enter.setBounds(200,10,400,200);
		enter.setForeground(Color.white);
		c.add(enter);	
	}
	public void button1() {
		Font f1=new Font("Arial",Font.BOLD,30);
		b1=new JButton("SignUp");
		b1.setFont(f1);
		b1.setBounds(290,250,200,60);
		b1.setForeground(Color.white);
		b1.setBackground(Color.red);
		b1.addActionListener(this);
		c.add(b1);	
	}
	
	public void button2()
	{
		Font f1=new Font("Arial",Font.BOLD,30);
		b2=new JButton("Login");
		b2.setFont(f1);
		b2.setBounds(290,350,200,60);
		b2.setForeground(Color.white);
		b2.setBackground(Color.red);
		b2.addActionListener(this);
		c.add(b2);	
	}
public 	void signin()
	{
		Font f1=new Font("Arial",Font.BOLD,30);
		loginuser=new JLabel("Username");
		loginuser.setFont(f1);
		loginuser.setForeground(Color.white);
		loginuser.setBounds(100,150,100,50);
		c.add(loginuser);
		
		loginuser1=new JTextField();
		loginuser1.setBounds(170,150,100,50);
		loginuser1.setForeground(Color.black);
		loginuser1.addActionListener(this);
		c.add(loginuser1);
	}
	public void signin1()
	{
		loginpass=new JLabel("Password");
		loginpass.setBounds(100,200,100,50);
		c.add(loginpass);		
		loginpass1=new JTextField();
		loginpass1.setBounds(170,200,100,50);		
		c.add(loginpass1);
	}
	public  void del()
	 {
		 Font f2=new Font("Arial",Font.BOLD,20);
			d=new JButton("Account Deletion");
			d.setFont(f2);
			d.setBackground(Color.red);
			d.setForeground(Color.white);
			d.setBounds(260,450,250,50);
			d.addActionListener(this);
			c.add(d);
	 }

	
	public void actionPerformed(ActionEvent e) {
	if(e.getSource()==b1)
	{
		 JOptionPane.showMessageDialog(null,"Welcome to Register page");
		 setVisible(false);
		
		 Signup s=new Signup();
		
			s.head();
			s.first();
			s.last();
			s.register();
			s.email();
			s.password();
			s.back();
	}
	else if(e.getSource()==b2)
	{
		JOptionPane.showMessageDialog(null,"Welcome to Login page");
		setVisible(false);
		
		Signlogin s=new Signlogin();
		
			s.head();
			s.signin();
			s.password();
			s.login();		
			s.back();
			
	}
	else if(e.getSource()==d){
		 JOptionPane.showMessageDialog(null,"Welcome to Deletion Page");
		 setVisible(false);
		 delate d=new delate();
			d.head();
	}
	else
	{
		JOptionPane.showMessageDialog(null,"Sorry Server is not Wroking");
		setVisible(false);
	}
	}
public static void main(String args[])
{
database d=new database();
d.head();
d.button1();
d.button2();
d.Entertainment();
d.del();

}


}
