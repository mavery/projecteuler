package mavery.projecteuler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mavery.projecteuler.util.PrimeNumberSieve;



public class Problem320
{

	public static final int LOW = 10;
	public static final int HIGH = 1000000;
	public static final long MOD_FACTOR = 1000000000000000000L;
	public static final long POW_FACTOR = 1234567890L;

	private static PrimeNumberSieve sieve;
	private static List<Integer> primes;

	private static Map<Integer, Map<Integer, Integer>> primeFactors;

	/**
	 * Let N(i) be the smallest integer n such that n! is divisible by
	 * (i!)^1234567890
	 * 
	 * Let S(u)=N(i) for 10 <= i <= u.
	 * 
	 * S(1000)=614538266565663.
	 * 
	 * Find S(1000000) mod 10^18.
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		sieve = new PrimeNumberSieve(HIGH);

		primes = sieve.getPrimeList();

		calcPrimeFactors();
		
		System.out.println("Done factors");

		long result = 0L;
		long largestSoFar = 0L;
		Map<Integer, Integer> factorialFactors = new HashMap<Integer, Integer>();
		for (int i = 2; i <= HIGH; i++)
		{
			Map<Integer, Integer> currentFactors = primeFactors.get(i);
			for (int currentFactor : currentFactors.keySet())
			{
				int newPow = factorialFactors.containsKey(currentFactor) ? factorialFactors
						.get(currentFactor) : 0;
				newPow += currentFactors.get(currentFactor);
				
				factorialFactors.put(currentFactor, newPow);
				
				long required = requiredFactorial(currentFactor, POW_FACTOR * newPow);
				if (required > largestSoFar)
				{
					largestSoFar = required;
				}
			}
			
			if (i >= LOW)
			{
				result += largestSoFar;
				result %= MOD_FACTOR;
			}
		
			// This is to free up memory so it can run on this gutless little netbook
			primeFactors.remove(i);
		}

		System.out.println(result);
		System.out.println("Time taken = " + (System.currentTimeMillis() - startTime) + "ms");
	}

	private static void calcPrimeFactors()
	{
		primeFactors = new HashMap<Integer, Map<Integer, Integer>>();
		for (int i = 2; i <= HIGH; i++)
		{
			Map<Integer, Integer> current = null;
			if (sieve.isPrime(i))
			{
				current = new HashMap<Integer, Integer>();
				current.put(i, 1);
			}
			else
			{
				for (int j : primes)
				{
					if (i % j == 0)
					{
						current = new HashMap<Integer, Integer>(primeFactors
								.get(i / j));
						current
								.put(
										j,
										current.containsKey(j) ? current.get(j) + 1
												: 1);
						break;
					}
				}
			}
			primeFactors.put(i, current);
		}
	}

	public static long requiredFactorial(int prime, long power)
	{
		long result = 0;
		
		long a = 1, b = 1;
		
		while (a < power)
		{
			b = b * prime;
			a = a * prime + 1;
		}
		
		a /= prime;
		
		while (power != 0)
		{
			result += b * (power / a);
			power = power % a;
			a /= prime;
			b /= prime;
		}
		return result;
	}
}
