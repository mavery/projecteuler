package mavery.projecteuler;

import java.util.Arrays;

public class Problem24
{

	/**
	 * A permutation is an ordered arrangement of objects. For example, 3124 is
	 * one possible permutation of the digits 1, 2, 3 and 4. If all of the
	 * permutations are listed numerically or alphabetically, we call it
	 * lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
	 * 
	 * 012 021 102 120 201 210
	 * 
	 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3,
	 * 4, 5, 6, 7, 8 and 9?
	 */
	public static void main(String[] args)
	{
		char[] result = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

		for (int i = 1; i < 1000000; i++)
		{
			increment(result);
		}

		System.out.println(result);
	}

	public static void increment(char[] input)
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

		Arrays.sort(input, j + 2, input.length);
	}

	public static void swap(char[] input, int index1, int index2)
	{
		char temp = input[index2];
		input[index2] = input[index1];
		input[index1] = temp;
	}

}
