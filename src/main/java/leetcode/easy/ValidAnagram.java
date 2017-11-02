package leetcode.easy;

import java.util.Arrays;

/**
 * Created by zhangsw on 2017/11/2.
 */
public class ValidAnagram
{
	class Solution
	{
		public boolean isAnagram(String s, String t)
		{
			char[] array_s = s.toCharArray();
			char[] array_t = t.toCharArray();
			Arrays.sort(array_s);
			Arrays.sort(array_t);
			s = Arrays.toString(array_s);
			t = Arrays.toString(array_t);
			return s.equals(t);
		}
	}
}
