package leetcode.easy;

/**
 * Created by zhangsw on 2017/12/9.
 */
public class CountBinarySubstrings
{
	class Solution
	{
		public int countBinarySubstrings(String s)
		{
			int pre = 0, current = 1, result = 0;
			char[] c = s.toCharArray();
			for (int i = 1; i < c.length; i++)
			{
				if (c[i] == c[i - 1])
				{
					current++;
				}
				else
				{
					pre = current;
					current = 1;
				}
				if (current <= pre)
				{
					++result;
				}
			}
			return result;
		}
	}
}
