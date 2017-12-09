package leetcode.easy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by zhangsw on 2017/12/9.
 */
public class DegreeOfAnArray
{
	class Solution
	{
		public int findShortestSubArray(int[] a)
		{
			int length = a.length, counter = 0;
			Map<Integer, Integer> map = new HashMap<>();
			for (int i : a)
			{
				map.put(i, map.getOrDefault(i, 0) + 1);
				counter = Math.max(counter, map.get(i));
			}
			List<Integer> list = IntStream.of(a).boxed().collect(Collectors.toList());
			for (Map.Entry<Integer, Integer> entry : map.entrySet())
			{
				if (entry.getValue() == counter)
				{
					length = Math.min(length, list.lastIndexOf(entry.getKey()) - list.indexOf(entry.getKey()) + 1);
				}
			}
			return length;
		}
	}
}
