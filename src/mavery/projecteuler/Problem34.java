package mavery.projecteuler;

public class Problem34
{
	// precomputed for speeeeed
	private static int[] factorials = { 1, 1, 2, 6, 24, 120, 720, 5040, 40320,
			362880 };

	/**
	 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
	 * 
	 * Find the sum of all numbers which are equal to the sum of the factorial
	 * of their digits.
	 * 
	 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
	 */
	public static void main(String[] args)
	{
		int result = 0;
		for (int i = 3; i < factorials[9] * 7; i++)
		{
			if (i == sumOfFactorialsOfDigits(i))
			{
				System.out.println(i);
				result += i;
			}
		}
		System.out.println(result);
	}

	/**
	 * Returns the sum of the factorials of the digits of n
	 * 
	 * @param n
	 * @return
	 */
	public static int sumOfFactorialsOfDigits(int n)
	{
		int result = 0;
		while (n > 0)
		{
			result += factorials[n % 10];
			n /= 10;
		}
		return result;
	}

}
