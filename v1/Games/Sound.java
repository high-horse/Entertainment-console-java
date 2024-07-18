package Games;

import java.awt.Container;
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
import javax.swing.JTextField;


public class Sound extends JFrame implements ItemListener,ActionListener{
	JComboBox j;
	Container c;
	JButton b;
	private Object clip;
	static  long endTime = System.currentTimeMillis() + 3000;
  	static Sound s=new Sound();
	void head() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400,40,700,500);
		c=this.getContentPane();
		c.setLayout(null);
	}
	void button() {
		b=new JButton("Stop");
		b.setBounds(100,30,130,30);
//		b. clip.stop();
		c.add(b);
		b.addActionListener(this);
		
	}

	void Combobox() {

		String track1="sounds\\akhil.wav";
		String track2="sounds\\tashi.wav";
		String track3="sounds\\s.wav";
		String track4="sounds\\suren.wav";
		
		String []file= {track1,track2,track3,track4};
		j=new JComboBox(file);
		j.setBounds(300,200,100,30);
		c.add(j);
		j.revalidate();
		j.addItemListener(this);
	
	}
	   void audio() {
          try {

              File file = new File("sounds//akhil.wav");
              File file1 = new File("sounds//tashi.wav");
              File file2 = new File("sounds//s.wav");
              File file3 = new File("sounds//suren.wav");     
             
              Clip clip = AudioSystem.getClip();
              clip.open(AudioSystem.getAudioInputStream(file1));
              clip.loop(Clip.LOOP_CONTINUOUSLY);
              clip.start();
     
             
  } catch (Exception e) {

          }
      }
public static void main(String args[]) {
	Sound s=new Sound();
	s.head();
	s.Combobox();
	s.button();
	
}
@Override
public void itemStateChanged(ItemEvent e) {
	
	if(e.getSource()==j) {
          
		 long endTime = System.currentTimeMillis() + 3000;
     	Sound s=new Sound();
     	
		if(j.getSelectedItem().equals("sounds\\akhil.wav"))
		{	
        	
        	
			 while (System.currentTimeMillis() < endTime) {	     
				
				 
		        	s.audio();	        

					
		        	}        	
		}
		
		else if(j.getSelectedItem().equals("sounds\\tashi.wav")) {	
			
			 while (System.currentTimeMillis() < endTime) 
			 {		    
	 
		        	s.audio();
		   	
				
		        	break;	        
		        	}			 				
		}
		
		else if(j.getSelectedItem().equals("sounds\\s.wav")) {		
			 while (System.currentTimeMillis() < endTime) 
			       {
				
		        	s.audio();	        	
		        	break;
		        	}
		}
	
		else if(j.getSelectedItem().equals("sounds\\suren.wav")) {		
			 while (System.currentTimeMillis() < endTime) {		
				
		        	s.audio();
		        	
		        	
		        	break;
		        	}
		}
		
		else
		{
			 dispose();
		}

	}
}
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==b) {
		if(j.getSelectedItem().equals("sounds\\akhil.wav"))
		{	
        	
        	
			 while (System.currentTimeMillis() < endTime) {	     
				 try {

		              File file = new File("sounds\\akhil.wav");
		              File file1 = new File("sounds\\tashi.wav");
		              File file2 = new File("sounds\\s.wav");
		              File file3 = new File("sounds\\suren.wav");          
		              Clip clip = AudioSystem.getClip();
		              clip.open(AudioSystem.getAudioInputStream(file1));
		              clip.loop(Clip.LOOP_CONTINUOUSLY);
		              clip.close();
		     
		             
		  } catch (Exception e1) {

		          }        
		   
					 break;
					
		        	}        	
		}
	}
	
}

    

}