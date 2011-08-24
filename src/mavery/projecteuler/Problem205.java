package mavery.projecteuler;

import java.math.BigInteger;

public class Problem205
{
	
	private static BigInteger[] factorials = new BigInteger[37];
	
	static
	{
		// precompute factorials
		factorials[0] = BigInteger.ONE;
		for (int i = 1; i < factorials.length; i++)
		{
			factorials[i] = factorials[i - 1].multiply(BigInteger.valueOf(i));
		}		
	}

	/**
	 * Peter has nine four-sided (pyramidal) dice, each with faces numbered 1,
	 * 2, 3, 4. Colin has six six-sided (cubic) dice, each with faces numbered
	 * 1, 2, 3, 4, 5, 6.
	 * 
	 * Peter and Colin roll their dice and compare totals: the highest total
	 * wins. The result is a draw if the totals are equal.
	 * 
	 * What is the probability that Pyramidal Pete beats Cubic Colin? Give your
	 * answer rounded to seven decimal places in the form 0.abcdefg
	 */
	public static void main(String[] args)
	{
		double[] py = new double[37];
		for (int i = 9; i <= 36; i++)
		{
			py[i] = probability(i, 9, 4);
		}
		
		double[] cu = new double[37];
		for (int i = 6; i <= 36; i++)
		{
			cu[i] = probability(i, 6, 6);
		}
		
		double result = 0.0;
		for (int i = 0; i <= 36; i++)
		{
			for (int j = 0; j < i; j++)
			{
				result += py[i] * cu[j];
			}
		}

		System.out.printf("%.7f", result);
		
	}

	/**
	 * Calculates the probability of rolling a certain number with a given
	 * number of dice.
	 * 
	 * @see <a href="http://mathworld.wolfram.com/Dice.html">Dice probabilities
	 *      at MathWorld</a>
	 * @param p
	 *            points
	 * @param n
	 *            number of dice
	 * @param s
	 *            sides of dice
	 * @return the probability of rolling 'p' with n s-sided dice.
	 */
	public static double probability(int p, int n, int s)
	{
		double result = 0.0;
		for (int k = 0; k <= (p - n) / s; k++)
		{
			result += (k % 2 == 0 ? 1.0 : -1.0) * nCr(n, k)
					* nCr(p - s * k - 1, n - 1);
		}
		result /= Math.pow(s, n);
		return result;
	}

	/**
	 * Calculates nCr
	 */
	private static int nCr(int n, int r)
	{
		return (factorials[n].divide(factorials[r].multiply(factorials[n - r]))).intValue();
	}
}