package mavery.projecteuler;

import java.util.HashSet;
import java.util.Set;

import mavery.projecteuler.util.EulerUtils;

public class Problem95
{

	public static final int LIMIT = 1000000;

	/**
	 * The proper divisors of a number are all the divisors excluding the number
	 * itself. For example, the proper divisors of 28 are 1, 2, 4, 7, and 14. As
	 * the sum of these divisors is equal to 28, we call it a perfect number.
	 * 
	 * Interestingly the sum of the proper divisors of 220 is 284 and the sum of
	 * the proper divisors of 284 is 220, forming a chain of two numbers. For
	 * this reason, 220 and 284 are called an amicable pair.
	 * 
	 * Perhaps less well known are longer chains. For example, starting with
	 * 12496, we form a chain of five numbers:
	 * 
	 * 12496 14288 15472 14536 14264 ( 12496 ...)
	 * 
	 * Since this chain returns to its starting point, it is called an amicable
	 * chain.
	 * 
	 * Find the smallest member of the longest amicable chain with no element
	 * exceeding one million.
	 */
	public static void main(String[] args)
	{
		int result = 0;
		int best = 0;

		for (int i = 1; i < LIMIT; i++)
		{
			int currentChainLength = 1;
			int currentChainElement = EulerUtils.sumOfProperDivisors(i);
			int lowestChainElement = Math.min(currentChainElement, i);

			Set<Integer> currentChain = new HashSet<>();
			while (currentChainElement < LIMIT
					&& !currentChain.contains(currentChainElement))
			{
				if (currentChainElement == i)
				{
					if (currentChainLength > best)
					{
						result = lowestChainElement;
						best = currentChainLength;
					}
					break;
				}

				currentChain.add(currentChainElement);
				currentChainElement = EulerUtils
						.sumOfProperDivisors(currentChainElement);
				lowestChainElement = Math.min(currentChainElement,
						lowestChainElement);
				currentChainLength++;
			}
		}
		System.out.println(result);
	}
}
