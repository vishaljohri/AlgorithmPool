import java.util.Arrays;


public class SelectionSort {

	public static void main(String[] args) {
		int numbers[] = {5, 4, 1, 3, 2, 9, 7, 8, 6};
		
		int temp;
		for(int i = 0; i < numbers.length-1; i++) {
			int min = numbers[i];
			int index = i;
			for(int j = i+1; j < numbers.length; j++) {
				if(numbers[j] < min) {
					min = numbers[j];
					index = j;
				}
			}
			temp = numbers[i];
			numbers[i] = min;
			numbers[index] = temp;
			
		}
		
		System.out.println(Arrays.toString(numbers));

	}

}
