package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/5.
 */
public class PowerOfThree
{
	class Solution
	{
		/*
		这个题目要求不用循环或者递归的方式，所以投机取巧一下
		在int范围内，最大的3的次方数是3^19=1162261467
		所以如果一个数是3的次方数，那么一定得能整除1162261467
		 */
		public boolean isPowerOfThree(int n)
		{
			return (n > 0) && (1162261467 % n == 0);
		}
	}
}
