package com.tecsup.SpringMVC.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.tecsup.SpringMVC.model.Employee;
import com.tecsup.SpringMVC.services.EmployeeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/admin/menu")
	public String menu() {

		return "/admin/menu";
	}
	

	@GetMapping("/admin/emp/list")
	public String list(@ModelAttribute("SpringWeb") Employee employee, ModelMap model) {

		try {
			model.addAttribute("employees", employeeService.findAll());
		} catch (Exception e) {
			logger.info(e.getMessage());
			model.addAttribute("message", e.getMessage());
		}

		return "admin/emp/list";
	}

	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping("/{employee_id}")
	public ModelAndView home(@PathVariable int employee_id, ModelMap model) {

		ModelAndView modelAndView = null;
		Employee emp = new Employee();
		try {
			emp = employeeService.find(employee_id);
			logger.info(emp.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		modelAndView = new ModelAndView("home", "command", emp);

		return modelAndView;
	}
	
}

