package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/23.
 */
public class ConstructTheRectangle
{
	class Solution
	{
		public int[] constructRectangle(int area)
		{
			int l = 0, w = 0;
			for (int i = 1, limit = (int) Math.sqrt(area); i <= limit; ++i)
			{
				if ((area / i) * i == area)
				{
					w = i;
					l = area / i;
				}
			}
			return new int[]{l, w};
		}
	}
}
