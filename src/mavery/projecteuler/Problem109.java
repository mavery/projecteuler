package mavery.projecteuler;

public class Problem109
{
	public static final int LIMIT = 100;

	private static int[] doubles;
	private static int[] all;

	static
	{
		all = new int[62];
		doubles = new int[21];
		for (int i = 1; i <= 20; i++)
		{
			all[3 * (i - 1)] = i;
			all[3 * (i - 1) + 1] = 2 * i;
			all[3 * (i - 1) + 2] = 3 * i;
			doubles[i - 1] = 2 * i;
		}
		all[60] = 25;
		all[61] = 50;
		doubles[20] = 50;
	}

	/**
	 * In the game of darts a player throws three darts at a target board which
	 * is split into twenty equal sized sections numbered one to twenty.
	 * 
	 * The score of a dart is determined by the number of the region that the
	 * dart lands in. A dart landing outside the red/green outer ring scores
	 * zero. The black and cream regions inside this ring represent single
	 * scores. However, the red/green outer ring and middle ring score double
	 * and treble scores respectively.
	 * 
	 * At the centre of the board are two concentric circles called the bull
	 * region, or bulls-eye. The outer bull is worth 25 points and the inner
	 * bull is a double, worth 50 points.
	 * 
	 * There are many variations of rules but in the most popular game the
	 * players will begin with a score 301 or 501 and the first player to reduce
	 * their running total to zero is a winner. However, it is normal to play a
	 * "doubles out" system, which means that the player must land a double
	 * (including the double bulls-eye at the centre of the board) on their
	 * final dart to win; any other dart that would reduce their running total
	 * to one or lower means the score for that set of three darts is "bust".
	 * 
	 * When a player is able to finish on their current score it is called a
	 * "checkout" and the highest checkout is 170: T20 T20 D25 (two treble 20s
	 * and double bull).
	 * 
	 * There are exactly eleven distinct ways to checkout on a score of 6...
	 * 
	 * Note that D1 D2 is considered different to D2 D1 as they finish on
	 * different doubles. However, the combination S1 T1 D1 is considered the
	 * same as T1 S1 D1.
	 * 
	 * In addition we shall not include misses in considering combinations; for
	 * example, D3 is the same as 0 D3 and 0 0 D3.
	 * 
	 * Incredibly there are 42336 distinct ways of checking out in total.
	 * 
	 * How many distinct ways can a player checkout with a score less than 100?
	 */
	public static void main(String[] args)
	{
		int result = 0;
		for (int i = 0; i < doubles.length; i++)
		{
			result += countCheckouts(LIMIT - doubles[i], 2, 0);
		}
		System.out.println(result);
	}

	/**
	 * Recursive method to count the available ways to checkout with a starting
	 * score less than toScore.
	 */
	private static int countCheckouts(int toScore, int dartsLeft,
			int lastDartIndex)
	{
		if (toScore <= 0)
		{
			return 0;
		}
		if (dartsLeft <= 0)
		{
			return 1;
		}

		int result = 1;
		for (int i = lastDartIndex; i < all.length; i++)
		{
			result += countCheckouts(toScore - all[i], dartsLeft - 1, i);
		}
		return result;
	}
}
