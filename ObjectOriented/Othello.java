
enum Direction {
	left, right, up, down
}

enum Color {
	black, white
}

class Piece {
	Color color;

	public Piece(Color color) {
		super();
		this.color = color;
	}
	
	void flipPiece() {
		if(color == Color.black)
			color = Color.white;
		else
			color = Color.black;
	}
}

class Board {
	private static Board instance = null;
	private int blackCount = 0;
	private int whiteCount = 0;
	private Piece[][] board;
	
	private Board() {
		board = new Piece[32][32];
	}
	
	public static Board getInstance() {
		if(instance == null)
			instance = new Board();
		return instance;
	}
	
	void placePiece(int row, int column, Color c) {
		Piece p = new Piece(c);
		board[row][column] = p;
		if(p.color == Color.black)
			blackCount++;
		else
			whiteCount++;
	}
	
	int getScore(Color c) {
		if(c == Color.black)
			return blackCount;
		else
			return whiteCount;
	}
	
	void updateScore() {
		//check the entire board and flip pieces as required
	}
}

class PlayerOthello {
	private String name;
	private Color color;
	public PlayerOthello(String name, Color color) {
		super();
		this.name = name;
		this.color = color;
	}
	public String getName() {
		return name;
	}
	public Color getColor() {
		return color;
	}
	
	void playMove(int row, int column) {
		Board.getInstance().placePiece(row, column, color);
	}
}

public class Othello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
