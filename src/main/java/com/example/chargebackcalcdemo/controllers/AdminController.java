package com.example.chargebackcalcdemo.controllers;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.chargebackcalcdemo.models.Admin;
import com.example.chargebackcalcdemo.models.AdminLogin;
import com.example.chargebackcalcdemo.models.Customer;
import com.example.chargebackcalcdemo.services.AdminServices;
import com.example.chargebackcalcdemo.services.CusServices;


@Controller
public class AdminController {
	@Autowired
	private AdminServices adminservices;
	@Autowired
	private CusServices cusservices;
	@GetMapping(value="/admin")
	 public String admin(Model model) {
		 model.addAttribute("admin",new Admin());
		 return "AdminRegistration";
	 }
	
	
	@PostMapping(value="/adminreg")
	public String adminreg(@ModelAttribute("admin") Admin ad,BindingResult result,Model model) {
		if(result.hasErrors())
		{
			return "AdminRegistration";
		}
		
		else {
			
			model.addAttribute("ad",new AdminLogin());
		
		int res = adminservices.CreateAd(ad);
		if(res==0)
		{
			model.addAttribute("message", ad.getFirstName().concat(ad.getLastName()).toUpperCase()+" You are already registered");
			return "AdminRegistration";
		
		}
		else if(res==1)
		{
			model.addAttribute("message", ad.getFirstName().concat(ad.getLastName()).toUpperCase()+"Congrats your registration is successfull");
			return "AdminRegistration";
		
		}
		else
		{
			model.addAttribute("message", "Some thing went wrong");
			return "failure";
		}
		
		}
	
	}
	@GetMapping(value="/adminlogin")
	public String adminlogin(Model model) {
		model.addAttribute("adminlogin", new AdminLogin());
		return "AdminLogin";
	}
	
	@PostMapping(value="/loginverify")
	public String loginverify(@ModelAttribute("adminlogin") AdminLogin adminlogin,BindingResult result,Model model,HttpSession session) {
		if(result.hasErrors())
		{
			return "AdminLogin";
		}
		else {
			int status = adminservices.login(adminlogin);
			
			if(status==1)
			{
				model.addAttribute("message","you are not registered");
				return "failure";
		    }
			else if(status==2)
			{
				session.setAttribute("name",adminlogin.getAdminId());
				return "adminhome";
			}
			else
			{
				model.addAttribute("message","Invalid Username OR password");
				return "failure";
			}
			
			}
	
	}
	@GetMapping("/acceptuserregisteration")
	public String showUsers(Model m)
	{
		List<Customer> cusList=cusservices.cusList();
		m.addAttribute("cusList", cusList);
		return "adminhome";
	}
	@GetMapping("activate")
	public String activate(@RequestParam("id")String custId) {
		boolean b1=adminservices.activate(custId);
		if(b1)
		{
			return "adminhome";
		}
		return "failure";
	}
	@GetMapping("deactivate")
	public String deactivate(@RequestParam("id")String username) {
		boolean b1=adminservices.deactivate(username);
		if(b1)
		{
			return "adminhome";
		}
		return "failure";
	}
	@GetMapping(value="/adminlogout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	

	
	
	

}
