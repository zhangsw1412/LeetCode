package leetcode.medium;

/**
 * Created by zhangsw on 2017/12/12.
 */
public class LongestPalindromicSubstring
{
	class Solution
	{
		//动态规划
		public String longestPalindrome(String s)
		{
			boolean[][] dp = new boolean[s.length()][s.length()];
			char[] c = s.toCharArray();
			int left = 0, right = 0, length = 0;
			for (int i = 0; i < c.length; ++i)
			{
				for (int j = 0; j < i; ++j)
				{
					dp[j][i] = (c[j] == c[i] && (i - j < 2 || dp[j + 1][i - 1]));
					if (dp[j][i] && length < i - j + 1)
					{
						length = i - j + 1;
						left = j;
						right = i;
					}
				}
				dp[i][i] = true;
			}
			return s.substring(left, right + 1);
		}

		//直接法
		/*
		private int lo, maxLen;

		public String longestPalindrome(String s)
		{
			int len = s.length();
			if (len < 2)
			{
				return s;
			}

			for (int i = 0; i < len - 1; i++)
			{
				extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
				extendPalindrome(s, i, i + 1); //assume even length.
			}
			return s.substring(lo, lo + maxLen);
		}

		private void extendPalindrome(String s, int j, int k)
		{
			while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k))
			{
				j--;
				k++;
			}
			if (maxLen < k - j - 1)
			{
				lo = j + 1;
				maxLen = k - j - 1;
			}
		}
		*/
	}
}
