package entities;



import static utilz.Constants.Direction.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import utilz.LoadSave;

public class Player extends Entity{
	private BufferedImage[][] animations;
	private int aniTick, aniIndex,aniSpeed = 30;
	private int playAction = DOWN;
	private boolean left,up,right,down;
	private float playerSpeed = 1.0f;
	public Player(float x, float y,int scaleX,int scaleY) {
		super(x, y,scaleX,scaleY);
		loadAnimation();
	}
	
	public void update() {
		updatePos();
		updateAnimation();
		setAnimation();
	}
	
	public void render(Graphics g) {
		g.drawImage(animations[playAction][aniIndex],(int) x,(int) y,scaleX,scaleY,null);
	}

	private void updateAnimation() {
		aniTick++;
		if(aniTick >= aniSpeed) {
			aniTick = 0;
			aniIndex++;
			if(aniIndex >= GetSpriteAmount(playAction)) {
				aniIndex = 0;
			}
		}
	}
	
	private void setAnimation() {
		if(!left && !right && !up && !down)
			return;
		int startAni = playAction;
		if(left) {
			playAction = LEFT;
		}
		if(right) {
			playAction = RIGHT;
		}
		if(down) {
			playAction = DOWN;
		}
		if(up) {
			playAction = UP;
		}

		
//		if(startAni != playAction) {
//			resetAniTick();
//		}
	}
	
	private void resetAniTick() {
		aniTick = 0;
		aniIndex = 0;
	}

	private void updatePos() {
		
		if(left && !right) {
			x-=playerSpeed;
		}
		else if((right && !left)) {
			x+=playerSpeed;
		}
		
		
		if(up && !down) {
			y-=playerSpeed;
		}
		else if((down && !up)) {
			y+=playerSpeed;
		}
	}
	
	private void loadAnimation() {
		BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_ATLAS);
		animations = new BufferedImage[4][4];
		for(int i =0; i< animations.length; i++) {
			for(int j = 0; j< animations[i].length;j++)
				animations[i][j] = img.getSubimage(j*64, 66*i, 64, 66);
		}
	}

	public void resetDirBooleans() {
		left = false;
		right = false;
		up = false;
		down = false;
	}
	
	
	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {

		this.up = up;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {

		this.right = right;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}
	
	
	
}
