import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {
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

	
	
	
		
		
		
	
	  
		
	
	Timer frameDraw; 
	Font fontTitle;
	Font titleFont;

	public GamePanel() {
		frameDraw = new Timer(1000/60, this);
		frameDraw.start();
		
	    titleFont = new Font("Arial", Font.PLAIN, 48);

		fontTitle = new Font("Arial", Font.PLAIN, 30);

	}
	
	
	
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;

	int currentState = MENU;

	void updateMenuState() {

	}

	void updateGameState() {

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
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HIEGHT);

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
	System.out.println("action");
	
	}
}
