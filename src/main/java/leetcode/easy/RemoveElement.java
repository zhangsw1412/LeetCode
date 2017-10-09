package leetcode.easy;

import java.util.Arrays;

/**
 * Created by zhangsw on 2017/9/20.
 */
public class RemoveElement
{
	class Solution
	{
		//简洁的版本
		public int removeElement(int[] nums, int val)
		{
			int j = 0;
			for (int i = 0; i < nums.length; ++i)
			{
				if (nums[i] != val)
				{
					nums[j++] = nums[i];
				}
			}
			return j;
		}
		//自己完成的版本
		/*
		public int removeElement(int[] nums, int val)
		{
			if (nums.length == 0)
			{
				return 0;
			}
			Arrays.sort(nums);
			if ((val < nums[0]) || (val > nums[nums.length - 1]))
			{
				return nums.length;
			}
			int count = 0, index = -1;
			for (int i = 0; i < nums.length; ++i)
			{
				if (nums[i] == val)
				{
					++count;
					index = (index == -1) ? i : index;
				}
			}
			if (index != -1 && count != 0)
			{
				for (int i = index + count; i < nums.length; ++i)
				{
					nums[i - count] = nums[i];
				}
			}
			return nums.length - count;
		}
		*/
	}
}
