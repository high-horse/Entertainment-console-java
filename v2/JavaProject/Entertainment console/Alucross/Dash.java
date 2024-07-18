package Alucross;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Dash extends JPanel{
	Container c;
	int score;
	String name,game;
	JLabel dfirst,dlast,dscore,demail,print,dgame;
	static String url = "jdbc:mysql://localhost:3306/Entertainment?useSSL=false";
	static String uname = "root";
	static String passw = "mutillidae";
	static String query;
	JTable t;
	JPanel k;
	
	//constructor 

	public void database()
	{
		 try {				
	  			query = "select * from alu where score =  (Select max(score) from alu)"; 
	  		
	  			ResultSet rs;
	  			Connection con = DriverManager.getConnection(url, uname, passw);
	  		    Statement s = con.createStatement();
	  			
	  			PreparedStatement p = con.prepareStatement(query);
	  			
	  			Class.forName("com.mysql.jdbc.Driver");
	  			con = DriverManager.getConnection(url, uname, passw);
	  			s = con.createStatement();
	  			p = con.prepareStatement(query);

	  			rs=p.executeQuery();
	  		    while(rs.next()) {
	
//	  			String user=rs.getInt(1)+":"+rs.getString(2)+":"+rs.getString(3)+":"+rs.getString(4)+":"+rs.getString(5)+":"+rs.getString(6)+":"+rs.getInt(7);
//	  			System.out.println(user);  				  
	  			this.name=rs.getString(2);
	  			this.game=rs.getString(3);
	  			this.score=rs.getInt(4);	 
	  		
	  			}
	  			s.close();
				con.close();
	  			     }   
	  			catch (ClassNotFoundException | SQLException e1){
	  				  e1.printStackTrace();
	  			}
	    	 }
	
public void suren()
{
	String column[]={"PlayerName","Game","score"};
	Object data[][]= {{name,game,""+score},};
	t=new JTable(data,column);
	t.setPreferredScrollableViewportSize(new Dimension(500,100));
	t.setFillsViewportHeight(true);
	JScrollPane sp=new JScrollPane(t);
	System.out.println("suren");
	add(sp);
	}


public static void main(String args[]) {
	Dash d=new Dash();
	JFrame j=new JFrame();
	j.setVisible(true);	 
	j.setBounds(410,5,800,600);
	j.setTitle("Entertainment Console");
	j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
j.add(d);
d.database();
d.suren();
}
}
