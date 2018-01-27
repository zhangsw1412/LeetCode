package leetcode.medium;

/**
 * Created by zhangsw on 2018/1/27.
 */
public class SingleNumber_II
{
	class Solution
	{
		/*
		利用三个变量分别保存各个二进制位上 1 出现一次、两次、三次的分布情况，最后只需返回变量一就行了
		每次循环先计算 twos，即出现两次的 1 的分布，然后计算出现一次的 1 的分布，接着 二者进行与操作得到出现三次的 1 的分布情况，
		然后对 threes 取反，再与 ones、twos进行与操作，这样的目的是将出现了三次的位置清零
		 */
		public int singleNumber(int[] a)
		{
			int one = 0, two = 0, three = 0;
			for (int i : a)
			{
				two |= one & i;
				one ^= i;
				three = one & two;
				one &= ~three;
				two &= ~three;
			}
			return one;
		}
	}
}
