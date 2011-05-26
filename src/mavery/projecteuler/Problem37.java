package mavery.projecteuler;

import mavery.projecteuler.util.PrimeNumberSieve;

public class Problem37
{

	public static final int LIMIT = 999999;

	/**
	 * The number 3797 has an interesting property. Being prime itself, it is
	 * possible to continuously remove digits from left to right, and remain
	 * prime at each stage: 3797, 797, 97, and 7. Similarly we can work from
	 * right to left: 3797, 379, 37, and 3.
	 * 
	 * Find the sum of the only eleven primes that are both truncatable from
	 * left to right and right to left.
	 * 
	 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
	 */
	public static void main(String[] args)
	{
		int result = 0;

		PrimeNumberSieve sieve = new PrimeNumberSieve(LIMIT);

		numberList: for (int current = 10; current < LIMIT; current++)
		{
			// test by truncating digits from right
			for (int i = current; i > 0; i /= 10)
			{
				if (!sieve.isPrime(i))
				{
					continue numberList;
				}
			}

			String currentString = Integer.toString(current);
			// test by truncating digits from left
			for (int i = 1; i < currentString.length(); i++)
			{
				int j = Integer.parseInt(currentString.substring(i));
				if (!sieve.isPrime(j))
				{
					continue numberList;
				}
			}

			System.out.println(current);
			result += current;
		}

		System.out.println(result);

	}

}
