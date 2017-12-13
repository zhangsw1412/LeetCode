package leetcode.medium;

/**
 * Created by zhangsw on 2017/12/13.
 */
public class ContainerWithMostWater
{
	class Solution
	{
		/*
		用两个指针从两端开始向中间靠拢，如果左端线段短于右端，那么左端右移，反之右端左移，知道左右两端移到中间重合，
		记录这个过程中每一次组成木桶的容积，返回其中最大的
		当左端线段L小于右端线段R时，我们把L右移，这时舍弃的是L与右端其他线段（R-1, R-2, ...）组成的木桶，
		这些木桶是没必要判断的，因为这些木桶的容积肯定都没有L和R组成的木桶容积大
		 */
		public int maxArea(int[] a)
		{
			int ans = 0, left = 0, right = a.length - 1;
			while (left < right)
			{
				ans = Math.max(ans, Math.min(a[left], a[right]) * (right - left));
				if (a[left] < a[right])
				{
					++left;
				}
				else
				{
					--right;
				}
			}
			return ans;
		}
	}
}
