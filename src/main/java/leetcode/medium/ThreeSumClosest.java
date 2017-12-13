package leetcode.medium;

import java.util.Arrays;

/**
 * Created by zhangsw on 2017/12/13.
 */
public class ThreeSumClosest
{
	class Solution
	{
		public int threeSumClosest(int[] a, int target)
		{
			Arrays.sort(a);
			int diff = Integer.MAX_VALUE, ans = 0, left, right;
			for (int i = 0; i < a.length - 2; i++)
			{
				if (i > 0 && a[i] == a[i - 1])
				{
					continue;
				}
				left = i + 1;
				right = a.length - 1;
				while (left < right)
				{
					int sum = a[i] + a[left] + a[right];
					if (sum < target)
					{
						if (target - sum < diff)
						{
							ans = sum;
							diff = target - sum;
						}
						++left;
					}
					else if (sum > target)
					{
						if (sum - target < diff)
						{
							ans = sum;
							diff = sum - target;
						}
						--right;
					}
					else
					{
						return sum;
					}
				}
			}
			return ans;
		}

		//简洁版
		/*
		public int threeSumClosest(int[] num, int target)
		{
			int result = num[0] + num[1] + num[num.length - 1];
			Arrays.sort(num);
			for (int i = 0; i < num.length - 2; i++)
			{
				int start = i + 1, end = num.length - 1;
				while (start < end)
				{
					int sum = num[i] + num[start] + num[end];
					if (sum > target)
					{
						end--;
					}
					else
					{
						start++;
					}
					if (Math.abs(sum - target) < Math.abs(result - target))
					{
						result = sum;
					}
				}
			}
			return result;
		}
		*/
	}
}
