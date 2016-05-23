import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

public class TreeOperations {
	TreeNode root;
	int count = 0;
	ArrayList<Integer> al; // for storing traversed nodes in pre-order
	int rank = 0; // for rank of number

	public TreeOperations() {
		this.root = null;
		count = 0;
		al = new ArrayList<>();
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	void BSTInsertRecursive(int data, TreeNode cur) {
		if (cur == null) {
			count++;
			root = new TreeNode(data);
		} else {
			if (data > cur.data) {
				if (cur.right != null)
					BSTInsertRecursive(data, cur.right);
				else {
					cur.right = new TreeNode(data);
					count++;
				}
			} else {
				if (cur.left != null)
					BSTInsertRecursive(data, cur.left);
				else {
					cur.left = new TreeNode(data);
					count++;
				}
			}
		}
	}

	void BTInsert(int data, TreeNode cur) {
		if (cur == null) {
			root = new TreeNode(data);
			count++;
			return;
		}
		// like level order traversal
		java.util.Queue<TreeNode> queueNodes = new java.util.LinkedList<>();
		queueNodes.add(root);

		while (queueNodes.size() != 0) {
			TreeNode tn = queueNodes.poll();
			if (tn.left != null)
				queueNodes.add(tn.left);
			else {
				tn.left = new TreeNode(data);
				count++;
				return;
			}
			if (tn.right != null)
				queueNodes.add(tn.right);
			else {
				tn.right = new TreeNode(data);
				count++;
				return;
			}
		}
	}

	void levelTraversal(TreeNode cur) {
		if (cur == null)
			return;
		else {
			java.util.Queue<TreeNode> queueNodes = new java.util.LinkedList<>();
			queueNodes.add(cur);
			while (queueNodes.size() != 0) {
				TreeNode temp = queueNodes.poll();
				System.out.print(temp.data + " ");
				if (temp.left != null)
					queueNodes.add(temp.left);
				if (temp.right != null)
					queueNodes.add(temp.right);
			}
		}
	}

	void inOrderTraversal(TreeNode cur) {
		if (cur == null)
			return;
		inOrderTraversal(cur.left);
		System.out.print(cur.data + " ");
		inOrderTraversal(cur.right);
	}

	void preOrderTraversal(TreeNode cur) {
		if (cur == null)
			return;
		System.out.print(cur.data + " ");
		al.add(cur.data);
		preOrderTraversal(cur.left);
		preOrderTraversal(cur.right);
	}

	void postOrderTraversal(TreeNode cur) {
		if (cur == null)
			return;
		postOrderTraversal(cur.left);
		postOrderTraversal(cur.right);
		System.out.print(cur.data + " ");

	}

	void inOrderNumberRankProblem(TreeNode cur, int key) {
		if (cur == null) {
			return;
		}
		inOrderNumberRankProblem(cur.left, key);
		if (cur.data == key) {
			System.out.println("rank of element is: " + rank);
			return;
		}
		rank++;
		inOrderNumberRankProblem(cur.right, key);

	}

	int height(TreeNode cur) {
		if (cur == null)
			return 0;
		else
			return (1 + (Math.max(height(cur.left), height(cur.right))));
	}

	boolean findNode(int element, TreeNode cur) {
		if (cur == null)
			return false;
		else {
			if (element == cur.data)
				return true;
			else if (element > cur.data)
				return findNode(element, cur.right);
			else
				return findNode(element, cur.left);
		}
	}

	TreeNode findMin(TreeNode cur) {
		if (cur == null)
			return null;
		else {
			while (cur.left != null) {
				cur = cur.left;
			}
			return cur;
		}
	}

	TreeNode findMax(TreeNode cur) {
		if (cur == null)
			return null;
		else {
			while (cur.right != null) {
				cur = cur.right;
			}
			return cur;
		}
	}

	boolean IsBalanced(TreeNode cur) {
		if (cur == null) {
			System.out.println("no element in the tree");
			return true;
		} else {
			java.util.Queue<TreeNode> queueNodes = new java.util.LinkedList<>();
			queueNodes.add(cur);
			while (queueNodes.size() != 0) {
				TreeNode temp = queueNodes.poll();
				if (Math.abs(height(temp.left) - height(temp.right)) > 1) {
					System.out.println("tree is unbalanced");
					return false;
				}
				if (temp.left != null)
					queueNodes.add(temp.left);
				if (temp.right != null)
					queueNodes.add(temp.right);
			}
			System.out.println("balanced tree");
			return true;
		}
	}

	int IsBalancedOptimizedVersion(TreeNode cur) {
		if (cur == null) {
			return 0;
		} else {
			int leftSubtree = IsBalancedOptimizedVersion(cur.left);
			int rightSubtree = IsBalancedOptimizedVersion(cur.right);

			int diff = leftSubtree - rightSubtree;
			if (Math.abs(diff) > 1) {
				System.out.println("unbalanced tree");
				return -1;
			} else {
				return (Math.max(leftSubtree, rightSubtree) + 1);
			}

		}

	}

	TreeNode createMinimumHeightBST(int ar[], int first, int last) {
		if (first > last)
			return null;
		int mid = (first + last) / 2;
		TreeNode n = new TreeNode(ar[mid]);
		n.left = createMinimumHeightBST(ar, first, mid - 1);
		n.right = createMinimumHeightBST(ar, mid + 1, last);
		return n;

	}

	TreeNode lastVisited = null;

	boolean IsBST(TreeNode cur) {
		if (cur == null)
			return true;

		// check and recurse left
		if (!IsBST(cur.left))
			return false;

		// check current
		if (lastVisited != null && cur.data <= lastVisited.data)
			return false;
		lastVisited = cur;

		// check and recurse right
		if (!IsBST(cur.right))
			return false;
		return true;
	}

	void depthLists(TreeNode cur) {
		if (cur == null)
			return;
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
		LinkedList<TreeNode> l = new LinkedList<>();
		l.add(cur);
		while (l.size() != 0) {
			result.add(l);
			LinkedList<TreeNode> parents = l;
			l = new LinkedList<>();
			for (TreeNode parent : parents) {
				if (parent.left != null)
					l.add(parent.left);
				if (parent.right != null)
					l.add(parent.right);
			}
		}
		System.out.println(result);

	}

	boolean covers(TreeNode cur, int data) {
		if (cur == null)
			return false;
		if (cur.data == data)
			return true;
		return (covers(cur.left, data) || covers(cur.right, data));
	}

	TreeNode commonAncestorHelper(TreeNode cur, int first, int second) {
		if (cur == null)
			return null;
		if ((cur.data == first) || (cur.data == second))
			return cur;

		boolean isLeftFirst = covers(cur.left, first);
		boolean isLeftSecond = covers(cur.left, second);

		// if on diff sides return cur
		if (isLeftFirst != isLeftSecond)
			return cur;

		// else check which side to go as both on same side
		TreeNode childSide = isLeftFirst ? cur.left : cur.right;
		return commonAncestorHelper(childSide, first, second);
	}

	void commonAncestor(TreeNode cur, int first, int second) {
		/*
		 * basically four conditions should be kept in mind: 1) Check if both
		 * the given elements are there in tree. 2) See if one of the elements
		 * is cur node, if its true return cur. 3) See if given elements are
		 * present on different side of trees, if true return cur. 4) If given
		 * elements are present on same side, then call function recursively
		 * after checking which side to proceed.
		 */
		if (covers(cur, first) && covers(cur, second)) {
			System.out.println("common ancestor exists: "
					+ commonAncestorHelper(cur, first, second).data);
		} else {
			System.out.println("there is no common ancestor");
		}
	}

	boolean containsTree(TreeNode first, TreeNode second) {
		if (second == null)
			return true;
		return subTree(first, second);
	}

	boolean subTree(TreeNode first, TreeNode second) {
		if (first == null)
			return false;
		if (first.data == second.data) {
			if (matchTree(first, second))
				return true;
		}

		return ((subTree(first.left, second) || subTree(first.right, second)));
	}

	boolean matchTree(TreeNode first, TreeNode second) {
		if (first == null && second == null) // both empty
			return true;

		if (first == null || second == null) // if only one is empty
			return false;

		if (first.data != second.data)
			return false;

		return ((matchTree(first.left, second.left) && matchTree(first.right,
				second.right)));

	}

	void findSumAllPathsHelper(TreeNode cur, int sum, int path[], int level) {
		if (cur == null)
			return;
		path[level] = cur.data;

		// look for paths that end at this node
		int t = 0;
		for (int i = level; i >= 0; i--) {
			t = t + path[i];
			if (t == sum) {
				System.out.print("Path is: ");
				for (int j = i; j <= level; j++)
					System.out.print(path[j] + " ");
				System.out.println();
			}
		}

		// look for nodes beneath this one
		findSumAllPathsHelper(cur.left, sum, path, level + 1);
		findSumAllPathsHelper(cur.right, sum, path, level + 1);
	}

	void findSumAllPaths(TreeNode cur, int sum) {
		int ht = height(cur);
		int[] path = new int[ht];
		findSumAllPathsHelper(cur, sum, path, 0);
	}

	void mirror(TreeNode cur) {
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(cur);

		while (queue.size() != 0) {
			TreeNode first = queue.poll();
			TreeNode temp = first.left;
			first.left = first.right;
			first.right = temp;
			if (first.left != null)
				queue.add(first.left);
			if (first.right != null)
				queue.add(first.right);
		}

	}

	void mirrorRecursive(TreeNode cur) {
		if (cur == null)
			return;
		// appply pre-order traversal and swap
		// swap
		TreeNode temp = cur.left;
		cur.left = cur.right;
		cur.right = temp;

		mirrorRecursive(cur.left);
		mirrorRecursive(cur.right);

	}

	// detect cycle
	boolean detectCycle(ArrayList<ArrayList<Integer>> adjacencylist, int start) {
		int vertices = adjacencylist.size();
		boolean visited[] = new boolean[vertices];
		boolean stack[] = new boolean[vertices + 1];
		hasCycle(adjacencylist, visited, start, stack);
		int i = 0;
		while (i < adjacencylist.size()) {
			if (!visited[i]) {
				hasCycle(adjacencylist, visited, start, stack);
			}
			i++;
		}
		return stack[vertices];
	}

	void hasCycle(ArrayList<ArrayList<Integer>> adjacencylist,
			boolean[] visited, int v, boolean[] stack) {
		// logic is similar to dfs
		visited[v] = true;
		stack[v] = true;
		System.out.print(v + " ");
		for (int w : adjacencylist.get(v)) {
			if (stack[w])
				stack[stack.length - 1] = true;
			if (!visited[w] && !stack[w])
				hasCycle(adjacencylist, visited, w, stack);
		}
		stack[v] = false;
	}

	void dfs(ArrayList<ArrayList<Integer>> adjacencylist, int start) {
		int vertices = adjacencylist.size();
		boolean visited[] = new boolean[vertices];
		dfsHelper(adjacencylist, visited, start);

		// iterating left out vertices
		int i = 0;
		while (i < adjacencylist.size()) {
			if (!visited[i])
				dfsHelper(adjacencylist, visited, i);
			i++;
		}

	}

	void dfsHelper(ArrayList<ArrayList<Integer>> adjacencylist,
			boolean[] visited, int v) {
		visited[v] = true;
		System.out.print(v + " ");
		for (int w : adjacencylist.get(v)) {
			if (!visited[w])
				dfsHelper(adjacencylist, visited, w);
		}
	}

	void bfs(ArrayList<ArrayList<Integer>> adjacencyList, int v) {
		int vertices = adjacencyList.size();
		boolean[] visited = new boolean[vertices];
		LinkedList<Integer> list = new LinkedList<>();

		// call bfsHelper
		bfsHelper(adjacencyList, visited, v, list);
	}

	void bfsHelper(ArrayList<ArrayList<Integer>> adjacencyList,
			boolean[] visited, int v, LinkedList<Integer> list) {
		list.add(v);
		while (list.size() != 0) {
			int element = list.poll();
			System.out.print(element + " ");
			for (int i : adjacencyList.get(element)) {
				if (!visited[i]) {
					list.add(i);
					visited[i] = true;
				}
			}
		}
	}

	void IsPath(ArrayList<ArrayList<Integer>> adjacencyList, int start, int end) {
		int vertices = adjacencyList.size();
		boolean[] visited = new boolean[vertices];
		LinkedList<Integer> list = new LinkedList<>();

		// call bfsHelper
		bfsHelper(adjacencyList, visited, start, list);

		// check if end is visited
		if (visited[end])
			System.out.println("\npath exists");
		else
			System.out.println("\nthere is no path");
	}

	void printNeighbor(TreeNode cur) {
		LinkedList<TreeNode> list = new LinkedList<>();
		list.add(cur);
		list.add(null);
		while (list.size() > 1) {
			TreeNode temp = list.poll();
			if (temp == null)
				list.add(null);
			else {
				if (temp.left != null)
					list.add(temp.left);
				if (temp.right != null)
					list.add(temp.right);
				TreeNode next = list.peek();
				if (next != null)
					System.out.println(temp.data + " : " + next.data);
				else
					System.out.println(temp.data + " : " + next);
			}

		}

	}

	void numberLeaves(TreeNode cur) {
		int count = 0;
		LinkedList<TreeNode> list = new LinkedList<>();
		list.add(cur);
		while (list.size() != 0) {
			TreeNode temp = list.poll();
			if (temp.left == null && temp.right == null)
				count++;
			else {
				if (temp.left != null)
					list.add(temp.left);
				if (temp.right != null)
					list.add(temp.right);
			}
		}
		System.out.println("number of leaf nodes = " + count);
	}

	TreeNode convertToDLL(TreeNode cur) {
		if (cur == null)
			return null;
		cur = convertToDLLHelper(cur);
		while (cur.left != null)
			cur = cur.left;
		return cur;
	}

	TreeNode convertToDLLHelper(TreeNode cur) {
		if (cur == null)
			return null;

		if (cur.left != null) {
			TreeNode leftNode = convertToDLLHelper(cur.left);
			// find inorder predecessor
			for (; leftNode.right != null; leftNode = leftNode.right)
				;

			leftNode.right = cur;
			cur.left = leftNode;
		}

		if (cur.right != null) {
			TreeNode rightNode = convertToDLLHelper(cur.right);
			// find inorder successor
			for (; rightNode.left != null; rightNode = rightNode.left)
				;

			rightNode.left = cur;
			cur.right = rightNode;
		}

		return cur;
	}

	public ArrayList<String> serialize(TreeNode root) {
		ArrayList<String> s = new ArrayList<>();
		if (root == null) {
			s.add("n");
			return s;
		}
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (queue.size() != 0) {
			TreeNode cur = queue.poll();
			if (cur == null) {
				s.add("n");
				continue;
			}
			queue.add(cur.left);
			queue.add(cur.right);
			s.add(String.valueOf(cur.data));
		}
		return s;
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(ArrayList<String> data) {
		if (data.get(0).equals("n"))
			return null;
		TreeNode cur = new TreeNode(Integer.parseInt(data.get(0)));
		TreeNode rootTree = cur;
		LinkedList<TreeNode> queue = new LinkedList<>();
		for (int i = 0; i < data.size(); i++) {
			int leftLoc = 2 * i + 1;
			int rightLoc = 2 * i + 2;
			if (leftLoc < data.size()) {
				String left = data.get(leftLoc);
				if (left != "n") {
					TreeNode childLeft = new TreeNode(Integer.parseInt(left));
					cur.left = childLeft;
					queue.add(childLeft);
				}

			}
			if (rightLoc < data.size()) {
				String right = data.get(rightLoc);
				if (right != "n") {
					TreeNode childRight = new TreeNode(Integer.parseInt(right));
					cur.right = childRight;
					queue.add(childRight);
				}
			}
			cur = queue.poll();

		}
		return rootTree;
	}

	List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<Integer> list = new ArrayList<>();
		pathSumHelper(root, sum, list);
		return result;
	}

	void pathSumHelper(TreeNode root, int sum, List<Integer> list) {
		if (root == null)
			return;
		list.add(root.data);
		if (root.left == null && root.right == null && sum - root.data == 0) {
			result.add(new ArrayList<>(list));
		}
		pathSumHelper(root.left, sum - root.data, list);
		pathSumHelper(root.right, sum - root.data, list);
		list.remove(list.size() - 1);

	}

	HashMap<Integer, List<TreeNode>> hm = new HashMap<>();

	void columnTraversal(TreeNode root) {
		columnTraversalHelperMethod(root, 0);
		int min = Collections.min(hm.keySet());
		int max = Collections.max(hm.keySet());
		System.out.println(min + " " + max);
		for (int i = min; i <= max; i++) {
			List<TreeNode> result = hm.get(i);
			for (TreeNode t : result) {
				System.out.print(t.data + " ");
			}
		}
	}

	void columnTraversalHelperMethod(TreeNode root, int horDist) {
		if (root == null)
			return;
		if (!hm.containsKey(horDist)) {
			List<TreeNode> list = new ArrayList<>();
			list.add(root);
			hm.put(horDist, list);
		} else {
			hm.get(horDist).add(root);
		}

		columnTraversalHelperMethod(root.left, horDist - 1);
		columnTraversalHelperMethod(root.right, horDist + 1);

	}

	TreeNode deleteNodeInBST(TreeNode root, int value) {
		if (root == null)
			return null;
		if (root.data == value) {
			TreeNode rightNode = root.right;
			TreeNode leftNode = root.left;
			if (rightNode != null && leftNode != null) {
				TreeNode cur = leftNode;
				TreeNode prev = root;
				while (cur.right != null) {
					prev = cur;
					cur = cur.right;
				}
				root.data = cur.data;
				if (prev != root)
					prev.right = cur.left;
				else
					prev.left = cur.left;
			} else if (leftNode != null) {
				return root.left;
			} else {
				return root.right;
			}
		} else if (root.data > value)
			root.left = deleteNodeInBST(root.left, value);
		else
			root.right = deleteNodeInBST(root.right, value);

		return root;
	}

	public static void main(String[] args) {
		TreeOperations to = new TreeOperations();

		to.BSTInsertRecursive(5, to.root);
		to.BSTInsertRecursive(4, to.root);
		to.BSTInsertRecursive(2, to.root);
		to.BSTInsertRecursive(7, to.root);
		to.BSTInsertRecursive(10, to.getRoot());
		to.BSTInsertRecursive(9, to.getRoot());

		System.out.println("\nprinting in order traversal: ");
		to.inOrderTraversal(to.getRoot());

		System.out.println("\nprinting pre order traversal: ");
		to.preOrderTraversal(to.getRoot());

		System.out.println("\nprinting post order traversal: ");
		to.postOrderTraversal(to.getRoot());
		System.out.println();

		System.out.println("height of the tree is: " + to.height(to.getRoot()));

		System.out.println("seraching for a node: "
				+ to.findNode(9, to.getRoot()));
		System.out.println("seraching for a node: "
				+ to.findNode(6, to.getRoot()));

		System.out.println("Minimum element is: "
				+ to.findMin(to.getRoot()).data);

		System.out.println("Maximum element is: "
				+ to.findMax(to.getRoot()).data);

		// creating BT
		TreeOperations binaryTree = new TreeOperations();
		binaryTree.BTInsert(5, binaryTree.root);
		binaryTree.BTInsert(4, binaryTree.root);
		binaryTree.BTInsert(2, binaryTree.root);
		binaryTree.BTInsert(7, binaryTree.root);
		binaryTree.BTInsert(10, binaryTree.getRoot());
		binaryTree.BTInsert(9, binaryTree.getRoot());

		System.out.println("Inorder traversal of BT");
		binaryTree.inOrderTraversal(binaryTree.getRoot());

		System.out.println("\nlevel order traversal is: ");
		binaryTree.levelTraversal(binaryTree.getRoot());

		System.out.println("\nchecking for balanced bst:");
		System.out.println(to.IsBalanced(to.getRoot()));
		System.out.println("\nchecking for balanced bst optimized:");
		int x = (to.IsBalancedOptimizedVersion(to.getRoot()));
		if (x == -1)
			System.out.println("unbalanced");
		else
			System.out.println("balanced");

		System.out.println("checking for balanced bt");
		System.out.println(binaryTree.IsBalanced(binaryTree.getRoot()));
		System.out.println("checking for balanced bt optimized");
		x = (binaryTree.IsBalancedOptimizedVersion(binaryTree.getRoot()));
		if (x == -1)
			System.out.println("unbalanced");
		else
			System.out.println("balanced");

		System.out.println("constructing minimum ht BST from sorted array");
		int ar[] = { 1, 2, 3, 4, 5, 6, 7 };
		TreeOperations createBSTFromArray = new TreeOperations();
		createBSTFromArray.root = createBSTFromArray.createMinimumHeightBST(ar,
				0, ar.length - 1);
		System.out.println("height = "
				+ createBSTFromArray.height(createBSTFromArray.getRoot()));
		createBSTFromArray.levelTraversal(createBSTFromArray.getRoot());

		System.out.println("\nchecking BST: "
				+ binaryTree.IsBST(binaryTree.getRoot()));
		System.out.println("again checking the BST: " + to.IsBST(to.getRoot()));

		System.out.println("printing each level in link list: ");
		binaryTree.levelTraversal(binaryTree.getRoot());
		binaryTree.depthLists(binaryTree.getRoot());

		System.out.println("creating a new BT");
		TreeOperations binaryTest = new TreeOperations();
		binaryTest.BTInsert(5, binaryTest.getRoot());
		binaryTest.BTInsert(4, binaryTest.getRoot());
		binaryTest.BTInsert(2, binaryTest.getRoot());
		binaryTest.BTInsert(7, binaryTest.getRoot());
		binaryTest.BTInsert(10, binaryTest.getRoot());
		binaryTest.BTInsert(9, binaryTest.getRoot());
		binaryTest.BTInsert(8, binaryTest.getRoot());
		binaryTest.BTInsert(6, binaryTest.getRoot());
		binaryTest.BTInsert(1, binaryTest.getRoot());
		binaryTest.levelTraversal(binaryTest.getRoot());
		System.out.println("\nchecking if root covers: "
				+ binaryTest.covers(binaryTest.getRoot(), 6));
		System.out.println("checking if root covers: "
				+ binaryTest.covers(binaryTest.getRoot(), 0));
		System.out.println("checking for common ancestor");
		binaryTest.commonAncestor(binaryTest.getRoot(), 6, 10);
		binaryTest.commonAncestor(binaryTest.getRoot(), 6, 7);

		System.out.println("checking for subtree existence");
		TreeOperations subTree = new TreeOperations();
		subTree.BTInsert(4, subTree.getRoot());
		subTree.BTInsert(7, subTree.getRoot());
		subTree.BTInsert(10, subTree.getRoot());
		subTree.BTInsert(6, subTree.getRoot());
		subTree.BTInsert(1, subTree.getRoot());

		binaryTest.preOrderTraversal(binaryTest.getRoot());
		ArrayList<Integer> parent = binaryTest.al;
		System.out.println();
		System.out.println(parent);
		subTree.preOrderTraversal(subTree.getRoot());
		ArrayList<Integer> sub = subTree.al;
		System.out.println();
		System.out.println(sub);
		int flag = 1;
		// check similarly for inorder traversal as well
		int c = (parent.indexOf(sub.get(0)));
		if (c == -1) {
			System.out.println("not subtree");
		} else {
			for (int i = 0; i < sub.size(); i++) {
				if (sub.get(i) != parent.get(c++)) {
					flag = 0;
					break;
				}
			}
			if (flag == 1) {
				System.out.println("subtree found");
			} else {
				System.out.println("subtree is not found");
			}
		}

		System.out
				.println("again checking for subtree with optimized implementation");
		System.out.println(binaryTest.containsTree(binaryTest.getRoot(),
				subTree.getRoot()));

		System.out
				.println("checking for the paths with the given sum as input:");
		binaryTest.findSumAllPaths(binaryTree.getRoot(), 9);

		System.out.println("before creating mirror: ");
		binaryTest.levelTraversal(binaryTest.getRoot());
		binaryTest.mirror(binaryTest.getRoot());
		System.out.println("\n after creating the mirror");
		binaryTest.levelTraversal(binaryTest.getRoot());
		System.out.println("\napplying recursive mirror again");
		binaryTest.mirrorRecursive(binaryTest.getRoot());
		binaryTest.levelTraversal(binaryTest.getRoot());

		System.out.println("\nimplementing graphs");
		// creating graph by adjacency list using ArrayList<ArrayList>
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		// assuming 8 vertices add empty adjacency list for each
		for (int i = 0; i < 8; i++) {
			graph.add(new ArrayList<Integer>());
		}

		// insert neighboring vertices for each vertex
		graph.get(0).add(1);
		graph.get(0).add(2);
		graph.get(0).add(3);

		graph.get(1).add(5);
		graph.get(1).add(6);

		graph.get(2).add(4);

		graph.get(3).add(2);
		graph.get(3).add(4);

		graph.get(4).add(1);

		graph.get(6).add(5);

		// call dfs
		TreeOperations dummy = new TreeOperations();
		System.out.println("DFS:");
		dummy.dfs(graph, 0);

		// call bfs
		System.out.println("\nBFS:");
		dummy.bfs(graph, 0);

		// check path
		dummy.IsPath(graph, 0, 4);
		dummy.IsPath(graph, 0, 7);
		dummy.IsPath(graph, 5, 0);
		dummy.IsPath(graph, 2, 0);
		dummy.IsPath(graph, 4, 1);

		binaryTest.printNeighbor(binaryTest.getRoot());

		binaryTest.numberLeaves(binaryTest.getRoot());

		TreeOperations numberRank = new TreeOperations();
		numberRank.BSTInsertRecursive(20, numberRank.getRoot());
		numberRank.BSTInsertRecursive(15, numberRank.getRoot());
		numberRank.BSTInsertRecursive(25, numberRank.getRoot());
		numberRank.BSTInsertRecursive(10, numberRank.getRoot());
		numberRank.BSTInsertRecursive(5, numberRank.getRoot());
		numberRank.BSTInsertRecursive(13, numberRank.getRoot());
		numberRank.BSTInsertRecursive(23, numberRank.getRoot());
		numberRank.BSTInsertRecursive(24, numberRank.getRoot());

		numberRank.inOrderNumberRankProblem(numberRank.getRoot(), 25);

		// check for cycles in the graph
		System.out.println();
		System.out.println("\nchecking for cycle in the graph: "
				+ dummy.detectCycle(graph, 0));

		// testing bst for converting to dll
		TreeOperations treeToDoublyList = new TreeOperations();

		treeToDoublyList.BSTInsertRecursive(4, treeToDoublyList.root);
		treeToDoublyList.BSTInsertRecursive(2, treeToDoublyList.root);
		treeToDoublyList.BSTInsertRecursive(5, treeToDoublyList.root);
		treeToDoublyList.BSTInsertRecursive(1, treeToDoublyList.root);
		treeToDoublyList.BSTInsertRecursive(3, treeToDoublyList.getRoot());
		treeToDoublyList.BSTInsertRecursive(0, treeToDoublyList.getRoot());
		treeToDoublyList.BSTInsertRecursive(6, treeToDoublyList.root);

		TreeNode cur = treeToDoublyList.convertToDLL(treeToDoublyList.root);
		System.out.println("converting bst to linked list");
		while (cur != null) {
			System.out.print(cur.data + " ");
			cur = cur.right;
		}

		//
		TreeOperations serializationTest = new TreeOperations();
		serializationTest.BTInsert(-1, serializationTest.getRoot());
		serializationTest.BTInsert(0, serializationTest.getRoot());
		serializationTest.BTInsert(-1, serializationTest.getRoot());
		ArrayList<String> s = serializationTest.serialize(serializationTest
				.getRoot());
		System.out.println();
		System.out.println(s);
		serializationTest.deserialize(s);

		TreeOperations binaryTree2 = new TreeOperations();
		binaryTree2.BTInsert(2, binaryTree2.root);
		binaryTree2.BTInsert(5, binaryTree2.root);
		binaryTree2.BTInsert(5, binaryTree2.root);
		binaryTree2.pathSum(binaryTree2.root, 7);

		TreeOperations bTColumnTraversal = new TreeOperations();
		bTColumnTraversal.BTInsert(1, bTColumnTraversal.root);
		bTColumnTraversal.BTInsert(2, bTColumnTraversal.root);
		bTColumnTraversal.BTInsert(3, bTColumnTraversal.root);
		bTColumnTraversal.BTInsert(4, bTColumnTraversal.root);
		bTColumnTraversal.BTInsert(5, bTColumnTraversal.root);
		bTColumnTraversal.BTInsert(6, bTColumnTraversal.root);
		bTColumnTraversal.BTInsert(7, bTColumnTraversal.root);
		bTColumnTraversal.columnTraversal(bTColumnTraversal.root);

		// testing deletion of node
		TreeOperations treeBSTDelete = new TreeOperations();

		treeBSTDelete.BSTInsertRecursive(5, treeBSTDelete.root);
		treeBSTDelete.BSTInsertRecursive(2, treeBSTDelete.root);
		treeBSTDelete.BSTInsertRecursive(7, treeBSTDelete.root);
		treeBSTDelete.BSTInsertRecursive(1, treeBSTDelete.root);
		treeBSTDelete.BSTInsertRecursive(4, treeBSTDelete.getRoot());
		treeBSTDelete.BSTInsertRecursive(6, treeBSTDelete.getRoot());
		treeBSTDelete.BSTInsertRecursive(8, treeBSTDelete.root);
		treeBSTDelete.deleteNodeInBST(treeBSTDelete.root, 2);
		System.out.println();
		treeBSTDelete.inOrderTraversal(treeBSTDelete.root);

	}

}
