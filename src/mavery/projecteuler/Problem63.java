package mavery.projecteuler;

public class Problem63
{

	/**
	 * The 5-digit number, 16807=7^5, is also a fifth power. Similarly, the
	 * 9-digit number, 134217728=8^9, is a ninth power.
	 * 
	 * How many n-digit positive integers exist which are also an nth power?
	 */
	public static void main(String[] args)
	{
		int result = 0;
		
		// Don't need to test any number 10 or greater since they will always have too many digits. 
		for (int i = 1; i <= 9; i++)
		{
			for (int j = 1; j < 25; j++)
			{
				if (j == (int) (Math.log10(Math.pow(i, j)) + 1))
				{
					result++;
					System.out.printf("%d^%d - %d digits%n", i, j, j);
				}
			}
		}
		
		System.out.println(result);
	}
}
