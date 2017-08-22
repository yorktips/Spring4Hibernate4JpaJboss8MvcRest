package com.tca.controller;
import com.tca.entity.GeneralLicensee;
import com.tca.service.GeneralLicenseeService;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Fan
 * @version 1.0
 */
@Controller
public class GeneralLicenseeController {
	
	@Autowired 
	Environment env;
	
	private static String rowsPerpageList;

	@Value("${database.url}")
	private static String defaultRowsPerpage;
	
	private static final Logger logger = Logger.getLogger(GeneralLicenseeController.class);
	
	public GeneralLicenseeController() {
		System.out.println("GeneralLicenseeController()");
	}

    @Autowired
    private GeneralLicenseeService generalLicenseeService;

    @RequestMapping("/generallicensee/add")
    public ModelAndView createGeneralLicensee(@ModelAttribute GeneralLicensee generalLicensee) {
    	logger.info("Creating GeneralLicensee. Data: " + generalLicensee);
        return new ModelAndView("generalLicenseeForm");
    }
    
    @RequestMapping("/generallicensee/edit")
    public ModelAndView editGeneralLicensee(@RequestParam long id, @ModelAttribute GeneralLicensee generalLicensee) {
    	logger.info("Updating the GeneralLicensee for the Id "+id);
        generalLicensee = generalLicenseeService.getGeneralLicensee(id);
        return new ModelAndView("generalLicenseeForm", "generalLicenseeObject", generalLicensee);
    }
    
//	@RequestMapping(value = "/generallicensee/save", method ={ RequestMethod.POST})
//	public String saveGeneralLicensee(@ModelAttribute GeneralLicensee generalLicensee,BindingResult result, 
//			Model model) {
//		    	if (result.hasErrors()) {
//		    		return new ModelAndView("generalLicenseeForm", "generalLicensee",); 
//		    	}
//			}
			
    @RequestMapping(value = "/generallicensee/save", method ={ RequestMethod.POST})
    //public ModelAndView saveGeneralLicensee(@ModelAttribute GeneralLicensee generalLicensee,BindingResult result) {
    public ModelAndView saveGeneralLicensee(@Valid @ModelAttribute("generalLicensee") GeneralLicensee  generalLicensee, BindingResult result) {
    	System.out.println("888XX4: ");
    	logger.info("2222Saving the GeneralLicensee. Data 222: "+generalLicensee);
    	if (result.hasErrors()) {
    		return new ModelAndView("generalLicenseeForm", "generalLicensee", generalLicensee);
    	}
        if(generalLicensee.getId() == 0){ // if generalLicensee id is 0 then creating the generalLicensee other updating the generalLicensee
            generalLicenseeService.createGeneralLicensee(generalLicensee);
        } else {
            generalLicenseeService.updateGeneralLicensee(generalLicensee);
        }
        return new ModelAndView("redirect:/generallicensee/list/1/");
    }
    
