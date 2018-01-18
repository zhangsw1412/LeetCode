package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangsw on 2018/1/18.
 */
public class Triangle
{
	class Solution
	{
		//从下向上计算
		public int minimumTotal(List<List<Integer>> triangle)
		{
			int[] A = new int[triangle.size() + 1];
			for (int i = triangle.size() - 1; i >= 0; i--)
			{
				for (int j = 0; j < triangle.get(i).size(); j++)
				{
					A[j] = Math.min(A[j], A[j + 1]) + triangle.get(i).get(j);
				}
			}
			return A[0];
		}

		/*
		public int minimumTotal(List<List<Integer>> triangle)
		{
			int result = 0;
			if (triangle == null || triangle.size() == 0)
			{
				return result;
			}
			int n = triangle.size();
			List<Integer> list = new ArrayList<>(n), temp;
			for (int i = 0; i < n; i++)
			{
				temp = triangle.get(i);
				for (int j = i; j >=0 ; j--)
				{
					if (j == i)
					{
						list.add(temp.get(j) + (j > 0 ? list.get(j - 1) : 0));
						result = list.get(j);
					}
					else if (j == 0)
					{
						list.set(j, list.get(j) + temp.get(j));
					}
					else
					{
						list.set(j, temp.get(j) + Math.min(list.get(j - 1), list.get(j)));
					}
					result = Math.min(result, list.get(j));
				}
			}
			return result;
		}
		*/
	}
}
