package com.example.chargebackcalcdemo.services;

import java.util.List;


import com.example.chargebackcalcdemo.models.Customer;
import com.example.chargebackcalcdemo.models.EmpLogin;
import com.example.chargebackcalcdemo.models.Employee;
import com.example.chargebackcalcdemo.models.Transactions;


public interface EmpServices {
	public int CreateEmp(Employee emp);
	public int login(EmpLogin emplogin);
	public List<Customer>  cusList();
	/* public List<Customer> serchBycustomerId(String customerId); */
	}
