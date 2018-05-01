package leetcode.medium;

import java.util.*;

/**
 * Created by zhangsw on 2018/5/1.
 */
public class MinimumHeightTrees
{
	class Solution
	{
		/*
		先计算每个点的degree，然后将degree为1的点放入list或者queue中进行计算，
		把这些点从neighbours中去除，然后计算接下来degree = 1的点。最后剩下1 - 2个点就是新的root
		 */
		public List<Integer> findMinHeightTrees(int n, int[][] edges)
		{
			if (n <= 1)
			{
				return Collections.singletonList(0);
			}
			Map<Integer, Set<Integer>> graph = new HashMap<>();
			for (int i = 0; i < n; i++)
			{
				graph.put(i, new HashSet<>());
			}
			for (int[] edge : edges)
			{
				graph.get(edge[0]).add(edge[1]);
				graph.get(edge[1]).add(edge[0]);
			}
			Queue<Integer> queue = new LinkedList<>();
			for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet())
			{
				if (entry.getValue().size() == 1)
				{
					queue.offer(entry.getKey());
				}
			}
			while (n > 2)
			{
				int length = queue.size();
				n -= length;
				for (int i = 0; i < length; i++)
				{
					int leaf = queue.poll();
					Set<Integer> neighbors = graph.get(leaf);
					for (Integer neighbor : neighbors)
					{
						graph.get(leaf).remove(neighbor);
						graph.get(neighbor).remove(leaf);
						if (graph.get(neighbor).size() == 1)
						{
							queue.offer(neighbor);
						}
					}
				}
			}
			return (LinkedList) queue;
		}
	}
}
