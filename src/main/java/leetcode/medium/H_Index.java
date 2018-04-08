package leetcode.medium;

import java.util.Arrays;

/**
 * Created by zhangsw on 2018/4/8.
 */
public class H_Index
{
	class Solution
	{
		public int hIndex(int[] c)
		{
			Arrays.sort(c);
			int i = 1;
			while (i <= c.length && c[c.length - i] >= i)
			{
				++i;
			}
			return --i;
		}
	}
}
