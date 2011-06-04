package mavery.projecteuler;

import mavery.projecteuler.util.Fraction;

public class Problem71
{
	public static final int LIMIT = 1000000;

	/**
	 * Consider the fraction, n/d, where n and d are positive integers. If n != d
	 * and HCF(n,d)=1, it is called a reduced proper fraction.
	 * 
	 * If we list the set of reduced proper fractions for d <= 8 in ascending
	 * order of size, we get:
	 * 
	 * 1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8,
	 * 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8
	 * 
	 * It can be seen that 2/5 is the fraction immediately to the left of 3/7.
	 * 
	 * By listing the set of reduced proper fractions for d <= 1,000,000 in
	 * ascending order of size, find the numerator of the fraction immediately
	 * to the left of 3/7.
	 */
	public static void main(String[] args)
	{
		// This can be solved by hand quite easily, this is a brute force'ish
		// demonstration that the solution is correct

		Fraction result = Fraction.ZERO;
		for (int i = 1; i <= LIMIT; i++)
		{
			Fraction current = new Fraction(i * 3 / 7 - (i % 7 == 0 ? 1 : 0), i);
			if (current.compareTo(result) > 0)
			{
				result = current;
			}
		}
		System.out.println(result.getNum());
	}
}
