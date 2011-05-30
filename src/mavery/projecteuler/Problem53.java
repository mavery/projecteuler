package mavery.projecteuler;

import java.math.BigInteger;

public class Problem53
{
	
	public static final int MAX_N = 100;
	
	public static final BigInteger MIN_C = BigInteger.valueOf(1000000);

	/**
	 * There are exactly ten ways of selecting three from five, 12345:
	 * 
	 * 123, 124, 125, 134, 135, 145, 234, 235, 245, and 345
	 * 
	 * In combinatorics, we use the notation, 5C3 = 10.
	 * 
	 * In general,nCr = n! r!(nr)! ,where r n, n! = n(n1)...321, and 0! = 1.
	 * 
	 * 
	 * It is not until n = 23, that a value exceeds one-million: 23C10 =
	 * 1144066.
	 * 
	 * How many, not necessarily distinct, values of nCr, for 1 n 100, are
	 * greater than one-million?
	 */
	public static void main(String[] args)
	{
		BigInteger[] factorials = new BigInteger[MAX_N + 1];
		factorials[0] = BigInteger.ONE;
		for (int i = 1; i < factorials.length; i++)
		{
			factorials[i] = factorials[i - 1].multiply(BigInteger.valueOf(i));
		}
		
		int result = 0;
		for (int i = 23; i <= MAX_N; i++)
		{
			for (int j = 1; j <= i; j++)
			{
				if (factorials[i].divide(factorials[j].multiply(factorials[i - j])).compareTo(MIN_C) >= 0)
				{
					result++;
				}
			}
		}
		
		System.out.println(result);
	}
}
