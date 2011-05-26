package mavery.projecteuler;

import java.math.BigInteger;

import mavery.projecteuler.util.EulerUtils;


public class Problem20
{

	/**
	 * Find the sum of the digits in the number 100!
	 */
	public static void main(String[] args)
	{
		BigInteger factorial = new BigInteger("1");
		for (int i = 2; i <= 100; i++)
		{
			factorial = factorial.multiply(new BigInteger(Integer.toString(i)));
		}

		System.out.println(EulerUtils.sumDigits(factorial));

	}

}
