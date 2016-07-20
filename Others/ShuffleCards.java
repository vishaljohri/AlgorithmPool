
import java.util.Arrays;

public class ShuffleCards {
	
	int rand(int lower, int higher) {
		return (int) (lower + (Math.random() * (higher - lower + 1)));
	}
	
	void shuffleCards(int cards[]) {
		for(int i = 0; i < cards.length; i++) {
			int k = rand(0, i);
			
			//swap
			int temp = cards[k];
			cards[k] = cards[i];
			cards[i] = temp;
		}
		System.out.println(Arrays.toString(cards));
	}
	
	void pickMFromNIteratively(int []original, int m) {
		int []subset = new int[m];
		
		//assign first m from original to subset
		for(int i = 0; i < m; i++) {
			subset[i] = original[i];
		}
		
		for(int i = m; i < original.length; i++) {
			int k = rand(0, i);
			if(k < m)
				subset[k] = original[i];
		}
		System.out.println(Arrays.toString(subset));
		
	}
	
	public static void main(String[] args) {
		int cards[] = new int [52];
		for(int i = 0; i < cards.length; i++) {
			cards[i] = i+1;
		}
		
		ShuffleCards s = new ShuffleCards();
		s.shuffleCards(cards);
		
		int original[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		s.pickMFromNIteratively(original, 5);

	}

}
