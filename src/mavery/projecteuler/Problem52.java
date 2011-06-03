package mavery.projecteuler;

import mavery.projecteuler.util.EulerUtils;

public class Problem52
{

	/**
	 * It can be seen that the number, 125874, and its double, 251748, contain
	 * exactly the same digits, but in a different order.
	 * 
	 * Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x,
	 * contain the same digits.
	 */
	public static void main(String[] args)
	{
		for (long i = 1; true; i *= 10)
		{
			for (long j = 0; j * 6 <= i * 10; j++)
			{
				long n = i + j;
				if (EulerUtils.arePermutations(n, 2 * n, 3 * n, 4 * n, 5 * n,
						6 * n))
				{
					System.out.println(n);
					return;
				}
			}
		}
	}
}
