package leetcode.medium;

/**
 * Created by zhangsw on 2018/3/12.
 */
public class FindPeakElement
{
	class Solution
	{
		/*
		由于题目中说明了局部峰值一定存在，那么实际上可以从第二个数字开始往后遍历，
		如果第二个数字比第一个数字小，说明此时第一个数字就是一个局部峰值；
		否则就往后继续遍历，现在是个递增趋势，如果此时某个数字小于前面那个数字，说明前面数字就是一个局部峰值，返回位置即可。
		如果循环结束了，说明原数组是个递增数组，返回最后一个位置即可
		 */
		public int findPeakElement(int[] a)
		{
			for (int i = 1; i < a.length; i++)
			{
				if (a[i] < a[i - 1])
				{
					return i - 1;
				}
			}
			return a.length - 1;
		}
		/*
		二分查找
		如果中间元素大于其相邻后续元素，则中间元素左侧(包含该中间元素）必包含一个局部最大值。
		如果中间元素小于其相邻后续元素，则中间元素右侧必包含一个局部最大值
		 */
		/*
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
		*/
	}
}
