package binarytree;

public class BinarySearchTreeHeihtTest {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		
		tree.insert(11);
		
		tree.insert(14);
		
		tree.insert(16);
		
		tree.insert(20);
		
		tree.insert(15);
		tree.insert(22);
		
		System.out.println(tree.height());
	}
}
