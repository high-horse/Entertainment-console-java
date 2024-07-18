package Alucross;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class menu extends JFrame implements ActionListener{
Container c;
JMenuItem open,exit,view,play,gamemenu;
JMenu file,Dashboard;

	void frame() {
		 setTitle("Alucross");
		 setSize(500,500);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setVisible(true);
	}
	
	void menu() {
		  JMenuBar jmb=new JMenuBar();
		  setJMenuBar(jmb);
		  file=new JMenu("File");
		  jmb.add(file);
		
		  
		  open=new JMenuItem("Restart");
		  file.add(open);
		  

		  exit=new JMenuItem("Exit");
		  file.add(exit); 
		  
		  play=new JMenuItem("Play");
		  file.add(play);
		  
		  gamemenu=new JMenuItem("Gamelist");
		  file.add(gamemenu);
		  
		  Dashboard=new JMenu("Dashboard");
		  jmb.add(Dashboard);
		  
		  view=new JMenuItem("View");
		  Dashboard.add(view); 
		  
		  open.addActionListener(this);
		  exit.addActionListener(this);
		  view.addActionListener(this);
	      play.addActionListener(this);
	      gamemenu.addActionListener(this);
	}
public static void main(String args[]) 
{	

  menu m=new menu();
  m.frame();
  m.menu();
 
  
}

@Override
public void actionPerformed(ActionEvent e) {
if(e.getSource()==open) {

}
else if(e.getSource()==exit) {
	System.out.println("exit");
}
else if(e.getSource()==view) {
	System.out.println("viewed");
}
	else if(e.getSource()==play) {
		System.out.println("Played");
	}
		else if(e.getSource()==gamemenu) {
			System.out.println("List");
		
}
}
}
