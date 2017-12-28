package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangsw on 2017/12/28.
 */
public class SearchA2DMatrix
{
	public boolean searchMatrix(int[][] matrix, int target)
	{
		if (matrix == null || matrix.length == 0)
		{
			return false;
		}
		int[] list = new int[matrix.length * matrix[0].length];
		int counter = 0;
		for (int[] row : matrix)
		{
			for (int i : row)
			{
				list[counter++] = i;
			}
		}
		return Arrays.binarySearch(list, target) >= 0;
	}
}
