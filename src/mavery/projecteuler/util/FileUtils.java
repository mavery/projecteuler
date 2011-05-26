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
	 * @param filename The file to read from
	 * @return A list of strings with the contents of the file
	 * @throws IOException
	 */
	public static List<String> readLines(String filename) throws IOException
	{
		BufferedReader inputFile = new BufferedReader(new FileReader(
				filename));

		List<String> result = new ArrayList<String>();

		while (inputFile.ready())
		{
			result.add(inputFile.readLine());
		}

		return result;
	}


}
