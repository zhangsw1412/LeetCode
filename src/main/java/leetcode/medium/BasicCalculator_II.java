package leetcode.medium;

import java.util.Stack;

/**
 * Created by zhangsw on 2018/3/29.
 */
public class BasicCalculator_II
{
	class Solution
	{
		//栈版本
		public int calculate(String s)
		{
			int len;
			if (s == null || (len = s.length()) == 0)
			{
				return 0;
			}
			Stack<Integer> stack = new Stack<>();
			int num = 0;
			char sign = '+';
			for (int i = 0; i < len; i++)
			{
				if (Character.isDigit(s.charAt(i)))
				{
					num = num * 10 + s.charAt(i) - '0';
				}
				if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == len - 1)
				{
					if (sign == '-')
					{
						stack.push(-num);
					}
					if (sign == '+')
					{
						stack.push(num);
					}
					if (sign == '*')
					{
						stack.push(stack.pop() * num);
					}
					if (sign == '/')
					{
						stack.push(stack.pop() / num);
					}
					sign = s.charAt(i);
					num = 0;
				}
			}

			int re = 0;
			for (int i : stack)
			{
				re += i;
			}
			return re;
		}

		//迭代版
		/*
		public int calculate(String s)
		{
			if (s == null)
			{
				return 0;
			}
			s = s.trim().replaceAll(" +", "");
			int length = s.length();

			int res = 0;
			long preVal = 0; // initial preVal is 0
			char sign = '+'; // initial sign is +
			int i = 0;
			while (i < length)
			{
				long curVal = 0;
				while (i < length && (int) s.charAt(i) <= 57 && (int) s.charAt(i) >= 48)
				{ // int
					curVal = curVal * 10 + (s.charAt(i) - '0');
					i++;
				}
				if (sign == '+')
				{
					res += preVal;  // update res
					preVal = curVal;
				}
				else if (sign == '-')
				{
					res += preVal;  // update res
					preVal = -curVal;
				}
				else if (sign == '*')
				{
					preVal = preVal * curVal; // not update res, combine preVal & curVal and keep loop
				}
				else if (sign == '/')
				{
					preVal = preVal / curVal; // not update res, combine preVal & curVal and keep loop
				}
				if (i < length)
				{ // getting new sign
					sign = s.charAt(i);
					i++;
				}
			}
			res += preVal;
			return res;
		}
		*/
	}
}
