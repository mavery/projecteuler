package mavery.projecteuler;

public class Problem78
{
	private static final int LIMIT = 10000;
	private static int[][] PRECALC = new int[LIMIT + 1][LIMIT + 1];

	public static final int MOD = 1000000;
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
		for (int i = 1; i <= LIMIT; i++)
		{
			if (p_mod(i) == 0)
			{
				System.out.printf("p(%d) mod %d = %d\n", i, MOD, p_mod(i));
			}
		}

	}

	public static int p_mod(int n)
	{
		return p_mod(n, n);
	}

	private static int p_mod(int n, int maxPile)
	{
		if (maxPile > n)
		{
			maxPile = n;
		}
		if (PRECALC[n][maxPile] != 0)
		{
			return PRECALC[n][maxPile];
		}
		if (n <= 1)
		{	
			return 1;
		}
		
		int result = 0;
		for (int i = maxPile; i > 0; i--)
		{
			result += p_mod(n - i, i);
			if (result >= MOD)
			{
				result %= MOD;
			}
		}
		
		PRECALC[n][maxPile] = result;
		return result;
	}
}
