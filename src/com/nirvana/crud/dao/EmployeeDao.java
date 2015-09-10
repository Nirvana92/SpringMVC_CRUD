package com.nirvana.crud.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nirvana.crud.entity.Department;
import com.nirvana.crud.entity.Employee;

@Repository
public class EmployeeDao {
	private static List<Employee> employees = new ArrayList<Employee>();
	@Autowired
	private DepartmentDao departmentDao;
	static {
		employees.add(new Employee(1, "NIRVANA", "nirvana@163.com", 1, new Department(1, "研发部")));
		employees.add(new Employee(2, "MING", "ming@163.com", 0, new Department(1, "研发部")));
		employees.add(new Employee(3, "GUI", "gui@163.com", 1, new Department(2, "销售部")));
		employees.add(new Employee(4, "FACE", "face@163.com", 0, new Department(2, "销售部")));
		employees.add(new Employee(5, "JING", "jing@163.com", 1, new Department(3, "售后部")));
		employees.add(new Employee(6, "LEI", "lei@163.com", 0, new Department(3, "售后部")));
	}
	
	public void save(Employee employee) {
		List<Department> departments = departmentDao.list();
		employee.setId(employees.size()+1);
		for(int i=0; i<departments.size(); i++) {
			if(employee.getDepartment().equals(departments.get(i))) {
				System.out.println(departments.get(i));
				employee.setDepartment(departments.get(i));
			}
		}
		
		employees.add(employee);
	}
	
	public Employee getEmployeeById(int id) {
		for(Employee e : employees) {
			if(e.getId() == id) {
				return e;
			}else {
				continue;
			}
		}
		
		return null;
	}
	
	public void delete(int id) {
		for(int i=0; i<employees.size(); i++) {
			if(employees.get(i).getId()==id) {
				employees.remove(employees.get(i));
			}
		}
	}
	
	public List<Employee> list() {
		return employees;
	}
	
	public Employee getTopEmployee() {
		return employees.get(0);
	}
}
