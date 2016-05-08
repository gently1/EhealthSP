package com.eHealth.Problems;

public class Program {

	public static void main(String[] args) {
		// Test For Tree Trasversal: First Construct a tree
		TreeTrasversal treeTest = new TreeTrasversal();
		treeTest.TestTree();
		
		//Test For Character Finder
		CharacterFinder finder = new CharacterFinder();
		finder.Test();
		
		//Test CompactArray
		ArrayOperations arr = new ArrayOperations();
		arr.TestCompactArray();
		arr.TestArrayRotation();
		
		//Test Commom Multiple
		
		CommonMultiple lcm = new CommonMultiple();
		lcm.TestLCM();

	}

}
