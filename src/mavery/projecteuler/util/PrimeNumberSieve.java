package mavery.projecteuler.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A dumb prime sieve.
 * 
 * @author mavery
 * 
 */
public class PrimeNumberSieve
{
	private boolean[] sieve;

	private List<Integer> primeList;

	/**
	 * Constructs a prime number sieve which can calculate primality for
	 * integers <= limit.
	 * 
	 * @param limit
	 *            The largest number in the sieve
	 */
	public PrimeNumberSieve(int limit)
	{
		sieve = new boolean[limit + 1];
		Arrays.fill(sieve, true);

		sieve[0] = false;
		sieve[1] = false;

		int max = (int) Math.floor(Math.sqrt(limit));
		for (int i = 2; i <= max; i++)
		{
			if (sieve[i])
			{
				for (int j = i * i; j <= limit; j += i)
				{
					sieve[j] = false;
				}
			}
		}

	}

	/**
	 * Returns true if n is prime, false otherwise.
	 * 
	 * @param n
	 *            The integer to test
	 * @return true if n is prime, false otherwise
	 * @throws ArrayIndexOutOfBoundsException
	 *             if n > limit
	 */
	public boolean isPrime(int n)
	{
		if (n < 2)
		{
			return false;
		}
		return sieve[n];

	}

	/**
	 * Returns an unmodifiable list of all prime numbers found by this sieve.
	 * 
	 * @return An unmodifiable list containing all prime numbers up to the limit specified in
	 *         the constructor.
	 */
	public List<Integer> getPrimeList()
	{
		if (primeList == null)
		{
			primeList = new ArrayList<Integer>();
			for (int i = 2; i < sieve.length; i++)
			{
				if (isPrime(i))
				{
					primeList.add(i);
				}
			}
			primeList = Collections.unmodifiableList(primeList);
		}

		return primeList;
	}
	
	/**
	 * Returns the limit of this sieve as passed into the constructor of this object. 
	 * 
	 * @return The limit for this sieve
	 */
	public int getLimit()
	{
		return sieve.length - 1;
	}
}
