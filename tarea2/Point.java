import java.util.Random;
//import java.util.Math;
public class Point{
	int id;
	float x;
	float y;
	int cluster;
	
	public Point(int id, float x, float y) {
		this.id = id;
		this.x = x;
		this.y = y;
		cluster = -1;
	}
	
	public int getId() {
		return this.id;
	}
	
	public float getX() {
		return this.x;
	}
	
	public float getY() {
		return this.y;
	}
	
	public void setCluster(int id) {
		this.cluster = id;
	}
	
	public static Point[] createPoints(int n) {
		Random random = new Random();
		Point[] points = new Point[n];
		for(int i = 0; i<n; i++) {
			points[i] = new Point(i, random.nextFloat(), random.nextFloat());
		}
		return points;
	}
	
	public float distanceFrom(Point p) {
		return (float) Math.sqrt(Math.pow(this.x - p.getX(), 2) +  Math.pow(this.y - p.getY(),2));
	}
	
	
}