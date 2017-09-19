import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by zhangsw on 2017/9/19.
 */
public class ValidParentheses
{
	class Solution
	{
		//一种很巧妙的思路
		public boolean isValid(String s)
		{
			if (s.length() % 2 == 1)
			{
				return false;
			}
			Stack<Character> stack = new Stack<>();
			char[] chars = s.toCharArray();
			for (char c : chars)
			{
				if (c == '(')
				{
					stack.push(')');
				}
				else if (c == '[')
				{
					stack.push(']');
				}
				else if (c == '{')
				{
					stack.push('}');
				}
				else if(stack.isEmpty() || (c != stack.pop()))
				{
					return false;
				}
			}
			return stack.isEmpty();
		}
		//自己完成的版本
		/*
		public boolean isValid(String s)
		{
			if (s.length() % 2 == 1)
			{
				return false;
			}
			Stack<Character> stack = new Stack<>();
			Map<Character, Character> map = new HashMap<>();
			map.put(')', '(');
			map.put(']', '[');
			map.put('}', '{');
			char[] chars = s.toCharArray();
			for (int i = 0; i < chars.length; ++i)
			{
				if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{')
				{
					stack.push(chars[i]);
				}
				else
				{
					if ((!stack.empty()) && (map.get(chars[i]) != stack.pop()))
					{
						return false;
					}
				}
			}
			return stack.empty() ? true : false;
		}
		*/
	}
}
