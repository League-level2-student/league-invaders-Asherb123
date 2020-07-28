import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
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

	Font fontTitle;
	Font titleFont;

	public GamePanel() {

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

	}
}
