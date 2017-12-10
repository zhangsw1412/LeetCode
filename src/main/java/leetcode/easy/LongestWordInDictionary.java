package leetcode.easy;

import java.util.*;

/**
 * Created by zhangsw on 2017/12/10.
 */
public class LongestWordInDictionary
{
	class Solution
	{
		public String longestWord(String[] s)
		{
			Arrays.sort(s);
			Set<String> set = new HashSet<>();
			String ans = "";
			for (String str : s)
			{
				if (str.length() == 1 || set.contains(str.substring(0, str.length() - 1)))
				{
					set.add(str);
					ans = str.length() > ans.length() ? str : ans;
				}
			}
			return ans;
		}
	}
}
