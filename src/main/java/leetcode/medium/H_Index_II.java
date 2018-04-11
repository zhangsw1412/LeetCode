package leetcode.medium;

/**
 * Created by zhangsw on 2018/4/11.
 */
public class H_Index_II
{
	class Solution
	{
		public int hIndex(int[] c)
		{
			int i = 1;
			while (i <= c.length && c[c.length - i] >= i)
			{
				++i;
			}
			return --i;
		}
	}
}
