package com.example.chargebackcalcdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.chargebackcalcdemo.dao.CusDao;
import com.example.chargebackcalcdemo.models.CusLogin;
import com.example.chargebackcalcdemo.models.Customer;
@Service
@Component
public class CusServicesImpl implements CusServices {
    @Autowired
    private CusDao dao;
    	@Override
	public int createCus(Customer customer) {
		Customer c=dao.findBycusId(customer.getCusId());
		if(c==null) {
			Customer c1=dao.save(customer);
			if (c1 != null) {
				return 1;
			} else {
				return 2;
			}
		}
		return 0;
	}
	@Override
	public int login(CusLogin cuslogin) {
		Customer c=dao.findBycusId(cuslogin.getCusId());
		
		 if(c==null)
		 {
		 	return 1;
		 }else if(c.getStatus().equals("no"))
		 {
		 	return 2;
		 }
		 else if(c.getPassword().equals(cuslogin.getPassword()) && c.getStatus().equals("yes"))
		 {
		 	return 3;
		 }
		 else
		 {
		 return 4;
		 }

	}
	@Override
	public List<Customer> cusList() {
		return dao.findAll();

	}
}
		 
		 