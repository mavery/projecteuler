package mavery.projecteuler;

import mavery.projecteuler.util.EulerUtils;

public class Problem117
{

	/**
	 * Using a combination of black square tiles and oblong tiles chosen from:
	 * red tiles measuring two units, green tiles measuring three units, and
	 * blue tiles measuring four units, it is possible to tile a row measuring
	 * five units in length in exactly fifteen different ways.
	 * 
	 * How many ways can a row measuring fifty units in length be tiled?
	 */
	public static void main(String[] args)
	{
		System.out.println(EulerUtils.tilePatterns(50, 1, 2, 3, 4));
	}
}
