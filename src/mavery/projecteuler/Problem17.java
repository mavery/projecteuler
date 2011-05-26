package mavery.projecteuler;

public class Problem17
{

	public static final int[] zeroToNineteen = { 0, 3, 3, 5, 4, 4, 3, 5, 5, 4,
			3, 6, 6, 8, 8, 7, 7, 9, 8, 8 };
	public static final int[] tens = { 0, 3, 6, 6, 5, 5, 5, 7, 6, 6 };
	public static final int HUNDRED = 7;
	public static final int AND = 3;

	/**
	 * If the numbers 1 to 5 are written out in words: one, two, three, four,
	 * five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
	 * 
	 * If all the numbers from 1 to 1000 (one thousand) inclusive were written
	 * out in words, how many letters would be used?
	 * 
	 * 
	 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and
	 * forty-two) contains 23 letters and 115 (one hundred and fifteen) contains
	 * 20 letters. The use of "and" when writing out numbers is in compliance
	 * with British usage.
	 */
	public static void main(String[] args)
	{
		int result = 0;
		for (int i = 1; i <= 1000; i++)
		{
			result += letters(i);
		}
		
		System.out.println(letters(342) + " " + letters(115));

		System.out.println(result);

	}

	public static int letters(int input)
	{
		if (input == 1000)
		{
			return 11;
		}
		int res = 0;
		if (input >= 100)
		{
			res += zeroToNineteen[input / 100] + HUNDRED;
			if (input % 100 != 0)
			{
				res += AND;
			}
		}
		input = input % 100;
		if (input < 20)
		{
			res += zeroToNineteen[input];
		}
		else
		{
			res += tens[input / 10];
			res += zeroToNineteen[input % 10];
		}

		return res;
	}
}
