package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/23.
 */
public class ConstructTheRectangle
{
	class Solution
	{
		//简化版
		public int[] constructRectangle(int area)
		{
			int w = (int) Math.sqrt(area);
			while (area % w != 0)
			{
				w--;
			}
			return new int[]{area / w, w};
		}

		//自己的版本
		/*
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
		*/
	}
}
