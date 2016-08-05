
import java.util.Stack;

public class HistogramArea {

	public int largestRectangleArea(int[] heights) {
		int n = heights.length;
		if (n == 0)
			return 0;
		int left[] = new int[n];
		int right[] = new int[n];

		// check how much each element can extend on left side
		left[0] = 0;
		for (int i = 1; i < n; i++) {
			int count = 0;
			int j = i - 1;
			while (j >= 0 && heights[j] >= heights[i]) {
				count++;
				if (j > 0 && heights[i] == heights[j]) {
					count += left[j];
					break;
				}
				j--;
			}
			left[i] = count;
		}

		// check how much each element can extend on right side
		right[n - 1] = 0;
		for (int i = n - 2; i >= 0; i--) {
			int count = 0;
			int j = i + 1;
			while (j < n && heights[j] >= heights[i]) {
				count++;
				if (j < n - 1 && heights[i] == heights[j]) {
					count += right[j];
					break;
				}
				j++;
			}
			right[i] = count;
		}

		// find max by calc extended area for each cell
		int max = Integer.MIN_VALUE;
		for (int k = 0; k < n; k++) {
			max = Math.max(max, heights[k] * left[k] + heights[k] * right[k]
					+ heights[k]);
		}

		// return maximum possible area
		return max;

	}

	int largestRectangleAreaOptimized(int[] heights) {
		int n = heights.length;
		if (n == 0)
			return 0;
		Stack<Integer> stack = new Stack<>();
		int maxArea = Integer.MIN_VALUE;

		// put elements in stack in ascending manner
		int i = 0;
		while (i < n) {
			if (stack.isEmpty() || heights[stack.peek()] <= heights[i])
				stack.push(i++);
			else {
				int curLoc = stack.pop();
				int width = 0;
				if (stack.isEmpty())
					width = i;
				else
					width = i - stack.peek() - 1;
				maxArea = Math.max(maxArea, heights[curLoc] * width);
			}
		}

		while (!stack.isEmpty()) {
			int curLoc = stack.pop();
			int width = 0;
			if(stack.isEmpty())
				width = i;
			else
				width = i - stack.peek() - 1;
			maxArea = Math.max(maxArea, heights[curLoc] * width);
		}
		return maxArea;
	}

	public static void main(String[] args) {
		HistogramArea h = new HistogramArea();
		int a[] = {2, 4};
		System.out.println(h.largestRectangleAreaOptimized(a));

	}

}
