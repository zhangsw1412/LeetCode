package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangsw on 2017/12/13.
 */
public class ThreeSum
{
	class Solution
	{
		public List<List<Integer>> threeSum(int[] a)
		{
			List<List<Integer>> list = new ArrayList<>();
			List<Integer> temp;
			Arrays.sort(a);
			int target, left, right;
			for (int i = 0; i < a.length - 2; i++)
			{
				if (a[i] > 0)
				{
					break;
				}
				if (i > 0 && a[i - 1] == a[i])
				{
					continue;
				}
				target = 0 - a[i];
				left = i + 1;
				right = a.length - 1;
				while (left < right)
				{
					if (a[left] + a[right] == target)
					{
						temp = new ArrayList<>();
						temp.add(a[i]);
						temp.add(a[left]);
						temp.add(a[right]);
						list.add(temp);
						while (left < right && a[left + 1] == a[left])
						{
							++left;
						}
						while (left < right && a[right - 1] == a[right])
						{
							--right;
						}
						++left;
						--right;
					}
					else if (a[left] + a[right] < target)
					{
						++left;
					}
					else
					{
						--right;
					}
				}
			}
			return list;
		}
	}
}
