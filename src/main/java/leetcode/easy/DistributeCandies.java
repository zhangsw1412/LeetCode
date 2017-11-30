package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangsw on 2017/11/30.
 */
public class DistributeCandies
{
	class Solution
	{
		public int distributeCandies(int[] a)
		{
			Set<Integer> set = new HashSet<>();
			for (int i : a)
			{
				set.add(i);
			}
			return Math.min(set.size(), a.length / 2);
		}
	}
}
