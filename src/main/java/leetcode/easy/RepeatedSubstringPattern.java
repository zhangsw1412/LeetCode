package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/21.
 */
public class RepeatedSubstringPattern
{
	class Solution
	{
		public boolean repeatedSubstringPattern(String s)
		{
			int len = s.length();
			String temp;
			StringBuilder stringBuilder;
			for (int i = 1; i <= len / 2; ++i)
			{
				if (len % i == 0)
				{
					temp = s.substring(0, i);
					stringBuilder = new StringBuilder();
					for (int j = 1; j <= (len / i); ++j)
					{
						stringBuilder.append(temp);
					}
					if (stringBuilder.toString().equals(s))
					{
						return true;
					}
				}
			}
			return false;
		}
	}

	public Solution getSolution()
	{
		return new Solution();
	}

	public static void main(String[] args)
	{
		RepeatedSubstringPattern repeatedSubstringPattern = new RepeatedSubstringPattern();
		Solution solution = repeatedSubstringPattern.getSolution();
		System.out.print(solution.repeatedSubstringPattern("ababab"));
	}
}
