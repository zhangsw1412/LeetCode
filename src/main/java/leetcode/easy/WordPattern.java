package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangsw on 2017/11/4.
 */
public class WordPattern
{
	class Solution
	{
		public boolean wordPattern(String pattern, String str)
		{
			String[] tokens = str.split(" ");
			if (pattern.length() != tokens.length)
			{
				return false;
			}
			Map<Character, String> map = new HashMap<>();
			for (int i = 0, len = pattern.length(); i < len; ++i)
			{
				if (!map.containsKey(pattern.charAt(i)))
				{
					if (map.containsValue(tokens[i]))
					{
						return false;
					}
					map.put(pattern.charAt(i), tokens[i]);
				}
				else
				{
					if (!map.get(pattern.charAt(i)).equals(tokens[i]))
					{
						return false;
					}
				}
			}
			return true;
		}
	}
}
