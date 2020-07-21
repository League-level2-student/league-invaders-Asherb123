import javax.swing.JFrame;

public class LeagueInvaders {
public static void main(String[] args) {
	
LeagueInvaders c = new LeagueInvaders();
	c.setup();
}
JFrame frame;
public static final int WIDTH = 500;
public static final int HIEGHT  = 800;

public LeagueInvaders(){
	
	frame= new JFrame();
	
}

void setup() {
	frame.setSize(WIDTH, HIEGHT);
	
	
	frame.setVisible(true);
	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
}





}




