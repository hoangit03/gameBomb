package levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;
import utilz.LoadSave;

public class LevelManager {
	private Game game;
	private BufferedImage backGround;
	private BufferedImage[] levelSprite;
	private Level levelOne;
	
	public LevelManager(Game game) {
		this.game = game;
//		levelSprite = LoadSave.GetSpriteAtlas(LoadSave.LEVEL_ATLAS);
		importOutsideSpeites();
		importOutsideBackground();
		levelOne = new Level(LoadSave.GetLevelData());
	}
	
	private void importOutsideSpeites() {
		BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.LEVEL_ATLAS);
		levelSprite = new BufferedImage[2];
		for(int i = 0; i < 2; i++) {
			int index = i;
			levelSprite[i] = img.getSubimage(i*63, 0, 63, 51);
		}
		
	}

	public void drawBackGround(Graphics g) {
		for(int j = 0; j < Game.TILES_IN_HIEGHT;j++)
			for(int i = 0; i< Game.TILES_IN_WIDTH;i++) {
				g.drawImage(backGround, Game.TILES_SIZE*i, Game.TILES_SIZE*j,Game.TILES_SIZE,Game.TILES_SIZE, null);
			}
		
		
	}
	
	public void draw(Graphics g) {
		for(int j = 0; j < Game.TILES_IN_HIEGHT;j++)
			for(int i = 0; i< Game.TILES_IN_WIDTH;i++) {
				int index = levelOne.getSpriteindex(j, i);
				g.drawImage(levelSprite[index], Game.TILES_SIZE*i, Game.TILES_SIZE*j,Game.TILES_SIZE,Game.TILES_SIZE, null);
			}
	}
	
	public void importOutsideBackground() {
		BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.BACKGROUND);
		backGround = img;
	}
	
	public void update() {
		
	}
}
