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
	
	void Update() {
		
	
		
		
	}
			
	
	
	
	
}
