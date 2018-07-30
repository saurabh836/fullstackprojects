package com.niit.controller;

import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.ModelAndView; 
import com.niit.dao.Emp;
import com.niit.dao.EmpDao;

@Controller
public class EmpController {
	
	@Autowired
	EmpDao dao;
	
	@RequestMapping("/empform")
	
	public ModelAndView showform()
	{
		return new ModelAndView("empform","command",new Emp());
	}
	
	@RequestMapping("/viewemp")  
    public ModelAndView viewemp(){  
        List<Emp> list=dao.getEmployees();  
        return new ModelAndView("viewemp","list",list);  
    }  
	
	
	@RequestMapping(value="/editemp/{eid}")  
    public ModelAndView edit(@PathVariable int eid){  
        Emp emp=dao.getEmpById(eid);  
        return new ModelAndView("empeditform","command",emp);  
    }  

	 @RequestMapping(value="/editsave",method = RequestMethod.POST)  
	    public ModelAndView editsave(@ModelAttribute("emp") Emp emp){  
	        dao.update(emp);  
	        return new ModelAndView("redirect:/viewemp");  
	    }
	 
	 @RequestMapping(value="/deleteemp/{eid}",method = RequestMethod.GET)  
	    public ModelAndView delete(@PathVariable int eid){  
	        dao.delete(eid);  
	        return new ModelAndView("redirect:/viewemp");  
	    }  
	 
	 
}
