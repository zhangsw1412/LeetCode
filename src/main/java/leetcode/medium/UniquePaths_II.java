package leetcode.medium;

/**
 * Created by zhangsw on 2017/12/26.
 */
public class UniquePaths_II
{
	class Solution
	{
		//简洁版
		public int uniquePathsWithObstacles(int[][] obstacleGrid)
		{
			int width = obstacleGrid[0].length;
			int[] dp = new int[width];
			dp[0] = 1;
			for (int[] row : obstacleGrid)
			{
				for (int j = 0; j < width; j++)
				{
					if (row[j] == 1)
					{
						dp[j] = 0;
					}
					else if (j > 0)
					{
						dp[j] += dp[j - 1];
					}
				}
			}
			return dp[width - 1];
		}
		/*
		public int uniquePathsWithObstacles(int[][] a)
		{
			if (a == null)
			{
				return 0;
			}
			for (int i = 0; i < a.length; i++)
			{
				for (int j = 0; j < a[0].length; j++)
				{
					if (a[i][j] == 1)
					{
						a[i][j] = -1;
					}
				}
			}
			for (int i = 0; i < a[0].length; i++)
			{
				if (a[0][i] == -1)
				{
					break;
				}
				a[0][i] = 1;
			}
			for (int i = 0; i < a.length; i++)
			{
				if (a[i][0] == -1)
				{
					break;
				}
				a[i][0] = 1;
			}
			for (int i = 1; i < a.length; i++)
			{
				for (int j = 1; j < a[0].length; j++)
				{
					if (a[i][j] == 0)
					{
						a[i][j] = (a[i - 1][j] == -1 ? 0 : a[i - 1][j]) + (a[i][j - 1] == -1 ? 0 : a[i][j - 1]);
					}
				}
			}
			return a[a.length - 1][a[0].length - 1] == -1 ? 0 : a[a.length - 1][a[0].length - 1];
		}
		*/
	}
}
