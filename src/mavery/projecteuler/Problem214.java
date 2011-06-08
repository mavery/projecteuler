package mavery.projecteuler;

import mavery.projecteuler.util.EulerUtils;
import mavery.projecteuler.util.PrimeNumberSieve;

/**
 * NOTE: The solution to this uses a fair bit of RAM, you may need to run the
 * JVM with the -Xmx512M or else you could get OutOfMemoryErrors
 * 
 * @author mavery
 * 
 */
public class Problem214
{
	public static final int LIMIT = 40000000;

	public static final int CHAIN_LENGTH = 25;

	/**
	 *Let phi be Euler's totient function, i.e. for a natural number n, phi(n)
	 * is the number of k, 1 k n, for which gcd(k,n) = 1.
	 * 
	 * By iterating phi, each positive integer generates a decreasing chain of
	 * numbers ending in 1. E.g. if we start with 5 the sequence 5,4,2,1 is
	 * generated. Here is a listing of all chains with length 4: 5,4,2,1 7,6,2,1
	 * 8,4,2,1 9,6,2,1 10,4,2,1 12,4,2,1 14,6,2,1 18,6,2,1
	 * 
	 * Only two of these chains start with a prime, their sum is 12.
	 * 
	 * What is the sum of all primes less than 40000000 which generate a chain
	 * of length 25?
	 */
	public static void main(String[] args)
	{
		PrimeNumberSieve sieve = new PrimeNumberSieve(LIMIT);

		int[] totients = EulerUtils.getTotients(LIMIT, sieve);

		long result = 0;

		// now going to repurpose the totient array to calculate chain lengths
		totients[1] = 1;
		for (int i = 2; i < LIMIT; i++)
		{
			totients[i] = totients[(int) totients[i]] + 1;
			if (totients[i] == CHAIN_LENGTH && sieve.isPrime(i))
			{
				result += i;
			}
		}

		System.out.println(result);
	}
}
