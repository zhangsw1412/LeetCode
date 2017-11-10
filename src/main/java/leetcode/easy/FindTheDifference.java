package leetcode.easy;

import java.util.Arrays;

/**
 * Created by zhangsw on 2017/11/10.
 */
public class FindTheDifference
{
	class Solution
	{
		//位操作版
		public char findTheDifference(String s, String t)
		{
			int n = t.length();
			char c = t.charAt(n - 1);
			for (int i = 0; i < n - 1; ++i)
			{
				c ^= s.charAt(i);
				c ^= t.charAt(i);
			}
			return c;
		}
		//自己的版本
		/*
		public char findTheDifference(String s, String t)
		{
			char[] char_s = s.toCharArray();
			char[] char_t = t.toCharArray();
			Arrays.sort(char_s);
			Arrays.sort(char_t);
			for (int i = 0; i < char_s.length; ++i)
			{
				if (char_s[i] != char_t[i])
				{
					return char_t[i];
				}
			}
			return char_t[char_t.length - 1];
		}
		*/
	}
}
