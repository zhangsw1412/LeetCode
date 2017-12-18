package leetcode.medium;

/**
 * Created by zhangsw on 2017/12/18.
 */
public class NextPermutation
{
	class Solution
	{
		public void nextPermutation(int[] a)
		{
			if (a == null || a.length < 2)
			{
				return;
			}
			int pos = a.length - 2;
			while (pos >= 0 && a[pos] >= a[pos + 1])
			{
				--pos;
			}
			if (pos >= 0)
			{
				int j = pos + 1;
				while (j < a.length && a[j] > a[pos])
				{
					++j;
				}
				--j;
				int temp = a[j];
				a[j] = a[pos];
				a[pos] = temp;
			}
			reverse(a, pos + 1);
		}

		private void reverse(int[] a, int left)
		{
			int l = left, r = a.length - 1, temp;
			while (l < r)
			{
				temp = a[l];
				a[l] = a[r];
				a[r] = temp;
				--r;
				++l;
			}
		}

		//简洁写法
		/*
		public void nextPermutation(int[] A)
		{
			if (A == null || A.length <= 1)
			{
				return;
			}
			int i = A.length - 2;
			while (i >= 0 && A[i] >= A[i + 1])
			{
				i--; // Find 1st id i that breaks descending order
			}
			if (i >= 0)
			{                           // If not entirely descending
				int j = A.length - 1;              // Start from the end
				while (A[j] <= A[i])
				{
					j--;           // Find rightmost first larger id j
				}
				swap(A, i, j);                     // Switch i and j
			}
			reverse(A, i + 1, A.length - 1);       // Reverse the descending sequence
		}

		public void swap(int[] A, int i, int j)
		{
			int tmp = A[i];
			A[i] = A[j];
			A[j] = tmp;
		}

		public void reverse(int[] A, int i, int j)
		{
			while (i < j)
			{
				swap(A, i++, j--);
			}
		}
		*/
	}
}
