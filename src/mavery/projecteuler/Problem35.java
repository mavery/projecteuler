package mavery.projecteuler;

import java.util.ArrayList;
import java.util.List;

import mavery.projecteuler.util.EulerUtils;
import mavery.projecteuler.util.PrimeNumberSieve;


public class Problem35
{

	public static final int LIMIT = 999999;

	/**
	 * The number, 197, is called a circular prime because all rotations of the
	 * digits: 197, 971, and 719, are themselves prime.
	 * 
	 * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37,
	 * 71, 73, 79, and 97.
	 * 
	 * How many circular primes are there below one million?
	 */
	public static void main(String[] args)
	{
		int result = 4; // There are 4 single digit solutions. 

		PrimeNumberSieve sieve = new PrimeNumberSieve(LIMIT);

		// for the rest they must be composed only of the digits 1, 3, 7 and 9. 
		for (String current : EulerUtils.buildCombinations("1379", 2, Integer.toString(LIMIT).length()))
		{
			int i = Integer.parseInt(current);
			if (i > LIMIT)
			{
				continue;
			}
			if (sieve.isPrime(i))
			{
				boolean allPrime = true;
				for (int j : getRotations(i))
				{
					allPrime &= sieve.isPrime(j);
				}
				if (allPrime)
				{
					result++;
				}
			}
		}

		System.out.println(result);

	}

	public static List<Integer> getRotations(int n)
	{
		List<Integer> result = new ArrayList<Integer>();

		int numDigits = countDigits(n);
		for (int i = 1; i < numDigits; i++) // deliberately 1 short here
		{
			int lastDigit = n % 10;
			for (int j = 1; j < numDigits; j++)
			{
				lastDigit *= 10;
			}
			n = (n / 10) + lastDigit;
			result.add(n);
		}
		return result;
	}

	public static int countDigits(int i)
	{
		int result = 0;
		while (i != 0)
		{
			i /= 10;
			result++;
		}
		return result;
	}

}
