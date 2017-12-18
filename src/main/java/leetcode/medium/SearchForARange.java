package leetcode.medium;

/**
 * Created by zhangsw on 2017/12/18.
 */
public class SearchForARange
{
	class Solution
	{
		public int[] searchRange(int[] a, int target)
		{
			int[] res = new int[]{-1, -1};
			if (a == null || a.length < 1)
			{
				return res;
			}
			int left = 0, right = a.length - 1, m;
			while (left <= right)
			{
				m = (left + right) / 2;
				if (a[m] < target)
				{
					left = m + 1;
				}
				else
				{
					right = m - 1;
				}
			}
			res[0] = left;
			left = 0;
			right = a.length - 1;
			while (left <= right)
			{
				m = (left + right) / 2;
				if (a[m] <= target)
				{
					left = m + 1;
				}
				else
				{
					right = m - 1;
				}
			}
			if (res[0] <= right)
			{
				res[1] = right;
			}
			else
			{
				res[0] = -1;
			}
			return res;
		}
	}
}
