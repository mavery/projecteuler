package mavery.projecteuler;

public class Problem164
{
	public static final int MAX_DIGITS = 20;
	
	public static final long[][][] storedResults = new long[MAX_DIGITS + 1][10][10];

	/**
	 * How many 20 digit numbers n (without any leading zero) exist such that no
	 * three consecutive digits of n have a sum greater than 9?
	 */
	public static void main(String[] args)
	{
		long result = 0;
		for (int i = 1; i <= 9; i++)
		{
			result += validNumbers(MAX_DIGITS - 1, 0, i);
		}
		System.out.println(result);
	}
	
	public static long validNumbers(int remainingDigits, int a, int b)
	{
		if (storedResults[remainingDigits][a][b] != 0)
		{
			return storedResults[remainingDigits][a][b];
		}
		if (remainingDigits == 0)
		{
			return 1;
		}
		
		long result = 0;
		for (int i = 0; i <= 9; i++)
		{
			if (a + b + i <= 9)
			{
				result += validNumbers(remainingDigits - 1, b, i);
			}
		}
		
		storedResults[remainingDigits][a][b] = result;
		return result;
	}

}
