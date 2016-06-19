public class NumberIslands {
	
	public int numIslands(char[][] grid) {
		if(grid.length == 0)
			return 0;
		int rows = grid.length;
		int cols = grid[0].length;
		boolean visited[][] = new boolean[rows][cols];
		int result = 0;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(!visited[i][j] && grid[i][j] == '1') {
					visitIsland(grid, i, j, visited);
					result++;
				}
			}
		}
		return result;
	}
	
	void visitIsland(char[][] grid, int i, int j, boolean[][] visited) {
		int rows = grid.length;
		int cols = grid[0].length;
		visited[i][j] = true;
		if(i > 0 && grid[i - 1][j] == '1' && !visited[i - 1][j])
			visitIsland(grid, i - 1, j, visited);
		if(i < rows - 1 && grid[i + 1][j] == '1' && !visited[i + 1][j])
			visitIsland(grid, i + 1, j, visited);
		if(j > 0 && grid[i][j - 1] == '1'&& !visited[i][j - 1])
			visitIsland(grid, i, j - 1, visited);
		if(j < cols - 1 && grid[i][j + 1] == '1' && !visited[i][j + 1])
			visitIsland(grid, i, j + 1, visited);
	}
	
	public static void main(String[] args) {
		NumberIslands n = new NumberIslands();
		char a[][] = {{'1', '1', '0', '0', '1'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
		System.out.println(n.numIslands(a));
	}

}
