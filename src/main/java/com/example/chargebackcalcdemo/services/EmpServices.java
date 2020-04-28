package com.example.chargebackcalcdemo.services;

import java.util.List;
import java.util.Set;

import com.example.chargebackcalcdemo.models.Customer;
import com.example.chargebackcalcdemo.models.EmpLogin;
import com.example.chargebackcalcdemo.models.Employee;
import com.example.chargebackcalcdemo.models.LodgeComplaint;
import com.example.chargebackcalcdemo.models.Transactions;


public interface EmpServices {
	public int CreateEmp(Employee emp);
	public int login(EmpLogin emplogin);
	public List<Transactions>  transactionList();
	 public Customer serchBycustomerId(long customerId); 
	 public LodgeComplaint searchwithCustomerId(long customerId);
	 
	 public Set<Long> getCustIds();
	 public Set<Long> getCustomerIds();
	}
