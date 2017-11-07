package leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zhangsw on 2017/11/7.
 */
public class IntersectionOfTwoArrays
{
	class Solution
	{
		//自己的版本
		public int[] intersection(int[] a, int[] b)
		{
			Set<Integer> result = new HashSet<>();
			Set<Integer> setA = new HashSet<>();
			int[] res;
			int count = 0;
			for (int temp : a)
			{
				setA.add(temp);
			}
			for (int temp : b)
			{
				if (setA.contains(temp))
				{
					result.add(temp);
				}
			}
			res = new int[result.size()];
			for (Integer temp : result)
			{
				res[count++] = temp;
			}
			return res;
		}

		//改进版
		/*
		public int[] intersection(int[] nums1, int[] nums2)
		{
			HashSet<Integer> set = new HashSet<Integer>();
			ArrayList<Integer> res = new ArrayList<Integer>();
			//Add all elements to set from array 1
			for (int i = 0; i < nums1.length; i++)
			{
				set.add(nums1[i]);
			}
			for (int j = 0; j < nums2.length; j++)
			{
				// If present in array 2 then add to res and remove from set
				if (set.contains(nums2[j]))
				{
					res.add(nums2[j]);
					set.remove(nums2[j]);
				}
			}
			// Convert ArrayList to array
			int[] arr = new int[res.size()];
			for (int i = 0; i < res.size(); i++)
			{
				arr[i] = res.get(i);
			}
			return arr;
		}
		*/
	}
}
