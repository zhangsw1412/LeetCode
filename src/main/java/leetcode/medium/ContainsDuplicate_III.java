package leetcode.medium;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by zhangsw on 2018/3/27.
 */
public class ContainsDuplicate_III
{
	class Solution
	{
		/*
		维持一个长度为k的window, 每次检查新的值是否与原来窗口中的所有值的差值有小于等于t的. 如果用两个for循环会超时O(nk).
		使用treeset(backed by binary search tree) 的subSet函数,可以快速搜索. 复杂度为 O(nlogk)
		 */
		public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t)
		{
			//input check
			if (k < 1 || t < 0 || nums == null || nums.length < 2)
			{
				return false;
			}

			SortedSet<Long> set = new TreeSet<>();

			for (int j = 0; j < nums.length; j++)
			{
				SortedSet<Long> subSet = set.subSet((long) nums[j] - t, (long) nums[j] + t + 1);
				if (!subSet.isEmpty())
				{
					return true;
				}

				if (j >= k)
				{
					set.remove((long) nums[j - k]);
				}
				set.add((long) nums[j]);
			}
			return false;
		}
	}
}
