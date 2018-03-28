package leetcode.medium;

/**
 * Created by zhangsw on 2018/3/28.
 */
public class MaximalSquare
{
	class Solution
	{
		public int maximalSquare(char[][] matrix)
		{
			if (matrix == null || matrix.length == 0)
			{
				return 0;
			}
			int row = matrix.length, col = matrix[0].length;
			int[][] ret = new int[row][col];
			int max = 0;

			//初始化第一行
			for (int i = 0; i < col; i++)
			{
				ret[0][i] = matrix[0][i] - '0';
				max = Math.max(max, ret[0][i]);
			}
			for (int i = 0; i < row; i++)
			{
				ret[i][0] = matrix[i][0] - '0';
				max = Math.max(max, ret[i][0]);
			}
			//从[1][1]开始，逐个由前3个(上，左，左上)递推
			for (int i = 1; i < row; ++i)
			{
				for (int j = 1; j < col; ++j)
				{
					if (matrix[i][j] == '0')
					{
						ret[i][j] = 0;
						continue;
					}
					int left = ret[i - 1][j];
					int top = ret[i][j - 1];
					int left_top = ret[i - 1][j - 1];
					if (left > 0 && top > 0 && left_top > 0)
					{
						//核心递推式
						ret[i][j] = Math.min(left_top, Math.min(left, top)) + 1;
					}
					else
					{
						ret[i][j] = 1;
					}
					max = Math.max(max, ret[i][j]);
				}
			}
			return max * max;
		}

		//简洁版
		/*
		public int maximalSquare(char[][] a)
		{
			if (a.length == 0)
			{
				return 0;
			}
			int m = a.length, n = a[0].length, result = 0;
			int[][] b = new int[m + 1][n + 1];
			for (int i = 1; i <= m; i++)
			{
				for (int j = 1; j <= n; j++)
				{
					if (a[i - 1][j - 1] == '1')
					{
						b[i][j] = Math.min(Math.min(b[i][j - 1], b[i - 1][j - 1]), b[i - 1][j]) + 1;
						result = Math.max(b[i][j], result); // update result
					}
				}
			}
			return result * result;
		}
		*/
	}
}
