package leetcode.easy;

/**
 * Created by zhangsw on 2017/12/9.
 */
public class MaxAreaOfIsland
{
	class Solution
	{
		boolean[][] checked = null;
		int area = 0;
		int current = 0;

		public int maxAreaOfIsland(int[][] a)
		{
			checked = new boolean[a.length][a[0].length];
			for (int y = 0; y < a.length; y++)
			{
				for (int x = 0; x < a[0].length; x++)
				{
					if (!checked[y][x])
					{
						current = 0;
						helper(a, x, y);
						area = Math.max(area, current);
					}
				}
			}
			return area;
		}

		private void helper(int[][] a, int x, int y)
		{
			if (x < 0 || x == a[0].length || y < 0 || y == a.length)
			{
				return;
			}
			if (!checked[y][x] && a[y][x] == 1)
			{
				current += 1;
				checked[y][x] = true;
				helper(a, x - 1, y);
				helper(a, x + 1, y);
				helper(a, x, y - 1);
				helper(a, x, y + 1);
			}
			return;
		}
	}
}
