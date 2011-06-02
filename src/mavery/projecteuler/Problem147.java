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
				result += countCrossHatch(i, j);
			}
		}

		System.out.println(result);
	}

	/**
	 * Returns the number of rectangles that can be created using the horizontal
	 * and vertical grid lines
	 */
	public static int countRectangles(int x, int y)
	{
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

	/**
	 * Returns the total number of rectangles that can be created using the cross-hatched lines. 
	 */
	public static int countCrossHatch(int x, int y)
	{

		// Initially this is the number of 1x1 squares
		int squares = 2 * x * (x - 1) + ((2 * x) - 1) * (y - x);
		int result = 0;

		for (int rowCount = 0, nextRow = (x + y - 2); squares > 0; rowCount++)
		{
			int current = squares;
			for (int colCount = 0, nextCol = (x + y - 2) - rowCount; current > 0; colCount++)
			{
				result += current;

				// Adds one to the x dimension of the rectangle
				current -= nextCol;
				if (colCount % 2 == 1)
				{
					nextCol -= 2;
				}
			}

			// Adds one to the y dimension of the rectangle
			squares -= nextRow;
			if (rowCount % 2 == 1)
			{
				nextRow -= 2;
			}
		}

		return result;
	}
}
