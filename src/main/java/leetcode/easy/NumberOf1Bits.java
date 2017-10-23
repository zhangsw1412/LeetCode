package leetcode.easy;

/**
 * Created by zhangsw on 2017/10/23.
 */
public class NumberOf1Bits
{
	class Solution
	{
		public int hammingWeight(int n)
		{
			int result = 0;
			while (n != 0)
			{
				result += n & 1;
				n >>>= 1;
			}
			return result;
		}
	}
}
