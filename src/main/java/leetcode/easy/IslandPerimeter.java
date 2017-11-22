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

		/*
		loop over the matrix and count the number of islands;
		if the current dot is an island, count if it has any right neighbour or down neighbour;
		the result is islands * 4 - neighbours * 2
		 */
		/*
		public int islandPerimeter(int[][] grid)
		{
			int islands = 0, neighbours = 0;

			for (int i = 0; i < grid.length; i++)
			{
				for (int j = 0; j < grid[i].length; j++)
				{
					if (grid[i][j] == 1)
					{
						islands++; // count islands
						if (i < grid.length - 1 && grid[i + 1][j] == 1)
						{
							neighbours++; // count down neighbours
						}
						if (j < grid[i].length - 1 && grid[i][j + 1] == 1)
						{
							neighbours++; // count right neighbours
						}
					}
				}
			}

			return islands * 4 - neighbours * 2;
		}
		*/
	}
}
