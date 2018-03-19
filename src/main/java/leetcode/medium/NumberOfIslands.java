package leetcode.medium;

/**
 * Created by zhangsw on 2018/3/19.
 */
public class NumberOfIslands
{
	class Solution
	{
		public int numIslands(char[][] grid)
		{
			if (grid == null || grid.length == 0)
			{
				return 0;
			}
			int height = grid.length, width = grid[0].length;
			int result = 0;
			for (int y = 0; y < height; ++y)
			{
				for (int x = 0; x < width; x++)
				{
					if (grid[y][x] == '1')
					{
						++result;
						helper(grid, x, y);
					}
				}
			}
			return result;
		}

		private void helper(char[][] grid, int x, int y)
		{
			int height = grid.length, width = grid[0].length;
			if (x >= 0 && x < width && y >= 0 && y < height && grid[y][x] == '1')
			{
				grid[y][x] = '0';
				helper(grid, x, y - 1);
				helper(grid, x, y + 1);
				helper(grid, x - 1, y);
				helper(grid, x + 1, y);
			}
		}
	}
}
