package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangsw on 2017/9/17.
 */
public class TwoSum
{
	class Solution
	{
		//自己写的第一个版本
		/*
		public int[] twoSum(int[] nums, int target)
		{
			int arrayLength = nums.length;
			int[] result = new int[2];

			for (int i = 0; i < arrayLength; ++i)
			{
				result[0] = i;
				for (int j = i + 1; j < arrayLength; ++j)
				{
					if ((nums[i] + nums[j]) == target)
					{
						result[1] = j;
						return result;
					}
				}
			}
			return null;
		}
		*/

		//两次遍历的哈希表
		/*
		public int[] twoSum(int[] nums, int target)
		{
			Map<Integer, Integer> numMap = new HashMap<>();
			for (int i = 0; i < nums.length; ++i)
			{
				numMap.put(nums[i], i);
			}
			int difference;
			for (int i = 0; i < nums.length; ++i)
			{
				difference = target - nums[i];
				if (numMap.containsKey(difference) && (numMap.get(difference) != i))
				{
					return new int[]{i, numMap.get(difference)};
				}
			}
			throw new IllegalArgumentException("No two sum solution");
		}
		*/

		//一次遍历的哈希表，一边插入一边回溯寻找是否有匹配
		public int[] twoSum(int[] nums, int target)
		{
			Map<Integer, Integer> numMap = new HashMap<>();
			int difference;
			for (int i = 0; i < nums.length; ++i)
			{
				difference = target - nums[i];
				if (numMap.containsKey(difference) && (numMap.get(difference) != i))
				{
					return new int[]{i, numMap.get(difference)};
				}
				numMap.put(nums[i], i);
			}
			throw new IllegalArgumentException("No two sum solution");
		}
	}

	public Solution getSolution()
	{
		return new Solution();
	}

	public static void main(String[] args)
	{
		TwoSum twoSum=new TwoSum();
		Solution solution = twoSum.getSolution();
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		int[] result;

		result = solution.twoSum(nums, target);
		System.out.print(Arrays.toString(result));
	}
}