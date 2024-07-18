package Alucross;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Database.database;
import Games.gamelist;

public class Tiktac1 extends JFrame implements ActionListener{
	public JTextField t1,t2;
	JLabel j,j1;
	JButton b,d,bc;
	Container c;
	static String url = "jdbc:mysql://localhost:3306/Entertainment?useSSL=false";
	static String uname = "root";
	static String passw = "mutillidae";
	static String query;
	JMenuItem exit,view,play,gamemenu;
	JMenu file,Dashboard;
	
	public void back() {
		bc=new JButton("Back");
		bc.setBounds(400,180,100,30);
		bc.setBackground(Color.black);
		bc.setForeground(Color.white);
		c.add(bc);
		bc.addActionListener(this);
		
	}
	public void menu() {
		  JMenuBar jmb=new JMenuBar();
		  setJMenuBar(jmb);
		  file=new JMenu("File");
		  jmb.add(file);
		
		  

		  play=new JMenuItem("Play");
		  file.add(play);
		  

		  exit=new JMenuItem("Exit");
		  file.add(exit); 
		  
		  gamemenu=new JMenuItem("Gamelist");
		  file.add(gamemenu);
		  
		  Dashboard=new JMenu("Dashboard");
		  jmb.add(Dashboard);
		  
		  view=new JMenuItem("View");
		  Dashboard.add(view); 
		
		  exit.addActionListener(this);
		  view.addActionListener(this);
	      play.addActionListener(this);
	      gamemenu.addActionListener(this);
	}
	public void alu()
	 {		 
		 setVisible(true);
		 setTitle("Entertainment Console");	
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		 setBounds(400,100,700,550);
	     c=this.getContentPane();
	   
	     c.setBackground(Color.red);
	     c.setLayout(null);
	     t1=new JTextField();
	     Font f1=new Font("Arial",Font.BOLD,30);
	     j=new JLabel("TicTacToe");
	     j.setForeground(Color.white);
	     j.setBounds(250,10,200,70);
	     j.setFont(f1);
	     c.add(j);
	     
	     j1=new JLabel("PlayerName");
	     j1.setForeground(Color.white);
	     j1.setBounds(150,150,100,30);
	     c.add(j1);
	     
		 Font f=new Font("Arial",Font.BOLD,15);
		 t1=new JTextField();
		 t1.setFont(f);
		 t1.setBounds(150,180,100,30);
		 t1.setForeground(Color.white);
		 t1.setBackground(Color.black);
		 c.add(t1);
		 t1.addActionListener(this);
		 
	
	     b=new JButton("Start"); 
	     b.setFont(f);
	     b.setForeground(Color.white);
	     b.setBackground(Color.black);
	     b.setBounds(150,240,100,30);	    
	     c.add(b);	 
	     b.addActionListener(this);	  
	 	   
	     d=new JButton("DashBoard");
	     d.setFont(f);		   
	     d.setForeground(Color.white);
	     d.setBackground(Color.black);
	     d.setBounds(400,240,150,30);	   
	     c.add(d);
	     d.addActionListener(this);
	 }
	 
public static void main(String args[])
{	
 	Tiktac1 t=new Tiktac1();
 	t.alu();
 	t.menu();
 	t.back();
}

@Override
public void actionPerformed(ActionEvent e) {
     if(e.getSource()==b)
     {
	 try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, uname, passw);
			Statement s = con.createStatement();				
			String query = "Insert into alu(pname,game)values(?,?) ";	
			PreparedStatement p = con.prepareStatement(query);
			p.setString(1,t1.getText());
	    	p.setString(2,"Alucross");
	    	String name=t1.getText();
	    	Tiktac game=new Tiktac();
	    	game.suren(name);
			int count = p.executeUpdate();			
			System.out.println(count + "rows affected :" + count);    
			}  
	    	catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
			}
	   JOptionPane.showMessageDialog(null,"Sucessfully Loaded");
	   setVisible(false);
	   Tiktac game=new Tiktac();
	   game.Tiktac1();
	   game.back();
      }
     else  if(e.getSource()==d)
     {
    	 
    	Dash d=new Dash();
    	JFrame j=new JFrame();
    	j.setVisible(true);	 
    	j. setBounds(410,5,800,600);
    	j.setTitle("Entertainment Console");
    	j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        j.add(d);
        d.database();
        d.suren();
     }
		else if(e.getSource()==play) {
			  JOptionPane.showMessageDialog(null,"Sucessfully Loaded");
			   setVisible(false);
			   Tiktac game=new Tiktac();
			   game.Tiktac1();
			   game.back();
			
	}
    	else if(e.getSource()==exit) {
    		setVisible(false);
    		System.exit(0);
    	}
    	else if(e.getSource()==view) {
    		 
        	Dash d=new Dash();
        	JFrame j=new JFrame();
        	j.setVisible(true);	 
        	j. setBounds(410,5,800,600);
        	j.setTitle("Entertainment Console");
        	j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            j.add(d);
            d.database();
            d.suren();
    	}
    
    		else if(e.getSource()==gamemenu) {
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
    		}
    		else if(e.getSource()==bc) {
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
    		else {
    			  JOptionPane.showMessageDialog(null,"Failed to load");
    		}
    }
 }




