package mavery.projecteuler;

import java.math.BigDecimal;

public class Problem48
{
	private static final long MOD_FACTOR = 10000000000L;

	/**
	 * The series, 11 + 22 + 33 + ... + 1010 = 10405071317.
	 * 
	 * Find the last ten digits of the series, 11 + 22 + 33 + ... + 10001000.
	 */
	public static void main(String[] args)
	{
		long result = 0;

		for (int i = 1; i <= 1000; i++)
		{
			// System.out.println(lastTenDigitPow(i));
			result += lastTenDigitPow(i);
		}

		result %= MOD_FACTOR;

		System.out.println(result);
	}

	private static long lastTenDigitPow(long n)
	{
		long i = n;
		long result = 1;

		while (i != 0)
		{
			n %= MOD_FACTOR;
			result %= MOD_FACTOR;

			if ((i & 1) != 0)
			{
				result = safeTenDigitMultiply(result, n);
			}

			n = safeTenDigitMultiply(n, n);
			i >>= 1;
		}

		return result % MOD_FACTOR;
	}

	/**
	 * 10 digits * 10 digits will overflow a long so this does it with
	 * BigDecimals. Would be faster to just use BigDecimals all along but I wanted
	 * to write my own pow method. How annoying that I have to do this :(
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private static long safeTenDigitMultiply(long a, long b)
	{
		return BigDecimal.valueOf(a).multiply(BigDecimal.valueOf(b)).remainder(
				BigDecimal.valueOf(MOD_FACTOR)).longValueExact();
	}

}
