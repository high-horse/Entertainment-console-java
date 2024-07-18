//play again option
package BrickBreaker;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Timer;

import javax.swing.JPanel;
public class Gameplay extends JPanel implements KeyListener, ActionListener{
	static String url = "jdbc:mysql://localhost:3306/Entertainment?useSSL=false";
	static String uname = "root";
	static String passw = "mutillidae";
	static String query;
	private boolean play = false;
	private int score;

	private int totalBricks = 21;
	static String name;
	private Timer timer;
	private int delay = 5;//speed of ball
	
	private int playerX = 310;	
	private int ballposX = 120;
	private int ballposY = 350;
	private int ballXdir = -1;
	private int ballYdir = -2;
	
	private MapGenerator map;
	
	public Gameplay() {
		map = new MapGenerator(3, 7);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay,this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		//background
		g.setColor(Color.black);
		g.fillRect(1,1, 692, 592);
		
		//drawing map
		map.draw((Graphics2D)g);
		
		//borders
		g.setColor(Color.yellow);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691, 0, 3, 592);
		
		//scores
		g.setColor(Color.white);
		g.setFont(new Font("serif", Font.BOLD, 25));
		g.drawString(""+score,500, 30);
		
		//the paddle
		g.setColor(Color.green);
		g.fillRect(playerX, 550, 100, 8);
		
		//the ball
		g.setColor(Color.yellow);
		g.fillOval(ballposX, ballposY, 20, 20);
		
		//win condition
		if(totalBricks == 0) {
			play = false;
			ballXdir = 0;
			ballYdir = 0;
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("You Won !!! \nScore = " +score, 200, 300);
			
	
		}
		
		//gameover
		if(ballposY > 570) {
			
			play = false;
			ballXdir = 0;
			ballYdir = 0;
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 30));
			
			g.drawString("Game Over, Score = "+score, 190, 300);
	
	database();
	System.exit(0);

		g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Press ENTER to restart ", 290, 350);
		}	
	}	
	void database()
	{
		  try{   
			    Class.forName("com.mysql.jdbc.Driver");
			    Connection con = DriverManager.getConnection(url, uname, passw);
			    Statement s = con.createStatement();
			    String query = "UPDATE  brick SET score=? WHERE pname= '"+name+"'";
			    PreparedStatement p = con.prepareStatement(query);    
			    p.setInt(1, this.score);
			    int count = p.executeUpdate();
				System.out.println(this.name);
				System.out.println(this.score);
			    System.out.println(count + "rows affected :" + count);

			} catch (ClassNotFoundException | SQLException e1) {
			    e1.printStackTrace();
			  }        
	}
	void suren(String name) {
		this.name=name;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//movement of the ball
		timer.start();
		if(play) {
			//to detect intersection, create rectangle around the ball
			//detecting intersection between the ball and paddle
			if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))) {
				ballYdir = -ballYdir;
			}			
			//first map is above "private MapGenerator map" and second map is "public int map[][];" of class MapGenerator
			//(like obj.array)
			A: for(int i = 0; i< map.map.length; i++) {
				for (int j=0; j < map.map[0].length; j++) {
					if(map.map[i][j] > 0) {
						int brickX =j*map.brickWidth + 80;
						int brickY = i*map.brickHeight + 50;
						int brickWidth = map.brickWidth;
						int brickHeight = map.brickHeight;
						
						Rectangle  rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
						Rectangle ballRect = new Rectangle(ballposX, ballposY, 20, 20);
						Rectangle brickRect = rect;
						
						if(ballRect.intersects(brickRect)) {
							map.setBrickValue(0, i, j);
							totalBricks--;
							score += 5;
							
							//left and right intersection
							if(ballposX + 19 <= brickRect.x || ballposX + 1 >= brickRect.x + brickRect.width) {
								ballXdir = -ballXdir;
							}
							else {
								ballYdir = -ballYdir;
							}
							
							break A;
						}
					}
				}
			}
			
			
			
			ballposX += ballXdir;
			ballposY += ballYdir;
			//left
			if(ballposX < 0) {
				ballXdir = -ballXdir;
			}
			//top
			if(ballposY < 0) {
				ballYdir = -ballYdir;
			}
			//right
			if(ballposX >670 ) {
				ballXdir = -ballXdir;
			}
		}
		
		//to recall above paint method in new co-ordinates
		repaint();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		//movement of paddle
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(playerX >= 600) {
				playerX = 600;
			}
			else {
				moveRight();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(playerX < 10) {
				playerX = 10;
			}
			else {
				moveLeft();
			}
		}
		//play again enter 
//		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
//			if(play) {
//				ballposX= 120;
//				ballposY = 350;
//				ballXdir = -1;
//				ballYdir = -2;
//				playerX = 310;
//				score = 0;
//				totalBricks = 21;
//				map = new MapGenerator(3, 7);				
//				repaint();
//			}
		}
		
		
	
	
	public void moveRight() {
		play = true;
		playerX += 60;	
	}
	public void moveLeft() {
		play = true;
		playerX -= 60;	
	}



}

