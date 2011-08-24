package mavery.projecteuler;

public class Problem78
{
	public static final int MOD = 1000000;

	private static final int LIMIT = 100000;

	/**
	 * Let p(n) represent the number of different ways in which n coins can be
	 * separated into piles. For example, five coins can separated into piles in
	 * exactly seven different ways, so p(5)=7.
	 * 
	 * OOOOO OOOO O OOO OO OOO O O OO OO O OO O O O O O O O O
	 * 
	 * 
	 * Find the least value of n for which p(n) is divisible by one million.
	 */
	public static void main(String[] args)
	{
		int[] results = new int[LIMIT + 1];
		results[0] = 1;
		results[1] = 1;

		// using the generating function from
		// http://en.wikipedia.org/wiki/Partition_(number_theory)#Generating_function
		for (int n = 2; n <= LIMIT; n++)
		{
			int result = 0;
			for (int i = 1; true; i++)
			{
				// calculating the pentagonal number we need.
				int x = (i % 2 == 0 ? -(i / 2) : (i / 2) + 1);
				int pent = x * (3 * x - 1) / 2;

				if (pent > n)
				{
					break;
				}

				// calculating whether to add or subtract this number
				result = (((i - 1) & 2) == 0 ? result + results[n - pent]
						: result - results[n - pent]);
				if (result >= MOD)
				{
					result -= MOD;
				}
				else if (result < 0)
				{
					result += MOD;
				}
			}

			results[n] = result;
			if (result == 0)
			{
				System.out.printf("p(%d) mod %d = %d\n", n, MOD, result);
				return;
			}
		}
	}
}