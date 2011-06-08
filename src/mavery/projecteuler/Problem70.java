package mavery.projecteuler;

import mavery.projecteuler.util.EulerUtils;

public class Problem70
{
	public static final int LIMIT = 10000000;

	/**
	 * Euler's Totient function, phi(n) [sometimes called the phi function], is
	 * used to determine the number of positive numbers less than or equal to n
	 * which are relatively prime to n. For example, as 1, 2, 4, 5, 7, and 8,
	 * are all less than nine and relatively prime to nine, phi(9)=6. The number
	 * 1 is considered to be relatively prime to every positive number, so
	 * phi(1)=1.
	 * 
	 * Interestingly, phi(87109)=79180, and it can be seen that 87109 is a
	 * permutation of 79180.
	 * 
	 * Find the value of n, 1 < n < 10^7, for which phi(n) is a permutation of n
	 * and the ratio n/phi(n) produces a minimum.
	 */
	public static void main(String[] args)
	{
		int[] totients = EulerUtils.getTotients(LIMIT);

		int result = 0;
		double bestRatio = Double.MAX_VALUE;

		// find best ratio, starting from the highest number where low ratios
		// are more likely.
		for (int i = LIMIT - 1; i > 1; i--)
		{
			double ratio = (double) i / totients[i];

			if (ratio < bestRatio && EulerUtils.arePermutations(i, totients[i]))
			{
				result = i;
				bestRatio = ratio;
			}
		}

		System.out.println(result);
	}
}
