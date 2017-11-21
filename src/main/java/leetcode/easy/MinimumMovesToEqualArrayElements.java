package leetcode.easy;

import java.util.stream.IntStream;

/**
 * Created by zhangsw on 2017/11/21.
 */
public class MinimumMovesToEqualArrayElements
{
	class Solution
	{
		/*
		这道题给了我们一个长度为n的数组，说是我们每次可以对n-1个数字同时加1，
		问最少需要多少次这样的操作才能让数组中所有的数字相等。那么我们想，
		为了快速的缩小差距，该选择哪些数字加1呢，不难看出每次需要给除了数组最大值的所有数字加1，
		这样能快速的到达平衡状态。但是这道题如果我们老老实实的每次找出最大值，然后给其他数字加1，
		再判断是否平衡，思路是正确，但是OJ不答应。正确的解法相当的巧妙，需要换一个角度来看问题，
		其实给n-1个数字加1，效果等同于给那个未被选中的数字减1，比如数组[1，2，3],
		给除去最大值的其他数字加1，变为[2，3，3]，我们全体减1，并不影响数字间相对差异，
		变为[1，2，2]，这个结果其实就是原始数组的最大值3自减1，那么问题也可能转化为，
		将所有数字都减小到最小值，这样难度就大大降低了，我们只要先找到最小值，
		然后累加每个数跟最小值之间的差值即可
		 */
		public int minMoves(int[] a)
		{
			int min = Integer.MAX_VALUE, sum = 0;
			for (int i : a)
			{
				min = (i < min) ? i : min;
			}
			for (int i : a)
			{
				sum += i - min;
			}
			return sum;
		}

		//一行版
		/*
		public int minMoves(int[] nums)
		{
			return IntStream.of(nums).sum() - nums.length * IntStream.of(nums).min().getAsInt();
		}
		*/
	}
}
