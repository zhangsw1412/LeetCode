package leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhangsw on 2017/12/10.
 */
public class SentenceSimilarity
{
	class Solution
	{
		public boolean areSentencesSimilar(String[] a, String[] b, String[][] pairs)
		{
			if (a.length != b.length)
			{
				return false;
			}
			Map<String, Set<String>> map = new HashMap<>();
			for (String[] p : pairs)
			{
				if (!map.containsKey(p[0]))
				{
					map.put(p[0], new HashSet<>());
				}
				map.get(p[0]).add(p[1]);
			}

			for (int i = 0; i < a.length; i++)
			{
				if (!a[i].equals(b[i]) && !map.getOrDefault(a[i], new HashSet<>()).contains(b[i]) && !map
						.getOrDefault(b[i], new HashSet<>()).contains(a[i]))
				{
					return false;
				}
			}
			return true;
		}
	}
}
