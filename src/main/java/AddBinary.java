/**
 * Created by zhangsw on 2017/9/27.
 */
public class AddBinary
{
	class Solution
	{
		public String addBinary(String a, String b)
		{
			StringBuilder stringBuilder = new StringBuilder();
			int i = a.length() - 1, j = b.length() - 1, carry = 0;
			while (i >= 0 || j >= 0 || carry == 1)
			{
				int aCurrent = i >= 0 ? a.charAt(i--) - '0' : 0;
				int bCurrent = j >= 0 ? b.charAt(j--) - '0' : 0;
				int temp = aCurrent + bCurrent + carry;
				stringBuilder.append(temp % 2);
				carry = temp / 2;
			}
			return stringBuilder.reverse().toString();
		}
		//尝试的第一个版本，但是有些测试用例的输入字符串过长，会造成parseInt抛异常
		/*
		public String addBinary(String a, String b)
		{
			int aInt = Integer.parseInt(a, 2);
			int bInt = Integer.parseInt(b, 2);
			int result = aInt + bInt;
			return Integer.toBinaryString(result);
		}
		*/
	}
}
