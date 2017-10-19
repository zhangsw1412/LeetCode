package leetcode.easy;

import java.util.Arrays;

/**
 * Created by zhangsw on 2017/10/19.
 */
public class MajorityElement
{
	class Solution
	{
		//Moore voting algorithm
		public int majorityElement(int[] a)
		{
			int counter = 0, majority = a[0];
			for (int i = 0; i < a.length; ++i)
			{
				if (counter == 0)
				{
					majority = a[i];
					++counter;
				}
				else
				{
					counter += (a[i] == majority) ? 1 : -1;
				}
			}
			return majority;
		}
		//这种写法有点偷懒
		/*
		public int majorityElement(int[] a)
		{
			Arrays.sort(a);
			return a[a.length / 2];
		}
		*/
	}
}
