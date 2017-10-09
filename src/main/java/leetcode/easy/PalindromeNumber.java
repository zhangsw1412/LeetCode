package leetcode.easy;

/**
 * Created by zhangsw on 2017/9/18.
 */
public class PalindromeNumber
{
	class Solution
	{
		//只将数字反向一半
		public boolean isPalindrome(int x)
		{
			if ((x < 0) || (x != 0 && x % 10 == 0))
			{
				return false;
			}
			else
			{
				int revert = 0;
				while (x > revert)
				{
					revert = revert * 10 + x % 10;
					x /= 10;
				}
				return (x == revert || revert / 10 == x);
			}
		}
	}

	public Solution getSolution()
	{
		return new Solution();
	}

	public static void main(String[] agrs)
	{
		PalindromeNumber palindromeNumber = new PalindromeNumber();
		Solution solution = palindromeNumber.getSolution();
		System.out.println(solution.isPalindrome(123454321));
	}
}
