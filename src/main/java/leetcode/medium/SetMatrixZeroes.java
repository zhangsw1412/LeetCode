package leetcode.medium;

/**
 * Created by zhangsw on 2017/12/28.
 */
public class SetMatrixZeroes
{
	public void setZeroes(int[][] m)
	{
		if (m == null)
		{
			return;
		}
		boolean[] row = new boolean[m.length], col = new boolean[m[0].length];
		for (int i = 0; i < m.length; i++)
		{
			for (int j = 0; j < m[0].length; j++)
			{
				if (m[i][j] == 0)
				{
					row[i] = col[j] = true;
				}
			}
		}
		for (int i = 0; i < m.length; i++)
		{
			for (int j = 0; j < m[0].length; j++)
			{
				if (row[i] || col[j])
				{
					m[i][j] = 0;
				}
			}
		}
	}
}
