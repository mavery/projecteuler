package mavery.projecteuler;

import mavery.projecteuler.util.FileUtils;

public class Problem11
{
	public static final int MATRIX_SIZE = 20;
	public static final int LINE_LENGTH = 4;

	/**
	 * In the 2020 grid below, four numbers along a diagonal line have been
	 * marked in red.
	 * 
	 * (See Problem11.txt)
	 * 
	 * The product of these numbers is 26 63 78 14 = 1788696.
	 * 
	 * What is the greatest product of four adjacent numbers in any direction
	 * (up, down, left, right, or diagonally) in the 2020 grid?
	 */
	public static void main(String[] args) throws Exception
	{
		int[][] input = FileUtils.readMatrix("resources/Problem11.txt", MATRIX_SIZE, MATRIX_SIZE);

		int result = 0;

		// horizontal lines
		for (int i = 0; i < MATRIX_SIZE; i++)
		{
			for (int j = 0; j < MATRIX_SIZE - LINE_LENGTH + 1; j++)
			{
				int currentRes = 1;
				for (int k = 0; k < LINE_LENGTH; k++)
				{
					currentRes *= input[i][j + k];
				}
				if (result < currentRes)
				{
					result = currentRes;
				}
			}
		}

		// vertical lines
		for (int i = 0; i < MATRIX_SIZE - LINE_LENGTH + 1; i++)
		{
			for (int j = 0; j < MATRIX_SIZE; j++)
			{
				int currentRes = 1;
				for (int k = 0; k < LINE_LENGTH; k++)
				{
					currentRes *= input[i + k][j];
				}
				if (result < currentRes)
				{
					result = currentRes;
				}
			}
		}

		// diagonal forward
		for (int i = 0; i < MATRIX_SIZE - LINE_LENGTH + 1; i++)
		{
			for (int j = 0; j < MATRIX_SIZE - LINE_LENGTH + 1; j++)
			{
				int currentRes = 1;
				for (int k = 0; k < LINE_LENGTH; k++)
				{
					currentRes *= input[i + k][j + k];
				}
				if (result < currentRes)
				{
					result = currentRes;
				}
			}
		}

		// diagonal backwards
		for (int i = 3; i < MATRIX_SIZE; i++)
		{
			for (int j = 0; j < MATRIX_SIZE - LINE_LENGTH + 1; j++)
			{
				int currentRes = 1;
				for (int k = 0; k < LINE_LENGTH; k++)
				{
					currentRes *= input[i - k][j + k];
				}
				if (result < currentRes)
				{
					result = currentRes;
				}
			}
		}

		System.out.println(result);
	}
}
