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

		//上面写法的简洁版
		/*
		public boolean checkRecord(String s)
		{
			if (s.indexOf("A") != s.lastIndexOf("A") || s.contains("LLL"))
			{
				return false;
			}
			return true;
		}
		*/

		//正则表达式版
		/*
		public boolean checkRecord(String s)
		{
			return !s.matches(".*LLL.*|.*A.*A.*");
		}
		*/
	}
}
