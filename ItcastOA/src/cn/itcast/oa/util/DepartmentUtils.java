package cn.itcast.oa.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cn.itcast.oa.domain.Department;

public class DepartmentUtils {

	public static List<Department> getAllDepartmentList(
			List<Department> topList, Department removedDepartment) {
		List<Department> list = new ArrayList<Department>();
		walkTree(topList, "┣", list, removedDepartment);
		return list;
	}

	private static void walkTree(Collection<Department> topList, String prefix,
			List<Department> list, Department removedDepartment) {
		// 去掉指定的部门分支
		for (Department top : topList) {
			if (removedDepartment != null
					&& top.getId().equals(removedDepartment.getId())) {
				continue;
			}
			Department copy = new Department();
			copy.setId(top.getId());
			copy.setName(prefix + top.getName());
			list.add(copy);
			walkTree(top.getChildren(),"　" + prefix, list, removedDepartment );
		}
	}
}
