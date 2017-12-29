package leetcode.medium;

/**
 * Created by zhangsw on 2017/12/29.
 */
public class WordSearch
{
	class Solution
	{
		public boolean exist(char[][] b, String word)
		{
			if (word == null || word.length() == 0)
			{
				return true;
			}
			if (b == null || b.length == 0 || b[0].length == 0)
			{
				return false;
			}
			boolean[][] visited = new boolean[b.length][b[0].length];
			for (int i = 0; i < b.length; i++)
			{
				for (int j = 0; j < b[0].length; j++)
				{
					if (helper(b, visited, word, 0, i, j))
					{
						return true;
					}
				}
			}
			return false;
		}

		private boolean helper(char[][] b, boolean[][] visited, String word, int index, int i, int j)
		{
			if (index == word.length())
			{
				return true;
			}
			if (i < 0 || i == b.length || j < 0 || j == b[0].length || visited[i][j] || b[i][j] != word.charAt(index))
			{
				return false;
			}
			visited[i][j] = true;
			boolean result = helper(b, visited, word, index + 1, i - 1, j)
					|| helper(b, visited, word, index + 1, i, j - 1)
					|| helper(b, visited, word, index + 1, i, j + 1)
					|| helper(b, visited, word, index + 1, i + 1, j);
			visited[i][j] = false;
			return result;
		}

		//这个方法不需要额外空间
		/*
		public boolean exist(char[][] board, String word) {
			char[] w = word.toCharArray();
			for (int y=0; y<board.length; y++) {
				for (int x=0; x<board[y].length; x++) {
					if (exist(board, y, x, w, 0)) return true;
				}
			}
			return false;
		}

		private boolean exist(char[][] board, int y, int x, char[] word, int i) {
			if (i == word.length) return true;
			if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
			if (board[y][x] != word[i]) return false;
			board[y][x] ^= 256;
			boolean exist = exist(board, y, x+1, word, i+1)
					|| exist(board, y, x-1, word, i+1)
					|| exist(board, y+1, x, word, i+1)
					|| exist(board, y-1, x, word, i+1);
			board[y][x] ^= 256;
			return exist;
		}
		*/
	}
}
