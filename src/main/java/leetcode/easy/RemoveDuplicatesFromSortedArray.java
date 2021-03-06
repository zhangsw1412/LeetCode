package leetcode.easy;

/**
 * Created by zhangsw on 2017/9/20.
 */
public class RemoveDuplicatesFromSortedArray
{
	class Solution
	{
		//一个简洁的版本
		public int removeDuplicates(int[] nums)
		{
			if (nums.length == 0)
			{
				return 0;
			}
			int result = 0;
			for (int i = 0; i < nums.length; ++i)
			{
				if (nums[i] > nums[result])
				{
					nums[++result] = nums[i];
				}
			}
			return ++result;
		}
		//自己完成的版本
		/*
		public int removeDuplicates(int[] nums)
		{
			if (nums.length == 0)
			{
				return 0;
			}
			int result = 1;
			for (int i = 1; i < nums.length; ++i)
			{
				while ((i < nums.length) && (nums[i] == nums[i - 1]))
				{
					++i;
				}
				if (i != nums.length)
				{
					nums[result] = nums[i];
					++result;
				}
			}
			return result;
		}
		*/
	}
}
