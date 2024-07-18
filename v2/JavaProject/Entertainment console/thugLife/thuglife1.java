package thugLife;

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
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import Database.Signlogin;
import Games.gamelist;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class thuglife1 extends JFrame implements ActionListener{
	 static String hero;
	 String name3,rl="chippad";
	 String name4,name5,name6;
	 int score8;
	 static String url = "jdbc:mysql://localhost:3306/Entertainment?useSSL=false";
	 static String uname = "root";
	 static String passw = "mutillidae";
	 static String query;
	 private JLabel j, p1, c1, s,dfirst,dlast,demail,dscore,r0;
	 private JTextField f1, f2, f3, p, m, s1;//m=cash,p=power
	 private JButton b, exit,b1,r1,bc;
	 private int score;
	 private int cash;
	 private int power=30;
	 static Random r = new Random(); //static use
	 String name[] = new String[] {
	        "Gun",
	        "Money",
	        "Thief",
	        "Power"
	    };
	    Container c;

	    //encapsulation

	    public void head() {
	        setVisible(true);
	        setTitle("Entertainment Console");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(300, 100, 800, 500);
	        c = this.getContentPane();
	        c.setBackground(Color.black);
	        c.setLayout(null);
	        Font f = new Font("Arial", Font.BOLD, 30);
	        j = new JLabel("ThugLife");
	        j.setFont(f);
	        j.setForeground(Color.red);
	        c.add(j);
	        j.setBounds(330, 80, 900, 150);
	        c.add(j);
	    }
	
	    public void fram() {

	        f1 = new JTextField();
	        f1.setBounds(240, 200, 100, 200);
	        f1.setBackground(Color.red);
	        c.add(f1);
	        f1.addActionListener(this);
	        f2 = new JTextField();
	        f2.setBounds(360, 200, 100, 200);
	        f2.setBackground(Color.red);
	        c.add(f2);
	        f2.addActionListener(this);
	        f3 = new JTextField();
	        f3.setBounds(480, 200, 100, 200);
	        f3.setBackground(Color.red);
	        c.add(f3);
	        f3.addActionListener(this);

	    }
	    
	    public void button() {
	        Font f = new Font("Arial", Font.BOLD, 17);
	        b = new JButton("Click");
	        b.setBounds(360, 420, 100, 40);
	        b.setFont(f);
	        b.setForeground(Color.white);
	        b.setBackground(Color.red);
	        c.add(b);
	        b.addActionListener(this);
	    }

	    public void power() {

	        p1 = new JLabel("Power");
	        p1.setBounds(110, 275, 100, 40);
	        Font f = new Font("Arial", Font.BOLD, 17);
	        p1.setForeground(Color.white);
	        p1.setFont(f);
	        c.add(p1);

	        p = new JTextField();
	        p.setBounds(100, 243, 100, 40);
	        p.setFont(f);
	        p.setForeground(Color.white);
	        p.setBackground(Color.red);
	        p.setText(""+this.power);
	        c.add(p);
	        p.addActionListener(this);
	    }

	    public void cash() {
	        c1 = new JLabel("Cash");
	        c1.setBounds(250, 70, 100, 40);
	        Font f = new Font("Arial", Font.BOLD, 15);
	        c1.setFont(f);
	        c1.setForeground(Color.white);
	        c.add(c1);

	        m = new JTextField();
	        m.setBounds(230, 40, 100, 40);
	        m.setFont(f);
	        m.setForeground(Color.white);
	        m.setBackground(Color.red);
	        c.add(m);
	        m.addActionListener(this);
	    }

	    public void score() {
	        s = new JLabel("Score");
	        s.setBounds(509, 70, 100, 40);
	        Font f = new Font("Arial", Font.BOLD, 15);
	        s.setFont(f);
	        s.setForeground(Color.white);
	        c.add(s);

	        s1 = new JTextField();
	        s1.setBounds(484, 40, 100, 40);
	        s1.setFont(f);
	        s1.setForeground(Color.white);
	        s1.setBackground(Color.red);
	        c.add(s1);
	        s1.addActionListener(this);
	    }
	  
	    public int a1() {
	        String a1;
	        int a = r.nextInt(name.length);
	        Font f = new Font("Arial", Font.BOLD, 25);
	        a1 = name[a];
	        f1.setFont(f);
	        f1.setForeground(Color.white);
	        f1.setText(a1);
	        f1.addActionListener(this);
	        if (a1.equals("Gun")) {
	            return 1;
	        }
	        if (a1.equals("Money")) {
	            return 2;
	        }
	        if (a1.equals("Thief")) {
	            return 3;
	        }
	        if (a1.equals("Power")) {
	            return 4;
	        }
	        return 0;
	    }

	    public int a2() {
	        String b1;
	        int b = r.nextInt(name.length);
	        b1 = name[b];
	        Font f = new Font("Arial", Font.BOLD, 25);
	        f2.setForeground(Color.white);
	        f2.setFont(f);
	        f2.setText(b1);
	        f2.addActionListener(this);
	        if (b1.equals("Gun")) {
	            return 1;
	        }
	        if (b1.equals("Money")) {
	            return 2;
	        }
	        if (b1.equals("Thief")) {
	            return 3;
	        }
	        if (b1.equals("Power")) {
	            return 4;
	        }
	        return 0;
	    }

	    public int a3() {
	        String c1;
	        int c = r.nextInt(name.length);
	        c1 = name[c];
	        Font f = new Font("Arial", Font.BOLD, 25);
	        f3.setFont(f);
	        f3.setForeground(Color.white);
	        f3.setText(c1);
	        f3.addActionListener(this);
	        if (c1.equals("Gun")) {
	            return 1;
	        }
	        if (c1.equals("Money")) {
	            return 2;
	        }
	        if (c1.equals("Thief")) {
	            return 3;
	        }
	        if (c1.equals("Power")) {
	            return 4;
	        }
	        return 0;
	    }
	    
	    public void back() {
	    	Font f = new Font("Arial", Font.BOLD, 12);
			bc=new JButton("Back");
			bc.setFont(f);
			bc.setBounds(695,230,130,30);
			bc.setBackground(Color.red);
			bc.setForeground(Color.white);
			c.add(bc);
			bc.addActionListener(this);			
		}
	    
	  public void restart()
	    {
		  Font f = new Font("Arial", Font.BOLD, 12);	      			
		  r1=new JButton("Restart");
		  r1.setFont(f);   
		  r1.setForeground(Color.white);
		  r1.setBackground(Color.red);  
		  r1.setBounds(695,300,120,40);
		  c.add(r1);	  
	      r1.addActionListener(this);
	    }
	
	    public void actionPerformed(ActionEvent e) {
		
	    	  if (e.getSource() == b){
	    		  this.power--;
	    		  p.setText(""+this.power);
	              int suren1 = a1();
	              int suren2 = a2();
	              int suren3 = a3();
	              
	          if (suren1 == 1 && suren2 == 1 && suren3 == 1) {
	                  this.cash = this.cash + 50000;
	                  m.setText(""+this.cash);
	                  
	              }
	          else if (suren1 == 2 && suren2 == 2 && suren3 == 2) {
	                  this.cash = this.cash + 100000;
	                  m.setText(""+this.cash);
	                  
	              }
	          else if (suren1 == 3 && suren2 == 3 && suren3 == 3) {
	                  this.cash = this.cash + 2000000;
	                  m.setText(""+this.cash);
	                  
	              } 
	          else if (suren1 == 4 && suren2 == 4 && suren3 == 4) {
	            	  this.cash=this.cash+3000;
	            	  m.setText(""+this.cash);
	                  this.power = this.power + 30;
	                  p.setText(""+this.power);
	                }
	          else if(this.cash<=10000&&this.cash<20000) {
	            	  this.score=score+1;
	            	  this.cash=this.cash+3000;
	            	  s1.setText(""+this.score);
	            	  m.setText(""+this.cash);
	            	
	              }
	          else if(this.cash>=20000&&this.cash<40000) {
	            	  this.score=this.score+5;
	            	  this.cash=this.cash+3000;
	            	  s1.setText(""+this.score);
	             	  m.setText(""+this.cash);
	             	  
	              }
	          else if(this.cash>=40000&&this.cash<60000) {
	            	  this.score=this.score+5;
	            	  this.cash=this.cash+3000;
	            	  s1.setText(""+this.score);
	             	  m.setText(""+this.cash);
	              }
	         else if(this.cash>=60000&&this.cash<80000) {
	            	  this.score=this.score+5;
	            	  this.cash=this.cash+3000;
	            	  s1.setText(""+this.score);
	             	  m.setText(""+this.cash);
	              }
	         else if(this.cash>=80000&&this.cash<100000) {
	            	  this.cash=this.cash+3000;
	            	 
	            	  s1.setText(""+this.score);
	             	  m.setText(""+this.cash);
	              }
	         else if(this.cash>=100000&&this.cash<300000){
	            	  this.score=this.score+7;
	            	  this.cash=this.cash+3000;
	            	  s1.setText(""+this.score);
	             	  m.setText(""+this.cash);
	              }
	        else if(this.cash>=300000&&this.cash<700000) {
	            	  this.score=this.score+7;
	            	  this.cash=this.cash+3000;
	            	  s1.setText(""+this.score);
	             	  m.setText(""+this.cash);
	              }
	       else if(this.cash>=700000&&this.cash<1000000){
	            	  this.score=this.score+7;
	            	  this.cash=this.cash+3000;
	            	  s1.setText(""+this.score);
	             	  m.setText(""+this.cash);
	              }
	       else if(this.cash>=10000000){	            	  
	            	  this.cash=this.cash+3000;
	            	  s1.setText("Won");
	             	  m.setText(""+this.cash);
	              }
	        if(this.power<=0){	  
	            	   
	            	  p.setText("No Power");
	            	  m.setText("");
	            	  f1.setText("");
	            	  f2.setText("");
	            	  f3.setText("");
	            	  s1.setText("");	        
	            	  
	            	   try{ 	            	 
	                     Class.forName("com.mysql.jdbc.Driver");
	                     Connection con = DriverManager.getConnection(url, uname, passw);
	                     Statement s = con.createStatement();
	                    
	                   
	                     String query = "UPDATE  thug SET score=? WHERE pname= '"+hero+"'";
	                     PreparedStatement p = con.prepareStatement(query);	  
	                  
	                     p.setInt(1, this.score);	                    
	                     int count = p.executeUpdate();

	                     System.out.println(count + "rows affected :" + count);

	                 } catch (ClassNotFoundException | SQLException e1) {
	                     e1.printStackTrace();
	                 }        
//          	 
	            	  
	             }    	 
      else {
		      this.cash=this.cash+3000;
		      m.setText(""+this.cash);
		              }	            	 
	              }      
      	if(e.getSource()==r1)
	    	{
	    		setVisible(false);
	    		thuglife1 t1=new thuglife1();
	    		t1.head();
	    		t1.fram();
	    		t1.button();
	    		t1.score();
	    		t1.cash();
	    		t1.power();
	    		t1.restart();
	    		t1.back();
	    	}
    	else if(e.getSource()==bc) {
			setVisible(false);
			thuglife2 t=new thuglife2();
			t.thugg();
			t.menu();
			t.back();
		}
	     }
	    void anil(String name)
	    {
	    	this.hero=name;
	    }
	  
	public static void main(String args[])
	{
		
		thuglife1 t=new thuglife1();
		
		t.head();
		t.fram();
		t.button();
		t.score();
		t.cash();
		t.power();		
		t.restart();
		t.back();
	}
}
