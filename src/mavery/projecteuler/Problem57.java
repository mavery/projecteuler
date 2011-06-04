package mavery.projecteuler;

import mavery.projecteuler.util.Fraction;

public class Problem57
{
	public static final int MAX_ITERATIONS = 1000;

	/**
	 * It is possible to show that the square root of two can be expressed as an
	 * infinite continued fraction.
	 * 
	 * sqrt2 = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...
	 * 
	 * By expanding this for the first four iterations, we get:
	 * 
	 * 1 + 1/2 = 3/2 = 1.5 1 + 1/(2 + 1/2) = 7/5 = 1.4 1 + 1/(2 + 1/(2 + 1/2)) =
	 * 17/12 = 1.41666... 1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...
	 * 
	 * The next three expansions are 99/70, 239/169, and 577/408, but the eighth
	 * expansion, 1393/985, is the first example where the number of digits in
	 * the numerator exceeds the number of digits in the denominator.
	 * 
	 * In the first one-thousand expansions, how many fractions contain a
	 * numerator with more digits than denominator?
	 */
	public static void main(String[] args)
	{
		int result = 0;

		Fraction current = new Fraction(3, 2);
		
		for (int i = 2; i <= MAX_ITERATIONS; i++)
		{
			current = current.add(Fraction.ONE).reciprocal().add(Fraction.ONE);

			if (current.getNum().toString().length() > current.getDen()
					.toString().length())
			{
				result++;
			}
		}
		System.out.println(result);
	}
}
