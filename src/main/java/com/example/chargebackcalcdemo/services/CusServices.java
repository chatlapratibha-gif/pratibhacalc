package com.example.chargebackcalcdemo.services;

import java.util.List;

import com.example.chargebackcalcdemo.models.CusLogin;
import com.example.chargebackcalcdemo.models.Customer;

public interface CusServices {
	public int createCus(Customer customer);
	public int login(CusLogin cuslogin);
	public List<Customer> cusList();
	
}
