package mavery.projecteuler;

public class Problem3
{

	/**
	 * The prime factors of 13195 are 5, 7, 13 and 29.
	 * 
	 * What is the largest prime factor of the number 600851475143 ?
	 */
	public static void main(String[] args)
	{
		long input = 600851475143L;

		for (long l = 2; l <= input; l++)
		{
			while (input % l == 0)
			{
				input /= l;
				if (input == 1)
				{
					System.out.println(l);
					return;
				}
			}
		}
	}
}
