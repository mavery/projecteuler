package mavery.projecteuler;

import mavery.projecteuler.util.PrimeNumberSieve;

public class Problem27
{

	public static final int MAX_A = 1000;
	public static final int MAX_B = 1000;

	/**
	 * Euler published the remarkable quadratic formula:
	 * 
	 * n² + n + 41
	 * 
	 * It turns out that the formula will produce 40 primes for the consecutive
	 * values n = 0 to 39. However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41
	 * is divisible by 41, and certainly when n = 41, 41² + 41 + 41 is clearly
	 * divisible by 41.
	 * 
	 * Using computers, the incredible formula n² - 79n + 1601 was discovered,
	 * which produces 80 primes for the consecutive values n = 0 to 79. The
	 * product of the coefficients, 79 and 1601, is 126479.
	 * 
	 * Considering quadratics of the form: n² + an + b, where |a| 1000 and |b|
	 * 1000
	 * 
	 * where |n| is the modulus/absolute value of n e.g. |11| = 11 and |4| = 4
	 * 
	 * Find the product of the coefficients, a and b, for the quadratic
	 * expression that produces the maximum number of primes for consecutive
	 * values of n, starting with n = 0.
	 */
	public static void main(String[] args)
	{
		PrimeNumberSieve sieve = new PrimeNumberSieve(calc(MAX_A, MAX_A, MAX_B));

		int bestA = 0;
		int bestB = 0;
		int bestLength = 0;

		for (int a = -MAX_A + 1; a <= MAX_A; a++)
		{
			for (int b = -MAX_B + 1; b <= MAX_B; b++)
			{
				int n = 0;
				while (true)
				{
					if (sieve.isPrime(calc(n, a, b)))
					{
						n++;
					}
					else
					{
						break;
					}
				}
				if (n > bestLength)
				{
					bestLength = n;
					bestA = a;
					bestB = b;
				}
			}
		}

		System.out.println("a = " + bestA + ", b = " + bestB + ", a * b = "
				+ (bestA * bestB));

	}

	/**
	 * Returns n^2 + an + b
	 * 
	 * @param n
	 * @param a
	 * @param b
	 * @return n^2 + an + b
	 */
	public static int calc(int n, int a, int b)
	{
		return n * n + n * a + b;
	}

}
