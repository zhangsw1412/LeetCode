package leetcode.medium;

/**
 * Created by zhangsw on 2018/1/25.
 */
public class GasStation
{
	class Solution
	{
		public int canCompleteCircuit(int[] gas, int[] cost)
		{
			if (gas == null || cost == null || gas.length == 0 || cost.length == 0 || gas.length != cost.length)
			{
				return -1;
			}
			int sum = 0, total = 0, start = 0;
			for (int i = 0; i < gas.length; i++)
			{
				total += (gas[i] - cost[i]);
				if (sum < 0)
				{
					sum = gas[i] - cost[i];
					start = i;
				}
				else
				{
					sum += gas[i] - cost[i];
				}
			}
			return total < 0 ? -1 : start;
		}
	}
}
