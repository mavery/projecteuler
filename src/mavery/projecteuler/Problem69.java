package mavery.projecteuler;

import mavery.projecteuler.util.EulerUtils;

public class Problem69
{

	public static final int LIMIT = 1000000;

	/**
	 * Euler's Totient function, phi(n) [sometimes called the phi function], is
	 * used to determine the number of numbers less than n which are relatively
	 * prime to n. For example, as 1, 2, 4, 5, 7, and 8, are all less than nine
	 * and relatively prime to nine, phi(9)=6.
	 * 
	 * It can be seen that n=6 produces a maximum n/phi(n) for n <= 10.
	 * 
	 * Find the value of n <= 1,000,000 for which n/phi(n) is a maximum.
	 */
	public static void main(String[] args)
	{
		// This is trivial to solve by hand so I'll put the code in here to
		// generate the right answer for an arbitrary limit.
		int result = 1;
		for (int i = 2; result * i <= LIMIT; i++)
		{
			if (EulerUtils.isPrime(i))
			{
				result *= i;
			}
		}
		System.out.println(result);
	}

}
