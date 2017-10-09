package leetcode.easy;

/**
 * Created by zhangsw on 2017/9/26.
 */
public class LengthOfLastWord
{
	class Solution
	{
		public int lengthOfLastWord(String s)
		{
			if (s == null || s.length() == 0)
			{
				return 0;
			}
			String[] strings = s.trim().split(" ");
			return strings == null ? 0 : strings[strings.length - 1].length();

			//一个强大的版本，只要一句话就行
			//return s.trim().length()-s.trim().lastIndexOf(" ")-1;
		}
	}
}
