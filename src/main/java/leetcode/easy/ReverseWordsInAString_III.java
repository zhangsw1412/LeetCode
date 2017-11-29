package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/29.
 */
public class ReverseWordsInAString_III
{
	class Solution
	{
		public String reverseWords(String s)
		{
			StringBuilder stringBuilder = new StringBuilder();
			for (String a : s.split(" "))
			{
				stringBuilder.append(' ').append(new StringBuilder(a).reverse());
			}
			return stringBuilder.substring(1).toString();
		}
	}
}
