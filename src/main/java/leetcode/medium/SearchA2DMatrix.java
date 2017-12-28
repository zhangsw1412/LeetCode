package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangsw on 2017/12/28.
 */
public class SearchA2DMatrix
{
	//直接版
	public boolean searchMatrix(int[][] matrix, int target)
	{
		int i = 0, j = matrix[0].length - 1;
		while (i < matrix.length && j >= 0)
		{
			if (matrix[i][j] == target)
			{
				return true;
			}
			else if (matrix[i][j] > target)
			{
				j--;
			}
			else
			{
				i++;
			}
		}

		return false;
	}
	/*
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
	*/
}
