package mavery.projecteuler;

import mavery.projecteuler.util.EulerUtils;

public class Problem116
{

	/**
	 * A row of five black square tiles is to have a number of its tiles
	 * replaced with coloured oblong tiles chosen from red (length two), green
	 * (length three), or blue (length four).
	 * 
	 * If red tiles are chosen there are exactly seven ways this can be done.
	 * 
	 * If green tiles are chosen there are three ways.
	 * 
	 * And if blue tiles are chosen there are two ways.
	 * 
	 * Assuming that colours cannot be mixed there are 7 + 3 + 2 = 12 ways of
	 * replacing the black tiles in a row measuring five units in length.
	 * 
	 * How many different ways can the black tiles in a row measuring fifty
	 * units in length be replaced if colours cannot be mixed and at least one
	 * coloured tile must be used?
	 */
	public static void main(String[] args)
	{
		// -3 because we are to ignore cases composed only of one square tiles
		System.out.println(EulerUtils.tilePatterns(50, 1, 2)
				+ EulerUtils.tilePatterns(50, 1, 3)
				+ EulerUtils.tilePatterns(50, 1, 4) - 3);
	}

}
