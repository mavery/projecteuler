package mavery.projecteuler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import mavery.projecteuler.util.EulerUtils;

public class Problem74
{
	public static final int LIMIT = 1000000;

	private static final int[] chains = new int[362880 * 7 + 1]; // 7 digits * 9
																	// factorial

	/**
	 * The number 145 is well known for the property that the sum of the
	 * factorial of its digits is equal to 145:
	 * 
	 * 1! + 4! + 5! = 1 + 24 + 120 = 145
	 * 
	 * Perhaps less well known is 169, in that it produces the longest chain of
	 * numbers that link back to 169; it turns out that there are only three
	 * such loops that exist:
	 * 
	 * 169 363601 1454 169 871 45361 871 872 45362 872
	 * 
	 * It is not difficult to prove that EVERY starting number will eventually
	 * get stuck in a loop. For example,
	 * 
	 * 69 363600 1454 169 363601 ( 1454) 78 45360 871 45361 ( 871) 540 145 (
	 * 145)
	 * 
	 * Starting with 69 produces a chain of five non-repeating terms, but the
	 * longest non-repeating chain with a starting number below one million is
	 * sixty terms.
	 * 
	 * How many chains, with a starting number below one million, contain
	 * exactly sixty non-repeating terms?
	 */
	public static void main(String[] args)
	{
		int result = 0;
		for (int i = 1; i < LIMIT; i++)
		{
			if (chainLength(i) == 60)
			{
				result++;
			}
		}
		System.out.println(result);
	}

	/**
	 * Returns the number of items in the factorial chain before the first
	 * repetition.
	 * 
	 * @param n
	 *            a positive integer less than LIMIT
	 * @return a count of the number of elements
	 */
	public static int chainLength(int n)
	{
		// could improve this by precalculating all known cycles and then
		// ignoring the cycle case.
		if (chains[n] != 0)
		{
			return chains[n];
		}

		Set<Integer> inChain = new HashSet<Integer>();
		List<Integer> chain = new ArrayList<Integer>();
		int cur = n;
		while (chains[cur] == 0 && !inChain.contains(cur))
		{
			inChain.add(cur);
			chain.add(cur);
			cur = EulerUtils.sumOfFactorialsOfDigits(cur);
		}

		if (chains[cur] == 0)
		{
			int cycleLength = chain.size() - chain.lastIndexOf(cur);
			for (int i = 0; i < cycleLength; i++)
			{
				chains[chain.get(chain.size() - i - 1)] = cycleLength;
			}
		}
		else
		{
			chain.add(cur);
		}

		for (int i = chain.lastIndexOf(cur) - 1; i >= 0; i--)
		{
			chains[chain.get(i)] = chains[chain.get(i + 1)] + 1;
		}

		return chains[n];
	}
}