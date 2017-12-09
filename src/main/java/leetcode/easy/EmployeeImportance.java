package leetcode.easy;

import java.util.List;

/**
 * Created by zhangsw on 2017/12/9.
 */
public class EmployeeImportance
{
	// Employee info
	class Employee
	{
		// It's the unique id of each node;
		// unique id of this employee
		public int id;
		// the importance value of this employee
		public int importance;
		// the id of direct subordinates
		public List<Integer> subordinates;
	}

	class Solution
	{
		public int getImportance(List<Employee> list, int id)
		{
			Employee employee = null;
			for (Employee e : list)
			{
				if (e.id == id)
				{
					employee = e;
					break;
				}
			}
			if (employee == null)
			{
				return 0;
			}
			int sum = employee.importance;
			for (Integer i : employee.subordinates)
			{
				sum += getImportance(list, i);
			}
			return sum;
		}
	}
}
