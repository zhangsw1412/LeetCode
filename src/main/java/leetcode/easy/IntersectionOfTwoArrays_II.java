package leetcode.easy;

import java.util.*;

/**
 * Created by zhangsw on 2017/11/9.
 */
public class IntersectionOfTwoArrays_II
{
	class Solution
	{
		public int[] intersect(int[] a, int[] b)
		{
			List<Integer> result = new ArrayList<>();
			Map<Integer, Integer> map_a = new HashMap<>(), map_b = new HashMap<>();
			for (int temp : a)
			{
				if (!map_a.containsKey(temp))
				{
					map_a.put(temp, 1);
				}
				else
				{
					map_a.put(temp, map_a.get(temp) + 1);
				}
			}
			for (int temp : b)
			{
				if (!map_b.containsKey(temp))
				{
					map_b.put(temp, 1);
				}
				else
				{
					map_b.put(temp, map_b.get(temp) + 1);
				}
			}
			for (Map.Entry<Integer, Integer> entry : map_a.entrySet())
			{
				if (map_b.containsKey(entry.getKey()))
				{
					for (int i = 0; i < Math.max(entry.getValue(), map_b.get(entry.getKey())); ++i)
					{
						result.add(entry.getKey());
					}
				}
			}
			int[] arr = new int[result.size()];
			for (int i = 0, len = result.size(); i < len; ++i)
			{
				arr[i] = result.get(i);
			}
			return arr;
		}
	}
}
