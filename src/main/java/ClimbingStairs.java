/**
 * Created by zhangsw on 2017/10/9.
 */
public class ClimbingStairs
{
	class Solution
	{
		public int climbStairs(int n)
		{
			if ((n == 0) || (n == 1) || (n == 2))
			{
				return n;
			}
			int[] a = new int[n];
			a[0] = 1;
			a[1] = 2;
			for (int i = 2; i < n; ++i)
			{
				a[i] = a[i - 1] + a[i - 2];
			}
			return a[n - 1];
		}
	}
}
