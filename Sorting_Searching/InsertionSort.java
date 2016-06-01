import java.util.Arrays;


public class InsertionSort {

	public static void main(String[] args) {
		int numbers[] = {5, 4, 1, 3, 2, 9, 7, 8, 6};
		
		for(int i = 1; i < numbers.length; i ++) {
			int current = numbers[i];
			int j = i-1;
			while(j >= 0 && (current < numbers[j])) {
				numbers[j+1] = numbers[j];
				j--;
			}
			numbers[j+1] = current;
		}
		
		System.out.println(Arrays.toString(numbers));

	}

}
