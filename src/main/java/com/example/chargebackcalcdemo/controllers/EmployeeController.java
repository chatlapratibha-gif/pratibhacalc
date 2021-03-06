package com.example.chargebackcalcdemo.controllers;

import java.util.List;


import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.chargebackcalcdemo.dao.EmpDao;
import com.example.chargebackcalcdemo.models.Admin;
import com.example.chargebackcalcdemo.models.CusLogin;
import com.example.chargebackcalcdemo.models.Customer;
import com.example.chargebackcalcdemo.models.EmpLogin;
import com.example.chargebackcalcdemo.models.Employee;
import com.example.chargebackcalcdemo.models.LodgeComplaint;
import com.example.chargebackcalcdemo.models.Transactions;
import com.example.chargebackcalcdemo.services.EmpServices;


@Controller
public class EmployeeController {
	@Autowired
	private EmpServices empservices;
	
	
	@GetMapping(value="/emp")
	public String employee(Model model)
	{ 
		model.addAttribute("emp" ,new Employee());
		return "Empreg";	
	}
	@PostMapping(value="/empr")
   public String empreg(@ModelAttribute("emp") Employee epreg,BindingResult result,Model model)
   {
		if(result.hasErrors())
		{
			return "Empreg";
		}
		
		else {
			
			model.addAttribute("epreg",new EmpLogin());
		
		int res = empservices.CreateEmp(epreg);
		if(res==0)
		{
			model.addAttribute("message", epreg.getFirstName().concat(epreg.getLastName()).toUpperCase()+" You are already registered");
			return "Empreg";
		
		}
		else if(res==1)
		{
			model.addAttribute("message", epreg.getFirstName().concat(epreg.getLastName()).toUpperCase()+"Congrats your registration is successfull");
			return "Empreg";
		
		}
		else
		{
			model.addAttribute("message", "Some thing went wrong");
			return "failure";
		}
     }
   }	
	@GetMapping(value="/emplogin")
	public String empLogin(Model model)
	{
		model.addAttribute("emplogin",new EmpLogin());
		return "EmpLogin";
	}
	
	@PostMapping(value="/login")
	public String loginverify(@ModelAttribute("emplogin") EmpLogin emplogin,BindingResult result,Model model,HttpSession session)
	{
		if(result.hasErrors())
		{
			return "EmpLogin";
		}
			else {
				int status = empservices.login(emplogin);
				
				if(status==1)
				{
					model.addAttribute("message","you are not registered");
					return "failure";
			    }
				else if(status==2)
				{
					
					
					session.setAttribute("name",emplogin.getEmpId());
					
					model.addAttribute("CustIDs",empservices.getCustIds());
					model.addAttribute("customerIds",empservices.getCustomerIds());
					return "EmpHome";
				}
				else
				{
					model.addAttribute("message","Invalid Username OR password");
					return "failure";
				}
				
				}

	} 
	
	/*
	 * @ModelAttribute("customerIdSet") public Set<Long> getCustomerIds() { Set<Long
	 * > customerSet = empservices.getCustIds();
	 * 
	 * return customerSet;
	 * 
	 * }
	 */
	
	
	  @PostMapping("/searchcustomers") 
	/* @ModelAttribute("searchCustomer") */
	  public String searchUser(@RequestParam("searchbycustomerId") long customerId,HttpSession
	  session,Model model) 
	  { 
       Customer customers= empservices.serchBycustomerId(customerId); //System.out.println(users)
	  model.addAttribute("searchCustomer", customers); 
	  return "EmpHome"; 
	  }
	@GetMapping("/Transactions")
	public String getAllTransactions(Model model,HttpSession session)
	{
		List<Transactions> cusList=empservices.transactionList();
		model.addAttribute("translist", cusList);
		return "EmpHome";
	}
	@GetMapping(value="/emplogout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	@GetMapping(value="/getCustDetails")
	public String getCustDetails(@RequestParam("cust") long customerid ,Model model)
	{
		Customer customer=empservices.serchBycustomerId(customerid);
		model.addAttribute("customer",customer);
		return "EmpHome";
		
	}
	@GetMapping(value="/getChargeCustDetails")
	public String getCustappliedchargeback(@RequestParam("cust1") long customerid1 ,Model model)
	{
		LodgeComplaint lcomlint=empservices.searchwithCustomerId(customerid1);
		model.addAttribute("customercharge",lcomlint);
		return "EmpHome";
		
	}
}
	/*
	 String username  =(String) session.getAttribute("username");
		User user = userBo.getUserByUserName(username);
		List<AddressBook> addressbook = addressbookdao.getAddressByUser(user);
		
		
		boolean status =addressbook.stream()
				.anyMatch(t-> t.getUser().getUsername().equals(username)&&t.getContactUsername().equals(friendusername));
		
		if(status)
		{
			model.addAttribute("message", "You have already sent request to Friend");
			  return "userhome";
		}
		else
		{
			 AddressBook ab = new AddressBook(); 
			 ab.setContactUsername(friendusername);
			 ab.setDateCreated(new Date()); ab.setStatus("pending"); 
			 ab.setUser(user);
			addressbookdao.save(ab);
			  
			  model.addAttribute("message", "Request has sent request to Friend"); 
			  return "userhome"; 
		}
	 */

	

	

