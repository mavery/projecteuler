package mavery.projecteuler;

import java.util.HashMap;
import java.util.Map;

import mavery.projecteuler.util.DigitCount;

public class Problem62
{

	public static final int NUM_PERMS = 5;

	/**
	 * The cube, 41063625 (345^3), can be permuted to produce two other cubes:
	 * 56623104 (384^3) and 66430125 (4053). In fact, 41063625 is the smallest
	 * cube which has exactly three permutations of its digits which are also
	 * cube.
	 * 
	 * Find the smallest cube for which exactly five permutations of its digits
	 * are cube.
	 */
	public static void main(String[] args)
	{
		System.out.println(new Problem62().solve(NUM_PERMS));
	}

	/**
	 * Returns the lowest cubic integer that is a permutation of (perms - 1)
	 * other cubic numbers.
	 */
	public long solve(int perms)
	{
		long result = Long.MAX_VALUE;
		long lastToCheck = Long.MAX_VALUE;

		Map<DigitCount, PermutationCount> cubes = new HashMap<DigitCount, PermutationCount>();
		for (long n = 1; n < lastToCheck; n++)
		{
			long nCubed = n * n * n;
			DigitCount dc = new DigitCount(nCubed);
			if (cubes.containsKey(dc))
			{
				cubes.get(dc).count++;
				if (cubes.get(dc).count == perms)
				{
					// It's possible that the first solution we find is not the
					// lowest one so we can't just end here. Need to continue on
					// until all cubes of the same number of digits are
					// exhausted. Doesn't effect the 5 permutations case but
					// does effect the 6 permutations case.
					if (cubes.get(dc).lowestCube < result)
					{
						result = cubes.get(dc).lowestCube;

						// last number whose cube shares the same number of
						// digits as result
						lastToCheck = (long) Math.pow(Math.pow(10, (((int) Math
								.log10(result)) + 1)), 1.0 / 3.0);

					}
				}
			}
			else
			{
				cubes.put(dc, new PermutationCount(nCubed, 1));
			}
		}

		return result;
	}

	private class PermutationCount
	{
		long lowestCube;
		int count;

		PermutationCount(long lowestCube, int count)
		{
			this.lowestCube = lowestCube;
			this.count = count;
		}
	}
}
