package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	// GameObject object;
	int shipx = 250;
	int shipy = 700;
	RocketShip ship;
	int score = 0;
	public static boolean egg = false;
	public static BufferedImage alienImg;

	public static BufferedImage rocketImg;

	public static BufferedImage bulletImg;

	public static BufferedImage spaceImg;

	ObjectManager manager;
	Font titleFont;
	Font nontitle;

	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;

	GamePanel() {
		timer = new Timer(1000 / 60, this);
		// object = new GameObject(10, 10, 100, 100);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		nontitle = new Font("Arial", Font.PLAIN, 28);
		ship = new RocketShip(shipx, shipy, 50, 50);
		manager = new ObjectManager(ship);
		try {

			alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));

			rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));

			bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));

			spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));

		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
	}

	void startGame() {
		timer.start();

	}

	void updateMenuState() {
		currentState = MENU_STATE;

	}

	void updateGameState() {
		currentState = GAME_STATE;
		manager.update();
		manager.manageEnemies();
		manager.purgeObjects();
		manager.checkCollision();
	}

	void updateEndState() {
		currentState = END_STATE;

	}

	void drawMenuState(Graphics g) {
		g.setFont(titleFont);
		ship.score = 0;
		g.setColor(Color.BLUE);
		g.drawImage(GamePanel.spaceImg, 0, 0, LeagueInvaders.width, LeagueInvaders.height, null);
		// g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setColor(Color.YELLOW);
		g.drawString("League Invaders", 50, 200);
		g.setFont(nontitle);
		g.drawString("Press ENTER to Start", 100, 300);
		g.drawString("Press SPACE for instructions", 50, 400);
	}

	void drawGameState(Graphics g) {

		g.setColor(Color.BLACK);
		g.drawImage(GamePanel.spaceImg, 0, 0, LeagueInvaders.width, LeagueInvaders.height, null);
		manager.draw(g);

	}

	void drawEndState(Graphics g) {
		g.setFont(titleFont);
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER", 90, 200);
		g.setFont(nontitle);
		g.drawString("You killed " + ship.score + " enemies", 110, 300);
		g.drawString("Press ENTER to restart", 90, 400);
		// score = 0;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ship.update();
		if (!ship.isAlive) {
			ship.isAlive = true;

			updateEndState();

		}

		repaint();
		if (currentState == MENU_STATE) {

			updateMenuState();

		} else if (currentState == GAME_STATE) {

			updateGameState();

		} else if (currentState == END_STATE) {

			updateEndState();

		}

	}

	@Override

	public void paintComponent(Graphics g) {
		ship.draw(g);
		if (currentState == MENU_STATE) {

			drawMenuState(g);

		} else if (currentState == GAME_STATE) {

			drawGameState(g);

		} else if (currentState == END_STATE) {

			drawEndState(g);

		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == 32) {
			// System.out.println("the");
			manager.addProjectile(new Projectile(ship.x, ship.y, 10, 10));
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == 32 && currentState == MENU_STATE) {
			JOptionPane.showMessageDialog(null,
					"Use the arrow keys to move. Use the space bar to shoot. \n Don't let the aliens touch you or the Earth. \n You are our only hope. Good luck officer, and be \non the look out for the easter egg.");
		}

		// System.out.println(e.getKeyChar());
		if (e.getKeyCode() == 39) {
			ship.xSpeed = 5;
			// System.out.println("hello");
		}
		if (e.getKeyCode() == 37) {
			ship.xSpeed = -5;
		}
		if (e.getKeyCode() == 40) {
			ship.ySpeed = 5;
		}
		if (e.getKeyCode() == 38) {
			ship.ySpeed = -5;
		}

		if (e.getKeyCode() == 32) {
			// System.out.println("the");
			manager.addProjectile(new Projectile(ship.x + 20, ship.y, 10, 10));
		}
		// TODO Auto-generated method stub
		// System.out.println(e.getKeyCode());
		if (e.getKeyCode() == 10) {
			// System.out.println(e.getKeyCode());
			currentState++;

			if (currentState > END_STATE) {

				currentState = MENU_STATE;

			}
			if (currentState == END_STATE) {
				ship = new RocketShip(shipx, shipy, 50, 50);
				manager = new ObjectManager(ship);

			}

		}
		if (e.getKeyCode() == 45) {
			egg = true;
			manager.enemySpawnTime = 500;
			System.out.println("You have found the easter egg");
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("kid");
		if (e.getKeyCode() == 39) {
			ship.xSpeed = 0;
		}
		if (e.getKeyCode() == 37) {
			ship.xSpeed = 0;
		}
		if (e.getKeyCode() == 40) {
			ship.ySpeed = 0;
		}
		if (e.getKeyCode() == 38) {
			ship.ySpeed = 0;
		}
	}
}
