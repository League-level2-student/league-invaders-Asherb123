import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}

	}

	
	
		
		
		
	
	  
	  Rocketship rocketship;
	Timer alienSpawn;
	Timer frameDraw; 
	Font fontTitle;
	Font titleFont;
	ObjectManager objectManager;

	public GamePanel(int x, int y, int width, int height) {
		frameDraw = new Timer(1000/60, this);
		frameDraw.start();
		
	    titleFont = new Font("Arial", Font.PLAIN, 48);

		fontTitle = new Font("Arial", Font.PLAIN, 30);

		 rocketship = new Rocketship(250, 700, 50, 50);
		 
		objectManager = new ObjectManager(rocketship);
		if (needImage) {
		    loadImage ("space.png");
		}
	}
	
	
	
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;

	int currentState = MENU;

	void updateMenuState() {

	}

	void updateGameState() {
		objectManager.update();;
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HIEGHT);

		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("LEAGUE INVADERS", 25, 200);

		g.setFont(fontTitle);
		g.setColor(Color.white);
		g.drawString("Press ENTER to Start", 100, 400);

		g.setFont(fontTitle);
		g.setColor(Color.WHITE);
		g.drawString("Press SPACE for Instructions", 50, 500);

		
	}

	
	
	
	void drawGameState(Graphics g) {
		//g.setColor(Color.BLACK);
	//	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HIEGHT);
		if (gotImage) {
			g.drawImage(image,  WIDTH, HEIGHT, null);
		} else {
			g.setColor(Color.BLUE);
			
		}
		
		objectManager.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HIEGHT);
		
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("GAME OVER", 25, 200);
		g.setColor(Color.white);
		g.drawString("HAHA! You suck!", 100, 400);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		    
		}
	//System.out.println("action");
	repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		      
		    } else if( currentState==GAME){
		       currentState=END;
		       alienSpawn.stop();
		     }
		    else {
				currentState++;
				  startGame();
			}
		}   
		if (e.getKeyCode()== KeyEvent.VK_SPACE) {
			objectManager.addProjectile(rocketship.getProjectile());
		}
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    System.out.println("UP");
		    	rocketship.up(); 
		       
		    
		}
		else if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			System.out.println("Down");
			rocketship.down();
		}
		else if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			System.out.println("Left");
			rocketship.left();
		}
		else if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			System.out.println("Right");
			rocketship.right();    
		}
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	void startGame(){
		
		alienSpawn = new Timer(1000 , objectManager);
	    alienSpawn.start();
		
		
	}
}
