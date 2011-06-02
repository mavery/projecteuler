package mavery.projecteuler;

import java.math.BigInteger;

public class Problem48
{
	private static final BigInteger MOD_FACTOR = BigInteger
			.valueOf(10000000000L);

	/**
	 * The series, 11 + 22 + 33 + ... + 1010 = 10405071317.
	 * 
	 * Find the last ten digits of the series, 11 + 22 + 33 + ... + 10001000.
	 */
	public static void main(String[] args)
	{
		BigInteger result = BigInteger.ZERO;

		for (int i = 1; i <= 1000; i++)
		{
			result = result.add(lastTenDigitPow(i));
		}

		result = result.mod(MOD_FACTOR);

		System.out.println(result);
	}

	public static BigInteger lastTenDigitPow(int n)
	{
		BigInteger bigN = BigInteger.valueOf(n);
		return bigN.modPow(bigN, MOD_FACTOR);
	}

}
