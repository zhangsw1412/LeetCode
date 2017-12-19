package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangsw on 2017/12/19.
 */
public class CombinationSum
{
	class Solution
	{
		private List<List<Integer>> result;

		public List<List<Integer>> combinationSum(int[] c, int target)
		{
			result = new ArrayList<>();
			Arrays.sort(c);
			helper(c, new ArrayList<>(), 0, target);
			return result;
		}

		private void helper(int[] c, List<Integer> current, int start, int target)
		{
			if (target == 0)
			{
				result.add(new ArrayList<>(current));
				return;
			}
			for (int i = start; i < c.length && c[i] <= target; i++)
			{
				current.add(c[i]);
				helper(c, current, i, target - c[i]);
				current.remove(new Integer(c[i]));
			}
		}
	}
}
