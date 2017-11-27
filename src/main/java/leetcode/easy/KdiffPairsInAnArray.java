package leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhangsw on 2017/11/27.
 */
public class KdiffPairsInAnArray
{
	class Solution
	{
		//map解法
		/*
		public int findPairs(int[] nums, int k) {
			if (nums == null || nums.length == 0 || k < 0)   return 0;

			Map<Integer, Integer> map = new HashMap<>();
			int count = 0;
			for (int i : nums) {
				map.put(i, map.getOrDefault(i, 0) + 1);
			}

			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				if (k == 0) {
					//count how many elements in the array that appear more than twice.
					if (entry.getValue() >= 2) {
						count++;
					}
				} else {
					if (map.containsKey(entry.getKey() + k)) {
						count++;
					}
				}
			}

			return count;
		}
		*/

		//set解法，写的比较优雅
		public int findPairs(int[] nums, int k)
		{
			if (k < 0)
			{
				return 0;
			}

			Set<Integer> starters = new HashSet<Integer>();
			Set<Integer> uniqs = new HashSet<Integer>();
			for (int i = 0; i < nums.length; i++)
			{
				if (uniqs.contains(nums[i] - k))
				{
					starters.add(nums[i] - k);
				}
				if (uniqs.contains(nums[i] + k))
				{
					starters.add(nums[i]);
				}
				uniqs.add(nums[i]);
			}

			return starters.size();
		}
	}
}
