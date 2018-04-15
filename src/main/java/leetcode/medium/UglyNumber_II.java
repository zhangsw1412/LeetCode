package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhangsw on 2018/4/6.
 */
public class UglyNumber_II
{
	class Solution
	{
		public int nthUglyNumber(int n)
		{
			int counter = 1;
			int result = 1;
			Queue<Integer> l2 = new LinkedList<>();
			Queue<Integer> l3 = new LinkedList<>();
			Queue<Integer> l5 = new LinkedList<>();

			while (counter < n)
			{
				l2.offer(result * 2);
				l3.offer(result * 3);
				l5.offer(result * 5);

				result = Math.min(l2.peek(), Math.min(l3.peek(), l5.peek()));
				if (result == l2.peek())
				{
					l2.poll();
				}
				if (result == l3.peek())
				{
					l3.poll();
				}
				if (result == l5.peek())
				{
					l5.poll();
				}
				++counter;
			}
			return result;
		}
	}
}
