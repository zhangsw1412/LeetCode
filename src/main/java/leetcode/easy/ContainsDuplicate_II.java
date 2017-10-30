package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangsw on 2017/10/30.
 */
public class ContainsDuplicate_II
{
	class Solution
	{
		public boolean containsNearbyDuplicate(int[] a, int k)
		{
			int counter = 0;
			Set<Integer> set = new HashSet<>();
			while (counter < Math.min(a.length, k))
			{
				if (!set.add(a[counter++]))
				{
					return true;
				}
			}
			while (counter < a.length)
			{
				if (!set.add(a[counter]))
				{
					return true;
				}
				set.remove(a[counter - k]);
				++counter;
			}
			return false;
		}
	}
}
