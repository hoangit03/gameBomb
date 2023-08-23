package entities;

import static utilz.Constants.Direction.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import static utilz.HelpMothods.CanMoveHere;
import utilz.LoadSave;
import ai.Run;

public class Player extends Entity {
	private BufferedImage[][] animations;
	private int aniTick, aniIndex, aniSpeed = 30;
	private int playAction = DOWN;
	private boolean left, up, right, down;
	private Run run;
	private float playerSpeed = 1.0f;
	private int[][] lvlData;
	private float xDrawOffet = (float) (13 * 0.9);
	private float yDrawOffet = (float) (8 * 0.9);

	public Player(float x, float y, int scaleX, int scaleY) {
		super(x, y, scaleX, scaleY);
		loadAnimation();
		initHitbox(x, y, (float) (36 * 0.9), (float) (50 * 0.9));
	}

	public void update() {
		updatePos();
//		updateHitbox();
		updateAnimation();
		setAnimation();
	}

	public void render(Graphics g) {
		g.drawImage(animations[playAction][aniIndex], (int) (hitbox.x - xDrawOffet), (int) (hitbox.y - yDrawOffet),
				width, height, null);
//		drawHitbox(g);
	}

	private void updateAnimation() {
		aniTick++;
		if (aniTick >= aniSpeed) {
			aniTick = 0;
			aniIndex++;
			if (aniIndex >= GetSpriteAmount(playAction)) {
				aniIndex = 0;
			}
		}
	}

	private void setAnimation() {

		int startAni = playAction;
		if (left) {
			playAction = LEFT;
		}
		if (right) {
			playAction = RIGHT;
		}
		if (down) {
			playAction = DOWN;
		}
		if (up) {
			playAction = UP;
		}

	}

	private void resetAniTick() {
		aniTick = 0;
		aniIndex = 0;
	}

	private void updatePos() {

//		if(!left && !right && !up && !down)
//			return;
//		
//		float xSpeed = 0, ySpeed = 0;
//		
//		if(left && !right) {
//			xSpeed=-playerSpeed;
//			
//		}
//		else if((right && !left)) {
//			xSpeed=playerSpeed;
//		}
//		if(up && !down) {
//			ySpeed=-playerSpeed;
//		}
//		else if((down && !up)) {
//			ySpeed=playerSpeed;
//		}

//		if(CanMoveHere(x+xSpeed, y+ySpeed, width, height, lvlData)) {
//			this.x += xSpeed;
//			this.y += ySpeed;
//		}
//		
//		if (CanMoveHere(hitbox.x + xSpeed, hitbox.y + ySpeed, hitbox.width, hitbox.height, lvlData)) {
//			hitbox.x += xSpeed;
//			hitbox.y += ySpeed;
//		}
	}

	private void loadAnimation() {
		BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_ATLAS);
		animations = new BufferedImage[4][4];
		for (int i = 0; i < animations.length; i++) {
			for (int j = 0; j < animations[i].length; j++)
				animations[i][j] = img.getSubimage(j * 64, 66 * i, 64, 66);
		}
	}

	public void loadLvlData(int[][] lvlData) {
		this.lvlData = lvlData;
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
