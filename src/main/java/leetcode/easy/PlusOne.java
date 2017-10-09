package leetcode.easy;

/**
 * Created by zhangsw on 2017/9/26.
 */
public class PlusOne
{
	class Solution
	{
		public int[] plusOne(int[] a)
		{
			for (int i = a.length - 1; i >= 0; --i)
			{
				if (a[i] < 9)
				{
					++a[i];
					return a;
				}
				a[i] = 0;
			}
			int[] res = new int[a.length + 1];
			res[0] = 1;
			return res;
		}
	}
}
