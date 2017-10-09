package leetcode.easy;

import java.util.Arrays;

/**
 * Created by zhangsw on 2017/9/19.
 */
public class LongestCommonPrefix
{
	class Solution
	{
		//先将字符串数组排序，再比较
		public String longestCommonPrefix(String[] strs)
		{
			StringBuilder stringBuilder = new StringBuilder();
			if (strs != null && strs.length > 0)
			{
				Arrays.sort(strs);
				char[] first = strs[0].toCharArray();
				char[] last = strs[strs.length - 1].toCharArray();
				for (int i = 0; i < first.length; ++i)
				{
					if (last[i] == first[i])
					{
						stringBuilder.append(first[i]);
					}
					else
					{
						return stringBuilder.toString();
					}
				}
			}
			return stringBuilder.toString();
		}
		//取第一个字符串作为参照，不停地匹配和缩短它
		/*
		public String longestCommonPrefix(String[] strs)
		{
			if (strs == null || strs.length == 0)
			{
				return "";
			}
			String result = strs[0];
			for (int i = 1; i < strs.length; ++i)
			{
				while (strs[i].indexOf(result) != 0)
				{
					result = result.substring(0, result.length() - 1);
				}
			}
			return result;
		}
		*/
	}
}
