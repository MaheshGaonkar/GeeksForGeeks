package binarytree;

import tree.Node;
import tree.binarytree.BinaryTree;

/**
 * @author Mahesh
 * @date 26-06-2017
 */
public class HeightBalancedProblem {

	public static boolean isBalanvedTree(Node root){
		if(root == null || root.isLeaf()) return true;
		return Integer.MIN_VALUE != isBalancedTreeUtil(root);
	}
	
	private static int isBalancedTreeUtil(Node root) {
		if(root == null) return 0;
		int leftHeight = isBalancedTreeUtil(root.getLeft());
		int rightHeight = isBalancedTreeUtil(root.getRight());
		int minValue = Integer.MIN_VALUE;
		if(Math.abs(leftHeight-rightHeight) > 1 || leftHeight == minValue || rightHeight == minValue)
			return minValue;
		else
			return Math.max(leftHeight, rightHeight) + 1;
	}
	
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		int[] elements = {1, 2, 3, 4, 5, 6, 7};
		binaryTree.add(elements);
		System.out.println("Height balanced tree : " + HeightBalancedProblem.isBalanvedTree(binaryTree.getRoot()));
		
		Node root = binaryTree.getRoot().getLeft();
		Node left = root.getLeft();
		left.setLeft(new Node(8));
		left.setRight(new Node(9));
		left.getRight().setLeft(new Node(11));
		
		Node right = root.getRight();
		right.setRight(new Node(10));
		right.getRight().setLeft(new Node(12));
		
		System.out.println("Height balanced tree : " + HeightBalancedProblem.isBalanvedTree(binaryTree.getRoot()));		
	}
}