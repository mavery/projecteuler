package mavery.projecteuler;

import java.math.BigInteger;

public class Problem100
{
	public static final long MINIMUM = 100_000_000_000L;

	/**
	 * If a box contains twenty-one coloured discs, composed of fifteen blue
	 * discs and six red discs, and two discs were taken at random, it can be
	 * seen that the probability of taking two blue discs, P(BB) =
	 * (15/21)(14/20) = 1/2.
	 * 
	 * The next such arrangement, for which there is exactly 50% chance of
	 * taking two blue discs at random, is a box containing eighty-five blue
	 * discs and thirty-five red discs.
	 * 
	 * By finding the first arrangement to contain over 1012 = 1,000,000,000,000
	 * discs in total, determine the number of blue discs that the box would
	 * contain.
	 */
	public static void main(String[] args)
	{
		double root2 = Math.sqrt(2);
		
		for (long sum = MINIMUM; ; sum++)
		{
			BigInteger blue = BigInteger.valueOf(((long) (sum / root2)) + 1);
			BigInteger sumBig = BigInteger.valueOf(sum);
		
			BigInteger numerator = blue.multiply(blue.subtract(BigInteger.ONE));
			BigInteger denominator = sumBig.multiply(sumBig.subtract(BigInteger.ONE));
			
			if (numerator.shiftLeft(1).equals(denominator))
			{
				System.out.println(blue);
			}
		}
	}
}
