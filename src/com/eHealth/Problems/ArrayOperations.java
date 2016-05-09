package com.eHealth.Problems;

import java.util.Arrays;

public class ArrayOperations 
{
	//This function assumes the array is already sorted
	public int[] compactArray(int[] sortedArray)
	{
		int length = sortedArray.length;
		//If array is already sorted, the last item in the array is the largest number in the array, so a bit table can only have a maximum of that
		boolean found[] = new boolean[sortedArray[length - 1] + 1];
		int[] uniqueArray = new int[length];
		
		for(int i = 0; i < length; i++)
		{
			//switch bit to 1 if array value is found
			found[sortedArray[i]] = true;
		}
		
		int count = 0;
		
		//Check all bit 1 values and add value to unique array
		for(int i = 0; i < found.length; i++)
		{
			if(found[i] == true)
			{
				uniqueArray[count] = i;
				count++;
			}
		}
		
		//compact array and return results
		 int[] compressed = new int[count];
		 System.arraycopy(uniqueArray, 0, compressed, 0, count);
		    
		return compressed;
		
	}
	
	public void TestCompactArray()
	{
		//input data must be sorted or the last value must be the largest
		int[] testData = new int[]{1,
				2,
				3,
				4,4,4,4,
				5,5,5,5,5,5,
				6,
				7,7,7,7,7,7,
				8,8,8,8,
				9,
				10,
				11,11,11,11,11,11,
				12,
				13,13,13,13,
				14};
		int[] ans = compactArray(testData);
		System.out.println("Compact Array: " + Arrays.toString(ans));
	}

	public int[] rotateArray(int[] arrayToRotate, int rotateBy)
	{
		int length = arrayToRotate.length;
		
		int[] rotatedArray = new int[length];
		int count = 0;
		
		//Split array at rotate pivot
		for(int i = length - rotateBy; i < length; i++)
		{
			rotatedArray[count] = arrayToRotate[i];
			count++;
		}
		
		//add remaining array values 
		for(int i = 0; i < length - rotateBy; i++)
		{
			rotatedArray[count] = arrayToRotate[i];
			count++;
		}
		
		return rotatedArray;
	}
	
	public void TestArrayRotation()
	{
		int[] testData = new int[]{1, 2, 3, 4, 5, 6};
		int[] ans = rotateArray(testData, 2);
		System.out.println("Rotate Array: " + Arrays.toString(ans));
	}
}
