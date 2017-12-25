package leetcode.medium;

import java.util.*;

/**
 * Created by zhangsw on 2017/12/25.
 */
public class GroupAnagrams
{
	class Solution
	{
		public List<List<String>> groupAnagrams(String[] strs)
		{
			if (strs == null || strs.length == 0)
			{
				return new ArrayList<>();
			}
			Map<String, List<String>> map = new HashMap<>();
			Arrays.sort(strs);
			for (String str : strs)
			{
				char[] chars = str.toCharArray();
				Arrays.sort(chars);
				map.putIfAbsent(String.valueOf(chars), new ArrayList<>());
				map.get(String.valueOf(chars)).add(str);
			}
			return new ArrayList<>(map.values());
		}
	}
}
