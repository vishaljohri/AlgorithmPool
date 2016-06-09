class TreeNodeAVL {
	int key;
	TreeNodeAVL left;
	TreeNodeAVL right;
	TreeNodeAVL parent;

	public TreeNodeAVL(int value) {
		this.key = value;
		left = null;
		right = null;
		parent = null;
	}
}

public class AVLTree {
	TreeNodeAVL root;

	AVLTree() {
		root = null;
	}

	void insert(TreeNodeAVL cur, int value) {
		if (root == null) {
			root = new TreeNodeAVL(value);
		} else {
			if (value > cur.key) {
				if (cur.right != null)
					insert(cur.right, value);
				else {
					TreeNodeAVL newNode = new TreeNodeAVL(value);
					cur.right = newNode;
					newNode.parent = cur;
					rebalance(newNode);
				}

			} else {
				if (cur.left != null)
					insert(cur.left, value);
				else {
					TreeNodeAVL newNode = new TreeNodeAVL(value);
					cur.left = newNode;
					newNode.parent = cur;
					rebalance(newNode);
				}
			}
		}
	}

	void rebalance(TreeNodeAVL cur) {
		while (cur.parent != null) {
			TreeNodeAVL parentNode = cur.parent;
			TreeNodeAVL leftParent = parentNode.left;
			TreeNodeAVL rightParent = parentNode.right;
			if (height(leftParent) - height(rightParent) >= 2) {
				if (height(parentNode.left.left) > height(parentNode.left.right))
					rotateLeft(parentNode);
				else
					doubleRotateLeft(parentNode);
				return;
			} else if (height(leftParent) - height(rightParent) <= -2) {
				if (height(parentNode.right.right) > height(parentNode.right.left))
					rotateRight(parentNode);
				else
					doubleRotateRight(parentNode);
				return;
			}
			cur = cur.parent;
		}
	}

	void levelTraversal(TreeNodeAVL cur) {
		if (cur == null)
			return;
		else {
			java.util.Queue<TreeNodeAVL> queueNodes = new java.util.LinkedList<>();
			queueNodes.add(cur);
			while (queueNodes.size() != 0) {
				TreeNodeAVL temp = queueNodes.poll();
				System.out.print(temp.key + " ");
				if (temp.left != null)
					queueNodes.add(temp.left);
				if (temp.right != null)
					queueNodes.add(temp.right);
			}
		}
	}

	void rotateLeft(TreeNodeAVL cur) {
		TreeNodeAVL temp = cur.left;
		TreeNodeAVL parentCur = cur.parent;
		cur.left = temp.right;
		temp.right = cur;
		if (parentCur != null) {
			if (parentCur.right == cur)
				parentCur.right = temp;
			else
				parentCur.left = temp;
		}
		else {
			root = temp;
		}
		// update parents
		temp.parent = cur.parent;
		cur.parent = temp;
		if (cur.left != null)
			cur.left.parent = cur;
	}

	void rotateRight(TreeNodeAVL cur) {
		TreeNodeAVL temp = cur.right;
		TreeNodeAVL parentCur = cur.parent;
		cur.right = temp.left;
		temp.left = cur;
		if (parentCur != null) {
			if (parentCur.right == cur)
				parentCur.right = temp;
			else
				parentCur.left = temp;
		}
		else {
			root = temp;
		}
		// update parents
		temp.parent = cur.parent;
		cur.parent = temp;
		if (cur.right != null)
			cur.right.parent = cur;
	}

	void doubleRotateLeft(TreeNodeAVL cur) {
		TreeNodeAVL temp = cur.left;
		rotateRight(temp);
		rotateLeft(cur);
	}

	void doubleRotateRight(TreeNodeAVL cur) {
		TreeNodeAVL temp = cur.right;
		rotateLeft(temp);
		rotateRight(cur);
	}

	int height(TreeNodeAVL cur) {
		if (cur == null)
			return 0;
		else
			return 1 + Math.max(height(cur.left), height(cur.right));
	}

	public static void main(String[] args) {
		AVLTree avl = new AVLTree();
		avl.insert(avl.root, 4);
		avl.insert(avl.root, 2);
		avl.insert(avl.root, 7);
		avl.insert(avl.root, 6);
		avl.insert(avl.root, 8);
		avl.insert(avl.root, 5);
		avl.levelTraversal(avl.root);

	}

}
