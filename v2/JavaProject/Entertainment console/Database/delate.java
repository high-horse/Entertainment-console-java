package Database;

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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class delate extends JFrame implements ActionListener{
	JButton d,e1,b;
	Container c;
	JLabel n;
	JTextField f;
	String name,pass;
	static String url = "jdbc:mysql://localhost:3306/Entertainment?useSSL=false";
	static String uname = "root";
	static String passw = "mutillidae";
	static String query;
	
	JTextField loginuser1;
	JLabel loginuser; 
	void head() {
		Font f1=new Font("Arial",Font.BOLD,16);
	
		n=new JLabel("Name");
		n.setForeground(Color.white);
		n.setFont(f1);
		n.setBounds(100,100,100,40);
		
		f=new JTextField(10);
		f.setForeground(Color.black);
		n.setFont(f1);
		
		
		d=new JButton("Delete");
		d.setForeground(Color.white);
		d.setBackground(Color.red);
		
		e1=new JButton("Exit");
		e1.setForeground(Color.white);
		e1.setBackground(Color.red);
		
		b=new JButton("Back");
		b.setForeground(Color.white);
		b.setBackground(Color.red);
		
		setVisible(true);
		setTitle("Entertainent");	
		c=this.getContentPane();
        c.setBackground(Color.DARK_GRAY);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setBounds(500,150,500,500);
		setLayout(new FlowLayout(FlowLayout.CENTER,60,60));
		add(n);
		add(f);
		add(d);
		add(e1);
		add(b);
		f.addActionListener(this);	 
		d.addActionListener(this);
		e1.addActionListener(this);
		b.addActionListener(this);
	}
	void delet(){
		try 
		{   
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, passw);
		Statement s = con.createStatement();
		String name=f.getText();
		String query = ("drop table "+name+"");
		PreparedStatement p = con.prepareStatement(query);
		int count = p.executeUpdate();
	    }  
	    catch (ClassNotFoundException | SQLException e1) {
		e1.printStackTrace();
	 } 
	}


public void actionPerformed(ActionEvent e) {
if(e.getSource()==d) {
	delet();
	JOptionPane.showMessageDialog(null,"Sucesssufully Deleted");
}

else if(e.getSource()==e1) {
	JOptionPane.showMessageDialog(null,"thank u");
	setVisible(false);
	System.exit(0);

}
else if(e.getSource()==b) {
	setVisible(false);
	database d=new database();
	d.head();
	d.button1();
	d.button2();
	d.Entertainment();
	d.del();

}
}
public static void main(String args[]) {
	delate d=new delate();
	d.head();
	
}
}
