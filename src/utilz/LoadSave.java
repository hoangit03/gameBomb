package utilz;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import main.Game;

public class LoadSave {
	public static final String PLAYER_ATLAS = "player.png";
	public static final String BACKGROUND = "nen.png";
	public static final String LEVEL_ATLAS = "block3.png";
	public static final String LEVEL_ONE_DATA = "level_one_data.png";
	public static final String BOMB = "bomb.png";
	public static BufferedImage GetSpriteAtlas(String fileName) {
		BufferedImage img = null;
		InputStream iStream = LoadSave.class.getResourceAsStream("/"+fileName);
		try {
			 img = ImageIO.read(iStream);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				iStream.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return img;
	}
	
	public static int[][] GetLevelData(){
		int[][] lvData = new int[Game.TILES_IN_HIEGHT][Game.TILES_IN_WIDTH];
		BufferedImage img = GetSpriteAtlas(LEVEL_ONE_DATA);
		for(int j = 0;j < img.getHeight();j++)
			for(int i = 0; i< img.getWidth();i++) {
				Color color = new Color(img.getRGB(i, j));
				int value = color.getRed();
				
				if(value != 13)
					value = 1;
				else if (value == 13) {
					value = 0;
				}
				lvData[j][i] = value;
			}
		return lvData;
	}
}
