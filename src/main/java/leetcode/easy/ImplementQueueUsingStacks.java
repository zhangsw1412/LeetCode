package leetcode.easy;

import java.util.Stack;

/**
 * Created by zhangsw on 2017/10/31.
 */
public class ImplementQueueUsingStacks
{
	class MyQueue
	{
		private Stack<Integer> stack, temp;

		public MyQueue()
		{
			this.stack = new Stack<>();
			this.temp = new Stack<>();
		}

		public void push(int x)
		{
			this.stack.push(x);
		}

		public int pop()
		{
			this.peek();
			return this.temp.pop();
		}

		public int peek()
		{
			if (this.temp.isEmpty())
			{
				while (!this.stack.isEmpty())
				{
					this.temp.push(this.stack.pop());
				}
			}
			return this.temp.peek();
		}

		public boolean empty()
		{
			return this.stack.isEmpty() && this.temp.isEmpty();
		}
	}
}
