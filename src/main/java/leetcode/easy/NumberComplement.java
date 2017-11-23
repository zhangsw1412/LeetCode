package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/23.
 */
public class NumberComplement
{
	class Solution
	{
		public int findComplement(int a)
		{
			int result = ~a, temp = 0x80000000;
			while ((a & temp) == 0)
			{
				result = result & (~temp);
				temp >>>= 1;
			}
			return result;
		}
	}
}
