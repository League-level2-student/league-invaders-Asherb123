import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {

	Rocketship rocketship;
	Random rand = new Random();

	ArrayList<Alien> aliens = new ArrayList<Alien>();

	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

	int score = 0;
	int getScore() {
		
		return score;
		
		
		
	}
	public ObjectManager(Rocketship rocketship) {

		this.rocketship = rocketship;

	}

	void addProjectile(Projectile projectile) {

		projectiles.add(projectile);

	}

	void addAlien(Alien alien) {
		aliens.add(new Alien(rand.nextInt(LeagueInvaders.WIDTH-100), 0, 50, 50));

	}

	void update() {
		for (int i = 0; i < aliens.size(); i++) {
			Alien s = aliens.get(i);
			//aliens.get(i).update();
			s.update();
			
			System.out.println(s.y);

			
		}
		rocketship.update();
		for (int i = 0; i < projectiles.size(); i++) {

			Projectile a = projectiles.get(i);

			a.update();

			System.out.println(a.y);

		}
checkCollision();
			purgeObjects();
}
	void draw(Graphics g) {
		rocketship.draw(g);
		for (int i = 0; i < aliens.size(); i++) {
			Alien b = aliens.get(i);
			b.draw(g);
		
		}
		for (int i = 0; i < projectiles.size(); i++) {
			Projectile c = projectiles.get(i);
			c.draw(g);
		}
	}
	
	void purgeObjects() {
		
		
		
		
		
		for (int i = aliens.size()-1; i>=0; i--) {
			Alien z = aliens.get(i);
			
			if (z.isActive==false) {
				aliens.remove(i);
				score= score+1;
			}
			
			
		}
		for (int i = projectiles.size()-1; i >= 0; i--) {
			Projectile x = projectiles.get(i);
			
			if (x.isActive==false) {
				projectiles.remove(i);
			}
			
		}
		
	}
	void checkCollision() {
		for (int i = aliens.size()-1; i>=0; i--) {
			Alien z = aliens.get(i);
		if (z.collisionBox.intersects(rocketship.collisionBox)) {
			z.isActive=false;
			rocketship.isActive=false;

			}
			 for (int j = projectiles.size()-1; j >= 0; j--) {
				Projectile x = projectiles.get(j);
				
				if (x.collisionBox.intersects(z.collisionBox)) {
					x.isActive=false;
					z.isActive=false;
				}
			}
			
		}
			
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien(null);
		
	}
	
}
