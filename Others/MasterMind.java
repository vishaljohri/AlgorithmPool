
public class MasterMind {
	
	int code(char c) {
		switch(c) {
			case 'R':
				return 0;
			case 'G':
				return 1;
			case 'B':
				return 2;
			case 'Y':
				return 3;
			default:
				return -1;
		}
	}
	
	void result(String soln, String guess) {
		
		if(soln.length() != guess.length() || soln.length() != 4) {
			System.out.println("incorrect input");
			return;
		}
		
		int n = soln.length();
		int solnFrequency[] = new int[n];
		int guessFrequency[] = new int[n];
		int hits = 0;
		int pseudoHits = 0;
		for(int i = 0; i < n; i++) {
			char s = soln.charAt(i);
			char g = guess.charAt(i);
			
			//check if it is a hit
			if(s == g)
				hits++;
			else {
				//build frequency array
				solnFrequency[code(s)]++;
				guessFrequency[code(g)]++;
			}
		}
		
		//use frequency arrays to print pseudo hits
		for(int i = 0; i < n; i++) {
			if(solnFrequency[i] > 0 && guessFrequency[i] > 0)
				pseudoHits += Math.min(solnFrequency[i], guessFrequency[i]);
		}
		
		//print results
		System.out.println("hits = " + hits + " pseudohits = " + pseudoHits);
			
	}

	public static void main(String[] args) {
		MasterMind m = new MasterMind();
		m.result("YBYG", "YGRY");

	}

}
