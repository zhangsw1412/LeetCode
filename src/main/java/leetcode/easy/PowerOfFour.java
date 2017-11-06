package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/6.
 */
public class PowerOfFour
{
	class Solution
	{
		/*
		如果是4的次方，那么一定是2的次方
		4的次方的最高位都是在奇数位，所以与0x55555555做按位与运算还是自身的话证明是4的次方数
		 */
		public boolean isPowerOfFour(int n)
		{
			return (n > 0) && ((n & (n - 1)) == 0) && ((n & 0x55555555) == n);
		}
	}
}
