package algorithm.leetcode.algorithm;

public class Point{
	public int x,y;
	private int value;
	public Point(){
		x = 0;
		y = 0;
	}
	public Point(int x,int y){
		this.x = x;
		this.y = y;
	}

	public Point(int x, int y, int value) {
		this.x = x;
		this.y = y;
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "(" + x + " , " + y + ")";
	}
	@Override
	public boolean equals(Object obj) {
		Point p = (Point)obj;
		return p.x == this.x && p.y == this.y;
	}
}
