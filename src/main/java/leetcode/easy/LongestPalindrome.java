package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/14.
 */
public class LongestPalindrome
{
	class Solution
	{
		public int longestPalindrome(String s)
		{
			int[] a = new int[128];
			for (char c : s.toCharArray())
			{
				++a[c];
			}
			int odd = 0;
			for (int i : a)
			{
				odd += (i % 2 == 1) ? 1 : 0;
			}
			return (odd > 0) ? s.length() - odd + 1 : s.length();
		}
	}
}
