package leetcode.medium;

import java.util.Arrays;

/**
 * Created by zhangsw on 2018/4/4.
 */
public class SearchA2DMatrix_II
{
	class Solution
	{
		public boolean searchMatrix(int[][] matrix, int target)
		{
			if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			{
				return false;
			}
			int last = matrix[0].length - 1;
			for (int i = 0; i < matrix.length; i++)
			{
				if (target >= matrix[i][0] && target <= matrix[i][last] && Arrays.binarySearch(matrix[i], target) >= 0)
				{
					return true;
				}
			}
			return false;
		}
	}
}
