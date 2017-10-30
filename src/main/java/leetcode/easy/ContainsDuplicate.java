package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangsw on 2017/10/30.
 */
public class ContainsDuplicate
{
	class Solution
	{
		public boolean containsDuplicate(int[] a)
		{
			if (a == null || a.length <= 1)
			{
				return false;
			}
			Set<Integer> set = new HashSet<>();
			for (int i = 0; i < a.length; ++i)
			{
				set.add(a[i]);
			}
			return !(set.size() == a.length);
		}
	}
}
