package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangsw on 2017/12/11.
 */
public class LongestSubstringWithoutRepeatingCharacters
{
	class Solution
	{
		public int lengthOfLongestSubstring(String s)
		{
			if (s == null || s.length() == 0)
			{
				return 0;
			}
			int length = 0, left = 0, right = 0;
			char[] c = s.toCharArray();
			Set<Character> set = new HashSet<>();
			while (right < c.length)
			{
				if (set.add(c[right]))
				{
					length = Math.max(length, set.size());
				}
				else
				{
					while (c[left] != c[right])
					{
						set.remove(c[left++]);
					}
					++left;
				}
				++right;
			}
			return length;
		}
	}
}
