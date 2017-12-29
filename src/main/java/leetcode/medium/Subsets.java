package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangsw on 2017/12/29.
 */
public class Subsets
{
	class Solution
	{
		public List<List<Integer>> subsets(int[] a)
		{
			List<List<Integer>> list = new ArrayList<>();
			backtrack(list, new ArrayList<>(), a, 0);
			return list;
		}

		private void backtrack(List<List<Integer>> list, List<Integer> temp, int[] a, int start)
		{
			list.add(new ArrayList<>(temp));
			if (a == null)
			{
				return;
			}
			for (int i = start; i < a.length; i++)
			{
				temp.add(a[i]);
				backtrack(list, temp, a, i + 1);
				temp.remove(temp.size() - 1);
			}
		}
	}
}
