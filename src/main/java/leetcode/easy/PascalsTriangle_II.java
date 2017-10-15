package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangsw on 2017/10/15.
 */
public class PascalsTriangle_II
{
	class Solution
	{
		public List<Integer> getRow(int n)
		{
			List<Integer> result = new ArrayList<>();
			for (int i = 0; i <= n; ++i)
			{
				result.add(0, 1);
				for (int j = 1, len = result.size() - 1; j < len; ++j)
				{
					result.set(j, result.get(j) + result.get(j + 1));
				}
			}
			return result;
		}
	}
}
