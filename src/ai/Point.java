package ai;

public class Point {
	private float x;
	private float y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("(%f,%f)->", x, y);
	}

}
