package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	//GameObject object;
	int shipx=250;
	int shipy=700;
	RocketShip ship = new RocketShip(shipx,shipy,50,50);
	ObjectManager manager = new ObjectManager(ship);
	Font titleFont;
	Font nontitle;
	
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;

	GamePanel() {
		timer = new Timer(1000 / 60, this);
		//object = new GameObject(10, 10, 100, 100);
		titleFont=new Font("Arial",Font.PLAIN,48);
		nontitle = new Font("Arial",Font.PLAIN,28);
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
	}

	void updateEndState() {
		currentState = END_STATE;

	}

	void drawMenuState(Graphics g) {
		g.setFont(titleFont);
		
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setColor(Color.YELLOW);
		g.drawString("League Invaders", 50, 200);
		g.setFont(nontitle);
		g.drawString("Press ENTER to Start", 100, 300);
		g.drawString("Press SPACE for instructions", 50, 400);
	}

	void drawGameState(Graphics g) {
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height); 
		manager.draw(g);
		
	}

	void drawEndState(Graphics g) {
		g.setFont(titleFont);
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height); 
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER", 90, 200);
		g.setFont(nontitle);
		g.drawString("You killed "+0+" enemies", 110, 300);
		g.drawString("Press ENTER to restart", 90, 400);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ship.update();
		
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
		System.out.println(e.getKeyCode());
		if(e.getKeyCode()==32) {
			System.out.println("the");
			manager.addProjectile(new Projectile(ship.x, ship.y, 10, 10));
		}             
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==32) {
			System.out.println("the");
			manager.addProjectile(new Projectile(ship.x+20, ship.y, 10, 10));
		}
		// TODO Auto-generated method stub
		//System.out.println(e.getKeyCode());
		if(e.getKeyCode()==10) {
			System.out.println(e.getKeyCode());
			currentState++;
			
			if(currentState > END_STATE){

                currentState = MENU_STATE;

			}
		
		}
		if(e.getKeyCode()==39) {
			ship.x+=ship.speed;
		}
		if(e.getKeyCode()==40) {
			ship.y+=ship.speed;
		}
		if(e.getKeyCode()==37) {
			ship.x-=ship.speed;
		}
		if(e.getKeyCode()==38) {
			ship.y-=ship.speed;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("kid");
	}
}
