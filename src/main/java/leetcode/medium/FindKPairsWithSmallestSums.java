package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by zhangsw on 2018/7/5.
 */
public class FindKPairsWithSmallestSums
{
    class Solution
    {
        public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k)
        {
            if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            {
                return Collections.emptyList();
            }
            boolean[][] visited = new boolean[nums1.length][nums2.length];
            List<int[]> result = new ArrayList<>();
            PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]);
            priorityQueue.offer(new int[]{0, 0});
            visited[0][0] = true;
            while (!priorityQueue.isEmpty() && result.size() < k)
            {
                int[] temp = priorityQueue.poll();
                result.add(new int[]{nums1[temp[0]], nums2[temp[1]]});
                if (temp[0] + 1 < nums1.length && !visited[temp[0] + 1][temp[1]])
                {
                    priorityQueue.offer(new int[]{temp[0] + 1, temp[1]});
                    visited[temp[0] + 1][temp[1]] = true;
                }
                if (temp[1] + 1 < nums2.length && !visited[temp[0]][temp[1] + 1])
                {
                    priorityQueue.offer(new int[]{temp[0], temp[1] + 1});
                    visited[temp[0]][temp[1] + 1] = true;
                }
            }
            return result;
        }
    }
}
