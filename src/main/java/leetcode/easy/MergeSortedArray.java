package leetcode.easy;

/**
 * Created by zhangsw on 2017/10/9.
 */
public class MergeSortedArray
{
	class Solution
	{
		//自己写的版本
		public void merge(int[] a, int m, int[] b, int n)
		{
			int i = m - 1, j = n - 1, k = m + n - 1,tempA,tempB;
			while (i >= 0 || j >= 0)
			{
				tempA = i >= 0 ? a[i] : Integer.MIN_VALUE;
				tempB = j >= 0 ? b[j] : Integer.MIN_VALUE;
				if (tempA <= tempB)
				{
					a[k--] = b[j--];
				}
				else
				{
					a[k--] = a[i--];
				}
			}
		}
	}
}
