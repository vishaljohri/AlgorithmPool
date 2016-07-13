package leetcode.ques;

public class WaterJug {

	public boolean canMeasureWater(int x, int y, int z) {
		if(x + y < z)
			return false;
		if(x == z || y == z || x + y == z) 
			return true;
		
		// z should be multiple of gcd of x, y
		if(z % gcd(Math.max(x, y), Math.min(x, y)) == 0)
			return true;
		else
			return false;
	}
	
	int gcd(int a, int b) {
		if(b == 0)
			return a;
		return gcd(b, a%b);
	}

	public static void main(String[] args) {
		WaterJug wj = new WaterJug();
		System.out.println(wj.canMeasureWater(3, 5, 4));
	}
}
