package leetcode.easy;

/**
 * Created by zhangsw on 2017/10/19.
 */
public class FactorialTrailingZeroes
{
	class Solution
	{
		/*
		0是2和5相乘得到的，而在1到n这个范围内，2的个数要远多于5的个数，所以这里只需计算从1到n这个范围内有多少个5就可以了
		但是25会贡献两个5，125会贡献三个5，这些数需要特殊考虑
		 */
		//迭代版
		public int trailingZeroes(int n)
		{
			int result = 0;
			while (n > 0)
			{
				n /= 5;
				result += n;
			}
			return result;
		}
		//递归版
		/*
		public int trailingZeroes(int n)
		{
			return (n < 5) ? 0 : n / 5 + trailingZeroes(n / 5);
		}
		*/
	}
}
