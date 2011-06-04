package mavery.projecteuler.util;

import java.math.BigInteger;

/**
 * A class to represent an immutable fraction. Class is final to prevent
 * creating subclasses which could break immutability.
 * 
 * @author mavery
 * 
 */
public final class Fraction
{
	/**
	 * The fraction 1/1
	 */
	public static final Fraction ONE = new Fraction(1, 1);

	/** Numerator */
	private final BigInteger num;

	/** Denominator */
	private final BigInteger den;

	/** A precomputed reduced fraction */
	private Fraction reduced;

	/**
	 * Creates a fraction
	 * 
	 * @param num
	 *            numerator
	 * @param den
	 *            denominator, must be non-zero
	 */
	public Fraction(long num, long den)
	{
		if (den == 0)
		{
			throw new IllegalArgumentException(
					"Cannot create fraction with denominator of 0");
		}
		this.num = BigInteger.valueOf(num);
		this.den = BigInteger.valueOf(den);
	}

	/**
	 * Creates a fraction
	 * 
	 * @param num
	 *            numerator
	 * @param den
	 *            denominator, must be non-zero
	 */
	public Fraction(BigInteger num, BigInteger den)
	{
		if (den.equals(BigInteger.ZERO))
		{
			throw new IllegalArgumentException(
					"Cannot create fraction with denominator of 0");
		}
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
	public BigInteger getNum()
	{
		return num;
	}

	/**
	 * Returns the denominator
	 * 
	 * @return denominator
	 */
	public BigInteger getDen()
	{
		return den;
	}

	/**
	 * Returns the int value of the numerator using BigInteger.intValue()
	 * 
	 * @return getNum().intValue()
	 */
	public int getIntNum()
	{
		return num.intValue();
	}

	/**
	 * Returns the int value of the denominator using BigInteger.intValue()
	 * 
	 * @return getDen().intValue()
	 */
	public int getIntDen()
	{
		return den.intValue();
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
			if (num.equals(BigInteger.ZERO))
			{
				reduced = this;
			}
			else
			{
				BigInteger gcd = num.gcd(den);

				if (den.compareTo(BigInteger.ZERO) < 0)
				{
					reduced = new Fraction(num.divide(gcd).negate(), den
							.divide(gcd).negate());
				}
				else
				{
					reduced = new Fraction(num.divide(gcd), den.divide(gcd));
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
		return f1.num.equals(f2.num) && f1.den.equals(f2.den);
	}

	/**
	 * Returns a hashcode for the fraction.
	 */
	@Override
	public int hashCode()
	{
		Fraction reduced = reduce();
		return reduced.num.hashCode() ^ reduced.den.hashCode();
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
		return new Fraction(this.num.multiply(f.num), this.den.multiply(f.den));
	}

	/**
	 * Returns the reciprocal of this fraction
	 * 
	 * @return The reciprocal of this fraction
	 */
	public Fraction reciprocal()
	{
		return new Fraction(den, num);
	}

	/**
	 * Returns a fraction whose value is (this + other). The result is not
	 * reduced.
	 * 
	 * @param other
	 *            the fraction to add to this
	 * @return (this + other)
	 */
	public Fraction add(Fraction other)
	{
		return new Fraction(this.num.multiply(other.den).add(
				other.num.multiply(this.den)), this.den.multiply(other.den));
	}

}
