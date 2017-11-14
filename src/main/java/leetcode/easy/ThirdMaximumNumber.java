package leetcode.easy;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by zhangsw on 2017/11/14.
 */
public class ThirdMaximumNumber
{
	class Solution
	{
		public int thirdMax(int[] a)
		{
			Set<Integer> result = new TreeSet<>();
			for (int i : a)
			{
				result.add(i);
			}
			Integer[] res = result.toArray(new Integer[0]);
			return res.length > 2 ? res[res.length - 3] : res[res.length - 1];
		}
	}
}
