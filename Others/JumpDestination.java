
import java.util.Arrays;

public class JumpDestination {
	
	int jump(int array[]) {
		int optimum[] = new int[array.length];
		optimum[0] = 0;
		for(int i = 1; i < array.length; i++) {
			optimum[i] = Integer.MAX_VALUE;
			for(int j = i - 1; j >= 0; j--) {
				if(array[j] >= (i - j))
					optimum[i] = Math.min(optimum[i], 1 + optimum[j]);
			}
		}
		System.out.println(Arrays.toString(optimum));
		return optimum[array.length - 1];
	}

	public static void main(String[] args) {
		int array[] = {2, 3, 1, 1, 4};
		JumpDestination jd = new JumpDestination();
		jd.jump(array);

	}

}
