package mavery.projecteuler;

public class Problem14
{
	public static long[] chainLengths = new long[1000000];

	/**
	 * The following iterative sequence is defined for the set of positive
	 * longegers:
	 * 
	 * n -> n/2 (n is even)
	 * 
	 * n -> 3n + 1 (n is odd)
	 * 
	 * Using the rule above and starting with 13, we generate the following
	 * sequence: 13 40 20 10 5 16 8 4 2 1
	 * 
	 * It can be seen that this sequence (starting at 13 and finishing at 1)
	 * contains 10 terms. Although it has not been proved yet (Collatz Problem),
	 * it is thought that all starting numbers finish at 1.
	 * 
	 * Which starting number, under one million, produces the longest chain?
	 * 
	 * NOTE: Once the chain starts the terms are allowed to go above one
	 * million.
	 */
	public static void main(String[] args)
	{
		chainLengths[0] = 0;
		chainLengths[1] = 1;
		for (int i = 2; i < 1000000; i++)
		{
			chainLengths[i] = chainLength(i);
		}

		int result = 0;
		long maxLength = 0;
		for (int i = 0; i < 1000000; i++)
		{
			if (chainLengths[i] > maxLength)
			{
				result = i;
				maxLength = chainLengths[i];
			}
		}

		System.out.println(result);
	}

	public static long chainLength(long input)
	{
		if (input < 1000000 && chainLengths[(int) input] > 0)
		{
			return chainLengths[(int) input];
		}
		else if (input % 2 == 0)
		{
			return 1 + chainLength(input / 2);
		}
		else
		{
			return 1 + chainLength(input * 3 + 1);
		}
	}
}
