package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Projectile extends GameObject{
	int speed =10;
	Random rand = new Random();
	Projectile(int xp, int yp, int widthp, int heightp) {
		super(xp, yp, widthp, heightp);
		// TODO Auto-generated constructor stub
	}
	void update(){
		super.update();
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
	int getY() {
		return y;
		
	}

}
