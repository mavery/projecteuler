package mavery.projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;

public class Problem11
{

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
		int[][] input = readMatrix();

		int result = 0;

		// horizontal lines
		for (int i = 0; i < 20; i++)
		{
			for (int j = 0; j < 17; j++)
			{
				int currentRes = 1;
				for (int k = 0; k < 4; k++)
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
		for (int i = 0; i < 17; i++)
		{
			for (int j = 0; j < 20; j++)
			{
				int currentRes = 1;
				for (int k = 0; k < 4; k++)
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
		for (int i = 0; i < 17; i++)
		{
			for (int j = 0; j < 17; j++)
			{
				int currentRes = 1;
				for (int k = 0; k < 4; k++)
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
		for (int i = 3; i < 20; i++)
		{
			for (int j = 0; j < 17; j++)
			{
				int currentRes = 1;
				for (int k = 0; k < 4; k++)
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

	public static int[][] readMatrix() throws Exception
	{
		BufferedReader inputFile = new BufferedReader(new FileReader(
				"resources/Problem11.txt"));

		int[][] result = new int[20][20];
		for (int i = 0; i < 20; i++)
		{
			String line = inputFile.readLine();
			String[] splitLine = line.split(" ");
			for (int j = 0; j < 20; j++)
			{
				result[i][j] = Integer.parseInt(splitLine[j]);
			}
		}

		return result;
	}

}
