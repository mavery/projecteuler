package mavery.projecteuler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import mavery.projecteuler.util.FileUtils;

public class Problem98
{

	/**
	 * By replacing each of the letters in the word CARE with 1, 2, 9, and 6
	 * respectively, we form a square number: 1296 = 36^2. What is remarkable is
	 * that, by using the same digital substitutions, the anagram, RACE, also
	 * forms a square number: 9216 = 96^2. We shall call CARE (and RACE) a
	 * square anagram word pair and specify further that leading zeroes are not
	 * permitted, neither may a different letter have the same digital value as
	 * another letter.
	 * 
	 * Using words.txt (right click and 'Save Link/Target As...'), a 16K text
	 * file containing nearly two-thousand common English words, find all the
	 * square anagram word pairs (a palindromic word is NOT considered to be an
	 * anagram of itself).
	 * 
	 * What is the largest square number formed by any member of such a pair?
	 * 
	 * NOTE: All anagrams formed must be contained in the given text file.
	 */
	public static void main(String[] args) throws Exception
	{
		// read in all the words
		List<String> words = FileUtils.readLines("resources/Problem98.txt");

		// create lists of words which are anagrams
		Map<LetterCount, List<String>> anagrams = new HashMap<>();
		for (String word : words)
		{
			LetterCount count = new LetterCount(word);
			if (!anagrams.containsKey(count))
			{
				anagrams.put(count, new ArrayList<String>());
			}
			anagrams.get(count).add(word);
		}

		// remove any words which don't have anagrams
		List<List<String>> trueAnagrams = new ArrayList<>();
		for (List<String> current : anagrams.values())
		{
			if (current.size() >= 2)
			{
				trueAnagrams.add(current);
			}
		}

		// sort the anagrams by length. the longest ones will have the largest
		// squares.
		Collections.sort(trueAnagrams, new Comparator<List<String>>()
		{
			public int compare(List<String> l1, List<String> l2)
			{
				return l2.get(0).length() - l1.get(0).length();
			}
		});

		// starting from the longest, look for anagram pairs which are squares.
		int result = 0;
		for (List<String> currentAnagrams : trueAnagrams)
		{
			if (currentAnagrams.get(0).length() < Math.log10(result))
			{
				// stop when we reach anagrams that are shorter than our current
				// answer since any past this point will not improve on our
				// current result
				break;
			}
			for (int i = 0; i < currentAnagrams.size(); i++)
			{
				for (int j = i + 1; j < currentAnagrams.size(); j++)
				{
					result = Math.max(
							result,
							findSquaresForAnagrams(currentAnagrams.get(i),
									currentAnagrams.get(j)));
				}
			}
		}

		System.out.println(result);
	}

	/**
	 * Finds the largest possible square number than can be formed with the two
	 * anagrams
	 * 
	 * @param s1
	 *            First word
	 * @param s2
	 *            Second word, anagram of s1
	 * @return The largest possible square, or 0 if none found.
	 */
	public static int findSquaresForAnagrams(String s1, String s2)
	{
		// first calculate all the squares
		Set<Integer> squares = new HashSet<Integer>();

		int startValue = (int) Math.pow(10, s1.length() - 1);
		int endValue = startValue * 10;
		for (int i = (int) Math.sqrt(startValue); (i * i) < endValue; i++)
		{
			if (i * i > startValue)
			{
				squares.add(i * i);
			}
		}

		// now try each square as a replacement for s1, map it to s2 and then
		// see if the result is also a square
		int result = 0;
		for (int i1 : squares)
		{
			int i1temp = i1;
			int i2 = 0;
			boolean valid = true;
			Set<Integer> usedDigits = new HashSet<>();
			Set<Character> usedChars = new HashSet<>();

			for (int j = s1.length() - 1; j >= 0; j--)
			{
				char c = s1.charAt(j);
				if (usedChars.contains(c))
				{
					// we've already dealt with this character
					continue;
				}
				usedChars.add(c);

				int digit = i1temp % 10;
				if (usedDigits.contains(digit))
				{
					// same digit can't be used more than once
					valid = false;
					break;
				}
				usedDigits.add(digit);
				i1temp /= 10;

				for (int k = s2.length() - 1; k >= 0; k--)
				{
					if (s2.charAt(k) == c)
					{
						i2 += digit;
					}
					digit *= 10;
				}
			}

			if (valid && squares.contains(i2))
			{
				result = Math.max(result, i1);
				result = Math.max(result, i2);
			}
		}

		return result;
	}

	/**
	 * Stores a count of the letters in a string
	 * @author mavery
	 *
	 */
	static class LetterCount
	{
		private int[] counts;

		private static final int NUM_LETTERS = 'Z' - 'A' + 1;

		LetterCount(CharSequence s)
		{
			counts = new int[NUM_LETTERS];
			for (int i = 0; i < s.length(); i++)
			{
				char current = s.charAt(i);
				if (current >= 'a' && current <= 'z')
				{
					counts[current - 'a']++;
				}
				if (current >= 'A' && current <= 'Z')
				{
					counts[current - 'A']++;
				}
			}
		}

		@Override
		public boolean equals(Object o)
		{
			if (this == o)
			{
				return true;
			}
			if (!(o instanceof LetterCount))
			{
				return false;
			}
			LetterCount other = (LetterCount) o;
			for (int i = 0; i < counts.length; i++)
			{
				if (this.counts[i] != other.counts[i])
				{
					return false;
				}
			}
			return true;
		}

		@Override
		public int hashCode()
		{
			int result = 0;
			for (int i = 0; i < counts.length; i++)
			{
				result = result * 23 + counts[i];
			}
			return result;
		}
	}
}
