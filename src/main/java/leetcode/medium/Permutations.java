package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangsw on 2017/12/22.
 */
public class Permutations
{
	class Solution
	{
		public List<List<Integer>> permute(int[] a)
		{
			List<List<Integer>> list = new ArrayList<>();
			backtrack(list, new ArrayList<>(), a);
			return list;
		}

		private void backtrack(List<List<Integer>> list, List<Integer> temp, int[] a)
		{
			if (temp.size() == a.length)
			{
				list.add(new ArrayList<>(temp));
			}
			else
			{
				for (int i = 0; i < a.length; i++)
				{
					if (!temp.contains(a[i]))
					{
						temp.add(a[i]);
						backtrack(list, temp, a);
						temp.remove(temp.size() - 1);
					}
				}
			}
		}
	}
}
