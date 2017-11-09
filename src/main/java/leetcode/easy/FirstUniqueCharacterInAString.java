package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/9.
 */
public class FirstUniqueCharacterInAString
{
	class Solution
	{
		public int firstUniqChar(String s)
		{
			for (int i = 0, len = s.length(); i < len; ++i)
			{
				if (s.lastIndexOf(s.charAt(i)) == s.indexOf(s.charAt(i)))
				{
					return i;
				}
			}
			return -1;
		}
	}
}
