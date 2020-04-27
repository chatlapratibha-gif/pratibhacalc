package com.example.chargebackcalcdemo.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.chargebackcalcdemo.models.CusLogin;
import com.example.chargebackcalcdemo.models.Customer;
import com.example.chargebackcalcdemo.services.CusServices;



@Controller
public class CustomerController {

	@Autowired
	private CusServices cusservices;
	@GetMapping(value="/cus")
	 public String customer(Model model) {
		 model.addAttribute("cus",new Customer());
		 return "CusReg";
	 }
	
	
	@PostMapping(value="/cusreg")
	public String cusreg(@ModelAttribute("cus") Customer cust,BindingResult result,Model model) {
		if(result.hasErrors())
		{
			return "CusReg";
		}
		
		else {
			
			model.addAttribute("cust",new CusLogin());
		
		int res = cusservices.createCus(cust);
		if(res==0)
		{
			model.addAttribute("message", cust.getFirstName().concat(cust.getLastName()).toUpperCase()+" You are already registered");
			return "CusReg";
		
		}
		else if(res==1)
		{
			model.addAttribute("message", cust.getFirstName().concat(cust.getLastName()).toUpperCase()+"Congrats your registration is successfull");
			return "CusReg";
		
		}
		else
		{
			model.addAttribute("message", "Some thing went wrong");
			return "failure";
		}
		
		}
		
	}
	@GetMapping(value="/cuslogin")
	public String cuslogin(Model model) {
		model.addAttribute("cuslogin", new CusLogin());
		return "CusLogin";
	}
	
	@PostMapping(value="/clogin")
	public String loginverify(@ModelAttribute("cuslogin") CusLogin cuslogin,BindingResult result,Model model,HttpSession session) {
		
		 {
	
		if(result.hasErrors())
		{
			return "CusLogin";
		}
		else {
		int status = cusservices.login(cuslogin);
		
		if(status==1)
		{
			String message="you are not registered";
			model.addAttribute("message",message);
			return "failure";
	    }		
		else if(status==2)
		{
			String message="You are Not yet activated Please wait for admin confirmation";	
			model.addAttribute("message", message);
			return "failure";
			}
		
		else if(status==3)
		{
			session.setAttribute("name",cuslogin.getCusId());
			return "CusHome";
		}
		else
		{
			model.addAttribute("message","Invalid Username OR password");
			return "EmpLogin";
		}
		
		
	}
		 }
	}
		 
		
		
	/*
	 * if(result.hasErrors()) { return "CusLogin"; } else { int status =
	 * cusservices.login(cuslogin);
	 * 
	 * if(status==1) { model.addAttribute("message","you are not registered");
	 * return "failure"; } else if(status==2) {
	 * session.setAttribute("name",cuslogin.getCusId()); return "CusHome"; } else {
	 * model.addAttribute("message","Invalid Username OR password"); return
	 * "failure"; }
	 * 
	 * }
	 * 
	 * }
	 */
	@GetMapping(value="/cuslogout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	
	
	


}
