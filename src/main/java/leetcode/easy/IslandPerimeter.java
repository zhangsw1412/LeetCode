package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/22.
 */
public class IslandPerimeter
{
	class Solution
	{
		public int islandPerimeter(int[][] grid)
		{
			if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
			{
				return 0;
			}
			int height = grid.length, width = grid[0].length;
			int perimeter = 0;
			for (int j = 0; j < height; ++j)
			{
				for (int i = 0; i < width; ++i)
				{
					if (grid[j][i] != 0)
					{
						perimeter += helper(i - 1, j, width, height, grid);
						perimeter += helper(i, j - 1, width, height, grid);
						perimeter += helper(i + 1, j, width, height, grid);
						perimeter += helper(i, j + 1, width, height, grid);
					}
				}
			}
			return perimeter;
		}

		private int helper(int x, int y, int width, int height, int[][] grid)
		{
			return ((x < 0) || (x >= width) || (y < 0) || (y >= height)) || (grid[y][x] == 0) ? 1 : 0;
		}
	}
}
