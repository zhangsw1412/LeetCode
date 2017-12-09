package leetcode.easy;

/**
 * Created by zhangsw on 2017/12/9.
 */
public class BinaryNumberWithAlternatingBits
{
	class Solution
	{
		public boolean hasAlternatingBits(int a)
		{
			int pre = a & 1;
			a >>>= 1;
			while (a != 0)
			{
				if (((a & 1) ^ pre) != 1)
				{
					return false;
				}
				pre = a & 1;
				a >>>= 1;
			}
			return true;
		}
	}
}
