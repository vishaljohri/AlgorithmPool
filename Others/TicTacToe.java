
public class TicTacToe {
	
	void winnerNXN(char [][]board) {
		
		int row = 0;
		int col = 0;
		
		//check for rows
		for(row = 0; row < board.length; row++) {
			if(board[row][0] != '\u0000') {
				for(col = 1; col < board.length; col++) {
					if(board[row][0] != board[row][col])
						break;
				}
				if(col == board.length) {
					System.out.println("winner is: " + board[row][0]);
					return;
				}
			}
		}
		
		//check for columns
		for(col = 0; col < board.length; col++) {
			if(board[0][col] != '\u0000') {
				for(row = 1; row < board.length; row++) {
					if(board[0][col] != board[row][col])
						break;
				}
				if(row == board.length) {
					System.out.println("winner is: " + board[0][col]);
					return;
				}
			}
		}
		
		//check for diagonal
		if(board[0][0] != '\u0000') {
			for(row = 1; row < board.length; row++) {
				if(board[0][0] != board[row][row])
					break;
			}
			if(row == board.length) {
				System.out.println("winner is: " + board[0][0]);
				return;
			}
		}
		
		//check for other diagonal
		if(board[board.length-1][0] != '\u0000') {
			for(row = 1; row < board.length; row++) {
				if(board[board.length-1][0] != board[board.length-1-row][row])
					break;
			}
			if(row == board.length) {
				System.out.println("winner is: " + board[board.length-1][0]);
				return;
			}
		}
		
		System.out.println("no winner");
		
	}
	
	void winner(char [][]board) {
		for(int i = 0; i < board.length; i++) {
			
			//check rows
			if(board[i][0] != '\u0000' && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
				System.out.println("winner is: " + board[i][0]);
				return;
			}
			
			//check columns
			if(board[0][i] != '\u0000' && board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
				System.out.println("winner is: " + board[0][i]);
			}
			
		}
		
		//check diagonals
		if(board[0][0] != '\u0000' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
			System.out.println("winner is: " + board[0][0]);
		}
		
		//check reverse diagonal
		if(board[2][0] != '\u0000' && board[2][0] == board[1][1] && board[2][0] == board[0][2]) {
			System.out.println("winner is: " + board[2][0]);
		}
		
		System.out.println("no winner");
	}

	public static void main(String[] args) {
		char [][]ticTac = new char[3][3];
		ticTac[1][0] = 'r';
		ticTac[1][1] = 'r';
		ticTac[1][2] = 'r';
		
		TicTacToe t = new TicTacToe();
		t.winner(ticTac);
		t.winnerNXN(ticTac);

	}

}
