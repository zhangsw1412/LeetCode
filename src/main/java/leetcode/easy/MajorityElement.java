package leetcode.easy;

import java.util.Arrays;

/**
 * Created by zhangsw on 2017/10/19.
 */
public class MajorityElement
{
	class Solution
	{
		//这种写法有点偷懒
		public int majorityElement(int[] a)
		{
			Arrays.sort(a);
			return a[a.length / 2];
		}
	}
}
