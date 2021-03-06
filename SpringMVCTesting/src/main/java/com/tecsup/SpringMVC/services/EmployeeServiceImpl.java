package com.tecsup.SpringMVC.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.SpringMVC.dao.EmployeeDAO;
import com.tecsup.SpringMVC.exception.DAOException;
import com.tecsup.SpringMVC.exception.EmptyResultException;
import com.tecsup.SpringMVC.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public Employee find(int employee_id) throws DAOException, EmptyResultException {
		
		Employee emp = employeeDAO.findEmployee(employee_id);

		return emp;
	}
	
	@Override
	public List<Employee> findAll()
			throws DAOException, EmptyResultException {
		
		List<Employee> emps = employeeDAO.findAllEmployees();
	
		return emps;
	}


}
