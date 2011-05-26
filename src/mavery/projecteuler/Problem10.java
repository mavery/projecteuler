package mavery.projecteuler;

import mavery.projecteuler.util.EulerUtils;

public class Problem10
{

	/**
	 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
	 * 
	 * Find the sum of all the primes below two million.
	 */
	public static void main(String[] args)
	{
		long result = 2;
		for (int i = 3; i < 2000000; i += 2)
		{
			if (EulerUtils.isPrime(i))
			{
				result += i;
			}
		}
		System.out.println(result);

	}
}
