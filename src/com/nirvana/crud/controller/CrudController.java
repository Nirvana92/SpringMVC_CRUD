package com.nirvana.crud.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nirvana.crud.dao.DepartmentDao;
import com.nirvana.crud.dao.EmployeeDao;
import com.nirvana.crud.entity.Employee;

//rest style crud
@Controller
public class CrudController {

	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private DepartmentDao departmentDao;

	@RequestMapping("/emps")
	public String list(Map<String, Object> rvalue) {
		rvalue.put("employees", employeeDao.list());
		return "list";
	}

	@RequestMapping(value = "/emp", method = RequestMethod.GET)
	public String add(Map<String, Object> rvalue) {
		Map<String, String> genders = new HashMap<String, String>();
		genders.put("0", "FEMALE");
		genders.put("1", "MALE");
		rvalue.put("genders", genders);
		rvalue.put("departments", departmentDao.list());
		rvalue.put("employee", new Employee());
		return "add";
	}

	@RequestMapping(value = "/emp", method = RequestMethod.POST)
	public String save(Employee employee) {
		employeeDao.save(employee);
		return "redirect:/emps";
	}

	@RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id) {
		employeeDao.delete(id);
		return "redirect:/emps";
	}

	@RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
	public String modify(@PathVariable("id") Integer id,
			Map<String, Object> rvalue) {
		Map<String, String> genders = new HashMap<String, String>();
		genders.put("0", "FEMALE");
		genders.put("1", "MALE");
		rvalue.put("genders", genders);
		rvalue.put("departments", departmentDao.list());
		rvalue.put("employee", employeeDao.getEmployeeById(id));
		return "add";
	}

	@RequestMapping(value="/emp", method=RequestMethod.PUT) 
	public String update(Employee employee) {
		System.out.println(employee);
		return "redirect:/emps";
	}
	
	@ModelAttribute
	public void fillForm(
			@RequestParam(value = "id", required = false) Integer id,  
			Map<String, Object> rvalue) {
		
		if (id != null) {
			System.out.println("fillForm: "+employeeDao.getEmployeeById(id));
			rvalue.put("employee", employeeDao.getEmployeeById(id));
		}
	}
	
}
