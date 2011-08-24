package mavery.projecteuler;

public class Problem85
{
	public static final int TARGET = 2_000_000;

	/**
	 * By counting carefully it can be seen that a rectangular grid measuring 3
	 * by 2 contains eighteen rectangles:
	 * 
	 * 
	 * Although there exists no rectangular grid that contains exactly two
	 * million rectangles, find the area of the grid with the nearest solution.
	 */
	public static void main(String[] args)
	{
		int result = 1;
		int bestDiff = Math.abs(TARGET - rectangles(1, 1));

		// could improve this loop
		for (int i = 1; i < 2000; i++)
		{
			for (int j = 1; j < 2000; j++)
			{
				int current = rectangles(i, j);
				if (Math.abs(TARGET - current) < bestDiff)
				{
					result = i * j;
					bestDiff = Math.abs(TARGET - current);
				}
			}
		}

		System.out.println(result);
	}

	/**
	 * Calculates the number of rectangles inside an x*y rectangle
	 * 
	 * @param x
	 *            x > 0
	 * @param y
	 *            y > 0
	 * @return The number of rectangles contained within an x*y rectangle.
	 */
	public static int rectangles(int x, int y)
	{
		return (x * (x + 1) / 2) * (y * (y + 1) / 2);
	}
}