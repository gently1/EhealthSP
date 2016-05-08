package com.eHealth.Problems;

import java.util.ArrayList;
import java.util.Stack;

public class TreeTrasversal
{
	
	/**
	 * TOPIC: TREE TRASVERSAL
	 * 
	 * Given a tree with parent node N1 and multiple child nodes N21, N22, N23 etc.
	 * 
	 * Considering that the immediate child nodes are lined up from left to right as written, and considering the character flow of English language is left to right
	 * we will consider a tree trasversal that is in the natural order (Left to Right). If the first parent child nodes are parents to other nodes, we will evaluate node
	 * values of the last child on the first left child node of the first parent node N1 as we are considering depth first.
	 * 
	 * Hence Node Trasversal, depth first, in the natural order:
	 * 
	 * Left Child -> Parent -> Right Child; Starting from the Last left Child upwards the tree.
	 * 
	 * See algorithm example below.
	 */
	
	
	//Class to define Tree Structure of integers
	public class TreeNode 
	{
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	
	 public ArrayList<Integer> trasverseTree(TreeNode root) 
	 {
	     
		 //Create a list to hold evaluation of trasversed nodes
         ArrayList<Integer> trasversedTreeValues = new ArrayList<Integer>();
 
         //return an empty array if tree is null
        if(root == null)
            return trasversedTreeValues; 
 
        //Create a stack of treenodes to be able to perform push and pop operations, Last-In-First-Out
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode p = root;
 
        while(!stack.empty() || p != null){
 
            // if it is not null, push to stack
            //and go down the tree to left
            if(p != null){
                stack.push(p);
                p = p.left;
 
            // if no left child
            // pop stack, process the node
            // then let p point to the right, this way, you process the last left child node first
            }else{
                TreeNode t = stack.pop();
                trasversedTreeValues.add(t.val);
                p = t.right;
            }
        }
 
        return trasversedTreeValues;
    }
	 
	 
	 public void TestTree()
	 {
		 //Create tree node switch.
		 boolean goRight = false;
		 
		 //Create Tree, Parent Value is 1, expect this to be last evaluated value
		 TreeNode parentNode = new TreeNode(1);
		 TreeNode previousNode = parentNode;
		 
		 //First value into the left node is 2, making all left node values to be even and right node values odd. 
		 //If our depth first evaluation works, all even values will come before the odd values, as this loop constructs a linear tree. 
		 //NOTE: The commented out previous nodes create a lopsided tree of one node per side
		for(int x = 2; x < 10; x++)
		{
			TreeNode node = new TreeNode(x);
			if(goRight)
			{
				//previousNode.right = node;
				previousNode = node;
			}
			else
			{
				//previousNode.right = node;
				previousNode.left = node;
				
			}
			goRight = !goRight;
			previousNode.right = node;
			
		}
		
		ArrayList<Integer> result =  trasverseTree(parentNode);
		for (Integer i : result) {
			System.out.println(i);
		}
		
	 }
}
