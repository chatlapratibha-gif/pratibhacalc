package com.example.chargebackcalcdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.chargebackcalcdemo.dao.CusDao;
import com.example.chargebackcalcdemo.dao.Lodgecomplaintdao;
import com.example.chargebackcalcdemo.dao.TransacDao;
import com.example.chargebackcalcdemo.models.CusLogin;
import com.example.chargebackcalcdemo.models.Customer;
import com.example.chargebackcalcdemo.models.Employee;
import com.example.chargebackcalcdemo.models.LodgeComplaint;
import com.example.chargebackcalcdemo.models.Transactions;
@Service
@Component
public class CusServicesImpl implements CusServices {
    @Autowired
    private CusDao dao;
    @Autowired
    private Lodgecomplaintdao ldao;
    @Autowired
    private TransacDao transdao;
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
	@Override
	public List<Transactions> transactionlist() {
		
		
	List<Transactions> tl=(List<Transactions>)transdao.findAll();
	return tl;   
	
	}

	/*
	 * @Override
	 * 
	 * public Customer findByCutomerId(Customer customer) {
	 * 
	 * 
	 * Customer c = dao.findByCutomerId(customer.getTransactionslist());
	 * 
	 * return c;
	 * 
	 * 
	 * }
	 */
	
	
	@Override
	public List<Customer> searchById(long cutomerId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Customer findByCutomerId(long cutomerId) {
		// TODO Auto-generated method stub
		return dao.findByCustomerId(cutomerId);
	}
	@Override
	public Customer getCustomer(String userId) {
		// TODO Auto-generated method stub
		return dao.findBycusId(userId);
	}
	@Override
	public int createlodge(LodgeComplaint c) {
		
		LodgeComplaint lc=ldao.findBycustomerid(c.getCustomerid());
		if(lc==null)
		{
			LodgeComplaint l1=ldao.save(c);
			if(l1!=null) {
				return 1;
			}
			else {
				return 2;
			}
			
		}
		
		return 0;
	}
}
		 
		 