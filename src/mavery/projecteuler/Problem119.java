package mavery.projecteuler;

import java.util.PriorityQueue;
import java.util.Queue;

import mavery.projecteuler.util.EulerUtils;

public class Problem119
{
	// this is the maximum digital sum of any long
	public static final int MAX_N = 9 * (int) Math.log10(Long.MAX_VALUE) + 1;

	/**
	 * The number 512 is interesting because it is equal to the sum of its
	 * digits raised to some power: 5 + 1 + 2 = 8, and 8^3 = 512. Another
	 * example of a number with this property is 614656 = 28^4.
	 * 
	 * We shall define an to be the nth term of this sequence and insist that a
	 * number must contain at least two digits to have a sum.
	 * 
	 * You are given that a2 = 512 and a10 = 614656.
	 * 
	 * Find a30.
	 */
	public static void main(String[] args)
	{
		// maintains a priority queue of n^m, then finds which ones have the
		// correct digital sum.
		Queue<PowerBasePair> queue = new PriorityQueue<PowerBasePair>();
		for (long i = 2; i <= MAX_N; i++)
		{
			queue.add(new PowerBasePair(i * i, i));
		}

		int count = 0;
		long result = 0;
		while (count < 30)
		{
			PowerBasePair pair = queue.remove();
			if (EulerUtils.sumDigits(pair.power) == pair.base)
			{
				count++;
				result = pair.power;
			}
			pair.power *= pair.base;
			queue.add(pair);
		}
		System.out.println(result);
	}

	private static class PowerBasePair implements Comparable<PowerBasePair>
	{
		long power;
		long base;

		public PowerBasePair(long power, long base)
		{
			this.power = power;
			this.base = base;
		}

		@Override
		public int compareTo(PowerBasePair other)
		{
			if (this.power < other.power)
			{
				return -1;
			}
			if (this.power > other.power)
			{
				return 1;
			}
			return 0;
		}
	}
}
