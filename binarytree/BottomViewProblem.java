package binarytree;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import tree.Node;
import tree.binarytree.BinaryTree;

/*
 * Given a Binary Tree, we need to print the bottom view from left to right. A node x is there in output if x is 
 * the bottommost node at its horizontal distance. Horizontal distance of left child of a node x is equal to 
 * horizontal distance of x minus 1, and that of right child is horizontal distance of x plus 1.
 */

/**
 * 
 * @author Mahesh Gaonkar
 * @date 27-06-2017
 */
public class BottomViewProblem {
	
	public static ArrayList<Integer> getBottomView(final Node root){
		if(root == null) return null;
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		Queue<SimpleEntry<Node, Integer>> queue = new LinkedList<SimpleEntry<Node, Integer>>();
		
		queue.add(new SimpleEntry<Node, Integer>(root, 0));
		while(!queue.isEmpty()){
			AbstractMap.SimpleEntry<Node, Integer> pair = queue.poll();
			Node popNode = pair.getKey();
			int levelCount = pair.getValue();
			map.put(levelCount, popNode.getValue());
			if(popNode.getLeft() != null) queue.add(new SimpleEntry<Node, Integer>(popNode.getLeft(), levelCount - 1));
			if(popNode.getRight() != null) queue.add(new SimpleEntry<Node, Integer>(popNode.getRight(), levelCount + 1));
		}
		
		map.forEach((key, value) -> { result.add(value); });
		return result;
	}
	
	public static void print(final ArrayList<Integer> elements){
		for(int element : elements){
			System.out.print(element + " ");
		}
	}
	
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		int[] elements = {1, 2, 3, 4, 5, 6, 7};
		binaryTree.add(elements);
		ArrayList<Integer> result = BottomViewProblem.getBottomView(binaryTree.getRoot());
		BottomViewProblem.print(result);
		System.out.println();
		
		Node root = binaryTree.getRoot().getLeft();
		Node left = root.getLeft();
		left.setLeft(new Node(8));
		left.setRight(new Node(9));
		left.getRight().setLeft(new Node(11));
		
		Node right = root.getRight();
		right.setRight(new Node(10));
		right.getRight().setLeft(new Node(12));
		
		result = BottomViewProblem.getBottomView(binaryTree.getRoot());
		BottomViewProblem.print(result);		

	}

}
