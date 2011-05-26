package mavery.projecteuler;

public class Problem9
{

	/**
	 * A Pythagorean triplet is a set of three natural numbers, a b c, for
	 * which, a^2 + b^2 = c^2
	 * 
	 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
	 * 
	 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
	 * Find the product abc.
	 */
	public static void main(String[] args)
	{
		for (int a = 1; a < 1000; a++)
		{
			for (int b = a; b < 1000; b++)
			{
				int c = 1000 - a - b;
				if (a * a + b * b == c * c)
				{
					System.out.println(a * b * c);
					System.exit(0);
				}

			}
		}

	}
}
