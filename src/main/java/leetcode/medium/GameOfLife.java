package leetcode.medium;

/**
 * Created by zhangsw on 2018/4/14.
 */
public class GameOfLife
{
	/*
	使用原数组缓存结果。但又不影响后续计算。因为所有数组的值只有两个，1：存活，0：死亡
	那么我们就可以用二进制11，表示当前状态存活，下一个状态存活
	01：表示当前状态存活，下一个状态死亡
	10：表示当前状态死亡，下一个状态存活。
	00：当前状态死亡，下一个状态死亡
	最后数组就变成了值为00~11的数组，然后将所有元素向右移动一位，就变成了下一个状态
	 */
	public void gameOfLife(int[][] board)
	{
		int row = board.length, col = board[0].length;
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				int neighbors = helper(board, i, j);
				if (board[i][j] == 1)
				{
					//当前细胞存活
					//如果活细胞周围邻居有两道三个为活细胞，则下一代继续存活
					if (neighbors == 2 || neighbors == 3)
					{
						board[i][j] = 3;//11
					}
					//如果小于2个或者大于3个，都是导致死亡
					//即是01，则在更新时，死掉
				}
				else
				{
					if (neighbors == 3)
					{
						//如果当前细胞是死的，其相邻有三个存活的邻居。则其变成一个活细胞
						board[i][j] = 2;//10
					}
				}
			}
		}
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				board[i][j] >>= 1;
			}
		}
	}

	/*
	计算一个细胞周围存活的细胞数
	 */
	private int helper(int[][] b, int x, int y)
	{
		int row = b.length, col = b[0].length;
		int count = 0;
		for (int i = Math.max(x - 1, 0); i <= Math.min(x + 1, row - 1); i++)
		{
			for (int j = Math.max(y - 1, 0); j <= Math.min(y + 1, col - 1); j++)
			{
				count += b[i][j] & 1;
			}
		}
		count -= b[x][y] & 1;
		return count;
	}
}
