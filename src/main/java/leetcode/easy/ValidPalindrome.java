package leetcode.easy;

/**
 * Created by zhangsw on 2017/10/15.
 */
public class ValidPalindrome
{
	class Solution
	{
		public boolean isPalindrome(String s)
		{
			if (s == null)
			{
				return false;
			}
			int left = 0, right = s.length() - 1;
			char l, r;
			while (left < right)
			{
				while (left < s.length() && !Character.isLetterOrDigit(s.charAt(left)))
				{
					++left;
				}
				while (right >= 0 && !Character.isLetterOrDigit(s.charAt(right)))
				{
					--right;
				}

				if ((left < right))
				{
					l = s.charAt(left);
					r = s.charAt(right);
					//其实使用toLowerCase就可以将下面两个判断变成一个，进行简化
					if ((Character.isDigit(l) || Character.isDigit(r)) && l != r)
					{
						return false;
					}
					if (l != r && !(Math.abs(l - r) == 32))
					{
						return false;
					}
					++left;
					--right;
				}
			}
			return true;
		}
	}


	private Solution getSolution()
	{
		return new Solution();
	}

	public static void main(String[] args)
	{
		ValidPalindrome validPalindrome = new ValidPalindrome();
		Solution solution = validPalindrome.getSolution();
		System.out.println(solution.isPalindrome("0P"));
	}
}
