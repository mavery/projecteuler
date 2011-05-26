package mavery.projecteuler;

import mavery.projecteuler.util.PrimeNumberSieve;

public class Problem46
{
	private static final int LIMIT = 10000000;

	/**
	 * It was proposed by Christian Goldbach that every odd composite number can
	 * be written as the sum of a prime and twice a square.
	 * 
	 * 9 = 7 + 2*12 15 = 7 + 2*22 21 = 3 + 2*32 25 = 7 + 2*32 27 = 19 + 2*22 33 = 31
	 * + 2*12
	 * 
	 * It turns out that the conjecture was false.
	 * 
	 * What is the smallest odd composite that cannot be written as the sum of a
	 * prime and twice a square?
	 */
	public static void main(String[] args)
	{
		PrimeNumberSieve sieve = new PrimeNumberSieve(LIMIT);
		
		outer: for (int i = 3; i < LIMIT; i += 2)	
		{
			if (sieve.isPrime(i))
			{
				continue outer;
			}
			
			for (int j = 1; 2 * j * j < i; j++)
			{
				if (sieve.isPrime(i - 2 * j * j))
				{
					continue outer;
				}
			}
			
			System.out.println(i);
			return;
		}
		
		System.out.println("Limit too low");
	}

}
