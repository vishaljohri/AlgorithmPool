
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Box {
	private double height;
	private double width;
	private double depth;

	public Box(double height, double width, double depth) {
		super();
		this.height = height;
		this.width = width;
		this.depth = depth;
	}

	public double getHeight() {
		return height;
	}

	public double getWidth() {
		return width;
	}

	public double getDepth() {
		return depth;
	}
}

public class BoxesStack {

	ArrayList<Box> createStacks(Box[] boxes, Box bottom) {
		double maxHeight = 0.0;
		ArrayList<Box> maxStack = null;
		for (int i = 0; i < boxes.length; i++) {
			if (canAbove(boxes[i], bottom)) {
				ArrayList<Box> newStack = createStacks(boxes, boxes[i]);
				double newHeight = 0.0;
				for (Box b : newStack) {
					newHeight += b.getHeight();
				}
				if (newHeight > maxHeight) {
					maxHeight = newHeight;
					maxStack = newStack;
				}
			}
		}
		if (maxStack == null) {
			maxStack = new ArrayList<>();
		}
		if (bottom != null) {
			maxStack.add(0, bottom);
		}
		return maxStack;
	}

	boolean canAbove(Box up, Box down) {
		if (up.getHeight() < down.getHeight()
				&& up.getWidth() < down.getWidth()
				&& up.getDepth() < down.getDepth())
			return true;
		else
			return false;
	}
	
	void createStackDP(Box[] boxes) {
		//assuming width, depth and height sequence
		Arrays.sort(boxes, new Comparator<Box>() {
			@Override
			public int compare(Box o1, Box o2) {
				if(o1.getWidth() * o1.getDepth() < o2.getWidth() * o2.getDepth())
					return 1;
				else
					return -1;
			}
		});
		
		double dp[] = new double[boxes.length];
		int backTrack[] = new int[boxes.length];
		for(int i = 0; i < boxes.length; i++) {
			backTrack[i] = -1;
		}
		double max = 0;
		int maxLoc = 0;
		// fill dp[] with height of one box
		for(int i = 0; i < boxes.length; i++) {
			dp[i] = boxes[i].getHeight();
		}
		
		for(int i = 1; i < boxes.length; i++) {
			for(int j = 0; j < i; j++) {
				if(boxes[i].getWidth() < boxes[j].getWidth() 
						&& boxes[i].getDepth() < boxes[j].getDepth()
						&& boxes[i].getHeight() < boxes[j].getHeight()) {
					if(dp[i] < dp[j] + boxes[i].getHeight()) {
						dp[i] = dp[j] + boxes[i].getHeight();
						backTrack[i] = j;
					}
				}
			}
			if(max < dp[i]) {
				max = dp[i];
				maxLoc = i;
			}
		}
		
		while(maxLoc != -1) {
			System.out.println(boxes[maxLoc].getWidth() + " " + boxes[maxLoc].getHeight()
					+ " " + boxes[maxLoc].getHeight());
			maxLoc = backTrack[maxLoc];
		}
		System.out.println("max height = " + max);
	}

	public static void main(String[] args) {
		Box b1 = new Box(5.0, 6.0, 7.0);
		Box b2 = new Box(7.0, 8.0, 9.0);
		Box b3 = new Box(6.0, 7.0, 8.0);

		Box[] boxes = new Box[3];
		boxes[0] = b1;
		boxes[1] = b2;
		boxes[2] = b3;

		BoxesStack bs = new BoxesStack();
		ArrayList<Box> stackBoxes = new ArrayList<>();
		
		//try for all boxes as bottom... tried only for b2
		stackBoxes = (bs.createStacks(boxes, b2));
		
		for (Box eachBox : stackBoxes) {
			System.out.println(eachBox.getHeight());
		}
		
		//using dp
		bs.createStackDP(boxes);
		
	}

}
