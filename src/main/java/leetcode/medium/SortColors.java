package leetcode.medium;

/**
 * Created by zhangsw on 2017/12/28.
 */
public class SortColors
{
	public void sortColors(int[] a)
	{
		if (a == null || a.length < 2)
		{
			return;
		}
		int red = 0, cur = 0, blue = a.length - 1;
		while (cur <= blue)
		{
			if (a[cur] == 1)
			{
				++cur;
			}
			else if (a[cur] == 0)
			{
				int temp = a[cur];
				a[cur] = a[red];
				a[red++] = temp;
				cur += a[cur] == 0 ? 1 : 0;
			}
			else
			{
				int temp = a[cur];
				a[cur] = a[blue];
				a[blue--] = temp;
			}
		}
	}
}
