package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangsw on 2017/11/16.
 */
public class FindAllAnagramsInAString
{
	class Solution
	{
		//滑动窗口的方法
		public List<Integer> findAnagrams(String s, String p)
		{
			List<Integer> result = new ArrayList<>();
			if (s == null || p == null || s.length() == 0 || p.length() == 0)
			{
				return result;
			}
			int[] map = new int[256];
			for (char c : p.toCharArray())
			{
				map[c]++;
			}
			int left = 0, right = 0, count = p.length();
			while (right < s.length())
			{
				if (map[s.charAt(right++)]-- >= 1)
				{
					--count;
				}
				if (count == 0)
				{
					result.add(left);
				}
				if (((right - left) == p.length()) && (map[s.charAt(left++)]++ >= 0))
				{
					++count;
				}
			}
			return result;
		}
	}
}
