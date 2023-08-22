package main;

import java.awt.Graphics;

import entities.Player;
import levels.LevelManager;

public class Game implements Runnable {
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private Thread gameThread;
	private final int FPS_SET = 120;
	private final int UPS_SET = 200;
	private Player player;
	private LevelManager levelManager;
	
	public final static int TILES_DEFAULT_SIZE = 42;
	public final static float SACLE = 1.5f;
	public final static int TILES_IN_WIDTH = 26;
	public final static int TILES_IN_HIEGHT = 14;
	public final static int TILES_SIZE = (int) (TILES_DEFAULT_SIZE*SACLE);
	public final static int GAME_WIDTH = TILES_SIZE*TILES_IN_WIDTH;
	public final static int GAME_HIEGHT = TILES_SIZE*TILES_IN_HIEGHT;
	public Game() {
		initClasses();
		gamePanel = new GamePanel(this);
		gameWindow = new GameWindow(gamePanel);
		gamePanel.requestFocus();
		startGameLoop();

	}

	private void initClasses() {
		levelManager = new LevelManager(this);
		player = new Player(70, 70,(int) (64*0.9),(int) (66*0.9));
		player.loadLvlData(levelManager.getCurrentLevel().getLevelData());
	}

	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void update() {
		levelManager.update();
		player.update();
	}
	
	public void render(Graphics g) {
		levelManager.drawBackGround(g);
		levelManager.draw(g);
		player.render(g);
	}
	
	@Override
	public void run() {
		double timePerFrame = 1000000000.0 / FPS_SET;
		double timePerUpdeta = 1000000000.0 / UPS_SET;

		
		long previousTime = System.nanoTime();
		
		int frames = 0;
		int updates = 0;
		long lastCheck = System.currentTimeMillis();
		
		double detaU = 0;
		double deltaF = 0;
		
		while(true) {
			
			long currentTime = System.nanoTime();
			
			
			
			detaU += (currentTime -previousTime) / timePerUpdeta;
			deltaF += (currentTime -previousTime) / timePerFrame;
			previousTime = currentTime;
			
			
			if(detaU >= 1) {
				update();
				updates++;
				detaU--;
			}
			if(deltaF >= 1) {
				gamePanel.repaint();
				deltaF--;
				frames++;
			}
			
			
			
			if(System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: "+frames+ " | UPS: " +updates );
				frames = 0;
				updates = 0;
			}
			
		}
	}
	
	public void windowFocusLost() {
		player.resetDirBooleans();
	}
	
	public Player getPlayer() {
		return player;
	}
}
