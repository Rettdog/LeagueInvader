   package game;

import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	static JFrame frame;
	static final int width = 500;
	static final int height = 800;
	
	
	GamePanel superPanel;

	LeagueInvaders() {
		frame = new JFrame();
		frame.setSize(width, height);

		superPanel = new GamePanel();
		frame.addKeyListener(superPanel);
	}

	public static void main(String[] args) {
		LeagueInvaders invader = new LeagueInvaders();
		invader.setup();
	}

	void setup() {
		frame.add(superPanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setPreferredSize(new Dimension(width, height));

		frame.pack();
		superPanel.startGame();
	}
}
