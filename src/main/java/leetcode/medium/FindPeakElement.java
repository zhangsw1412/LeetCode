package leetcode.medium;

/**
 * Created by zhangsw on 2018/3/12.
 */
public class FindPeakElement
{
	class Solution
	{
		/*
		二分查找
		如果中间元素大于其相邻后续元素，则中间元素左侧(包含该中间元素）必包含一个局部最大值。
		如果中间元素小于其相邻后续元素，则中间元素右侧必包含一个局部最大值
		 */
		public int findPeakElement(int[] a)
		{
			int left = 0, right = a.length - 1;
			while (left < right)
			{
				int mid = left + (right - left) / 2;
				if (a[mid] < a[mid + 1])
				{
					left = mid + 1;
				}
				else
				{
					right = mid;
				}
			}
			return right;
		}
	}
}
