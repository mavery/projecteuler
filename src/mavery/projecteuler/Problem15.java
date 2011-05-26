package mavery.projecteuler;

public class Problem15
{

	/**
	 * Starting in the top left corner of a 22 grid, there are 6 routes (without
	 * backtracking) to the bottom right corner.
	 * 
	 * How many routes are there through a 2020 grid?
	 */
	public static void main(String[] args)
	{
		int GRIDSIZE = 20;

		long[][] grid = new long[GRIDSIZE + 1][GRIDSIZE + 1];

		for (int i = 0; i < GRIDSIZE + 1; i++)
		{
			for (int j = 0; j < GRIDSIZE + 1; j++)
			{
				if (i == 0 || j == 0)
				{
					grid[i][j] = 1;
				}
				else
				{
					grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
				}
			}
		}
		System.out.println(grid[GRIDSIZE][GRIDSIZE]);
	}

}
