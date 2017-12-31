package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangsw on 2017/12/31.
 */
public class Subsets_II
{
	class Solution
	{
		public List<List<Integer>> subsetsWithDup(int[] nums)
		{
			List<List<Integer>> list = new ArrayList<>();
			Arrays.sort(nums);
			backtrack(list, new ArrayList<>(), nums, 0);
			return list;
		}

		private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start)
		{
			list.add(new ArrayList<>(tempList));
			for (int i = start; i < nums.length; i++)
			{
				if (i > start && nums[i] == nums[i - 1])
				{
					continue; // skip duplicates
				}
				tempList.add(nums[i]);
				backtrack(list, tempList, nums, i + 1);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}
