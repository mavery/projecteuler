package mavery.projecteuler;

public class Problem100
{
	public static final long MINIMUM = 1_000_000_000_000L;

	private static final double ROOT_2 = Math.sqrt(2.0);

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
		long b = 0;
		long r = 0;
		for (int i = 1; b + r <= MINIMUM; i++)
		{
			b = b(i);
			r = r(i);
			System.out.printf("Blue = %d, Red = %d\n", b, r);
		}
	}

	/**
	 * Number of blue coins. 
	 * 
	 * @see <a href=
	 * "http://www.wolframalpha.com/input/?i=2b%28b-1%29+%3D+%28b%2Br%29%28b%2Br-1%29"
	 * >WolframAlpha</a> for algorithm details.
	 */
	public static long b(int n)
	{
		double result = 0.0;
		result += 2 * Math.pow(3.0 - 2.0 * ROOT_2, n);
		result += ROOT_2 * Math.pow(3.0 - 2.0 * ROOT_2, n);
		result += 2 * Math.pow(3.0 + 2.0 * ROOT_2, n);
		result -= ROOT_2 * Math.pow(3.0 + 2.0 * ROOT_2, n);
		result += 4.0;
		result /= 8.0;
		return Math.round(result);
	}

	/**
	 * Number of red coins.
	 * 
	 * @see <a href=
	 * "http://www.wolframalpha.com/input/?i=2b%28b-1%29+%3D+%28b%2Br%29%28b%2Br-1%29"
	 * >WolframAlpha</a> for algorithm details.
	 */
	public static long r(int n)
	{
		double result = 0.0;
		result -= 4 * Math.pow(3.0 - 2.0 * ROOT_2, n);
		result -= 3.0 * ROOT_2 * Math.pow(3.0 - 2.0 * ROOT_2, n);
		result -= 4 * Math.pow(3.0 + 2.0 * ROOT_2, n);
		result += 3.0 * ROOT_2 * Math.pow(3.0 + 2.0 * ROOT_2, n);
		result /= 8.0;
		return Math.round(result);
	}
}
