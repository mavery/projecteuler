package mavery.projecteuler.util;

/**
 * A class to represent an immutable fraction. Class is final to prevent
 * creating subclasses which could break immutability.
 * 
 * @author mavery
 * 
 */
public final class Fraction
{
	/** Numerator */
	private final int num;

	/** Denominator */
	private final int den;

	/** A precomputed reduced fraction */
	private Fraction reduced;

	/**
	 * Creates a fraction
	 * 
	 * @param num
	 *            numerator
	 * @param den
	 *            denominator
	 */
	public Fraction(int num, int den)
	{
		this.num = num;
		this.den = den;
	}

	/**
	 * Returns a string representation of a fraction
	 */
	public String toString()
	{
		return num + "/" + den;
	}

	/**
	 * Returns the numerator
	 * 
	 * @return numerator
	 */
	public int getNum()
	{
		return num;
	}

	/**
	 * Returns the denominator
	 * 
	 * @return denominator
	 */
	public int getDen()
	{
		return den;
	}

	/**
	 * Returns the current fraction reduced to its lowest common terms
	 * 
	 * @return
	 */
	public Fraction reduce()
	{
		if (reduced == null)
		{
			if (num == 0 || den == 0)
			{
				reduced = this;
			}
			else
			{
				int gcd = EulerUtils.gcd(Math.abs(num), Math.abs(den));

				if (den < 0)
				{
					reduced = new Fraction(-num / gcd, -den / gcd);
				}
				else
				{
					reduced = new Fraction(num / gcd, den / gcd);
				}
			}
		}
		return reduced;
	}

	/**
	 * Returns true if the two objects are equal. Note that two fractions that
	 * represent the same number, eg. 1/2 and 2/4, are considered equal.
	 */
	@Override
	public boolean equals(Object o)
	{
		if (o == null || !(o instanceof Fraction))
		{
			return false;
		}
		Fraction f1 = this.reduce();
		Fraction f2 = ((Fraction) o).reduce();
		return (f1.num == f2.num) && (f1.den == f2.den);
	}

	/**
	 * Returns a hashcode for the fraction.
	 */
	@Override
	public int hashCode()
	{
		Fraction reduced = reduce();
		return reduced.num ^ reduced.den;
	}

	/**
	 * Returns this * f. Result is not reduced at all. Beware, could overflow
	 * 
	 * @param f
	 *            Fraction, not null
	 * @return. New fraction which is equal to this * f.
	 */
	public Fraction multiply(Fraction f)
	{
		return new Fraction(this.num * f.num, this.den * f.den);
	}
}
