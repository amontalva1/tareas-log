public class Point{
	int id;
	double x;
	double y;
	int cluster;
	
	public Point(int id, double x, double y) {
		this.id = id;
		this.x = x;
		this.y = y;
		cluster = -1;
	}
	
	public int getId() {
		return this.id;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public void setCluster(int id) {
		this.cluster = id;
	}
	
	public static Point[] createPoints(int n, double min, double max) {
		Point[] points = new Point[n];
		for(int i = 0; i<n; i++) {
			points[i] = new Point(i, min +(max-min)*Math.random(), min+(max-min)*Math.random());
		}
		return points;
	}
	
	public double distanceFrom(Point p) {
		return (double) Math.sqrt(Math.pow(this.x - p.getX(), 2) +  Math.pow(this.y - p.getY(),2));
	}

	public String info(){
		return this.x + " " + this.y + " " + this.cluster;
	}
	
	
}