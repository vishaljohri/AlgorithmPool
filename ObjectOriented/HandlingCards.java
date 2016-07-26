
enum Suit {
	Club (0), Diamond (1), Heart (2), Spade (3);
	private int value;
	private Suit(int v) {
		value = v;
	}
	public int getValue() {
		return value;
	}
}

public class HandlingCards {
	
	private int handCards[][];
	public HandlingCards() {
		//defining deck of cards as 2d array
		handCards = new int[4][13];
	}
	
	void setCard(Suit s, int value) {
		handCards[s.getValue()][value-1] = 1;
	}
	
	void unsetCard(Suit s, int value) {
		if(handCards[s.getValue()][value-1] == 0) {
			System.out.println("you don't have this card");
			return;
		}
		handCards[s.getValue()][value-1] = 0;
	}
	
	void setAllCards() {
		//set all the cards initially
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 13; j++) {
				handCards[i][j] = 1;
			}
		}
	}
	
	int getSumOfValues() {
		int sum = 0;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 13; j++) {
				if(handCards[i][j] == 1)
					sum = sum + j+1;
			}
		}
		return sum;
	}
	public static void main(String[] args) {
		HandlingCards handlingCards = new HandlingCards();
		handlingCards.setCard(Suit.Heart, 9);
		handlingCards.setCard(Suit.Club, 1);
		System.out.println(handlingCards.getSumOfValues());
	}
}


