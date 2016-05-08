package com.eHealth.Problems;


public class CommonMultiple
{
	//Check for Greatest Common Divisor by testing
	public int GCD(int a, int b)
	{
		//if a is less than b, try switching positions and re-test
	    if (a < b) return GCD(b, a);
	    //if a divided by b returns no remainder then b is the common divisor 
	    if (a % b == 0) return b;
	    //Else try using b as input for a and the remainder of a divided by b for input of b
	    else return GCD(b, a % b);
	}


	//Find lowest common multiple of two integers by computing a x b divided by the greatest common divisor of a and b
	public int LCM(int a, int b)
	{
	    return ((a * b) / GCD(a, b));

	} 
	
	public int LcmOfArray(int[] arr, int start, int end)
	{
		//if array has just two elements, calculate lcm of the two
	    if ((end - start) == 1) 
	    	return LCM(arr[start],arr[end - 1]);
	    //else run a recursive that increases the start index of the array until above condition holds true, hence it will find the lcm of the last two elements
	    //of the array and return that as the second parameter to the next element until all elements have been evaluated
	    else return (LCM (arr[start], LcmOfArray(arr, start + 1, end)));
	}
	
	public int FindLCMofArray(int[] arr)
	{
		int length = arr.length;
		int ans = LcmOfArray(arr, 0, length);
		
		return ans;
	}
	
	public void TestLCM()
	{
		int[] testData = new int[]{1, 2, 3, 4, 5, 6,7, 8, 9, 10};
		int ans = FindLCMofArray(testData);
		System.out.println("LCM: " +ans);
	}
}
