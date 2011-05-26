package mavery.projecteuler;

public class Problem31
{
	public static final int AMOUNT = 200;
	
	public static final int[] DEMONINATIONS = {1, 2, 5, 10, 20, 50, 100, 200};
	
	public static final int[][] RESULTS = new int[AMOUNT + 1][DEMONINATIONS.length + 1];

	/**
	 * In England the currency is made up of pound, £, and pence, p, and there
	 * are eight coins in general circulation: 1p, 2p, 5p, 10p, 20p, 50p, £1
	 * (100p) and £2 (200p).
	 * 
	 * It is possible to make £2 in the following way: 1*£1 + 1*50p + 2*20p + 1*5p +
	 * 1*2p + 3*1p
	 * 
	 * How many different ways can £2 be made using any number of coins?
	 */
	public static void main(String[] args)
	{
		System.out.println(combinations(AMOUNT, DEMONINATIONS.length - 1));
	}
	
	public static final int combinations(int amount, int maxDenomIndex)
	{
		
		if (amount < 0)
		{
			return 0;
		}
		if (amount == 0)
		{
			return 1;
		}
		
		if (RESULTS[amount][maxDenomIndex] != 0)
		{
			return RESULTS[amount][maxDenomIndex];
		}
		
		int result = 0;
		
		for (int i = maxDenomIndex; i >= 0; i--)
		{
			result += combinations(amount - DEMONINATIONS[i], i);
		}
		
		RESULTS[amount][maxDenomIndex] = result;
		return result;
	}

}
