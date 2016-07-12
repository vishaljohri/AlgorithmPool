
public class WaterContainer {

	public int maxArea(int[] height) {
		if (height.length <= 1)
			return 0;
		int max = 0;
		int left = 0;
		int right = height.length - 1;
		while (left < right) {
			int area = (right - left) * Math.min(height[left], height[right]);
			max = Math.max(max, area);
			// move the smaller height pointer as it decides the area and there
			// is no point checking it with other pairs of smaller width
			if (height[left] < height[right])
				left++;
			else
				right--;
		}
		return max;
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 4, 2, 3, 2, 5, 2 };
		WaterContainer w = new WaterContainer();
		System.out.println(w.maxArea(a));

	}

}
