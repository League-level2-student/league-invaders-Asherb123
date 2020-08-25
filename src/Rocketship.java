import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	

			public Rocketship(int x, int y, int width, int height) {
				super(x, y, width, height);
					speed=10;
				
					
			}
			
					public void right() {
						if (x<=430) {
							
						
						x+=speed;
			   }
					}
			
			
					public void left() {
					if (x>=20) {
						
					
						x-=speed;
				    }
					}
					public void up() {
				       if (y>=20) {
						
					
						y-=speed;
				    }
					}
					public void down() {
				     if (y<=710) {
						
					
						y+=speed;
				    }
				}
				// TODO Auto-generated constructor stub
			
			void draw(Graphics g) {
				g.setColor(Color.BLUE);
		        g.fillRect(x, y, width, height);
				
			}
						

}