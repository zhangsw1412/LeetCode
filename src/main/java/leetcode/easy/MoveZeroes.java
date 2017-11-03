package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/4.
 */
public class MoveZeroes
{
	class Solution
	{
		public void moveZeroes(int[] a)
		{
			int zeroCount = 0, pos = 0;
			while (pos < a.length)
			{
				if (a[pos] != 0)
				{
					a[pos - zeroCount] = a[pos];
				}
				else
				{
					++zeroCount;
				}
				++pos;
			}
			while (zeroCount-- > 0)
			{
				a[pos - zeroCount - 1] = 0;
			}
		}
	}
}
