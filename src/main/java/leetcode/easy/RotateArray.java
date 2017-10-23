package leetcode.easy;

/**
 * Created by zhangsw on 2017/10/23.
 */
public class RotateArray
{
	class Solution
	{
		//一种很棒的解法，将数组翻转，然后以k为分界，两边分别翻转
		public void rotate(int[] a, int k)
		{
			k = k % a.length;
			reverse(a, 0, a.length - 1);
			reverse(a, 0, k - 1);
			reverse(a, k, a.length - 1);
		}

		private void reverse(int[] a, int left, int right)
		{
			int temp;
			while (left < right)
			{
				temp = a[left];
				a[left] = a[right];
				a[right] = temp;
				++left;
				--right;
			}
		}
		//自己的版本
		/*
		public void rotate(int[] a, int k)
		{
			int len = a.length;
			int[] b = new int[len];
			for (int i = 0; i < len; ++i)
			{
				b[(i + k) % len] = a[i];
			}
			System.arraycopy(b, 0, a, 0, len);
		}
		*/
		//这种解法的时间复杂度太高，超时了
		/*
		public void rotate(int[] a, int k)
		{
			int temp, len = a.length;
			k = k % len;
			while (k-- > 0)
			{
				temp = a[len - 1];
				for (int i = len - 1; i > 0; --i)
				{
					a[i] = a[i - 1];
				}
				a[0] = temp;
			}
		}
		*/
	}
}
