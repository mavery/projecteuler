package mavery.projecteuler;

public class Problem5
{

	/**
	 * 2520 is the smallest number that can be divided by each of the numbers
	 * from 1 to 10 without any remainder.
	 * 
	 * What is the smallest positive number that is evenly divisible by all of
	 * the numbers from 1 to 20?
	 */
	public static void main(String[] args)
	{
		for (int i = 20; i <= 1000000000; i += 20)
		{
			boolean valid = true;
			for (int j = 2; j <= 20 && valid; j++)
			{
				valid = (i % j == 0);
			}
			if (valid)
			{
				System.out.println(i);
				System.exit(0);
			}
		}

		System.out.println("Failed");

	}
}
