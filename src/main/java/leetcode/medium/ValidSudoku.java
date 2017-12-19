package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangsw on 2017/12/19.
 */
public class ValidSudoku
{
	class Solution
	{
		public boolean isValidSudoku(char[][] a)
		{
			if (a == null)
			{
				return false;
			}
			//检查行
			for (int i = 0; i < 9; i++)
			{
				Set<Character> set = new HashSet<>();
				for (int j = 0; j < 9; j++)
				{
					if (a[i][j] != '.' && !set.add(a[i][j]))
					{
						return false;
					}
				}
			}
			//检查列
			for (int i = 0; i < 9; i++)
			{
				Set<Character> set = new HashSet<>();
				for (int j = 0; j < 9; j++)
				{
					if (a[j][i] != '.' && !set.add(a[j][i]))
					{
						return false;
					}
				}
			}
			//检查子矩阵
			for (int i = 0; i < 9; i += 3)
			{
				for (int j = 0; j < 9; j += 3)
				{
					Set<Character> set = new HashSet<>();
					for (int k = 0; k < 9; k++)
					{
						if (a[i + k / 3][j + k % 3] != '.' && !set.add(a[i + k / 3][j + k % 3]))
						{
							return false;
						}
					}
				}
			}
			return true;
		}
	}
}
