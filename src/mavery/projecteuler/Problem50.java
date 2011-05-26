package mavery.projecteuler;

import java.util.List;

import mavery.projecteuler.util.PrimeNumberSieve;


public class Problem50
{
	private static final int LIMIT = 1000000;
	private static final int MINIMUM_ANSWER = 3;

	/**
	 * The prime 41, can be written as the sum of six consecutive primes: 41 = 2
	 * + 3 + 5 + 7 + 11 + 13
	 * 
	 * This is the longest sum of consecutive primes that adds to a prime below
	 * one-hundred.
	 * 
	 * The longest sum of consecutive primes below one-thousand that adds to a
	 * prime, contains 21 terms, and is equal to 953.
	 * 
	 * Which prime, below one-million, can be written as the sum of the most
	 * consecutive primes?
	 */
	public static void main(String[] args)
	{
		PrimeNumberSieve sieve = new PrimeNumberSieve(LIMIT);

		int currentLength = MINIMUM_ANSWER;
		
		while (true)
		{
			int result = getSequence(currentLength, sieve);
			if (result != 0)
			{
				System.out.println(currentLength + ": " + result);	
			}
			currentLength++;
		}

	}

	/**
	 * Returns the smallest prime number that is the sum of 'length' consecutive
	 * prime numbers
	 * 
	 * @param length
	 *            The number of prime numbers in the sequence
	 * @param sieve
	 *            A prime sieve to use
	 * @return the smallest prime number that is the sum of 'length' consecutive
	 *         prime numbers, 0 if no such sequence is found
	 */
	public static int getSequence(int length, PrimeNumberSieve sieve)
	{
		List<Integer> primeList = sieve.getPrimeList();
		
		int current = 0;
		for (int i = 0; i < length; i++)
		{
			current += primeList.get(i);
		}
		
		int i = length;
		while (current < sieve.getLimit())
		{
			if (sieve.isPrime(current))
			{
				return current;
			}
			current -= primeList.get(i - length);
			current += primeList.get(i);
			i++;
		}
		return 0;
	}
}
