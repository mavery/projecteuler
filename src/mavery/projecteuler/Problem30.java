package mavery.projecteuler;

public class Problem30
{

	/**
	 * Surprisingly there are only three numbers that can be written as the sum
	 * of fourth powers of their digits: 1634 = 14 + 64 + 34 + 44 8208 = 84 + 24
	 * + 04 + 84 9474 = 94 + 44 + 74 + 44
	 * 
	 * As 1 = 14 is not a sum it is not included.
	 * 
	 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
	 * 
	 * Find the sum of all the numbers that can be written as the sum of fifth
	 * powers of their digits.
	 */
	public static void main(String[] args)
	{
		int result = 0;
		
		for (int i = 2; i < 1000000; i++)
		{
			if (i == sumOfFifthPowersOfDigits(i))
			{
				result += i;
				System.out.println(i);
			}
		}
		
		System.out.println("Sum = " + result);
	}
	
	public static int sumOfFifthPowersOfDigits(int n)
	{
		int result = 0;
	
		while (n != 0)
		{
			int digit = n % 10;
			result += digit * digit * digit * digit * digit;
			n /= 10;
		}
		
		return result;
	}

}
