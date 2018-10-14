package game;

import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	ArrayList<Projectile> list = new ArrayList<Projectile>();
	RocketShip shippy;
	ObjectManager(RocketShip shipper){
		shippy=shipper;
		
	}
	void update(){
		shippy.update();
		for(int i =0;i<list.size();i++) {
			list.get(i).update();
			
		}
		
	}
	void draw(Graphics g) {
		shippy.draw(g);
		//System.out.println(list.size());
		for(int i =0;i<list.size();i++) {
			list.get(i).draw(g);
			
		}
	}
	void addProjectile(Projectile bullet) {
		list.add(bullet);
		
	}
}
