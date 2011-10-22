package mavery.projecteuler;

import java.util.HashSet;
import java.util.Set;

public class Problem346
{
	public static final long LIMIT = 1_000_000_000_000L;

	/**
	 * The number 7 is special, because 7 is 111 written in base 2, and 11
	 * written in base 6 (i.e. 710 = 116 = 1112). In other words, 7 is a repunit
	 * in at least two bases b > 1.
	 * 
	 * We shall call a positive integer with this property a strong repunit. It
	 * can be verified that there are 8 strong repunits below 50:
	 * {1,7,13,15,21,31,40,43}. Furthermore, the sum of all strong repunits
	 * below 1000 equals 15864. Find the sum of all strong repunits below 1012.
	 */
	public static void main(String[] args)
	{
		Set<Long> strongRepunits = new HashSet<Long>();
		strongRepunits.add(1L);
		
		int maxTest = (int) Math.ceil(Math.sqrt(LIMIT));
		for (long i = 2; i <= maxTest; i++)
		{
			for (long j = i * i + i + 1; j < LIMIT; j = j * i + 1)
			{
				strongRepunits.add(j);
			}
		}
		
		long result = 0;
		for (long current : strongRepunits)
		{
			result += current;
		}
		System.out.println(result);
	}
}
