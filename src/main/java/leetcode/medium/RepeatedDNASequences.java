package leetcode.medium;

import java.util.*;

/**
 * Created by zhangsw on 2018/3/15.
 */
public class RepeatedDNASequences
{
	class Soluton
	{
		public List<String> findRepeatedDnaSequences(String s)
		{
			List<String> result = new ArrayList<>();
			if (s == null || s.length() == 0)
			{
				return result;
			}

			Map<Character, Integer> map = new HashMap<>();
			map.put('A', 0);
			map.put('C', 1);
			map.put('G', 2);
			map.put('T', 3);

			Set<Integer> set = new HashSet<>();
			Set<Integer> repeat = new HashSet<>();
			int mask = 0xfffff;
			int val = 0;
			// Use a sliding window to check every 10-bit substring
			for (int i = 0; i < s.length(); i++)
			{
				val = (val << 2 | map.get(s.charAt(i))) & mask;
				if (i < 9)
				{
					continue;
				}
				// Check each 10-bit substring
				if (!set.add(val) && repeat.add(val))
				{
					// If first come out duplicates, then add to list
					result.add(s.substring(i - 9, i + 1));
				}
			}
			return result;
		}
	}
}
