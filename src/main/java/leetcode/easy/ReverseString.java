package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/6.
 */
public class ReverseString
{
	class Solution
	{
		public String reverseString(String a)
		{
			return new StringBuilder(a).reverse().toString();
		}
	}
}
