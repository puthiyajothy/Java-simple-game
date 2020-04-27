import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;
import java.util.Timer;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public  class Gameplay extends JPanel implements KeyListener,ActionListener {
	private boolean play = false;
	private int score=0;
	
	private int totalBricks=0;
	
	private Timer timer;
	private int delay=8;
	
	private int playerX = 310;
	
	private int ballposX =120;
	private int ballposY =350;
	private int ballXdir =-1;
	private int ballYdir =-2;
	private int brickheight;
	private int brickWidth;
	private Object map;
	private int j;
	private int O;
	
	public Gameplay(String dalay) {
		MapGenerator map = new MapGenerator(3,7);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay,this);
		timer.start();
			
		
	}
	
Gameplay() {
		// TODO Auto-generated constructor stub
	}
public void paint (Graphics g) {
	//background color
	g.setColor(Color.black);
	g.fillRect(1, 1, 692,592);
	
	//drawing map 
	Map.draw((Graphics2D)g);
	
	//border color
	g.setColor(Color.yellow);
	g.fillRect(0, 0, 3, 592);
	g.fillRect(0, 0, 692, 3);
	g.fillRect(0, 0, 3, 592);
	
	//paddle
	g.setColor(Color.green);
	g.fillRect(playerX, 550, 100, 8);
	
	
	//score
	g.setColor(Color.white);
	g.setFont("serif",Font.BOLD,25);
	g.drawString(""+score, 590, 30);
	
	
	//ball
	g.setColor(Color.yellow);
	g.fillOval(ballposX, ballposY, 20, 20);
	
	if (totalBricks <=0) {
		play = false;
		ballXdir = 0;
		ballYdir = 0;
		g.setColor(Color.RED);
		g.setFont(new Font("serif",Font.BOLD,20));
		g.drawString("You WON",260, 300);
		
		g.setFont(new Font("serif",Font.BOLD,20));
		g.drawString("press ENTER FOR RESTART",230, 350);
		
	}
	
	if (ballposY > 570) {
		play = false;
		ballXdir=0;
		ballYdir=0;
		g.setColor(Color.RED);
		g.setFont(new Font("serif",Font.BOLD,20));
		g.drawString("You Over,Scores:"+score,260,300);
		
		g.setFont(new Font("serif",Font.BOLD,20));
		g.drawString("press ENTER FOR RESTART",230, 350);
		
	}
	
	g.dispose();
	
	
	
}

@Override
public void actionPerformed1(ActionEvent e) {
    timer.start();
	if(play) {
		if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))) {
			ballYdir = -ballYdir;
		}
		A:for(int i=0;i<map.map.length;i++) {
			for(int +i=0;j<map.map[0].length;j++){
				if(map.map[i][j]>0) {
					int brickX=j*map.brickWidth+80;
					int brickY=j*map.brickHeight+50;
					
					Rectangle rect=new Rectangle(brickX,brickY,brickWidth,brickheight);
					Rectangle ballRect=new Rectangle(ballposX,ballposY,20,20);
					Rectangle brickRect=rect;
					
					if (ballRect.intersects(brickRect)) {
						map.setBrickValue(0, i, j);
						totalBricks--;
						score+=5;
						if(ballposX+19<=brickRect.x||ballposX+1>=brickRect.x+brickRect.width) {
							ballXdir=-ballXdir;
							
						}else {
							ballYdir=-ballYdir;
						}
						
						break A;
					}
					
					
				}
				
			}
		}
		
		ballposX+=ballXdir;
		ballposY+=ballYdir;
		if(ballposX< 0) {
			ballXdir=-ballXdir;
			
			
		}
		if(ballposY<0) {
			ballYdir=-ballYdir;
			
		}
		if(ballposX>670) {
			ballXdir=-ballXdir;
			
		}
	}
	repaint();
	
}


@Override
public void keyPressed(KeyEvent e) {
	if (e.getKeyCode()==KeyEvent.VK_LEFT) {
		if(playerX<0) {
			playerX=0;
		}else {
			moveLeft();
			
		}
	}
	if(e.getKeyCode()==KeyEvent.VK_ENTER) {
		if(!play) {
			play=true;
			ballposX=120;
			ballposY=350;
			ballXdir=-1;
			ballYdir=-2;
			playerX=320;
			score=0;
			totalBricks=21;
			map = new.MapGenerator(3,7);
			repaint();
			
			
		}
	}
}
public void moveRight() {
	play=true;
	playerX+=20;
}
public void mveleft() {
	play=true;
	playerX-=20;
	
}

@Override
public void keyReleased(KeyEvent e) {}

@Override
public void keyTyped(KeyEvent e) {}

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
}

	
}
