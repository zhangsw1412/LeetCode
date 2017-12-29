package leetcode.medium;

/**
 * Created by zhangsw on 2017/12/29.
 */
public class SearchInRotatedSortedArray_II
{
	class Solution
	{
		public boolean search(int[] a, int target)
		{
			if (a == null || a.length == 0)
			{
				return false;
			}
			int left = 0, right = a.length - 1, mid;
			while (left < right)
			{
				mid = (left + right) / 2;
				if (a[mid] == target)
				{
					return true;
				}
				if (a[mid] > a[right])
				{
					if (a[mid] > target && a[left] <= target)
					{
						right = mid;
					}
					else
					{
						left = mid + 1;
					}
				}
				else if (a[mid] < a[right])
				{
					if (a[mid] < target && a[right] >= target)
					{
						left = mid + 1;
					}
					else
					{
						right = mid;
					}
				}
				else
				{
					--right;
				}
			}
			return a[left] == target;
		}
	}
}
