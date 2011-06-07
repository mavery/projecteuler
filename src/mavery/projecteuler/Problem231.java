package mavery.projecteuler;

import mavery.projecteuler.util.PrimeNumberSieve;

public class Problem231
{
	public static final int N = 20000000;
	public static final int R = 15000000;

	/**
	 * The binomial coefficient 10C3 = 120. 120 = 2^3 3 5 = 2 2 2 3 5, and 2 + 2
	 * + 2 + 3 + 5 = 14. So the sum of the terms in the prime factorisation of
	 * 10C3 is 14.
	 * 
	 * Find the sum of the terms in the prime factorisation of
	 * 20000000C15000000.
	 */
	public static void main(String[] args)
	{
		PrimeNumberSieve sieve = new PrimeNumberSieve(N + 1);

		long result = 0;
		for (int p : sieve.getPrimeList())
		{
			int current = getPrimeFactorsInFactorial(p, N)
					- getPrimeFactorsInFactorial(p, R)
					- getPrimeFactorsInFactorial(p, N - R);
			if (current > 0)
			{
				result += current * p;
			}
		}
		System.out.println(result);
	}

	/**
	 * Returns the multiplicity of prime factor p in n!
	 * @param p prime factor
	 * @param n the factorial to look at
	 * @return multiplicity of p in n!.
	 */
	public static int getPrimeFactorsInFactorial(int p, int n)
	{
		int result = 0;
		while (n > 1)
		{
			n /= p;
			result += n;
		}
		return result;
	}
}
