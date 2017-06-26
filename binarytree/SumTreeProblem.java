package binarytree;

import java.util.ArrayList;

import tree.Node;
import tree.binarytree.BinaryTree;

public class SumTreeProblem {
	public static void convertSumTree(Node root){
		if(root != null)
			convertSumTreeUtil(root);
	}
	
	private static int convertSumTreeUtil(Node root){
		if(root == null) return 0;
		int leftSubTreeSum = convertSumTreeUtil(root.getLeft());
		int rightSubTreeSum = convertSumTreeUtil(root.getRight());
		int currentNodeValue = root.getValue();
		root.setValue(leftSubTreeSum + rightSubTreeSum);
		return leftSubTreeSum + rightSubTreeSum + currentNodeValue;
	}
	
	public static void print(ArrayList<Integer> elements){
		for(int element : elements){
			System.out.print(element + " ");
		}
	}
	
	public static void main(String[] args){
		BinaryTree binaryTree = new BinaryTree();
		int[] elements = {10, -2, 6, 8, -4, 7, 5};
		binaryTree.add(elements);
		SumTreeProblem.convertSumTree(binaryTree.getRoot());
		ArrayList<Integer> result = binaryTree.levelOrderTravesal();
		SumTreeProblem.print(result);
	}
}
