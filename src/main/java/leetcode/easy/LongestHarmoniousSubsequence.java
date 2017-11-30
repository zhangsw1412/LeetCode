package leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhangsw on 2017/11/30.
 */
public class LongestHarmoniousSubsequence
{
	class Solution
	{
		public int findLHS(int[] a)
		{
			Map<Integer, Integer> map = new HashMap<>();
			for (int i : a)
			{
				map.put(i, map.getOrDefault(i, 0) + 1);
			}
			int result = 0;
			for (Map.Entry<Integer, Integer> entry : map.entrySet())
			{
				result = Math.max(result, (map.containsKey(entry.getKey() + 1) ? entry.getValue() + map
						.get(entry.getKey() + 1) : 0));
			}
			return result;
		}
	}
}
