package game;

import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject{
	int speed =10;

	Projectile(int xp, int yp, int widthp, int heightp) {
		super(xp, yp, widthp, heightp);
		// TODO Auto-generated constructor stub
	}
	void update(){
		y-=speed;
		if(y<0) {
			isAlive=false;
			
		}
		
	}
	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
		System.out.println(x+" "+y);
	}

}
