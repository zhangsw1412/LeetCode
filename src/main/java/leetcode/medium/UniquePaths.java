package leetcode.medium;

/**
 * Created by zhangsw on 2017/12/26.
 */
public class UniquePaths
{
	class Solution
	{
		//组合数公式法
		public int uniquePaths(int m, int n)
		{
			int k = m + n - 2;
			int t = m - 1;
			double res = 1;
			for (int i = 1; i <= t; i++)
			{
				res = res * (k - t + i) / i;
			}
			return (int) res;
		}
	}
}
