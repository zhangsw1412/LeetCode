package leetcode.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by zhangsw on 2017/10/30.
 */
public class ImplementStackUsingQueues
{
	class MyStack
	{
		private Deque<Integer> deque;

		public MyStack()
		{
			this.deque = new LinkedList<>();
		}

		public void push(int x)
		{
			this.deque.addFirst(x);
		}

		public int pop()
		{
			return this.deque.pollFirst();
		}

		public int top()
		{
			return this.deque.peekFirst();
		}

		public boolean empty()
		{
			return this.deque.isEmpty();
		}
	}
}
