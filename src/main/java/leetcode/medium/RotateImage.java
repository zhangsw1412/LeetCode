package leetcode.medium;

/**
 * Created by zhangsw on 2017/12/25.
 */
public class RotateImage
{
	class Solution
	{
		//首先以副对角线为轴翻转，然后再沿水平中线上下翻转即可得到结果
		public void rotate(int[][] m)
		{
			int n = m.length;
			for (int i = 0; i < n - 1; i++)
			{
				for (int j = 0; j < n - 1 - i; j++)
				{
					int temp = m[i][j];
					m[i][j] = m[n - 1 - j][n - 1 - i];
					m[n - 1 - j][n - 1 - i] = temp;
				}
			}
			for (int i = 0; i < n / 2; i++)
			{
				for (int j = 0; j < n; j++)
				{
					int temp = m[i][j];
					m[i][j] = m[n - 1 - i][j];
					m[n - 1 - i][j] = temp;
				}
			}
		}
	}
}
