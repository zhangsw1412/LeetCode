package leetcode.easy;

/**
 * Created by zhangsw on 2017/10/16.
 */
public class SingleNumber
{
	class Solution
	{
		public int singleNumber(int[] a)
		{
			int result = 0;
			for (int i = 0, len = a.length; i < len; ++i)
			{
				result ^= a[i];
			}
			return result;
		}
	}
}
