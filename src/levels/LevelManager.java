package levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;
import utilz.LoadSave;

public class LevelManager {
	private Game game;
	private BufferedImage levelSprite;
	private Level levelOne;
	
	public LevelManager(Game game) {
		this.game = game;
//		levelSprite = LoadSave.GetSpriteAtlas(LoadSave.LEVEL_ATLAS);
		importOutsideSpeites();
//		levelOne = new Level(LoadSave.GetLevelData());
	}
	
	private void importOutsideSpeites() {
		BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.LEVEL_ATLAS);
		levelSprite = img;
		
	}

	public void draw(Graphics g) {
		for(int j = 0; j < Game.TILES_IN_HIEGHT;j++)
			for(int i = 0; i< Game.TILES_IN_WIDTH;i++) {
//				int index = levelOne.getSpriteindex(i, j);
				g.drawImage(levelSprite, Game.TILES_SIZE*i, Game.TILES_SIZE*j,Game.TILES_SIZE,Game.TILES_SIZE, null);
			}
	}
	
	public void update() {
		
	}
}
