package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhangsw on 2018/3/21.
 */
public class CourseSchedule
{
	class Solution
	{
		/*
		使用BFS实现，定义二维数组graph来表示这个有向图，一维数组in来表示每个顶点的入度。
		开始先根据输入来建立这个有向图，并将入度数组也初始化好。
		然后定义一个queue变量，将所有入度为0的点放入队列中，然后开始遍历队列，
		从graph里遍历其连接的点，每到达一个新节点，将其入度减一，
		如果此时该点入度为0，则放入队列末尾。直到遍历完队列中所有的值，
		若此时还有节点的入度不为0，则说明环存在，返回false，反之则返回true
		 */
		public boolean canFinish(int numCourses, int[][] prerequisites)
		{
			if (prerequisites == null || prerequisites.length == 0)
			{
				return true;
			}

			int[][] graph = new int[numCourses][numCourses];
			int[] indegree = new int[numCourses];

			for (int[] prerequisite : prerequisites)
			{
				if (graph[prerequisite[0]][prerequisite[1]] == 0)//防止一条边重复出现
				{
					++indegree[prerequisite[1]];
				}
				graph[prerequisite[0]][prerequisite[1]] = 1;
			}

			Queue<Integer> queue = new LinkedList<>();
			for (int i = 0; i < indegree.length; i++)
			{
				if (indegree[i] == 0)
				{
					queue.offer(i);
				}
			}

			int count = 0;
			while (!queue.isEmpty())
			{
				++count;
				int temp = queue.poll();
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
			return count == numCourses;
		}

		/*
		深度优先遍历
		 */
		/*
		public boolean canFinish(int numCourses, int[][] prerequisites)
		{
			ArrayList[] graph = new ArrayList[numCourses];
			for (int i = 0; i < numCourses; i++)
			{
				graph[i] = new ArrayList();
			}

			boolean[] visited = new boolean[numCourses];
			for (int i = 0; i < prerequisites.length; i++)
			{
				graph[prerequisites[i][1]].add(prerequisites[i][0]);
			}

			for (int i = 0; i < numCourses; i++)
			{
				if (!dfs(graph, visited, i))
				{
					return false;
				}
			}
			return true;
		}

		private boolean dfs(ArrayList[] graph, boolean[] visited, int course)
		{
			if (visited[course])
			{
				return false;
			}
			else
			{
				visited[course] = true;
			}
			;

			for (int i = 0; i < graph[course].size(); i++)
			{
				if (!dfs(graph, visited, (int) graph[course].get(i)))
				{
					return false;
				}
			}
			visited[course] = false;
			return true;
		}
		*/
	}
}
