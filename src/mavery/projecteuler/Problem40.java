package mavery.projecteuler;

public class Problem40
{

	/**
	 * An irrational decimal fraction is created by concatenating the positive
	 * integers:
	 * 
	 * 0.123456789101112131415161718192021...
	 * 
	 * It can be seen that the 12th digit of the fractional part is 1.
	 * 
	 * If dn represents the nth digit of the fractional part, find the value of
	 * d1 * d10 * d100 * d1000 * d10000 * d100000 * d1000000
	 * the following expression.
	 */
	public static void main(String[] args)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 1; sb.length() <= 1000000; i++)
		{
			sb.append(i);
		}
		
		int result = 1;
		for (int i = 1; i <= 1000000; i *= 10)
		{
			result *= (sb.charAt(i - 1) - '0');
		}
		
		System.out.println(result);

	}

}
