package leetcode.medium;

/**
 * Created by zhangsw on 2018/3/20.
 */
public class BitwiseANDofNumbersRange
{
	class Solution
	{
		/*
		最后的数是该数字范围内所有的数的左边共同的部分
		 */

		/*
		可以建立一个32位都是1的mask，然后每次向左移一位，比较m和n是否相同，
		不同再继续左移一位，直至相同，然后把m和mask相与就是最终结果
		 */
		public int rangeBitwiseAnd(int m, int n)
		{
			int mask = Integer.MAX_VALUE;
			while ((m & mask) != (n & mask))
			{
				mask <<= 1;
			}
			return m & mask;
		}

		/*
		直接平移m和n，每次向右移一位，直到m和n相等，记录下所有平移的次数i，然后再把m左移i位即为最终结果
		 */
		public int rangeBitwiseAnd(int m, int n)
		{
			int counter = 0;
			while (m != n)
			{
				m >>= 1;
				n >>= 1;
				++counter;
			}
			return m << counter;
		}
	}
}
