package mavery.projecteuler;

public class Problem92
{

	public static final int LIMIT = 10000000;
	public static final int MAX_SQUARE_DIGITS = 9 * 9 * 7;

	private static int[] storedResults;

	/**
	 * A number chain is created by continuously adding the square of the digits
	 * in a number to form a new number until it has been seen before.
	 * 
	 * For example,
	 * 
	 * 44 32 13 10 1 1
	 * 
	 * 85 89 145 42 20 4 16 37 58 89
	 * 
	 * Therefore any chain that arrives at 1 or 89 will become stuck in an
	 * endless loop. What is most amazing is that EVERY starting number will
	 * eventually arrive at 1 or 89.
	 * 
	 * How many starting numbers below ten million will arrive at 89?
	 */
	public static void main(String[] args)
	{
		storedResults = new int[MAX_SQUARE_DIGITS];
		storedResults[0] = 1;
		storedResults[88] = 89;

		int result = 0;
		for (int i = 1; i < LIMIT; i++)
		{
			if (chainReaches89(i))
			{
				result++;
			}
		}

		System.out.println(result);
	}

	/**
	 * Returns true if the number chain eventually reaches 89
	 * 
	 * @param n
	 *            Starting number in the chain
	 * @return True if the number chain reaches 89, false if it reaches 1
	 */
	public static boolean chainReaches89(int n)
	{
		int i = n;
		while (true)
		{
			if (i <= MAX_SQUARE_DIGITS && storedResults[i - 1] != 0)
			{
				if (n <= MAX_SQUARE_DIGITS)
				{
					storedResults[n - 1] = storedResults[i - 1];
				}
				return storedResults[i - 1] == storedResults[88];
			}

			int temp = 0;
			while (i != 0)
			{
				int cur = i % 10;
				temp += (cur * cur);
				i /= 10;
			}
			i = temp;
		}
	}
}
