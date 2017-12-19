package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangsw on 2017/12/19.
 */
public class CombinationSum_II
{
	class Solution
	{
		public List<List<Integer>> combinationSum2(int[] c, int target)
		{
			List<List<Integer>> list = new ArrayList<>();
			Arrays.sort(c);
			backtrack(list, new ArrayList<>(), c, target, 0);
			return list;
		}

		private void backtrack(List<List<Integer>> list, List<Integer> temp, int[] c, int remain, int start)
		{
			if (remain < 0)
			{
				return;
			}
			else if (remain == 0)
			{
				list.add(new ArrayList<>(temp));
			}
			else
			{
				for (int i = start; i < c.length; i++)
				{
					if (i > start && c[i - 1] == c[i])
					{
						continue;
					}
					temp.add(c[i]);
					backtrack(list, temp, c, remain - c[i], i + 1);
					temp.remove(temp.size() - 1);
				}
			}
		}
	}
}
