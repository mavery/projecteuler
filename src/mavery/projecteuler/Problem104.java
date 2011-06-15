package mavery.projecteuler;

import mavery.projecteuler.util.EulerUtils;

/*
 * This solution isn't perfect since it's possible that it could miscount the
 * first 9 digits. A miscount would be a very rare event (1/(10^10) chance on each
 * iteration) and luckily it finds a solution before this happens.
 */
public class Problem104
{
	private static final int E_DIV = 1000000000;
	private static final long S_MAX = 1000000000000000000L;

	/**
	 * The Fibonacci sequence is defined by the recurrence relation: Fn = Fn1 +
	 * Fn2, where F1 = 1 and F2 = 1.
	 * 
	 * It turns out that F541, which contains 113 digits, is the first Fibonacci
	 * number for which the last nine digits are 1-9 pandigital (contain all the
	 * digits 1 to 9, but not necessarily in order). And F2749, which contains
	 * 575 digits, is the first Fibonacci number for which the first nine digits
	 * are 1-9 pandigital.
	 * 
	 * Given that Fk is the first Fibonacci number for which the first nine
	 * digits AND the last nine digits are 1-9 pandigital, find k.
	 */
	public static void main(String[] args)
	{
		long prevS = 1L;
		long curS = 1L; // The first digits of F(k)
		int prevE = 1;
		int curE = 1; // The last digits of F(k)

		int k = 2;
		String firstNine = null, lastNine = null;
		do
		{
			long tempS = curS;
			curS += prevS;
			prevS = tempS;
			if (curS > S_MAX)
			{
				curS /= 10L;
				prevS /= 10L;
			}
			firstNine = Long.toString(curS);
			if (firstNine.length() > 9)
			{
				firstNine = firstNine.substring(0, 9);
			}

			int tempE = curE;
			curE += prevE;
			prevE = tempE;
			if (curE >= E_DIV)
			{
				curE %= E_DIV;
			}
			lastNine = Long.toString(curE);

			k++;
		}
		while (!EulerUtils.isPandigital(firstNine)
				|| !EulerUtils.isPandigital(lastNine));

		System.out.println(k);
	}
}
