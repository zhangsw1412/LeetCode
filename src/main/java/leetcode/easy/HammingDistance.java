package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/22.
 */
public class HammingDistance
{
	class Solution
	{
		public int hammingDistance(int a, int b)
		{
			return Integer.bitCount((a ^ b));
		}
	}
}
