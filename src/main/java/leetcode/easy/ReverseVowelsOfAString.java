package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/7.
 */
public class ReverseVowelsOfAString
{
	class Solution
	{
		public String reverseVowels(String s)
		{
			if (s == null || s.length() <= 1)
			{
				return s;
			}
			int left = 0, right = s.length() - 1;
			String vowels = "aeiouAEIOU";
			char[] str = s.toCharArray();
			while (left < right)
			{
				while (left < right && vowels.indexOf(str[left]) == -1)
				{
					++left;
				}
				while (left < right && vowels.indexOf(str[right]) == -1)
				{
					--right;
				}
				if (left < right)
				{
					str[left] ^= str[right];
					str[right] ^= str[left];
					str[left++] ^= str[right--];
				}
			}
			return new String(str);
		}
	}
}
