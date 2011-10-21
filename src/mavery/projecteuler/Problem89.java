package mavery.projecteuler;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mavery.projecteuler.util.FileUtils;

public class Problem89
{
	private static final int[] MINIMAL_CHARACTERS = { 0, 1, 2, 3, 2, 1, 2, 3,
			4, 2 };

	private static final Map<Character, Integer> VALUES;

	static
	{
		VALUES = new HashMap<Character, Integer>();
		VALUES.put('I', 1);
		VALUES.put('V', 5);
		VALUES.put('X', 10);
		VALUES.put('L', 50);
		VALUES.put('C', 100);
		VALUES.put('D', 500);
		VALUES.put('M', 1000);
	}

	/**
	 * he rules for writing Roman numerals allow for many ways of writing each
	 * number (see About Roman Numerals...). However, there is always a "best"
	 * way of writing a particular number.
	 * 
	 * For example, the following represent all of the legitimate ways of
	 * writing the number sixteen:
	 * 
	 * IIIIIIIIIIIIIIII VIIIIIIIIIII VVIIIIII XIIIIII VVVI XVI
	 * 
	 * The last example being considered the most efficient, as it uses the
	 * least number of numerals.
	 * 
	 * The 11K text file, roman.txt (right click and 'Save Link/Target As...'),
	 * contains one thousand numbers written in valid, but not necessarily
	 * minimal, Roman numerals; that is, they are arranged in descending units
	 * and obey the subtractive pair rule (see About Roman Numerals... for the
	 * definitive rules for this problem).
	 * 
	 * Find the number of characters saved by writing each of these in their
	 * minimal form.
	 * 
	 * Note: You can assume that all the Roman numerals in the file contain no
	 * more than four consecutive identical units.
	 */
	public static void main(String[] args) throws IOException
	{
		List<String> lines = FileUtils.readLines("resources/Problem89.txt");

		int result = 0;
		for (String romanNumeral : lines)
		{
			result += romanNumeral.length() - minimalCharacters(convertRomanNumeral(romanNumeral));
		}
		System.out.println(result);
	}

	/**
	 * Calculates the minimal number of characters required to represent a
	 * number in roman numerals.
	 * 
	 * @param n
	 *            the number to test
	 * @return the number of characters required to represent n in roman
	 *         numerals
	 */
	public static int minimalCharacters(int n)
	{
		int result = 0;
		for (int i = 1; i <= 3; i++)
		{
			result += MINIMAL_CHARACTERS[n % 10];
			n /= 10;
		}
		result += n;

		return result;
	}

	/**
	 * Converts a roman numeral to an int. Note that this does not enforce the
	 * requirements of roman numerals so technically invalid numbers could still
	 * be converted.
	 * 
	 * @param romanNumeral
	 *            The roman numeral to convert
	 * @return The int value that romanNumeral represents
	 */
	public static int convertRomanNumeral(String romanNumeral)
	{
		int result = 0;

		int previousValue = 0;
		for (int i = romanNumeral.length() - 1; i >= 0; i--)
		{
			int currentValue = VALUES.get(romanNumeral.charAt(i));
			result += (currentValue >= previousValue) ? currentValue
					: -currentValue;
			previousValue = currentValue;
		}
		return result;
	}
}