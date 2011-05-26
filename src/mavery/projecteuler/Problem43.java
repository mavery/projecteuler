package mavery.projecteuler;

import mavery.projecteuler.util.EulerUtils;

public class Problem43
{

	/**
	 * The number, 1406357289, is a 0 to 9 pandigital number because it is made
	 * up of each of the digits 0 to 9 in some order, but it also has a rather
	 * interesting sub-string divisibility property.
	 * 
	 * Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we
	 * note the following: d2d3d4=406 is divisible by 2 d3d4d5=063 is divisible
	 * by 3 d4d5d6=635 is divisible by 5 d5d6d7=357 is divisible by 7 d6d7d8=572
	 * is divisible by 11 d7d8d9=728 is divisible by 13 d8d9d10=289 is divisible
	 * by 17
	 * 
	 * Find the sum of all 0 to 9 pandigital numbers with this property.
	 */
	public static void main(String[] args)
	{
		long result = 0;
		
		int[] ia = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

		while (EulerUtils.increment(ia))
		{
			if (isValid(ia))
			{
				long l = buildNumber(ia, 0, 10);
				System.out.println(l);
				result += l;
			}
		}
		
		System.out.println(result);
	}
	
	public static boolean isValid(int[] ia)
	{
		if (buildNumber(ia, 7, 3) % 17 != 0)
		{
			return false;
		}

		if (buildNumber(ia, 6, 3) % 13 != 0)
		{
			return false;
		}

		if (buildNumber(ia, 5, 3) % 11 != 0)
		{
			return false;
		}

		if (buildNumber(ia, 4, 3) % 7 != 0)
		{
			return false;
		}

		if (buildNumber(ia, 3, 3) % 5 != 0)
		{
			return false;
		}

		if (buildNumber(ia, 2, 3) % 3 != 0)
		{
			return false;
		}

		if (buildNumber(ia, 1, 3) % 2 != 0)
		{
			return false;
		}
		
		return true;

	}

	public static long buildNumber(int[] ia, int start, int length)
	{
		long result = 0;
		for (int i = 0; i < length; i++)
		{
			result = result * 10 + ia[start + i];
		}
		return result;
	}
}
