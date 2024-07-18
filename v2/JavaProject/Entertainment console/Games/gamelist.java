package Games;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Alucross.Tiktac1;
import BrickBreaker.Brick1;
import Database.database;
import Mathrace.Mathr;
import Mathrace.mathr1;
import thugLife.thuglife2;

public class gamelist extends JFrame implements ActionListener,ItemListener{
	JLabel loginuser,loginpass,enter;
	JTextField loginuser1,loginpass1;
	JButton b1,b2,b3,b4,m,b,bc;
	Container c;
    JComboBox j;
    public void back() {
		bc=new JButton("Back");
		bc.setBounds(650,150,100,30);
		bc.setBackground(Color.red);
		bc.setForeground(Color.white);
		c.add(bc);
		bc.addActionListener(this);
		
	}
	
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
		Font f1=new Font("Arial",Font.BOLD,25);
		enter =new JLabel("Entertainment Console");
		enter.setFont(f1);
		enter.setBounds(130,5,400,200);
		enter.setForeground(Color.white);
		c.add(enter);	
	}
	public void Alu() {
		Font f1=new Font("Arial",Font.BOLD,15);
		b1=new JButton("TicTacToe");
		b1.setFont(f1);
		b1.setBounds(130,250,150,35);
		b1.setForeground(Color.white);
		b1.setBackground(Color.red);
		b1.addActionListener(this);
		c.add(b1);	
	}
	public void Thug() {
		Font f1=new Font("Arial",Font.BOLD,15);
		b2=new JButton("ThugLife");
		b2.setFont(f1);
		b2.setBounds(130,300,150,35);
		b2.setForeground(Color.white);
		b2.setBackground(Color.red);
		b2.addActionListener(this);
		c.add(b2);	
	}
	public void Brickbreaker() {
		Font f1=new Font("Arial",Font.BOLD,15);
		b3=new JButton("Brickbreaker");
		b3.setFont(f1);
		b3.setBounds(130,350,150,35);
		b3.setForeground(Color.white);
		b3.setBackground(Color.red);
		b3.addActionListener(this);
		c.add(b3);	
	}
	public void Mathmatical() {
		Font f1=new Font("Arial",Font.BOLD,15);
		b4=new JButton("Math Race");
		b4.setFont(f1);
		b4.setBounds(130,400,150,35);
		b4.setForeground(Color.white);
		b4.setBackground(Color.red);
		b4.addActionListener(this);
		c.add(b4);	
	}
	 void audio() 
	 {
         try {

             File file = new File("sounds\\akhil.wav");
             File file1 = new File("sounds\\tashi.wav");
             File file2 = new File("sounds\\s.wav");
             File file3 = new File("sounds\\suren.wav");          
             Clip clip = AudioSystem.getClip();
             clip.open(AudioSystem.getAudioInputStream(file));
             clip.loop(Clip.LOOP_CONTINUOUSLY);
             clip.start();          
 } catch (Exception e) {
         }
     }
	 
	public void music() {
		Font f1=new Font("Arial",Font.BOLD,15);
		m=new JButton("music");
		m.setFont(f1);
		m.setBounds(650,240,100,35);
		m.setForeground(Color.white);
		m.setBackground(Color.red);
		m.addActionListener(this);
		c.add(m);	
	}
	public void Combobox() {		
		String []color= {"Red","Black","Blue","Green","Yellow","Gray","Orange"};
		j=new JComboBox(color);
		j.setBounds(650,280,100,30);
		j.setForeground(Color.white);
		j.setBackground(Color.red);
		c.add(j);
		j.revalidate();
		j.addItemListener(this);	
	}
	
	public void actionPerformed(ActionEvent e) {
	if(e.getSource()==b1)
	   {				
		JOptionPane.showMessageDialog(null,"Sucessfully Loaded");
		setVisible(false);
		Tiktac1 t=new Tiktac1();
	 	t.alu();
	 	t.menu();
	 	t.back();
	   }
	else if(e.getSource()==b2)
	{
		JOptionPane.showMessageDialog(null,"Sucessfully Loaded");
		setVisible(false);
		thuglife2 t=new thuglife2();
		t.thugg();
		t.menu();
		t.back();
	}
	else if(e.getSource()==b3)
	{
		JOptionPane.showMessageDialog(null,"Sucessfully Loaded");
		setVisible(false);
		Brick1 b=new Brick1();
		b.brick();
		b.dash();
		b.menu();
		b.back();
	}
	else if(e.getSource()==b4) {
		 JOptionPane.showMessageDialog(null,"Sucessfully Loaded");
		 setVisible(false);
			mathr1 m=new mathr1();
			m.math();
			m.menu();
			m.back();
	}
	else if(e.getSource()==m) {
		 
		long endTime = System.currentTimeMillis() + 500;
	     Sound s=new Sound();
	     		 while (System.currentTimeMillis() < endTime) {	     		 
			        	s.audio();	        				
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
	}
	
	
	public static void main(String args[])
	{
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
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==j) {
			if(j.getSelectedItem().equals("Red")) {
				c.setBackground(Color.red);
			}
			else if(j.getSelectedItem().equals("Blue")) {
				c.setBackground(Color.blue);
			}
			else if(j.getSelectedItem().equals("Black")) {
				c.setBackground(Color.black);
			}
			else if(j.getSelectedItem().equals("Green")) {
				c.setBackground(Color.green);
			}
			else if(j.getSelectedItem().equals("Yellow")) {
				c.setBackground(Color.yellow);
			}
			else if(j.getSelectedItem().equals("Orange")) {
				c.setBackground(Color.orange);
			}
			else if(j.getSelectedItem().equals("Gray")) {
				c.setBackground(Color.gray);
			}
			else {
				JOptionPane.showMessageDialog(null,"No Color");
			}
		}
		
	}
	
}