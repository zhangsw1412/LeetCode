package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhangsw on 2018/1/21.
 */
public class SurroundedRegions
{
	class Solution
	{
		//从四周向中心进行Flood Fill，将没有被包围的O暂替换为#，最后将所有不是#的替换为X
		public void solve(char[][] board)
		{
			if (board == null || board.length == 0 || board[0].length == 0)
			{
				return;
			}
			int height = board.length, width = board[0].length;
			for (int i = 0; i < height; i++)
			{
				fill(board, i, 0);
				fill(board, i, width - 1);
			}
			for (int i = 0; i < width; i++)
			{
				fill(board, 0, i);
				fill(board, height - 1, i);
			}
			for (int i = 0; i < height; i++)
			{
				for (int j = 0; j < width; j++)
				{
					board[i][j] = board[i][j] == '#' ? 'O' : 'X';
				}
			}
		}

		private void fill(char[][] b, int i, int j)
		{
			if (b[i][j] != 'O')
			{
				return;
			}
			b[i][j] = '#';
			Queue<Integer> queue = new LinkedList<>();
			int height = b.length, width = b[0].length;
			queue.offer(i * width + j);
			while (!queue.isEmpty())
			{
				int val = queue.poll();
				int row = val / width, col = val % width;
				if (row > 0 && b[row - 1][col] == 'O')
				{
					queue.offer((row - 1) * width + col);
					b[row - 1][col] = '#';
				}
				if (row < height - 1 && b[row + 1][col] == 'O')
				{
					queue.offer((row + 1) * width + col);
					b[row + 1][col] = '#';
				}
				if (col > 0 && b[row][col - 1] == 'O')
				{
					queue.offer(row * width + col - 1);
					b[row][col - 1] = '#';
				}
				if (col < width - 1 && b[row][col + 1] == 'O')
				{
					queue.offer(row * width + col + 1);
					b[row][col + 1] = '#';
				}
			}
		}
	}
}
