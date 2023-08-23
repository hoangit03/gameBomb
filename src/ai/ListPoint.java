package ai;

import java.util.ArrayList;
import java.util.List;

public class ListPoint {
	private List<Point> listPoints;
	
	
	public ListPoint () {
		listPoints = new ArrayList<>();
	}
	
	public void addPointFirst(Point a) {
		listPoints.add(0,a);
	}
	public void addPointLast(Point a) {
		listPoints.add(a);
	}
	
	public void deleteFirst() {
		listPoints.remove(0);
	}
	
	public int getSize() {
		return listPoints.size();
	}
	
	public boolean checkPoint(Point x) {
		for (Point point : listPoints) {
			if(point.getX() == x.getX() && point.getY() == x.getY())
				return true;
		}
		return false;

	}

	public Point getFirst() {
		return listPoints.get(0);
	}
	
	public Point get(int i) {
		return listPoints.get(i);
	}
	
	@Override
	public String toString() {
		String result = "";
		for (Point point : listPoints) {
			result += point+"\n";
		}
		return result;
	}
}
