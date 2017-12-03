package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangsw on 2017/12/3.
 */
public class SetMismatch
{
	class Solution
	{
		public int[] findErrorNums(int[] a)
		{
			int missing = 0, sum = 0;
			Set<Integer> set = new HashSet<>();
			for (int i : a)
			{
				set.add(i);
				sum += i;
			}
			for (int i = 1; i <= a.length; i++)
			{
				if (set.add(i))
				{
					missing = i;
					break;
				}
			}
			return new int[]{missing + sum - (1 + a.length) * a.length / 2, missing};
		}

		//简洁版
		/*
		public int[] findErrorNums(int[] nums)
		{
			Set<Integer> set = new HashSet<>();
			int duplicate = 0, n = nums.length;
			long sum = (n * (n + 1)) / 2;
			for (int i : nums)
			{
				if (set.contains(i))
				{
					duplicate = i;
				}
				sum -= i;
				set.add(i);
			}
			return new int[]{duplicate, (int) sum + duplicate};
		}
		*/
	}
}
