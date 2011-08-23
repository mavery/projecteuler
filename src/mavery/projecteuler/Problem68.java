package mavery.projecteuler;

import mavery.projecteuler.util.EulerUtils;

public class Problem68
{
	public static final long LIMIT = 9_999_999_999_999_999L;

	/**
	 * Consider the following "magic" 3-gon ring, filled with the numbers 1 to
	 * 6, and each line adding to nine.
	 * 
	 * 
	 * Working clockwise, and starting from the group of three with the
	 * numerically lowest external node (4,3,2 in this example), each solution
	 * can be described uniquely. For example, the above solution can be
	 * described by the set: 4,3,2; 6,2,1; 5,1,3.
	 * 
	 * It is possible to complete the ring with four different totals: 9, 10,
	 * 11, and 12. There are eight solutions in total.Total Solution Set 9
	 * 4,2,3; 5,3,1; 6,1,2 9 4,3,2; 6,2,1; 5,1,3 10 2,3,5; 4,5,1; 6,1,3 10
	 * 2,5,3; 6,3,1; 4,1,5 11 1,4,6; 3,6,2; 5,2,4 11 1,6,4; 5,4,2; 3,2,6 12
	 * 1,5,6; 2,6,4; 3,4,5 12 1,6,5; 3,5,4; 2,4,6
	 * 
	 * 
	 * By concatenating each group it is possible to form 9-digit strings; the
	 * maximum string for a 3-gon ring is 432621513.
	 * 
	 * Using the numbers 1 to 10, and depending on arrangements, it is possible
	 * to form 16- and 17-digit strings. What is the maximum 16-digit string for
	 * a "magic" 5-gon ring?
	 */
	public static void main(String[] args)
	{
		long result = 0;
		int[] fiveGon = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		while (EulerUtils.increment(fiveGon))
		{
			if (isMagic(fiveGon) && solutionForm(fiveGon) <= LIMIT)
			{
				result = Math.max(result, solutionForm(fiveGon));
			}
		}
		
		System.out.println(result);
	}

	/**
	 * Returns whether the 5-gon represented by a is 'magic'
	 * 
	 * @param a
	 *            an int array with 10 elements
	 * @return true if a is magic, false otherwise
	 */
	public static boolean isMagic(int[] a)
	{
		int sum = a[0] + a[5] + a[6];
		if (sum != a[1] + a[6] + a[7])
		{
			return false;
		}
		if (sum != a[2] + a[7] + a[8])
		{
			return false;
		}
		if (sum != a[3] + a[8] + a[9])
		{
			return false;
		}
		if (sum != a[4] + a[9] + a[5])
		{
			return false;
		}
		return true;
	}
	
	/**
	 * Returns a long in the correct form for the solution. 
	 * @param a
	 * @return
	 */
	public static long solutionForm(int[] a)
	{
		int min = 0;
		for (int i = 1; i < 5; i++)
		{
			if (a[min] > a[i])
			{
				min = i;
			}
		}
		
		long result = 0;
		for (int i = 0; i < 5; i++)
		{
			int start = (i + min) % 5;
			result = addToEnd(result, a[start]);
			result = addToEnd(result, a[start + 5]);
			result = addToEnd(result, a[start == 4 ? 5 : start + 6]);
		}
		
		return result;
	}
	
	/**
	 * Adds the integer i to the end of the long n. Only valid for i in [1, 10]
	 * @param n the base number
	 * @param i an integer i [1, 10]
	 * @return a long which contains n with i concatenated on the end. 
	 */
	private static long addToEnd(long n, int i)
	{
		if (i < 10)
		{
			return n * 10 + i;
		}
		return n * 100 + i;
	}
}