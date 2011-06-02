package mavery.projecteuler;

public class Problem147
{

	public static final int MAX_X = 47;
	public static final int MAX_Y = 43;

	/**
	 * In a 3x2 cross-hatched grid, a total of 37 different rectangles could be
	 * situated within that grid as indicated in the sketch.
	 * 
	 * 
	 * There are 5 grids smaller than 3x2, vertical and horizontal dimensions
	 * being important, i.e. 1x1, 2x1, 3x1, 1x2 and 2x2. If each of them is
	 * cross-hatched, the following number of different rectangles could be
	 * situated within those smaller grids:
	 * 
	 * 1x1: 1 2x1: 4 3x1: 8 1x2: 4 2x2: 18
	 * 
	 * Adding those to the 37 of the 3x2 grid, a total of 72 different
	 * rectangles could be situated within 3x2 and smaller grids.
	 * 
	 * How many different rectangles could be situated within 47x43 and smaller
	 * grids?
	 */
	public static void main(String[] args)
	{
		int result = 0;

		for (int i = 1; i <= MAX_X; i++)
		{
			for (int j = 1; j <= MAX_Y; j++)
			{
				result += countRectangles(i, j);
				result += countDiamonds(i, j);

				// System.out.printf("%d %d : %d\n", i, j, countRectangles(i, j)
				// + countDiamonds(i, j));
			}
		}

		System.out.println(result);
	}

	public static int countRectangles(int x, int y)
	{
		if (x <= 0 || y <= 0)
		{
			return 0;
		}

		int result = 0;
		for (int i = 1; i <= x; i++)
		{
			for (int j = 1; j <= y; j++)
			{
				result += i * j;
			}
		}

		return result;
	}

	public static int countDiamonds(int x, int y)
	{
		if (x > y)
		{
			int temp = x;
			x = y;
			y = temp;
		}

		if (x <= 0)
		{
			return 0;
		}

		if (x == 1)
		{
			return Math.max(0, y - 1);
		}

		int basicDiamonds = 2 * x * (x - 1) + ((2 * x) - 1) * (y - x);
		int result = 0;

		for (int i = 1; i < 2 * x; i++)
		{
			for (int j = 1; j < 2 * y; j++)
			{
				int current = basicDiamonds;

				int rowsRemoved = 0;
				for (int a = (x + y - 2), b = j - 1, c = 0; a > 0 && b > 0; c ^= 1, b--, a = c == 1 ? a
						: a - 2)
				{
					current -= a;
					rowsRemoved++;
				}
				for (int a = (x + y - 2) - rowsRemoved, b = i - 1, c = 0; a > 0
						&& b > 0; c ^= 1, b--, a = c == 1 ? a : a - 2)
				{
					current -= a;
				}

				if (current > 0)
				{
					result += current;
				}
			}
		}

		return result;
	}
}
