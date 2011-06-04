package mavery.projecteuler.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils
{
	/**
	 * Returns a list of lines from the named file
	 * 
	 * @param filename
	 *            The file to read from
	 * @return A list of strings with the contents of the file
	 * @throws IOException
	 */
	public static List<String> readLines(String filename) throws IOException
	{
		BufferedReader inputFile = new BufferedReader(new FileReader(filename));

		List<String> result = new ArrayList<String>();

		while (inputFile.ready())
		{
			result.add(inputFile.readLine());
		}

		return result;
	}

	public static int[][] readMatrix(String filename, int rows, int columns) throws Exception
	{
		BufferedReader inputFile = new BufferedReader(new FileReader(filename));

		int[][] result = new int[rows][columns];
		for (int i = 0; i < rows; i++)
		{
			String line = inputFile.readLine();
			String[] splitLine = line.split(" ");
			for (int j = 0; j < columns; j++)
			{
				result[i][j] = Integer.parseInt(splitLine[j]);
			}
		}

		return result;
	}

}
