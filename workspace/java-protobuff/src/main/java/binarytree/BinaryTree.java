package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTree {

	private BinaryTreeNode root;

	public void insert(int value) {
		BinaryTreeNode newNode = new BinaryTreeNode(value, null, null);
		if (root == null) {
			// no data present at all
			root = newNode;
		} else {
			LinkedList<BinaryTreeNode> queue = new LinkedList<>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				BinaryTreeNode queueTop = queue.peek();
				if (queueTop.getLeft() == null) {
					queueTop.setLeft(newNode);
					return;
				}
				if (queueTop.getRight() == null) {
					queueTop.setRight(newNode);
					return;
				}
				queue.offer(queueTop.getLeft());
				queue.offer(queueTop.getRight());
				// so that next elemtn is picked up
				queue.poll();
			}
		}
	}

	public void traverseLevelOrder() {
		if (root == null) {
			throw new RuntimeException("tree is empty");
		}
		LinkedList<BinaryTreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode queueHead = queue.peek();
			if (queueHead.getLeft() != null) {
				queue.offer(queueHead.getLeft());
			}
			if (queueHead.getRight() != null) {
				queue.offer(queueHead.getRight());
			}
			System.out.println("Node found with value " + queue.poll().getValue());
		}
	}

	public void traversePreOrder() {
		if (root == null) {
			throw new RuntimeException("tree is empty");
		}
		traversePreOrderRecursively(root);
	}

	private void traversePreOrderRecursively(BinaryTreeNode node) {
		if (node == null) {
			return;
		}
		System.out.println("Node found with value " + node.getValue());
		traversePreOrderRecursively(node.getLeft());
		traversePreOrderRecursively(node.getRight());

	}

	public void traverseInOrder() {
		if (root == null) {
			throw new RuntimeException("tree is empty");
		}
		traverseInOrderRecursively(root);
	}

	private void traverseInOrderRecursively(BinaryTreeNode node) {
		if (node == null) {
			return;
		}
		traverseInOrderRecursively(node.getLeft());
		System.out.println("Node found with value " + node.getValue());
		traverseInOrderRecursively(node.getRight());

	}

	public void traversePostOrder() {
		if (root == null) {
			throw new RuntimeException("tree is empty");
		}
		traversePostOrderRecursively(root);
	}

	private void traversePostOrderRecursively(BinaryTreeNode node) {
		if (node == null) {
			return;
		}
		traversePostOrderRecursively(node.getLeft());
		traversePostOrderRecursively(node.getRight());
		System.out.println("Node found with value " + node.getValue());
	}

	public BinaryTreeNode searchItem(int value) {
		if (root == null) {
			throw new RuntimeException("tree is empty");
		}
		LinkedList<BinaryTreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode headQueue = queue.peek();
			if (headQueue.getValue() == value) {
				// first found node is returned and others are ignored
				return headQueue;
			}
			if (headQueue.getLeft() != null) {
				queue.offer(headQueue.getLeft());
			}
			if (headQueue.getRight() != null) {
				queue.offer(headQueue.getRight());
			}
			queue.poll();
		}
		throw new RuntimeException("Value " + value + " not present in tree");
	}

	public void deleteNode(int value) {
		if (root == null) {
			throw new RuntimeException("tree is empty");
		}
		if (value == root.getValue() && root.getLeft() == null && root.getRight() == null) {
			// as only one tiem is present lets save loop
			root = null;
		} else {
			// more than one item present
			List<BinaryTreeNode> populateDeepestNodeData = populateDeepestNodeData();
			BinaryTreeNode deepestNode = populateDeepestNodeData.get(populateDeepestNodeData.size() - 1);
			BinaryTreeNode secondDeepest = populateDeepestNodeData.get(populateDeepestNodeData.size() - 2);
			BinaryTreeNode actualNodetoDelete = searchItem(value);
			actualNodetoDelete.setValue(deepestNode.getValue());
			if (secondDeepest.getLeft() == deepestNode) {
				secondDeepest.setLeft(null);
			} else if (secondDeepest.getRight() == deepestNode) {
				secondDeepest.setRight(null);
			}
		}
	}

	private List<BinaryTreeNode> populateDeepestNodeData() {
		if (root == null) {
			throw new RuntimeException("tree is empty");
		}
		BinaryTreeNode deepestNode = null;
		LinkedList<BinaryTreeNode> queue = new LinkedList<>();
		queue.offer(root);
		List<BinaryTreeNode> items = new ArrayList<BinaryTreeNode>();
		while (!queue.isEmpty()) {
			BinaryTreeNode queueHead = queue.peek();
			if (queueHead.getLeft() != null) {
				queue.offer(queueHead.getLeft());
			}
			if (queueHead.getRight() != null) {
				queue.offer(queueHead.getRight());
			}
			deepestNode = queue.poll();
			items.add(deepestNode);

		}
		return items;
	}

	public void deleteTree() {
		// enough fo rll other objects to be applicable for garbage collections
		root = null;
	}

	public int height() {
		if (root == null) {
			return 0;
		}
		return heightRecursively(root, 1);
	}

	private int heightRecursively(BinaryTreeNode root, int iteration) {

		// both are null
		if (root.getLeft() == null && root.getRight() == null) {
			return iteration;
		}

		// height of left
		int leftHeight = 0;
		if (root.getLeft() != null) {
			leftHeight = heightRecursively(root.getLeft(), iteration+1);
		}

		// height of right
		// height of left
		int rightHeight = 0;
		if (root.getRight() != null) {
			rightHeight = heightRecursively(root.getRight(), iteration+1);
		}
		return Math.max(leftHeight, rightHeight);
	}

}