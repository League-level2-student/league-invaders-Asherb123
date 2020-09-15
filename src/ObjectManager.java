import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {

	
	Rocketship rocketship;
	 Random rand = new Random();
	
	
	
	ArrayList <Alien> aliens = new ArrayList <Alien>();
	
	ArrayList<Projectile> projectiles = new ArrayList <Projectile>();
	
	
	public ObjectManager(Rocketship rocketship ) {
		
		this.rocketship=rocketship;
		
		
	}
			
	void addProjectile(Projectile projectile) {
		
		projectiles.add(projectile);
		
		
		
	}
			
	void addAlien(Alien alien) {
		aliens.add(new Alien(rand.nextInt(LeagueInvaders.WIDTH),0,50,50));
		
		
	}
	
	void update() {
		for (int i = 0; i < aliens.size() ; i++) {
			Alien s = aliens.get(i);
		
		s.update();
		
		System.out.println(s.y);
		
		}
		
		for (int i = 0; i < projectiles.size(); i++) {
			
			Projectile a = projectiles.get(i);
			
			a.update();
			
			
		}
		
	
		
		
	}
			
	
	
	
	
}
