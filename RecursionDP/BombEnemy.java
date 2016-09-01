class CellKilled {
	int left;
	int top;
	int right;
	int down;
}

public class BombEnemy {

	int maxKilledEnemies(char[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		CellKilled dp[][] = new CellKilled[rows][cols];
		int maxKilled = 0;

		// populate enemies which can be killed left/top of current
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				dp[i][j] = new CellKilled();
				if (grid[i][j] == 'W')
					continue;
				else if (grid[i][j] == 'E') {
					dp[i][j].left = (j > 0) ? dp[i][j - 1].left + 1 : 1;
					dp[i][j].top = (i > 0) ? dp[i - 1][j].top + 1 : 1;
				} else if (grid[i][j] == '0') {
					dp[i][j].left = (j > 0) ? dp[i][j - 1].left : 0;
					dp[i][j].top = (i > 0) ? dp[i - 1][j].top : 0;
				}
			}
		}

		// populate enemies which can be killed right/bottom of current
		for (int i = rows - 1; i >= 0; i--) {
			for (int j = cols - 1; j >= 0; j--) {
				if (grid[i][j] == 'W')
					continue;
				else if (grid[i][j] == 'E') {
					dp[i][j].right = (j < cols - 1) ? dp[i][j + 1].right + 1 : 1;
					dp[i][j].down = (i < rows - 1) ? dp[i + 1][j].down + 1 : 1;
				} else if (grid[i][j] == '0') {
					dp[i][j].right = (j < cols - 1) ? dp[i][j + 1].right : 0;
					dp[i][j].down = (i < rows - 1) ? dp[i + 1][j].down : 0;
					maxKilled = Math.max(maxKilled, dp[i][j].left
							+ dp[i][j].top + dp[i][j].right + dp[i][j].down);
				}
			}
		}

		return maxKilled;
	}

	public static void main(String[] args) {
		BombEnemy be = new BombEnemy();
		char grid[][] = { { '0', 'E', '0', 'E' }, { 'E', '0', 'W', 'E' },
				{ '0', 'E', '0', 'E' }, { '0', 'E', '0', '0' } };
		System.out.println(be.maxKilledEnemies(grid));
	}
}