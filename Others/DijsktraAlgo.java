
import java.util.Arrays;

public class DijsktraAlgo {

	void algorithmMatrix(int graph[][], int vertices, int start) {
		boolean visited[] = new boolean[vertices];
		int distance[] = new int[vertices];
		for (int i = 0; i < vertices; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[start] = 0;
		// iterate vertices - 1 times
		for (int i = 0; i < vertices - 1; i++) {
			int smallestDistanceNode = getSmallest(distance, visited);
			visited[smallestDistanceNode] = true;
			// update distance of adjacent nodes
			for (int j = 0; j < vertices; j++) {
				if ((!visited[j])
						&& (graph[smallestDistanceNode][j] != 0)
						&& (distance[j] > (distance[smallestDistanceNode] + graph[smallestDistanceNode][j]))) {
					distance[j] = distance[smallestDistanceNode] + graph[smallestDistanceNode][j];
				}

			}
		}
		System.out.println("final distance matrix is: " + Arrays.toString(distance));
	}

	int getSmallest(int distance[], boolean visited[]) {
		int minDistance = Integer.MAX_VALUE;
		int node = -1;
		// iterate through all the nodes and return smallest un-visited
		for (int i = 0; i < distance.length; i++) {
			if (!visited[i] && distance[i] < minDistance) {
				minDistance = distance[i];
				node = i;
			}
		}
		return node;
	}

	public static void main(String[] args) {
		//create matrix of nodes distance
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
				{ 4, 0, 8, 0, 0, 0, 0, 11, 0 }, { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
				{ 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
				{ 0, 0, 4, 0, 10, 0, 2, 0, 0 }, { 0, 0, 0, 14, 0, 2, 0, 1, 6 },
				{ 8, 11, 0, 0, 0, 0, 1, 0, 7 }, { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

		DijsktraAlgo d = new DijsktraAlgo();
		d.algorithmMatrix(graph, graph.length, 0);

	}

}
