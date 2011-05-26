package mavery.projecteuler;

public class Problem26
{
	public static final int LIMIT = 1000;

	/**
	 * A unit fraction contains 1 in the numerator. The decimal representation
	 * of the unit fractions with denominators 2 to 10 are given:1/2 = 0.5 1/3 =
	 * 0.(3) 1/4 = 0.25 1/5 = 0.2 1/6 = 0.1(6) 1/7 = 0.(142857) 1/8 = 0.125 1/9
	 * = 0.(1) 1/10 = 0.1
	 * 
	 * 
	 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can
	 * be seen that 1/7 has a 6-digit recurring cycle.
	 * 
	 * Find the value of d < 1000 for which 1/d contains the longest recurring
	 * cycle in its decimal fraction part.
	 */
	public static void main(String[] args)
	{
		int bestDenom = 0;
		int bestLength = 0;

		for (int i = 1; i < LIMIT; i++)
		{
			if (cycleLength(i) > bestLength)
			{
				bestDenom = i;
				bestLength = cycleLength(i);
			}
		}

		System.out.println("Denominator = " + bestDenom + ", length = "
				+ bestLength);

	}

	/**
	 * Returns the recurring decimal cycle length of the fraction 1/denominator
	 * 
	 * @param denominator
	 * @return The cycle length if fraction is a recurring decimal, -1 otherwise
	 */
	public static int cycleLength(int denominator)
	{
		int arrayLength = 1;
		while (arrayLength < denominator)
		{
			arrayLength *= 10;
		}

		int[] digitArray = new int[arrayLength];

		int n = arrayLength / 10;
		int count = 0;

		while (true)
		{
			count++;
			n *= 10;
			n = n % denominator;
			if (n == 0)
			{
				return 0;
			}
			if (digitArray[n] != 0)
			{
				return count - digitArray[n];
			}
			digitArray[n] = count;
		}
	}

}
