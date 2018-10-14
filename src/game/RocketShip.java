package game;

import java.awt.Color;
import java.awt.Graphics;

public class RocketShip extends GameObject{
	int speed;
	
	RocketShip(int xp, int yp, int widthp, int heightp) {
		super(xp, yp, widthp, heightp);
		// TODO Auto-generated constructor stub
		speed = 5;
		
		
	}
void update() {
		
	}

	void draw(Graphics g) {
		g.setColor(Color.BLUE);

        g.fillRect(x, y, width, height);

	}
}
