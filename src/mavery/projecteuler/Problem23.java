package mavery.projecteuler;

import mavery.projecteuler.util.EulerUtils;

public class Problem23
{

	public static final boolean[] abundantNumbers = new boolean[28124];

	/**
	 * A perfect number is a number for which the sum of its proper divisors is
	 * exactly equal to the number. For example, the sum of the proper divisors
	 * of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect
	 * number.
	 * 
	 * A number n is called deficient if the sum of its proper divisors is less
	 * than n and it is called abundant if this sum exceeds n.
	 * 
	 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the
	 * smallest number that can be written as the sum of two abundant numbers is
	 * 24. By mathematical analysis, it can be shown that all integers greater
	 * than 28123 can be written as the sum of two abundant numbers. However,
	 * this upper limit cannot be reduced any further by analysis even though it
	 * is known that the greatest number that cannot be expressed as the sum of
	 * two abundant numbers is less than this limit.
	 * 
	 * Find the sum of all the positive integers which cannot be written as the
	 * sum of two abundant numbers.
	 */
	public static void main(String[] args)
	{
		for (int i = 0; i < abundantNumbers.length; i++)
		{
			if (i < EulerUtils.sumOfProperDivisors(i))
			{
				abundantNumbers[i] = true;
			}
			else
			{
				abundantNumbers[i] = false;
			}
		}

		int result = 0;
		for (int i = 0; i < abundantNumbers.length; i++)
		{
			if (!isSumOfAbundantNumbers(i))
			{
				result += i;
			}
		}
		System.out.println(result);
	}

	public static boolean isSumOfAbundantNumbers(int input)
	{
		int startValue = 0;
		if (input > abundantNumbers.length)
		{
			startValue = input - abundantNumbers.length + 1;
		}
		int endValue = input - startValue;

		for (int i = startValue; i < endValue; i++)
		{
			if (abundantNumbers[i] && abundantNumbers[input - i])
			{
				return true;
			}
		}
		return false;
	}

}
