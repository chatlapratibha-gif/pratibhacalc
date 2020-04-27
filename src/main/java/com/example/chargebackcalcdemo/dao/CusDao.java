package com.example.chargebackcalcdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.chargebackcalcdemo.models.Customer;


public interface CusDao extends CrudRepository<Customer,String>{
	public Customer findBycusId(String cusId);
	public List<Customer>  findAll();
	/*
	 * @Query("select c from customer c where c.customerId like :customer") public
	 * List<Customer> searchcustomerId(@Param("customer")String customerId);
	 */

}
