package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/23.
 */
public class LargestPalindromeProduct
{
	class Solution
	{
		/*
		输入范围n∈[1, 8]，除n = 1以外，其余n值最大回文数palindrome的位数均为偶数，
		可以拆分为half与reversed(half)左右两半。从上界high = pow(10, n) - 1
		向下界low = pow(10, n - 1)枚举half，构造回文，检查是否存在两个n位数的除数
		 */
		public int largestPalindrome(int n)
		{
			if (n == 1)
			{
				return 9;
			}

			int high = (int) Math.pow(10, n) - 1, low = high / 10;

			for (int i = high; i > low; i--)
			{
				long palindrome = createPalindrome(i);

				for (long j = high; j > low; j--)
				{
					if (palindrome / j > high)
					{
						break;
					}
					if (palindrome % j == 0)
					{
						return (int) (palindrome % 1337);
					}
				}
			}
			return -1;
		}

		private long createPalindrome(long num)
		{
			String str = num + new StringBuilder(Long.toString(num)).reverse().toString();
			return Long.parseLong(str);
		}
	}
}
