package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangsw on 2018/3/27.
 */
public class CombinationSum_III
{
	class Solution
	{
		public List<List<Integer>> combinationSum3(int k, int n)
		{
			List<List<Integer>> lists = new ArrayList<>();
			if (k == 0 || n == 0)
			{
				return lists;
			}
			backtrack(k, n, new ArrayList<>(), lists, 1);
			return lists;
		}

		private void backtrack(int k, int n, List<Integer> list, List<List<Integer>> lists, int start)
		{
			if (list.size() == k)
			{
				if (n == 0)
				{
					lists.add(new ArrayList<>(list));
				}
				return;
			}
			for (int i = start; i < 10; i++)
			{
				list.add(i);
				backtrack(k, n - i, list, lists, i + 1);
				list.remove(list.size() - 1);
			}
		}
	}
}
