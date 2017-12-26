package leetcode.medium;

/**
 * Created by zhangsw on 2017/12/26.
 */
public class SpiralMatrix_II
{
	class Solution
	{
		public int[][] generateMatrix(int n)
		{
			int[][] m = new int[n][n];
			int counter = 1, row = -1, col = -1;
			while (counter <= n * n)
			{
				for (++row, ++col; col < n && m[row][col] == 0; ++col)
				{
					m[row][col] = counter++;
				}
				for (--col, ++row; row < n && m[row][col] == 0; ++row)
				{
					m[row][col] = counter++;
				}
				for (--row, --col; col >= 0 && m[row][col] == 0; --col)
				{
					m[row][col] = counter++;
				}
				for (++col, --row; row >= 0 && m[row][col] == 0; --row)
				{
					m[row][col] = counter++;
				}
			}
			return m;
		}
	}
}
