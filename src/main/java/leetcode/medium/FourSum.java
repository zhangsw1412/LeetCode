package leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangsw on 2017/12/14.
 */
public class FourSum
{
	class Solution
	{
		public List<List<Integer>> fourSum(int[] a, int target)
		{
			List<List<Integer>> list = new LinkedList<>();
			Arrays.sort(a);
			int left, right, sum;
			for (int i = 0; i < a.length - 3; i++)
			{
				if (a[i] + a[i + 1] + a[i + 2] + a[i + 3] > target)
				{
					break; //first candidate too large, search finished
				}
				if (a[i] + a[a.length - 1] + a[a.length - 2] + a[a.length - 3] < target)
				{
					continue; //first candidate too small
				}
				if (i > 0 && a[i] == a[i - 1])
				{
					continue;
				}
				for (int j = i + 1; j < a.length - 2; j++)
				{
					if (j > i + 1 && a[j] == a[j - 1])
					{
						continue;
					}
					left = j + 1;
					right = a.length - 1;
					while (left < right)
					{
						sum = a[i] + a[j] + a[left] + a[right];
						if (sum == target)
						{
							list.add(Arrays.asList(a[i], a[j], a[left], a[right]));
							while (left < right && a[left] == a[left + 1])
							{
								++left;
							}
							while (left < right && a[right] == a[right - 1])
							{
								--right;
							}
							++left;
							--right;
						}
						else if (sum < target)
						{
							++left;
						}
						else
						{
							--right;
						}
					}
				}
			}
			return list;
		}
	}
}
