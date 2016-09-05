
import java.util.Arrays;

public class WallsGates {

	public void wallsAndGates(int[][] rooms) {
		int result[][] = new int[rooms.length][rooms[0].length];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				if(rooms[i][j] == -1)
					result[i][j] = -1;
				else
					result[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if (rooms[i][j] == 0) {
					boolean visited[][] = new boolean[rooms.length][rooms[0].length];
					wallsAndGatesDfs(rooms, result, i, j, 0, visited);
				}
			}
		}
		
		for(int i = 0; i < rooms.length; i++) {
			System.out.println(Arrays.toString(result[i]));
		}
	}

	void wallsAndGatesDfs(int[][] rooms, int[][] result, int i, int j,
			int count, boolean[][] visited) {
		if (i < 0 || i >= result.length || j < 0 || j >= result[0].length
				|| rooms[i][j] == -1 || visited[i][j])
			return;
		visited[i][j] = true;
		result[i][j] = Math.min(result[i][j], count);
		wallsAndGatesDfs(rooms, result, i - 1, j, count + 1, visited);
		wallsAndGatesDfs(rooms, result, i, j + 1, count + 1, visited);
		wallsAndGatesDfs(rooms, result, i + 1, j, count + 1, visited);
		wallsAndGatesDfs(rooms, result, i, j - 1, count + 1, visited);
	}

	public static void main(String[] args) {
		WallsGates wg = new WallsGates();
		int rooms[][] = {{Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE}, 
				{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
				{Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
				{0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}};
		wg.wallsAndGates(rooms);

	}

}
