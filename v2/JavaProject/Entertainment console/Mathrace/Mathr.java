package Mathrace;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Games.gamelist;
import java.util.Random;
import java.util.Scanner;
import java.math.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
public class Mathr extends JFrame implements ActionListener{

	 static String hero;
	 String name3,rl="chippad";
	 String name4,name5,name6;
	 int score8;
	 static String url = "jdbc:mysql://localhost:3306/Entertainment?useSSL=false";
	 static String uname = "root";
	 static String passw = "mutillidae";
	 static String query;
	 int count;
	 int w,x,y,z;
	 Container c;
	 JLabel j,s1;
     static JTextField s;
	 JTextField e1;
	 static JTextField j1;
	 JButton b,c1,b1,r1,bc;
	 
     static Scanner oof=new Scanner(System.in);
	 static int total=0;
	//getter setter and tostring
	 
	 void setscore(int score){ //setter
		 this.count=count;
	 }
	 int getscore() { //getter
		 return this.count;
	 }
	 String tostring() {  //tostring
		 return "Mathrace";
	 }
	 

	   public void back() {
			bc=new JButton("Back");
			bc.setBounds(650,270,100,30);
			bc.setBackground(Color.red);
			bc.setForeground(Color.white);
			c.add(bc);
			bc.addActionListener(this);				
		}
	   
	 public void head() {

	        setVisible(true);
	        setTitle("MathRace");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(400, 70, 800, 650);
	        c = this.getContentPane();
	        c.setBackground(Color.DARK_GRAY);
	        c.setLayout(null);
	        Font f = new Font("Arial", Font.BOLD, 30);
	        j = new JLabel("MathRace");
	        j.setFont(f);
	        j.setForeground(Color.black);
	        c.add(j);
	        j.setBounds(330, 5, 900, 150);
	        c.add(j);
	    }
	  
	     public void score() {
		  Font f = new Font("Arial", Font.BOLD, 17);
		  s1=new JLabel("Score");
		  s1.setFont(f);
		  s1.setForeground(Color.black);
		  s1.setBounds(660,230,100,30);
		  c.add(s1);
	
		  s=new JTextField(10);		 
		  s.setBounds(650,190,80,40);
		  s.setForeground(Color.black);
		  s.setFont(f);
		  s.setBackground(Color.red);
		  c.add(s);
		  s.addActionListener(this);
	  }
	     public void play() {
	    	 b=new JButton("Play");
	    	 b.setBounds(650,390,100,40);
	    	 c.add(b);
	    	 b.addActionListener(this);

	     }
	     public void disp() {
	    	 Font f1 = new Font("Arial", Font.BOLD, 40);
	    	 j1=new JTextField();
	         j1.setBounds(250,190,350,250);
	         j1.setFont(f1);
	         j1.setBackground(Color.red);
	         c.add(j1);
	         j1.addActionListener(this);
         
	     }
	     public void input() {
	    	 Font f1 = new Font("Arial", Font.BOLD, 20);
	    	 e1=new JTextField();
	    	 e1.setBounds(350,480,120,50);
	    	 e1.setBackground(Color.blue);
	    	 e1.setFont(f1);
	    	 c.add(e1);
	    	 e1.addActionListener(this);
	     }
	     public void click() {
	    	 b1=new JButton("Sent");
	    	 b1.setBounds(360,550,100,30);
	    	 c.add(b1);
	    	 b1.addActionListener(this);
          }
	     public void restart()
		    {
			  Font f = new Font("Arial", Font.BOLD, 12);	      
				
			  r1=new JButton("Restart");
			  r1.setFont(f);   
			  r1.setForeground(Color.white);
			  r1.setBackground(Color.red);  
			  r1.setBounds(650,330,100,30);
			  c.add(r1);	  
		      r1.addActionListener(this);
		    }
	     
	   	 static Random r=new Random();
		     void add() {
			    int x=(int) (Math.random()*1000);
		        int y=(int) (Math.random()*100);
		        int z=x+y;
		        this.w=z;
		        System.out.println(x+"+"+y);
		        j1.setText(x+"+"+y);
		}
		     
