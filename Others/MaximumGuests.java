import java.util.Arrays;

public class MaximumGuests {
	
	// find max guests present at any given time
	void findMaximumGuestsPresent(int arrival[], int departure[]) {
		Arrays.sort(arrival);
		Arrays.sort(departure);
		
		int pointerA = 0;
		int pointerD = 0;
		int count = 0;
		int max = 0;
		while(pointerA < arrival.length) {
			if(arrival[pointerA] <= departure[pointerD]) {
				count++;
				pointerA++;
			}
			else {
				count--;
				pointerD++;
			}
			max = Math.max(max, count);
		}
		
		System.out.println(max);
	}

	
	public static void main(String[] args) {
		MaximumGuests m = new MaximumGuests();
		int arrival[] = {1, 2, 10, 5, 5, 4};
		int departure[] = {4, 5, 12, 9, 12};
		m.findMaximumGuestsPresent(arrival, departure);
	}
}