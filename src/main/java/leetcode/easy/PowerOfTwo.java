package leetcode.easy;

/**
 * Created by zhangsw on 2017/10/31.
 */
public class PowerOfTwo
{
	class Solution
	{
		/*
		如果一个数是2的次方数的话，根据上面分析，那么它的二进数必然是最高位为1，其它都为0，
		那么如果此时我们减1的话，则最高位会降一位，
		其余为0的位现在都为变为1，那么我们把两数相与，就会得到0，
		用这个性质也能来解题，而且只需一行代码就可以搞定
		 */
		public boolean isPowerOfTwo(int n)
		{
			return (n > 0) && (((n - 1) & n) == 0);
		}
		/*
		二的次方数改写为二进制时，都是一个1后面跟着若干个0的样子如8的二进制就写为1000
		所以只要计算其中1的个数就可以了
		 */
		/*
		public boolean isPowerOfTwo(int n)
		{
			int count = 0;
			while (n > 0)
			{
				if ((n & 1) == 1)
				{
					++count;
				}
				n >>>= 1;
			}
			return count == 1;
		}
		*/
	}
}
