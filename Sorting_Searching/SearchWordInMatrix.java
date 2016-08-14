
public class SearchWordInMatrix {

	public boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				boolean visited[][] = new boolean[board.length][board[0].length];
				if (existHelper(board, i, j, word, visited))
					return true;
			}
		}
		return false;
	}

	boolean existHelper(char board[][], int i, int j, String word,
			boolean visited[][]) {
		if (word.length() == 0)
			return true;
		if (i == -1 || j == -1 || i == board.length || j == board[0].length
				|| visited[i][j] || board[i][j] != word.charAt(0))
			return false;
		visited[i][j] = true;
		return existHelper(board, i + 1, j, word.substring(1), visited)
				|| existHelper(board, i, j + 1, word.substring(1), visited)
				|| existHelper(board, i - 1, j, word.substring(1), visited)
				|| existHelper(board, i, j - 1, word.substring(1), visited);
	}

	public static void main(String[] args) {
		SearchWordInMatrix s = new SearchWordInMatrix();
		char board[][] = {{'a', 'b', 'c', 'e'}, {'s', 'f', 'e', 's'}, {'a', 'd', 'e', 'e'}};
		System.out.println(s.exist(board, "abcesee"));

	}

}
