package leetcode.medium;

import static java.util.stream.Collectors.toList;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * Created by zhangsw on 2018/7/3.
 */
public class TopKFrequentElements
{
    class Solution
    {
        //优先队列
        public List<Integer> topKFrequent(int[] nums, int k)
        {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int num : nums)
            {
                hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
            }
            PriorityQueue<Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(k + 1, Comparator.comparingInt(Entry::getValue));
            for (Entry<Integer, Integer> entry : hashMap.entrySet())
            {
                priorityQueue.offer(entry);
                if (priorityQueue.size() > k)
                {
                    priorityQueue.poll();
                }
            }
            return priorityQueue.stream().map(Entry::getKey).collect(toList());
        }
    }
}
