package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangsw on 2017/12/22.
 */
public class Permutations_II
{
	class Solution
	{
		public List<List<Integer>> permuteUnique(int[] a)
		{
			List<List<Integer>> list = new ArrayList<>();
			Arrays.sort(a);
			backtrack(list, new ArrayList<>(), a, new boolean[a.length]);
			return list;
		}

		private void backtrack(List<List<Integer>> list, List<Integer> temp, int[] a, boolean[] used)
		{
			if (temp.size() == a.length)
			{
				list.add(new ArrayList<>(temp));
			}
			else
			{
				for (int i = 0; i < a.length; i++)
				{
					if (used[i] || (i > 0 && a[i] == a[i - 1] && !used[i - 1]))
					{
						continue;
					}
					used[i] = true;
					temp.add(a[i]);
					backtrack(list, temp, a, used);
					used[i] = false;
					temp.remove(temp.size() - 1);
				}
			}
		}
	}
}
