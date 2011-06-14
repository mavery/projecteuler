package mavery.projecteuler;

import java.util.ArrayList;
import java.util.List;

import mavery.projecteuler.util.FileUtils;

public class Problem102
{
	/**
	 * Three distinct points are plotted at random on a Cartesian plane, for
	 * which -1000 x, y 1000, such that a triangle is formed.
	 * 
	 * Consider the following two triangles:
	 * 
	 * A(-340,495), B(-153,-910), C(835,-947)
	 * 
	 * X(-175,41), Y(-421,-714), Z(574,-645)
	 * 
	 * It can be verified that triangle ABC contains the origin, whereas
	 * triangle XYZ does not.
	 * 
	 * Using triangles.txt (right click and 'Save Link/Target As...'), a 27K
	 * text file containing the co-ordinates of one thousand "random" triangles,
	 * find the number of triangles for which the interior contains the origin.
	 */
	public static void main(String[] args) throws Exception
	{
		List<Point[]> triangles = readTriangles("resources/Problem102.txt");

		int result = 0;

		for (Point[] triangle : triangles)
		{
			int area = twiceArea(triangle[0], triangle[1], triangle[2]);
			for (int i = 0; i < triangle.length; i++)
			{
				Point temp = triangle[i];
				triangle[i] = Point.ORIGIN;
				area -= twiceArea(triangle[0], triangle[1], triangle[2]);
				triangle[i] = temp;
			}
			if (area == 0)
			{
				result++;
			}
		}

		System.out.println(result);
	}

	/**
	 * Returns twice the area of the triangle ABC.
	 */
	private static int twiceArea(Point a, Point b, Point c)
	{
		return Math.abs(a.x * b.y + b.x * c.y + c.x * a.y - a.x * c.y - c.x
				* b.y - b.x * a.y);
	}

	private static List<Point[]> readTriangles(String filename)
			throws Exception
	{
		List<Point[]> result = new ArrayList<Point[]>();
		for (String s : FileUtils.readLines(filename))
		{
			Point[] triangle = new Point[3];
			String[] coords = s.split(",");
			for (int i = 0; i < triangle.length; i++)
			{
				triangle[i] = (new Point(Integer.parseInt(coords[2 * i]), Integer
						.parseInt(coords[2 * i + 1])));
			}
			result.add(triangle);
		}

		return result;
	}

	/**
	 * A point in 2D cartesian space with integer coordinates. 
	 */
	private static class Point
	{
		static final Point ORIGIN = new Point(0, 0);

		final int x;
		final int y;

		Point(int x, int y)
		{
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString()
		{
			return "(" + x + ", " + y + ")";
		}
	}
}
