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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Fan
 * @version 1.0
 */
@Controller
public class EmployeeController {
	
	private static final Logger logger = Logger.getLogger(EmployeeController.class);
	
	public EmployeeController() {
		System.out.println("EmployeeController()");
	}

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employee/add")
    public ModelAndView createEmployee(@ModelAttribute Employee employee) {
    	logger.info("Creating Employee. Data: "+employee);
        return new ModelAndView("employeeForm");
    }
    
    @RequestMapping("/employee/edit")
    public ModelAndView editEmployee(@RequestParam long id, @ModelAttribute Employee employee) {
    	logger.info("Updating the Employee for the Id "+id);
        employee = employeeService.getEmployee(id);
        return new ModelAndView("employeeForm", "employeeObject", employee);
    }
    
    @RequestMapping("/employee/save")
    public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
    	logger.info("Saving the Employee. Data : "+employee);
        if(employee.getId() == 0){ // if employee id is 0 then creating the employee other updating the employee
            employeeService.createEmployee(employee);
        } else {
            employeeService.updateEmployee(employee);
        }
        
        return new ModelAndView("redirect:/employee/list");
    }
    
    @RequestMapping("/employee/delete")
    public ModelAndView deleteEmployee(@RequestParam long id) {
    	logger.info("Deleting the Employee. Id : "+id);
        employeeService.deleteEmployee(id);
        return new ModelAndView("redirect:/employee/list");
    }
    
    @RequestMapping(value = {"/employee/list"})
    public ModelAndView getAllEmployees() {
    	logger.info("Getting the all Employees.");
        List<Employee> employeeList = employeeService.getAllEmployees();
        return new ModelAndView("employeeList", "employeeList", employeeList);
    }

    @RequestMapping(value = {"/","/main"}, method = RequestMethod.GET)
    public String getMainMenu(Model model) {
    	logger.info("Getting the main menu.");
            	
    	
    	GeneralLicensee generalLicensee= new GeneralLicensee();
    	generalLicensee.setName("york");
    	generalLicensee.setCity("toronto");
    	generalLicensee.setAddress("lognaberry");
    	generalLicensee.setPostCode("M2H3H1");
    	generalLicensee.setRowsperpage(100);
    	model.addAttribute("generalLicensee", generalLicensee);
    	
		Member member = new Member();
		List<String> preCheckedVals = new ArrayList<String>();
		preCheckedVals.add("Yoga");
		preCheckedVals.add("Aerobic");
		member.setCourses(preCheckedVals);
		member.setNewMember(true);
		model.addAttribute("member", member);
		
		List<String> courses = new ArrayList<String>();
		courses.add("Yoga");
		courses.add("Stretching");
		courses.add("Pilates");
		courses.add("Aerobic");
		courses.add("Oriental");
		model.addAttribute("courses", courses);
		
		List<Integer> rowsperpageList= new ArrayList<Integer>();
		rowsperpageList.add(10);
		rowsperpageList.add(20);
		rowsperpageList.add(50);
		rowsperpageList.add(100);
		rowsperpageList.add(200);
		
		model.addAttribute("rowsperpageList", rowsperpageList);
		
     	//model.addAttribute("country", country);
        return "mainmenu";
    }   
    
    @RequestMapping("/employee/search")
    public ModelAndView searchEmployee(@RequestParam("searchName") String searchName) {  
    	logger.info("Searching the Employee. Employee Names: "+searchName);
    	List<Employee> employeeList = employeeService.getAllEmployees(searchName);
        return new ModelAndView("employeeList", "employeeList", employeeList);    	
    }
}