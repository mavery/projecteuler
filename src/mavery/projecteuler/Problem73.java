package mavery.projecteuler;

import mavery.projecteuler.util.EulerUtils;

public class Problem73
{
	public static final int MAX_DEN = 12000;

	/**
	 * Consider the fraction, n/d, where n and d are positive integers. If nd
	 * and HCF(n,d)=1, it is called a reduced proper fraction.
	 * 
	 * If we list the set of reduced proper fractions for d 8 in ascending order
	 * of size, we get:
	 * 
	 * 1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8,
	 * 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8
	 * 
	 * It can be seen that there are 3 fractions between 1/3 and 1/2.
	 * 
	 * How many fractions lie between 1/3 and 1/2 in the sorted set of reduced
	 * proper fractions for d 12,000?
	 * 
	 * Note: The upper limit has been changed recently.
	 */
	public static void main(String[] args)
	{
		int result = 0;
		for (int den = 4; den <= MAX_DEN; den++)
		{
			int numLimit = den / 2 - (den % 2 == 0 ? 1 : 0);
			for (int num = den / 3 + 1; num <= numLimit; num++)
			{
				if (EulerUtils.gcd(num, den) == 1)
				{
					result++;
				}
			}
		}
		System.out.println(result);
	}
}
