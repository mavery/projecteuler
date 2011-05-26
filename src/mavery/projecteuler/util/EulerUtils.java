package mavery.projecteuler.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EulerUtils
{
	/**
	 * Utility class, should not be instanciated.
	 */
	private EulerUtils()
	{

	}

	/**
	 * Tests if input is prime. See also: PrimeNumberSieve
	 * 
	 * @param input
	 * @return true if input is prime
	 */
	public static boolean isPrime(long input)
	{
		long limit = (long) Math.sqrt(input);
		for (long l = 2; l <= limit; l++)
		{
			if (input % l == 0)
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @param input
	 * @return sum of the digits in input
	 */
	public static int sumDigits(BigInteger input)
	{
		int result = 0;

		String strInput = input.toString();
		for (int i = 0; i < strInput.length(); i++)
		{
			result += strInput.charAt(i) - '0';
		}
		return result;
	}

	/**
	 * @param input
	 * @return the sum of the proper divisors of input (i.e. positive integer
	 *         divisors < input)
	 */
	public static int sumOfProperDivisors(int input)
	{
		int result = 0;
		for (int i = 1; i < input; i++)
		{
			if (input % i == 0)
			{
				result += i;
			}
		}
		return result;
	}

	/**
	 * Returns the greatest common divisor of a and b using Euclid's method
	 * 
	 * @param a
	 * @param b
	 * @return The greatest common divisor or a and b
	 */
	public static int gcd(int a, int b)
	{
		// Failure case
		if (a <= 0 || b <= 0)
		{
			throw new IllegalArgumentException(
					"gcd() requires positive arguments");
		}

		while (true)
		{
			// let a be the larger of the two numbers
			if (a < b)
			{
				int temp = a;
				a = b;
				b = temp;
			}

			int remainder = a % b;
			if (remainder == 0)
			{
				return b;
			}
			else
			{
				a = remainder;
			}
		}
	}

	/**
	 * Returns true if s is a palindrome. s must not be null.
	 * 
	 * @param s
	 *            The string to check
	 * @return true if palindrome, false otherwise
	 */
	public static boolean isPalindrome(String s)
	{
		int endIndex = s.length() - 1;
		for (int i = 0; i <= (endIndex / 2); i++)
		{
			if (s.charAt(i) != s.charAt(endIndex - i))
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * Builds all possible combinations of string composed of the contents of
	 * characters and with size <= length.
	 * 
	 * @param characters
	 * @param length
	 * @return
	 */
	public static List<String> buildCombinations(String characters,
			int minLength, int maxLength)
	{
		List<String> result = new ArrayList<String>();

		addCombinations(result, characters, new StringBuilder(""), minLength,
				maxLength);

		return result;
	}

	private static void addCombinations(List<String> result, String characters,
			StringBuilder start, int minLength, int remainingLength)
	{

		if (minLength <= 0)
		{
			result.add(start.toString());
		}
		if (remainingLength <= 0)
		{
			return;
		}

		for (int i = 0; i < characters.length(); i++)
		{
			start.append(characters.charAt(i));
			addCombinations(result, characters, start, minLength - 1,
					remainingLength - 1);
			start.deleteCharAt(start.length() - 1);
		}
	}

	/**
	 * Returns true is s is pandigital, i.e. it contains all digits from 1-9
	 * exactly once
	 * 
	 * @param s
	 *            string to test.
	 * @return true if s is pandigital, false otherwise
	 */
	public static boolean isPandigital(String s)
	{
		if (s.length() != 9)
		{
			return false;
		}

		// this will be initialised to 'false'
		boolean[] hasDigit = new boolean[9];

		for (int i = 0; i < s.length(); i++)
		{
			int index = s.charAt(i) - '1';
			if (index < 0 || index > 8 || hasDigit[index])
			{
				return false;
			}
			hasDigit[index] = true;
		}

		return true;

	}

	/**
	 * permutes input lexiographically, returns true if a permutation occured.
	 * @param input
	 */
	public static boolean increment(int[] input)
	{
		boolean swapped = false;

		int i, j = 0;
		for (int k = input.length - 2; k >= 0; k--)
		{
			for (i = input.length - 1; i > k && !swapped; i--)
			{
				for (j = i - 1; j >= k && !swapped; j--)
				{
					if (input[i] > input[j])
					{
						swap(input, i, j);
						swapped = true;
					}
				}
			}
		}

		if (swapped)
		{
			Arrays.sort(input, j + 2, input.length);
		}
		return swapped;
	}

	private static void swap(int[] input, int index1, int index2)
	{
		int temp = input[index2];
		input[index2] = input[index1];
		input[index1] = temp;
	}
	
}
