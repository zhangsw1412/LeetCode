package leetcode.easy;

/**
 * Created by zhangsw on 2017/12/5.
 */
public class JudgeRouteCircle
{
	class Solution
	{
		public boolean judgeCircle(String a)
		{
			int v = 0, h = 0;
			for (char c : a.toCharArray())
			{
				switch (c)
				{
					case 'U':
						++v;
						break;
					case 'D':
						--v;
						break;
					case 'L':
						--h;
						break;
					case 'R':
						++h;
						break;
				}
			}
			return v == 0 && h == 0;
		}
	}
}
