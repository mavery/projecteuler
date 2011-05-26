package mavery.projecteuler;

import java.util.Collections;
import java.util.List;

import mavery.projecteuler.util.FileUtils;


public class Problem22
{

	/**
	 * Using Problem22.txt (right click and 'Save Link/Target As...'), a 46K
	 * text file containing over five-thousand first names, begin by sorting it
	 * into alphabetical order. Then working out the alphabetical value for each
	 * name, multiply this value by its alphabetical position in the list to
	 * obtain a name score.
	 * 
	 * For example, when the list is sorted into alphabetical order, COLIN,
	 * which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list.
	 * So, COLIN would obtain a score of 938 * 53 = 49714.
	 * 
	 * What is the total of all the name scores in the file?
	 */
	public static void main(String[] args) throws Exception
	{
		List<String> names = FileUtils.readLines("resources/Problem22.txt");

		Collections.sort(names);

		int result = 0;
		for (int i = 0; i < names.size(); i++)
		{
			result += (i + 1) * wordScore(names.get(i));
		}

		System.out.println(result);

	}

	public static int wordScore(String input)
	{
		int result = 0;
		for (int i = 0; i < input.length(); i++)
		{
			result += input.charAt(i) - 'A' + 1;
		}
		return result;
	}

}
