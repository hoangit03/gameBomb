package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;
import utilz.LoadSave;

public class Bomb {
	private BufferedImage animation;
	int x;
	int y;
	
	public Bomb(int x, int y) {
		this.x = x;
		this.y = y;
		draw();
	}
	
	
	public void update() {
		
	}
	
	
	
	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public void render(Graphics g) {
		g.drawImage(animation, x * Game.TILES_SIZE-30, y*Game.TILES_SIZE-30,123,123, null);
	}
	
	private void draw() {
		BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.BOMB);
		animation = img;
		
	}
	
}	
