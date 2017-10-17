package leetcode.easy;

import java.util.Stack;

/**
 * Created by zhangsw on 2017/10/17.
 */
public class MinStack
{
	private Stack<Integer> stack;
	private int min;

	public MinStack()
	{
		this.stack = new Stack<>();
		min = Integer.MAX_VALUE;
	}

	public void push(int x)
	{
		if (min >= x)
		{
			stack.push(min);
			min = x;
		}
		stack.push(x);
	}

	public void pop()
	{
		if (stack.pop() == min)
		{
			this.min = stack.pop();
		}
	}

	public int top()
	{
		return stack.peek();
	}

	public int getMin()
	{
		return this.min;
	}
}