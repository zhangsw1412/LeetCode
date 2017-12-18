package leetcode.medium;

/**
 * Created by zhangsw on 2017/12/18.
 */
public class SearchInRotatedSortedArray
{
	class Solution
	{
		public int search(int[] a, int target)
		{
			if (a == null || a.length == 0)
			{
				return -1;
			}
			int l = 0, r = a.length - 1, m;
			while (l <= r)
			{
				m = (l + r) / 2;
				if (a[m] == target)
				{
					return m;
				}
				if (a[m] < a[r])
				{
					if (target > a[m] && target <= a[r])
					{
						l = m + 1;
					}
					else
					{
						r = m - 1;
					}
				}
				else
				{
					if (target >= a[l] && target < a[m])
					{
						r = m - 1;
					}
					else
					{
						l = m + 1;
					}
				}
			}
			return -1;
		}
	}
}
