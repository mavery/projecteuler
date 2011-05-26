package mavery.projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;

public class Problem13
{

	/**
	 * Work out the first ten digits of the sum of the following one-hundred
	 * 50-digit numbers.
	 * 
	 * See Problem13.txt
	 */
	public static void main(String[] args) throws Exception
	{
		BigInteger result = new BigInteger("0");

		BufferedReader inputFile = new BufferedReader(new FileReader(
				"resources/Problem13.txt"));

		for (BigInteger nextInt = nextInt(inputFile); nextInt != null; nextInt = nextInt(inputFile))
		{
			result = result.add(nextInt);
		}

		System.out.println(result.toString().substring(0, 10));

	}

	public static BigInteger nextInt(BufferedReader in) throws Exception
	{
		if (in.ready())
		{
			return new BigInteger(in.readLine());
		}
		else
		{
			return null;
		}
	}

}
