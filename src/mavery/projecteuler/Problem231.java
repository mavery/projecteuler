package mavery.projecteuler;

import java.util.Arrays;

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
		int[] primes = new int[sieve.getPrimeList().size()];
		int count = 0;
		for (int p : sieve.getPrimeList())
		{
			primes[count++] = p;
		}

		// n will become the prime factors of N!, r and nmr are the prime
		// factors of R! and (N-R)! respectively
		int[] n = new int[N + 1];
		int[] nmr = null, r = null;

		for (int i = 2; i <= N; i++)
		{
			int current = i;
			for (int j = 0; j < primes.length; j++)
			{
				if (current == 1 || sieve.isPrime(current))
				{
					break;
				}
				while (current % primes[j] == 0)
				{
					current /= primes[j];
					n[primes[j]]++;
				}
			}
			n[current]++;

			if (i == N - R)
			{
				nmr = Arrays.copyOf(n, n.length);
			}
			if (i == R)
			{
				r = Arrays.copyOf(n, n.length);
			}
		}

		long result = 0;
		for (int i = 2; i <= N; i++)
		{
			int current = n[i] - r[i] - nmr[i];
			if (current > 0)
			{
				result += current * i;
			}
		}

		System.out.println(result);
	}

}
