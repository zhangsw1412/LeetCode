package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangsw on 2018/4/2.
 */
public class MajorityElement_II
{
	class Solution
	{
		/*
		摩尔投票法 Moore Voting
		题目中给了一条很重要的提示，让我们先考虑可能会有多少个众数，
		经过举了很多例子分析得出，任意一个数组出现次数大于n/3的众数最多有两个
		那么有了这个信息，我们使用投票法的核心是找出两个候选众数进行投票，需要两遍遍历，
		第一遍历找出两个候选众数，第二遍遍历重新投票验证这两个候选众数是否为众数即可
		 */
		public List<Integer> majorityElement(int[] a)
		{
			List<Integer> list = new ArrayList<>();
			if (a == null || a.length == 0)
			{
				return list;
			}
			int m = 0, n = 0, cm = 0, cn = 0;
			for (int i : a)
			{
				if (i == m)
				{
					++cm;
				}
				else if (i == n)
				{
					++cn;
				}
				else if (cm == 0)
				{
					m = i;
					cm = 1;
				}
				else if (cn == 0)
				{
					n = i;
					cn = 1;
				}
				else
				{
					--cm;
					--cn;
				}
			}
			cm = cn = 0;
			for (int i : a)
			{
				if (i == m)
				{
					++cm;
				}
				else if (i == n)
				{
					++cn;
				}
			}
			if (cm > a.length / 3)
			{
				list.add(m);
			}
			if (cn > a.length / 3)
			{
				list.add(n);
			}
			return list;
		}
	}
}
