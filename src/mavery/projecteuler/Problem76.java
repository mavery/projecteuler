package mavery.projecteuler;

public class Problem76
{
	public static final int AMOUNT = 100;

	public static final int[][] RESULTS = new int[AMOUNT + 1][AMOUNT + 1];

	/**
	 * It is possible to write five as a sum in exactly six different ways:
	 * 
	 * 4 + 1 3 + 2 3 + 1 + 1 2 + 2 + 1 2 + 1 + 1 + 1 1 + 1 + 1 + 1 + 1
	 * 
	 * How many different ways can one hundred be written as a sum of at least
	 * two positive integers?
	 */
	public static void main(String[] args)
	{
		System.out.println(combinations(AMOUNT, AMOUNT - 1));
	}

	public static final int combinations(int amount, int maxComponent)
	{
		if (amount < 0)
		{
			return 0;
		}
		if (amount == 0)
		{
			return 1;
		}

		if (RESULTS[amount][maxComponent] != 0)
		{
			return RESULTS[amount][maxComponent];
		}

		int result = 0;

		for (int i = maxComponent; i > 0; i--)
		{
			result += combinations(amount - i, i);
		}

		RESULTS[amount][maxComponent] = result;
		return result;
	}
}
