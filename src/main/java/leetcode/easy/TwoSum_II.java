package leetcode.easy;

/**
 * Created by zhangsw on 2017/10/17.
 */
public class TwoSum_II
{
	class Solution
	{
		public int[] twoSum(int[] a, int target)
		{
			int left = 0, right = a.length - 1;
			while (left < right)
			{
				if ((a[left] + a[right]) == target)
				{
					return new int[]{left + 1, right + 1};
				}
				if ((a[left] + a[right]) < target)
				{
					++left;
				}
				else
				{
					--right;
				}
			}
			return null;
		}
	}
}
