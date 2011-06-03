package mavery.projecteuler.util;

import java.util.Arrays;

/**
 * Stores the digits in a given number so they can be easily compared.
 * DigitCount are immutable.
 * 
 * @author mavery
 */
public final class DigitCount
{
	private final int[] count;

	private static final int BASE = 10;

	/**
	 * Constructs a DigitCount based on a given number
	 * 
	 * @param n
	 *            The decimal number to store the digits of
	 */
	public DigitCount(long n)
	{
		count = new int[BASE];
		while (n != 0)
		{
			count[(int) (n % BASE)]++;
			n /= BASE;
		}
	}

	/**
	 * Returns true if this object is equal to o
	 * 
	 * @param o
	 *            the object to compare to
	 * @return true if o is not null, is an instance of DigitCount and contains
	 *         the same digits in the same quantities as this DigitCount
	 */
	@Override
	public boolean equals(Object o)
	{
		if (o == null || !(o instanceof DigitCount))
		{
			return false;
		}
		return Arrays.equals(this.count, ((DigitCount) o).count);
	}

	/**
	 * Returns a hashCode for this DigitCount
	 */
	@Override
	public int hashCode()
	{
		int result = 0;
		for (int i = 0; i < count.length; i++)
		{
			result = result * 23 + count[i];
		}
		return result;
	}
}
