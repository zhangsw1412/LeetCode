package leetcode.easy;

/**
 * Created by zhangsw on 2017/12/3.
 */
public class SumOfSquareNumbers
{
	class Solution
	{
		public boolean judgeSquareSum(int a)
		{
			int right = (int) Math.sqrt(a), left = 0;
			while (left <= right)
			{
				if (left * left + right * right == a)
				{
					return true;
				}
				else if (left * left + right * right < a)
				{
					++left;
				}
				else
				{
					--right;
				}
			}
			return false;
		}
	}
}
