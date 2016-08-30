
public class TrappingWater {
	
	int trappedWater(int a[]) {
		if(a.length <= 2)
			return 0;
		int n = a.length;
		int leftMax[] = new int[n];
		int rightMax[] = new int[n];
		
		//populate left max array
		leftMax[0] = a[0];
		int max = a[0];
		for(int i = 1; i < n; i++) {
			if(a[i] > max) {
				max = a[i];
				leftMax[i] = max;
			}
			else {
				leftMax[i] = max;
			}
		}
		
		//populate right max array
		rightMax[n - 1] = a[n - 1];
		max = a[n - 1];
		for(int i = n - 2; i >= 0; i--) {
			if(a[i] > max) {
				max = a[i];
				rightMax[i] = max;
			}
			else {
				rightMax[i] = max;
			}
		}
		
		//find tapped water for each cell
		int result = 0;
		for(int i = 0; i < n ; i++) {
			result += Math.min(leftMax[i], rightMax[i]) - a[i];
		}
		
		//result has the sum of tapped water
		return result;
	}

	public static void main(String[] args) {
		int a[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		TrappingWater t = new TrappingWater();
		System.out.println(t.trappedWater(a));

	}

}
