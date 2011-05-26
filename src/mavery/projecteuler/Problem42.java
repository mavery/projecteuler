package mavery.projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import mavery.projecteuler.util.FileUtils;


public class Problem42
{
	private static boolean[] triangular;

	/**
	 * The nth term of the sequence of triangle numbers is given by, tn =
	 * ½n(n+1); so the first ten triangle numbers are:
	 * 
	 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
	 * 
	 * By converting each letter in a word to a number corresponding to its
	 * alphabetical position and adding these values we form a word value. For
	 * example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word
	 * value is a triangle number then we shall call the word a triangle word.
	 * 
	 * Using words.txt (right click and 'Save Link/Target As...'), a 16K text
	 * file containing nearly two-thousand common English words, how many are
	 * triangle words?
	 */
	public static void main(String[] args) throws Exception
	{
		int result = 0;
		
		List<String> words = FileUtils.readLines("resources/Problem42.txt");
		for (String s : words)
		{
			if (isTriangular(getValue(s)))
			{
				System.out.println(s + " " + getValue(s));
				result++;
			}
		}
		System.out.println(result);
	}

	public static int getValue(String s)
	{
		int result = 0;
		for (int i = 0; i < s.length(); i++)
		{
			result += s.charAt(i) - 'A' + 1;
		}

		return result;
	}

	public static boolean isTriangular(int i)
	{
		if (triangular == null)
		{
			populateTriangularArray();
		}
		return triangular[i];
	}

	public static void populateTriangularArray()
	{
		triangular = new boolean[1000];

		int sum = 1;
		for (int i = 2; sum < triangular.length; i++)
		{
			triangular[sum] = true;
			sum += i;
		}
	}

	public static List<String> readLines() throws Exception
	{
		BufferedReader inputFile = new BufferedReader(new FileReader(
				"resources/Problem22.txt"));

		List<String> result = new ArrayList<String>();

		while (inputFile.ready())
		{
			result.add(inputFile.readLine());
		}

		return result;
	}

}
