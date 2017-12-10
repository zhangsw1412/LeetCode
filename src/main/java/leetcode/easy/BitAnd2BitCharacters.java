package leetcode.easy;

/**
 * Created by zhangsw on 2017/12/10.
 */
public class BitAnd2BitCharacters
{
	class Solution
	{
		public boolean isOneBitCharacter(int[] a)
		{
			boolean flag = false;
			for (int i = 0; i < a.length; i++)
			{
				if (a[i] == 1)
				{
					++i;
					flag = false;
				}
				else
				{
					flag = true;
				}
			}
			return flag;
		}
	}
}
