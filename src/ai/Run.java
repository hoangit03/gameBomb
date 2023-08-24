package ai;

import entities.Player;
import levels.Level;
import main.Game;
import utilz.LoadSave;

public class Run {

	private Level levelOne;
	private ListPoint b = new ListPoint();
	private ListPoint c = new ListPoint();
	private static final float SPEEP = 0.01f;
	private boolean check = false;
	private Point start, end;
	private Point x = new Point(1, 1);
//	Point g = new Point(16, 5);
	private int[][] a;

	public ListPoint getB() {
		return b;
	}

	public void setB(ListPoint b) {
		this.b = b;
	}

	public ListPoint getC() {
		return c;
	}

	public void setC(ListPoint c) {
		this.c = c;
	}

	public Point getX() {
		return x;
	}

	public void setX(Point x) {
		this.x = x;
	}

//	public Point getG() {
//		return g;
//	}
//
//	public void setG(Point g) {
//		this.g = g;
//	}

	public int[][] getA() {
		return a;
	}

	public void setA(int[][] a) {
		this.a = a;
	}

	Player player;

	public Run(Player player) {
		levelOne = new Level(LoadSave.GetLevelData());
		a = levelOne.getLevelData();
		b.addPointFirst(x);
		this.player = player;
	}

	public void draw() {
		int i = 0;
//		check = true
		while (c.getSize() > 0) {
			if (c.getSize() == 1)
				break;
			start = c.get(i);
			end = c.get(i + 1);
			updatePos();
			check = false;
			c.deleteFirst();
		}
	}

	public void updatePos() {
		while (!check) {
			check = Math.round(start.getX() * 10.0) / 10.0 == Math.round(end.getX() * 10.0) / 10.0
					&& Math.round(start.getY() * 10.0) / 10.0 == Math.round(end.getY() * 10.0) / 10.0;
			if (start.getX() < end.getX()) {
				start.setX(start.getX() + SPEEP);
				player.setRight(true);
			}
			if (start.getX() > end.getX()) {
				player.setLeft(true);
				start.setX(start.getX() - SPEEP);
			}
			if (start.getY() < end.getY()) {
				player.setDown(true);
				start.setY(start.getY() + SPEEP);
			}
			if (start.getY() > end.getY()) {
				player.setUp(true);
				start.setY(start.getY() - SPEEP);
			}
			player.getHitbox().setRect(start.getX() * Game.TILES_SIZE, start.getY() * Game.TILES_SIZE, 36 * 0.9,
					50 * 0.9);
			player.update();
			player.resetDirBooleans();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

//		while ((player.isLeft() && a.getX() * Game.TILES_SIZE - n < b.getX() * Game.TILES_SIZE)
//				|| (player.isRight() && a.getX() * Game.TILES_SIZE + n > b.getX() * Game.TILES_SIZE)
//				|| (player.isDown() && a.getY() * Game.TILES_SIZE + n < b.getY() * Game.TILES_SIZE)
//				|| (player.isUp() && a.getY() * Game.TILES_SIZE - n < b.getY() * Game.TILES_SIZE)) {
//			n += sleep;
//			check = false;
//		}
//		check = true;
//		player.resetDirBooleans();
	}

	public void addList(ListPoint c, ListPoint b, int[][] a, Point g) {
		System.out.println(g);
		double start = System.currentTimeMillis();
		while (b.getSize() > 0) {
			Point x = b.getFirst();
			c.addPointLast(x);
			b.deleteFirst();
			if (x.getX() + 1 > 25 || x.getX() - 1 < 0 || x.getY() + 1 > 14 || x.getY() - 1 < 0)
				continue;
			if (x.getX() == g.getX() && x.getY() == g.getY())
				break;
			if (check(c, b, a, (int) x.getX(), (int) x.getY() + 1))
				b.addPointFirst(new Point((int) x.getX(), (int) x.getY() + 1));
			if (check(c, b, a, (int) x.getX() + 1, (int) x.getY()))
				b.addPointFirst(new Point((int) x.getX() + 1, (int) x.getY()));
			if (check(c, b, a, (int) x.getX(), (int) x.getY() - 1))
				b.addPointFirst(new Point((int) x.getX(), (int) x.getY() - 1));
			if (check(c, b, a, (int) x.getX() - 1, (int) x.getY()))
				b.addPointFirst(new Point((int) x.getX() - 1, (int) x.getY()));
		}
		double end = System.currentTimeMillis();
		System.out.println("Thoi gian tim kiem: " +(double) (end-start));
		RutGon(c);
		
	}
	
	public void RutGon(ListPoint a) {
		
		for (int i = 0; i < a.getSize(); i++) {
			for (int j = i+1; j < a.getSize() - 1; j++) {
				if ((Math.abs(a.getPointK(j).getX() - a.getPointK(j + 1).getX()) != 1
						|| Math.abs(a.getPointK(j).getY() - a.getPointK(j + 1).getY()) != 1)
						&& (Math.abs(a.getPointK(i).getX() - a.getPointK(j + 1).getX()) == 1 
						&& a.getPointK(i).getY() == a.getPointK(j + 1).getY())
						|| (Math.abs(a.getPointK(i).getY() - a.getPointK(j + 1).getY()) == 1 
						&& a.getPointK(i).getX() == a.getPointK(j + 1).getX()))
					a.xoaSoLuong(i+1, j);
//					System.out.println(a.getPointK(i) + "," + a.getPointK(j+1));
					
			}
		}
	}

	public ListPoint getRouteList() {
		return c;
	}

	private static boolean check(ListPoint c, ListPoint b, int[][] a, int x, int y) {
		if (a[y][x] == 1 && !b.checkPoint(new Point(x, y)) && !c.checkPoint(new Point(x, y)))
			return true;
		return false;
	}
}
