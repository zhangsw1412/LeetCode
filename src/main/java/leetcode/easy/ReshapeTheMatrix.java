package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/29.
 */
public class ReshapeTheMatrix
{
	class Solution
	{
		public int[][] matrixReshape(int[][] a, int r, int c)
		{
			int ori_r = a.length, ori_c = a[0].length;
			if ((ori_r * ori_c) != (r * c))
			{
				return a;
			}
			int[][] b = new int[r][c];
			int counter = 0;
			for (int i = 0; i < r; ++i)
			{
				for (int j = 0; j < c; ++j)
				{
					b[i][j] = a[counter / ori_c][counter % ori_c];
					++counter;
				}
			}
			return b;
		}
	}
}
