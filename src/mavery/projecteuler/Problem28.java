package mavery.projecteuler;

public class Problem28
{
	public static final int LIMIT = 1001;

	/**
	 * Starting with the number 1 and moving to the right in a clockwise
	 * direction a 5 by 5 spiral is formed as follows:
	 * 
	 * 21 22 23 24 25 
	 * 20  7  8  9 10 
	 * 19  6  1  2 11
	 * 18  5  4  3 12 
	 * 17 16 15 14 13
	 * 
	 * It can be verified that the sum of the numbers on the diagonals is 101.
	 * 
	 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral
	 * formed in the same way?
	 */
	public static void main(String[] args)
	{
		int result = 0;
		for (int i = 1; i <= LIMIT; i += 2)
		{
			result += sumCorners(i);
		}

		System.out.println(result);
	}

	/**
	 * Returns the sum of the corner numbers of an n*n number spiral
	 * 
	 * @param n
	 *            side length
	 * @return sum of the four corners, or 1 if n == 1
	 */
	public static int sumCorners(int n)
	{
		if (n == 1)
		{
			return 1;
		}

		int innerNumbers = (n - 2) * (n - 2);

		return 4 * innerNumbers + 10 * n - 10;
	}
}
