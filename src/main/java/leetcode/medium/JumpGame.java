package leetcode.medium;

/**
 * Created by zhangsw on 2017/12/26.
 */
public class JumpGame
{
	class Solution
	{
		public boolean canJump(int[] a)
		{
			if (a == null)
			{
				return false;
			}
			int current = 0, max = 0;
			while (max < a.length - 1)
			{
				max = current + a[current];
				for (int i = current; i < a.length && i <= max; i++)
				{
					if (i + a[i] > max)
					{
						max = i + a[i];
						current = i;
						break;
					}
					else if (i == max && i < a.length - 1)
					{
						return false;
					}
				}
			}
			return true;
		}
	}
}
