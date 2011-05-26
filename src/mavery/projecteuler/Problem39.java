package mavery.projecteuler;

public class Problem39
{

	public static final int LIMIT = 1000;

	/**
	 * If p is the perimeter of a right angle triangle with integral length
	 * sides, {a,b,c}, there are exactly three solutions for p = 120.
	 * 
	 * {20,48,52}, {24,45,51}, {30,40,50}
	 * 
	 * For which value of p <= 1000, is the number of solutions maximised?
	 */
	public static void main(String[] args)
	{
		int result = 0;
		int resultCount = 0;
				
		for (int p = 1; p <= LIMIT; p++)
		{
			int currentResultCount = 0;
			int maxA = p / 2;
			for (int a = 1; a < maxA; a++)
			{
				int b = (int) Math.round(getB(a, p));
				int c = p - a - b;
				if (isPythagorean(a, b, c))
				{
					currentResultCount++;
				}
			}
			if (currentResultCount > resultCount)
			{
				result = p;
				resultCount = currentResultCount;
			}
		}
		
		System.out.println(result);
	}

	/**
	 * finds the length of the other short side of a right angled triangle given
	 * one side and the total perimeter.
	 */
	public static double getB(double a, double p)
	{
		return (p * Math.sqrt((4 * a * a) - (4 * a * p) + (p * p)))
				/ Math.sqrt(4 * a * a - 8 * a * p + 4 * p * p);
	}
	
	/**
	 * Returns true if a^2 + b^2 = c^2
	 */
	public static boolean isPythagorean(int a, int b, int c)
	{
		return (a * a) + (b * b) == (c * c);
	}

}
