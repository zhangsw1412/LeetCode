package leetcode.easy;

import java.util.*;

/**
 * Created by zhangsw on 2017/11/23.
 */
public class NextGreaterElement_I
{
	class Solution
	{
		/*
		Key observation:
		Suppose we have a decreasing sequence followed by a greater number
		For example [5, 4, 3, 2, 1, 6] then the greater number 6 is the next greater element for all previous numbers in the sequence
		We use a stack to keep a decreasing sub-sequence,
		whenever we see a number x greater than stack.peek() we pop all elements less than x and for all the popped ones,
		their next greater element is x
		For example [9, 8, 7, 3, 2, 1, 6]
		The stack will first contain [9, 8, 7, 3, 2, 1] and then we see 6 which is greater than 1 so we pop 1 2 3 whose next greater element should be 6
		这种方法比较巧妙
		 */
		public int[] nextGreaterElement(int[] findNums, int[] nums)
		{
			Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
			Stack<Integer> stack = new Stack<>();
			for (int num : nums)
			{
				while (!stack.isEmpty() && stack.peek() < num)
				{
					map.put(stack.pop(), num);
				}
				stack.push(num);
			}
			for (int i = 0; i < findNums.length; i++)
			{
				findNums[i] = map.getOrDefault(findNums[i], -1);
			}
			return findNums;
		}
		//自己的版本
		/*
		public int[] nextGreaterElement(int[] a, int[] b)
		{
			List<Integer> list = new ArrayList<>();
			int pos;
			for (int i : a)
			{
				pos = -1;
				for (int j = 0; j < b.length; ++j)
				{
					if (b[j] == i)
					{
						pos = j;
					}
				}
				while (pos < b.length && b[pos] <= i)
				{
					++pos;
				}
				list.add((pos == b.length) ? -1 : b[pos]);
			}
			int[] result = new int[list.size()];
			pos = 0;
			for (Integer i : list)
			{
				result[pos++] = i;
			}
			return result;
		}
		*/
	}
}
