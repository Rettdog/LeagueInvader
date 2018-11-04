package game;

import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	boolean isAlive=true;
	Rectangle collisionBox;

	GameObject(int xp, int yp, int widthp, int heightp) {
		x = xp;
		y = yp;
		width = widthp;
		height = heightp;
		collisionBox = new Rectangle(x,y,width,height);
	}

	void update() {
		collisionBox.setBounds(x, y, width, height);
	}

	void draw(Graphics g) {
		

	}
}
