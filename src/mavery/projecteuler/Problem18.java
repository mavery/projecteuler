package mavery.projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;

public class Problem18
{

	public static final int HEIGHT = 15;

	/**
	 * By starting at the top of the triangle below and moving to adjacent
	 * numbers on the row below, the maximum total from top to bottom is 23.
	 * 
	 * 3 7 4 2 4 6 8 5 9 3
	 * 
	 * That is, 3 + 7 + 4 + 9 = 23.
	 * 
	 * Find the maximum total from top to bottom of the triangle below:
	 * 
	 * See Problem18.txt
	 * 
	 * NOTE: As there are only 16384 routes, it is possible to solve this
	 * problem by trying every route. However, Problem 67, is the same challenge
	 * with a triangle containing one-hundred rows; it cannot be solved by brute
	 * force, and requires a clever method! ;o)
	 */
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception
	{
		int[][] matrix = readMatrix();

		int[] lastLine = matrix[HEIGHT - 1];
		int[] nextLine;
		for (int i = HEIGHT - 1; i > 0; i--)
		{
			nextLine = new int[i];
			for (int j = 0; j < i; j++)
			{
				nextLine[j] = Math.max(lastLine[j], lastLine[j + 1])
						+ matrix[i - 1][j];
			}
			lastLine = nextLine;
		}

		System.out.println(lastLine[0]);

	}

	public static int[][] readMatrix() throws Exception
	{
		BufferedReader inputFile = new BufferedReader(new FileReader(
				"resources/Problem18.txt"));

		int[][] result = new int[HEIGHT][];
		for (int i = 0; i < HEIGHT; i++)
		{
			result[i] = new int[i + 1];
			String line = inputFile.readLine();
			String[] splitLine = line.split(" ");
			for (int j = 0; j <= i; j++)
			{
				result[i][j] = Integer.parseInt(splitLine[j]);
			}
		}

		return result;
	}

}
