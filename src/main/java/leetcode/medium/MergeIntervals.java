package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zhangsw on 2017/12/26.
 */
public class MergeIntervals
{
	/**
	 * Definition for an interval.
	 */
	class Interval
	{
		int start, end;

		Interval()
		{
			start = 0;
			end = 0;
		}

		Interval(int s, int e)
		{
			start = s;
			end = e;
		}
	}

	class Solution
	{
		public List<Interval> merge(List<Interval> intervals)
		{
			List<Interval> list = new ArrayList<>();
			if (intervals == null || intervals.size() == 0)
			{
				return list;
			}
			Collections.sort(intervals, Comparator.comparingInt(o -> o.start));
			int start, end;
			for (int i = 0; i < intervals.size(); i++)
			{
				start = intervals.get(i).start;
				end = intervals.get(i).end;
				while (i < intervals.size() - 1 && end >= intervals.get(i + 1).start)
				{
					++i;
					end = Math.max(end, intervals.get(i).end);
				}
				list.add(new Interval(start, end));
			}
			return list;
		}
	}
}
