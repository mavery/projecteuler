package mavery.projecteuler;

import java.util.ArrayList;
import java.util.List;

import mavery.projecteuler.util.EulerUtils;


public class Problem36
{

	/**
	 * The decimal number, 585 = 1001001001 (binary), is palindromic in both
	 * bases.
	 * 
	 * Find the sum of all numbers, less than one million, which are palindromic
	 * in base 10 and base 2.
	 * 
	 * (Please note that the palindromic number, in either base, may not include
	 * leading zeros.)
	 */
	public static void main(String[] args)
	{
		int result = 0;
		
		for (String pd : palindromicDecimals(6))
		{
			int current = Integer.parseInt(pd);
			if (EulerUtils.isPalindrome(Integer.toBinaryString(current)))
			{
				result += current;
				System.out.println(pd + " " + Integer.toBinaryString(current));
			}
		}
		
		System.out.println(result);

	}

	public static List<String> palindromicDecimals(int maxDigits)
	{
		List<String> result = new ArrayList<String>();
		
		int limit = (int) (Math.pow(10, (int) (maxDigits / 2)));
		for (int i = 1; i < limit; i++)
		{
			String iString = Integer.toString(i);
			result.add(constructPalindrome(iString, false));
			if (iString.length() * 2 <= maxDigits)
			{
				result.add(constructPalindrome(iString, true));
			}
		}
		
		return result;
	}
	
	public static String constructPalindrome(String s, boolean repeatLastChar)
	{		
		StringBuilder builder = new StringBuilder();
		builder.append(s);
		for (int i = repeatLastChar ? 0 : 1; i < s.length(); i++)
		{
			builder.append(s.charAt(s.length() - i - 1));
		}
		
		return builder.toString();
	}
}
