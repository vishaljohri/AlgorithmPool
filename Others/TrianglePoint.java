
public class TrianglePoint {
	
	// check if given point(x, y) lies inside the triangle
	boolean inside(int x1, int y1, int x2, int y2, int x3, int y3, int x, int y) {
		float areaTotal = getArea(x1, y1, x2, y2, x3, y3);
		float areaPAB = getArea(x, y, x1, y1, x2, y2);
		float areaPBC = getArea(x, y, x2, y2, x3, y3);
		float areaPCA = getArea(x, y, x3, y3, x1, y1);
		if(areaTotal == areaPAB + areaPBC + areaPCA)
			return true;
		else
			return false;
	}
	
	float getArea(int x1, int y1, int x2, int y2, int x3, int y3) {
		return (float) Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
	}

	public static void main(String[] args) {
		TrianglePoint tp = new TrianglePoint();
		System.out.println(tp.inside(0, 0, 10, 25, 20, 0, 10, 15));
	}
}
