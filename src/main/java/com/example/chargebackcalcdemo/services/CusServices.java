package com.example.chargebackcalcdemo.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.chargebackcalcdemo.models.CusLogin;
import com.example.chargebackcalcdemo.models.Customer;
import com.example.chargebackcalcdemo.models.LodgeComplaint;
import com.example.chargebackcalcdemo.models.Transactions;

public interface CusServices {
	public int createCus(Customer customer);
	public int login(CusLogin cuslogin);
	public List<Customer> cusList();
	List<Transactions> transactionlist();
	//public Customer findByCutomerId(long cutomerId); 
	@Query("select c from Customer c where c.cutomerId like :customerid")
	public List<Customer> searchById(@Param("customerid")long cutomerId);
	
	public Customer findByCutomerId(long cutomerId);
	
	public Customer getCustomer(String userId);
	public int createlodge(LodgeComplaint c);
	
}
