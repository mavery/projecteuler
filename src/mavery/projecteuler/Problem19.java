package mavery.projecteuler;

public class Problem19
{
	public static final int[] MONTHS = { 31, 0, 31, 30, 31, 30, 31, 31, 30, 31,
			30, 31 };

	/**
	 * You are given the following information, but you may prefer to do some
	 * research for yourself.
	 * 
	 * 1 Jan 1900 was a Monday.
	 * 
	 * Thirty days has September, April, June and November. All the rest have
	 * thirty-one, Saving February alone, Which has twenty-eight, rain or shine.
	 * And on leap years, twenty-nine.
	 * 
	 * A leap year occurs on any year evenly divisible by 4, but not on a
	 * century unless it is divisible by 400.
	 * 
	 * How many Sundays fell on the first of the month during the twentieth
	 * century (1 Jan 1901 to 31 Dec 2000)?
	 */
	public static void main(String[] args)
	{
		// 0 = monday, 7 = sunday

		int day = 0;
		int result = 0;
		for (int year = 1900; year <= 2000; year++)
		{
			for (int month = 1; month <= 12; month++)
			{
				day = (day + daysInMonth(year, month)) % 7;
				if (day == 6 && year >= 1901)
				{
					result++;
				}
			}
		}

		System.out.println(result);

	}

	public static int daysInMonth(int year, int month)
	{
		if (month == 2)
		{
			if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			{
				return 29;
			}
			else
			{
				return 28;
			}
		}
		else
		{
			return MONTHS[month - 1];
		}
	}

}
