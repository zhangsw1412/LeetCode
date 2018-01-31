package leetcode.medium;

import java.util.List;

/**
 * Created by zhangsw on 2018/1/31.
 */
public class WordBreak
{
	class Solution
	{
		public boolean wordBreak(String s, List<String> wordDict)
		{
			if (s == null || s.length() == 0)
			{
				return false;
			}
			boolean[] res = new boolean[s.length() + 1];
			res[0] = true;
			for (int i = 0; i < s.length(); i++)
			{
				StringBuilder stringBuilder = new StringBuilder(s.substring(0, i + 1));
				for (int j = 0; j <= i; j++)
				{
					if (res[j] && wordDict.contains(stringBuilder.toString()))
					{
						res[i + 1] = true;
						break;
					}
					stringBuilder.deleteCharAt(0);
				}
			}
			return res[s.length()];
		}
	}
}
