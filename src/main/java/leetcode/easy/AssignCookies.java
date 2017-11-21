package leetcode.easy;

import java.util.Arrays;

/**
 * Created by zhangsw on 2017/11/21.
 */
public class AssignCookies
{
	class Solution
	{
		public int findContentChildren(int[] g, int[] s)
		{
			Arrays.sort(g);
			Arrays.sort(s);
			int i = 0, j = 0, sum = 0;
			while (i < g.length && j < s.length)
			{
				if (g[i] <= s[j])
				{
					++sum;
					++i;
					++j;
				}
				else
				{
					++j;
				}
			}
			return sum;
		}
	}
}
