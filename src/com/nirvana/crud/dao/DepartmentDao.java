package com.nirvana.crud.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.nirvana.crud.entity.Department;

@Repository
public class DepartmentDao {
	private static List<Department> departments = new ArrayList<Department>();
	
	static {
		departments.add(new Department(1, "研发部"));
		departments.add(new Department(2, "销售部"));
		departments.add(new Department(3, "售后部"));
	}
	
	public List<Department> list() {
		return departments;
	}
	
}
