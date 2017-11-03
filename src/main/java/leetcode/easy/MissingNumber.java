package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/3.
 */
public class MissingNumber
{
	class Solution
	{
		public int missingNumber(int[] a)
		{
			int result = 0, len = a.length;
			for (int temp : a)
			{
				result += temp;
			}
			return (1 + len) * len / 2 - result;
		}
	}
}
