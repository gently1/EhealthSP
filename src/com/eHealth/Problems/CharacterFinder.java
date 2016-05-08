package com.eHealth.Problems;

public class CharacterFinder 
{
	public String find_chars(String str1, String str2)
	{

	    StringBuilder sameWords = new StringBuilder();
	    
		for (int i = 0;i < str1.length(); i++)
		{
			for (int j = 0;j < str2.length(); j++)
			{
				if(str1.charAt(i) == str2.charAt(j))
				{
					sameWords.append(str1.charAt(i));
				}
			}
		}
		    
	    
	    return sameWords.toString();
		
	}
	
	public String find_charsNOrder(String str1, String str2)
	{
		String sameWords = find_chars(str1, str2);
		
		char[] splitWords = sameWords.toCharArray();
		
		int length = splitWords.length;

		for(int i = 0; i < length; i++)
		{
		   for(int j = i + 1; j < length; j++)
		   {
		      if (splitWords[j] < splitWords[i]) 
		      {
		          char temp = splitWords[i];
		          splitWords[i] = splitWords[j];
		          splitWords[j] = temp;
		      }
		   }
		}
		
		return new String(splitWords);
	}
	
	public void Test()
	{
		System.out.println(" N*N Order: " + find_chars("yard","bandly"));
		System.out.println(" N Order: " + find_charsNOrder("yard","bandly"));
	}

}
