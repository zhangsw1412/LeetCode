package leetcode.easy;

import java.awt.*;

/**
 * Created by zhangsw on 2017/12/10.
 */
public class FloodFill
{
	class Solution
	{
		public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
		{
			boolean[][] checked = new boolean[image.length][image[0].length];
			helper(image, checked, sr, sc, image[sr][sc], newColor);
			return image;
		}

		private void helper(int[][] a, boolean[][] checked, int row, int col, int oriColor, int newColor)
		{
			if (row < 0 || row == a.length || col < 0 || col == a[0].length)
			{
				return;
			}
			if (!checked[row][col] && a[row][col] != oriColor)
			{
				checked[row][col] = true;
				a[row][col] = newColor;
				helper(a, checked, row - 1, col, oriColor, newColor);
				helper(a, checked, row + 1, col, oriColor, newColor);
				helper(a, checked, row, col - 1, oriColor, newColor);
				helper(a, checked, row, col + 1, oriColor, newColor);
			}
		}
	}
}
