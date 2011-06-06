package mavery.projecteuler;

import java.math.BigInteger;

public class Problem113
{
	public static final int LIMIT = 100;
	public static final int BASE = 10;
	
	private static BigInteger[][] storedResults = new BigInteger[LIMIT + 1][BASE + 1];

	/**
	 * Working from left-to-right if no digit is exceeded by the digit to its
	 * left it is called an increasing number; for example, 134468.
	 * 
	 * Similarly if no digit is exceeded by the digit to its right it is called
	 * a decreasing number; for example, 66420.
	 * 
	 * We shall call a positive integer that is neither increasing nor
	 * decreasing a "bouncy" number; for example, 155349.
	 * 
	 * As n increases, the proportion of bouncy numbers below n increases such
	 * that there are only 12951 numbers below one-million that are not bouncy
	 * and only 277032 non-bouncy numbers below 10^10.
	 * 
	 * How many numbers below a googol (10^100) are not bouncy?
	 */
	public static void main(String[] args)
	{
		BigInteger result = BigInteger.valueOf(BASE - 1);
		for (int i = 2; i <= LIMIT; i++)
		{
			// adds the number of increasing and decreasing numbers of a given
			// length, then subtracts all numbers composed of a single digit
			// which are double counted since they are both increasing and
			// decreasing
			result = result.add(oneDirection(i, BASE - 1)).add(
					oneDirection(i, BASE)).subtract(BigInteger.valueOf(BASE));
		}
		System.out.println(result);
	}

	/**
	 * Returns a count of the numbers whose digits are strictly increasing or
	 * decreasing in a given base
	 * 
	 * @param digits number of digits left to place
	 * @param base the number of possible options for each digit. 
	 */
	public static BigInteger oneDirection(int digits, int base)
	{
		if (base <= 0)
		{
			return BigInteger.ZERO;
		}
		if (base == 1 || digits == 0)
		{
			return BigInteger.ONE;
		}
		if (storedResults[digits][base] != null)
		{
			return storedResults[digits][base];
		}

		BigInteger result = BigInteger.ZERO;
		for (int i = base; i >= 0; i--)
		{
			result = result.add(oneDirection(digits - 1, i));
		}

		storedResults[digits][base] = result;
		return result;
	}
}
