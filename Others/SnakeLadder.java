
import java.util.LinkedList;

class Cell {
	int location;
	int dist;

	public Cell(int location, int dist) {
		super();
		this.location = location;
		this.dist = dist;
	}

}

public class SnakeLadder {

	int snakeLadder(int board[], int n) {
		LinkedList<Cell> queue = new LinkedList<>();
		int result = 0;
		queue.add(new Cell(board[0], 0));
		boolean visited[] = new boolean[n];

		while (queue.size() != 0) {
			Cell c = queue.poll();

			// if reached last cell
			if (c.location == n - 1) {
				result = c.dist;
				break;
			}

			for (int i = c.location + 1; i <= c.location + 6 && i < n; i++) {
				if (!visited[i]) {
					visited[i] = true;

					// check if snake or ladder is present at current location
					if (board[i] == -1) 
						queue.add(new Cell(i, c.dist + 1));
					 else 
						queue.add(new Cell(board[i], c.dist + 1));
				}
			}

		}
		return result;
	}

	public static void main(String[] args) {
		int n = 30;
		int moves[] = new int[n];
		for (int i = 0; i < n; i++)
			moves[i] = -1;

		// Ladders
		moves[2] = 21;
		moves[4] = 7;
		moves[10] = 25;
		moves[19] = 28;

		// Snakes
		moves[26] = 0;
		moves[20] = 8;
		moves[16] = 3;
		moves[18] = 6;
		
		SnakeLadder sl = new SnakeLadder();
		System.out.println(sl.snakeLadder(moves, n));

	}

}
