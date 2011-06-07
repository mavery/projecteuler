package mavery.projecteuler;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Problem203
{
	
	public static final int LINES = 51;

	/**
	 * The binomial coefficients nCk can be arranged in triangular form,
	 * Pascal's triangle, like this:
	 * 
	 * .........
	 * 
	 * It can be seen that the first eight rows of Pascal's triangle contain
	 * twelve distinct numbers: 1, 2, 3, 4, 5, 6, 7, 10, 15, 20, 21 and 35.
	 * 
	 * A positive integer n is called squarefree if no square of a prime divides
	 * n. Of the twelve distinct numbers in the first eight rows of Pascal's
	 * triangle, all except 4 and 20 are squarefree. The sum of the distinct
	 * squarefree numbers in the first eight rows is 105.
	 * 
	 * Find the sum of the distinct squarefree numbers in the first 51 rows of
	 * Pascal's triangle.
	 */
	public static void main(String[] args)
	{
		int[][] factors = getFactorialFactors(LINES);
		BigInteger[] values = getFactorialValues(LINES);
		
		Set<BigInteger> squareFreeNumbers = new HashSet<BigInteger>();
		
		for (int i = 0; i < LINES; i++)
		{
			for (int j = 1; j <= i; j++)
			{
				boolean isSquareFree = true;
				for (int k = 0; isSquareFree && k <= i; k++)
				{
					if (factors[i][k] - factors[i - j][k] - factors[j][k] >= 2)
					{
						isSquareFree = false;
					}
				}
				
				if (isSquareFree)
				{
					squareFreeNumbers.add(values[i].divide((values[i - j].multiply(values[j]))));
				}
			}
		}
		
		BigInteger result = BigInteger.ZERO;
		for (BigInteger i : squareFreeNumbers)
		{
			result = result.add(i);
		}
		
		System.out.println(result);
	}

	/**
	 * Returns an array representing the factors of each factorial number
	 */
	private static int[][] getFactorialFactors(int limit)
	{
		int[][] result = new int[limit][limit];

		for (int i = 2; i < limit; i++)
		{
			// factors of i! equal factors of (i-1)! plus factors of i
			for (int j = 0; j < limit; j++)
			{
				result[i][j] = result[i - 1][j];
			}
			
			int current = i;
			for (int j = 2; j <= current; /* no increment */)
			{
				if (current % j == 0)
				{
					result[i][j]++;
					current /= j;
				}
				else
				{
					j++;
				}
			}
		}

		return result;
	}
	
	/**
	 * Returns an array containing the value of each factorial
	 */
	private static BigInteger[] getFactorialValues(int limit)
	{
		BigInteger[] result = new BigInteger[limit];
		
		result[0] = BigInteger.ONE;
		result[1] = BigInteger.ONE;
		for (int i = 2; i < limit; i++)
		{
			result[i] = result[i - 1].multiply(BigInteger.valueOf(i));
		}
		return result;
	}
}
