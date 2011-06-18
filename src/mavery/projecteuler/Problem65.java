package mavery.projecteuler;

import mavery.projecteuler.util.EulerUtils;
import mavery.projecteuler.util.Fraction;

public class Problem65
{
	public static final int CONVERGENT = 100;

	/**
	 * The square root of 2 can be written as an infinite continued fraction.
	 * 
	 * The infinite continued fraction can be written, 2 = [1;(2)], (2)
	 * indicates that 2 repeats ad infinitum. In a similar way, 23 =
	 * [4;(1,3,1,8)].
	 * 
	 * It turns out that the sequence of partial values of continued fractions
	 * for square roots provide the best rational approximations. Let us
	 * consider the convergents for 2.1 + 1 = 3/2 2 1 + 1 = 7/5 2 + 1
	 * 
	 * Hence the sequence of the first ten convergents for 2 are: 1, 3/2, 7/5,
	 * 17/12, 41/29, 99/70, 239/169, 577/408, 1393/985, 3363/2378, ...
	 * 
	 * What is most surprising is that the important mathematical constant, e =
	 * [2; 1,2,1, 1,4,1, 1,6,1 , ... , 1,2k,1, ...].
	 * 
	 * The first ten terms in the sequence of convergents for e are: 2, 3, 8/3,
	 * 11/4, 19/7, 87/32, 106/39, 193/71, 1264/465, 1457/536, ...
	 * 
	 * The sum of digits in the numerator of the 10th convergent is 1+4+5+7=17.
	 * 
	 * Find the sum of digits in the numerator of the 100th convergent of the
	 * continued fraction for e.
	 */
	public static void main(String[] args)
	{
		Fraction current = new Fraction(getContinuedFractionForE(CONVERGENT), 1);
		for (int i = CONVERGENT - 1; i >= 1; i--)
		{
			int n = getContinuedFractionForE(i);
			current = current.reciprocal().add(new Fraction(n, 1));
		}
		System.out.println(EulerUtils.sumDigits(current.getNum()));
	}

	/**
	 * Returns the n'th entry in the continued fraction for e.
	 * @param n >= 1
	 * @return n'th entry in the continued fraction for e.
	 */
	public static int getContinuedFractionForE(int n)
	{
		if (n == 1)
		{
			return 2;
		}
		
		if (((n - 1) % 3) == 2)
		{
			return 1 + (2 * (n - 1)) / 3;
		}
		else
		{
			return 1;
		}
	}
}