		 void sub() {
			 int x=(int) (Math.random()*1000);
		        int y=(int) (Math.random()*100);
		        int z=x-y;
		        this.x=z;
		        System.out.println(x+"-"+y);
		        j1.setText(x+"-"+y);
		      
		        
		}
		void mul() {
			 int x=(int) (Math.random()*1000);
		        int y=(int) (Math.random()*100);
		        int z=x*y;
		        this.y=z;
		        System.out.println(x+"*"+y);
		        j1.setText(x+"*"+y);
	
		}
		 void div() {
			 int x=(int) (Math.random()*1000);
		        int y=(int) (Math.random()*100);
		        int z=x/y;
		        this.z=z;
		        j1.setText(x+"/"+y);
 
		}
	
		
	     public void actionPerformed(ActionEvent e) {
	    		if(e.getSource()==b) {
	    			
	    			int x=1+r.nextInt(4);
	    			
	    		switch(x) {
	    		case 1:
	    			add();
	    			break;
	    		case 2:
	    			sub();
	    			break;
	    		case 3:
	    			mul();
	    			break;
	    		case 4:
	    			div();
	    			break;
	    			
	    	      	}
	    		}
	    		else if(e.getSource()==b1) {
	    			String a=e1.getText();
                   
	    			if(a.equals(""+w)||a.equals(""+x)||a.equals(""+y)||a.equals(""+z)) {
	    				j1.setText("Congratulation");
	    				count=count+5;
	    				s.setText(""+count); 
	    				   try{ 	            	 
	  	                     Class.forName("com.mysql.jdbc.Driver");
	  	                     Connection con = DriverManager.getConnection(url, uname, passw);
	  	                     Statement s = con.createStatement();
	  	              
	  	                   
	  	                     String query = "UPDATE  math SET score=? WHERE pname= '"+hero+"'";
	  	                     PreparedStatement p = con.prepareStatement(query);	  
	  	                  
	  	                     p.setInt(1, this.count);	                    
	  	                     int count = p.executeUpdate();

	  	                     System.out.println(count + "rows affected :" + count);

	  	                 } catch (ClassNotFoundException | SQLException e1) {
	  	                     e1.printStackTrace();
	  	                      }                    	 
	    			             	}	    			
	    				else {
	    				j1.setText("Wrong answer");
	    						count=count-3;	
	                    s.setText(""+count);
	                    if(count<=0) {
	                    	j1.setText("Wrong answer");
		    				s.setText("");
		    			}
	                    try{ 	            	 
		                     Class.forName("com.mysql.jdbc.Driver");
		                     Connection con = DriverManager.getConnection(url, uname, passw);
		                     Statement s = con.createStatement();
		                     String query = "UPDATE  math SET score=? WHERE pname= '"+hero+"'";
		                     PreparedStatement p = con.prepareStatement(query);	  		                  
		                     p.setInt(1, this.count);	                    
		                     int count = p.executeUpdate();
		                 } catch (ClassNotFoundException | SQLException e1) {
		                     e1.printStackTrace();
		                 }        
	    			}
	    		}	    
	    		else if(e.getSource()==r1) {
	    			setVisible(false);
	    			Mathr r=new Mathr();
	    			r.head();
	    			r.score();
	    			r.play();
	    			r.disp();
	    			r.input();
	    			r.click();
	    			r.restart();
	    			r.back();
	    		}
	    		else if(e.getSource()==bc) {
	    			setVisible(false);
	    			mathr1 m=new mathr1();
	    			m.math();
	    			m.menu();
	    		    m.back();
	    		}
	    }
	
	     void suren(String name) {
	    	 this.hero=name;	    	 
	     }
	    
public static void main(String args[]) {
	Mathr r=new Mathr();
	r.head();
	r.score();
	r.play();
	r.disp();
	r.input();
	r.click();
	r.restart();
	r.back();
	 JOptionPane.showMessageDialog(null,"Game Name is"+r.tostring()+"Score is"+r.getscore());
    }
}
