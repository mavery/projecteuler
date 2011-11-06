package mavery.projecteuler;

import mavery.projecteuler.util.PrimeNumberSieve;

public class Problem357
{
	private static final int LIMIT = 100_000_000;

	/**
	 * Consider the divisors of 30: 1,2,3,5,6,10,15,30. It can be seen that for
	 * every divisor d of 30, d+30/d is prime.
	 * 
	 * Find the sum of all positive integers n not exceeding 100 000 000 such
	 * that for every divisor d of n, d+n/d is prime.
	 */
	public static void main(String[] args)
	{
		PrimeNumberSieve sieve = new PrimeNumberSieve(LIMIT);
		
		boolean[] failed = new boolean[LIMIT];
		int maxTest = (int) Math.sqrt(LIMIT);
		
		for (int i = 1; i <= maxTest; i++)
		{
			for (int j = i, k = 1; j < LIMIT; j += i, k++)
			{
				if (!failed[j] && !sieve.isPrime(i + k))
				{
					failed[j] = true;
				}
			}
		}
		
		long result = 0;
		for (int i = 1; i < LIMIT; i++)
		{
			if (!failed[i])
			{
				result += i;
			}
		}
		System.out.println(result);
	}
}
