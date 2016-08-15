
public class FindObjects {
	
	// find no of objects surrounded by 0
	void findObjects(int a[][]) {
		int rows = a.length;
		int cols = a[0].length;
		boolean visited[][] = new boolean[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(a[i][j] != 0 && !visited[i][j]) {
					visitNodes(a, i, j, visited);
					System.out.println();
				}
			}
		}
	}
	
	// similar to dfs algo
	void visitNodes(int a[][], int i, int j, boolean visited[][]) {
		if(i < 0 || i >= a.length || j < 0 || j >= a[0].length || a[i][j] == 0 || visited[i][j])
			return;
		visited[i][j] = true;
		visitNodes(a, i - 1, j, visited);
		visitNodes(a, i, j + 1, visited);
		visitNodes(a, i + 1, j, visited);
		visitNodes(a, i, j - 1, visited);
		System.out.print(a[i][j] + " ");
	}

	public static void main(String[] args) {
		FindObjects f = new FindObjects();
		int a[][] = {{0, 1, 0, 0, 4}, {0, 4, 4, 0, 0}, {0, 0, 0, 0, 2}, {0, 0, 5, 0, 2}, {0, 0, 0, 0, 0}};
		f.findObjects(a);

	}

}
