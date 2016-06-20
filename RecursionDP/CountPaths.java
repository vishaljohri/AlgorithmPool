public class CountPaths {

	int count(int curX, int curY, int X, int Y) {
		if(curX == X || curY == Y)
			return 1;
		else
			return count(curX+1, curY, X, Y) + count(curX, curY+1, X, Y); 
	}
	
	int countOptimized(int X, int Y) {
		if(X == 1 || Y == 1)
			return 1;
		else
			return countOptimized(X-1, Y) + countOptimized(X, Y-1);
	}
	
	int countDP(int x, int y) {
		int a[][] = new int[x][y];
		
		for(int i = 0; i < x; i++) {
			a[0][i] = 1;
		}
		
		for(int j = 0; j < y; j++) {
			a[j][0]= 1;
		}
		
		for(int i = 1; i < x; i++) {
			for(int j = 1; j < y; j++) {
				a[i][j] = a[i-1][j] + a[i][j-1];
			}
		}
		
		return a[x-1][y-1];
		
	}
	
	void printPaths(int curX, int curY, int X, int Y, String path) {
		
		if(curX == X-1) {
			for(int i = curY; i <= Y-1; i++) {
				path = path + curX + i;
			}
			System.out.println(path);
			return;
		}
		
		if(curY == Y-1) {
			for(int i = curX; i <= X-1; i++) {
				path = path + i + curY;
			}
			System.out.println(path);
			return;
		}
		
		path = path + curX + curY;
		printPaths(curX+1, curY, X, Y, path);
		printPaths(curX, curY+1, X, Y, path);
	}
	public static void main(String[] args) {
		CountPaths paths = new CountPaths();
		System.out.println("number of paths are: " + paths.count(1, 1, 5, 5));
		System.out.println("number of paths using optimized are: " + paths.countOptimized(4, 4));
		System.out.println("number of paths using dp: " + paths.countDP(4, 4));
		System.out.println("printing all the paths: ");
		paths.printPaths(0, 0, 5, 5, "");

	}

}
