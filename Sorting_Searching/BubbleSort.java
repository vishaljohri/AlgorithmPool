import java.util.Arrays;


public class BubbleSort {

	public static void main(String[] args) {
		int numbers[] = {5, 4, 1, 3, 2, 9, 7, 8, 6};
		int temp = 0;
		
		for(int i = numbers.length-2; i >= 0 ; i--) {
			for(int j = 0; j <= i; j++) {
				if(numbers[j] > numbers[j+1]) {
					temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(numbers));

	}

}
