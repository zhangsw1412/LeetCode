package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zhangsw on 2018/3/15.
 */
public class LargestNumber
{
	class Solution
	{
		public String largestNumber(int[] nums)
		{
			if (nums == null || nums.length == 0)
			{
				return "0";
			}
			List<String> list = new ArrayList<>(nums.length);
			for (int num : nums)
			{
				list.add(String.valueOf(num));
			}
			Collections.sort(list, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
			StringBuilder stringBuilder = new StringBuilder();
			for (String s : list)
			{
				stringBuilder.append(s);
			}
			if (stringBuilder.charAt(0) == '0')
			{
				return "0";
			}
			return stringBuilder.toString();
		}
	}
}
