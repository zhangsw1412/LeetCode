package leetcode.medium;

/**
 * Created by zhangsw on 2018/4/4.
 */
public class SingleNumber_III
{
	class Solution
	{
		/*
		首先我们先把原数组全部异或起来，那么我们会得到一个数字，
		这个数字是两个不相同的数字异或的结果，我们取出其中任意一位为‘1’的位，
		为了方便起见，我们用 a &= -a 来取出最右端为‘1’的位，
		然后和原数组中的数字挨个相与，那么我们要求的两个不同的数字就被分到了两个小组中，
		分别将两个小组中的数字都异或起来，就可以得到最终结果了
		 */
		public int[] singleNumber(int[] nums)
		{
			int[] result = new int[2];
			int diff = 0;
			for (int num : nums)
			{
				diff ^= num;
			}
			diff &= -diff;
			for (int num : nums)
			{
				if ((num & diff) == 0)
				{
					result[0] ^= num;
				}
				else
				{
					result[1] ^= num;
				}
			}
			return result;
		}
	}
}
