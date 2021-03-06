package game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Long enemyTimer = (long) 0;
	public int enemySpawnTime = 1000;
	ArrayList<Projectile> list = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	RocketShip shippy;
	int score;

	ObjectManager(RocketShip shipper) {
		shippy = shipper;
		score = 0;

	}

	void addAlien(Alien alien) {
		aliens.add(alien);

	}

	void update() {
		shippy.update();
		for (int i = 0; i < list.size(); i++) {
			list.get(i).update();

		}
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();

		}

	}

	void draw(Graphics g) {
		shippy.draw(g);
		// System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			list.get(i).draw(g);

		}
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);

		}
	}

	void addProjectile(Projectile bullet) {
		list.add(bullet);

	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(LeagueInvaders.width - 20), 0, 50, 50));

			enemyTimer = System.currentTimeMillis();
		}
	}

	/*
	 * void purgeObjects() { for(int i =0;i<list.size();i++) {
	 * if(list.get(i).getY()<=0) { list.remove(i); }
	 * 
	 * } for(int i =0;i<aliens.size();i++) { if(aliens.get(i).getY()<=0) {
	 * aliens.remove(i); }
	 * 
	 * } }
	 */
	void purgeObjects() {
		for (int i = 0; i < list.size(); i++) {
			if (!list.get(i).isAlive) {
				list.remove(i);
			}

		}
		for (int i = 0; i < aliens.size(); i++) {
			if (!aliens.get(i).isAlive) {
				aliens.remove(i);
				// add to score
			} else if (aliens.get(i).y > 800) {
				for (Alien b : aliens) {
					b.isAlive = false;
				}
				for (Projectile c : list) {
					c.isAlive = false;
				}
				shippy.isAlive = false;
			}

		}
		if (!shippy.isAlive) {

		}
	}

	void checkCollision() {
		for (Alien a : aliens) {
			if (shippy.collisionBox.intersects(a.collisionBox)) {
				// System.out.println("Garrett is cool");
				shippy.isAlive = false;

				for (Alien b : aliens) {
					b.isAlive = false;
				}

			}
		}
		// Separator
		for (int i = 0; i < aliens.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (aliens.get(i).collisionBox.intersects(list.get(j).collisionBox)) {
					aliens.get(i).isAlive = false;
					list.get(j).isAlive = false;
					shippy.score++;
				}

			}

		}

	}

}
