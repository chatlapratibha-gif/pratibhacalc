/*package com.example.chargebackcalcdemo.controllers;

import java.util.Date;


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

import com.example.chargebackcalcdemo.models.CusLogin;
import com.example.chargebackcalcdemo.models.Customer;
import com.example.chargebackcalcdemo.models.LodgeComplaint;
import com.example.chargebackcalcdemo.models.Transactions;
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
	/*
	 @PostMapping(value="/clogin")
	public String loginverify(@ModelAttribute("cuslogin") CusLogin cuslogin,BindingResult result,Model model,HttpSession session) {
		if(result.hasErrors())
		{
			return "CusLogin";
		}
			else {
				int status = cusservices.login(cuslogin);
				
				if(status==1)
				{
					model.addAttribute("message","you are not registered");
					return "failure";
			    }
				else if(status==2)
				{
					Customer c = cusservices.getCustomer(cuslogin.getCusId());
					session.setAttribute("name",cuslogin.getCusId());
					session.setAttribute("customerid",c.getCutomerId());
					return "CusHome";
				}
				else
				{
					model.addAttribute("message","Invalid Username OR password");
					return "failure";
				}
				
				}

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
			Customer c = cusservices.getCustomer(cuslogin.getCusId());
			session.setAttribute("name",cuslogin.getCusId());
			session.setAttribute("customerid",c.getCustomerId());
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
	 
	@GetMapping(value="/cuslogout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	@GetMapping(value="/LodgeComplaint")
	public String lodgeComplaint(Model model,HttpSession session,@RequestParam("transactionid") int tid)
	{
		
		 long customerid = (long) session.getAttribute("customerid");
			Customer c = cusservices.findByCutomerId(customerid);

		List<Transactions> translist=c.getTransacList();
		
		Transactions tx =null;
		for(Transactions t :translist)
		{
			if(t.getId() == tid)
			{
				tx = t;
			}
		}
		
		Date dt =new Date();
		
		Date td = tx.getDateoftrans(); 
		int diff =(int)(( dt.getTime() - td.getTime())/(1000*60*60*24));
		
		if(diff<=15)
		{
			LodgeComplaint lc = new LodgeComplaint();
			model.addAttribute("lc", lc);
			
			return "LodgeComplaintHome";
		}
		else
		{
			model.addAttribute("complaint message", "Not Elogible for Lodge Complaint");
			return "CusHome";
			
		}
		
		  }
	@GetMapping(value="/translist")
	public String transactionList(Model model,HttpSession session)
	{
		long customerid = (long) session.getAttribute("customerId");
		Customer c = cusservices.findByCutomerId(customerid);
		List<Transactions> translist=c.getTransacList();
		
		
		 * List<Transactions> modifiedList = new ArrayList<Transactions>();
		 * 
		 * Date d = new Date();
		 * 
		 * 
		 * 
		 * translist.forEach(t->{
		 * 
		 * Date td = t.getTransactiondate(); int diff =(int)(( d.getTime() -
		 * td.getTime())/(1000*60*60*24));
		 * 
		 * if(diff<=15) { modifiedList.add(t); }
		 * 
		 * });
		 * 
		 * 
		 	
		model.addAttribute("custtransactionlist", translist);
		return 	"CusHome";
	
	}
	


}
*/
package com.example.chargebackcalcdemo.controllers;

import java.util.Date;
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

import com.example.chargebackcalcdemo.models.CusLogin;
import com.example.chargebackcalcdemo.models.Customer;
import com.example.chargebackcalcdemo.models.LodgeComplaint;
import com.example.chargebackcalcdemo.models.Transactions;
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
	
	@GetMapping("/cusreg1")
	public String cusreg1(Model model)
	{
		Customer c=new Customer();
		
		model.addAttribute("cus",c);
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
		if(result.hasErrors())
		{
			return "CusLogin";
		}
			else {
				int status = cusservices.login(cuslogin);
				
				if(status==1)
				{
					model.addAttribute("message","You are not registered");
					return "CusLogin";
			    }
				else if(status==3)
				{
					Customer c = cusservices.getCustomer(cuslogin.getCusId());
					session.setAttribute("name",cuslogin.getCusId());
					session.setAttribute("customerid",c.getCustomerId());
					//return "CusHome";
					//session.setAttribute("name",cuslogin.getCusId());
					return "CusHome";
				}
				else
				{
					model.addAttribute("message","Invalid Username OR password");
					return "failure";
				}
				
				}

	}
	/*
	 * @GetMapping("/cuslodgecomplaint") public String cuslcompl(Model model) {
	 * LodgeComplaint l=new LodgeComplaint(); model.addAttribute("lc",l); return
	 * "LodgeComplaint"; }
	 */
	@GetMapping(value="/LodgeComplaint1")
	public String lodgeComplaint(Model model,HttpSession session,@RequestParam("transactionid") long tid)
	{
		
		 long customerid = (long) session.getAttribute("customerid");
			Customer c = cusservices.findByCutomerId(customerid);

		List<Transactions> translist=c.getTransacList();
		
		Transactions tx =null;
		for(Transactions t :translist)
		{
			if(t.getId() == tid)
			{
				tx = t;
			}
		}
		
		
		Date dt =new Date();
		
		Date td = tx.getDateoftrans(); 
		int diff =(int)(( dt.getTime() - td.getTime())/(1000*60*60*24));
		
		if(diff<=15)
		{
			LodgeComplaint lc = new LodgeComplaint();
			model.addAttribute("lc", lc);
			
			return "LodgeComplaintHome";
		}
		else
		{
			model.addAttribute("complaintmessage", "Transactions made in the last 15 days are only eligible to lodge a complaint");
			return "CusHome";
			
		}
		
		  }

	@PostMapping(value="/LodgeComplaint")
	public String cuslodgecompl(@ModelAttribute("lc") LodgeComplaint lcompl,BindingResult result,Model model)
	{
		if(result.hasErrors()) {
			return "LodgeComplaintHome";
		}
		else
		{
			model.addAttribute("lc",new LodgeComplaint());
			int res=cusservices.createlodge(lcompl);
			if(res==0)
			{
				model.addAttribute("message", lcompl.getFirstname().concat(lcompl.getLastname()).toUpperCase()+" You are already raised a complaint");
				return "LodgeComplaintHome";
			
			}else if(res==1)
			{
				model.addAttribute("message",lcompl.getFirstname().concat(lcompl.getLastname().toUpperCase()+"you have raised a complaint successfully"));
				return "LodgeComplaintHome";
			}
			else {
				model.addAttribute("message","something went wrong");
				return "failure";
			}
		}
	}
	
	

	
	@GetMapping(value="/translist")
	public String transactionList(Model model,HttpSession session)
	{
		long customerid = (long) session.getAttribute("customerid");
		Customer c = cusservices.findByCutomerId(customerid);
		List<Transactions> translist=c.getTransacList();
		
		/*
		 * List<Transactions> modifiedList = new ArrayList<Transactions>();
		 * 
		 * Date d = new Date();
		 * 
		 * 
		 * 
		 * translist.forEach(t->{
		 * 
		 * Date td = t.getTransactiondate(); int diff =(int)(( d.getTime() -
		 * td.getTime())/(1000*60*60*24));
		 * 
		 * if(diff<=15) { modifiedList.add(t); }
		 * 
		 * });
		 * 
		 * 
		 */	
		model.addAttribute("custtransactionlist", translist);
		return 	"CusHome";
	
	}
	
	
	
	
	

	@GetMapping(value="/cuslogout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	
	
	


}

