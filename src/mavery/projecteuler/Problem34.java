package mavery.projecteuler;

import mavery.projecteuler.util.EulerUtils;

public class Problem34
{
	public static final int LIMIT = 362880 * 7; // 9! * 7 digits
	/**
	 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
	 * 
	 * Find the sum of all numbers which are equal to the sum of the factorial
	 * of their digits.
	 * 
	 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
	 */
	public static void main(String[] args)
	{
		int result = 0;
		for (int i = 10; i <= LIMIT; i++)
		{
			if (i == EulerUtils.sumOfFactorialsOfDigits(i))
			{
				result += i;
			}
		}
		System.out.println(result);
	}
}
