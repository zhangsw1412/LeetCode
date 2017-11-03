package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/4.
 */
public class MoveZeroes
{
	class Solution
	{
		//简洁的写法
		public void moveZeroes(int[] nums)
		{
			if (nums == null || nums.length == 0)
			{
				return;
			}
			int insertPos = 0;
			for (int num : nums)
			{
				if (num != 0)
				{
					nums[insertPos++] = num;
				}
			}
			while (insertPos < nums.length)
			{
				nums[insertPos++] = 0;
			}
		}
		//自己完成的版本
		/*
		public void moveZeroes(int[] a)
		{
			int zeroCount = 0, pos = 0;
			while (pos < a.length)
			{
				if (a[pos] != 0)
				{
					a[pos - zeroCount] = a[pos];
				}
				else
				{
					++zeroCount;
				}
				++pos;
			}
			while (zeroCount-- > 0)
			{
				a[pos - zeroCount - 1] = 0;
			}
		}
		*/
	}
}
