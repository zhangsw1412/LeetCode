package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/25.
 */
public class DetectCapital
{
	class Solution
	{
		public boolean detectCapitalUse(String s)
		{
			int sum = 0;
			for (char c : s.toCharArray())
			{
				if (Character.isUpperCase(c))
				{
					++sum;
				}
			}
			return (sum == 0) || (sum == s.length()) || (sum == 1 && Character.isUpperCase(s.charAt(0)));
		}

		//正则表达式一行版
		/*
		public boolean detectCapitalUse(String word)
		{
			return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
		}
		*/
	}
}
