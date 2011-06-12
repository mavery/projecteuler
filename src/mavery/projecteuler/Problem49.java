package mavery.projecteuler;

import mavery.projecteuler.util.EulerUtils;
import mavery.projecteuler.util.PrimeNumberSieve;

public class Problem49
{
	public static final int START = 1000;
	public static final int END = 10000;

	/**
	 * The arithmetic sequence, 1487, 4817, 8147, in which each of the terms
	 * increases by 3330, is unusual in two ways: (i) each of the three terms
	 * are prime, and, (ii) each of the 4-digit numbers are permutations of one
	 * another.
	 * 
	 * There are no arithmetic sequences made up of three 1-, 2-, or 3-digit
	 * primes, exhibiting this property, but there is one other 4-digit
	 * increasing sequence.
	 * 
	 * What 12-digit number do you form by concatenating the three terms in this
	 * sequence?
	 */
	public static void main(String[] args)
	{
		PrimeNumberSieve sieve = new PrimeNumberSieve(END);

		for (int i = START; i < END; i++)
		{
			if (!sieve.isPrime(i))
			{
				continue;
			}
			for (int j = (END - i) / 2; j > 0; j--)
			{
				if (EulerUtils.arePermutations(i, i + j, i + 2 * j)
						&& sieve.isPrime(i + 2 * j) && sieve.isPrime(i + j))
				{
					System.out.printf("%d%d%d%n", i, i + j, i + 2 * j);
				}
			}
		}
	}
}
