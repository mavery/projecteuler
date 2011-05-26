package mavery.projecteuler;

public class Problem4
{

	/**
	 * A palindromic number reads the same both ways. The largest palindrome
	 * made from the product of two 2-digit numbers is 9009 = 91 99.
	 * 
	 * Find the largest palindrome made from the product of two 3-digit numbers.
	 */
	public static void main(String[] args)
	{
		int result = 0;

		for (int a = 100; a < 1000; a++)
		{
			for (int b = 100; b < 1000; b++)
			{
				int currentRes = a * b;
				if (currentRes > result && isPalindrome(currentRes))
				{
					result = currentRes;
				}
			}
		}
		
		System.out.println(result);

	}

	public static boolean isPalindrome(int input)
	{
		String str = Integer.toString(input);
		for (int i = 0; i < str.length() / 2; i++)
		{
			if (str.charAt(i) != str.charAt(str.length() - i - 1))
			{
				return false;
			}
		}
		return true;
	}

}
