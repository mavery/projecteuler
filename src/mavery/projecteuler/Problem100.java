package mavery.projecteuler;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class Problem100
{
	public static final BigDecimal MINIMUM = BigDecimal.valueOf(1_000_000_000_000L);

	private static final BigDecimal ROOT_2 = BigDecimal.valueOf(Math.sqrt(2.0));

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
		for (int i = 1; true; i++)
		{
			BigDecimal b = b(i);
			BigDecimal r = r(i);
			System.out.printf("Blue = %s, Red = %s\n", b, r);
			if (b.add(r).compareTo(MINIMUM) > 0)
			{
				return;
			}
		}
	}

	public static BigDecimal b(int n)
	{
		BigDecimal result = BigDecimal.ZERO;
		result = result.add(BigDecimal.valueOf(2).multiply(BigDecimal.valueOf(3).subtract(BigDecimal.valueOf(2).multiply(ROOT_2)).pow(n)));
		result = result.add(ROOT_2.multiply(BigDecimal.valueOf(3).subtract(BigDecimal.valueOf(2).multiply(ROOT_2)).pow(n)));
		result = result.add(BigDecimal.valueOf(2).multiply(BigDecimal.valueOf(3).add(BigDecimal.valueOf(2).multiply(ROOT_2)).pow(n)));
		result = result.subtract(ROOT_2.multiply(BigDecimal.valueOf(3).add(BigDecimal.valueOf(2).multiply(ROOT_2)).pow(n)));
		result = result.add(BigDecimal.valueOf(4));
		result = result.divide(BigDecimal.valueOf(8));
		return result.setScale(0, RoundingMode.HALF_UP);
	}

	public static BigDecimal r(int n)
	{
		BigDecimal result = BigDecimal.ZERO;
		result = result.subtract(BigDecimal.valueOf(4).multiply(BigDecimal.valueOf(3).subtract(BigDecimal.valueOf(2).multiply(ROOT_2)).pow(n)));
		result = result.subtract(BigDecimal.valueOf(3).multiply(ROOT_2).multiply(BigDecimal.valueOf(3).subtract(BigDecimal.valueOf(2).multiply(ROOT_2)).pow(n)));
		result = result.subtract(BigDecimal.valueOf(4).multiply(BigDecimal.valueOf(3).add(BigDecimal.valueOf(2).multiply(ROOT_2)).pow(n)));
		result = result.add(BigDecimal.valueOf(3).multiply(ROOT_2).multiply(BigDecimal.valueOf(3).add(BigDecimal.valueOf(2).multiply(ROOT_2)).pow(n)));
		result = result.divide(BigDecimal.valueOf(8));
		return result.setScale(0, RoundingMode.HALF_UP);
	}
}
