package mavery.projecteuler;

import java.math.BigInteger;

public class Problem56
{
	public static final int LIMIT = 100;

	/**
	 * A googol (10100) is a massive number: one followed by one-hundred zeros;
	 * 100100 is almost unimaginably large: one followed by two-hundred zeros.
	 * Despite their size, the sum of the digits in each number is only 1.
	 * 
	 * Considering natural numbers of the form, ab, where a, b 100, what is the
	 * maximum digital sum?
	 */
	public static void main(String[] args)
	{
		int maxSum = 0;
		for (int i = 2; i < LIMIT; i++)
		{
			BigInteger bigI = BigInteger.valueOf(i);
			for (int j = 2; j < LIMIT; j++)
			{
				int sum = digitalSum(bigI.pow(j));
				if (sum > maxSum)
				{
					maxSum = sum;
				}
			}
		}
		
		System.out.println(maxSum);
	}
	
	/**
	 * Returns the sum of the decimal digits of n. 
	 * @param n
	 * @return
	 */
	public static int digitalSum(BigInteger n)
	{
		String s = n.toString();
		
		int result = 0;
		for (int i = 0; i < s.length(); i++)
		{
			result += s.charAt(i) - '0';
		}
		return result;
	}

}
