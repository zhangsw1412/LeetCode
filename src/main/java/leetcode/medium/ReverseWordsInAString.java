package leetcode.medium;

/**
 * Created by zhangsw on 2018/3/10.
 */
public class ReverseWordsInAString
{
	class Solution
	{
		public String reverseWords(String s)
		{
			if (s == null || s.length() == 0)
			{
				return s;
			}
			String[] tokens = s.trim().split("\\s+");
			String separator = "";
			StringBuilder stringBuilder = new StringBuilder();
			for (int i = tokens.length - 1; i >= 0; i--)
			{
				stringBuilder.append(separator + tokens[i]);
				separator = " ";
			}
			return stringBuilder.toString();
		}
	}
}
