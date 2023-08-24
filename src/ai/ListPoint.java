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
	
	public Point getPointK(int i) {
		return listPoints.get(i);
	}
	
	public int getSize() {
		return listPoints.size();
	}
	
	public void xoaSoLuong(int i,int j) {
		int x = j;
		for(int a = i; a < listPoints.size();x--) {
			if(a < x+1) {
				listPoints.remove(a);
				if(x == a)
					break;
			}
			
		}
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
