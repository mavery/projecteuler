package mavery.projecteuler;

public class Problem341
{
	public static final int LIMIT = 1000000;

	// this value is derived from runs with smaller limits
	private static final int ARRAY_SIZE = 11000000;

	private static long[] golombs;

	/**
	 * The Golomb's self-describing sequence {G(n)} is the only nondecreasing
	 * sequence of natural numbers such that n appears exactly G(n) times in the
	 * sequence. The values of G(n) for the first few n are n 1 2 3 4 5 6 7 8 9
	 * 10 11 12 13 14 15 ... G(n) 1 2 2 3 3 4 4 4 5 5 5 6 6 6 6 ...
	 * 
	 * You are given that G(10^3) = 86, G(10^6) = 6137. You are also given that
	 * sum G(n^3) = 153506976 for 1 <= n < 10^3.
	 * 
	 * Find sum G(n3) for 1 <= n < 10^6.
	 */
	public static void main(String[] args)
	{
		populateGolombs(ARRAY_SIZE);

		long result = 1;
		long sum = 0;
		int currentIndex = 0;
		long n = 2;
		long target = n * n * n;
		while (n < LIMIT)
		{
			long diff = golombs[currentIndex + 1] - golombs[currentIndex];
			long nextIncrement = diff * currentIndex;
			if (sum + nextIncrement > target)
			{
				long count = getCount(0, diff, currentIndex, target - sum);
				result += golombs[currentIndex] + count;
				n++;
				target = n * n * n;
			}
			sum += nextIncrement;
			currentIndex++;
		}
		System.out.println(result);
	}

	private static void populateGolombs(int limit)
	{
		golombs = new long[limit];
		golombs[0] = 0L;
		golombs[1] = 1L;
		golombs[2] = 2L;
		golombs[3] = 4L;

		long last = 2;
		long current;
		for (int i = 4; i < limit; i++)
		{
			current = g(i - 1, last);
			golombs[i] = (golombs[i - 1] + current);
			last = current;
		}
	}

	private static long g(long n, long last)
	{
		if (golombs[(int) last + 1] == n)
		{
			return last + 1;
		}
		else
		{
			return last;
		}
	}

	/**
	 * Performs a binary search to find the exact value we need to add to our result. 
	 */
	private static long getCount(long start, long end, long increment,
			long target)
	{
		while (start + 1 < end)
		{
			long mid = (start + end) / 2;
			long midValue = mid * increment;
			if (midValue == target)
			{
				return mid - 1;
			}
			else if (midValue > target)
			{
				end = mid;
			}
			else
			{
				start = mid;
			}
		}

		return start;
	}
}
