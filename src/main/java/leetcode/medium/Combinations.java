package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangsw on 2017/12/29.
 */
public class Combinations
{
	class Solution
	{
		public List<List<Integer>> combine(int n, int k)
		{
			List<List<Integer>> list = new ArrayList<>();
			if (n <= 0 || k <= 0)
			{
				return list;
			}
			backtrack(list, new ArrayList<>(), 1, n, k);
			return list;
		}

		private void backtrack(List<List<Integer>> list, List<Integer> temp, int counter, int n, int k)
		{
			if (k == 0)
			{
				list.add(new ArrayList<>(temp));
				return;
			}
			for (int i = counter; i <= n; i++)
			{
				temp.add(i);
				backtrack(list, temp, i + 1, n, k - 1);
				temp.remove(temp.size() - 1);
			}
		}
	}
}
