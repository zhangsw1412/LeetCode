import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangsw on 2017/9/19.
 */
public class RomanToInteger
{
	class Solution
	{
		//第一，如果当前数字是最后一个数字，或者之后的数字比它小的话，则加上当前数字；第二，其他情况则减去这个数字
		public int romanToInt(String s)
		{
			Map<Character, Integer> map = new HashMap<>();
			map.put('I', 1);
			map.put('V', 5);
			map.put('X', 10);
			map.put('L', 50);
			map.put('C', 100);
			map.put('D', 500);
			map.put('M', 1000);
			int temp, result = 0;
			for (int i = 0; i < s.length(); ++i)
			{
				temp = map.get(s.charAt(i));
				if (i == (s.length() - 1) || (temp >= map.get(s.charAt(i + 1))))
				{
					result += temp;
				}
				else
				{
					result -= temp;
				}
			}
			return result;
		}
	}
}
