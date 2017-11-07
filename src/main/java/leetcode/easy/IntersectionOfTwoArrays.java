package leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zhangsw on 2017/11/7.
 */
public class IntersectionOfTwoArrays
{
	class Solution
	{
		//自己的版本
		public int[] intersection(int[] a, int[] b)
		{
			Set<Integer> result = new HashSet<>();
			Set<Integer> setA = new HashSet<>();
			int[] res;
			int count = 0;
			for (int temp : a)
			{
				setA.add(temp);
			}
			for (int temp : b)
			{
				if (setA.contains(temp))
				{
					result.add(temp);
				}
			}
			res = new int[result.size()];
			for (Integer temp : result)
			{
				res[count++] = temp;
			}
			return res;
		}
	}
}
