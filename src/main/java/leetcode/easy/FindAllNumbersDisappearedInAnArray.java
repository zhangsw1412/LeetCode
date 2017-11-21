package leetcode.easy;

import java.util.*;

/**
 * Created by zhangsw on 2017/11/21.
 */
public class FindAllNumbersDisappearedInAnArray
{
	class Solution
	{
		//自己的版本
		public List<Integer> findDisappearedNumbers(int[] a)
		{
			List<Integer> result = new ArrayList<>();
			if (a == null || a.length == 0)
			{
				return result;
			}
			Set<Integer> set = new HashSet<>();
			for (int i : a)
			{
				set.add(i);
			}
			for (int i = 1; i <= a.length; ++i)
			{
				if (!set.contains(i))
				{
					result.add(i);
				}
			}
			return result;
		}
	}
}
