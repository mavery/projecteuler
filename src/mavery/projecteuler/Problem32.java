package mavery.projecteuler;

import java.util.HashSet;
import java.util.Set;

public class Problem32
{

	/**
	 * We shall say that an n-digit number is pandigital if it makes use of all
	 * the digits 1 to n exactly once; for example, the 5-digit number, 15234,
	 * is 1 through 5 pandigital.
	 * 
	 * The product 7254 is unusual, as the identity, 39 186 = 7254, containing
	 * multiplicand, multiplier, and product is 1 through 9 pandigital.
	 * 
	 * Find the sum of all products whose multiplicand/multiplier/product
	 * identity can be written as a 1 through 9 pandigital.
	 * 
	 * HINT: Some products can be obtained in more than one way so be sure to
	 * only include it once in your sum.
	 */
	public static void main(String[] args)
	{
		Set<Integer> products = new HashSet<Integer>();
		
		for (int fd1 = 1; fd1 <= 9; fd1++)
		{
			for (int fd2 = 1; fd2 <= 9; fd2++)
			{
				int fdRes = (fd1 * fd2) % 10;
				if (fdRes != 0 && fdRes != fd1 && fdRes != fd2 && fd1 != fd2)
				{
					findPandigitalProducts(fd1, fd2, fdRes, products);
				}
			}
		}

		long result = 0;
		for (long l : products)
		{
			result += l;
		}
		System.out.println(result);
	}

	/**
	 * 
	 * @param fd1
	 *            The final digit of the first multiplicand
	 * @param fd2
	 *            The final digit of the second multiplicand
	 * @param fdRes
	 *            The final digit of the result
	 * @param products
	 *            The set of valid results
	 */
	public static void findPandigitalProducts(int fd1, int fd2, int fdRes, Set<Integer> products)
	{
		// Result has 9 digits, it could be composed like so (2 digit * 3 digit = 4 digit)
		
		// compose first multiplicand
		for (int i = 1; i <= 9; i++)
		{
			if (i != fd1 && i != fd2 && i != fdRes)
			{
				// we have a valid one so far.
				Set<Integer> firstDigits = new HashSet<Integer>();
				firstDigits.add(i);
				firstDigits.add(fd1);
				int first = i * 10 + fd1;
				
				// next we get the second numbers
				for (int j = 1; j <= 9; j++)
				{
					if (j != fd2 && j != fdRes && !firstDigits.contains(j))
					{
						for (int k = 1; k <= 9; k++)
						{
							if (k != j && k != fd2 && k != fdRes && !firstDigits.contains(k))
							{
								// we have a valid second number
								Set<Integer> secondDigits = new HashSet<Integer>();
								secondDigits.add(j);
								secondDigits.add(k);
								secondDigits.add(fd2);
								int second = j * 100 + k * 10 + fd2;
								
								// now we look to see if we have a valid number
								if (testPandigital(firstDigits, secondDigits, first * second))
								{
									products.add(first * second);
									System.out.println(first + " * " + second + " = " + (first * second));
								}
							}
						}						
					}
				}
			}
		}
		
		// Could also be composed as (1 digit * 4 digit = 4 digit)
		
		Set<Integer> firstDigits = new HashSet<Integer>();
		firstDigits.add(fd1);
		for (int i = 1; i <= 9; i++)
		{
			if (i != fd1 && i != fd2 && i != fdRes)
			{
				for (int j = 1; j <= 9; j++)
				{
					if (j != i && j != fd1 && j != fd2 && j != fdRes)
					{
						for (int k = 1; k <= 9; k++)
						{
							if (k != i && k != j && k != fd1 && k != fd2 && k != fdRes)
							{
								Set<Integer> secondDigits = new HashSet<Integer>();
								secondDigits.add(i);
								secondDigits.add(j);
								secondDigits.add(k);
								secondDigits.add(fd2);
								int second = 1000 * i + 100 * j + 10 * k + fd2;
								
								if (testPandigital(firstDigits, secondDigits, fd1 * second))
								{
									products.add(fd1 * second);
									System.out.println(fd1 + " * " + second + " = " + (fd1 * second));
								}								
							}
						}
					}
				}
			}
		}
	}
	
	public static boolean testPandigital(Set<Integer> a, Set<Integer> b, int rest)
	{
		Set<Integer> resDigits = new HashSet<Integer>();
		while (rest != 0)
		{
			int lastDigit = rest % 10;
			if (lastDigit == 0 || a.contains(lastDigit) || b.contains(lastDigit) || resDigits.contains(lastDigit))
			{
				return false;
			}
			resDigits.add(lastDigit);
			rest /= 10;
		}
		
		return true;
	}
	
}
