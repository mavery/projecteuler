package mavery.projecteuler;

import java.util.List;

import mavery.projecteuler.util.PrimeNumberSieve;

public class Problem347
{
	public static final int LIMIT = 10000000;

	/**
	 * The largest integer 100 that is only divisible by both the primes 2 and 3
	 * is 96, as 96=32*3=25*3. For two distinct primes p and q let M(p,q,N) be
	 * the largest positive integer N only divisible by both p and q and
	 * M(p,q,N)=0 if such a positive integer does not exist.
	 * 
	 * E.g. M(2,3,100)=96. M(3,5,100)=75 and not 90 because 90 is divisible by 2
	 * ,3 and 5. Also M(2,73,100)=0 because there does not exist a positive
	 * integer 100 that is divisible by both 2 and 73.
	 * 
	 * Let S(N) be the sum of all distinct M(p,q,N). S(100)=2262.
	 * 
	 * Find S(10 000 000).
	 */
	public static void main(String[] args)
	{
		List<Integer> primes = new PrimeNumberSieve(LIMIT).getPrimeList();
 
		long result = 0;
		for (int i = 0; i < primes.size(); i++)
		{
			for (int j = i + 1; j < primes.size(); j++)
			{
				long max = maximum(primes.get(i), primes.get(j), LIMIT);
				if (max == 0)
				{
					break;
				}
				else
				{
					result += max;
				}
			}
		}
		System.out.println(result);
	}

	/**
	 * Returns the largest number that is a multiple of only p and q and which
	 * is less than or equal to n
	 * 
	 * @param p
	 *            A prime
	 * @param q
	 *            A prime
	 * @param n
	 *            The limit
	 * @return The largest number p^k1 * q^k2 less than n, where k1 and k2 are
	 *         positive integers. If p*q > n, returns 0.
	 */
	public static long maximum(long p, long q, int n)
	{
		long result = 0;

		for (long p_pow = p * q; p_pow <= n; p_pow *= p)
		{
			long current = p_pow;
			while (current <= n)
			{
				if (current > result)
				{
					result = current;
				}
				current *= q;
			}
		}
		return result;
	}
}
