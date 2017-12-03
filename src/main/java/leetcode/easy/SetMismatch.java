package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangsw on 2017/12/3.
 */
public class SetMismatch
{
	class Solution
	{
		public int[] findErrorNums(int[] a)
		{
			int missing = 0, sum = 0;
			Set<Integer> set = new HashSet<>();
			for (int i : a)
			{
				set.add(i);
				sum += i;
			}
			for (int i = 1; i <= a.length; i++)
			{
				if (set.add(i))
				{
					missing = i;
					break;
				}
			}
			return new int[]{missing + sum - (1 + a.length) * a.length / 2, missing};
		}
	}
}
