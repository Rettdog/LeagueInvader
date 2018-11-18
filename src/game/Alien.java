package game;

import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject{

	Alien(int xp, int yp, int widthp, int heightp) {
		super(xp, yp, widthp, heightp);
		// TODO Auto-generated constructor stub
	}
void update() {
	super.update();
		y+=5;
	}

	void draw(Graphics g) {
		g.setColor(Color.BLUE);

        //g.fillRect(x, y, width, height);
        g.setColor(Color.YELLOW);
        g.drawImage(GamePanel.alienImg, x, y, width, height, null);


	}
	int getY() {
		return y;
		
	}
}
