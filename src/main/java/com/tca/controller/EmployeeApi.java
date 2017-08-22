package com.tca.controller;

import com.tca.entity.Employee;
import com.tca.entity.GeneralLicensee;
import com.tca.entity.Member;
import com.tca.service.EmployeeService;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Fan
 * @version 1.0
 */
@RestController
public class EmployeeApi {
	
	private static final Logger logger = Logger.getLogger(EmployeeApi.class);
	
	public EmployeeApi() {
		System.out.println("EmployeeApi()");
	}

    @Autowired
    private EmployeeService employeeService;
	
    @RequestMapping(method = RequestMethod.GET, value="/employees/{id}", headers = {"Accept=text/xml, application/json"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Employee getEmployee(@PathVariable("id") int empId) {
		logger.info("Start getEmployee. ID=" + empId);		
		return employeeService.getEmployee(empId);
	}

	@RequestMapping(value="/employees/", method = RequestMethod.GET, headers = {"Accept=text/xml, application/json"}, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Employee>>  getAllEmployees() {
		logger.info("Start getAllEmployees.");
		List<Employee> ret=employeeService.getAllEmployees();
		logger.info(ret.toString());
		return new ResponseEntity<List<Employee>>(ret, HttpStatus.OK);
	}
 
}