package leetcode.easy;

/**
 * Created by zhangsw on 2017/12/8.
 */
public class RepeatedStringMatch
{
	class Solution
	{
		public int repeatedStringMatch(String a, String b)
		{
			StringBuilder stringBuilder = new StringBuilder(a);
			for (int i = 1, limit = b.length() / a.length() + 2; i <= limit; i++)
			{
				if (stringBuilder.indexOf(b) >= 0)
				{
					return i;
				}
				else
				{
					stringBuilder.append(a);
				}
			}
			return -1;
		}
	}
}
