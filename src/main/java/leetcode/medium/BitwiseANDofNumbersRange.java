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
		/*
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
		*/

		/*
		递归版
		如果n大于m，那么就对m和n分别除以2，并且调用递归函数，对结果再乘以2
		 */
		/*
		public int rangeBitwiseAnd(int m, int n)
		{
			return m < n ? rangeBitwiseAnd(m >> 1, n >> 1) << 1 : m;
		}
		*/

		/*
		如果m小于n就进行循环，n与上n-1，相当于去掉最低位的1，n就这样每次去掉最低位的1，如果小于等于m了，返回此时的n即可
		 */
		public int rangeBitwiseAnd(int m, int n)
		{
			while (m < n)
			{
				n &= n - 1;
			}
			return n;
		}
	}
}
