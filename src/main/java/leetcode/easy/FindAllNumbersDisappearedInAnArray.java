package leetcode.easy;

import java.util.*;

/**
 * Created by zhangsw on 2017/11/21.
 */
public class FindAllNumbersDisappearedInAnArray
{
	class Solution
	{
		//自己的版本
		public List<Integer> findDisappearedNumbers(int[] a)
		{
			List<Integer> result = new ArrayList<>();
			if (a == null || a.length == 0)
			{
				return result;
			}
			Set<Integer> set = new HashSet<>();
			for (int i : a)
			{
				set.add(i);
			}
			for (int i = 1; i <= a.length; ++i)
			{
				if (!set.contains(i))
				{
					result.add(i);
				}
			}
			return result;
		}

		/*
		The basic idea is that we iterate through the input array and mark elements as negative using nums[nums[i] -1] = -nums[nums[i]-1].
		In this way all the numbers that we have seen will be marked as negative.
		In the second iteration, if a value is not marked as negative,
		it implies we have never seen that index before, so just add it to the return list.
		这种思路很巧妙
		 */
		/*
		public List<Integer> findDisappearedNumbers(int[] nums)
		{
			List<Integer> ret = new ArrayList<Integer>();

			for (int i = 0; i < nums.length; i++)
			{
				int val = Math.abs(nums[i]) - 1;
				if (nums[val] > 0)
				{
					nums[val] = -nums[val];
				}
			}

			for (int i = 0; i < nums.length; i++)
			{
				if (nums[i] > 0)
				{
					ret.add(i + 1);
				}
			}
			return ret;
		}
		*/
	}
}
