package leetcode.medium;

/**
 * Created by zhangsw on 2017/12/27.
 */
public class MinimumPathSum
{
	class Solution
	{
		//简洁版
		public int minPathSum(int[][] grid)
		{
			int m = grid.length, n = grid[0].length;
			for (int i = 0; i < m; i++)
			{
				for (int j = 0; j < n; j++)
				{
					if (i == 0 && j != 0)
					{
						grid[i][j] += grid[i][j - 1];
					}
					if (i != 0 && j == 0)
					{
						grid[i][j] += grid[i - 1][j];
					}
					if (i != 0 && j != 0)
					{
						grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
					}
				}
			}
			return grid[m - 1][n - 1];
		}
		/*
		public int minPathSum(int[][] g)
		{
			if (g == null)
			{
				return 0;
			}
			for (int i = 1; i < g[0].length; i++)
			{
				g[0][i] += g[0][i - 1];
			}
			for (int i = 1; i < g.length; i++)
			{
				g[i][0] += g[i - 1][0];
			}
			for (int i = 1; i < g.length; i++)
			{
				for (int j = 1; j < g[0].length; j++)
				{
					g[i][j] += Math.min(g[i - 1][j], g[i][j - 1]);
				}
			}
			return g[g.length - 1][g[0].length - 1];
		}
		*/
	}
}
