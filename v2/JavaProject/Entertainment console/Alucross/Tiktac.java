//complete Tictac game
//java TicTacToe Created By Bikash Tamang

package Alucross;
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
import javax.swing.JPanel;
import javax.swing.JTextField;
import Games.gamelist;
import javax.swing.JOptionPane;


public class Tiktac extends JFrame implements ActionListener
{
	 
	int score8,score;
	private char player1;
	private char player2;
	private Container c;
	private JTextField text0,text1,text2,text3,text4,text5,text6,text7,text8,text9,textx,textz;
	char ar[]=new char[9];
	private JLabel player1x,player20,start,Winner,dfirst,dlast,demail,dscore;
	int count;
	static String name;//static use
	static String url = "jdbc:mysql://localhost:3306/Entertainment?useSSL=false";
	static String uname = "root";
	static String passw = "mutillidae";
	static String query;
	JPanel panel;
	JButton b,b1,bc;
	
	//constructor
  public void back() {
		
		bc=new JButton("Back");
		bc.setBounds(450,310,100,30);
		bc.setBackground(Color.white);
		bc.setForeground(Color.black);
		panel.add(bc);
		bc.addActionListener(this);		
		
	}          
  
  public  void Tiktac1()
   {
	panel=new JPanel();
	setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(400,50,700,650);
	c=this.getContentPane();
	setTitle("Alucross");
	JLabel label=new JLabel("TikTacToe");
	label.setForeground(Color.white);
	label.setBounds(150,20,200,50);
	Font f=new Font("Arial",Font.BOLD,30);
	label.setFont(f);
	c.add(label);
	panel.setBackground(Color.red);
	panel.setBounds(40,120,350,400);
	c.add(panel);
	panel.setLayout(null);
	
	
	b=new JButton("Newgame");
	b.setBounds(450,350,105,30);
	b.setForeground(Color.black);
	b.setBackground(Color.white);
	panel.add(b);
	b.addActionListener(this);
	
	Font f3=new Font("Arial",Font.BOLD,15);
	JLabel head=new JLabel("Choose the character(x or 0)");
	head.setFont(f3);
	head.setBounds(450,150,600,30);
	head.setForeground(Color.white);
	panel.add(head);

	start=new JLabel("Anyone can start:");
	start.setFont(f3);
	start.setBounds(450,270,600,30);
	start.setBackground(Color.black);
	start.setForeground(Color.white);
	panel.add(start);
	
	Winner =new JLabel("Winner");
	Winner.setFont(f3);
	Winner.setBounds(465,450,600,30);
	Winner.setForeground(Color.white);
	panel.add(Winner);
	textz=new JTextField();
	textz.setBackground(Color.black);
	textz.setForeground(Color.black);
	textz.setBounds(460,430,70,25);
	panel.add(textz);
	
	
	player1x=new JLabel("Player1:");
	player1x.setBounds(450,200,70,25);
	player1x.setForeground(Color.white);
	player1x.setBackground(Color.black);
	panel.add(player1x);
	
	text0=new JTextField();
	text0.setBackground(Color.black);
	text0.setForeground(Color.white);
    text0.setBounds(525,200,40,25);
    panel.add(text0);
       
    player20=new JLabel("Player2:");
	player20.setBounds(450,230,70,25);
	player20.setForeground(Color.white);
	player20.setBackground(Color.black);
	panel.add(player20);
	
	textx=new JTextField();
	textx.setBackground(Color.black);
    textx.setBounds(525,230,40,25);
    panel.add(textx);
    	
	text1=new JTextField();
	text1.setBackground(Color.gray);
	text1.setBounds(60,200,90,60);
	panel.add(text1);
	
	Font f1=new Font("Arial",Font.BOLD,50);
	text1.setBackground(Color.black);
	text1.setFont(f1);
	panel.add(text1);
	
	text2=new JTextField();
	text2.setBackground(Color.black);
	text2.setBounds(160,200,95,60);
	text2.setFont(f1);
	panel.add(text2);
	
	text3=new JTextField();
	text3.setBackground(Color.black);
	text3.setBounds(260,200,90,60);
    text3.setFont(f1);
	panel.add(text3);
	
    text4=new JTextField();
	text4.setBackground(Color.black);
	text4.setBounds(60,280,90,60);
	text4.setFont(f1);
	panel.add(text4);
	
	text5=new JTextField();
	text5.setBackground(Color.black);
	text5.setBounds(160,280,90,60);
	text5.setFont(f1);
	panel.add(text5);
	
	text6=new JTextField();
	text6.setBackground(Color.black);
	text6.setBounds(260,280,90,60);
	text6.setFont(f1);
	panel.add(text6);
	
	text7=new JTextField();
	text7.setBackground(Color.black);
	text7.setBounds(60,360,90,60);
	text7.setFont(f1);
	panel.add(text7);
	
	text8=new JTextField();
	text8.setBackground(Color.black);
	text8.setBounds(160,360,90,60);
	text8.setFont(f1);
	panel.add(text8);
	
	text9=new JTextField();
	text9.setBackground(Color.black);
	text9.setBounds(260,360,90,60);
	text9.setFont(f1);
	panel.add(text9); 

	text0.addActionListener(this);
	textx.addActionListener(this);
	text1.addActionListener(this);
	text2.addActionListener(this);
	text3.addActionListener(this);
	text4.addActionListener(this);
	text5.addActionListener(this);
	text6.addActionListener(this);
	text7.addActionListener(this);
	text8.addActionListener(this);
	text9.addActionListener(this);
}

//Winning Logic
int game()
{
	if(((ar[0]=='0')&&(ar[1]=='0'))&&((ar[1]=='0')&&(ar[2]=='0'))||((ar[0]=='0')&&(ar[3]=='0'))&&((ar[3]=='0')&&(ar[6]=='0'))||((ar[6]=='0')&&(ar[7]=='0'))&&((ar[7]=='0')&&(ar[8]=='0'))||((ar[8]=='0')&&(ar[5]=='0'))&&((ar[5]=='0')&&(ar[2]=='0'))||((ar[2]=='0')&&(ar[4]=='0'))&&((ar[4]=='0')&&(ar[6]=='0'))||((ar[0]=='0')&&(ar[4]=='0'))&&((ar[4]=='0')&&(ar[8]=='0'))||((ar[3]=='0')&&(ar[4]=='0'))&&((ar[4]=='0')&&(ar[5]=='0'))||((ar[1]=='0')&&(ar[4]=='0'))&&((ar[4]=='0')&&(ar[7]=='0')))
	{
		return 1;
			
	}
	if(((ar[0]=='x')&&(ar[1]=='x'))&&((ar[1]=='x')&&(ar[2]=='x'))||((ar[0]=='x')&&(ar[3]=='x'))&&((ar[3]=='x')&&(ar[6]=='x'))||((ar[6]=='x')&&(ar[7]=='x'))&&((ar[7]=='x')&&(ar[8]=='x'))||((ar[8]=='x')&&(ar[5]=='x'))&&((ar[5]=='x')&&(ar[2]=='x'))||((ar[2]=='x')&&(ar[4]=='x'))&&((ar[4]=='x')&&(ar[6]=='x'))||((ar[0]=='x')&&(ar[4]=='x'))&&((ar[4]=='x')&&(ar[8]=='x'))||((ar[3]=='x')&&(ar[4]=='x'))&&((ar[4]=='x')&&(ar[5]=='x'))||((ar[1]=='x')&&(ar[4]=='x'))&&((ar[4]=='x')&&(ar[7]=='x')))
	{
		return 2;
	}
	return 0;
	
}

public void actionPerformed(ActionEvent e)
{
	//logic of x and 0
	count++;

	if(e.getSource()==text0)
	{   
		
	String text=text0.getText();
    if(text.equalsIgnoreCase("0"))
    {
		this.player1='0';	
		this.player2='x';
		
		textx.setForeground(Color.white);
        textx.setText("x");
    }
	
	else if(text.equalsIgnoreCase("X"))
	{
		this.player1='x';
		this.player2='0';
		
		textx.setForeground(Color.white);
		textx.setText("0");
	}
	else
	{
	  
	   textx.setText("Error");	
	}
}
    if(e.getSource()==textx)
    {
String text=textx.getText();
if(text.equalsIgnoreCase("X"))
{
	this.player2='x';
	this.player1='0';
	
	text0.setForeground(Color.white);
	text0.setText("0");
	
}
else if(text.equalsIgnoreCase("0"))
{
	this.player2='0';
	this.player1='x';
	
	text0.setForeground(Color.white);
	text0.setText("X");

}
else
{
	
	text0.setText("Error");
}
    }
//Actual game logic

if(e.getSource()==text1) 
{	
	String text=text1.getText();
	
    if(text.equalsIgnoreCase(""+player1)) {
    text1.setForeground(Color.white);
    text1.setText(text);
	ar[0]=text.charAt(0);
    }
    else if(text.equalsIgnoreCase(""+player2))
    {
    text1.setForeground(Color.white);
    text1.setText(text);
    ar[0]=text.charAt(0);
    }
    else
    {
    	text1.setText("");
    }
    
}
if(e.getSource()==text2) 
{	
	String text=text2.getText();
	
    if(text.equalsIgnoreCase(""+player1)) {
    	 text2.setForeground(Color.white);
    text2.setText(text);
  
    ar[1]=text.charAt(0);
    }
    else if(text.equalsIgnoreCase(""+player2))
    {
    text2.setForeground(Color.white);
    text2.setText(text);
   
    ar[1]=text.charAt(0);
    }
    else
    {
    	text2.setForeground(Color.white);
    	text2.setText("");
    	
    }
    
}

if(e.getSource()==text3) 
{	
	String text=text3.getText();
	
    if(text.equalsIgnoreCase(""+player1)) {
    	text3.setForeground(Color.white);
    text3.setText(text);
    ar[2]=text.charAt(0);
    }
    else if(text.equalsIgnoreCase(""+player2))
    {
    	text3.setForeground(Color.white);
    text3.setText(text);
    ar[2]=text.charAt(0);
    }
    else
    {
    	text3.setForeground(Color.white);
    	text3.setText("");
    }
    
}
if(e.getSource()==text4) 
{	
	String text=text4.getText();
	
    if(text.equalsIgnoreCase(""+player1)) {
    	text4.setForeground(Color.white);
    text4.setText(text);
    ar[3]=text.charAt(0);
    }
    else if(text.equalsIgnoreCase(""+player2))
    {
    	text4.setForeground(Color.white);
    text4.setText(text);
    ar[3]=text.charAt(0);
    }
    else
    {
    	text4.setText("");
    }
    
}
if(e.getSource()==text5) 
{	
	String text=text5.getText();
	
    if(text.equalsIgnoreCase(""+player1)) {
    text5.setForeground(Color.white);
    text5.setText(text);
    ar[4]=text.charAt(0);
    }
    else if(text.equalsIgnoreCase(""+player2))
    {
    text5.setForeground(Color.white);
    text5.setText(text);
    ar[4]=text.charAt(0);
    }
    else
    {
    	text5.setForeground(Color.white);
    	text5.setText("");
    }
    
}
if(e.getSource()==text6) 
{	
	String text=text6.getText();
	
    if(text.equalsIgnoreCase(""+player1)) {
    text6.setForeground(Color.white);
    text6.setText(text);
    ar[5]=text.charAt(0);
    }
    else if(text.equalsIgnoreCase(""+player2))
    {
    text6.setForeground(Color.white);
    text6.setText(text);
    ar[5]=text.charAt(0);
    }
    else
    {
    	text6.setText("");
    }
    
}
if(e.getSource()==text7) 
{	
	String text=text7.getText();
	
    if(text.equalsIgnoreCase(""+player1)) {
    text7.setForeground(Color.white);
    	 
    text7.setText(text);
    ar[6]=text.charAt(0);
    }
    else if(text.equalsIgnoreCase(""+player2))
    {
    text7.setForeground(Color.white);
    text7.setText(text);
    ar[6]=text.charAt(0);
    }
    else
    {
    	text7.setText("");
    }
    
}
if(e.getSource()==text8) 
{	
	
	String text=text8.getText();
	
    if(text.equalsIgnoreCase(""+player1)) {
    text8.setForeground(Color.white);	
    text8.setText(text);
    ar[7]=text.charAt(0);
    }
    else if(text.equalsIgnoreCase(""+player2))
    {
    text8.setForeground(Color.white);
    text8.setText(text);
    ar[7]=text.charAt(0);
    }
    else
    {
    	text8.setText("");
    }   
}
if(e.getSource()==text9) 
{	
	String text=text9.getText();	
    if(text.equalsIgnoreCase(""+player1)) {
    text9.setForeground(Color.white);
    text9.setText(text);
    ar[8]=text.charAt(0);
    }
    
    else if(text.equalsIgnoreCase(""+player2))
    {
    text9.setForeground(Color.white); 	
    text9.setText(text);
    ar[8]=text.charAt(0);
    }
    else
    {
    	text9.setText("");
    }   
}

//Winning logic

int c=game();
if(c==1) {
	if(player1=='0') {
    textz.setForeground(Color.white);
	textz.setText("Player 1");	
	this.score++;
	database();
	}
	if(player2=='0') {
		 textz.setForeground(Color.white);	
		textz.setText("Player 2");
		this.score++;
		database();
}
	}
else if(c==2){
	if(player1=='x') {
		 textz.setForeground(Color.white);
		textz.setText("Player 1");
		this.score++;
		database();
	}
	
	if(player2=='x') {
		 textz.setForeground(Color.white);
		textz.setText("Player 2");
		this.score++;
		database();
	}
}

 if(count==10){
	textz.setForeground(Color.white);
	textz.setText("Draw");
	database();

}
 if(e.getSource()==b)
 {
setVisible(false);
Tiktac game1=new Tiktac();
game1.Tiktac1();
 }
 else if(e.getSource()==bc) {
		setVisible(false);
		Tiktac1 t=new Tiktac1();
	 	t.alu();
	 	t.menu();
	 	t.back();
}
}
//update
void database(){
    try{   
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection(url, uname, passw);
    Statement s = con.createStatement();
    String query = "UPDATE  alu SET score=? WHERE pname= '"+name+"'";
    PreparedStatement p = con.prepareStatement(query);    
    p.setInt(1, this.score);
    int count = p.executeUpdate();
	System.out.println(this.name);
    System.out.println(count + "rows affected :" + count);

} catch (ClassNotFoundException | SQLException e1) {
    e1.printStackTrace();
  }        
}

void suren(String name)
{
	this.name=name;
System.out.println(this.name);
}

//public static void main(String[] args)
//{
//Tiktac game=new Tiktac();
//game.Tiktac1();
//game.back();
//}
}
