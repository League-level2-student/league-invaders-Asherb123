import javax.swing.JFrame;

public class LeagueInvaders {
	public static void main(String[] args) {

		LeagueInvaders c = new LeagueInvaders();
		c.setup();
	}

	JFrame frame;
	public static final int WIDTH = 500;
	public static final int HIEGHT = 800;
	GamePanel gp;

	public LeagueInvaders() {
		
		frame = new JFrame();
		gp = new GamePanel(0, 0, 0, 0);
		frame.add(gp);
	}

	void setup() {
		frame.setSize(WIDTH, HIEGHT);
frame.addKeyListener(gp);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
	}

}
