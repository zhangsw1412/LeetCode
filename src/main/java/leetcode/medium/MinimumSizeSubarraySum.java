package leetcode.medium;

/**
 * Created by zhangsw on 2018/3/22.
 */
public class MinimumSizeSubarraySum
{
	class Solution
	{
		public int minSubArrayLen(int s, int[] nums)
		{
			if (nums == null || nums.length == 0)
			{
				return 0;
			}
			int left = 0, right = 0, result = 0, sum = nums[0];
			for (; ; )
			{
				if (sum >= s)
				{
					result = result == 0 ? right - left + 1 : Math.min(result, right - left + 1);
					sum -= nums[left++];
				}
				else
				{
					if (right == nums.length - 1)
					{
						break;
					}
					sum += nums[++right];
				}
			}
			return result;
		}
	}
}
