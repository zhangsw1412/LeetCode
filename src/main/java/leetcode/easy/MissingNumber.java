package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/3.
 */
public class MissingNumber
{
	class Solution
	{
		//位操作版
		public int missingNumber(int[] nums)
		{
			int xor = 0, i = 0;
			for (i = 0; i < nums.length; i++)
			{
				xor = xor ^ i ^ nums[i];
			}

			return xor ^ i;
		}
		//自己实现的版本
		/*
		public int missingNumber(int[] a)
		{
			int result = 0, len = a.length;
			for (int temp : a)
			{
				result += temp;
			}
			return (1 + len) * len / 2 - result;
		}
		*/
	}
}
