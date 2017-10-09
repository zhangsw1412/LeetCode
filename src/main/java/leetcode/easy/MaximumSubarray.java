package leetcode.easy;

/**
 * Created by zhangsw on 2017/9/26.
 */
public class MaximumSubarray
{
	class Solution
	{
		public int maxSubArray(int[] a)
		{
			int sum = a[0], temp = 0;
			for (int i = 0, len = a.length; i < len; ++i)
			{
				temp += a[i];
				if (temp > sum)
				{
					sum = temp;
				}
				if (temp < 0)
				{
					temp = 0;
				}
			}
			return sum;
		}
	}
}