    @RequestMapping("/generallicensee/delete")
    public ModelAndView deleteGeneralLicensee(@RequestParam long id) {
    	logger.info("Deleting the GeneralLicensee. Id : "+id);
        generalLicenseeService.deleteGeneralLicensee(id);
        return new ModelAndView("redirect:getAllGeneralLicensees");
    }
  
    
	@RequestMapping(value = "/generallicensee/list/{pageNumber}/", method ={ RequestMethod.GET,RequestMethod.POST})
	public String getAllGeneralLicensees(@PathVariable Integer pageNumber,
			@ModelAttribute("generalLicensee") GeneralLicensee generalLicensee, 
			Model model) {

		logger.info("getAllGeneralLicensees 01.rowsPerpageList=" + rowsPerpageList + ";defaultRowsPerpage=" + defaultRowsPerpage);

		
		rowsPerpageList=env.getProperty("rows.perpage.list");
		defaultRowsPerpage=env.getProperty("default.rows.perpage");
		
		logger.info("getAllGeneralLicensees 32.rowsPerpageList=" + rowsPerpageList + ";defaultRowsPerpage=" + defaultRowsPerpage);

		if (defaultRowsPerpage==null || defaultRowsPerpage.isEmpty())
			defaultRowsPerpage="10";
		if (rowsPerpageList==null || rowsPerpageList.isEmpty()) 
			rowsPerpageList="10,20,50,100,200";

		String rowsperpage=String.valueOf(generalLicensee.getRowsperpage());
		String name=generalLicensee.getName();
		String city=generalLicensee.getCity();
		String address=generalLicensee.getAddress();
		String postCode=generalLicensee.getPostCode();
		
		logger.info("Paging all GeneralLicensees.rowsperpage=" + rowsperpage + ";name=" + name + ";city=" + city+ ";address=" + address+ ";postCode=" + postCode);
		logger.info("path=" + env.getProperty("path"));
		if (pageNumber<1) pageNumber=1;
		if (rowsperpage==null || rowsperpage.isEmpty()
				|| rowsperpage.equalsIgnoreCase("null")|| rowsperpage.equalsIgnoreCase("0")) rowsperpage=defaultRowsPerpage;
		System.out.println("Paging.name2=" + name + ";pageNumber=" + pageNumber + ";rowsperpage=" + rowsperpage);
		
		String sortColumn="id";

		Page<GeneralLicensee> page = generalLicenseeService.getGeneralLicenseePage(pageNumber-1, Integer.parseInt(rowsperpage),sortColumn,
				name, city,address,postCode);
	
        int current = page.getNumber()+1 ;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

		model.addAttribute("generalLicenseePage", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);

		model.addAttribute("generalLicensee",generalLicensee);

		String[] rowsperpageList=rowsPerpageList.split(",");
		logger.debug(rowsperpageList);
		
		model.addAttribute("rowsperpageList", rowsperpageList);
		
		System.out.println("current=" + current + ";begin=" + begin + ";end=" + end + ";getTotalPages=" + page.getTotalPages() );
		return "generalLicenseeList";
	}
 
//	@RequestMapping(value = "/generallicensee/list/{pageNumber}/", method ={ RequestMethod.GET,RequestMethod.POST})
//	public String getAllGeneralLicensees(@PathVariable Integer pageNumber, 
//    		@RequestParam(value="name", required=false,defaultValue = "") String name,
//    		@RequestParam(value="address", required=false,defaultValue = "") String address,
//    		@RequestParam(value="city", required=false,defaultValue = "") String city,
//    		@RequestParam(value="postCode", required=false,defaultValue = "") String postCode,  
//    		@RequestParam(value="rowsperpage", required=false,defaultValue = "10" ) String rowsperpage,
//			Model model) {
//		
//		if (defaultRowsPerpage==null || defaultRowsPerpage.isEmpty())
//			defaultRowsPerpage="10";
//		if (rowsPerpageList==null || rowsPerpageList.isEmpty()) 
//			rowsPerpageList="10,20,50,100,200";
//		
//		System.out.println("Paging all GeneralLicensees.pageNumber=" + pageNumber + ";rowsperpage=" + rowsperpage);
//		logger.info("Paging all GeneralLicensees.");
//
//		if (pageNumber<1) pageNumber=1;
//		if (rowsperpage==null || rowsperpage.isEmpty()) rowsperpage=defaultRowsPerpage;
//		
//		String sortColumn="id";
//
//		Page<GeneralLicensee> page = generalLicenseeService.getGeneralLicenseePage(pageNumber-1, Integer.parseInt(rowsperpage),sortColumn,
//				name, city,address,postCode);
//	
//        int current = page.getNumber()+1 ;
//        int begin = Math.max(1, current - 5);
//        int end = Math.min(begin + 10, page.getTotalPages());
//
//		model.addAttribute("generalLicenseePage", page);
//		model.addAttribute("beginIndex", begin);
//		model.addAttribute("endIndex", end);
//		model.addAttribute("currentIndex", current);
//
//		model.addAttribute("name", name);
//		model.addAttribute("city", city);
//		model.addAttribute("address", address);
//		model.addAttribute("postCode", postCode);
//		model.addAttribute("rowsperpage", Integer.parseInt(rowsperpage));
//		
//		String[] rowsperpageList=rowsPerpageList.split(",");
//		logger.debug(rowsperpageList);
//		
//		model.addAttribute("rowsperpageList", rowsperpageList);
//		
//		System.out.println("current=" + current + ";begin=" + begin + ";end=" + end + ";getTotalPages=" + page.getTotalPages() );
//		return "generalLicenseeList";
//	}
}