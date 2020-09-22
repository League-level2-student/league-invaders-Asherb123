import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject {
	

	
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
			
	public Rocketship(int x, int y, int width, int height) {
				super(x, y, width, height);
					speed=10;
					if (needImage) {
					    loadImage ("rocket.png");
					}

					
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
				//g.setColor(Color.BLUE);
		     //   g.fillRect(x, y, width, height);
		        
		        if (gotImage) {
		        	g.drawImage(image, x, y, width, height, null);
		        } else {
		        	g.setColor(Color.BLUE);
		        	g.fillRect(x, y, width, height);
		        }

				
			}
			void loadImage(String imageFile) {
			    if (needImage) {
			        try {
			            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				    gotImage = true;
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
			        needImage = false;
			    }
			}
				

}