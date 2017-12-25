package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangsw on 2017/12/25.
 */
public class SpiralMatrix
{
	class Solution
	{
		public List<Integer> spiralOrder(int[][] matrix)
		{
			if (matrix == null || matrix.length == 0)
			{
				return new ArrayList<>();
			}
			List<Integer> list = new ArrayList<>(matrix.length * matrix[0].length);
			boolean[][] checked = new boolean[matrix.length][matrix[0].length];
			int counter = 1, i = 0, j = 0;
			while (counter <= matrix.length * matrix[0].length)
			{
				while (j < matrix[0].length && !checked[i][j])
				{
					list.add(matrix[i][j]);
					checked[i][j++] = true;
					++counter;
				}
				++i;
				--j;
				while (i < matrix.length && !checked[i][j])
				{
					list.add(matrix[i][j]);
					checked[i++][j] = true;
					++counter;
				}
				--j;
				--i;
				while (j >= 0 && !checked[i][j])
				{
					list.add(matrix[i][j]);
					checked[i][j--] = true;
					++counter;
				}
				--i;
				++j;
				while (i >= 0 && !checked[i][j])
				{
					list.add(matrix[i][j]);
					checked[i--][j] = true;
					++counter;
				}
				++j;
				++i;
			}
			return list;
		}
	}
}
