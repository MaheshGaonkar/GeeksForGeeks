package binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import tree.Node;
import tree.binarytree.BinaryTree;

public class VerticalSumProblem {
	public static ArrayList<Integer> getVerticalSum(Node root){
		if(root == null) return null;
		
		Map<Integer, Integer> verticalSum = new HashMap<Integer, Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		getVerticalSumUtil(root,verticalSum, 0);
		verticalSum.forEach((key, value) -> {
			result.add(value);
		});
		
		return result;
	}
	
	private static void getVerticalSumUtil(Node root, Map<Integer, Integer> verticalSum, int verticalLevel){
		if(root != null){
			int value = verticalSum.containsKey(verticalLevel) ? verticalSum.get(verticalLevel) : 0;
			verticalSum.put(verticalLevel, value + root.getValue());
			getVerticalSumUtil(root.getLeft(),verticalSum, verticalLevel - 1);
			getVerticalSumUtil(root.getRight(),verticalSum, verticalLevel + 1);
		}
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
		ArrayList<Integer> result = VerticalSumProblem.getVerticalSum(binaryTree.getRoot());
		SumTreeProblem.print(result);
	}
}
