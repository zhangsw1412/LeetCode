package leetcode.medium;

import java.util.PriorityQueue;

/**
 * Created by zhangsw on 2018/3/26.
 */
public class KthLargestElementInAnArray
{
	class Solution
	{
		//使用优先队列
		public int findKthLargest(int[] nums, int k)
		{
			PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k + 1);
			for (int num : nums)
			{
				priorityQueue.offer(num);
				if (priorityQueue.size() > k)
				{
					priorityQueue.poll();
				}
			}
			return priorityQueue.poll();
		}
	}
}
