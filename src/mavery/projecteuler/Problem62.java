package mavery.projecteuler;

import java.util.ArrayList;
import java.util.List;

import mavery.projecteuler.util.EulerUtils;

public class Problem62
{

	public static final int INITIAL_MAX = 1000;
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
		List<Long> cubes = new ArrayList<Long>();
		for (int max = INITIAL_MAX; true; max *= 2)
		{
			System.out.println(max);
			addCubes(cubes, max);
			
			for (int i = 1; i < cubes.size(); i++)
			{
				int count = 1;
				
				int limit = (int) Math.pow(Math.pow(10, (((int)Math.log10(cubes.get(i))) + 1)), 1.0 / 3.0);
				for (int j = i + 1; j < cubes.size() && j <= limit; j++)
				{
					if (EulerUtils.arePermutations(cubes.get(i), cubes.get(j)))
					{
						count++;
					}
					if (count == NUM_PERMS)
					{
						System.out.printf("%d %d\n", i, cubes.get(i));
						return;
					}
				}
			}
		}
	}

	/**
	 * Adds cubes to the array up to limit cubed.
	 */
	public static void addCubes(List<Long> toFill, int limit)
	{
		for (long l = toFill.size(); l <= limit; l++)
		{
			toFill.add(l * l * l);
		}
	}

}
