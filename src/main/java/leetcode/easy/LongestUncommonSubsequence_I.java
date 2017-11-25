package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/25.
 */
public class LongestUncommonSubsequence_I
{
	class Solution
	{
		public int findLUSlength(String a, String b)
		{
			return a.equals(b) ? -1 : Math.max(a.length(), b.length());
		}
	}
}
