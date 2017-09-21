/**
 * Created by zhangsw on 2017/9/21.
 */
public class SearchInsertPosition
{
	class Solution
	{
		//由于数组有序，用二分查找来定位元素
		public int searchInsert(int[] a, int target)
		{
			int left = 0, right = a.length - 1, mid = (left + right) >> 1;
			while (left < right)
			{
				if (a[mid] < target)
				{
					left = mid + 1;
				}
				else
				{
					right = mid;
				}
				mid = (left + right) >> 1;
			}
			return (a[mid] < target) ? mid + 1 : mid;
		}
	}
}
