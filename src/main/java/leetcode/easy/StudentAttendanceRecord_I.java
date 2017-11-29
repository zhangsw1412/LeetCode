package leetcode.easy;

/**
 * Created by zhangsw on 2017/11/29.
 */
public class StudentAttendanceRecord_I
{
	class Solution
	{
		public boolean checkRecord(String s)
		{
			return s.split("A").length < 3 && s.indexOf("AA") == -1 && s.indexOf("LLL") == -1;
		}
	}
}
