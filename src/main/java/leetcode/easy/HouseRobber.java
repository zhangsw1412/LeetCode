package leetcode.easy;

/**
 * Created by zhangsw on 2017/10/26.
 */
public class HouseRobber
{
	class Solution
	{
		/*
		动态规划思想
		如果选择了抢劫上一个屋子，那么就不能抢劫当前的屋子，所以最大收益就是抢劫上一个屋子的收益
		如果选择抢劫当前屋子，就不能抢劫上一个屋子，所以最大收益是到上一个屋子的上一个屋子为止的最大收益，加上当前屋子里有的钱
		 */
		public int rob(int[] a)
		{
			if (a.length <= 1)
			{
				return a.length == 0 ? 0 : a[0];
			}
			int pre = a[0], current = Math.max(a[0], a[1]), temp;
			for (int i = 2; i < a.length; ++i)
			{
				temp = current;
				current = Math.max(current, pre + a[i]);
				pre = temp;
			}
			return current;
		}
	}
}
