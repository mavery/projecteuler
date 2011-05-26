package mavery.projecteuler;

import java.util.ArrayList;
import java.util.List;

import mavery.projecteuler.util.Fraction;


public class Problem33
{

	/**
	 * The fraction 49/98 is a curious fraction, as an inexperienced
	 * mathematician in attempting to simplify it may incorrectly believe that
	 * 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.
	 * 
	 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
	 * 
	 * There are exactly four non-trivial examples of this type of fraction,
	 * less than one in value, and containing two digits in the numerator and
	 * denominator.
	 * 
	 * If the product of these four fractions is given in its lowest common
	 * terms, find the value of the denominator.
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Fraction result = new Fraction(1, 1);

		for (int i = 10; i <= 99; i++)
		{
			for (int j = i + 1; j <= 99; j++)
			{
				Fraction f = new Fraction(i, j);
				for (Fraction g : getStrangeReductions(f))
				{
					if (f.equals(g))
					{
						System.out.println(f + " " + g + " -> " + f.reduce());
						result = result.multiply(f.reduce());
					}
				}

			}
		}
		System.out.println(result.reduce());
	}

	/**
	 * Returns a list of all possible 'strange' reductions as discussed in the
	 * problem description..
	 * 
	 * @param f
	 *            the fraction to reduce
	 * @return A list of all strange reductions, empty list if no reduction
	 *         possible
	 */
	public static List<Fraction> getStrangeReductions(Fraction f)
	{
		List<Fraction> result = new ArrayList<Fraction>();

		int n1 = f.getNum() / 10;
		int n2 = f.getNum() % 10;
		int d1 = f.getDen() / 10;
		int d2 = f.getDen() % 10;

		// iterate over the four possible reductions
		if (n2 != 0 & n2 == d2)
		{
			// second digits. eg. 12/32 -> 1/3
			result.add(new Fraction(n1, d1));
		}
		if (n1 == d2)
		{
			// eg. 21/32 -> 1/3
			result.add(new Fraction(n2, d1));
		}
		if (n2 == d1)
		{
			// second digits. eg. 12/23 -> 1/3
			result.add(new Fraction(n1, d2));
		}
		if (n1 == d1)
		{
			// second digits. eg. 21/23 -> 1/3
			result.add(new Fraction(n2, d2));
		}

		return result;

	}

}
