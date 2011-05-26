package mavery.projecteuler;

import java.math.BigInteger;

public class Problem16
{

	/**
	 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
	 * 
	 * What is the sum of the digits of the number 2^1000?
	 */
	public static void main(String[] args)
	{
		BigInteger value = new BigInteger("2").pow(1000);

		String strValue = value.toString();

		int result = 0;
		for (int i = 0; i < strValue.length(); i++)
		{
			result += strValue.charAt(i) - '0';
		}
		System.out.println(result);

	}

}
