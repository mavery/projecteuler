package mavery.projecteuler;

import mavery.projecteuler.util.PrimeNumberSieve;

public class Problem47
{
	
	public static final int TARGET = 4;
	
	private static PrimeNumberSieve sieve = new PrimeNumberSieve(10000000);
	
	/**
	 * The first two consecutive numbers to have two distinct prime factors are:
	 * 
	 * 14 = 2 * 7 15 = 3 * 5
	 * 
	 * The first three consecutive numbers to have three distinct prime factors
	 * are:
	 * 
	 * 644 = 2² * 7 * 23 645 = 3 * 5 * 43 646 = 2 * 17 * 19.
	 * 
	 * Find the first four consecutive integers to have four distinct primes
	 * factors. What is the first of these numbers?
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		int currentRun = 0;
		for (int i = 2; true; i++)
		{
			if (countPrimeFactors(i) == TARGET)
			{
				currentRun++;
			}
			else
			{
				currentRun = 0;
			}
			
			if (currentRun == 4)
			{
				System.out.println(i - 3);
				return;
			}
		}
	}
	
	public static int countPrimeFactors(int n)
	{
		
		int count = 0;
		for (int l = 2; l <= n; l++)
		{
			if (sieve.isPrime(n))
			{
				count++;
				break;
			}
			if (n % l == 0)
			{
				count++;
			}
			while (n % l == 0)
			{
				n = n / l;
			}
		}
		return count;

	}


	
}
