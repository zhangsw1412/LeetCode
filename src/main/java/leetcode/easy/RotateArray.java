package leetcode.easy;

/**
 * Created by zhangsw on 2017/10/23.
 */
public class RotateArray
{
	class Solution
	{
		//自己的版本
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
