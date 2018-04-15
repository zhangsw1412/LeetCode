package leetcode.medium;

/**
 * Created by zhangsw on 2018/4/14.
 */
public class FindTheDuplicateNumber
{
	class Solution
	{
		//二分法
		public int findDuplicate(int[] nums)
		{
			int min = 0, max = nums.length - 1;
			while (min <= max)
			{
				// 找到中间那个数
				int mid = min + (max - min) / 2;
				int cnt = 0;
				// 计算总数组中有多少个数小于等于中间数
				for (int i = 0; i < nums.length; i++)
				{
					if (nums[i] <= mid)
					{
						cnt++;
					}
				}
				// 如果小于等于中间数的数量大于中间数，说明前半部分必有重复
				if (cnt > mid)
				{
					max = mid - 1;
					// 否则后半部分必有重复
				}
				else
				{
					min = mid + 1;
				}
			}
			return min;
		}

		//快慢指针法，和找有环单链表的环路起点那个题一个思路
		/*
		public int findDuplicate(int[] nums)
		{
			if (nums.length > 1)
			{
				int slow = nums[0];
				int fast = nums[nums[0]];
				while (slow != fast)
				{
					slow = nums[slow];
					fast = nums[nums[fast]];
				}

				fast = 0;
				while (fast != slow)
				{
					fast = nums[fast];
					slow = nums[slow];
				}
				return slow;
			}
			return -1;
		}
		*/
	}
}
