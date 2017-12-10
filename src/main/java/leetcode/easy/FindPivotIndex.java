package leetcode.easy;

/**
 * Created by zhangsw on 2017/12/10.
 */
public class FindPivotIndex
{
	class Solution
	{
		public int pivotIndex(int[] a)
		{
			int right = 0, left = 0;
			for (int i : a)
			{
				right += i;
			}
			for (int i = 0; i < a.length; i++)
			{
				left += i > 0 ? a[i - 1] : 0;
				right -= a[i];
				if (left == right)
				{
					return i;
				}
			}
			return -1;
		}
	}
}
