package game;

import java.awt.Color;
import java.awt.Graphics;

public class RocketShip extends GameObject{
	int xSpeed;
	int ySpeed;
	int score;
	RocketShip(int xp, int yp, int widthp, int heightp) {
		super(xp, yp, widthp, heightp);
		// TODO Auto-generated constructor stub
		
		xSpeed = 0;
		ySpeed = 0;
		
	}
void update() {
	super.update();
	x+=xSpeed;
	y+=ySpeed;
	//System.out.println(xSpeed);
	}

	void draw(Graphics g) {
		g.setColor(Color.BLUE);

        //g.fillRect(x, y, width, height);
		g.drawImage(GamePanel.rocketImg, x, y, width, height, null);

	}
}
