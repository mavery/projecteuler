package mavery.projecteuler;

import java.util.ArrayList;
import java.util.List;

/**
 * Not working for the full case yet, only for the 1->10^3 case. I think I
 * should be able to find a recursive definition of G(n) but I don't have it
 * yet.
 */
public class Problem341
{
	public static final int LIMIT = 1000;

	private static final long ARRAY_LIMIT = 1000000;

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
	 * sum G(n^3) = 153506976 for 1 n 10^3.
	 * 
	 * Find sum G(n3) for 1 <= n <= 10^6.
	 */
	public static void main(String[] args)
	{
		golombs = new ArrayList<Long>();
		golombs.add(0L);
		golombs.add(1L);
		golombs.add(2L);
		golombs.add(4L);

		while (golombs.get(golombs.size() - 1) < ARRAY_LIMIT)
		{
			golombs
					.add(golombs.get(golombs.size() - 1)
							+ g(golombs.size() - 1));
		}

		System.out.printf("%d %d%n", g(1000), g(1000000));

		long result = 0;
		long sum = 0;
		long count = 0;
		long n = 1;
		while (n < LIMIT)
		{
			long target = n * n * n;
			sum += g(count);
			while (sum >= target)
			{
				result += count;
				System.out.printf("%d %d %d%n", n, target, g(count));
				n++;
				target = n * n * n;
			}
			count++;

		}
		System.out.println(result);
	}

	/**
	 * My own binary search. Could probably do this using
	 * Collections.binarySearch but the behaviour of that method when it doesn't
	 * find an exact match is quite awkward to work with here.
	 */
	private static long g(long n)
	{
		int start = 0;
		int end = golombs.size() - 1;
		while (start + 1 < end)
		{
			int mid = (start + end) / 2;
			long midValue = golombs.get(mid);
			if (midValue == n)
			{
				return mid;
			}
			else if (midValue > n)
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
