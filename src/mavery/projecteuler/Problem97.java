package mavery.projecteuler;

import java.math.BigInteger;

public class Problem97
{
	public static final BigInteger POW = BigInteger.valueOf(7830457);
	public static final BigInteger MULT = BigInteger.valueOf(28433);

	private static final BigInteger MOD_FACTOR = BigInteger
			.valueOf(10000000000L);

	/**
	 * The first known prime found to exceed one million digits was discovered
	 * in 1999, and is a Mersenne prime of the form 2^6972593-1; it contains
	 * exactly 2,098,960 digits. Subsequently other Mersenne primes, of the form
	 * 2^p+/-1, have been found which contain more digits.
	 * 
	 * However, in 2004 there was found a massive non-Mersenne prime which
	 * contains 2,357,207 digits: 28433*2^7830457+1.
	 * 
	 * Find the last ten digits of this prime number.
	 */
	public static void main(String[] args)
	{
		System.out.println(BigInteger.valueOf(2).modPow(POW, MOD_FACTOR)
				.multiply(MULT).add(BigInteger.ONE).mod(MOD_FACTOR));
	}
}
