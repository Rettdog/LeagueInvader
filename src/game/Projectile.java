package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Projectile extends GameObject{
	int speed =10;
	Random rand = new Random();
	Projectile(int xp, int yp, int widthp, int heightp) {
		super(xp, yp, widthp, heightp);
		 if(GamePanel.egg) {
			 this.x=x-width/2;
		 }
		 
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
		//g.fillRect(x, y, width, height);
		
		 
		 if(GamePanel.egg) {
			 width=250;
			 height=350;
			 
			 g.drawImage(GamePanel.bulletImg, x, y, width, height, null);
		 }else {
			 width=10;
			 height=14;
			 g.drawImage(GamePanel.bulletImg, x, y, width, height, null);
		 }


		System.out.println(x+" "+y);
	}
	int getY() {
		return y;
		
	}

}
