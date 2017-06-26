package binarytree;

import java.util.ArrayList;

import tree.Node;
import tree.binarytree.BinaryTree;

public class TreeBoundaryProblem {
	
	public static ArrayList<Integer> getTreeBoundary(Node root){
		if(root == null) return null;
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(root.getValue());
		leftNode(root.getLeft(), result);
		leafNode(root.getLeft(), result);
		leafNode(root.getRight(), result);
		rightNode(root.getRight(), result);
		return result;
	}
	
	private static void leafNode(Node root, ArrayList<Integer> elemenst){
		if(root != null){
			Node left = root.getLeft();
			Node right = root.getRight();
			if(left == null && right == null)
				elemenst.add(root.getValue());
			leafNode(left, elemenst);
			leafNode(right, elemenst);
		}
	}
	
	private static void leftNode(Node root, ArrayList<Integer> elemenst){
		if(root != null){
			Node left = root.getLeft();
			if(left != null){
				elemenst.add(root.getValue());
				leftNode(left, elemenst);
			}
		}
	}
	
	private static void rightNode(Node root, ArrayList<Integer> elemenst){
		if(root != null){
			Node right = root.getRight();
			if(right != null){
				elemenst.add(root.getValue());
				leftNode(right, elemenst);
			}
		}
	}
	
	public static void print(ArrayList<Integer> elements){
		System.out.print("Tree Boundary :: \n\t");
		elements.forEach(value -> System.out.print(value + " "));
		System.out.println();
	}
	public static void main(String[] args){
		BinaryTree binaryTree = new BinaryTree();
		int[] elements = {10, -2, 6, 8, -4, 7, 5};
		binaryTree.add(elements);
		ArrayList<Integer> result = TreeBoundaryProblem.getTreeBoundary(binaryTree.getRoot());
		TreeBoundaryProblem.print(result);
	}
}
