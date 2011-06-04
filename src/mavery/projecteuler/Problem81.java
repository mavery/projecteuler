package mavery.projecteuler;

import mavery.projecteuler.util.FileUtils;

public class Problem81
{
	public static final int SIZE = 80;

	/**
	 * In the 5 by 5 matrix below, the minimal path sum from the top left to the
	 * bottom right, by only moving to the right and down, is indicated in bold
	 * red and is equal to 2427.
	 * 
	 * Find the minimal path sum, in matrix.txt (right click and 'Save
	 * Link/Target As...'), a 31K text file containing a 80 by 80 matrix, from
	 * the top left to the bottom right by only moving right and down.
	 */
	public static void main(String[] args) throws Exception
	{
		int[][] matrix = FileUtils.readMatrix("resources/Problem81.txt", SIZE,
				SIZE);
		for (int i = 0; i < SIZE; i++)
		{
			for (int j = 0; j < SIZE; j++)
			{
				if (i == 0 && j == 0)
				{
					continue;
				}
				int down = (i == 0 ? Integer.MAX_VALUE : matrix[i - 1][j]);
				int right = (j == 0 ? Integer.MAX_VALUE : matrix[i][j - 1]);
				matrix[i][j] += Math.min(down, right);
			}
		}
		System.out.println(matrix[SIZE - 1][SIZE - 1]);
	}
}
