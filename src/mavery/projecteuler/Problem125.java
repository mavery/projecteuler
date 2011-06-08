package mavery.projecteuler;

import java.util.HashSet;
import java.util.Set;

import mavery.projecteuler.util.EulerUtils;

public class Problem125
{
	public static final int LIMIT = 100000000;

	/**
	 * The palindromic number 595 is interesting because it can be written as
	 * the sum of consecutive squares: 6^2 + 7^2 + 8^2 + 9^2 + 10^2 + 11^2 +
	 * 12^2.
	 * 
	 * There are exactly eleven palindromes below one-thousand that can be
	 * written as consecutive square sums, and the sum of these palindromes is
	 * 4164. Note that 1 = 0^2 + 1^2 has not been included as this problem is
	 * concerned with the squares of positive integers.
	 * 
	 * Find the sum of all the numbers less than 10^8 that are both palindromic
	 * and can be written as the sum of consecutive squares.
	 */
	public static void main(String[] args)
	{
		int[] squares = new int[(int) Math.sqrt(LIMIT)];
		for (int i = 0; i < squares.length; i++)
		{
			squares[i] = (i + 1) * (i + 1);
		}

		Set<Integer> palindromes = new HashSet<Integer>();

		for (int i = 2; i < squares.length; i++)
		{
			int sum = 0;
			for (int j = 0; j < i; j++)
			{
				sum += squares[j];
			}
			if (sum >= LIMIT)
			{
				break;
			}

			int j = i;
			do
			{
				if (EulerUtils.isPalindrome(Integer.toString(sum)))
				{
					palindromes.add(sum);
				}
				sum = sum + squares[j] - squares[j - i];
				j++;
			}
			while (sum < LIMIT && j < squares.length);
		}
		
		long result = 0;
		for (int n : palindromes)
		{
			result += n;
		}
		System.out.println(result);
	}
}
