package binarytree;

public class BinaryTreeHeight {

	public static void main(String[] args) {
		
		BinaryTree tree= new BinaryTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(3);
		tree.insert(6);
		tree.insert(9);
		tree.insert(101);
		tree.insert(99);
		tree.insert(99);
		System.out.println(tree.height());
	}
	
}
