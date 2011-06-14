package mavery.projecteuler;

import java.util.ArrayList;
import java.util.List;

/**
 * Needs a significant amount of ram to run for the full solution. I recommend
 * running with the -Xmx600M argument on the command line.
 */
public class Problem341
{
	public static final int LIMIT = 1000000;

	private static final long ARRAY_LIMIT = 200000000000L;

	private static List<Long> golombs;

	/**
	 * The Golomb's self-describing sequence {G(n)} is the only nondecreasing
	 * sequence of natural numbers such that n appears exactly G(n) times in the
	 * sequence. The values of G(n) for the first few n are n 1 2 3 4 5 6 7 8 9
	 * 10 11 12 13 14 15 ... G(n) 1 2 2 3 3 4 4 4 5 5 5 6 6 6 6 ...
	 * 
	 * 
	 * 
	 * You are given that G(10^3) = 86, G(10^6) = 6137. You are also given that
	 * sum G(n^3) = 153506976 for 1 <= n < 10^3.
	 * 
	 * Find sum G(n3) for 1 <= n < 10^6.
	 */
	public static void main(String[] args)
	{
		populateGolombList(ARRAY_LIMIT);

		long result = 1;
		long sum = 0;
		int currentIndex = 0;
		long n = 2;
		long target = n * n * n;
		while (n < LIMIT)
		{
			long diff = golombs.get(currentIndex + 1)
					- golombs.get(currentIndex);
			long nextIncrement = diff * currentIndex;
			if (sum + nextIncrement > target)
			{
				long count = getCount(0, diff, currentIndex, target - sum);
				result += golombs.get(currentIndex) + count;
				n++;
				target = n * n * n;
			}
			sum += nextIncrement;
			currentIndex++;
		}
		System.out.println(result);
	}

	private static void populateGolombList(long limit)
	{
		golombs = new ArrayList<Long>();
		golombs.add(0L);
		golombs.add(1L);
		golombs.add(2L);
		golombs.add(4L);

		long last = 2;
		long current;
		while (golombs.get(golombs.size() - 1) < limit)
		{
			current = g(golombs.size() - 1, last);
			golombs.add(golombs.get(golombs.size() - 1) + current);
			last = current;
		}
		
		System.out.printf("golombs done. %d elements.%n", golombs.size());
	}

	private static long g(long n, long last)
	{
		if (golombs.get((int) last + 1) == n)
		{
			return last + 1;
		}
		else
		{
			return last;
		}
	}

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
