package leetcode.medium;

/**
 * Created by zhangsw on 2018/4/18.
 */
public class RangeSumQuery2DImmutable
{
	class NumMatrix
	{
		private int[][] m;

		public NumMatrix(int[][] matrix)
		{
			for (int i = 0; i < matrix.length; i++)
			{
				for (int j = 0; j < matrix[i].length; j++)
				{
					matrix[i][j] +=
							(i > 0 ? matrix[i - 1][j] : 0) + (j > 0 ? matrix[i][j - 1] : 0) - (i > 0 && j > 0 ? matrix[i - 1][j - 1] : 0);
				}
			}
			this.m = matrix;
		}

		public int sumRegion(int row1, int col1, int row2, int col2)
		{
			return m[row2][col2] - (col1 > 0 ? m[row2][col1 - 1] : 0) - (row1 > 0 ? m[row1 - 1][col2] : 0) + (row1 > 0 ? (col1 > 0 ? m[row1 - 1][col1 - 1] : 0) : 0);
		}
	}
}
