package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangsw on 2017/11/14.
 */
public class FizzBuzz
{
	class Solution
	{
		public List<String> fizzBuzz(int a)
		{
			List<String> result = new ArrayList<>();
			for (int i = 1; i <= a; ++i)
			{
				if (i % 15 == 0)
				{
					result.add("FizzBuzz");
				}
				else if (i % 5 == 0)
				{
					result.add("Buzz");
				}
				else if (i % 3 == 0)
				{
					result.add("Fizz");
				}
				else
				{
					result.add(i + "");
				}
			}
			return result;
		}
	}
}
