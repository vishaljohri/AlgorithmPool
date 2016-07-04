
import java.util.ArrayList;
import java.util.HashMap;

public class ClassSchedule {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
		for (int i = 0; i < prerequisites.length; i++) {
			if (!hm.containsKey(prerequisites[i][0])) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(prerequisites[i][1]);
				hm.put(prerequisites[i][0], list);
			} else {
				hm.get(prerequisites[i][0]).add(prerequisites[i][1]);
			}
		}

		boolean visited[] = new boolean[numCourses];
		boolean stack[] = new boolean[numCourses + 1];
		for (int i = 0; i < numCourses; i++) {
			if (!visited[i]) {
				dfsCycle(hm, numCourses, visited, stack, i);
				if (stack[numCourses] == true)
					return false;
			}
		}
		return true;
	}

	void dfsCycle(HashMap<Integer, ArrayList<Integer>> hm, int n,
			boolean[] visited, boolean[] stack, int start) {
		stack[start] = true;
		visited[start] = true;
		ArrayList<Integer> adjacent = hm.get(start);
		if (adjacent != null) {
			for (int i : adjacent) {
				if (stack[i])
					stack[n] = true;
				if (!visited[i] && !stack[i]) {
					dfsCycle(hm, n, visited, stack, i);
				}
			}
		}
		stack[start] = false;

	}

	public static void main(String[] args) {
		int a[][] = { { 1, 0 } };
		ClassSchedule cs = new ClassSchedule();
		System.out.println(cs.canFinish(2, a));

	}

}
