package mavery.projecteuler;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import mavery.projecteuler.util.FileUtils;

public class Problem79
{

	/**
	 * A common security method used for online banking is to ask the user for
	 * three random characters from a passcode. For example, if the passcode was
	 * 531278, they may ask for the 2nd, 3rd, and 5th characters; the expected
	 * reply would be: 317.
	 * 
	 * The text file, keylog.txt, contains fifty successful login attempts.
	 * 
	 * Given that the three characters are always asked for in order, analyse
	 * the file so as to determine the shortest possible secret passcode of
	 * unknown length.
	 */
	public static void main(String[] args) throws Exception
	{
		// Note: It's trivial to solve this one by hand. I'm writing this code
		// after the fact to see how it could be done.

		// Given the nature of the problem we can assume that there is a unique
		// solution, also assuming each digit only appears once.

		List<String> logins = FileUtils.readLines("resources/Problem79.txt");
		Set<Character> chars = getAllCharacters(logins);

		StringBuffer result = new StringBuffer(chars.size());
		while (result.length() < chars.size())
		{
			// Searches for a character that appears at the start of every input
			// string, ignoring any characters already in the result string,
			// then appends that character to the result.
			nextChar: for (char current : chars)
			{
				if (contains(result, current))
				{
					continue;
				}
				outer: for (String s : logins)
				{
					if (!contains(s, current))
					{
						continue outer;
					}
					inner: for (int i = 0; i < s.length(); i++)
					{
						if (contains(result, s.charAt(i)))
						{
							continue inner;
						}
						if (s.charAt(i) == current)
						{
							continue outer;
						}
						continue nextChar;
					}
				}
				result.append(current);
				break;
			}
		}

		System.out.println(result.toString());

	}

	/**
	 * Returns a set containing all characters present in the strings in input.
	 */
	private static Set<Character> getAllCharacters(List<String> input)
	{
		Set<Character> chars = new HashSet<Character>();

		for (String s : input)
		{
			for (int i = 0; i < s.length(); i++)
			{
				if (!chars.contains(s.charAt(i)))
				{
					chars.add(s.charAt(i));
				}
			}
		}

		return chars;
	}

	/**
	 * Returns true if the CharSequence seq contains the char c. False
	 * otherwise.
	 */
	private static boolean contains(CharSequence seq, char c)
	{
		for (int i = 0; i < seq.length(); i++)
		{
			if (c == seq.charAt(i))
			{
				return true;
			}
		}
		return false;
	}
}
