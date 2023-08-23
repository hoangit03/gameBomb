package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.io.ObjectInputStream.GetField;

import javax.swing.JPanel;

import ai.Run;
import entities.Player;
import inputs.KeyboardInputs;
import inputs.MouseInputs;

import static main.Game.GAME_HIEGHT;
import static main.Game.GAME_WIDTH;

public class GamePanel extends JPanel {
	private MouseInputs mouseInputs;
	private Game game;
	private Run run;
	private Player player;

	public GamePanel(Game game) {
		mouseInputs = new MouseInputs(this);
		this.game = game;
		setPanalSize();
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
		this.player = game.getPlayer();
		run = new Run(player);
	}

	private void setPanalSize() {
		Dimension size = new Dimension(GAME_WIDTH, GAME_HIEGHT);
		setPreferredSize(size);
		System.out.println("size: " + GAME_WIDTH + " : " + GAME_HIEGHT);
	}

	public void updateGame() {

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		game.render(g);
		repaint();
	}

	public Game getGame() {
		return game;
	}
	
	public Player getPlayer() {
		return player;
	}

	public Run getRun() {
		return run;
	}

}
