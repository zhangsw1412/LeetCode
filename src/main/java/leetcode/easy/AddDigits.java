package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/3.
 */
public class AddDigits
{
	class Solution
	{
		/*
		普通解法会超时，其实数根是每9个循环一次的
		 */
		public int addDigits(int n)
		{
			return (n - 1) % 9 + 1;
		}
	}
}
