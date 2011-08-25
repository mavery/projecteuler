package mavery.projecteuler;

public class Problem179
{
	public static final int LIMIT = 10_000_000;

	/**
	 * Find the number of integers 1 < n < 10^7, for which n and n + 1 have the same
	 * number of positive divisors. For example, 14 has the positive divisors 1,
	 * 2, 7, 14 while 15 has 1, 3, 5, 15.
	 */
	public static void main(String[] args)
	{
		int result = 0;
		
		int[] factors = getFactorsArray(LIMIT);

		for (int i = 2; i < factors.length - 1; i++)
		{
			if (factors[i] == factors[i + 1])
			{
				result++;
			}
		}
		
		System.out.println(result);
	}

	/**
	 * Returns an array containing the number of positive integer factors of
	 * each integer in [0, limit]
	 * 
	 * @param limit
	 * @return an array of size (limit + 1) where array[n] = the number of
	 *         positive integer factors of n
	 */
	private static int[] getFactorsArray(int limit)
	{
		int[] result = new int[limit + 1];

		for (int i = 1; i <= limit; i++)
		{
			for (int j = i; j <= limit; j += i)
			{
				result[j]++;
			}
		}

		return result;
	}
}
