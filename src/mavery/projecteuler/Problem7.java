package mavery.projecteuler;

import mavery.projecteuler.util.EulerUtils;

public class Problem7
{

	/**
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can
	 * see that the 6th prime is 13.
	 * 
	 * What is the 10001st prime number?
	 */
	public static void main(String[] args)
	{
		int primeCount = 0;

		for (int i = 2; true; i++)
		{
			if (EulerUtils.isPrime(i))
			{
				primeCount++;
			}
			if (primeCount == 10001)
			{
				System.out.println(i);
				System.exit(0);
			}
		}

	}

}
