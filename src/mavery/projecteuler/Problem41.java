package mavery.projecteuler;

import mavery.projecteuler.util.EulerUtils;

public class Problem41
{

	/**
	 * We shall say that an n-digit number is pandigital if it makes use of all
	 * the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital
	 * and is also prime.
	 * 
	 * What is the largest n-digit pandigital prime that exists?
	 */
	public static void main(String[] args)
	{
		int[] ia = {1, 2, 3, 4, 5, 6, 7};
		while (EulerUtils.increment(ia))
		{
			if (EulerUtils.isPrime(intArrayToInt(ia)))
			{
				System.out.println(intArrayToInt(ia));
			}
		}
	}

	public static int intArrayToInt(int[] input)
	{
		int result = 0;
		for (int i = 0; i < input.length; i++)
		{
			result = result * 10 + input[i];
		}
		return result;
	}
}
