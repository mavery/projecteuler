package mavery.projecteuler;

import mavery.projecteuler.util.EulerUtils;

public class Problem38
{

	/**
	 * Take the number 192 and multiply it by each of 1, 2, and 3: 192 1 = 192
	 * 192 2 = 384 192 3 = 576
	 * 
	 * By concatenating each product we get the 1 to 9 pandigital, 192384576. We
	 * will call 192384576 the concatenated product of 192 and (1,2,3)
	 * 
	 * The same can be achieved by starting with 9 and multiplying by 1, 2, 3,
	 * 4, and 5, giving the pandigital, 918273645, which is the concatenated
	 * product of 9 and (1,2,3,4,5).
	 * 
	 * What is the largest 1 to 9 pandigital 9-digit number that can be formed
	 * as the concatenated product of an integer with (1,2, ... , n) where n > 1?
	 */
	public static void main(String[] args)
	{
		int result = 0;
		
		// must be a maximum of 4 digits. 
		for (int i = 9999; i >= 0; i--)
		{
			StringBuilder builder = new StringBuilder();
			builder.append(i);
			for (int j = 2; builder.length() < 9; j++)
			{
				builder.append(i * j);
			}
			if (EulerUtils.isPandigital(builder.toString()))
			{
				System.out.println(i + " " + builder);
				if (Integer.parseInt(builder.toString()) > result)
				{
					result = Integer.parseInt(builder.toString());
				}
			}
		}
		
		System.out.println(result);
	}

}
