package mavery.projecteuler;

public class Problem108
{
	public static final int TARGET = 1_000;

	/**
	 * In the following equation x, y, and n are positive integers.
	 * 
	 * 1/x + 1/y = 1/n
	 * 
	 * For n = 4 there are exactly three distinct solutions
	 * 
	 * What is the least value of n for which the number of distinct solutions
	 * exceeds one-thousand?
	 */
	public static void main(String[] args)
	{
		int best = 0;
		int bestCount = 0;
		for (int i = 4; true; i++)
		{
			int currentCount = countSolutions(i);
			if (currentCount > bestCount)
			{
				bestCount = currentCount;
				best = i;
				System.out.printf("New best: n = %d, solutions = %d\n", best, bestCount);
			}
			if (currentCount > TARGET)
			{
				System.out.println(i);
				return;
			}
		}
	}

	/**
	 * Returns the number of distinct positive integer solutions to 1/x + 1/y =
	 * 1/n
	 * 
	 * @param n
	 * @return A count of the distinct solutions to the equation
	 */
	public static int countSolutions(long n)
	{
		int result = 0;

		for (long x = n + 1; x <= 2 * n; x++)
		{
			if ((n * x) % (n - x) == 0)
			{
				result++;
			}
		}

		return result;
	}
}
