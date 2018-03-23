package leetcode.medium;

import java.util.*;

/**
 * Created by zhangsw on 2018/3/23.
 */
public class CourseSchedule_II
{
	class Solution
	{
		public int[] findOrder(int numCourses, int[][] prerequisites)
		{
			List<Integer> list = new ArrayList<>();
			if (prerequisites != null && prerequisites.length != 0)
			{
				int[][] graph = new int[numCourses][numCourses];
				int[] indegree = new int[numCourses];

				for (int[] prerequisite : prerequisites)
				{
					if (graph[prerequisite[1]][prerequisite[0]] == 0)//防止一条边重复出现
					{
						++indegree[prerequisite[0]];
					}
					graph[prerequisite[1]][prerequisite[0]] = 1;
				}

				Queue<Integer> queue = new LinkedList<>();
				for (int i = 0; i < indegree.length; i++)
				{
					if (indegree[i] == 0)
					{
						queue.offer(i);
					}
				}

				while (!queue.isEmpty())
				{
					int temp = queue.poll();
					list.add(temp);
					for (int i = 0; i < graph[temp].length; i++)
					{
						if (graph[temp][i] != 0)
						{
							if (--indegree[i] == 0)
							{
								queue.offer(i);
							}
						}
					}
				}
			}
			if (list.size() != numCourses)
			{
				return new int[]{};
			}
			int[] result = new int[list.size()];
			for (int i = 0; i < list.size(); i++)
			{
				result[i] = list.get(i);
			}
			return result;
		}
	}
}
