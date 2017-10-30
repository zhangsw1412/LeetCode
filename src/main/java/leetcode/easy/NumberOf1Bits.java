package leetcode.easy;

/**
 * Created by zhangsw on 2017/10/23.
 */
public class NumberOf1Bits
{
	class Solution
	{
		//每次将n减一就能去掉二进制中的一个1
		public int hammingWeight(int n)
		{
			int result = 0;
			while (n != 0)
			{
				n &= (n - 1);
				++result;
			}
			return result;
		}
		/*
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
		*/
	}
}
