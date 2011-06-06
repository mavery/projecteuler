package mavery.projecteuler;

public class Problem206
{
	private static final long LOW = (long) Math.sqrt(1020304050607080900.0);

	/**
	 * Find the unique positive integer whose square has the form
	 * 1_2_3_4_5_6_7_8_9_0, where each “_” is a single digit.
	 */
	public static void main(String[] args)
	{
		long result = 0;

		// answer must be a multiple of 10 to have its square end in 0.
		for (long l = (LOW / 10) * 10; result == 0; l += 10)
		{
			if (matchesFormat(l * l))
			{
				result = l;
			}
		}
		System.out.println(result);
	}

	public static boolean matchesFormat(long l)
	{
		if (l % 10 != 0)
		{
			return false;
		}

		l /= 100;

		for (int i = 9; i > 0; i--)
		{
			if (l % 10 != i)
			{
				return false;
			}
			l /= 100;
		}
		return true;
	}
}
