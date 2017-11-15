package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/15.
 */
public class NumberOfSegmentsInAString
{
	class Solution
	{
		public int countSegments(String s)
		{
			s = s.replaceAll("\\s+", " ");
			return s.trim().length() == 0 ? 0 : s.trim().split(" ").length;
		}
	}
}
