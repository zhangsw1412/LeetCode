package leetcode.easy;

/**
 * Created by zhangsw on 2017/12/5.
 */
public class ImageSmoother
{
	class Solution
	{
		public int[][] imageSmoother(int[][] a)
		{
			int[][] res = new int[a.length][a[0].length];
			for (int i = 0; i < a.length; ++i)
			{
				for (int j = 0; j < a[0].length; ++j)
				{
					res[i][j] = smooth(j, i, a);
				}
			}
			return res;
		}

		private int smooth(int x, int y, int[][] a)
		{
			int sum = 0, counter = 0;
			for (int i = y - 1; i <= y + 1; ++i)
			{
				for (int j = x - 1; j <= x + 1; ++j)
				{
					if (i >= 0 && i < a.length && j >= 0 && j < a[0].length)
					{
						++counter;
						sum += a[i][j];
					}
				}
			}
			return sum / counter;
		}
	}
}
