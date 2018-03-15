package leetcode.medium;

import java.util.*;

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

		//三行版，没看懂
		/*
		public String largestNumber(int[] num)
		{
			String[] array = Arrays.stream(num).mapToObj(String::valueOf).toArray(String[]::new);
			Arrays.sort(array, (String s1, String s2) -> (s2 + s1).compareTo(s1 + s2));
			return Arrays.stream(array).reduce((x, y) -> x.equals("0") ? y : x + y).get();
		}
		*/
	}
}
