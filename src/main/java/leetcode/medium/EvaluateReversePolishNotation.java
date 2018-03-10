package leetcode.medium;

import java.util.Stack;

/**
 * Created by zhangsw on 2018/3/10.
 */
public class EvaluateReversePolishNotation
{
	class Solution
	{
		public int evalRPN(String[] tokens)
		{
			if (tokens == null)
			{
				return 0;
			}
			Stack<Integer> stack = new Stack<>();
			String operators = "+-*/";
			for (String token : tokens)
			{
				if (!operators.contains(token))
				{
					stack.push(Integer.valueOf(token));
				}
				else
				{
					Integer a = stack.pop(), b = stack.pop();
					switch (token)
					{
						case "+":
							stack.push(b + a);
							break;
						case "-":
							stack.push(b - a);
							break;
						case "*":
							stack.push(b * a);
							break;
						case "/":
							stack.push(b / a);
							break;
					}
				}
			}
			return stack.pop();
		}
	}
}
