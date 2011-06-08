package mavery.projecteuler;

import mavery.projecteuler.util.PrimeNumberSieve;

public class Problem204
{
	public static final int LIMIT = 1000000000;
	public static final int HAMMING_TYPE = 100;

	private static int[] primes;

	/**
	 * A Hamming number is a positive number which has no prime factor larger
	 * than 5. So the first few Hamming numbers are 1, 2, 3, 4, 5, 6, 8, 9, 10,
	 * 12, 15. There are 1105 Hamming numbers not exceeding 10^8.
	 * 
	 * We will call a positive number a generalised Hamming number of type n, if
	 * it has no prime factor larger than n. Hence the Hamming numbers are the
	 * generalised Hamming numbers of type 5.
	 * 
	 * How many generalised Hamming numbers of type 100 are there which don't
	 * exceed 10^9?
	 */
	public static void main(String[] args)
	{
		populatePrimes(HAMMING_TYPE);

		System.out.println(doHammingNumbers(0, 1));
	}

	/**
	 * Creates the array primes and populates it with all primes up to and
	 * including limit, in order from smallest to largest.
	 * 
	 * @param limit
	 */
	private static void populatePrimes(int limit)
	{
		PrimeNumberSieve sieve = new PrimeNumberSieve(limit);
		primes = new int[sieve.getPrimeList().size()];
		int count = 0;
		for (int p : sieve.getPrimeList())
		{
			primes[count++] = p;
		}
	}

	/**
	 * Recursive function to calculate hamming numbers. 
	 */
	private static int doHammingNumbers(int minIndex, long baseAmount)
	{
		if (minIndex >= primes.length)
		{
			return 1;
		}

		int result = 0;
		do
		{
			result += doHammingNumbers(minIndex + 1, baseAmount);
			baseAmount *= primes[minIndex];
		}
		while (baseAmount <= LIMIT);

		return result;
	}
}
