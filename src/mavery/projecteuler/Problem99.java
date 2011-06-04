package mavery.projecteuler;

import java.util.ArrayList;
import java.util.List;

import mavery.projecteuler.util.FileUtils;

public class Problem99
{

	/**
	 * Comparing two numbers written in index form like 211 and 37 is not
	 * difficult, as any calculator would confirm that 211 = 2048 37 = 2187.
	 * 
	 * However, confirming that 632382^518061 519432^525806 would be much more
	 * difficult, as both numbers contain over three million digits.
	 * 
	 * Using base_exp.txt (right click and 'Save Link/Target As...'), a 22K text
	 * file containing one thousand lines with a base/exponent pair on each
	 * line, determine which line number has the greatest numerical value.
	 */
	public static void main(String[] args) throws Exception
	{
		System.out.println(new Problem99().solve("resources/Problem99.txt"));
	}
	
	/**
	 * Solves problem 99
	 * @return The line number of 'filename' which contains the greatest numerical value
	 * @throws Exception If file cannot be read or if it is in an invalid format
	 */
	public int solve(String filename) throws Exception
	{
		int result = 0;
		double best = 0.0;
		
		List<BaseExponentPair> pairs = readPairs(filename);
		
		int i = 1;
		for (BaseExponentPair p : pairs)
		{
			double current = Math.log(p.base) * p.exponent;
			if (current > best)
			{
				result = i;
				best = current;
			}
			i++;
		}
		
		return result;
	}
	
	private List<BaseExponentPair> readPairs(String filename) throws Exception
	{
		List<BaseExponentPair> result = new ArrayList<BaseExponentPair>();
		for (String s : FileUtils.readLines(filename))
		{
			result.add(new BaseExponentPair(s));
		}
		return result;
	}

	private class BaseExponentPair
	{
		int base;
		int exponent;
		
		BaseExponentPair(String input)
		{
			String[] pair = input.split(",");
			base = Integer.parseInt(pair[0]);
			exponent = Integer.parseInt(pair[1]);
		}
	}
}
