package leetcode.easy;

/**
 * Created by zhangsw on 2017/10/23.
 */
public class ReverseBits
{
	class Solution
	{
		//用位操作进行翻转
		public int reverseBits(int n)
		{
			int result = 0;
			for (int i = 0; i < 32; ++i)
			{
				result = (result << 1) | (n & 1);
				n >>= 1;
			}
			return result;
		}
	}
}
