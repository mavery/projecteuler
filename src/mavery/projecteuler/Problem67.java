package mavery.projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;

public class Problem67
{
	public static final int HEIGHT = 100;

	/**
	 * By starting at the top of the triangle below and moving to adjacent
	 * numbers on the row below, the maximum total from top to bottom is 23.
	 * 
	 * 3 7 4 2 4 6 8 5 9 3
	 * 
	 * That is, 3 + 7 + 4 + 9 = 23.
	 * 
	 * Find the maximum total from top to bottom in triangle.txt (right click
	 * and 'Save Link/Target As...'), a 15K text file containing a triangle with
	 * one-hundred rows.
	 * 
	 * NOTE: This is a much more difficult version of Problem 18. It is not
	 * possible to try every route to solve this problem, as there are 299
	 * altogether! If you could check one trillion (1012) routes every second it
	 * would take over twenty billion years to check them all. There is an
	 * efficient algorithm to solve it. ;o)
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
				"resources/Problem67.txt"));

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
