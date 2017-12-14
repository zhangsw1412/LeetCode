package leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangsw on 2017/12/14.
 */
public class LetterCombinationsOfAPhoneNumber
{
	class Solution
	{
		public List<String> letterCombinations(String s)
		{
			String[] num = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
			List<String> list = new LinkedList<>();
			if (s != null && s.length() > 0)
			{
				helper(s, 0, new StringBuilder(), num, list);
			}
			return list;
		}

		private void helper(String s, int index, StringBuilder stringBuilder, String[] num, List<String> list)
		{
			if (index == s.length())
			{

				list.add(stringBuilder.toString());
			}
			else
			{
				for (char c : num[s.charAt(index) - '0'].toCharArray())
				{
					stringBuilder.append(c);
					helper(s, index + 1, stringBuilder, num, list);
					stringBuilder.deleteCharAt(stringBuilder.length() - 1);
				}
			}
		}
	}
}
