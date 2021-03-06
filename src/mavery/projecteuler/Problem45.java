package mavery.projecteuler;

public class Problem45
{

	/**
	 * Triangle, pentagonal, and hexagonal numbers are generated by the
	 * following formulae:
	 * 
	 * Triangle Tn=n(n+1)/2 1, 3, 6, 10, 15, ... 
	 * 
	 * Pentagonal Pn=n(3n-1)/2 1, 5, 12, 22, 35, ... 
	 * 
	 * Hexagonal Hn=n(2n-1) 1, 6, 15, 28, 45, ...
	 * 
	 * 
	 * It can be verified that T285 = P165 = H143 = 40755.
	 * 
	 * Find the next triangle number that is also pentagonal and hexagonal.
	 */
	public static void main(String[] args)
	{
		for (int i = 144; true; i++)
		{
			long current = getHexagonal(i);
			if (isPentagonal(current) && isTriangular(current))
			{
				System.out.println(current);
				return;
			}
		}

	}
	
	public static boolean isTriangular(long l)
	{
		double n = (Math.sqrt(8 * l + 1) - 1) / 2;
		long roundedN = Math.round(n);
		
		return (l == roundedN * (roundedN + 1) / 2);
	}

	public static boolean isPentagonal(long l)
	{
		double n = (Math.sqrt(24 * l + 1) + 1) / 6;
		long roundedN = Math.round(n);
		
		return (l == roundedN * (3 * roundedN - 1) / 2);
	}
	
	public static long getHexagonal(int n)
	{
		return (long) n * (((long) n * 2L) - 1);
	}

}
